package group2.TASC.core;

import group2.TASC.model.Schedule;
import group2.TASC.repository.ScheduleRepo;
import group2.TASC.service.ScheduleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import javax.persistence.EntityNotFoundException;
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
        schedule.setId((long)1234);
        schedule.setScheduleName("Adpro");
        schedule.setDate(new Date(0));
        schedule.setDuration(2);
        scheduleService.addSchedule(schedule);
    }

    @Test
    void testGetScheduleByIdNotFound() {
        try {
            scheduleService.getScheduleById(1234);
        } catch (EntityNotFoundException ex){
            assertEquals(null, ex.getMessage());
        }
    }

    @Test
    void getScheduleList() {
        assertEquals(scheduleRepo.findAllByOrderByIdAsc().get(0).getId(), scheduleService.getAllSchedule().get(0).getId());
    }

    @Test
    void testGetScheduleByIdAndScheduleExist() {
        try {
            assertEquals(schedule.getId(), scheduleService.getScheduleById(1234).getId());
        } catch (EntityNotFoundException e) {
            assertNull(e.getMessage());
        }
    }

    @Test void testRemoveScheduleById() {
        scheduleRepo.delete(schedule);
    }

    @Test
    void testUpdateScheduleIdButScheduleDoesntExist() {
        schedule.setId((long)0);
        try {
            scheduleService.updateSchedule(schedule);
        } catch (EntityNotFoundException e) {
            assertNull(e.getMessage());
        }
    }

}
