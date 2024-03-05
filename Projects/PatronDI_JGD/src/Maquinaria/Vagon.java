package Maquinaria;

public class Vagon {
    private double capacidadMaxima;
    private double cargaPuntual;
    private String tipoMercancia;

    protected Vagon(double capacidadMaxima, double cargaPuntual, String tipoMercancia) {
        this.capacidadMaxima = capacidadMaxima;
        this.cargaPuntual = cargaPuntual;
        this.tipoMercancia = tipoMercancia;
    }

    protected Vagon() {
        this.capacidadMaxima = 0;
        this.cargaPuntual = 0;
        this.tipoMercancia = "Mercancía";
    }
    public double getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(double capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public double getCargaPuntual() {
        return cargaPuntual;
    }

    public void setCargaPuntual(double cargaPuntual) {
        this.cargaPuntual = cargaPuntual;
    }

    public String getTipoMercancia() {
        return tipoMercancia;
    }

    public void setTipoMercancia(String tipoMercancia) {
        this.tipoMercancia = tipoMercancia;
    }
}
