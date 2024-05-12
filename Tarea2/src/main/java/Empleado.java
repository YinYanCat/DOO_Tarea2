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
    public void invitar(Reunion reunion) {
        reunion.agregarInvitado(this);
    }
    public String getNombre() {
        return nombre;
    }
}
