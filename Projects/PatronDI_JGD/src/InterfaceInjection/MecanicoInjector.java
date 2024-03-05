package InterfaceInjection;

import Maquinaria.Locomotora;
import Personal.Mecanico;
import Personal.MecanicoAndaluz;

public class MecanicoInjector {
    public Locomotora mecanicoInjector(){
        Mecanico mecanico = new MecanicoAndaluz("Mecánico inyectado",23456789, Mecanico.Especialidad.FRENOS);
        Locomotora locomotora = new Locomotora(mecanico,"EST-98123",200, 1975);
        return locomotora;
    }
}
