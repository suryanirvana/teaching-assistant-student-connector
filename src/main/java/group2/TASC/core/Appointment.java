package group2.TASC.core;

import group2.TASC.model.Schedule;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Appointment extends Schedule {
    private TeachingAssistant TA;
    private Student student;
    private long maximumNumberOfStudent;

    public Appointment(Student student, TeachingAssistant TA) {
        this.student = student;
        this.TA = TA;
    }
}
