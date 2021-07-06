package pl.cansoft.java_zadanie_domowe.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.cansoft.java_zadanie_domowe.models.Teacher;



@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Page<Teacher> findAll(Pageable pageable);

    Page<Teacher> getAllByName(String name, Pageable pageable);

    Page<Teacher> getAllBySurname(String surname, Pageable pageable);

    Page<Teacher> getAllByNameAndSurname(String name, String surname, Pageable pageable);

    @Query("select t from  Teacher t join t.students s where s.id = :studentId")
    Page<Teacher> getAllByStudentId(@Param("studentId") Long studentId, Pageable pageable);
}
