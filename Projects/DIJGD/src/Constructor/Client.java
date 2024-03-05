package Constructor;

public class Client {

    private Service service = null;

    public Client(Service service) {
        this.service = service;

    }

    public Client() {
        this.service = null;

    }

    public void setService(Service service){
        this.service = service;
    }

    public void saludar(){
        System.out.println("Hola, soy un servicio sin DI.");
    }
}
