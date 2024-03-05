package com.example.unispring.controllers;

import com.example.unispring.models.Asignatura;
import com.example.unispring.models.Grado;
import com.example.unispring.services.AsignaturasServicesImpl;
import com.example.unispring.services.GradoServicesImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class GradosController {

    Logger log = LoggerFactory.getLogger(GradosController.class);

    @Autowired
    AsignaturasServicesImpl asignaturasServices;

    @Autowired
    GradoServicesImpl gradoServices;

    @GetMapping("/grado")
    public String getGrado(Model modelo){
        List<Grado> grados = gradoServices.getAllGrados();
        log.info(grados.toString());
        modelo.addAttribute("grados", grados);
        return "grados";
    }

    @GetMapping("/grado/asig")
    public String gradoAsig(@RequestParam(required = false, name = "id") String id, Model modelo){

        if (id == null) {
            return "redirect:/grado";
        }

        List<Asignatura> asignaturas = asignaturasServices.findAsignaturasByGrado(Integer.parseInt(id));
        log.info(asignaturas.toString());
        modelo.addAttribute("asignaturas",asignaturas);

        return "gradoAsig";
    }
}
