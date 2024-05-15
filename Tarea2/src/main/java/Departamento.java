import java.util.ArrayList;

/** Un departamento el cuál contiene empleados y puede ser invitado a una reunión
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class Departamento implements Invitable {

    /** Nombre del departamento */
    private String nombre;

    /** Lista de los empleados que trabajan en el departamento */
    private ArrayList<Empleado> listaEmpleados;

    /** Constructor para crear un departamento y entregarle un nombre
     * @param nombre El nombre del departamento */
    public Departamento(String nombre) {
        this.nombre = nombre;
        listaEmpleados = new ArrayList<>();
    }

    /** Método para contratar y asignar un empleado al departamento
     * @param empleado El empleado que es contratado y asignado al departamento */
    public void contratar(Empleado empleado) {
        listaEmpleados.add(empleado);
    }

    /** Método para invitar a el departamento completo a una reunión
     * @param reunion La reunión a la que está invitado el departamento
     * @throws EmpleadoYaInvitadoException Se lanza esta excepción si el departamento o uno de sus empleados ya fue invitado */
    public void invitar(Reunion reunion) throws Exception {
        for(int i=0; i<listaEmpleados.size(); i++) {
            reunion.agregarInvitado(listaEmpleados.get(i));
        }
    }

    /** Método para obtener el nombre del departamento
     * @return El nombre del departamento */
    public String getNombre(){
        return nombre;
    }

    /** Método para obtener la lista de empleados pretenecientes al departamento
     * @return La lista de empleados que pertenecen al departamento */
    public ArrayList<Empleado> getEmpleados(){
        return listaEmpleados;
    }

    /** Método para devolver la cantidad de empleados que trabajan en el departamento
     * @return La cantidad de empleados que trabajan en el departamento */
    public int getCantidadEmpleados(){
        return listaEmpleados.size();
    }

    /** Método para obtener los datos internos de la clase Departamento
     * @return Un texto con la información del departamento y los empleados del mismo */
    public String toString() {
        String empleadosInfo = "";
        for(int i=0; i<listaEmpleados.size(); i++) {
            empleadosInfo = empleadosInfo+listaEmpleados.get(i).toString()+"\n";
        }
        return "Nombre: "+nombre+"\nEmpleados:\n"+empleadosInfo;
    }
}
