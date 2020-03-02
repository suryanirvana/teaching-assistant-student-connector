package group2.TASC.core;

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

}
