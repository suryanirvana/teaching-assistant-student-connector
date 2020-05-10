package group2.TASC.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
public class Course {

    @Id
    @NotNull
    private long courseCode;

    @NotNull
    private String courseName;
}
