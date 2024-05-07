import java.lang.reflect.Array;
import java.time.Instant;
import java.util.ArrayList;

public class Retraso extends Asistencia {
    private ArrayList<Instant> horas;
    public Retraso() {
        super();
        horas = new ArrayList<>();
    }
    public void addHora(Instant hora) {
        horas.add(hora);
    }
}
