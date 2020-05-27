package group2.TASC.core;

import group2.TASC.model.Course;
import group2.TASC.model.Schedule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TeachingAssistantTest {

    private static TeachingAssistant ta = new TeachingAssistant("Jane", "janey", "password");
    String taName = "Jane";
    String taUsername = "janey";
    String taPassword = "password";

    private static Student student = new Student("Joe", "averagejoe", "password");

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
        ta.setName(taName);
        assertEquals(ta.getName(), taName);
    }

    @Test
    void sendMessageTest() {
        ta.sendRejectionMessage( student, "test", "test");
        int temp = ta.getMessages().size();
        assertEquals(temp, 1);
    }

    @Test
    void testGetRole() {
        assertEquals(ta.getRole(), "Teaching Assistant");
    }

    @Test
    void testAddDeleteScheduleAndAddAppointmentToTACalendar() {
        ta.addSchedule(schedule);
        assertEquals(1, ta.getTACalendar().getScheduleArrayList().size());
        ta.deleteSchedule(schedule);
        assertEquals(0, ta.getTACalendar().getScheduleArrayList().size());
        ta.createAppointment("Joe", date, 2);
        assertEquals(1, ta.getTACalendar().getScheduleArrayList().size());
    }

    @Test
    void testSetCourseForTA() {
        Course course = new Course();
        course.setCourseCode(12345);
        course.setCourseName("AP");
        ta.setCourse(course);
        assertEquals(1, ta.getTACourse().size());
    }

    @Test
    void testSetReminderForTA() {
        Reminder reminder = new Reminder(date, "Test", 2);
        ta.setReminder(reminder);
        assertEquals(1, ta.getTAReminder().size());
    }
}
