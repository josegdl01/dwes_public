package Constructor;

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        Service service = new Service(1, "cosas");
        client.setService(service);
        client.saludar();
    }
}
