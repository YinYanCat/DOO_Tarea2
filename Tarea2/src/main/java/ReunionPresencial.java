import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class ReunionPresencial extends Reunion {

    private String sala;
    public ReunionPresencial(Date fecha, Instant hora, Duration duracion, String sala) {
        super(fecha, hora, duracion);
        this.sala=sala;
    }

}
