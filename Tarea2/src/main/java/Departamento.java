import java.util.ArrayList;

public class Departamento implements Invitable {
    private String nombre;
    private ArrayList<Empleado> listaEmpleados;

    public void invitar(Invitacion invitacion){
        for(int i=0; i<listaEmpleados.size(); i++) {
            invitacion.agregarInvitado(listaEmpleados.get(i));
        }
    }
    public int obtenerCantidadEmpleados(){
        return listaEmpleados.size();
    }
}
