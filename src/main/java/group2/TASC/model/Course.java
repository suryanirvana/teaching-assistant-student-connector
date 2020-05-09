package group2.TASC.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
public class Course {

    @Id
    private long courseCode;
    private String courseName;

}
