package pl.cansoft.java_zadanie_domowe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.cansoft.java_zadanie_domowe.models.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
