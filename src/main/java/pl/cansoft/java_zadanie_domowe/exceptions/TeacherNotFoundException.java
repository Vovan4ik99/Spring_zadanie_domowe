package pl.cansoft.java_zadanie_domowe.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
        (code = HttpStatus.NOT_FOUND,
         reason = "Nauczyciel nie odnalieziony!")
public class TeacherNotFoundException extends RuntimeException{
}
