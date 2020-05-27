package group2.TASC.model;

import group2.TASC.core.Student;
import group2.TASC.core.TeachingAssistant;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public abstract class User {
    private long studentId;
    private String name;
    private String username;
    private String password;
    private String role = "User";
    Map<String, Student> studentHashMap = new HashMap<>();
    Map<String, TeachingAssistant> TAHashMap = new HashMap<>();
}
