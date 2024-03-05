package velazquez.entregablefinaljgd.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import velazquez.entregablefinaljgd.models.Asignatura;
import velazquez.entregablefinaljgd.models.Grado;
import velazquez.entregablefinaljgd.models.Profesor;
import velazquez.entregablefinaljgd.services.AsignaturasServiceImpl;
import velazquez.entregablefinaljgd.services.GradosServiceImpl;
import velazquez.entregablefinaljgd.services.ProfesoresServiceImpl;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    ProfesoresServiceImpl profServ;

    @Autowired
    GradosServiceImpl gradosServ;


    @GetMapping("/")
    public String index(Model model){
        //PARA USER
        List<Profesor> profesores = profServ.getAllProfesores();
        model.addAttribute("profesores", profesores);

        //PARA ADMIN
        List<Grado> grados = gradosServ.getAllGrados();
        model.addAttribute("grados", grados);

        return "index";
    }


}
