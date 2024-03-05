package InterfaceInjection;

import Maquinaria.Locomotora;
import Maquinaria.Tren;
import Personal.Mecanico;
import Personal.MecanicoAndaluz;

public class LocomotoraInjector {
    public Tren locomotoraInjector(){
        Locomotora locomotora = new Locomotora(new MecanicoAndaluz(),"Matricula inyectada",500,1965);
        Tren tren = new Tren();
        tren.setLocomotora(locomotora);

        return tren;
    }
}
