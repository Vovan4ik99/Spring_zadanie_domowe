package pl.cansoft.java_zadanie_domowe.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.cansoft.java_zadanie_domowe.models.Student;
import pl.cansoft.java_zadanie_domowe.models.Teacher;


import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Page<Student> findAll(Pageable pageable);

    Page<Student> getAllByName(String name, Pageable pageable);

    Page<Student> getAllBySurname(String surname, Pageable pageable);

    Page<Student> getAllByNameAndSurname(String name, String surname, Pageable pageable);

    @Query("select s from  Student s join s.teachers t where t.id = :teacherId")
    Page<Student> getAllByTeacherId(@Param("teacherId") Long teacherId, Pageable pageable);
}
