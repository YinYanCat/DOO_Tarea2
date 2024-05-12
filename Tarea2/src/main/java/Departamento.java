import java.util.ArrayList;

public class Departamento implements Invitable {
    private String nombre;
    private ArrayList<Empleado> listaEmpleados;

    public Departamento(String nombre) {
        this.nombre = nombre;
        listaEmpleados = new ArrayList<>();
    }
    public void contratar(Empleado empleado) {
        listaEmpleados.add(empleado);
    }
    public void invitar(Reunion reunion) {
        for(int i=0; i<listaEmpleados.size(); i++) {
            reunion.agregarInvitado(listaEmpleados.get(i));
        }
    }
    public int obtenerCantidadEmpleados(){
        return listaEmpleados.size();
    }
}
