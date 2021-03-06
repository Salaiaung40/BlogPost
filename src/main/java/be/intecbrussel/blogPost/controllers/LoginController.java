package be.intecbrussel.blogPost.controllers;

import be.intecbrussel.blogPost.repositories.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @Autowired
    private SecurityService securityService;

    @GetMapping("/login")
    public String login(Model model, String error, String logout){
// This code is preventing to access login page after user had login. (Same code use in Register page too)
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        }

        if (securityService.isAuthenticated()) {
            return "redirect:/";
        }

        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");
        return "login";
    }

public String backURL(){
//        ShowLoginForm
//                previousURL = url() -> previous();
                return null;

}
//    @PostMapping("/logout")
//    public String logout(){
//
//
//        return "index";
//    }

}
