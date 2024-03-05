package velazquez.entregablefinaljgd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import velazquez.entregablefinaljgd.models.Grado;
import velazquez.entregablefinaljgd.repositories.GradosRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class GradosServiceImpl implements GradosService {

  @Autowired GradosRepository gradosRep;

  @Override
  public List<Grado> getAllGrados() {
    List<Grado> grados = gradosRep.findAll();

    if (grados != null && !grados.isEmpty()) {
      return grados;
    }

    return new ArrayList<>();
  }

  @Override
  public Grado getGradoById(Integer id) {
    Grado grado = null;
    grado = gradosRep.getReferenceById(id);

    return grado;
  }
}
