package group2.TASC.service;

import group2.TASC.model.Course;
import group2.TASC.model.Schedule;
import group2.TASC.repository.CourseRepo;
import group2.TASC.repository.ScheduleRepo;
import group2.TASC.service.ScheduleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CourseServiceTest {

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private CourseService courseService;

    private Course course;

    @BeforeEach
    void setUpSchedule() {
        course = new Course();
        course.setCourseName("Adpro");
        course.setCourseCode(123);
        courseService.addCourse(course);
    }

    @Test
    void testGetCourseByIdNotFound() {
        try {
            courseService.getCourseById(123);
        } catch (EntityNotFoundException ex) {
            assertNull(ex.getMessage());
        }
    }

    @Test
    void getCourseList() {
        assertEquals(courseRepo.findAllByOrderByCourseCodeAsc().get(0).getCourseCode(),
                courseService.getAllCourse().get(0).getCourseCode());
    }

    @Test
    void testGetCourseByIdAndScheduleExist() {
        try {
            assertEquals(course.getCourseCode(), courseService.getCourseById(123).getCourseCode());
        } catch (EntityNotFoundException e) {
            assertNull(e.getMessage());
        }
    }

    @Test
    void testRemoveCourseById() {
        courseRepo.delete(course);
    }

    @Test
    void testUpdateCourseIdButScheduleDoesntExist() {
        course.setCourseCode((long) 0);
        try {
            courseService.updateCourse(course);
        } catch (EntityNotFoundException e) {
            assertNull(e.getMessage());
        }
    }
}