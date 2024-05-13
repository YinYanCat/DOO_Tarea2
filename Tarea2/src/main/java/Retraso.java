import java.lang.reflect.Array;
import java.time.Instant;
import java.util.ArrayList;

public class Retraso extends Asistencia {
    private Instant horaLlegada;
    public Retraso(Invitacion invitado, Instant hora) {
        super(invitado);
        horaLlegada = hora;
    }
    public Instant getHora() {
        return horaLlegada;
    }
}
