package group2.TASC.core;

import group2.TASC.model.Schedule;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Calendar {
    private ArrayList<Schedule> scheduleArrayList = new ArrayList<>();

    public Calendar() {
    }
}
