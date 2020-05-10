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

    @Test
    void testShowCourseForm() throws Exception {
        this.mockMvc.perform(get("/add/course"))
                .andExpect(status().isOk())
                .andExpect(view().name("add-course"));
    }

    @Test
    void testIfAddScheduleErrorThenStayAtForm() throws Exception {
        course.setCourseName(null);
        this.mockMvc.perform(post("/addcourse")
                .flashAttr("course", course)
                .flashAttr("result", bindingResult)
                .flashAttr("model", model))
                .andExpect(view().name("add-course"));
    }

    @Test
    void testIfDeleteCourseSucceedThenShowCourse() throws Exception {
        long id = 1234;
        course.setCourseCode(id);
        course.setCourseName("Adpro");
        courseService.removeCourseById(id);
        this.mockMvc.perform(get("/delete/1234"))
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/seecourse"));
    }

    @Test
    public void testIfDeleteCourseButInvalidIdThenRaiseException() throws Exception {
        try {
            this.mockMvc.perform(get("/delete/99"))
                    .andExpect(status().isFound())
                    .andExpect(view().name("redirect:/seecourse"));
        } catch (Exception e) {
            assertEquals("Request processing failed; nested exception is java.lang.IllegalArgumentException: Invalid user Id:99", e.getMessage());
        }
    }

//    @Test
//    public void testUpdateCourseValidThenRedirectSeeCourse() throws Exception {
//        course.setCourseCode(11);
//        course.setCourseName("Adpro");
//        this.mockMvc.perform(post("/update/" + course.getCourseCode())
//                .flashAttr("user", course)
//                .flashAttr("result", bindingResult)
//                .flashAttr("model", model))
//                .andExpect(status().isOk())
//                .andExpect(view().name("redirect:/seecourse"));
//    }


}
