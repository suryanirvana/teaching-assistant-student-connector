package group2.TASC.core;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTests {
    private static User student = new Student("Joe", "averagejoe", "password");
    String name = "Joe";
    String username = "averagejoe";
    String password = "password";
    private static User ta = new TeachingAssistant("Jane", "janey", "password");

    private static Date date = new Date();
    private static Schedule schedule = new Schedule(date, "name", 2);

    @Test
    void nameTest() {
        student.setName(name);
        assertEquals(student.getName(), name);
    }

    @Test
    void usernameTest() {
        student.setUserName(username);
        assertEquals(student.getUserName(), username);
    }

    @Test
    void passwordLengthTest() {
        student.setPassWord(password);
        assertTrue(student.getPassWord().length() >= 8);
    }

    @Test
    void passwordTest() {
        student.setPassWord(password);
        assertEquals(student.getPassWord(), password);
    }

    @Test
    void createAppointmentTest() {
        ((Student) student).createAppointment((Student) student, (TeachingAssistant) ta, schedule);
        int temp = ((TeachingAssistant) ta).getAppointments().size();
        assertEquals(temp, 1);
    }

    @Test
    void testSetReminder() {
        Reminder reminder = new Reminder(date, "test", 2);
        ((Student) student).setReminder(reminder);
        int temp = ((Student) student).getStudentReminder().size();
        assertEquals(temp, 1);
    }

    @Test
    void testGetReminder() {
        ArrayList<Reminder> temp = ((Student) student).getStudentReminder();
        assertEquals(temp, new ArrayList<>());
    }
    @Test
    void testGetAppointments() {
        ArrayList<Appointment> temp = ((Student) student).getAppointments();
        assertEquals(temp, new ArrayList<>());
    }
    @Test
    void testGetSchedule() {
        ArrayList<Schedule> temp = ((Student) student).getSchedule();
        assertEquals(temp, new ArrayList<>());
    }

    @Test
    void testGetRole() {
        assertEquals(((Student) student).getRole(),"Student");
    }
}
