package com.loginapp.logindemo.controller;

import com.loginapp.logindemo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login"; 
    }

    @PostMapping("/login")
    public String processLogin(@ModelAttribute User user, Model model) {
        if ("admin".equals(user.getUsername()) && "1234".equals(user.getPassword())) {
            model.addAttribute("username", user.getUsername());
            return "home"; 
        } else {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "login";
        }
    }
}
