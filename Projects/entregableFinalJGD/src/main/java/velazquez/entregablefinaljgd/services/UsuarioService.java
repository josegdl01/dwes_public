package velazquez.entregablefinaljgd.services;

import velazquez.entregablefinaljgd.models.Usuarios;

import java.util.List;

public interface UsuarioService {
    public Usuarios addUsuario(Usuarios user);
    public List<Usuarios> getAllUsuarios();
    public void deleteUsuario(Usuarios usuarios);
    public Usuarios getUsuarioById(Integer id);
}
