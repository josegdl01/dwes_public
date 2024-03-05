package velazquez.entregablefinaljgd.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import velazquez.entregablefinaljgd.models.Asignatura;
import velazquez.entregablefinaljgd.models.Profesor;
import velazquez.entregablefinaljgd.services.AsignaturasServiceImpl;
import velazquez.entregablefinaljgd.services.ProfesoresServiceImpl;

import java.util.List;

@Controller
public class ProfesoresController {

    private final Logger log = LoggerFactory.getLogger(ProfesoresController.class);

    @Autowired
    ProfesoresServiceImpl profServ;
    @Autowired
    AsignaturasServiceImpl asigServ;
    @GetMapping("/profesores/asignaturas")
    public String profAsig(@RequestParam(required = false, name = "id") String id, Model model) {

        Profesor prof = profServ.getProfesorById(Integer.parseInt(id));
        String nombreProf = prof.getNombre();
        List<Asignatura> asigs = asigServ.getAsigByProf(prof);

        log.info("Listado de asignaturas por profesor " + asigs.toString());

        model.addAttribute("asigs", asigs);
        model.addAttribute("nombre", nombreProf);

        return "profAsig";
    }
}
