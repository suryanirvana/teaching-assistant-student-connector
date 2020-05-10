package group2.TASC.core;

import group2.TASC.model.Course;
import group2.TASC.model.Schedule;
import group2.TASC.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class AdminTest {
    private static User admin = new Admin("Surya", "suryanirvana", "LaLiLuLeLo");
    private static User ta = new TeachingAssistant("Jane", "janey", "password");
    private static LocalDate date = LocalDate.of(2020, 05,10);
    private static Schedule schedule = new Schedule();

    @BeforeEach
    void setUpSchedule() {
        schedule.setDate(date);
        schedule.setScheduleName("name");
        schedule.setDuration(2);
    }

    @Test
    void checkIfNameExist() {
        String temp = "Surya";
        admin.setName(temp);
        assertNotEquals(admin.getName(), "");
    }

    @Test
    void checkIfUsernameExist() {
        String temp = "suryanirvana";
        admin.setUsername(temp);
        assertNotEquals(admin.getUsername(), "");
    }

    @Test
    void checkIfPasswordMoreThan8Characters() {
        String temp = "LaLiLuLeLo";
        admin.setPassword(temp);
        assertTrue(admin.getPassword().length() >= 8);
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
        admin.setUsername(temp);
        assertEquals(admin.getUsername(), temp);
    }

    @Test
    void checkIfPasswordEquals() {
        String temp = "LaLiLuLeLo";
        admin.setPassword(temp);
        assertEquals(admin.getPassword(), temp);
    }

    @Test
    void testGetRole() {
        assertEquals(((Admin) admin).getRole(), "Admin");
    }

    @Test
    void testAssignCourse() {
        Course new_course = new Course();
        new_course.setCourseCode(213);
        new_course.setCourseName("test");
        ((Admin) admin).assignCourseTA(new_course, (TeachingAssistant) ta);
        int temp = ((TeachingAssistant) ta).getTACourse().size();
        assertEquals(temp, 1);
    }
}
