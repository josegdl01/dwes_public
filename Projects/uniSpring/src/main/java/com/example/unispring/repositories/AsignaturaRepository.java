package com.example.unispring.repositories;

import com.example.unispring.models.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura, Integer> {
    public List<Asignatura> findAsignaturasByIdGrado(Integer idGrado);
}
