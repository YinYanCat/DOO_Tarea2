import java.time.Instant;

/** Un documento creado cuando un empleado asiste a una reunión, el cúal guarda información del empleado
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class Asistencia {

    /** Empleado que asiste a la reunión, esto incluye su información personal */
    private Empleado asistente;

    /** Hora en la cúal se envió la invitación al empleado (también contiene la fecha) */
    private Instant horaInvitacion;

    /** Constructor para crear y rellenar la asistencia con la información necesaria
     * @param invitado El empleado que asiste a la reunión en la que fue invitado */
    public Asistencia(Invitacion invitado) {
        asistente = invitado.getEmpleado();
        horaInvitacion = invitado.getHora();
    }

    /** Método para obtener el empleado, y su información personal, que asiste a la reunión
     * @return El empleado guardado que asiste a la reunión */
    public Empleado getEmpleado() {
        return asistente;
    }

    /** Método para obtener la hora en la cúal se envió la invitación al asistente
     * @return La hora del envio de la invitación; al ser un instante de tiempo, tambien contiene la fecha */
    public Instant getHoraInvitacion() {
        return horaInvitacion;
    }
}
