package group2.TASC.core;

import group2.TASC.model.Schedule;

import java.util.ArrayList;
import java.util.Date;

class TeachingAssistant implements User, CreateAppointment {
    private String name;
    private String userName;
    private String passWord;
    private String role;
    private Calendar TACalendar;
    private ArrayList<Reminder> TAReminder;
    private ArrayList<Course> TACourse;
    private ArrayList<Message> messages;
    private long preferedNoOfStudents;

    public TeachingAssistant(String name, String userName, String passWord) {
        this.name = name;
        this.userName = userName;
        this.passWord = passWord;
        this.role = "Teaching Assistant";
        this.TACalendar = new Calendar();
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

    @Override
    public void createAppointment(String name, Date date, int duration) {
        Appointment appointment = new Appointment(this.studentHashMap.get(name), this);
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

    public ArrayList<Reminder> getReminder() {
        return this.TAReminder;
    }

    public void sendRejectionMessage(Student student, String title, String content) {
        //TODO
        Message new_message = new Message(student, title, content);
        messages.add(new_message);
    }

    public void deleteSchedule(Schedule schedule) {
        TACalendar.getScheduleArrayList().remove(schedule);
    }

    public ArrayList<Course> getCourse() {
        return this.TACourse;
    }

    public void setCourse(Course course) {
        this.TACourse.add(course);
    }

    public void setPreferedNoOfStudents(long preferedNoOfStudents) {
        this.preferedNoOfStudents = preferedNoOfStudents;
    }

    public long getPreferedNoOfStudents() {
        return preferedNoOfStudents;
    }
}
