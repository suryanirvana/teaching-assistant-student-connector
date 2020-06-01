package group2.TASC.controller;

import group2.TASC.model.Appointment;
import group2.TASC.model.Schedule;
import group2.TASC.model.User;
import group2.TASC.repository.UserRepo;
import group2.TASC.service.AppointmentService;
import group2.TASC.service.MailerService;
import group2.TASC.service.UserService;
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
import java.util.Optional;

@Controller
public class AppointmentController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepo userRepo;

    @Autowired
    AppointmentService appointmentService;

    @Autowired
    MailerService mailerService;

    @GetMapping("/seeappointment/{USERNAME}")
    public String appointmentPage(@PathVariable("USERNAME") String username, Authentication authentication, Model model) {
        List<User> TAList = new ArrayList<>();
        List<Appointment> appointments = new ArrayList<>();
        for (User user : userService.findAllUsers()) {
            if(user.getRoleList().contains("TA") && !user.getName().equals(username)) {
                TAList.add(user);
            }
        }
        for (Appointment appointment : appointmentService.findAllAppointments()) {
            if (appointment.getStudent().equals(username) || appointment.getTa().equals(username)) {
                appointments.add(appointment);
            }
        }
        model.addAttribute("TA", TAList);
        model.addAttribute("APPOINTMENT", appointments);
        model.addAttribute("USERNAME", authentication.getName());
        return "see-appointment";
    }

    @GetMapping("/add/appointment/{USERNAME}/{TA}")
    public String addAppointmentPage(@PathVariable("USERNAME") String username, @PathVariable("TA") String ta, Model model) {
        model.addAttribute("USERNAME", username);
        model.addAttribute("TA", ta);
        model.addAttribute("STATUS", "Waiting for confirmation");
        return "add-appointment";
    }

    @PostMapping("/addappointment/{USERNAME}/{TA}")
    public String addSchedule(@PathVariable("USERNAME") String username, @PathVariable("TA") String ta, @Valid Appointment appointment, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return result.toString();
        }
        mailerService.sendEmail(userRepo.findByName(ta).getEmail(),  "You have a new appointment request",
                "Hello TA, student has a new appointment request for course on date at. Please give your confirmation on the application.");

        appointmentService.addAppointment(appointment);
        model.addAttribute("APPOINTMENT", appointmentService.findAllAppointments());
        return "redirect:/seeappointment/" + username;
    }

    @GetMapping("/accept/{id}/{USERNAME}")
    public String acceptAppointment(@PathVariable("id") Long id, @PathVariable("USERNAME") String username, Model model) {
        Appointment appointment = appointmentService.getAppointmentById(id);
        appointmentService.acceptAppointment(appointment);
        model.addAttribute("APPOINTMENT", appointmentService.findAllAppointments());

        mailerService.sendEmail(userService.findByUsername(username).getEmail(), "Your appointment request is accepted",
                "Hello student your appointment with TA for course is confirmed and scheduled on date at time. Contact your TA for further information");
        return "redirect:/seeappointment/" + username;
    }

    @GetMapping("/reject/{id}/{USERNAME}")
    public String rejectAppointment(@PathVariable("id") Long id, @PathVariable("USERNAME") String username, Model model) {
        Appointment appointment = appointmentService.getAppointmentById(id);
        appointmentService.rejectAppointment(appointment);
        model.addAttribute("APPOINTMENT", appointmentService.findAllAppointments());
        mailerService.sendEmail(userService.findByUsername(username).getEmail(), "Your appointment request is rejected",
                "Hello student your appointment with TA for course is rejected and scheduled on date at time. Please request a new appointment.");
        return "redirect:/seeappointment/" + username;
    }
}
