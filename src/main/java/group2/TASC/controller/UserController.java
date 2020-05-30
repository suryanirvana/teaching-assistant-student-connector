package group2.TASC.controller;

import group2.TASC.model.Role;
import group2.TASC.model.User;
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
public class UserController
{
    @Autowired
    private UserService userService;

    private static final String REDIRECT = "redirect:/";

    @GetMapping("/signup")
    public String signUpForm() {
        return "sign-up";
    }

    @PostMapping("/register")
    public String register(@RequestBody User user, BindingResult result, Model model) {
//        if (userService.findByUsername(user.getUsername()) != null)
//        {
//            return new ResponseEntity<>(HttpStatus.CONFLICT);
//        }
//        if (result.hasErrors()) {
//            return "sign-up";
//        }
        userService.saveUser(user);
        model.addAttribute("USER", user);
        return REDIRECT;
    }

    @GetMapping("/login")
    public String loginAndLogout()
    {
        return "login";
    }

    @PostMapping("/authenticateTheUser")
    public String successLogin(@Valid User user, Model model) throws Exception {
        if(userService.findByUsername(user.getUsername()) == null) {
            throw new Exception("Username not found");
        }
        model.addAttribute("username", user.getUsername());
        return REDIRECT;
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


    @PostMapping("/change/{role}")
    public ResponseEntity<?> changeRole(Principal principal, @PathVariable Role role)
    {
        User user = userService.changeRole(role, principal.getName());
        return ResponseEntity.ok(user);
    }
}