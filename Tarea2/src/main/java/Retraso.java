import java.time.Instant;

public class Retraso extends Asistencia {
    private Instant hora;
    public Retraso(Empleado asistente, Instant hora) {
        super(asistente);
    }
}
