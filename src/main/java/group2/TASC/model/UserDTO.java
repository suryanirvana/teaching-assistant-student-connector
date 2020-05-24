package group2.TASC.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UserDTO {
    @NotNull
    private long userId;
    @NotNull
    private long studentId;
    @NotNull
    @NotEmpty(message = "Please enter your name")
    private String name;
    @NotNull
    @NotEmpty(message = "Please enter your desired username")
    private String username;
    @NotNull
    @NotEmpty(message = "Please enter your password")
    private String password;
    @NotNull
    @NotEmpty(message = "Please enter your email")
    private String email;
    @NotNull
    @NotEmpty(message = "Please enter your role")
    private String role;

}
