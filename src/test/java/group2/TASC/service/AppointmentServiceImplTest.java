package group2.TASC.service;

import group2.TASC.model.Appointment;
import group2.TASC.repository.AppointmentRepo;
import org.apache.tomcat.jni.Local;
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
public class AppointmentServiceImplTest {

    @Autowired
    AppointmentService appointmentService;

    @Autowired
    AppointmentRepo appointmentRepo;

    private Appointment appointment = new Appointment();

    private static String appointmentName = "Tutor";
    private static LocalDate date = LocalDate.of(2020, 6, 8);
    private static LocalTime time = LocalTime.of(8, 00);
    private static Long duration = (long) 3;
    private static String student = "Sarah";
    private static String ta = "Surya";

    @BeforeEach
    void setUp() {
        appointment.setAppointmentName(appointmentName);
        appointment.setDate(date);
        appointment.setTime(time);
        appointment.setDuration(duration);
        appointment.setStudent(student);
        appointment.setTa(ta);
//        appointment.setId((long)45678);
        appointment.setNumOfStudents((long)1);
        appointmentService.addAppointment(appointment);
    }

    @Test
    void whenSuccessfullyAddAppointmentRepoAndServiceCanAccessTheAppointmentList() {
        assertEquals(appointmentRepo.findAll().get(0).getId(),
                appointmentService.findAllAppointments().get(0).getId());
    }

    @Test
    void whenAppointmentGetIdCheckIfIdTheSameAsTheActualId() {
        assertEquals(appointment.getId(),
                appointmentService.getAppointmentById(appointment.getId()).getId());
//        try {
//            courseService.getCourseById(null);
//        } catch (EntityNotFoundException ex) {
//            assertNull(ex.getMessage());
//        }
//        try {
//            course.setCourseCode("CS00");
//            courseService.updateCourse(course);
//        } catch (EntityNotFoundException ex) {
//            assertNull(ex.getMessage());
//        }
    }

    @Test
    void whenAppointmentAcceptedChangeStatusToAccepted(){
        appointmentService.acceptAppointment(appointment);
        assertEquals("Accepted", appointment.getStatus());
    }

    @Test
    void whenAppointmentRejetedChangeStatusToRejected(){
        appointmentService.rejectAppointment(appointment);
        assertEquals("Rejected", appointment.getStatus());
    }
}
