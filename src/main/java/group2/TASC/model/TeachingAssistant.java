package group2.TASC.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Table(name="teaching_assistant")
@Entity
public class TeachingAssistant{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ta")
    private Long id;

    @NotNull
    @Column(name = "student_id")
    private String student_id;

    @NotNull
    @Column(name = "ta_username")
    private String username;

    public TeachingAssistant() {}
}