package Maquinaria;

import Personal.Maquinista;

public class Tren {
    private Locomotora locomotora;
    private Vagon[] vagones = new Vagon[5];
    private Maquinista maquinista;

    //Inyección por constructor
    public Tren(Locomotora locomotora, Vagon[] vagones, Maquinista maquinista) {
        this.locomotora = locomotora;
        this.vagones = vagones;
        this.maquinista = maquinista;
    }

    public Tren() {
    }

    public Locomotora getLocomotora() {
        return locomotora;
    }

    public void setLocomotora(Locomotora locomotora) {
        this.locomotora = locomotora;
    }

    public Vagon[] getVagones() {
        return vagones;
    }

    public void setVagones(Vagon[] vagones) {
        this.vagones = vagones;
    }

    public Maquinista getMaquinista() {
        return maquinista;
    }

    public void setMaquinista(Maquinista maquinista) {
        this.maquinista = maquinista;
    }

    public String toString(){
        return "Tren compuesto por " +this.vagones.length+ " vagones, y dirigido por el maquinista " +this.maquinista.getNombre()+"." +
                "La matrícula de la locomotora es: " +this.locomotora.getMatricula();
    }
}
