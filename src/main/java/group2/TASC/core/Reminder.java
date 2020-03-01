package group2.TASC.core;

import java.util.Date;

public class Reminder {
    private Date date;
    private String reminderName;
    private int duration;


    public Reminder(Date date, String reminderName, int duration) {
        this.date = date;
        this.reminderName = reminderName;
        this.duration = duration;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReminderName() {
        return reminderName;
    }

    public void setReminderName(String reminderName) {
        this.reminderName = reminderName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
