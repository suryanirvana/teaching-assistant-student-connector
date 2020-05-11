package group2.TASC.controller;

import group2.TASC.model.Course;
import group2.TASC.model.Schedule;
import group2.TASC.repository.CourseRepo;
import group2.TASC.repository.ScheduleRepo;
import group2.TASC.service.CourseService;
import group2.TASC.service.ScheduleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CourseControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Mock
    private BindingResult bindingResult;

    @Mock
    private Model model;

    @MockBean
    private CourseRepo courseRepo;

    @Autowired
    private CourseService courseService;

    private static Course course = new Course();

    @BeforeEach
    void setUpCourse() {
        course.setCourseCode(10);
        course.setCourseName("Test");
        courseService.addCourse(course);
    }

    @Test
    void testShowCourseForm() throws Exception {
        this.mockMvc.perform(get("/add/course"))
                .andExpect(status().isOk())
                .andExpect(view().name("add-course"));
    }

    @Test
    void testIfAddScheduleErrorThenStayAtFormAndAddScheduleValidThenRedirectToSeeCoursePage() throws Exception {
        course.setCourseName(null);
        this.mockMvc.perform(post("/addcourse")
                .flashAttr("course", course)
                .flashAttr("result", bindingResult)
                .flashAttr("model", model))
                .andExpect(view().name("add-course"));

        course.setCourseName("Adpro");
        this.mockMvc.perform(post("/addcourse")
                .flashAttr("course", course)
                .flashAttr("result", bindingResult)
                .flashAttr("model", model))
                .andExpect(view().name("redirect:/seecourse"));
    }

    @Test
    void testIfDeleteCourseSucceedThenShowCourse() throws Exception {
        this.mockMvc.perform(get("/delete/10"))
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/seecourse"));
    }

    @Test
    public void testIfDeleteCourseButInvalidIdThenRaiseException() throws Exception {
        Course new_course = new Course();
        new_course.setCourseCode(1001);
        new_course.setCourseName("Testt");
        courseService.addCourse(new_course);
        courseService.removeCourseById(1001);
        try {
            this.mockMvc.perform(get("/delete/1001"))
                    .andExpect(status().isFound())
                    .andExpect(view().name("redirect:/seecourse"));
        } catch (Exception e) {
            assertEquals("Request processing failed; nested exception is java.lang.IllegalArgumentException: Invalid user Id:99", e.getMessage());
        }
    }

    @Test
    void testShowSeeCoursePage() throws Exception {
        this.mockMvc.perform(get("/seecourse"))
                .andExpect(status().isOk())
                .andExpect(view().name("see-course"));
    }

    @Test
    void testShowHomepage() throws Exception {
        this.mockMvc.perform(get("/home"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

//    @Test
//    void testShowSignUpForm() throws Exception {
//        this.mockMvc.perform(get("/signup"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("sign-up"));
//    }

//    @Test
//    public void testUpdateCourseValidThenRedirectSeeCourse() throws Exception {
//        Course new_course = new Course();
//        new_course.setCourseCode(1001);
//        new_course.setCourseName("Testt");
//        this.mockMvc.perform(post("/update/1001")
//                .flashAttr("user", course)
//                .flashAttr("result", bindingResult)
//                .flashAttr("model", model))
//                .andExpect(status().isOk())
//                .andExpect(view().name("see-course"));
//    }
}
