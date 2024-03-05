package Modelos;

import Factory.ElementoAndaluz;

public class Gazpacho implements ElementoAndaluz {
    @Override
    public String describir() {
        return "Gazpacho";
    }

    public String toString(){
        return "Representa el plato típico andaluz, el gazpacho.";
    }
}
