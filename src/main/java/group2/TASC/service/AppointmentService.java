package group2.TASC.service;

import group2.TASC.model.Appointment;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    Appointment addAppointment(Appointment appointment);

    List<Appointment> findAllAppointments();

    Appointment getAppointmentById(long id);

    void acceptAppointment(Appointment appointment);

    void rejectAppointment(Appointment appointment);
}
