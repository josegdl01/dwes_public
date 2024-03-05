package com.example.unispring.repositories;

import com.example.unispring.models.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios, Integer> {
    Usuarios findByUsuario(String username);
}
