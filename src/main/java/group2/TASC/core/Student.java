package group2.TASC.core;

class Student implements User {
    private String name;
    private String userName;
    private String passWord;
    private Schedule schedule;
    private TeachingAssistant TA;

    public Student(String name, String userName, String passWord, Schedule schedule) {
        this.name = name;
        this.userName = userName;
        this.passWord = passWord;
        this.schedule = schedule;
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

    public void createAppointment(TeachingAssistant TA, Schedule schedule) {
        // TODO
    }

    public void setReminder(Reminder reminder) {
        // TODO
    }

    public void getAppointments() {
        // TODO
        // do we need class appointment??
    }

    public Schedule getSchedule() {
        // TODO
        return this.schedule;
    }
}
