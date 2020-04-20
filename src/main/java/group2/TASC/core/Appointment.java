package group2.TASC.core;

import group2.TASC.model.Schedule;

public class Appointment extends Schedule {
    private TeachingAssistant TA;
    private Student student;
    private long maximumNumberOfStudent;

    public Appointment(Student student, TeachingAssistant TA) {
        this.student = student;
        this.TA = TA;
    }

    public TeachingAssistant getTA() {
        return TA;
    }

    public void setTA(TeachingAssistant TA) {
        this.TA = TA;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public long getMaximumNumberOfStudent() {
        return maximumNumberOfStudent;
    }

    public void setMaximumNumberOfStudent(long maximumNumberOfStudent) {
        this.maximumNumberOfStudent = maximumNumberOfStudent;
    }
}
