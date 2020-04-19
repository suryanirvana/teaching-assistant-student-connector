package group2.TASC.core;

import group2.TASC.controller.MainController;
import group2.TASC.model.Schedule;
import group2.TASC.repository.ScheduleRepo;
import group2.TASC.service.ScheduleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.Date;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ScheduleControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Mock
    private BindingResult bindingResult;

    @Mock
    private Model model;

    @MockBean
    private ScheduleRepo scheduleRepo;

    @Autowired
    private ScheduleService scheduleService;

    private static Schedule schedule = new Schedule();

    @Test
    void testHomepage() throws Exception {
        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    void testShowScheduleForm() throws Exception {
        this.mockMvc.perform(get("/add/schedule"))
                .andExpect(status().isOk())
                .andExpect(view().name("add-schedule"));
    }

    @Test
    void testIfAddScheduleError() throws Exception {
        schedule.setScheduleName(null);
        this.mockMvc.perform(post("/addschedule")
                .flashAttr("schedule", schedule)
                .flashAttr("result", bindingResult)
                .flashAttr("model", model))
                .andExpect(view().name("add-schedule"));
    }

    @Test
    void testIfAddScheduleSucceed() throws Exception {
        long id = 1234;
        schedule.setId(id);
        schedule.setScheduleName("Adpro");
        schedule.setDuration(2);
        schedule.setDate(new Date());
        this.mockMvc.perform(post("/addschedule")
                .flashAttr("schedule", schedule)
                .flashAttr("result", bindingResult)
                .flashAttr("model", model))
                .andExpect(view().name("see-schedule"));
    }
}
