package group2.TASC.core;

import group2.TASC.model.Schedule;

import java.util.ArrayList;

public class Calendar {
    private ArrayList<Schedule> scheduleArrayList = new ArrayList<>();
    private ArrayList<Appointment> appointmentArrayList = new ArrayList<>();

    public Calendar() {
    }

    public ArrayList<Schedule> getScheduleArrayList() {
        return scheduleArrayList;
    }

    public void setScheduleArrayList(ArrayList<Schedule> scheduleArrayList) {
        this.scheduleArrayList = scheduleArrayList;
    }

    public ArrayList<Appointment> getAppointmentArrayList() {
        return appointmentArrayList;
    }

    public void setAppointmentArrayList(ArrayList<Appointment> appointmentArrayList) {
        this.appointmentArrayList = appointmentArrayList;
    }
}
