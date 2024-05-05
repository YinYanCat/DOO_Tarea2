import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class ReunionPresencial extends Reunion {

    private String sala;
    public ReunionPresencial(Date fecha, Instant hora, Duration duracion, Empleado org, String sala) {
        super(fecha, hora, duracion, org);
        this.sala=sala;
    }
}
