package group2.TASC.controller;

import group2.TASC.model.Schedule;
import group2.TASC.repository.ScheduleRepo;
import group2.TASC.service.ScheduleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class MainController {

    @Autowired
    ScheduleRepo scheduleRepo;

    @Autowired
    ScheduleService scheduleService;

    private static final String INDEX = "index";
    private static final String REDIRECT = "redirect:/";
    private static final String SCHEDULE = "SCHEDULE";

    @GetMapping("/")
    public String homepage(Model model) {
        model.addAttribute(SCHEDULE, scheduleService.getAllSchedule());
        return INDEX;
    }

    @GetMapping("/add/schedule")
    public String showAddScheduleForm(Schedule schedule) {
        return "add-schedule";
    }

    @PostMapping("/addschedule")
    public String addUser(@Valid Schedule schedule, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-schedule";
        }
        scheduleRepo.save(schedule);
        model.addAttribute(SCHEDULE, scheduleService.getAllSchedule());
        return "see-schedule";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) throws Exception {
        try {
            scheduleRepo.findById(id);
        } catch (Exception e) {
            throw new Exception();
        }
        scheduleRepo.deleteById(id);
        model.addAttribute(SCHEDULE, scheduleRepo.findAll());
        return INDEX;
    }
}
