package com.example.unispring.controllers;


import com.example.unispring.models.Asignatura;
import com.example.unispring.services.AsignaturasServicesImpl;
import com.example.unispring.services.GradoServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {

    @Autowired AsignaturasServicesImpl asignaturasServices;

    @Autowired GradoServicesImpl gradoServices;

    @GetMapping("/main")
    public String home(Model modelo){
        modelo.addAttribute("param", "valorIndex");

        return "index";
    }

    @GetMapping("/asig")
    public String asig(Model modelo){
        List<Asignatura> asignaturas = asignaturasServices.getAllAsignaturas();
        modelo.addAttribute("asignaturas", asignaturas);

        return "asignaturas";
    }


}
