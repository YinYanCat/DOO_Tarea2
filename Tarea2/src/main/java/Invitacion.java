import java.awt.image.AreaAveragingScaleFilter;
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

    public ArrayList<Empleado> getAusencia(ArrayList asistencia) {
        ArrayList<Empleado> ausencia = new ArrayList<>();
        for(int i=0; i<listaInvitados.size(); i++) {
            Empleado invitado = listaInvitados.get(i);
            for(int j=0; i<asistencia.size(); j++) {
                if(invitado == asistencia.get(j)) {
                    ausencia.add(invitado);
                }
            }
        }
        return ausencia;
    }
}
