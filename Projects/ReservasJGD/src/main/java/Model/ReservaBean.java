package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ReservaBean implements Serializable {
    private String fechaInicio;
    private String fechaFin;
    private Integer numPersonas;
    private ArrayList<String> servicios = new ArrayList<>();

    public ReservaBean() {}

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getNumPersonas() {
        return numPersonas;
    }

    public void setNumPersonas(Integer numPersonas) {
        this.numPersonas = numPersonas;
    }

    public ArrayList<String> getServicios() {
        return servicios;
    }

    public void setServicios(ArrayList<String> servicios) {
        this.servicios = servicios;
    }

    @Override
    public String toString() {
        return "ReservaBean{" +
                "fechaInicio='" + fechaInicio + '\'' +
                ", fechaFin='" + fechaFin + '\'' +
                ", numPersonas=" + numPersonas +
                ", servicios=" + servicios.toString() +
                '}';
    }
}
