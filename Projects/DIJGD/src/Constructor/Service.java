package Constructor;

public class Service {
    private int id;
    private String name;

    public Service(int id, String name){
        this.id = id;
        this.name = name;
    }

    public String getName(){
        return "Hola, soy servicio " +this.id;
    }
}
