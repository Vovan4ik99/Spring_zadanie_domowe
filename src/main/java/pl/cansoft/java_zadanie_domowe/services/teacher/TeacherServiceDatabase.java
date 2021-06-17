package pl.cansoft.java_zadanie_domowe.services.teacher;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.cansoft.java_zadanie_domowe.exceptions.TeacherNotFoundException;
import pl.cansoft.java_zadanie_domowe.models.Student;
import pl.cansoft.java_zadanie_domowe.models.Teacher;
import pl.cansoft.java_zadanie_domowe.repositories.TeacherRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Primary
public class TeacherServiceDatabase implements TeacherService{

    final TeacherRepository teacherRepository;

    public List<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher getTeacher(Long id) {
        return teacherRepository.findById(id).orElseThrow(() -> new TeacherNotFoundException());
    }

    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher updateTeacher(Long id, Teacher newTeacher) {
        newTeacher.setId(id);
        return teacherRepository.save(newTeacher);
    }

    public Teacher deleteTeacher(Long id) {
        var deleteTeacher = getTeacher(id);
        teacherRepository.deleteById(id);
        return deleteTeacher;
    }
    public Page<Teacher> getTeachersSortByName() {
        return teacherRepository.findAll(PageRequest.of(0, 20, Sort.by(Sort.Direction.ASC, "name")));
    }
}
