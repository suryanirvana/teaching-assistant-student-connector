package group2.TASC.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@Table(name="student")
@Entity
public class Student{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student")
    private Long id;

    @NotNull
    @Column(name = "student_id")
    private String student_id;

    @NotNull
    @Column(name = "student_username")
    private String username;

    public Student() {}
}
