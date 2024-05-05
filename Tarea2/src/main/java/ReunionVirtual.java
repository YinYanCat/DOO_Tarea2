import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class ReunionVirtual extends Reunion {

    private String enlace;
    public ReunionVirtual(Date fecha, Instant hora, Duration duracion, Empleado org, String enlace) {
        super(fecha, hora, duracion, org);
        this.enlace = enlace;
    }

}
