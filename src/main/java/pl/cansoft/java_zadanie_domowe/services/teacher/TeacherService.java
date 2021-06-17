package pl.cansoft.java_zadanie_domowe.services.teacher;

import org.springframework.data.domain.Page;
import pl.cansoft.java_zadanie_domowe.models.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> getTeachers();

    Teacher getTeacher(Long id);

    Teacher createTeacher(Teacher teacher);

    Teacher updateTeacher(Long id, Teacher newTeacher);

    Teacher deleteTeacher(Long id);

    Page<Teacher> getTeachersSortByName();
}
