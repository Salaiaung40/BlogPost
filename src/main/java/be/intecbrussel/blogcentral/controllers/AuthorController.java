package be.intecbrussel.blogcentral.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthorController {


    @GetMapping("/")
    public String viewHomePage() {
        return "index";
    }
}
