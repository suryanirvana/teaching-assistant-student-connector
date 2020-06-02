package group2.TASC.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import group2.TASC.model.Appointment;
import group2.TASC.model.Course;
import group2.TASC.model.Schedule;
import group2.TASC.model.User;
import group2.TASC.repository.CourseRepo;
import group2.TASC.repository.ScheduleRepo;
import group2.TASC.repository.UserRepo;
import group2.TASC.security.UserDetailsServiceImpl;
import group2.TASC.service.AppointmentService;
import group2.TASC.service.CourseService;
import group2.TASC.service.ScheduleService;
import group2.TASC.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@WebMvcTest(controllers = ScheduleController.class)
@WebAppConfiguration
public class ScheduleControllerTest {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ScheduleRepo scheduleRepo;

    @MockBean
    ScheduleService scheduleService;

    @MockBean
    UserRepo userRepo;

    @Mock
    Model model;

    @Mock
    BindingResult result;

    @MockBean
    AppointmentService appointmentService;

    @MockBean
    UserDetailsServiceImpl userDetailsService;

    User user;

    Schedule schedule;

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

        userRepo.save(user);

        schedule = new Schedule();
        schedule.setId((long) 1);
        schedule.setScheduleName("Test");
        schedule.setDate(LocalDate.of(2020,12,20));
        schedule.setTime(LocalTime.of(12, 12));
        schedule.setDuration((long)2);
        schedule.setUser(user);

        scheduleService.addSchedule(schedule, user.getUsername());
    }

    @Test
    public void seeSchedulePageTest() throws Exception{
        this.mockMvc.perform(get("/seeschedule/test"))
                .andExpect(status().isOk())
                .andExpect(view().name("see-schedule"));
    }

    @Test
    public void addScheduleGet() throws Exception {
        this.mockMvc.perform(get("/add/schedule/test"))
                .andExpect(status().isOk())
                .andExpect(view().name("add-schedule"));
    }

    @Test
    public void addScheduleFailed() throws Exception{
        schedule.setTime(null);
        this.mockMvc.perform(post("/addschedule/test")
                .flashAttr("schedule", schedule)
                .flashAttr("result", result)
                .flashAttr("model", model))
                .andExpect(view().name("add-schedule"));
    }

    @Test
    public void addScheduleSuccess() throws Exception{
        schedule.setTime(LocalTime.of(20,20));
        this.mockMvc.perform(post("/addschedule/test")
                .flashAttr("schedule", schedule)
                .flashAttr("result", result)
                .flashAttr("model", model))
                .andExpect(view().name("redirect:/seeschedule/test"));
    }

    @Test
    public void editScheduleFormFailed() throws Exception {
        try {
            this.mockMvc.perform(get("/edit-schedule/999/test"));
        } catch (Exception e) {
            assertEquals("Request processing failed; nested exception is java.lang.IllegalArgumentException: Invalid user Id:999", e.getMessage());
        }
    }

    @Test
    public void updateSchedulePostFailed() throws Exception {
        schedule.setScheduleName(null);
        this.mockMvc.perform(post("/update-schedule/1/test"))
                .andExpect(view().name("edit-schedule"));
    }
}
