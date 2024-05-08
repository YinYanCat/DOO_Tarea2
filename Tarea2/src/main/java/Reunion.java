import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

public abstract class Reunion {
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFin;
    private Invitacion invitacion;
    private Asistencia asistencias;
    private Retraso retrasos;
    private Empleado organizador;

    public Reunion(Date fecha, Instant hora, Duration duracion, Empleado org) {
        this.fecha = fecha;
        horaPrevista = hora;
        duracionPrevista = duracion;
        horaFin=null;
        horaInicio=null;
        invitacion = new Invitacion(hora);
        asistencias = new Asistencia();
        retrasos = new Retraso();
    }
    public ArrayList<Empleado> obtenerAsistencias(){
        return asistencias.getAsistencia();
    }
    public ArrayList<Empleado> obtenerAusencias(){
        return invitacion.getAusencia(asistencias.getAsistencia());
    }
    public ArrayList<Empleado> obtenerRetrasos(){
        return retrasos.getAsistencia();
    }
    public int obtenerTotalAsistencia(){
        return asistencias.getTotalAsistencia();
    }
    public float obtenerPorcentajeAsistencia(){
        return invitacion.getPorcentajeAsistencia(asistencias);
    }
    public float calcularTiempoReal(){
        float tiempoReal;
        if(horaFin==null){
            tiempoReal = horaInicio.compareTo(Instant.now());
        }else{
            tiempoReal = horaInicio.compareTo(horaFin);
        }
        return tiempoReal;
    }
    public void iniciar() {
        horaInicio = Instant.now();
    }
    public void finalizar() {
        horaFin = Instant.now();
    }
    public Invitacion getInvitacion() {
        return invitacion;
    }
    public void llegada(Empleado asistente) {
        asistencias.addAsistente(asistente);
        if(horaInicio != null) {
            retrasos.addAsistente(asistente);
            retrasos.addHora(Instant.now());
        }
    }
}
