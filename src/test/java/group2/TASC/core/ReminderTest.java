package group2.TASC.core;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ReminderTest {
    Date date = new Date();
    Reminder reminder= new Reminder(date, "Adpro", 2);

    @Test
    void testScheduleNameExist() {
        String temp = "AdPro";
        reminder.setReminderName(temp);
        assertNotEquals(reminder.getReminderName(), "");
    }

    @Test
    void testScheduleNameEqual() {
        String temp = "AdPro";
        reminder.setReminderName(temp);
        assertEquals(reminder.getReminderName(), temp);
    }

    @Test
    void testDurationExist() {
        int temp = 2;
        reminder.setDuration(temp);
        assertNotEquals(reminder.getDuration(), 0);
    }

    @Test
    void testDurationEquals() {
        int temp = 2;
        reminder.setDuration(temp);
        assertEquals(reminder.getDuration(), temp);
    }
}
