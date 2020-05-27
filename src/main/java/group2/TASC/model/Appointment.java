package group2.TASC.model;

import group2.TASC.core.Student;
import group2.TASC.core.TeachingAssistant;
import group2.TASC.model.Schedule;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
public class Appointment extends Schedule {

    @NotNull
    private String TA;

    private String student;

    private long maximumNumberOfStudent;
}
