package group2.TASC.core;

import group2.TASC.model.Schedule;
import group2.TASC.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTests {
    private static User student = new Student("Joe", "averagejoe", "password");
    String name = "Joe";
    String username = "averagejoe";
    String password = "password";
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
    void whenSettingThePasswordItShouldBeMoreThan8Characters() {
        student.setPassword("passwordNew");
        assertTrue(student.getPassword().length()>8);
    }
}
