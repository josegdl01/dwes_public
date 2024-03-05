package Personal;

public class MecanicoCatalan extends Mecanico{
    public MecanicoCatalan(String nombre, long tlf, Especialidad especialidad) {
        super(nombre, tlf, especialidad);
    }

    public MecanicoCatalan() {
    }

    @Override
    public String acento() {
        return "Este mecánico tiene acento catalán";
    }
}
