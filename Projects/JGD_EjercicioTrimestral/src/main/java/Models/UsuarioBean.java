package Models;

import java.io.Serializable;

public class UsuarioBean implements Serializable {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String role;
    private String pass;

    public UsuarioBean() {}

    public UsuarioBean(String username, String firstName, String lastName, String pass, String email, String role) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.pass = pass;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
                "name='" + username + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}

