import java.time.Instant;
import java.util.ArrayList;

public class Asistencia {
    private Empleado asistente;
    public Asistencia(Empleado asistente) {
        this.asistente = asistente;
    }
    public Empleado getAsistente() {
        return asistente;
    }
}
