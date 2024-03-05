package Personal;

public abstract class Mecanico {

    public enum Especialidad {FRENOS, HIDRAULICA};

    private String nombre;
    private long tlf;
    private Especialidad especialidad;

    public Mecanico(String nombre, long tlf, Especialidad especialidad) {
        this.nombre = nombre;
        this.tlf = tlf;
        this.especialidad = especialidad;
    }

    public Mecanico() {
        this.nombre = "Mecánico";
        this.tlf = 12334565;
        this.especialidad = Especialidad.FRENOS;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getTlf() {
        return tlf;
    }

    public void setTlf(long tlf) {
        this.tlf = tlf;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public abstract String acento();
}
