import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Informe {
    public String listaAsistenciaNombres(ArrayList<Asistencia> listaAsistencia) {
        String listaEmpleados = "";
        for (int i = 0; i < listaAsistencia.size(); i++) {
            Asistencia asistente = listaAsistencia.get(i);
            String hora = toStringHoraCLT(asistente.getHora());
            listaEmpleados = listaEmpleados+"\n- "+(asistente.getEmpleado().getNombreCompleto()+" ["+hora+"]");
        }
        return listaEmpleados;
    }
    public String listaInvitadosNombres(ArrayList<Invitacion> listaInvitados) {
        String listaEmpleados = "";
        for (int i = 0; i < listaInvitados.size(); i++) {
            Invitacion invitado = listaInvitados.get(i);
            String hora = toStringHoraCLT(invitado.getHora());
            listaEmpleados = listaEmpleados+"\n- "+(invitado.getEmpleado().getNombreCompleto()+" ["+hora+"]");
        }
        return listaEmpleados;
    }

    public String toStringHoraCLT(Instant hora) {
        LocalDateTime now = LocalDateTime.now();
        ZoneId zone = ZoneId.of("America/Santiago");
        ZoneOffset zoneOffSet = zone.getRules().getOffset(now);
        return hora.atZone(zoneOffSet).toLocalTime().toString();
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
            String sFecha = "Fecha: " + reunion.getFecha().toString();
            String sHoraPrev = "Hora Prevista: " + toStringHoraCLT(reunion.getHoraPrevista());
            String sDuraPrev = "Duración Prevista: " + reunion.getDuracionPrevista().getSeconds() / 60 + " minutos";
            String sHoraIni = "Hora de Inicio: " + toStringHoraCLT(reunion.getHoraInicio());
            String sHoraFin = "Hora de finalización: " + toStringHoraCLT(reunion.getHoraFin());
            String sDura = "Duración: " + reunion.calcularTiempoReal() * 60 + " minutos";
            String sOrg = "Organizador: " + reunion.getOrganizador().getNombreCompleto();
            String sAsis = "Asistencias [Hora envio invitación]:" + listaAsistenciaNombres(reunion.obtenerAsistencias());
            String sRet = "Retrasos [Hora de llegada]:" + listaAsistenciaNombres(reunion.obtenerRetrasos());
            String sAus = "Ausencias [Hora envio invitación]:" + listaInvitadosNombres(reunion.obtenerAusencias());

            FileWriter myWriter = new FileWriter(nombre+".txt");
            myWriter.write(sFecha+"\n"+sHoraPrev+"\n"+sDuraPrev+"\n\n");
            myWriter.write(sHoraIni+"\n"+sHoraFin+"\n"+sDura+"\n");
            myWriter.write("Tipo de Reunión: " + reunion.getTipo()+"\n"+sOrg+"\n"+reunion.getLugar()+"\n\n");
            myWriter.write(sAsis+"\n\n"+sRet+"\n\n"+sAus+"\n\n");
            myWriter.write("Asistencia Total: "+reunion.obtenerTotalAsistencia()+"/"+reunion.obtenerTotalInvitacion());
            myWriter.write(" // "+reunion.obtenerPorcentajeAsistencia()+"%\n\n");
            myWriter.write("Notas de la Reunión:"+reunion.getNota().getContenido());
            myWriter.close();
            System.out.println("Informe de la reunión creado en: "+nombre+".txt");
        } catch (IOException e) {
            System.out.println("Error al crear el informe de reunión");
            e.printStackTrace();
        }
    }
}
