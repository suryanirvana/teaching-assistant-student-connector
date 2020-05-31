package group2.TASC.repository;

import group2.TASC.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepo extends CrudRepository<Schedule, Long> {
    List<Schedule> findAllByOrderByIdAsc();
    Schedule findById(long id);
}