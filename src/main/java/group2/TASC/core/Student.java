package group2.TASC.core;

import group2.TASC.model.Schedule;
import group2.TASC.model.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
public class Student extends User implements CreateAppointment {
    private Calendar studentCalendar = new Calendar();


    private String name;
    private String username;
    private String password;
    private String role;
    private ArrayList<Reminder> studentReminder;

    public Student(String name, String userName, String passWord) {
        this.name = name;
        this.username = userName;
        this.password = passWord;
        this.role = "Student";
        this.studentReminder = new ArrayList<>();
//        this.getStudentHashMap().put(name, this);
    }

    @Override
    public void createAppointment(String name, LocalDate date, int duration) {
        // TODO
        Appointment appointment = new Appointment(this, this.getTAHashMap().get(name));
        appointment.setDate(date);
        appointment.setDuration(duration);
        studentCalendar.getScheduleArrayList().add(appointment);
    }

    public void setReminder(Reminder reminder) {
        // TODO
        this.studentReminder.add(reminder);
    }
    public void addSchedule(Schedule schedule) {
        this.studentCalendar.getScheduleArrayList().add(schedule);
    }

    public void deleteSchedule(Schedule schedule) {
        this.studentCalendar.getScheduleArrayList().remove(schedule);
    }
}
