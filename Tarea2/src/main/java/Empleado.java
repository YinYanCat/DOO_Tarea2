import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class Empleado implements Invitable {
    private String id;
    private String apellidos;
    private String nombre;
    private String correo;

    public Empleado(String nombre, String ape, String id, String correo) {
        this.id = id;
        this.correo = correo;
        this.nombre = nombre;
        this.apellidos = ape;
    }

    public void invitar(Invitacion invitacion) {
        invitacion.agregarInvitado(this);
    }

    public Reunion organizarReunion(int tipo, Date fecha, Instant hora, Duration duracion, String location){

        switch(tipo){

            case 0:
                return new ReunionPresencial(fecha, hora, duracion, location);

            case 1:
                return new ReunionVirtual(fecha, hora, duracion, location);

            default:
                return null;


        }
    }
}
