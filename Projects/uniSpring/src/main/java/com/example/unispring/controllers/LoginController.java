package com.example.unispring.controllers;


import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Model modelo, String logout){
        modelo.addAttribute("logout", logout);
        return "login";
    }

    @GetMapping("/logout")
    public String logout(Model modelo, String logout, HttpSession session){
        session.invalidate();
        modelo.addAttribute("logout",logout);

        return "logout";
    }
}
