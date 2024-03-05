package Models;

import java.io.Serializable;

public class EmpleadoBean implements Serializable {
    private String id;
    private String apellidos;
    private String nombre;
    private String extension;
    private String email;
    private String puesto;
    private String oficina;
    private String jefe;

    public EmpleadoBean(String id, String apellidos, String nombre,String extension,String email, String puesto, String oficina, String jefe) {
        this.id = id;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.extension = extension;
        this.email = email;
        this.puesto = puesto;
        this.oficina = oficina;
        this.jefe = jefe;
    }

    public EmpleadoBean() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getOficina() {
        return oficina;
    }

    public void setOficina(String oficina) {
        this.oficina = oficina;
    }

    public String getJefe() {
        return jefe;
    }

    public void setJefe(String jefe) {
        this.jefe = jefe;
    }

    @Override
    public String toString() {
        return "EmpleadoBean{" +
                "id='" + id + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", nombre='" + nombre + '\'' +
                ", puesto='" + puesto + '\'' +
                ", oficina='" + oficina + '\'' +
                ", jefe='" + jefe + '\'' +
                '}';
    }
}
