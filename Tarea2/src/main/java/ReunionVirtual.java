import java.time.Duration;
import java.time.Instant;
import java.util.Date;

/** Una reunión de tipo virtual donde pueden asistir empleados a un enlace
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class ReunionVirtual extends Reunion {

    /** Enlace de la reunión virtual */
    private String enlace;

    /** Constructor para crear una reunión virtual y guardar la información relevante de la misma
     * @param fecha La fecha de la reunión virtual
     * @param hora La hora de inicio prevista de la reunión virtual
     * @param duracion La duración prevista de la reunión virtual
     * @param org El empleado organizador de la reunión virtual
     * @param miTipo El tipo de reunión virtual
     * @param enlace El enlace de la reunión virtual */
    public ReunionVirtual(Date fecha, Instant hora, Duration duracion, Empleado org, TipoReunion miTipo, String enlace) {
        super(fecha, hora, duracion, org, miTipo);
        this.enlace = enlace;
    }

    /** Método para obtener el enlace de la reunión virtual
     * @return El enlace de la reunión virtual" */
    public String getLugar() {
        return enlace;
    }

    /** Método para obtener el tipo de lugar donde se realizará la reunión
     * @return El texto "Enlace" "*/
    public String getTipoLugar() {
        return "Enlace";
    }

    /** Método para obtener los datos internos de la clase ReunionVirtual
     * @return Un texto con la información de la reunión y su enlace */
    @Override
    public String toString() {
        return super.toString()+"\nEnlace: "+enlace;
    }
}
