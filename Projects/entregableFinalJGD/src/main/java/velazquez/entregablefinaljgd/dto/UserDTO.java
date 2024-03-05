package velazquez.entregablefinaljgd.dto;

import java.util.Objects;

public class UserDTO {
    private Integer id;
    private String nombre;
    private String apellidos;
    private String email;
    private String usuario;
    private String password;
    private String role;
    private boolean activo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDTO userDTO)) return false;
        return activo == userDTO.activo && Objects.equals(id, userDTO.id) && Objects.equals(nombre, userDTO.nombre) && Objects.equals(apellidos, userDTO.apellidos) && Objects.equals(email, userDTO.email) && Objects.equals(usuario, userDTO.usuario) && Objects.equals(password, userDTO.password) && Objects.equals(role, userDTO.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellidos, email, usuario, password, role, activo);
    }
}
