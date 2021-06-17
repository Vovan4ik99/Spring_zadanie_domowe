package pl.cansoft.java_zadanie_domowe.models;



import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Teacher extends PersonDate {

    @NotBlank(message = "Nazwa przedmiotu jest wymagana!")
    private String object;


    @ManyToMany(mappedBy = "teachers")
    @JsonIgnore
    private List<Student> students;
}
