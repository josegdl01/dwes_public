package velazquez.models;

import velazquez.dao.generic.Identifiable;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Estadistica implements Identifiable {

    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPokemon")
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

    @Override
    public Long getId() {
        return pokemon.getId();
    }

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

    @Override
    public String toString() {
        return "Estadistica{" +
                "pokemon=" + pokemon +
                ", peso=" + peso +
                ", altura=" + altura +
                ", ataque=" + ataque +
                ", defensa=" + defensa +
                ", atEspecial=" + atEspecial +
                ", defEspecial=" + defEspecial +
                ", velocidad=" + velocidad +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Estadistica)) return false;
        Estadistica that = (Estadistica) o;
        return Double.compare(peso, that.peso) == 0 && Double.compare(altura, that.altura) == 0 && ataque == that.ataque && defensa == that.defensa && atEspecial == that.atEspecial && defEspecial == that.defEspecial && velocidad == that.velocidad && Objects.equals(pokemon, that.pokemon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pokemon, peso, altura, ataque, defensa, atEspecial, defEspecial, velocidad);
    }
}
