public class Test {
public static void main(String[] args){
    System.out.println("CREAMOS EL PRIMER CONFIGURADOR\n");
    Configurador conf = Configurador.obtenerInstancia();

    System.out.println("INTENTAMOS CREAR EL SEGUNDO CONFIGURADOR");
    Configurador conf2 = Configurador.obtenerInstancia();

    System.out.println("\nESTABLECEMOS UNA CONFIGURACIÓN Y LA IMPRIMIMOS");
    conf.setConfiguracion("Configuración establecida por usuario");
    System.out.println(conf.getConfiguracion());

}
}
