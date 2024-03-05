package InterfaceInjection;

import Maquinaria.Tren;

public class Main {
    public static void main(String[] args) {
        MaquinistaInjector maquinistaInjector = new MaquinistaInjector();
        LocomotoraInjector locomotoraInjector = new LocomotoraInjector();
        VagonesInjector vagonesInjector = new VagonesInjector();

        System.out.println(maquinistaInjector.inyectarMaquinista().getMaquinista().toString());
        System.out.println(locomotoraInjector.locomotoraInjector().getLocomotora().toString());
        System.out.println(vagonesInjector.vagonesInjector().getVagones().toString());
    }
}
