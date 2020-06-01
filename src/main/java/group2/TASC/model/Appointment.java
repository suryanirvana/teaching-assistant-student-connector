package group2.TASC.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    private Long id;

    @NotNull
    @NotBlank(message = "Please enter the appointment name")
    @Column(name = "appointment_name")
    private String appointmentName;

    @NotNull
    @Column(name = "date_appointment")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @NotNull
    @Column(name = "time_appointment")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime time;

    @NotNull
    @Column(name = "duration_appointment")
    private Long duration;

    @NotNull
    @Column(name = "student_name")
    private String student;

    @NotNull
    @Column(name = "ta_name")
    private String ta;

    @Column(name = "num_of_students")
    private Long numOfStudents;

    @NotNull
    @Column(name = "status")
    private String status = "Waiting for confirmation";
}
