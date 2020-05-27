package group2.TASC.repository;

import group2.TASC.model.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepo extends CrudRepository<Appointment, Long> {
    List<Appointment> findAllByOrderByStudent();
    Appointment findById(long id);
}
