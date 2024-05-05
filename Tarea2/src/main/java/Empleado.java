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
}
