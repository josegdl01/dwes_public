package velazquez.entregablefinaljgd.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String loginGet(){
        return "login";
    }

    @GetMapping("/logout")
    public String logoutGet(HttpSession session){
        session.invalidate();
        return "redirect:/login";
    }
}
