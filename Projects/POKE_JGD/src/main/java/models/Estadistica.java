package models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Estadistica implements Serializable {
    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Pokemon pokemon;
    @Column(name = "peso")
    private double peso;
    @Column(name = "altura")
    private double altura;
    @Column(name = "ps")
    private int ps;
    @Column(name = "ataque")
    private int ataque;
    @Column(name = "defensa")
    private int defensa;
    @Column(name = "ataque Especial")
    private int atEspecial;
    @Column(name = "defensa Especial")
    private int dfEspecial;
    @Column(name = "velocidad")
    private int velocidad;

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

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

    public int getPs() {
        return ps;
    }

    public void setPs(int ps) {
        this.ps = ps;
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

    public int getDfEspecial() {
        return dfEspecial;
    }

    public void setDfEspecial(int dfEspecial) {
        this.dfEspecial = dfEspecial;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    @Override
    public String toString() {
        return "Estadistica{" +
                "pokemon=" + pokemon +
                ", peso=" + peso +
                ", altura=" + altura +
                ", ps=" + ps +
                ", ataque=" + ataque +
                ", defensa=" + defensa +
                ", atEspecial=" + atEspecial +
                ", dfEspecial=" + dfEspecial +
                ", velocidad=" + velocidad +
                '}';
    }
}
