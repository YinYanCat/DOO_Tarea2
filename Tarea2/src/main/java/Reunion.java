import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

/** Una reunión donde pueden asistir empleados, y se guarda información de la misma
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public abstract class Reunion {

    /** Fecha de la reunión */
    private Date fecha;

    /** Hora de inicio prevista de la reunión */
    private Instant horaPrevista;

    /** Duración prevista de la reunión */
    private Duration duracionPrevista;

    /** Hora de inicio de la reunión */
    private Instant horaInicio;

    /** Hora de finalización de la reunión */
    private Instant horaFin;

    /** Notas de la reunión */
    private Nota notaReunion;

    /** El tipo de reunión */
    private TipoReunion tipo;

    /** Lista de invitados a la reunión (no incluye asistentes) */
    private ArrayList<Invitacion> listaInvitacion;

    /** Lista de asistentes a la reunión */
    private ArrayList<Asistencia> listaAsistencia;

    /** Empleado organizador de la reunión */
    private Empleado organizador;


    /** Constructor para crear una reunión y guardar la información relevante de la misma
     * @param fecha La fecha de la reunión
     * @param hora La hora de inicio prevista de la reunión
     * @param duracion La duración prevista de la reunión
     * @param org El empleado organizador de la reunión
     * @param miTipo El tipo de reunión */
    public Reunion(Date fecha, Instant hora, Duration duracion, Empleado org, TipoReunion miTipo) {
        notaReunion=new Nota();
        tipo=miTipo;
        this.fecha = fecha;
        horaPrevista = hora;
        duracionPrevista = duracion;
        horaInicio=null;
        horaFin=null;
        notaReunion = new Nota();
        listaInvitacion = new ArrayList<>();
        listaAsistencia = new ArrayList<>();
        organizador = org;
    }

    /** Método para obtener la lista de asistentes a la reunión
     * @return La lista de asistentes, las cuales contienen empleados y horas */
    public ArrayList<Asistencia> obtenerAsistencias() {
        return listaAsistencia;
    }

    /** Método para obtener la lista de invitados ausentes a la reunión
     * @return La lista de asistentes, las cuales contienen empleados y horas */
    public ArrayList<Invitacion> obtenerAusencias() {
        return listaInvitacion;
    }

    /** Método para obtener la lista de asistentes retrasados a la reunión
     * @return La lista de asistentes retrasados, las cuales contienen empleados y horas */
    public ArrayList<Retraso> obtenerRetrasos() {
        ArrayList<Retraso> listaRetraso= new ArrayList<>();
        for(int i=0; i<listaAsistencia.size(); i++) {
            if(listaAsistencia.get(i).getClass() == Retraso.class) {
                listaRetraso.add((Retraso)listaAsistencia.get(i));
            }
        }
        return listaRetraso;
    }

    /** Método para obtener la cantidad total de asistentes a la reunión
     * @return El número de asistentes a la reunión */
    public int obtenerTotalAsistencia() {
        return listaAsistencia.size();
    }

    /** Método para obtener la cantidad total de invitados a la reunión (Incluye asistentes)
     * @return El número de invitados a la reunión */
    public int obtenerTotalInvitacion() {
        return listaInvitacion.size()+listaAsistencia.size();
    }

    /** Método para obtener el porcentaje de asistentes a la reunión
     * @return El porcentaje de asistentes a la reunión */
    public float obtenerPorcentajeAsistencia() {
        float cantAsistencia = (float)listaAsistencia.size();
        float cantInvitacion = (float)listaInvitacion.size()+cantAsistencia;
        return (cantAsistencia*100)/cantInvitacion;
    }

    /** Método para obtener la duración actual de la reunión, si la reunión esta finalizada entrega la duración total
     * @return La duración real de la reunión */
    public float calcularTiempoReal(){
        float tiempoReal;
        if(horaFin==null){
            tiempoReal = horaInicio.compareTo(Instant.now());
        }else{
            tiempoReal = horaFin.compareTo(horaInicio);
        }
        return tiempoReal;
    }

    /** Método para iniciar la reunión
     * @throws HoraYaEstablecidaException Se lanza esta excepción si la reunión ya fue iniciada  */
    public void iniciar() throws Exception {
        if(horaInicio != null)
            throw new HoraYaEstablecidaException("Reunión ya iniciada");
        horaInicio = Instant.now();
    }

    /** Método para finalizar la reunión
     * @param hora Hora de finalización de la reunión
     * @throws HoraYaEstablecidaException Se lanza esta excepción si la reunión ya fue finalizada */
    public void finalizar(Instant hora) throws Exception {
        if(horaFin != null)
            throw new HoraYaEstablecidaException("Reunión ya finalizada");
        horaFin = hora;
    }

    /** Método para agregar una invitación a la lista de invitados, la cuál incluye un empleado y una hora
     * @param empleado El empleado invitado a la reunión
     * @throws EmpleadoYaInvitadoException Se lanza esta excepción si el empleado ya fue invitado a la reunión */
    public void agregarInvitado(Empleado empleado) throws Exception {
        for(int i=0; i<listaInvitacion.size(); i++) {
            if(listaInvitacion.get(i).getEmpleado() == empleado)
                throw new EmpleadoYaInvitadoException("Empleado ya invitado a la reunión");
        }
        Invitacion invitado = new Invitacion(empleado, Instant.now());
        listaInvitacion.add(invitado);
    }

    /** Método para establecer la llegada de un invitado a la reunión, convirtiendolo en asistente
     * @param asistente El empleado que llegó a la reunión
     * @throws AsistenciaDespuesDeFinalizarException Se lanza esta excepción si el invitado llega después de finalizar la reunión
     * @throws AsistenteNoEnListaException Se lanza esta excepción si el empleado no esta invitado o ya se encuentra en la reunión */
    public void llegadaEmpleado(Empleado asistente) throws Exception {
        if(horaFin != null)
            throw new AsistenciaDespuesDeFinalizarException("Llegada a una reunión ya finalizada");

        for(int i=0; i<listaInvitacion.size(); i++) {
            Invitacion invitado = listaInvitacion.get(i);
            if(invitado.getEmpleado() == asistente) {
                if(horaInicio == null)
                    listaAsistencia.add(new Asistencia(invitado));
                else
                    listaAsistencia.add(new Retraso(invitado, Instant.now()));
                listaInvitacion.remove(i);
                return;
            }
        }
        for(int i=0; i<listaAsistencia.size(); i++) {
            if(listaAsistencia.get(i).getEmpleado() == asistente)
                throw new AsistenteNoEnListaException("Asistente ya en la reunión");
        }
        throw new AsistenteNoEnListaException("Asistente no invitado");
    }

    /** Método para agregar una nota a las notas de la reunión
     * @param nota La nota a agregar */
    public void agregarNota(String nota) {
        notaReunion.addContenido(nota);
    }

    /** Método para obtener la fecha de la reunión
     * @return La fecha de la reunión */
    public Date getFecha() {
        return fecha;
    }

    /** Método para obtener la hora de inicio prevista de la reunión
     * @return La hora de inicio prevista de la reunión */
    public Instant getHoraPrevista() {
        return horaPrevista;
    }

    /** Método para obtener la duración prevista de la reunión
     * @return La duración prevista de la reunión */
    public Duration getDuracionPrevista() {
        return duracionPrevista;
    }

    /** Método para obtener la hora de inicio de la reunión
     * @return La hora de inicio de la reunión */
    public Instant getHoraInicio() {
        return horaInicio;
    }

    /** Método para obtener la hora de finalización de la reunión
     * @return La hora de finalización de la reunión */
    public Instant getHoraFin() {
        return horaFin;
    }

    /** Método para obtener las notas de la reunión
     * @return Las notas de la reunión */
    public Nota getNota() {
        return notaReunion;
    }

    /** Método para obtener el tipo de reunión
     * @return El tipo de reunión */
    public TipoReunion getTipo() {
        return tipo;
    }

    /** Método para obtener el empleado organizador de la reunión
     * @return El empleado organizador de la reunión */
    public Empleado getOrganizador() {
        return organizador;
    }

    /** Método abstracto para obtener la sala o el enlace de la reunión
     * @return La sala o el enlace de la reunión, junto con un texto diciendo cuál de las dos es */
    public abstract String getLugar();

    /** Método abstracto para obtener el tipo de lugar donde se realizará la reunión
     * @return El texto donde especifica el tipo de lugar, sala o enlace "*/
    public abstract String getTipoLugar();

    /** Método para obtener los datos internos de la clase Reunion
     * @return Un texto con la fecha, hora y duración previstas, la horas de inicio y fin,
     * los asistentes y austentes, tipo, organizador y notas de la reunión */
    public String toString() {
        String empleadosInfo = "Asistentes:\n";
        Informe cnv = new Informe();
        for(int i=0; i<listaAsistencia.size(); i++) {
            empleadosInfo = empleadosInfo+listaAsistencia.get(i).toString()+"\n";
        }
        empleadosInfo = empleadosInfo+"Ausentes:\n";
        for(int i=0; i<listaInvitacion.size(); i++) {
            empleadosInfo = empleadosInfo+listaInvitacion.get(i).toString()+"\n";
        }
        String prev = "\nPrevisto: "+cnv.toStringHoraCLT(horaPrevista)+" | "+duracionPrevista;
        String horas = "\nHoras: "+cnv.toStringHoraCLT(horaInicio)+" - "+cnv.toStringHoraCLT(horaFin);
        String datos = "\nTipo: "+tipo+"\nOrganizador: "+organizador.toString();
        return "Fecha: "+fecha+prev+horas+datos+empleadosInfo+"Notas:\n"+notaReunion.toString();
    }
}