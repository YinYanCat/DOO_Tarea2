import java.time.ZoneOffset;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Informacion {
    public String listaAsistenciaNombres(ArrayList<Asistencia> listaAsistencia) {
        String listaEmpleados = "";
        for (int i = 0; i < listaAsistencia.size(); i++) {
            Asistencia asistente = listaAsistencia.get(i);
            String hora = asistente.getHora().atZone(ZoneOffset.UTC).toLocalTime().toString();
            listaEmpleados = listaEmpleados+"\n- "+(asistente.getEmpleado().getNombreComp()+" ["+hora+"]");
        }
        return listaEmpleados;
    }
    public String listaInvitadosNombres(ArrayList<Invitacion> listaInvitados) {
        String listaEmpleados = "";
        for (int i = 0; i < listaInvitados.size(); i++) {
            Invitacion invitado = listaInvitados.get(i);
            String hora = invitado.getHora().atZone(ZoneOffset.UTC).toLocalTime().toString();
            listaEmpleados = listaEmpleados+"\n- "+(invitado.getEmpleado().getNombreComp()+" ["+hora+"]");
        }
        return listaEmpleados;
    }
    public void printNombresAsistentes(ArrayList<Asistencia> listaAsistencia, String str) {
        System.out.print(str);
        for (int i = 0; i < listaAsistencia.size(); i++) {
            System.out.print(" " + listaAsistencia.get(i).getEmpleado().getNombreComp());
            if(i!= listaAsistencia.size()-1){
                System.out.print(",");
            }
        }
        System.out.println();
    }

    public void printNombresInvitados(ArrayList<Invitacion> listaInvitados, String str) {
        System.out.print(str);
        for (int i = 0; i < listaInvitados.size(); i++) {
            System.out.print(" "+listaInvitados.get(i).getEmpleado().getNombreComp());
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
            myWriter.write(reunion.getTiemposPrevistos()+"\n\n"+reunion.getTiemposReunion()+"\n");
            myWriter.write("Duración total: "+reunion.calcularTiempoReal()*60+" minutos"+"\n");
            myWriter.write(reunion.getInfoReunion()+"\n"+reunion.getLugar()+"\n\n");
            myWriter.write("Asistencias [Hora envio invitación (UTC)]:"+listaAsistenciaNombres(reunion.obtenerAsistencias())+"\n\n");
            myWriter.write("Retrasos [Hora de llegada (UTC)]:"+listaAsistenciaNombres(reunion.obtenerRetrasos())+"\n\n");
            myWriter.write("Ausencias [Hora envio invitación (UTC)]:"+listaInvitadosNombres(reunion.obtenerAusencias())+"\n\n");
            myWriter.write("Notas de la Reunión:"+reunion.getNota().getContenido());
            myWriter.close();
            System.out.println("Informe de reunión creado en: "+nombre+".txt");
        } catch (IOException e) {
            System.out.println("Error al crear informe de reunión");
            e.printStackTrace();
        }
    }
}
