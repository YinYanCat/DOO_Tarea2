import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Informacion {
    public String listaAsistenciaNombres(ArrayList<Asistencia> listaAsistencia) {
        String listaEmpleados = "";
        for (int i = 0; i < listaAsistencia.size(); i++) {
            listaEmpleados = listaEmpleados+" "+(listaAsistencia.get(i).getEmpleado().getNombre());
            if(i!= listaAsistencia.size()-1){
                listaEmpleados = listaEmpleados+",";
            }
        }
        return listaEmpleados;
    }
    public String listaInvitadosNombres(ArrayList<Invitacion> listaInvitados) {
        String listaEmpleados = "";
        for (int i = 0; i < listaInvitados.size(); i++) {
            listaEmpleados = listaEmpleados+" "+(listaInvitados.get(i).getEmpleado().getNombre());
            if(i!= listaInvitados.size()-1){
                listaEmpleados = listaEmpleados+",";
            }
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

    public void crearArchivoTXT(String nombre) {
        try {
            File myObj = new File(nombre+".txt");
            if (myObj.createNewFile()) {
                System.out.println("Archivo creado: "+myObj.getName());
            } else {
                System.out.println("Archivo ya existente");
            }
        } catch (IOException e) {
            System.out.println("Error al crear archivo.txt");
            e.printStackTrace();
        }
    }

    public void crearInformeReunion(Reunion reunion, String nombre) {
        crearArchivoTXT(nombre);
        try {
            FileWriter myWriter = new FileWriter(nombre+".txt");
            myWriter.write(reunion.getTiemposPrevistos()+"\n\n");
            myWriter.write(reunion.getTiemposReunion()+"\n");
            myWriter.write("Duración total: "+reunion.calcularTiempoReal()+"\n");
            myWriter.write(reunion.getInfoReunion()+"\n");
            myWriter.write(reunion.getLugar()+"\n\n");
            //Asistentes
            myWriter.write("Asistencias:"+listaAsistenciaNombres(reunion.obtenerAsistencias())+"\n");
            //Retrasos(+horas (Agregar))
            myWriter.write("Retrasos:"+listaAsistenciaNombres(reunion.obtenerRetrasos())+"\n");
            //Ausentes
            myWriter.write("Ausencias:"+listaInvitadosNombres(reunion.obtenerAusencias())+"\n\n");
            myWriter.write(reunion.getNota().getContenido());
            myWriter.close();
            System.out.println("Informe de reunión creado en: "+nombre+".txt");
        } catch (IOException e) {
            System.out.println("Error al crear informe de reunión");
            e.printStackTrace();
        }
    }
}
