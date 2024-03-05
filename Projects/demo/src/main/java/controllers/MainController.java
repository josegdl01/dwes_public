package controllers;

import models.Alumno;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    private final Logger log = LoggerFactory.getLogger(MainController.class);

    @GetMapping("/")
    public String homeGet(Model modelo){
        log.info("INDEX GET");
        modelo.addAttribute("paramGet", "INICIO");
        return "index";
    }

    @PostMapping("/")
    public String homePost(Model modelo){
        log.info("INDEX POST");
        modelo.addAttribute("paramPost", "INICIO");
        return "index";
    }

    @RequestMapping("/asignaturas")
    public String asig(Model model){
        log.info("ASIGNATURAS");
        model.addAttribute("param", "valor");
        return "/asignaturas";
    }
}
