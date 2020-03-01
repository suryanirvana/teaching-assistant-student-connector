package group2.TASC.core;

public class Appointment {
    private TeachingAssistant TA;
    private Student student;
    private Schedule schedule;

    public Appointment(Student student, TeachingAssistant TA, Schedule schedule) {
        this.student = student;
        this.TA = TA;
        this.schedule = schedule;
    }
}
