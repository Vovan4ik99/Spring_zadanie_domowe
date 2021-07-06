package pl.cansoft.java_zadanie_domowe.models;



import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
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
