import java.awt.image.AreaAveragingScaleFilter;
import java.time.Instant;
import java.util.ArrayList;

public class Invitacion {
    private Empleado invitado;
    private Instant horaInvitacion;
    public Invitacion(Empleado empleado, Instant hora) {
        invitado = empleado;
        horaInvitacion = hora;
    }
    public Empleado getEmpleado() {
        return invitado;
    }
    public Instant getHora() {
        return horaInvitacion;
    }
}
