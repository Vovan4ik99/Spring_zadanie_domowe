package pl.cansoft.java_zadanie_domowe.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Student extends PersonDate {

    @NotBlank(message = "Nazwa kierunku jest wymagana!")
    private String kierunek;


    @ManyToMany
    private List<Teacher> teachers;

}
