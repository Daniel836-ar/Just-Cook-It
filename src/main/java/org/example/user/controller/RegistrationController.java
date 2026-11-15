package org.example.user.controller;

import org.example.user.dto.UserDto;
import org.example.user.roles.Role;
import org.example.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @GetMapping("/registration")
    public String getRegistration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password,
            Model model) {

        name = name.trim();
        email = email.trim();

        if (name.isBlank()) {
            return registrationError("Имя не может быть пустым.", name, email, model);
        }
        if (password.length() < 6) {
            return registrationError("Пароль должен содержать минимум 6 символов.", name, email, model);
        }
        if (userService.existsByEmail(email)) {
            return registrationError("Пользователь с таким email уже зарегистрирован.", name, email, model);
        }

        UserDto dto = new UserDto(name, email, password, Role.USER);
        userService.save(dto);

        return "redirect:/login?registered";
    }

    private String registrationError(String message, String name, String email, Model model) {
        model.addAttribute("error", message);
        model.addAttribute("name", name);
        model.addAttribute("email", email);
        return "registration";
    }
}
