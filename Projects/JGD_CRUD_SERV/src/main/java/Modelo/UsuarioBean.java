package Modelo;

import java.io.Serializable;

public class UsuarioBean implements Serializable {
    private String name;
    private String email;
    private String role;
    private String pass;

    public UsuarioBean() {}

    public UsuarioBean(String name, String email, String pass, String role) {
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "UsuarioDAO{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
