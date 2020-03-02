package group2.TASC.core;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class TeachingAssistantTest {

    private static User ta = new TeachingAssistant("Jane", "janey", "password");
    String taName = "Jane";
    String taUsername = "janey";
    String taPassword = "password";

    private static User student = new Student("Joe", "averagejoe", "password");

    private static Date date = new Date();
    private static Schedule schedule = new Schedule(date, "name", 2);

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
    void createAppointmentTest() {
        ((TeachingAssistant) ta).createAppointment((Student) student, (TeachingAssistant) ta, schedule);
        int temp = ((TeachingAssistant) ta).getAppointments().size();
        assertEquals(temp, 1);
    }

    @Test
    void getAppointmentTest() {
        Appointment new_appointment = new Appointment((Student) student, (TeachingAssistant) ta, schedule);
        ((TeachingAssistant) ta).getAppointments().add(new_appointment);
        assertTrue(((TeachingAssistant) ta).getAppointments().contains(new_appointment));
    }

    @Test
    void sendMessageTest() {
        ((TeachingAssistant) ta).sendRejectionMessage((Student) student, "test", "test");
        int temp = ((TeachingAssistant) ta).getMessages().size();
        assertEquals(temp, 1);
    }

    @Test
    void testAddSchedule() {
        ((TeachingAssistant) ta).addSchedule(schedule);
        int temp = ((TeachingAssistant) ta).getSchedule().size();
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
        ArrayList<Reminder> temp = ((TeachingAssistant) ta).getReminder();
        assertEquals(temp, new ArrayList<>());
    }

    @Test
    void testDeleteSchedule() {
        ((TeachingAssistant) ta).addSchedule(schedule);
        ((TeachingAssistant) ta).deleteSchedule(schedule);
        int temp = ((TeachingAssistant) ta).getSchedule().size();
        assertEquals(temp, 0);
    }

    @Test
    void testGetCourse() {
        assertEquals(((TeachingAssistant) ta).getCourse(), new ArrayList<>());
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
