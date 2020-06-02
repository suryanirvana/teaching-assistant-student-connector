package group2.TASC.service;

import group2.TASC.model.Schedule;
import group2.TASC.model.User;
import group2.TASC.repository.ScheduleRepo;
import group2.TASC.repository.UserRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class ScheduleServiceImplTest {
    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private ScheduleRepo scheduleRepo;

    private Schedule schedule = new Schedule();
    private User user = new User();

    private static Long id = (long)2001;
    private static String name = "Sarah Esperanti";
    private static String username= "sarahesperanti";
    private static String email = "sares@h.mail";
    private static String studentId = "studentid123";
    private static String password = "PLISBISAAAAA";
    private static String courseCode ="CS001";

    private static String scheduleName = "Adpro";
    private static Long duration = (long)2;
    private static LocalDate date = LocalDate.of(2020, 06, 03);
    private static LocalTime time = LocalTime.of(8, 00);
    private static Long schedId = (long)99;

    @BeforeEach
    void setUp() {
        user.setCourseCode(courseCode);
        user.setEmail(email);
        user.setId(id);
        user.setName(name);
        user.setPassword(password);
//        user.setRoles(role);
        user.setStudent_id(studentId);
        user.setUsername(username);
        schedule.setScheduleName(scheduleName);
        schedule.setDate(date);
        schedule.setId(schedId);
        schedule.setDuration(duration);
        schedule.setTime(time);
        schedule.setUser(user);
        scheduleService.addSchedule(schedule, username);
    }

    @Test
    void whenSuccessfullyAddScheduleRepoAndServiceCanAccessTheScheduleList() {
        assertEquals(scheduleRepo.findAllByOrderByIdAsc().get(0).getId(), scheduleService.getAllSchedule().get(0).getId());
    }

    @Test
    void whenScheduleFoundUpdateScheduleCodeIfNotFoundThrowException() {
        try {
            scheduleService.getScheduleById(0);
        } catch (EntityNotFoundException ex) {
            assertNull(ex.getMessage());
        }
        try {
            schedule.setId((long)123);
            scheduleService.updateSchedule(schedule, username);
        } catch (EntityNotFoundException ex) {
            assertNull(ex.getMessage());
        }
    }

    @Test
    void whenScheduleCodeFoundUpdateCourseCode() {
        Schedule s = new Schedule();
        s.setScheduleName("RPLtest");
        s.setDate(date);
        s.setDuration(duration);
        s.setTime(time);
        s.setUser(user);
        scheduleService.addSchedule(s, username);
        assertEquals(s.getId(), scheduleService.getScheduleById(s.getId()).getId());

        s.setScheduleName("SoftEng");
        s.setId(s.getId());
        s.setTime(time);
        s.setDuration((long)2);
        s.setDate(date);
        scheduleService.updateSchedule(s, username);
        assertEquals(s.getScheduleName(), scheduleService.getScheduleById(s.getId()).getScheduleName());
    }

    @Test
    void whenDeleteScheduleAssertNullOnGetScheduleById() {
        Schedule s = new Schedule();
        s.setScheduleName("Sched");
        s.setDate(date);
        s.setDuration(duration);
        s.setTime(time);
        s.setUser(user);
        scheduleService.addSchedule(s, username);
        try {
            scheduleService.removeScheduleById(s.getId());
        } catch (EntityNotFoundException ex) {
            assertNull(scheduleService.getScheduleById(s.getId()));
        }
    }
}
