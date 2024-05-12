import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class ReunionPresencial extends Reunion {

    private String sala;
    public ReunionPresencial(Date fecha, Instant hora, Duration duracion, Empleado org, tipoReunion miTipo, String sala) {
        super(fecha, hora, duracion, org, miTipo);
        this.sala=sala;
    }
}
