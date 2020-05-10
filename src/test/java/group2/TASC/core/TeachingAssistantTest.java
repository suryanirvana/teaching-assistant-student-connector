package group2.TASC.core;

import group2.TASC.model.Course;
import group2.TASC.model.Schedule;
import group2.TASC.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class TeachingAssistantTest {

    private static User ta = new TeachingAssistant("Jane", "janey", "password");
    String taName = "Jane";
    String taUsername = "janey";
    String taPassword = "password";

    private static User student = new Student("Joe", "averagejoe", "password");

    private static LocalDate date = LocalDate.of(2020, 05,10);
    private static Schedule schedule = new Schedule();

    @BeforeEach
    void setUpSchedule() {
        schedule.setDate(date);
        schedule.setScheduleName("name");
        schedule.setDuration(2);
    }
}
