package pl.cansoft.java_zadanie_domowe.controllers.rest;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import pl.cansoft.java_zadanie_domowe.models.Student;
import pl.cansoft.java_zadanie_domowe.services.student.StudentService;
import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/student")
@RequiredArgsConstructor
@RestController
public class StudentRestController {

    final StudentService studentService;


    @GetMapping("search")
    public Page<Student> getStudentsBySearchEngine(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "surname", required = false) String surname,
            @PageableDefault(size = 20) Pageable pageable
            ) {
        return studentService.getStudentsBySearchEngine(name, surname, pageable);
    }

    @GetMapping("teacher/{teacherId}")
    public Page<Student> getStudentsByTeacher(@PathVariable Long teacherId, Pageable pageable) {
        return studentService.getStudentsByTeacher(teacherId, pageable);
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("{id}")
    public Student getStudent(@PathVariable Long id) {
        return studentService.getStudent(id);
    }

    @PostMapping
    public Student createStudent(@Valid @RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping("{id}")
    public Student updateStudent(@PathVariable Long id, @Valid @RequestBody Student newStudent) {
        return studentService.updateStudent(id, newStudent);
    }

    @DeleteMapping("{id}")
    public Student deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id);
    }
}
