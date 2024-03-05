package velazquez.entregablefinaljgd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import velazquez.entregablefinaljgd.models.Usuarios;
import velazquez.entregablefinaljgd.repositories.JPAUserDetailsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    JPAUserDetailsRepository userRep;

    @Override
    public Usuarios addUsuario(Usuarios user) {
        Usuarios userIns = null;
        if(user != null){
            userIns = userRep.save(user);
        }

        return userIns;
    }

    @Override
    public List<Usuarios> getAllUsuarios() {
        List<Usuarios> usuarios = userRep.findAll();

        if(usuarios != null && !usuarios.isEmpty()){
            return usuarios;
        }

        return new ArrayList<>();
    }

    @Override
    public void deleteUsuario(Usuarios usuarios) {
        if(usuarios != null){
            userRep.delete(usuarios);
        }
    }

    @Override
    public Usuarios getUsuarioById(Integer id) {
        Usuarios usuario = null;

        if(id != null){
            usuario = userRep.getReferenceById(id);
        }

        return usuario;
    }
}
