package velazquez.entregablefinaljgd.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import velazquez.entregablefinaljgd.dto.AlumnoAsignaturaDTO;
import velazquez.entregablefinaljgd.models.Alumno;
import velazquez.entregablefinaljgd.models.AlumnoAsignatura;
import velazquez.entregablefinaljgd.models.Asignatura;
import velazquez.entregablefinaljgd.services.AlumnoAsignaturaServiceImpl;
import velazquez.entregablefinaljgd.services.AlumnoServiceImpl;
import velazquez.entregablefinaljgd.services.AsignaturasServiceImpl;

@Controller
public class EstudiantesController {

    private final Logger log = LoggerFactory.getLogger(EstudiantesController.class);

    @Autowired

    AlumnoAsignaturaServiceImpl alsServ;
    @Autowired
    AsignaturasServiceImpl asServ;
    @Autowired
    AlumnoServiceImpl alServ;

    @GetMapping("/estudiantes/editarnota")
    public String editarNota(@RequestParam(required = false, name = "id") String id, @RequestParam(required = false, name = "as") String as, Model model) {
        AlumnoAsignatura als = alsServ.getAlumnoAsignaturaByIds(Integer.parseInt(id), Integer.parseInt(as));
        AlumnoAsignaturaDTO alsDTO = new AlumnoAsignaturaDTO(als.getAlumno(), als.getAsignatura(), als.getNota());

        model.addAttribute("als", alsDTO);

        return "editarNota";
    }

    @PostMapping("/estudiantes/editarnota")
    public String editarNotaPost(@ModelAttribute(name = "nota") String nota, @ModelAttribute(name = "idAl") String idAl, @ModelAttribute(name = "idAs") String idAs) {
        Alumno al = alServ.getAlumnoById(Integer.parseInt(idAl));
        Asignatura as = asServ.getAsigById(Integer.parseInt(idAs));

        AlumnoAsignatura alsIns = new AlumnoAsignatura(al,as,Integer.parseInt(nota));

        alsServ.updateAlumnoAsigantura(alsIns);

        return "redirect:/";
    }
}
