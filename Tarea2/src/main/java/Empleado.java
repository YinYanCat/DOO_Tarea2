
/** Un empleado de un departamento el cuál puede ser invitado a una reunión
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class Empleado implements Invitable {

    /** Nombre del empleado */
    private String nombre;

    /** Apellidos del empleado */
    private String apellidos;

    /** ID (Identificador) del empleado */
    private String id;

    /** Correo electrónico del empleado*/
    private String correo;

    /** Constructor para crear un perfil de empleado y rellenarlo con su información personal y su departamento
     * @param nombre El nombre del empleado
     * @param apellidos Los apellidos del empleado
     * @param id El ID (Identificador) del empleado
     * @param correo El correo electrónico del empleado
     * @param depto El departamento asignado al empleado */
    public Empleado(String nombre, String apellidos, String id, String correo, Departamento depto) {
        this.id = id;
        this.correo = correo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        depto.contratar(this);
    }

    /** Método para invitar al empleado a una reunión
     * @param reunion La reunión a la que está invitado el empleado
     * @throws EmpleadoYaInvitadoException Se lanza esta excepción si el empleado ya fue invitado */
    public void invitar(Reunion reunion) throws Exception {
        reunion.agregarInvitado(this);
    }

    /** Método para obtener el nombre del empleado
     * @return El nombre del empleado */
    public String getNombre() {
        return nombre;
    }

    /** Método para obtener los apellidos del empleado
     * @return Los apellidos del empleado */
    public String getApellidos() {
        return apellidos;
    }

    /** Método para obtener el ID (Identificador) del empleado
     * @return El ID del empleado */
    public String getID() {
        return id;
    }

    /** Método para obtener el correo electrónico del empleado
     * @return El correo electrónico del empleado */
    public String getCorreo() {
        return correo;
    }

    /** Método para obtener los datos internos de la clase Empleado
     * @return Un texto con la información del empleado */
    public String toString() {
        return nombre+" "+apellidos+" | "+id+" | "+correo;
    }
}
