package com.example.unispring.services;

import com.example.unispring.models.JPAUserDetails;
import com.example.unispring.models.Usuarios;
import com.example.unispring.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JPAUserDetailsService implements UserDetailsService {

    @Autowired UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuarios usuarios = usuarioRepository.findByUsuario(username);
        if(usuarios == null){
            throw new UsernameNotFoundException("No se ha encontrado al usuario: "+username);
        }

        JPAUserDetails userDetails = new JPAUserDetails(usuarios);

        return userDetails;
    }
}
