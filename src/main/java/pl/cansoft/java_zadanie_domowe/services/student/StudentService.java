package pl.cansoft.java_zadanie_domowe.services.student;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.cansoft.java_zadanie_domowe.models.Student;


import java.util.List;

public interface StudentService {

    List<Student> getStudents();

    Student createStudent(Student student);

    Student getStudent(Long id);

    Student deleteStudent(Long id);

    Student updateStudent(Long id, Student newStudent);

    Page<Student> getStudentsSortByName();

    Page<Student> getStudentsByTeacher(Long teacherId, Pageable pageable);

    Page<Student> getStudentsBySearchEngine(String name, String surname, Pageable pageable);
}
