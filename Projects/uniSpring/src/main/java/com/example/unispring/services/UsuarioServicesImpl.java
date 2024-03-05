package com.example.unispring.services;

import com.example.unispring.models.Usuarios;
import com.example.unispring.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicesImpl implements UsuarioService{

    @Autowired UsuarioRepository usuarioRepository;

    @Override
    public Usuarios addUsuario(Usuarios usuario) {
        if(usuario != null){
            return usuarioRepository.save(usuario);
        }
        return null;
    }
}
