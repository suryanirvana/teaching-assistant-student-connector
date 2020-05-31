package group2.TASC.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @NotBlank(message = "Please enter the schedule name")
    @Column(name = "schedule_name")
    private String scheduleName;

    @NotNull
    @Column(name = "duration")
    private Long duration;

    @NotNull
    @Column(name = "date_schedule")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @NotNull
    @Column(name = "time_schedule")
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime time;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
