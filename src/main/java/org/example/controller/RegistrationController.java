package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class RegistrationController {
    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }

    @GetMapping("/registration")
    public String getRegistration(){
        return "registration";
    }
    @PostMapping("/registration")
    public String registration(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password){

        return "redirect:/login";
    }
}
