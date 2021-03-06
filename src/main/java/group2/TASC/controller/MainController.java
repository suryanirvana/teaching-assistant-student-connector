package group2.TASC.controller;

import io.micrometer.core.annotation.Timed;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Timed("base")
    @GetMapping("/")
    public String homepage(Authentication authentication, Model model) {
        String username = "";
        try {
            username = authentication.getName();
        } catch (Exception ignored) {}
        model.addAttribute("USERNAME", username);
        return "base";
    }
}
