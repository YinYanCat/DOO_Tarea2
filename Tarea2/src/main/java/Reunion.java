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

    public Reunion(Date fecha, Instant hora, Duration duracion) {
        this.fecha = fecha;
        horaPrevista = hora;
        duracionPrevista = duracion;
        horaFin=null;
        horaInicio=null;
    }

    public ArrayList<Empleado> obtenerAsistencias(){
        return null;
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
}
