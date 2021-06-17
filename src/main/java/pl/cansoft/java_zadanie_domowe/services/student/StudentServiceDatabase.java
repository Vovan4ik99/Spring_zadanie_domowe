package pl.cansoft.java_zadanie_domowe.services.student;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.cansoft.java_zadanie_domowe.exceptions.StudentNotFoundException;
import pl.cansoft.java_zadanie_domowe.models.Student;
import pl.cansoft.java_zadanie_domowe.repositories.StudentRepository;
import pl.cansoft.java_zadanie_domowe.services.student.StudentService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Service
@Primary
public class StudentServiceDatabase implements StudentService {

    final StudentRepository studentRepository;

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
        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException()) ;
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

}
