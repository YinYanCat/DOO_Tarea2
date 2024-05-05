import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class ReunionVirtual extends Reunion {
    public ReunionVirtual(Date fecha, Instant hora, Duration duracion) {
        super(fecha, hora, duracion);
    }
    private String enlace;
}
