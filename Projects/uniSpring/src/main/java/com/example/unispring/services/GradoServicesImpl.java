package com.example.unispring.services;

import com.example.unispring.models.Grado;
import com.example.unispring.repositories.GradoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GradoServicesImpl implements GradoServices{

    @Autowired GradoRepository repository;

  @Override
  public Optional<Grado> getGradoById(Integer id) {
    Optional<Grado> grado = null;

    if (id != null) {
      grado = repository.findById(id);
    }
    return grado;
    }

  @Override
  public List<Grado> getAllGrados() {
    List<Grado> grados = repository.findAll();

    if(!grados.isEmpty() && grados != null){
      return grados;
    }
    return new ArrayList<Grado>();
  }
}
