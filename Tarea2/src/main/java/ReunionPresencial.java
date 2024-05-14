import java.time.Duration;
import java.time.Instant;
import java.util.Date;

/** Una reunión de tipo presencial donde pueden asistir empleados a una sala
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class ReunionPresencial extends Reunion {

    /** Sala de la reunión */
    private String sala;

    /** Constructor para crear una reunión presencial y guardar la información relevante de la misma
     * @param fecha La fecha de la reunión presencial
     * @param hora La hora de inicio prevista de la reunión presencial
     * @param duracion La duración prevista de la reunión presencial
     * @param org El empleado organizador de la reunión presencial
     * @param miTipo El tipo de reunión presencial
     * @param sala La sala de la reunión presencial */
    public ReunionPresencial(Date fecha, Instant hora, Duration duracion, Empleado org, tipoReunion miTipo, String sala) {
        super(fecha, hora, duracion, org, miTipo);
        this.sala=sala;
    }

    /** Método abstracto para obtener la sala de la reunión
     * @return La sala de la reunión, junto con un texto diciendo "Sala: "*/
    public String getLugar() {
        return "Sala: "+sala;
    }
}
