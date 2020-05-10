package group2.TASC.core;

import group2.TASC.model.Schedule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class AppointmentTest {
    private static String studentName = "newStudent";
    private static String studentUserName = "StudentUserName";

    private static String TAName = "newTA";
    private static String TAUserName = "TAUSerName";

    private static String password = "123";

    @Test
    void testIfCanCreateNewAppointmentObject() {
        Student student = new Student(studentName, studentUserName, password);
        TeachingAssistant ta = new TeachingAssistant(TAName, TAUserName, password);
        Appointment appointment = new Appointment(student, ta);
    }
}
