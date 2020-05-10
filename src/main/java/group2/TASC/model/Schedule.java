package group2.TASC.model;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.*;

@Entity
@Getter
@Setter
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate date;

    @NotNull
    private String scheduleName;

    @NotNull
    private int duration;
}
