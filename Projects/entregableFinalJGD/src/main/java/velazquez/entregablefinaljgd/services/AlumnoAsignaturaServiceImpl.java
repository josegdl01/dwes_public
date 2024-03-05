package velazquez.entregablefinaljgd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import velazquez.entregablefinaljgd.models.Alumno;
import velazquez.entregablefinaljgd.models.AlumnoAsignatura;
import velazquez.entregablefinaljgd.models.Asignatura;
import velazquez.entregablefinaljgd.repositories.AlumnoAsignaturaRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlumnoAsignaturaServiceImpl implements AlumnoAsignaturaService{

    @Autowired
    AlumnoAsignaturaRepository alSigRep;

    @Override
    public List<AlumnoAsignatura> getAllAlumnoAsignatura() {
        List<AlumnoAsignatura> alSig = alSigRep.findAll();

        if(alSig != null && !alSig.isEmpty()){
            return alSig;
        }

        return new ArrayList<>();
    }

    @Override
    public AlumnoAsignatura getAlumnoAsignaturaByIds(Integer al, Integer as) {
        AlumnoAsignatura als = null;

        if(al != null && as != null){
            als = alSigRep.getAlumnoAsignaturaByAlumno_IdAndAsignatura_Id(al, as);
        }

        return als;
    }

    @Override
    public AlumnoAsignatura updateAlumnoAsigantura(AlumnoAsignatura als) {
        AlumnoAsignatura alsIns = null;

        if(als != null){
            alsIns = alSigRep.save(als);
        }

        return alsIns;
    }
}
