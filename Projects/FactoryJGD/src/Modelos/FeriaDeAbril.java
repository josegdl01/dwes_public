package Modelos;

import Factory.ElementoAndaluz;

public class FeriaDeAbril implements ElementoAndaluz {
    @Override
    public String describir() {
        return "FeriaDeAbril";
    }

    public String toString(){
        return "Representa la famosa feria de Sevilla.";
    }
}
