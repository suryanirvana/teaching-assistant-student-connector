package group2.TASC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String homepage() {
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
