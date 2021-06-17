package pl.cansoft.java_zadanie_domowe.controllers.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.cansoft.java_zadanie_domowe.models.Teacher;
import pl.cansoft.java_zadanie_domowe.services.teacher.TeacherService;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/teacher")
public class TeacherRestController {

    final TeacherService teacherService;

    @GetMapping
    public List<Teacher> getTeachers() {
        return teacherService.getTeachers();
    }

    @GetMapping("{id}")
    public Teacher getTeacher(@PathVariable Long id) {
        return teacherService.getTeacher(id);
    }

    @PostMapping
    public Teacher createTeacher(@Valid @RequestBody Teacher teacher) {
        return teacherService.createTeacher(teacher);
    }

    @PutMapping("{id}")
    public Teacher updateTeacher(@Valid @RequestBody Teacher newTeacher, @PathVariable Long id) {
        return teacherService.updateTeacher(id, newTeacher);
    }

    @DeleteMapping("{id}")
    public Teacher deleteTeacher(@PathVariable Long id) {
        return teacherService.deleteTeacher(id);
    }
}
