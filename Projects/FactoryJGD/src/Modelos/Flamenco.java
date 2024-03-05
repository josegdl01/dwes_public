package Modelos;

import Factory.ElementoAndaluz;

public class Flamenco implements ElementoAndaluz {
    @Override
    public String describir() {
        return "Flamenco";
    }

    public String toString(){
        return "Representa el cante y el baile flamenco";
    }
}
