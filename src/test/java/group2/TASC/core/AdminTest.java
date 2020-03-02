package group2.TASC.core;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class AdminTest {
    private static User admin = new Admin("Surya", "suryanirvana", "LaLiLuLeLo");
    private static User ta = new TeachingAssistant("Jane", "janey", "password");
    private static Date date = new Date();
    private static Schedule schedule = new Schedule(date, "name", 2);

    @Test
    void checkIfNameExist() {
        String temp = "Surya";
        admin.setName(temp);
        assertNotEquals(admin.getName(), "");
    }

    @Test
    void checkIfUsernameExist() {
        String temp = "suryanirvana";
        admin.setUserName(temp);
        assertNotEquals(admin.getUserName(), "");
    }

    @Test
    void checkIfPasswordMoreThan8Characters() {
        String temp = "LaLiLuLeLo";
        admin.setPassWord(temp);
        assertTrue(admin.getPassWord().length() >= 8);
    }

    @Test
    void checkIfNameEquals() {
        String temp = "Surya";
        admin.setName(temp);
        assertEquals(admin.getName(), temp);
    }

    @Test
    void checkIfUsernameEquals() {
        String temp = "suryanirvana";
        admin.setUserName(temp);
        assertEquals(admin.getUserName(), temp);
    }

    @Test
    void checkIfPasswordEquals() {
        String temp = "LaLiLuLeLo";
        admin.setPassWord(temp);
        assertEquals(admin.getPassWord(), temp);
    }

    @Test
    void testGetRole() {
        assertEquals(((Admin) admin).getRole(), "Admin");
    }

    @Test
    void testAssignCourse() {
        Course new_course = new Course(schedule, "test", "test");
        ((Admin) admin).assignCourseTA(new_course, (TeachingAssistant) ta);
        int temp = ((TeachingAssistant) ta).getCourse().size();
        assertEquals(temp, 1);
    }
}
