public class Empleado implements Invitable {
    private String id;
    private String apellidos;
    private String nombre;
    private String correo;

    public void invitar(Invitacion invitacion) {
        invitacion.agregarInvitado(this);
    }
}
