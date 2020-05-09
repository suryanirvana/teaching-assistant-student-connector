package group2.TASC.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
public class User {
    @Id
    private long studentId;
    private String name;
    private String username;
    private String password;
}
