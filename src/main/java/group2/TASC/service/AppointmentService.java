package group2.TASC.service;


import group2.TASC.model.Appointment;

import java.util.List;

public interface AppointmentService {
    List<Appointment> getAllAppointment();

    void addAppointment(Appointment appointment);
}
