package group2.TASC.service;

import group2.TASC.model.Schedule;
import group2.TASC.model.User;
import group2.TASC.repository.ScheduleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    ScheduleRepo scheduleRepo;

    @Autowired
    UserService userService;

    @Override
    public List<Schedule> getAllSchedule() {
        return scheduleRepo.findAllByOrderByIdAsc();
    }

    @Override
    public void addSchedule(Schedule schedule, String username) {
        User user = userService.findByUsername(username);
        System.out.println(username);
        schedule.setUser(user);
        scheduleRepo.save(schedule);
    }

    @Override
    public void removeScheduleById(long id) {
        scheduleRepo.deleteById(id);
    }

    @Override
    public Schedule getScheduleById(long id) {
        if (!scheduleRepo.existsById(id)) {
            throw new EntityNotFoundException();
        }
        return scheduleRepo.findById(id);
    }

    @Override
    public void updateSchedule(Schedule schedule, String username) {
        if (!scheduleRepo.existsById(schedule.getId())) {
            throw new EntityNotFoundException();
        }
        addSchedule(schedule, username);
    }
}