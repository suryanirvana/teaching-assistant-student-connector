package group2.TASC.model;

import group2.TASC.model.Schedule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class CourseModelTest {
    private static LocalDate date = LocalDate.of(2020, 05,10);
    private static Course course = new Course();

    @BeforeEach
    void setUpSchedule() {
        course.setCourseCode(123);
        course.setCourseName("AP");
    }

}
