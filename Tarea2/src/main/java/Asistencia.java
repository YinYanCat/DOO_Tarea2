import java.time.Instant;
import java.util.ArrayList;

public class Asistencia {
    private Empleado asistente;
    private Instant horaInvitacion;
    public Asistencia(Invitacion invitado) {
        asistente = invitado.getEmpleado();
        horaInvitacion = invitado.getHora();
    }
    public Empleado getEmpleado() {
        return asistente;
    }
    public Instant getHora() {
        return horaInvitacion;
    }
}
