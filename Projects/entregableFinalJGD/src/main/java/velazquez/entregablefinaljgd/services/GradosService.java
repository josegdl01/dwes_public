package velazquez.entregablefinaljgd.services;

import velazquez.entregablefinaljgd.models.Grado;

import java.util.List;

public interface GradosService {
    public List<Grado> getAllGrados();
    public Grado getGradoById(Integer id);
}
