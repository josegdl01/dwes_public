package misc;

import main.Main;
import org.apache.log4j.Logger;

public class Misc {
    final static Logger log = Logger.getLogger(Main.class);

    public static int sumar(int sum1, int sum2){
        log.info("Iniciando sumar");
        int suma = sum1 + sum2;
        log.error("Error");
        return suma;
    }

    public static int restar(int sum1, int sum2){
        log.info("Iniciando restar");
        int resta = sum1 - sum2;
        log.info("Resta realizada con éxito");
        return resta;
    }
}
