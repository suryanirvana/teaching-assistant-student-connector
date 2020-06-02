package group2.TASC.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.*;

@Getter
@Setter
@Table(name="users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "student_id")
    private String student_id;

    @NotNull
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "username")
    private String username;

    @NotNull
    @Column(name = "password")
    private String password;

    @NotNull
    @Column(name="roles")
    private String roles = "";

    @Column(name="course_code")
    private String courseCode = "";

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Schedule> schedules;

    public List<String> getRoleList() {
        return Arrays.asList(this.roles.split(","));
    }

    public List<String> getCourseList() {
        if(this.courseCode.length() > 0) {
            return Arrays.asList(this.courseCode.split(","));
        }
        return new ArrayList<>();
    }
}
