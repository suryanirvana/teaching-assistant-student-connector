package group2.TASC.core;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class AppointementTest {
    private static String studentName = "newStudent";
    private static String studentUserName = "StudentUserName";

    private static String TAName = "newTA";
    private static String TAUserName = "TAUSerName";

    private static String password = "123";

    private static Date date = new Date();
    private static String scheduleName = "schedule";
    private static int scheduleDuration = 2;


    private static TeachingAssistant ta = new TeachingAssistant(TAName, TAUserName, password);
    private static Student student = new Student(studentName, studentUserName, password);
    private static Schedule schedule = new Schedule(date, scheduleName, scheduleDuration);

    @Test
    void checkIfScheduleNameExist() {
        assertNotEquals(schedule.getScheduleName(), "");
    }

    @Test
    void checkIfScheduleNameEquals() {
        String temp = "schedule";
        schedule.setScheduleName(temp);
        assertEquals(schedule.getScheduleName(), temp);
    }

    @Test
    void checkIfScheduleDurationMoreThan0() {
        int temp = 2;
        schedule.setDuration(temp);
        assertTrue(schedule.getDuration()>0);
    }

    @Test
    void checkIfStudentNameExist() {
        assertNotEquals(student.getName(), "");
    }

    @Test
    void checkIfStudentUserNameExist() {
        assertNotEquals(student.getUserName(), "");
    }

    @Test
    void checkIfStudentNameEquals() {
        String temp = "newStudent";
        student.setName(temp);
        assertEquals(student.getName(), temp);
    }

    @Test
    void checkIfStudentUserNameEquals() {
        String temp = "StudentUserName";
        student.setUserName(temp);
        assertEquals(student.getUserName(), temp);
    }

    @Test
    void checkIfTANameExist() {
        assertNotEquals(ta.getName(), "");
    }

    @Test
    void checkIfTAUserNameExist() {
        assertNotEquals(ta.getUserName(), "");
    }

    @Test
    void checkIfTANameEquals() {
        String temp = "newTA";
        ta.setName(temp);
        assertEquals(ta.getName(), temp);
    }

    @Test
    void checkIfTAUserNameEquals() {
        String temp = "TAUserName";
        ta.setUserName(temp);
        assertEquals(ta.getUserName(), temp);
    }

}
