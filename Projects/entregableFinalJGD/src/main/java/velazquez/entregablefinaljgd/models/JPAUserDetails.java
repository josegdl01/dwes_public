package velazquez.entregablefinaljgd.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import velazquez.entregablefinaljgd.models.Usuarios;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JPAUserDetails implements UserDetails {

    private final String usuario;
    private final String password;
    private final boolean activo;
    private final List<GrantedAuthority> authorityList;

    public JPAUserDetails(Usuarios usuarios) {
        this.usuario = usuarios.getUsuario();
        this.password = usuarios.getPassword();
        this.activo = usuarios.isActivo();
        this.authorityList = new ArrayList<>();
        this.authorityList.add(new SimpleGrantedAuthority(usuarios.getRole()));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorityList;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.usuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.activo;
    }
}