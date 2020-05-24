package group2.TASC.model;

import group2.TASC.core.Appointment;
import group2.TASC.core.Calendar;
import group2.TASC.core.CreateAppointment;
import group2.TASC.core.Reminder;
import group2.TASC.model.Schedule;
import group2.TASC.model.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
@Entity
public class Student extends User  {
//    private Calendar studentCalendar = new Calendar();

//
    private long studentId;
    private long userId;
    private String name;
    private String username;
    private String password;
    private String email;
    private String role;

//    private ArrayList<Reminder> studentReminder;

//    public Student() {
//        super(userId, studentId, name, userName, password, email, role);
//    }

    public Student(long userId, long studentId, String name, String userName, String password, String email, String role) {
        super(userId, studentId, name, userName, password, email, role);
//        this.name = name;
//        this.username = userName;
//        this.password = password;
//        this.role = "Student";
//        this.studentReminder = new ArrayList<>();
//        this.getStudentHashMap().put(name, this);
    }

//    @Override
//    public void createAppointment(String name, LocalDate date, int duration) {
//        // TODO
//        Appointment appointment = new Appointment(this, this.getTAHashMap().get(name));
//        appointment.setDate(date);
//        appointment.setDuration(duration);
//        studentCalendar.getScheduleArrayList().add(appointment);
//    }
//
//    public void setReminder(Reminder reminder) {
//        // TODO
//        this.studentReminder.add(reminder);
//    }
//    public void addSchedule(Schedule schedule) {
//        this.studentCalendar.getScheduleArrayList().add(schedule);
//    }
//
//    public void deleteSchedule(Schedule schedule) {
//        this.studentCalendar.getScheduleArrayList().remove(schedule);
//    }
}
