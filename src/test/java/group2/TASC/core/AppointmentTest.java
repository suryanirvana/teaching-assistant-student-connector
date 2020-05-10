package group2.TASC.core;

import group2.TASC.model.Schedule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class AppointmentTest {
    private static String studentName = "newStudent";
    private static String studentUserName = "StudentUserName";

    private static String TAName = "newTA";
    private static String TAUserName = "TAUSerName";

    private static String password = "123";

    private static LocalDate date = LocalDate.of(2020, 05,10);
    private static String scheduleName = "schedule";
    private static int scheduleDuration = 2;


    private static TeachingAssistant ta = new TeachingAssistant(TAName, TAUserName, password);
    private static Student student = new Student(studentName, studentUserName, password);
    private static Schedule schedule = new Schedule();

    @BeforeEach
    void setUpSchedule() {
        schedule.setDate(date);
        schedule.setScheduleName(scheduleName);
        schedule.setDuration(scheduleDuration);
    }
}
