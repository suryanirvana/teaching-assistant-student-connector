package group2.TASC.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="course")
public class Course {

    @Id
    @NotNull
    @NotBlank
    @Column(name = "course_code")
    private String courseCode;

    @NotNull
    @NotBlank(message = "Please enter the course name")
    @Column(name = "course_name")
    private String courseName;

    @Column(name = "ta_id")
    private String taId;

    @Column(name = "ta_name")
    private String taName;

    public List<String> getTAList() {
        if(this.taId.length() > 0) {
            return Arrays.asList(this.taId.split(","));
        }
        return new ArrayList<>();
    }
}
