package group2.TASC.core;

import org.junit.jupiter.api.Test;
import org.springframework.scheduling.config.SchedulerBeanDefinitionParser;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

public class ScheduleTest {
    Date date = new Date();
    Schedule Sched = new Schedule(date, "Adpro", 2);

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


}
