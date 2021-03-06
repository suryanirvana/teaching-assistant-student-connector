package group2.TASC.service;

import group2.TASC.model.Schedule;

import java.util.List;

public interface ScheduleService {

    List<Schedule> getAllSchedule();

    void addSchedule(Schedule schedule, String username);

    void removeScheduleById(long id);

    Schedule getScheduleById(long id);

    void updateSchedule(Schedule schedule, String username);
}