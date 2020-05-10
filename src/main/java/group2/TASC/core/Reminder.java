package group2.TASC.core;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class Reminder {
    private LocalDate date;
    private String reminderName;
    private int duration;


    public Reminder(LocalDate date, String reminderName, int duration) {
        this.date = date;
        this.reminderName = reminderName;
        this.duration = duration;
    }
}
