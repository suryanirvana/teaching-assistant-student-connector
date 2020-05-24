package group2.TASC.core;

import group2.TASC.model.Course;
import group2.TASC.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Admin {
    private String name;
    private String userName;
    private String passWord;
    private String role;

    public Admin(String name, String userName, String passWord) {
//        super();
        this.userName = userName;
        this.passWord = passWord;
        this.role = "Admin";
    }

    public void assignCourseTA(Course course, TeachingAssistant TA) {
        // TODO
        TA.getTACourse().add(course);
    }
}
