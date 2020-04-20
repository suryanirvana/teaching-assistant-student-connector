package group2.TASC.core;

import group2.TASC.model.Schedule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class TeachingAssistantTest {

    private static User ta = new TeachingAssistant("Jane", "janey", "password");
    String taName = "Jane";
    String taUsername = "janey";
    String taPassword = "password";

    private static User student = new Student("Joe", "averagejoe", "password");

    private static Date date = new Date();
    private static Schedule schedule = new Schedule();

    @BeforeEach
    void setUpSchedule() {
        schedule.setDate(date);
        schedule.setScheduleName("name");
        schedule.setDuration(2);
    }

    @Test
    void nameTest() {
        ta.setName(taName);
        assertEquals(ta.getName(), taName);
    }

    @Test
    void usernameTest() {
        ta.setUserName(taUsername);
        assertEquals(ta.getUserName(), taUsername);
    }

    @Test
    void passwordLengthTest() {
        ta.setPassWord(taPassword);
        assertTrue(ta.getPassWord().length() >= 8);
    }

    @Test
    void passwordTest() {
        ta.setPassWord(taPassword);
        assertEquals(ta.getPassWord(), taPassword);
    }


    @Test
    void sendMessageTest() {
        ((TeachingAssistant) ta).sendRejectionMessage((Student) student, "test", "test");
        int temp = ((TeachingAssistant) ta).getMessages().size();
        assertEquals(temp, 1);
    }

    @Test
    void testSetReminder() {
        Reminder reminder = new Reminder(date, "test", 2);
        ((TeachingAssistant) ta).setReminder(reminder);
        int temp = ((TeachingAssistant) ta).getReminder().size();
        assertEquals(temp, 1);
    }

    @Test
    void testGetReminder() {
        Reminder new_reminder = new Reminder(date,"test", 2);
        ((TeachingAssistant) ta).getReminder().add(new_reminder);
        assertTrue(((TeachingAssistant) ta).getReminder().contains(new_reminder));
    }

    @Test
    void testGetCourse() {
        Course new_course = new Course(schedule, "test", "test");
        ((TeachingAssistant) ta).getCourse().add(new_course);
        assertTrue(((TeachingAssistant) ta).getCourse().contains(new_course));
    }

    @Test
    void testSetCourse() {
        Course new_course = new Course(schedule, "test", "test");
        ((TeachingAssistant) ta).setCourse(new_course);
        int temp = ((TeachingAssistant) ta).getCourse().size();
        assertEquals(temp, 1);
    }

    @Test
    void testGetRole() {
        assertEquals(((TeachingAssistant) ta).getRole(), "Teaching Assistant");
    }
}
