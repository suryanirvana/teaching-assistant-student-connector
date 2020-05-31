package group2.TASC.controller;

import group2.TASC.model.User;
import group2.TASC.repository.UserRepo;
import group2.TASC.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;

    private static final String REDIRECT = "redirect:/";

    @GetMapping("/signup")
    public String signUpForm() {
        return "sign-up";
    }

    @PostMapping("/register")
    public String register(@Valid User user, Model model) throws Exception{
        try {
            userService.saveUser(user);
        } catch (Exception e) {
            model.addAttribute("ERROR_MESSAGE", "Username already exist");
        }
        user.setRoles(user.getRoles()+",TA");
        userRepo.save(user);
        return REDIRECT;
    }

    @GetMapping("/login")
    public String loginForm()
    {
        return "login";
    }

    @GetMapping("/login-error")
    public String login(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        String errorMessage = null;
        if (session != null) {
            AuthenticationException ex = (AuthenticationException) session
                    .getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
            if (ex != null) {
                errorMessage = "Invalid Username or Password";
            }
        }
        model.addAttribute("errorMessage", errorMessage);
        return "login";
    }
}