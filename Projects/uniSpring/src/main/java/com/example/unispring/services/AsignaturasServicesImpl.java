package com.example.unispring.services;

import com.example.unispring.models.Asignatura;
import com.example.unispring.repositories.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AsignaturasServicesImpl implements AsignaturasServices {

    @Autowired AsignaturaRepository repository;

    @Override
    public List<Asignatura> getAllAsignaturas() {
        List<Asignatura> asignaturas = repository.findAll();

        if(asignaturas != null && asignaturas.size() > 0){
            return asignaturas;
        }

        return new ArrayList<Asignatura>();
    }

    @Override
    public Optional<Asignatura> findAsignaturaById(Integer id) {
        Optional<Asignatura> asignatura = null;

        if(id != null){
            asignatura = repository.findById(id);
        }

        return asignatura;
    }

    @Override
    public List<Asignatura> findAsignaturasByGrado(Integer idGrado) {
        List<Asignatura> asignaturas = repository.findAsignaturasByIdGrado(idGrado);

        if(idGrado != null && asignaturas != null && !asignaturas.isEmpty()){
            return asignaturas;
        }

        return new ArrayList<Asignatura>();
    }
}
