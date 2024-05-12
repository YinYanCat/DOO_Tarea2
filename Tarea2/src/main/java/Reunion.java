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
    private Nota notaReunion;
    private tipoReunion tipo;
    private ArrayList<Invitacion> listaInvitacion;
    private ArrayList<Asistencia> listaAsistencia;
    private Empleado organizador;

    public Reunion(Date fecha, Instant hora, Duration duracion, Empleado org, tipoReunion miTipo) {
        notaReunion=new Nota();
        tipo=miTipo;
        this.fecha = fecha;
        horaPrevista = hora;
        duracionPrevista = duracion;
        horaFin=null;
        horaInicio=null;
        listaInvitacion = new ArrayList<>();
        listaAsistencia = new ArrayList<>();
    }
    public ArrayList<Asistencia> obtenerAsistencias() {
        return listaAsistencia;
    }
    public ArrayList<Invitacion> obtenerAusencias() {
        return listaInvitacion;
    }
    public ArrayList<Asistencia> obtenerRetrasos() {
        ArrayList<Asistencia> listaRetraso= new ArrayList<>();
        for(int i=0; i<listaAsistencia.size(); i++) {
            if(listaAsistencia.get(i).getClass() == Retraso.class) {
                listaRetraso.add(listaAsistencia.get(i));
            }
        }
        return listaRetraso;
    }
    public int obtenerTotalAsistencia() {
        return listaAsistencia.size();
    }
    public float obtenerPorcentajeAsistencia() {
        float cantAsistencia = (float)listaAsistencia.size();
        float cantInvitacion = (float)listaInvitacion.size()+cantAsistencia;
        return (cantAsistencia*100)/cantInvitacion;
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
    public void agregarInvitado(Empleado empleado) {
        Invitacion invitado = new Invitacion(empleado, Instant.now());
        listaInvitacion.add(invitado);
    }
    public void llegada(Empleado asistente) {
        for(int i=0; i<listaInvitacion.size(); i++) {
            if(listaInvitacion.get(i).getEmpleado() == asistente) {
                listaInvitacion.remove(i);
            }
        }
        if(horaInicio == null)
            listaAsistencia.add(new Asistencia(asistente));
        else
            listaAsistencia.add(new Retraso(asistente, Instant.now()));
    }
}
