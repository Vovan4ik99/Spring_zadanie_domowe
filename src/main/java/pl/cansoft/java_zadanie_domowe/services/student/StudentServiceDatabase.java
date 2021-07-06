package pl.cansoft.java_zadanie_domowe.services.student;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.cansoft.java_zadanie_domowe.exceptions.StudentNotFoundException;
import pl.cansoft.java_zadanie_domowe.models.Student;
import pl.cansoft.java_zadanie_domowe.repositories.StudentRepository;
import pl.cansoft.java_zadanie_domowe.services.teacher.TeacherService;

import java.util.List;

@RequiredArgsConstructor
@Service
@Primary
public class StudentServiceDatabase implements StudentService {

    final StudentRepository studentRepository;
    final TeacherService teacherService;

    @Override
    public List<Student> getStudents( ) {
        return studentRepository.findAll();
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElseThrow(StudentNotFoundException::new) ;
    }

    @Override
    public Student deleteStudent(Long id) {
        var deleteStudent = getStudent(id);
        studentRepository.deleteById(id);
        return deleteStudent;
    }

    @Override
    public Student updateStudent(Long id, Student newStudent) {
        newStudent.setId(id);
        return studentRepository.save(newStudent);
    }
    public Page<Student> getStudentsSortByName() {
        return studentRepository.findAll(PageRequest.of(0, 20, Sort.by(Sort.Direction.ASC, "name")));
    }


    public Page<Student> getStudentsByTeacher(Long teacherId, Pageable pageable) {
        return studentRepository.getAllByTeacherId(teacherId, pageable);
    }


    public Page<Student> getStudentsBySearchEngine(String name, String surname, Pageable pageable) {
        if (name != null && surname !=null) {
            return studentRepository.getAllByNameAndSurname(name, surname, pageable);
        }
        if (name != null) {
            return studentRepository.getAllByName(name, pageable);
        }
        if (surname != null) {
            return studentRepository.getAllBySurname(surname, pageable);
        }
        return studentRepository.findAll(pageable);
    }

}
