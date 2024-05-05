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
    private ArrayList<Asistencia> asistencia;
    private Empleado organizador;

    public Reunion(Date fecha, Instant hora, Duration duracion, Empleado org) {
        this.fecha = fecha;
        horaPrevista = hora;
        duracionPrevista = duracion;
        horaFin=null;
        horaInicio=null;
        invitacion = new Invitacion(hora);
    }
    public ArrayList<Empleado> obtenerAsistencias(){
        ArrayList listaAsistencias = new ArrayList<Empleado>();
        for(int i=0; i<asistencia.size(); i++) {
            listaAsistencias.add(asistencia.get(i).getAsistente());
        }
        return listaAsistencias;
    }
    public ArrayList<Empleado> obtenerAusencias(){
        return null;
    }
    public ArrayList<Empleado> obtenerRetrasos(){
        return null;
    }
    public int obtenerTotalAsistencia(){
        return 0;
    }
    public float obtenerPorcentajeAsistencia(){
        return 0;
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
        if(horaInicio == null) {
            asistencia.add(new Asistencia(asistente));
        } else {
            asistencia.add(new Retraso(asistente, Instant.now()));
        }

    }
}
