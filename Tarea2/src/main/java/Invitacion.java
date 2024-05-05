import java.time.Instant;
import java.util.ArrayList;

public class Invitacion {
    private Instant hora;
    private ArrayList<Empleado> listaInvitados;

    public Invitacion(Instant hora) {
        listaInvitados =  new ArrayList<>();
        this.hora = hora;
    }
    public void agregarInvitado(Empleado invitado) {
        listaInvitados.add(invitado);
    }
}
