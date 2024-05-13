import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class ReunionVirtual extends Reunion {
    private String enlace;
    public ReunionVirtual(Date fecha, Instant hora, Duration duracion, Empleado org, tipoReunion miTipo, String enlace) {
        super(fecha, hora, duracion, org, miTipo);
        this.enlace = enlace;
    }
    public String getLugar() {
        return "Enlace: "+enlace;
    }
}
