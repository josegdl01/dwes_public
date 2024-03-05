package main;

import misc.Misc;
import org.apache.log4j.Logger;

public class Main {
    final static Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args){
        log.info("Logger antes de llamar a ningún método.");
        int resultado = Misc.sumar(3,2);

        log.info("Logger antes de llamar a restar.");
        resultado = Misc.restar(9,4);

        log.info("Logger al acabar.");


    }
}
