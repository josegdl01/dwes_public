package com.example.unispring.controllers;

import com.example.unispring.models.Grado;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GradoController {

    @GetMapping("grados/asignaturas")
    public String gradoAsig(@RequestParam(required = false, name = "grad") Model model, String grad){

        Grado grado = new Grado();
        model.addAttribute("grado", grado);

        return "gradoAsig";
    }
}
