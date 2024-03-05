package Maquinaria;

import Personal.Mecanico;

public class Locomotora {
    private Mecanico mecanicoEncargado;
    private String matricula;
    private double potencia;
    private int anyoFabricacion;

    //Inyección por constructor
    public Locomotora(Mecanico mecanicoEncargado, String matricula, double potencia, int anyoFabricacion) {
        this.mecanicoEncargado = mecanicoEncargado;
        this.matricula = matricula;
        this.potencia = potencia;
        this.anyoFabricacion = anyoFabricacion;
    }

    public Locomotora() {
    }

    public Mecanico getMecanicoEncargado() {
        return mecanicoEncargado;
    }

    public void setMecanicoEncargado(Mecanico mecanicoEncargado) {
        this.mecanicoEncargado = mecanicoEncargado;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public int getAnyoFabricacion() {
        return anyoFabricacion;
    }

    public void setAnyoFabricacion(int anyoFabricacion) {
        this.anyoFabricacion = anyoFabricacion;
    }

    @Override
    public String toString() {
        return "Locomotora{" +
                "mecanicoEncargado=" + mecanicoEncargado +
                ", matricula='" + matricula + '\'' +
                ", potencia=" + potencia +
                ", anyoFabricacion=" + anyoFabricacion +
                '}';
    }
}
