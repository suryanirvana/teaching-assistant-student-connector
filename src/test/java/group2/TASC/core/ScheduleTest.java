package group2.TASC.core;

import group2.TASC.model.Schedule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

public class ScheduleTest {
    Date date = new Date();
    Schedule Sched = new Schedule();

    @BeforeEach
    void setUpSchedule() {
        Sched.setDate(date);
        Sched.setScheduleName("Adpro");
        Sched.setDuration(2);
    }

    @Test
    void testScheduleNameExist() {
        String temp = "AdPro";
        Sched.setScheduleName(temp);
        assertNotEquals(Sched.getScheduleName(), "");
    }

    @Test
    void testScheduleNameEqual() {
        String temp = "AdPro";
        Sched.setScheduleName(temp);
        assertEquals(Sched.getScheduleName(), temp);
    }

    @Test
    void testDurationExist() {
        int temp = 2;
        Sched.setDuration(temp);
        assertNotEquals(Sched.getDuration(), 0);
    }

    @Test
    void testDurationEquals() {
        int temp = 2;
        Sched.setDuration(temp);
        assertEquals(Sched.getDuration(), temp);
    }

    @Test
    void testGetDate() {
        Date date = new Date();
        Sched.setDate(date);
        assertEquals(Sched.getDate(), Sched.getDate());
    }

    @Test
    void testSetDate() {
        Date date = new Date();
        Sched.setDate(date);
        assertEquals(Sched.getDate(), new Date());
    }

}
