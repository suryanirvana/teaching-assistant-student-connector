package group2.TASC.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String homepage(Authentication authentication, Model model) {
        String username = "";
        try {
            username = authentication.getName();
        } catch (Exception e) {}
        model.addAttribute("USERNAME", username);
        return "base";
    }

    @GetMapping("/admin")
    public String adminPageTest() {
        return "admin";
    }

    @GetMapping("/error")
    public String errorPage() {
        return "access-denied";
    }
}
