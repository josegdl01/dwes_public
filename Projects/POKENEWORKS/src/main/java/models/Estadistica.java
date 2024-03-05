package models;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
public class Estadistica implements Serializable {

    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Pokemon pokemon;
    @Column(name = "Peso")
    private double peso;
    @Column(name = "Altura")
    private double altura;
    @Column(name = "Ataque")
    private int ataque;
    @Column(name = "Defensa")
    private int defensa;
    @Column(name = "Ataque_Especial")
    private int atEspecial;
    @Column(name = "Defensa_Especial")
    private int defEspecial;
    @Column(name = "Velocidad")
    private int velocidad;

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getAtEspecial() {
        return atEspecial;
    }

    public void setAtEspecial(int atEspecial) {
        this.atEspecial = atEspecial;
    }

    public int getDefEspecial() {
        return defEspecial;
    }

    public void setDefEspecial(int defEspecial) {
        this.defEspecial = defEspecial;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
}
