package group2.TASC.repository;

import group2.TASC.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long> {
    Appointment findByAppointmentName(String appointmentName);
    Appointment findById(long id);
}
