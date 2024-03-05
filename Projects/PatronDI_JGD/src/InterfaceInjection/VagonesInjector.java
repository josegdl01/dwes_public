package InterfaceInjection;

import Maquinaria.Tren;
import Maquinaria.Vagon;

public class VagonesInjector {
    public Tren vagonesInjector(){
        Vagon[] vagones = new Vagon[5];
        Tren tren = new Tren();
        tren.setVagones(vagones);
        return tren;
    }
}
