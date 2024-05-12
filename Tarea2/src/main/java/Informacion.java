import java.util.ArrayList;

public class Informacion {
    public ArrayList<Empleado> cnvAsistenciaAEmpleados(ArrayList<Asistencia> listaAsistencia) {
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        for (int i = 0; i < listaAsistencia.size(); i++) {
            listaEmpleados.add(listaAsistencia.get(i).getEmpleado());
        }
        return listaEmpleados;
    }

    public ArrayList<Empleado> cnvInvitadosAEmpleados(ArrayList<Invitacion> listaInvitados) {
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        for (int i = 0; i < listaInvitados.size(); i++) {
            listaEmpleados.add(listaInvitados.get(i).getEmpleado());
        }
        return listaEmpleados;
    }

    public void printNombresAsistentes(ArrayList<Asistencia> listaAsistencia, String str) {
        System.out.print(str);
        for (int i = 0; i < listaAsistencia.size(); i++) {
            System.out.print(" " + listaAsistencia.get(i).getEmpleado().getNombre());
            if(i!= listaAsistencia.size()-1){
                System.out.print(",");
            }
        }
        System.out.println();
    }

    public void printNombresInvitados(ArrayList<Invitacion> listaInvitados, String str) {
        System.out.print(str);
        for (int i = 0; i < listaInvitados.size(); i++) {
            System.out.print(" "+listaInvitados.get(i).getEmpleado().getNombre());
            if(i!= listaInvitados.size()-1){
                System.out.print(",");
            }
        }
        System.out.println();
    }

    public void printRegistroReunion(Reunion reunion) {
        System.out.println("[T.Asis]:, " + reunion.obtenerTotalAsistencia() + " | " + reunion.obtenerPorcentajeAsistencia() + "%");
        printNombresAsistentes(reunion.obtenerAsistencias(), "[Asist.]:");
        printNombresAsistentes(reunion.obtenerRetrasos(), "[Retra.]:");
        printNombresInvitados(reunion.obtenerAusencias(), "[Ausen.]:");
        System.out.println();
    }
}
