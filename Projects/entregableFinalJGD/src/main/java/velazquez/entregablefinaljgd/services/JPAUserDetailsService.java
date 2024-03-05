package velazquez.entregablefinaljgd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import velazquez.entregablefinaljgd.models.Usuarios;
import velazquez.entregablefinaljgd.models.JPAUserDetails;
import velazquez.entregablefinaljgd.repositories.JPAUserDetailsRepository;

@Service
public class JPAUserDetailsService implements UserDetailsService {

    @Autowired
    JPAUserDetailsRepository userRep;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuarios usuarios = userRep.findUsuariosByUsuario(username);
        if(usuarios == null){
            throw new UsernameNotFoundException("No se ha encontrado al usuario: "+username);
        }

        JPAUserDetails userDetails = new JPAUserDetails(usuarios);

        return userDetails;
    }
}
