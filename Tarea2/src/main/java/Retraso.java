import java.time.Instant;

/** Un documento creado cuando un empleado asiste tarde a una reunión, el cúal guarda información del empleado
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class Retraso extends Asistencia {

    /** Hora en la cúal el asistente llega, de forma tardía, a la reunión */
    private Instant horaLlegada;

    /** Constructor para crear y rellenar la asistencia tardia con la información necesaria
     * @param invitado El empleado invitado a la reunión que asiste a la misma
     * @param hora La hora en la cuál el empleado llega a la reunión */
    public Retraso(Invitacion invitado, Instant hora) {
        super(invitado);
        horaLlegada = hora;
    }

    /** Método para obtener la hora en la cúal el asistente llega a la reunión
     * @return La hora en la que el asistente llega a la reunión de forma tardía */
    public Instant getHoraRetraso() {
        return horaLlegada;
    }

    /** Método para obtener los datos internos de la clase Retraso
     * @return Un texto con la información del asistente y la hora donde se envió su invitación y la hora de llegada */
    public String toString() {
        Informe cnv = new Informe();
        return super.toString()+" | Hora de llegada: "+cnv.toStringHoraCLT(horaLlegada);
    }
}
