package pl.cansoft.java_zadanie_domowe.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@MappedSuperclass
public abstract class PersonDate {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Pattern(regexp = "^[A-Z][a-z]+(-[A-Z][a-z]+)?$", message = "Imię musi składać się wyłącznie z liter!")
    @Size(min = 2, max = 100, message = "Imię musi mieć od 2 do 100 znaków!")
    @NotBlank(message = "Nazwa jest wymagane!")
    private String name;

    @Pattern(regexp = "^[A-Z][a-z]+( ?-?[A-Z][a-z]+)?$", message = "Nazwisko musi składać się wyłącznie z liter (w przypadku podwójnego jest dozwolona spacja!")
    @Size(min = 2, max = 100, message = "Nazwisko musi mieć od 2 do 100 znaków!")
    @NotBlank(message = "Nazwisko jest wymagane!")
    private String surname;

    @Min(value= 18, message = "Wiek musi być więcej 18 lat")
    @NotNull(message = "Wiek jest wymagany!")
    private int age;

    @Email(message = "Email jest niepoprawny!")
    @NotBlank(message = "Email jest wymagany!")
    private String email;
}
