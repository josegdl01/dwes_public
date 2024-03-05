package velazquez.entregablefinaljgd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import velazquez.entregablefinaljgd.models.Profesor;
import velazquez.entregablefinaljgd.repositories.ProfesoresRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfesoresServiceImpl implements ProfesoresService{

    @Autowired ProfesoresRepository profRep;

    @Override
    public List<Profesor> getAllProfesores() {
        List<Profesor> profesores = profRep.findAll();

        if(profesores != null && !profesores.isEmpty()){
            return profesores;
        }

        return new ArrayList<>();
    }

    @Override
    public Profesor getProfesorById(Integer id) {

        Profesor profesor = null;

        if(id != null){
            profesor = profRep.getReferenceById(id);
        }
        return profesor;
    }

    @Override
    public Profesor insertProfesor(Profesor prof) {
        Profesor profesor = null;
        if(prof != null){
            profesor = profRep.save(prof);
        }

        return profesor;
    }

    @Override
    public void deleteProfesor(Profesor profe) {profRep.delete(profe);}

    @Override
    public Profesor updateProfesor(Profesor profe) {
        Profesor profesor = null;
        if(profe != null){
            profesor = profRep.save(profe);
        }

        return profesor;
    }
}
