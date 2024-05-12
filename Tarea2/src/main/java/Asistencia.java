import java.time.Instant;
import java.util.ArrayList;

public class Asistencia {
    private Empleado asistente;
    public Asistencia(Empleado invitado) {
        asistente = invitado;
    }
    public Empleado getEmpleado() {
        return asistente;
    }
}
