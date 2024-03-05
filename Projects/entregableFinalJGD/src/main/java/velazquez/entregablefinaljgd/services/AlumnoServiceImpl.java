package velazquez.entregablefinaljgd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import velazquez.entregablefinaljgd.models.Alumno;
import velazquez.entregablefinaljgd.repositories.AlumnoRepository;

@Service
public class AlumnoServiceImpl implements AlumnoService{

    @Autowired
    AlumnoRepository alsRep;

    @Override
    public Alumno getAlumnoById(Integer id) {
        Alumno al = null;

        if(id != null){
            al = alsRep.getReferenceById(id);
        }

        return al;
    }
}
