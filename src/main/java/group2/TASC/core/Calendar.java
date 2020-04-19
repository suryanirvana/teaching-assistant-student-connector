package group2.TASC.core;

import group2.TASC.model.Schedule;

import java.util.ArrayList;

public class Calendar {
    private ArrayList<Schedule> scheduleArrayList = new ArrayList<>();

    public Calendar() {
    }

    public ArrayList<Schedule> getScheduleArrayList() {
        return scheduleArrayList;
    }

    public void setScheduleArrayList(ArrayList<Schedule> scheduleArrayList) {
        this.scheduleArrayList = scheduleArrayList;
    }
}
