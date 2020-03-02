package group2.TASC.core;
import java.util.*;

public class Schedule {
    private Date date;
    private String scheduleName;
    private int duration;

    public Schedule(Date date, String scheduleName,int duration) {
        this.date = date;
        this.scheduleName = scheduleName;
        this.duration = duration;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getScheduleName() {
        return scheduleName;
    }

    public void setScheduleName(String scheduleName) {
        this.scheduleName = scheduleName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
