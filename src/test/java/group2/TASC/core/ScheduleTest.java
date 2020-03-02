package group2.TASC.core;

import org.junit.jupiter.api.Test;
import org.springframework.scheduling.config.SchedulerBeanDefinitionParser;

public class ScheduleTest {
    Schedule Sched = new Schedule();

    @Test
    void testScheduleName() {
        String temp = "AdPro";
        Sched.setScheduleName(temp);
    }
}
