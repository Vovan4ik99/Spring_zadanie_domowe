package pl.cansoft.java_zadanie_domowe.controllers.mvc;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.cansoft.java_zadanie_domowe.services.teacher.TeacherService;

@Controller
@RequiredArgsConstructor
@RequestMapping("teachers")
public class TeacherConroller {

    final TeacherService teacherService;

    @GetMapping
    public String showTeachers(Model model) {
        model.addAttribute("teachers", teacherService.getTeachersSortByName());
        return "teachers";
    }
    @GetMapping("{teacherId}")
    public String showTeacherById(@PathVariable Long teacherId, Model model) {
        model.addAttribute("teacher", teacherService.getTeacher(teacherId));
        return "teacher";
    }
}
