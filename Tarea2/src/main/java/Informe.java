import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/** Un informe que contiene información sobre una reunión, no contiene constructor
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class Informe {

    /** Método para convertir una lista de asistencias en un String de nombres de los empleados y horas
     * @param listaAsistencia La lista de asistencias que contienen empleados
     * @return El String de los nombres y las horas guardadas en las asistencias, separadas por líneas  */
    public String listaAsistenciaNombres(ArrayList<Asistencia> listaAsistencia) {
        String listaEmpleados = "";
        for (int i = 0; i < listaAsistencia.size(); i++) {
            Asistencia asistente = listaAsistencia.get(i);
            String hora = toStringHoraCLT(asistente.getHoraInvitacion());
            listaEmpleados = listaEmpleados+"\n- "+(asistente.getEmpleado().toString()+" ["+hora+"]");
        }
        return listaEmpleados;
    }

    /** Método para convertir una lista de retrasos en un String de nombres de los empleados y horas
     * @param listaAsistencia La lista de retrasos que contienen empleados
     * @return El String de los nombres y las horas de llegada a la reunión, separadas por líneas  */
    public String listaRetrasosNombres(ArrayList<Retraso> listaAsistencia) {
        String listaEmpleados = "";
        for (int i = 0; i < listaAsistencia.size(); i++) {
            Retraso asistente = listaAsistencia.get(i);
            String hora = toStringHoraCLT(asistente.getHoraRetraso());
            listaEmpleados = listaEmpleados+"\n- "+(asistente.getEmpleado().toString()+" ["+hora+"]");
        }
        return listaEmpleados;
    }

    /** Método para convertir una lista de invitaciones en un String de nombres de los empleados y horas
     * @param listaInvitados La lista de invitaciones que contienen empleados
     * @return El String de los nombres y las horas guardadas en las invitaciones, separadas por líneas */
    public String listaInvitadosNombres(ArrayList<Invitacion> listaInvitados) {
        String listaEmpleados = "";
        for (int i = 0; i < listaInvitados.size(); i++) {
            Invitacion invitado = listaInvitados.get(i);
            String hora = toStringHoraCLT(invitado.getHora());
            listaEmpleados = listaEmpleados+"\n- "+(invitado.getEmpleado().toString()+" ["+hora+"]");
        }
        return listaEmpleados;
    }

    /** Método para convertir un instante en un String con la hora entregada en la zona horaria de Chile
     * @param hora El instante con la hora a convertir
     * @return El String con la hora cambiada de la zona horaria UTC a CLT */
    public String toStringHoraCLT(Instant hora) {
        LocalDateTime now = LocalDateTime.now();
        ZoneId zone = ZoneId.of("America/Santiago");
        ZoneOffset zoneOffSet = zone.getRules().getOffset(now);
        return hora.atZone(zoneOffSet).toLocalTime().toString();
    }

    /** Método para crear un archivo de texto a partir de un nombre
     * @param nombre El nombre del archivo de texto, el propio método agrega ".txt" al nombre
     * @throws IOException Se lanza esta excepción si hay un error al crear el archivo de texto */
    public void crearArchivoTXT(String nombre) throws IOException {
        File myObj = new File(nombre+".txt");
        if (myObj.createNewFile()) {
            System.out.println("Archivo creado: "+myObj.getName());
        } else {
            System.out.println("Archivo "+myObj.getName()+" ya existente");
        }
    }

    /** Método para crear un archivo de texto a partir de un nombre
     * @param reunion La reunión de donde se obtendrá la información para crear el informe
     * @param nombre El nombre del archivo de texto, al crear el archivo el método agrega ".txt" al nombre
     * @throws IOException Se lanza esta excepción si hay un error al crear el archivo de texto */
    public void crearInformeReunion(Reunion reunion, String nombre) throws IOException {
        crearArchivoTXT(nombre);
        try {
            String txtPrev = "Fecha: " + reunion.getFecha().toString()  + "\nHora Prevista: " + toStringHoraCLT(reunion.getHoraPrevista());
            txtPrev = txtPrev + "\nDuración Prevista: " + reunion.getDuracionPrevista().getSeconds() / 60 + " minutos";
            String txtDatos = "Hora de Inicio: " + toStringHoraCLT(reunion.getHoraInicio()) + "\nHora de finalización: " + toStringHoraCLT(reunion.getHoraFin());
            txtDatos = txtDatos + "\nDuración: " + reunion.calcularTiempoReal() * 60 + " minutos";
            txtDatos = txtDatos + "\nTipo de Reunión: " + reunion.getTipo()  + "\nOrganizador: " + reunion.getOrganizador().toString();
            String txtPart = "Asistencias [Hora envio invitación]:" + listaAsistenciaNombres(reunion.obtenerAsistencias());
            txtPart = txtPart + "\n\nRetrasos [Hora de llegada]:" + listaRetrasosNombres(reunion.obtenerRetrasos());
            txtPart = txtPart + "\n\nAusencias [Hora envio invitación]:" + listaInvitadosNombres(reunion.obtenerAusencias());

            FileWriter myWriter = new FileWriter(nombre+".txt");
            myWriter.write("Informe de Reunión\n\n"+txtPrev+"\n\n"+txtDatos+"\n"+reunion.getTipoLugar()+": "+reunion.getLugar()+"\n\n");
            myWriter.write(txtPart+"\n\nAsistencia Total: "+reunion.obtenerTotalAsistencia()+"/");
            myWriter.write(reunion.obtenerTotalInvitacion()+" | "+reunion.obtenerPorcentajeAsistencia()+"%\n\n");
            myWriter.write("Notas de la Reunión:"+reunion.getNota().getContenido());
            myWriter.close();
            System.out.println("Informe de la reunión creado en: "+nombre+".txt");
        } catch (IOException e) {
            System.out.println("Error al crear el informe de reunión");
            e.printStackTrace();
        }
    }
}