package Factory;

import Modelos.FeriaDeAbril;
import Modelos.Flamenco;
import Modelos.Gazpacho;

public class AndaluciaFactory extends ElementoAndaluzFactory{
    @Override
    public ElementoAndaluz createElementoAndaluz(String nombre){

        if(nombre.equalsIgnoreCase("FeriaDeAbril")){
            return new FeriaDeAbril();
        } else if (nombre.equalsIgnoreCase("Gazpacho")){
            return new Gazpacho();
        } else if (nombre.equalsIgnoreCase("Flamenco")){
            return new Flamenco();
        }
        return null;
    }
}
