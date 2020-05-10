package group2.TASC.core;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ReminderTest {
    @Test
    void testIfCanCreateNewReminderObject() {
        LocalDate date = LocalDate.of(2020, 05, 10);
        Reminder reminder = new Reminder(date, "Adpro", 2);
    }
}
