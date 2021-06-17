package pl.cansoft.java_zadanie_domowe.controllers.mvc;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.cansoft.java_zadanie_domowe.services.student.StudentService;



@RequiredArgsConstructor
@Controller
@RequestMapping("students")
public class StudentController {

    final StudentService studentService;

    @GetMapping
    public String showStudents(Model model) {
        var students = studentService.getStudentsSortByName();
        model.addAttribute("students", students);
        return "students";
    }
    @GetMapping("{studentId}")
    public String showStudentById(@PathVariable Long studentId, Model model) {
        model.addAttribute("student", studentService.getStudent(studentId));
        return "student";
    }


}
