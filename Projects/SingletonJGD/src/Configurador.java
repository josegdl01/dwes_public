public class Configurador {
    private static Configurador conf = null;
    private String configuracion;

    private Configurador() {
        this.configuracion = "Configuración";
    }

    public static Configurador obtenerInstancia(){
        if (conf == null){
            conf = new Configurador();
        } else {
      System.out.println("Ya existe una instancia de esta clase");
        }
        return conf;
    }

    public String getConfiguracion() {
        return configuracion;
    }

    public void setConfiguracion(String configuracion) {
        this.configuracion = configuracion;
    }
}
