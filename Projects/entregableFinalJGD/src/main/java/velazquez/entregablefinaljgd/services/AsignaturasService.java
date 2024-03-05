package velazquez.entregablefinaljgd.services;

import velazquez.entregablefinaljgd.models.Asignatura;
import velazquez.entregablefinaljgd.models.Profesor;

import java.util.List;

public interface AsignaturasService {

    public List<Asignatura> getAsigByProf(Profesor prof);
    public Asignatura getAsigById(Integer id);
}
