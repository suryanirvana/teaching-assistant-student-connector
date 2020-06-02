package group2.TASC.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import group2.TASC.model.Course;
import group2.TASC.model.User;
import group2.TASC.repository.CourseRepo;
import group2.TASC.repository.UserRepo;
import group2.TASC.security.UserDetailsServiceImpl;
import group2.TASC.service.CourseService;
import group2.TASC.service.StudentService;
import group2.TASC.service.TeachingAssistantService;
import group2.TASC.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.Authentication;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.WebApplicationContext;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = CourseController.class)
@WebAppConfiguration
public class CourseControllerTest {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UserService userService;

    @MockBean
    CourseService courseService;

    @Mock
    Model model;

    @Mock
    BindingResult result;

    @MockBean
    UserRepo userRepo;

    @MockBean
    CourseRepo courseRepo;

    @MockBean
    UserDetailsServiceImpl userDetailsService;

    User user;

    Course course;

    @Autowired
    private WebApplicationContext wac ;

    @BeforeEach
    public void setUp() {
        this.mockMvc = webAppContextSetup(wac).build();
        System.out.println(Arrays.toString(wac.getBeanDefinitionNames()));

        user = new User();
        user.setId((long) 1);
        user.setName("Test");
        user.setStudent_id("1");
        user.setEmail("test@test.com");
        user.setUsername("test");
        user.setPassword("test");
        user.setRoles("TA");

        course = new Course();
        course.setCourseCode("CS01");
        course.setCourseName("Advanced Programming");

        userRepo.save(user);
        courseService.addCourse(course);
    }

    @Test
    public void whenWantToAddCourseItWillReturnAddCourseHTML() throws Exception {
        this.mockMvc.perform(get("/add/course"))
                .andExpect(status().isOk())
                .andExpect(view().name("add-course"));
    }

    @Test
    public void whenWantToSeeCourseItWillReturnSeeCourseHTML() throws Exception {
        this.mockMvc.perform(get("/seecourse"))
                .andExpect(status().isOk())
                .andExpect(view().name("see-course"));
    }

    @Test
    public void whenWantToAddScheduleButErrorItWillStayInTheSamePage() throws Exception {
        course.setCourseName(null);
        this.mockMvc.perform(post("/addcourse")
                .flashAttr("course", course)
                .flashAttr("result", result)
                .flashAttr("model", model))
                .andExpect(view().name("add-course"));
    }

    @Test
    public void whenWantToAddCourseAndValidItWillRedirectedToSeeCoursePage() throws Exception{
        course.setCourseName("Adpro");
        this.mockMvc.perform(post("/addcourse")
                .flashAttr("course", course)
                .flashAttr("result", result)
                .flashAttr("model", model))
                .andExpect(view().name("redirect:/seecourse"));
    }

    @Test
    public void whenWantToEditCourseButCourseCodeNotFoundThrowException() throws Exception {
        try {
            this.mockMvc.perform(get("/edit/CS09"));
        } catch (Exception e) {
            assertEquals("Request processing failed; nested exception is java.lang.IllegalArgumentException: Invalid course Id:CS09", e.getMessage());
        }
    }

    @Test
    public void whenWantToUpdateCourseButNotValidThrowException() throws Exception {
        course.setCourseName(null);
        this.mockMvc.perform(post("/update/CS01"))
                    .andExpect(view().name("edit-course"));
    }

    @Test
    public void whenWantToDeleteCourseButCourseCodeNotFoundThrowException() throws Exception {
            this.mockMvc.perform(get("/delete/CS09")).andExpect(status().is(302));
    }

    @Test
    public void whenWeWantToAssignTAItWillRedirectedToTheSamePage() throws Exception{
        this.mockMvc.perform(get("/assignTA/CS01/1"))
                .andExpect(view().name("redirect:/seecourse"));
    }
}
