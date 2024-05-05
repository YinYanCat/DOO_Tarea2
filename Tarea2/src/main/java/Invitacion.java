import java.time.Instant;
import java.util.ArrayList;

public class Invitacion {
    private Instant hora;
    private ArrayList<Empleado> listaInvitados;
    public void agregarInvitado(Empleado invitado) {
        listaInvitados.add(invitado);
    }

}
