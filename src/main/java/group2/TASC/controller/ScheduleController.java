package group2.TASC.controller;

import group2.TASC.model.Schedule;
import group2.TASC.repository.ScheduleRepo;
import group2.TASC.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ScheduleController {

    @Autowired
    ScheduleRepo scheduleRepo;

    @Autowired
    ScheduleService scheduleService;

    private static final String INDEX = "index";
    private static final String REDIRECT = "redirect:/";
    private static final String SCHEDULE = "SCHEDULE";

    @GetMapping("/seeschedule")
    public String schedulePage(Model model) {
        model.addAttribute(SCHEDULE, scheduleService.getAllSchedule());
        return "see-schedule";
    }

    @GetMapping("/add/schedule")
    public String showAddScheduleForm(Schedule schedule) {
        return "add-schedule";
    }

    @PostMapping("/addschedule")
    public String addSchedule(@Valid Schedule schedule, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-schedule";
        }
        scheduleService.addSchedule(schedule);
        model.addAttribute(SCHEDULE, scheduleService.getAllSchedule());
        return "redirect:/seeschedule";
    }

    @GetMapping("/delete-schedule/{id}")
    public String deleteSchedule(@PathVariable("id") long id, Model model) throws Exception {
        try {
            scheduleRepo.findById(id);
        } catch (Exception e) {
            throw new Exception();
        }
        scheduleService.removeScheduleById(id);
        model.addAttribute(SCHEDULE, scheduleRepo.findAllByOrderByIdAsc());
        return "redirect:/seeschedule";
    }

    @PostMapping("/update-schedule/{id}")
    public String updateSchedule(@PathVariable("id") long id, @Valid Schedule schedule,
                               BindingResult result, Model model) {
        if (result.hasErrors()) {
            schedule.setId(id);
            return "edit-schedule";
        }
        scheduleService.updateSchedule(schedule);
        return "redirect:/seeschedule";
    }

    @GetMapping("/edit-schedule/{id}")
    public String showUpdateScheduleForm(@PathVariable("id") long id, Model model) throws Exception {
        if(!scheduleRepo.existsById(id)) {
            throw new IllegalArgumentException("Invalid user Id:" + id);
        }
        Schedule sched = scheduleRepo.findById(id);
        model.addAttribute(SCHEDULE, sched);
        return "edit-schedule";
    }
}
