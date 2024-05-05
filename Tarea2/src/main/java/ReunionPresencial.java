import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class ReunionPresencial extends Reunion {
    public ReunionPresencial(Date fecha, Instant hora, Duration duracion) {
        super(fecha, hora, duracion);
    }
    private String sala;
}
