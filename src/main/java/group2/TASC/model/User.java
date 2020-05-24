package group2.TASC.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;
    @NotNull
    private long studentId;
    @NotNull
    private String name;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String email;
    @NotNull
    private String role;
//    Map<String, Student> studentHashMap = new HashMap<>();
//    Map<String, TeachingAssistant> TAHashMap = new HashMap<>();

    public User(long userId, long studentId, String username, String password, String name, String email, String role) {
        this.setUserId(userId);
        this.setStudentId(studentId);
        this.setUsername(username);
        this.setPassword(password);
        this.setName(name);
        this.setEmail(email);
        this.setRole(role);
    }

}
