package group2.TASC.core;

import java.util.ArrayList;

class Student implements User {
    private String name;
    private String userName;
    private String passWord;
    private String role;
    private ArrayList<Schedule> studentSchedule;
    private ArrayList<Appointment> studentAppointments;
    private ArrayList<Reminder> studentReminder;

    public Student(String name, String userName, String passWord) {
        this.name = name;
        this.userName = userName;
        this.passWord = passWord;
        this.role = "Student";
        this.studentSchedule = new ArrayList<>();
        this.studentAppointments = new ArrayList<>();
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
        studentAppointments.add(new_appointment);
    }

    public void setReminder(Reminder reminder) {
        // TODO
        this.studentReminder.add(reminder);
    }

    public ArrayList<Appointment> getAppointments() {
        // TODO
        // do we need class appointment??
        return this.studentAppointments;
    }

    public ArrayList<Schedule> getSchedule() {
        // TODO
        return this.studentSchedule;
    }
}
