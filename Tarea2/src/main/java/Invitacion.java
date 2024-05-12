import java.awt.image.AreaAveragingScaleFilter;
import java.time.Instant;
import java.util.ArrayList;

public class Invitacion {
    private Instant horaInvitacion;
    private Empleado invitado;
    public Invitacion(Empleado empleado, Instant hora) {
        invitado = empleado;
        horaInvitacion = hora;
    }
    public Empleado getEmpleado() {
        return invitado;
    }
}
