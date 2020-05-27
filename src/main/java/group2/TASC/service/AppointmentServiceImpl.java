package group2.TASC.service;

import group2.TASC.model.Appointment;
import group2.TASC.repository.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    AppointmentRepo appointmentRepo;

    @Override
    public List<Appointment> getAllAppointment() {
        return appointmentRepo.findAllByOrderByStudent();
    }

    @Override
    public void addAppointment(Appointment appointment) {
        appointmentRepo.save(appointment);
    }
}
