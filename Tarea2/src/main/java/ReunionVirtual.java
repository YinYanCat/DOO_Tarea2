import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class ReunionVirtual extends Reunion {

    private String enlace;
    public ReunionVirtual(Date fecha, Instant hora, Duration duracion, String enlace) {
        super(fecha, hora, duracion);
        this.enlace = enlace;
    }

}git
