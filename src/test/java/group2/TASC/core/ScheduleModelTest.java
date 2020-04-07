package group2.TASC.core;

import group2.TASC.model.Schedule;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class ScheduleModelTest {

    @Autowired
    private static Schedule schedule = new Schedule();

    @Test
    void testScheduleName() {
        String temp = "Adpro";
        schedule.setScheduleName(temp);
        assertEquals("Adpro", schedule.getScheduleName());
    }

    @Test
    void testIdExist() {
        long schedule_id = 12345;
        schedule.setId(schedule_id);
        assertEquals(12345, schedule.getId());
    }

    @Test
    void testDuration() {
        int duration = 2;
        schedule.setDuration(duration);
        assertEquals(2, schedule.getDuration());
    }

    @Test
    void testDate() {
        Date schedule_date = new Date();
        schedule.setDate(schedule_date);
        assertEquals(schedule_date, schedule.getDate());
    }
}
