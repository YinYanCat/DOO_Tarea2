
/** Una inferfaz para invitar al alguien o algo (Empleados y/o departamentos) a una reunión
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public interface Invitable {

    /** Método para invitar a alguien o algo a una reunión
     * @param reunion La reunión a la que está invitado el alguien o algo
     * @throws EmpleadoYaInvitadoException Se lanza esta excepción si el alguien o algo ya fue invitado */
    public void invitar(Reunion reunion) throws Exception;
}
