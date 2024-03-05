package velazquez.entregablefinaljgd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import velazquez.entregablefinaljgd.models.Asignatura;
import velazquez.entregablefinaljgd.models.Profesor;
import velazquez.entregablefinaljgd.repositories.AsignaturasRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AsignaturasServiceImpl implements AsignaturasService{

    @Autowired
    AsignaturasRepository asigRep;

    @Override
    public List<Asignatura> getAsigByProf(Profesor prof) {
        List<Asignatura> asigs = asigRep.getAsignaturasByProfesor(prof);

        if(asigs != null && !asigs.isEmpty()){
            return asigs;
        }

        return new ArrayList<>();
    }

    @Override
    public Asignatura getAsigById(Integer id) {
        Asignatura as = null;

        if(id != null){
            as = asigRep.getReferenceById(id);
        }

        return as;
    }
}
