import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Reunion {
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFin;


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
        return 0;
    }

    public void iniciar(){}

    public void finalizar(){}
}
