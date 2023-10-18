package study.work.signup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping(value="/main")
    public String mainPage(Model model) {

        return "main.html";
    }
}
