package group2.TASC.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class CourseTest {
    private static Date date = new Date();
    private static Schedule schedule = new Schedule(date, "Course: AP", 2);
    private static Course course = new Course(schedule, "Advanced Programming", "AP");

    @Test
    void checkIfScheduleNameExist() {
        assertNotEquals(schedule.getScheduleName(), "");
    }

    @Test
    void checkIfScheduleNameEquals() {
        String temp = "Course: AP";
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
    void checkIfScheduleExistInCourse() {
        Schedule schedule = new Schedule(date, "", 2);
        course.setCourseSchedule(schedule);
        assertEquals(course.getCourseSchedule(), schedule);
    }

    @Test
    void checkIfCourseNameExist() {
        assertNotEquals(course.getCourseName(), "");
    }

    @Test
    void checkIfCourseNameEquals() {
        String temp = "Advanced Programming";
        course.setCourseName(temp);
        assertEquals(course.getCourseName(), temp);
    }

    @Test
    void checkIfCourseCodeExist() {
        assertNotEquals(course.getCourseCode(), "");
    }

    @Test
    void checkIfCourseCodeEquals() {
        String temp = "AP";
        course.setCourseCode(temp);
        assertEquals(course.getCourseCode(), temp);
    }
}
