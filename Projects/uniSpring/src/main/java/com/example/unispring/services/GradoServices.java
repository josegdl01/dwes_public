package com.example.unispring.services;

import com.example.unispring.models.Grado;

import java.util.List;
import java.util.Optional;

public interface GradoServices {
    public Optional<Grado> getGradoById(Integer id);
    public List<Grado> getAllGrados();
}
