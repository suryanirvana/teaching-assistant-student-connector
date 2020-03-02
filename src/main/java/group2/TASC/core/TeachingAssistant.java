package group2.TASC.core;

import java.util.ArrayList;

class TeachingAssistant implements User {
    private String name;
    private String userName;
    private String passWord;
    private String role;
    private ArrayList<Schedule> TASchedule;
    private ArrayList<Appointment> TAAppointments;
    private ArrayList<Reminder> TAReminder;
    private ArrayList<Course> TACourse;

    private ArrayList<Message> messages;

    public TeachingAssistant(String name, String userName, String passWord) {
        this.name = name;
        this.userName = userName;
        this.passWord = passWord;
        this.role = "Teaching Assistant";
        this.TASchedule = new ArrayList<>();
        this.TAAppointments = new ArrayList<>();
        this.TAReminder = new ArrayList<>();
        this.TACourse = new ArrayList<>();
        this.messages = new ArrayList<>();
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

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public String getRole() {
        return role;
    }

    public void createAppointment(Student student, TeachingAssistant TA, Schedule schedule) {
        Appointment new_appointment = new Appointment(student, this, schedule);
        TAAppointments.add(new_appointment);
    }

    public void addSchedule(Schedule schedule) {
        TASchedule.add(schedule);
    }

    public void setReminder(Reminder reminder) {
        // TODO
        this.TAReminder.add(reminder);
    }

    public ArrayList<Appointment> getAppointments() {
        return this.TAAppointments;
    }

    public ArrayList<Reminder> getReminder() {
        return this.TAReminder;
    }

    public void sendRejectionMessage(Student student, String title, String content) {
        //TODO
        Message new_message = new Message(student, title, content);
        messages.add(new_message);
    }

    public void deleteSchedule(Schedule schedule) {
        TASchedule.remove(schedule);
    }

    public ArrayList<Schedule> getSchedule() {
        return this.TASchedule;
    }

    public ArrayList<Course> getCourse() {
        return this.TACourse;
    }

    public void setCourse(Course course) {
        this.TACourse.add(course);
    }
}
