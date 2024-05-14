import java.time.Instant;

/** Un documento creado cuando un empleado es invitado a una reunión, el cúal guarda información del empleado
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class Invitacion {

    /** Empleado invitado a la reunión, esto incluye su información personal */
    private Empleado invitado;

    /** Hora en la cúal se envió la invitación al empleado (también contiene la fecha) */
    private Instant horaInvitacion;

    /** Constructor para crear y rellenar la invitación con la información necesaria
     * @param empleado El empleado invitado a la reunión
     * @param hora La hora del envio de la invitación */
    public Invitacion(Empleado empleado, Instant hora) {
        invitado = empleado;
        horaInvitacion = hora;
    }

    /** Método para devolver el empleado, y su información personal, invitado a la reunión
     * @return El empleado guardado que es invitado a la reunión */
    public Empleado getEmpleado() {
        return invitado;
    }

    /** Método para devolver la hora en la cúal se envió la invitación al empleado
     * @return La hora del envio de la invitación; al ser un instante de tiempo, tambien contiene la fecha */
    public Instant getHora() {
        return horaInvitacion;
    }
}
