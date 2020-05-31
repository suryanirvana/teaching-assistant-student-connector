package group2.TASC.controller;

import group2.TASC.model.Schedule;
import group2.TASC.repository.ScheduleRepo;
//import group2.TASC.service.MailerService;
import group2.TASC.service.ScheduleService;
import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ScheduleController {

    @Autowired
    ScheduleRepo scheduleRepo;

    @Autowired
    ScheduleService scheduleService;
//
//    @Autowired
//    MailerService mailerService;

//    private static final String INDEX = "index";
    private static final String REDIRECT = "redirect:/";
    private static final String SCHEDULE = "SCHEDULE";

    @GetMapping("/seeschedule/{USERNAME}")
    public String schedulePage(@PathVariable("USERNAME") String username,Model model) {
        List<Schedule> schedules = new ArrayList<>();
        for (Schedule schedule : scheduleService.getAllSchedule()) {
            if (schedule.getUser().getUsername().equals(username)) {
                schedules.add(schedule);
            }
        }
        model.addAttribute(SCHEDULE, schedules);
        model.addAttribute("USERNAME", username);
        return "see-schedule";
    }

    @GetMapping("/add/schedule/{USERNAME}")
    public String showAddScheduleForm(@PathVariable("USERNAME") String username, Model model) {
        model.addAttribute("USERNAME", username);
        return "add-schedule";
    }

    @PostMapping("/addschedule/{USERNAME}")
    public String addSchedule(@PathVariable("USERNAME") String username, @Valid Schedule schedule, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-schedule";
        }

//
//        mailerService.sendEmail(System.getenv("TEST_EMAIL"), "You have added a new course",
//                "Successfully add new schedule");
//
        scheduleService.addSchedule(schedule, username);
        model.addAttribute(SCHEDULE, scheduleService.getAllSchedule());
        return "redirect:/seeschedule/" + username;
    }
//
//    @GetMapping("/delete-schedule/{USERNAME}/{id}")
//    public String deleteSchedule(@PathVariable("id") long id, Model model) throws Exception {
//        try {
//            scheduleService.getScheduleById(id);
//        } catch (Exception e) {
//            throw new Exception();
//        }
//        scheduleService.removeScheduleById(id);
//        model.addAttribute(SCHEDULE, scheduleService.getAllSchedule());
//        return "redirect:/seeschedule";
//    }
//
//    @PostMapping("/update-schedule/{USERNAME}/{id}")
//    public String updateSchedule(@PathVariable("id") long id, @Valid Schedule schedule,
//                               BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            schedule.setId(id);
//            return "edit-schedule";
//        }
//        scheduleService.updateSchedule(schedule);
//        return "redirect:/seeschedule";
//    }
//
//    @GetMapping("/edit-schedule/{USERNAME}/{id}")
//    public String showUpdateScheduleForm(@PathVariable("id") long id, Model model) throws Exception {
//        if(!scheduleRepo.existsById(id)) {
//            throw new IllegalArgumentException("Invalid user Id:" + id);
//        }
//        Schedule sched = scheduleRepo.findById(id);
//        model.addAttribute(SCHEDULE, sched);
//        return "edit-schedule";
//    }
}
