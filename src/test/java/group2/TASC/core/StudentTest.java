package group2.TASC.core;

import group2.TASC.model.Schedule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
    private static final Student student = new Student("Joe", "averagejoe", "password");
    String name = "Joe";
    String username = "averagejoe";
    String password = "password";
    private static TeachingAssistant ta = new TeachingAssistant("Jane", "janey", "password");

    private static LocalDate date = LocalDate.of(2020, 05,10);
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
    void testSetReminder() {
        Reminder reminder = new Reminder(date, "test", 2);
        student.setReminder(reminder);
        int temp = student.getStudentReminder().size();
        assertEquals(temp, 1);
    }

    @Test
    void testGetReminder() {
        Reminder new_reminder = new Reminder(date, "test", 2);
        student.getStudentReminder().add(new_reminder);
        assertTrue(student.getStudentReminder().contains(new_reminder));
    }

    @Test
    void testGetRole() {
        assertEquals(student.getRole(),"Student");
    }

    @Test
    void testAddDeleteScheduleAndAddAppointmentToStudentCalendar() {
        student.addSchedule(schedule);
        assertEquals(1, student.getStudentCalendar().getScheduleArrayList().size());
        student.deleteSchedule(schedule);
        assertEquals(0, student.getStudentCalendar().getScheduleArrayList().size());
        student.createAppointment("Jane", date, 2);
        assertEquals(1, student.getStudentCalendar().getScheduleArrayList().size());
    }
}
