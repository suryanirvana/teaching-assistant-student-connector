package group2.TASC.service;

import group2.TASC.model.Appointment;
import group2.TASC.repository.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    AppointmentRepo appointmentRepo;

    @Override
    public Appointment addAppointment(Appointment appointment) {
        appointment.setStatus("Waiting for confirmation");
        return appointmentRepo.save(appointment);
    }

    @Override
    public List<Appointment> findAllAppointments() {
        return appointmentRepo.findAll();
    }

    @Override
    public Appointment getAppointmentById(long id) {
        return appointmentRepo.findById(id);
    }

    @Override
    public void acceptAppointment(Appointment appointment) {
        appointment.setStatus("Accepted");
        appointmentRepo.save(appointment);
    }

    @Override
    public void rejectAppointment(Appointment appointment) {
        appointment.setStatus("Rejected");
        appointmentRepo.save(appointment);
    }
}
