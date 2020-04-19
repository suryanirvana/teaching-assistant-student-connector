package group2.TASC.core;

import group2.TASC.model.Schedule;

import java.util.ArrayList;
import java.util.Date;

class Student implements User, CreateAppointment {
    private String name;
    private String userName;
    private String passWord;
    private String role;
    private Calendar studentCalendar;
    private ArrayList<Reminder> studentReminder;

    public Student(String name, String userName, String passWord) {
        this.name = name;
        this.userName = userName;
        this.passWord = passWord;
        this.role = "Student";
        this.studentCalendar = new Calendar();
        this.studentReminder = new ArrayList<>();
        this.studentHashMap.put(name, this);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String getPassWord() {
        return passWord;
    }

    @Override
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getRole() {
        return role;
    }

    @Override
    public void createAppointment(String name, Date date, int duration) {
        // TODO
        Appointment appointment = new Appointment(this, this.TAHashMap.get(name));
        appointment.setDate(date);
        appointment.setDuration(duration);
        studentCalendar.getScheduleArrayList().add(appointment);
    }

    public ArrayList<Reminder> getStudentReminder() {
        return studentReminder;
    }

    public void setReminder(Reminder reminder) {
        // TODO
        this.studentReminder.add(reminder);
    }
    public void addSchedule(Schedule schedule) {
        this.studentCalendar.getScheduleArrayList().add(schedule);
    }

    public void deleteSchedule(Schedule schedule) {
        studentCalendar.getScheduleArrayList().remove(schedule);
    }
}
