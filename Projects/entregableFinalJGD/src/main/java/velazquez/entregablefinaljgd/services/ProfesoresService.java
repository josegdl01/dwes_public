package velazquez.entregablefinaljgd.services;

import velazquez.entregablefinaljgd.models.Profesor;

import java.util.List;

public interface ProfesoresService {
    public List<Profesor> getAllProfesores();
    public Profesor getProfesorById(Integer id);
    public Profesor insertProfesor(Profesor profe);
    public void deleteProfesor(Profesor profe);
    public Profesor updateProfesor(Profesor profe);
}
