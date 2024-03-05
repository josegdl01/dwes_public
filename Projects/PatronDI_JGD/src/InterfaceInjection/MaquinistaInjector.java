package InterfaceInjection;

import Maquinaria.Locomotora;
import Maquinaria.Tren;
import Maquinaria.Vagon;
import Personal.Maquinista;
import Personal.Mecanico;

public class MaquinistaInjector {
    public Tren inyectarMaquinista(){
        Maquinista  maquinista = new Maquinista("Maquinista Inyectado","12345678K",1450,"Alto");
        Tren tren = new Tren();
        tren.setMaquinista(maquinista);
        return tren;
    }
}
