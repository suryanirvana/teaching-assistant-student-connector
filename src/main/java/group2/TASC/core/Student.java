package group2.TASC.core;

import group2.TASC.model.Schedule;

import java.util.ArrayList;

class Student extends StudentCreateAppointment implements User {
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

    public void createAppointment(Student student, TeachingAssistant TA, Schedule schedule) {
        // TODO
        Appointment new_appointment = new Appointment(this, TA, schedule);
        studentCalendar.getAppointmentArrayList().add(new_appointment);
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
}
