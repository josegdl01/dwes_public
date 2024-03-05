package Personal;

public class MecanicoAndaluz extends Mecanico{

    public MecanicoAndaluz(String nombre, long tlf, Especialidad especialidad) {
        super(nombre, tlf, especialidad);
    }

    public MecanicoAndaluz() {
    }

    @Override
    public String acento() {
        return "Este mecánico tiene acento andaluz";
    }
}
