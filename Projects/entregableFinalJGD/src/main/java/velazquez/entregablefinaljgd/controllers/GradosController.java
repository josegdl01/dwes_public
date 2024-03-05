package velazquez.entregablefinaljgd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import velazquez.entregablefinaljgd.models.AlumnoAsignatura;
import velazquez.entregablefinaljgd.models.Grado;
import velazquez.entregablefinaljgd.services.AlumnoAsignaturaServiceImpl;
import velazquez.entregablefinaljgd.services.AsignaturasServiceImpl;
import velazquez.entregablefinaljgd.services.GradosServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GradosController {

  @Autowired GradosServiceImpl gradosServ;
  @Autowired AsignaturasServiceImpl asigServ;
  @Autowired
  AlumnoAsignaturaServiceImpl alsigServ;
  @GetMapping("/grados/estudiantes")
  public String gradosMat(@RequestParam(required = false, name = "id") String id, Model model){

    List<AlumnoAsignatura> alsig = alsigServ.getAllAlumnoAsignatura();
    List<AlumnoAsignatura> alsigGrad = new ArrayList<>();

    for(AlumnoAsignatura als : alsig){
      if(als.getAsignatura().getGrado().getId() == Integer.parseInt(id)){

        alsigGrad.add(als);
      }
    }

    Grado grado = gradosServ.getGradoById(Integer.parseInt(id));
    String gradoName = grado.getNombre();

    model.addAttribute("grado",gradoName);
    model.addAttribute("alsig",alsigGrad);

    return "gradosMat";
  }
}
