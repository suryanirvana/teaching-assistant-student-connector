package group2.TASC.core;

public class Admin implements User {
    private String name;
    private String userName;
    private String passWord;
    private String role;

    public Admin(String name, String userName, String passWord) {
        super();
        this.userName = userName;
        this.passWord = passWord;
        this.role = "Admin";
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

    public void assignCourseTA(Course course, TeachingAssistant TA) {
        // TODO
        TA.getCourse().add(course);
    }
}
