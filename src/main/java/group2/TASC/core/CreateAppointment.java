package group2.TASC.core;

import java.time.LocalDate;

public interface CreateAppointment {
    void createAppointment(String name, LocalDate date, int duration);
}