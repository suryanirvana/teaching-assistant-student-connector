package group2.TASC.controller;

import group2.TASC.model.Appointment;
import group2.TASC.service.AppointmentService;
import group2.TASC.service.MailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @Autowired
    MailerService mailerService;

    private static final String APPOINTMENT = "APPOINTMENT";

    @GetMapping("/seeappointment")
    public String appointmentPage(Model model) {
        model.addAttribute(APPOINTMENT, appointmentService.getAllAppointment());
        return "see-appointment";
    }

    @GetMapping("/add/appointment")
    public String showAddAppointmentForm(Appointment appointment) {
        return "add-appointment";
    }

    @PostMapping("/add-appointment")
    public String addAppointment(@Valid Appointment appointment, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-appointment";
        }

        mailerService.sendEmail(System.getenv("TEST_EMAIL"), "New Appointment Request",
                "Hello, " + appointment.getTA() + "! " + appointment.getStudent() + " has requested an appointment for "
                        + appointment.getScheduleName() + " on " + appointment.getDate() + ". Please give your confirmation.");

        appointmentService.addAppointment(appointment);
        model.addAttribute(APPOINTMENT, appointmentService.getAllAppointment());

        return "redirect:/seeappointment";
    }


}
