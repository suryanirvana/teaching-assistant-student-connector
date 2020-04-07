package group2.TASC.core;

import group2.TASC.model.Schedule;
import org.junit.jupiter.api.BeforeEach;
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
    private static Schedule schedule = new Schedule();

    @BeforeEach
    void setUpSchedule() {
        schedule.setDate(date);
        schedule.setScheduleName("name");
        schedule.setDuration(2);
    }

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
        int temp = ((Student) student).getAppointments().size();
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
        Reminder new_reminder = new Reminder(date,"test", 2);
        ((Student) student).getStudentReminder().add(new_reminder);
        assertTrue(((Student) student).getStudentReminder().contains(new_reminder));
    }
    @Test
    void testGetAppointments() {
        Appointment new_appointment = new Appointment((Student) student, (TeachingAssistant) ta, schedule);
        ((Student) student).getAppointments().add(new_appointment);
        assertTrue(((Student) student).getAppointments().contains(new_appointment));
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
