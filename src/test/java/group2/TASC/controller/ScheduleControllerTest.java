package group2.TASC.controller;

import group2.TASC.model.Schedule;
import group2.TASC.repository.ScheduleRepo;
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

    @BeforeEach
    void setUpSchedule() {
        schedule.setScheduleName("Test");
        schedule.setDuration(2);
        schedule.setDate(LocalDate.of(2020, 05,10));
        schedule.setDuration(2);
        scheduleService.addSchedule(schedule);
    }

    @Test
    void testHomepage() throws Exception {
        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("base"));
    }

    @Test
    void testSchedulePage() throws Exception {
        this.mockMvc.perform(get("/seeschedule"))
                .andExpect(status().isOk())
                .andExpect(view().name("see-schedule"));
    }

    @Test
    void testShowScheduleForm() throws Exception {
        this.mockMvc.perform(get("/add/schedule"))
                .andExpect(status().isOk())
                .andExpect(view().name("add-schedule"));
    }

    @Test
    void testIfAddScheduleErrorThenStayAtFormAndAddScheduleValid() throws Exception {
        schedule.setScheduleName(null);
        this.mockMvc.perform(post("/addschedule")
                .flashAttr("schedule", schedule)
                .flashAttr("result", bindingResult)
                .flashAttr("model", model))
                .andExpect(view().name("add-schedule"));

        schedule.setScheduleName("AP");
        this.mockMvc.perform(post("/addschedule")
                .flashAttr("schedule", schedule)
                .flashAttr("result", bindingResult)
                .flashAttr("model", model))
                .andExpect(view().name("redirect:/seeschedule"));
    }

    @Test
    void testIfDeleteScheduleSucceedThenShowSchedule() throws Exception {
        long id = 1234;
        schedule.setId(id);
        schedule.setDate(LocalDate.of(2020,4,24));
        schedule.setDuration(2);
        schedule.setScheduleName("Adpro");
        scheduleService.removeScheduleById(1234);
        this.mockMvc.perform(get("/delete-schedule/1234"))
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/seeschedule"));
    }

    @Test
    public void testIfDeleteScheduleButInvalidIdThenRaiseException() throws Exception {
        try {
            this.mockMvc.perform(get("/delete-schedule/99"))
                    .andExpect(status().isFound())
                    .andExpect(view().name("redirect:/seeschedule"));
        } catch (Exception e) {
            assertEquals("Request processing failed; nested exception is java.lang.IllegalArgumentException: Invalid user Id:99", e.getMessage());
        }
    }


}
