package models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Usuarios implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "activo", nullable = false)
    private byte activo;
    @Basic
    @Column(name = "apellidos", nullable = false, length = 255)
    private String apellidos;
    @Basic
    @Column(name = "email", nullable = false, length = 255)
    private String email;
    @Basic
    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;
    @Basic
    @Column(name = "password", nullable = false, length = 255)
    private String password;
    @Basic
    @Column(name = "role", nullable = false, length = 255)
    private String role;
    @Basic
    @Column(name = "usuario", nullable = false, length = 255)
    private String usuario;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte getActivo() {
        return activo;
    }

    public void setActivo(byte activo) {
        this.activo = activo;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuarios usuarios = (Usuarios) o;

        if (id != usuarios.id) return false;
        if (activo != usuarios.activo) return false;
        if (apellidos != null ? !apellidos.equals(usuarios.apellidos) : usuarios.apellidos != null) return false;
        if (email != null ? !email.equals(usuarios.email) : usuarios.email != null) return false;
        if (nombre != null ? !nombre.equals(usuarios.nombre) : usuarios.nombre != null) return false;
        if (password != null ? !password.equals(usuarios.password) : usuarios.password != null) return false;
        if (role != null ? !role.equals(usuarios.role) : usuarios.role != null) return false;
        if (usuario != null ? !usuario.equals(usuarios.usuario) : usuarios.usuario != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) activo;
        result = 31 * result + (apellidos != null ? apellidos.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (usuario != null ? usuario.hashCode() : 0);
        return result;
    }
}
