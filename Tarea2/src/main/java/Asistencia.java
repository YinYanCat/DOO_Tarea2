import java.time.Instant;
import java.util.ArrayList;

public class Asistencia {
    private ArrayList<Empleado> listaAsistencia;
    public Asistencia() {
        listaAsistencia =  new ArrayList<>();
    }
    public void addAsistente(Empleado invitado) {
        listaAsistencia.add(invitado);
    }
    public ArrayList<Empleado> getAsistencia() {
        return listaAsistencia;
    }
}
