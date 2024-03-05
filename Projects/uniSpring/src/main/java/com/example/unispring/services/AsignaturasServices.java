package com.example.unispring.services;

import com.example.unispring.models.Asignatura;

import java.util.List;
import java.util.Optional;

public interface AsignaturasServices {

    public List<Asignatura> getAllAsignaturas();
    public Optional<Asignatura> findAsignaturaById(Integer id);
    public List<Asignatura> findAsignaturasByGrado(Integer idGrado);
}
