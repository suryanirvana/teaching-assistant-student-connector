package group2.TASC.core;

import group2.TASC.model.Course;
import group2.TASC.model.Schedule;
import group2.TASC.model.User;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
public class TeachingAssistant extends User implements CreateAppointment {
    private Calendar TACalendar = new Calendar();


    private String name;
    private String userName;
    private String passWord;
    private String role;
    private ArrayList<Reminder> TAReminder;
    private ArrayList<Course> TACourse;
    private ArrayList<Message> messages;
    private long preferedNoOfStudents;

    public TeachingAssistant(String name, String userName, String passWord) {
        this.name = name;
        this.userName = userName;
        this.passWord = passWord;
        this.role = "Teaching Assistant";
        this.TAReminder = new ArrayList<>();
        this.TACourse = new ArrayList<>();
        this.messages = new ArrayList<>();
    }

    @Override
    public void createAppointment(String name, LocalDate date, int duration) {
        Appointment appointment = new Appointment(this.getStudentHashMap().get(name), this);
        appointment.setDate(date);
        appointment.setDuration(duration);
        appointment.setMaximumNumberOfStudent(this.getPreferedNoOfStudents());
        TACalendar.getScheduleArrayList().add(appointment);
    }

    public void addSchedule(Schedule schedule) {
        this.TACalendar.getScheduleArrayList().add(schedule);
    }

    public void setReminder(Reminder reminder) {
        // TODO
        this.TAReminder.add(reminder);
    }

    public void sendRejectionMessage(Student student, String title, String content) {
        //TODO
        Message new_message = new Message(student, title, content);
        messages.add(new_message);
    }

    public void deleteSchedule(Schedule schedule) {
        TACalendar.getScheduleArrayList().remove(schedule);
    }

    public void setCourse(Course course) {
        this.TACourse.add(course);
    }
}
