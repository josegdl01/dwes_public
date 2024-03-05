package Personal;

public class Maquinista {
    private String nombre;
    private String dni;
    private double sueldoMensual;
    private String rango;

    public Maquinista(String nombre, String dni, double sueldoMensual, String rango) {
        this.nombre = nombre;
        this.dni = dni;
        this.sueldoMensual = sueldoMensual;
        this.rango = rango;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public double getSueldoMensual() {
        return sueldoMensual;
    }

    public void setSueldoMensual(double sueldoMensual) {
        this.sueldoMensual = sueldoMensual;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    @Override
    public String toString() {
        return "Maquinista{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", sueldoMensual=" + sueldoMensual +
                ", rango='" + rango + '\'' +
                '}';
    }
}
