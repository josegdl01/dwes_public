package com.example.unispring.controllers;

import com.example.unispring.dto.ProfesorDTO;
import com.example.unispring.dto.UserDTO;
import com.example.unispring.models.Asignatura;
import com.example.unispring.models.Usuarios;
import com.example.unispring.services.UsuarioServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FormsController {

    @Autowired
    UsuarioServicesImpl usuarioServices;

    @GetMapping ("/formTeacher")
    public String getForm(Model model){
        ProfesorDTO profesor = new ProfesorDTO();
        model.addAttribute("profesor", profesor);
        return "form1";
    }

    @PostMapping("/formTeacher")
    public String postForm(Model model, Asignatura asignatura){

        return "form1";
    }

    @GetMapping("/formUser")
    public String getUser(Model model){
        UserDTO user = new UserDTO();

        model.addAttribute("user",user);
        return "register";
    }

    @PostMapping("/formUser")
    public String postUser(@ModelAttribute UserDTO user){

        Usuarios userIns = new Usuarios();
        userIns.setActivo(true);
        userIns.setNombre(user.getNombre());
        userIns.setApellidos(user.getApellidos());
        userIns.setEmail(user.getEmail());
        userIns.setUsuario(user.getUsuario());
        userIns.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userIns.setRole("ROLE_USER");

        userIns = usuarioServices.addUsuario(userIns);

        if(userIns == null){
           return "redirect:/register";
        }

        return "redirect:/";
    }
}
