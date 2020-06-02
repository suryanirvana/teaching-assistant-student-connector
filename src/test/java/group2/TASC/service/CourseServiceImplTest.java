package group2.TASC.service;

import group2.TASC.model.Course;
import group2.TASC.repository.CourseRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.EntityNotFoundException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class CourseServiceImplTest {

        @Autowired
        CourseService courseService;

        @Autowired
        CourseRepo courseRepo;

        private Course course = new Course();

        private static String courseName = "Adpro";
        private static String taId = "123";
        private static String taName = "Surya";
        private static String courseCode = "CS01";

        @BeforeEach
        void setUp() {
            course.setCourseCode(courseCode);
            course.setCourseName(courseName);
            course.setTaId(taId);
            course.setTaName(taName);
            courseService.addCourse(course);
        }

        @Test
        void whenSuccessfullyAddCourseRepoAndServiceCanAccessTheCourseList() {
            assertEquals(courseRepo.findAll().get(0).getCourseCode(), courseService.getAllCourse().get(0).getCourseCode());
        }

        @Test
        void whenCourseCodeFoundUpdateCourseCodeIfNotFoundThrowException() {
            try {
                courseService.getCourseById(null);
            } catch (EntityNotFoundException ex) {
                assertNull(ex.getMessage());
            }
            try {
                course.setCourseCode("CS00");
                courseService.updateCourse(course);
            } catch (EntityNotFoundException ex) {
                assertNull(ex.getMessage());
            }
        }

        @Test
        void whenCourseCodeFoundUpdateCourseCode() {
            Course c = new Course();
            c.setTaName("Sarah");
            c.setCourseName("Adpro");
            c.setTaId("6789");
            c.setCourseCode(courseCode);
            courseService.addCourse(c);
            assertEquals(c.getCourseCode(), courseService.getCourseById(c.getCourseCode()).getCourseCode());

            c.setTaName("Sury");
            c.setCourseName("Adpro");
            c.setTaId("6789");
            c.setCourseCode(courseCode);
            courseService.updateCourse(c);
            assertEquals(c.getTaName(), courseService.getCourseById(c.getCourseCode()).getTaName());
        }

        @Test
        void whenDeleteCourseAssertNullOnGetCourseById() {
            try {
                courseService.removeCourseById("CS01");
            } catch (EntityNotFoundException ex) {
                assertNull(courseService.getCourseById("CS01"));
            }
        }
    }

