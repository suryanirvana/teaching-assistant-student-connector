package group2.TASC.service;

import group2.TASC.model.Schedule;
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
public class ScheduleServiceTest {

    @Autowired
    private ScheduleRepo scheduleRepo;

    @Autowired
    private ScheduleService scheduleService;

    private Schedule schedule;

    @BeforeEach
    void setUpSchedule() {
        schedule = new Schedule();
        schedule.setScheduleName("Adpro");
        schedule.setDate(LocalDate.of(2020, 05,10));
        schedule.setDuration(2);
        scheduleService.addSchedule(schedule);
    }

    @Test
    void testGetScheduleByIdNotFoundAndUpdateScheduleByIdNotFound() {
        try {
            scheduleService.getScheduleById(1234);
        } catch (EntityNotFoundException ex){
            assertNull(ex.getMessage());
        }

        try {
            schedule.setId((long)1234);
            scheduleService.updateSchedule(schedule);
        } catch (EntityNotFoundException ex){
            assertNull(ex.getMessage());
        }
    }

    @Test
    void getScheduleList() {
        assertEquals(scheduleRepo.findAllByOrderByIdAsc().get(0).getId(), scheduleService.getAllSchedule().get(0).getId());
    }

    @Test
    void testGetScheduleByIdAndUpdateScheduleByIdAndScheduleExist() {
        Schedule scheduletest = new Schedule();
        scheduletest.setScheduleName("Adpro");
        scheduletest.setDate(LocalDate.of(2020, 05,10));
        scheduletest.setDuration(2);
        scheduleService.addSchedule(scheduletest);
        assertEquals(scheduletest.getId(), scheduleService.getScheduleById(4).getId());

        scheduletest.setDuration(10);
        scheduleService.updateSchedule(scheduletest);
        assertEquals(10, scheduleService.getScheduleById(4).getDuration());
    }

    @Test void testRemoveScheduleById() {
        scheduleRepo.delete(schedule);
    }
}
