
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/** Tests unitarios para las clases reunion, usa en este caso ReunionVirtual para los test
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class ReunionTest {
    private ReunionVirtual reunionVirtual;
    private Empleado organizador;
    private Empleado e1;
    private Empleado e2;
    private Empleado e3;
    private Empleado e4;

    /** SetUp para cada test de Reunion
     * Crea una reunion virtual y asigna los invitdos, deja a un empledo sin invitar */
    @BeforeEach
    void setUp() {
        Departamento d1 = new Departamento("Analistas");
        Departamento d2 = new Departamento("Tecnicos");
        organizador = new Empleado("Diego","Valenzuela","1","dvalenzuela@correo.com", d1);
        e1 = new Empleado("Juan", "Perez", "2", "jperez@correo.com", d1);
        e2 = new Empleado("Roberto", "Gomez", "3", "rgomez@correo.com", d2);
        e3 = new Empleado("Maria", "Toncillo", "4", "mtoncillo@correo.com", d2);
        e4 = new Empleado("Selena", "Rolecci", "5", "srolecci@correo.com", d2);

        reunionVirtual = new ReunionVirtual(new Date(), Instant.now(), Duration.ofHours(1), organizador, tipoReunion.TECNICA, "www.reunion.com");

        try {
            reunionVirtual.agregarInvitado(e1);
            reunionVirtual.agregarInvitado(e2);
            reunionVirtual.agregarInvitado(e3);
            reunionVirtual.agregarInvitado(organizador);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @AfterEach
    void tearDown(){

    }

    /** test de asistencia de 4 empleados
     * Prueba que la lista de asistencia sea no nula y que tenga un tamaño de 4 */
    @Test
    @DisplayName("Test asistencias")
    void obtenerAsistencias() throws Exception {
        reunionVirtual.llegadaEmpleado(organizador);
        reunionVirtual.llegadaEmpleado(e1);
        reunionVirtual.llegadaEmpleado(e2);
        reunionVirtual.llegadaEmpleado(e3);
        ArrayList<Asistencia> asistencias = reunionVirtual.obtenerAsistencias();
        assertNotNull(asistencias);
        assertEquals(4,asistencias.size());

    }

    /** test de ausencia de 1 empleado
     * Prueba que la lista de ausencia sea no nula y que tenga un tamaño de 1 */
    @Test
    @DisplayName("Test ausencias")
    void obtenerAusencias() throws Exception {
        assertNotNull(reunionVirtual.obtenerAusencias());
        reunionVirtual.llegadaEmpleado(e1);
        reunionVirtual.llegadaEmpleado(e2);
        reunionVirtual.llegadaEmpleado(organizador);
        assertEquals(1,reunionVirtual.obtenerAusencias().size());
    }

    /** test de retraso de 3 empleados
     * Prueba que la lista de retraso este vacia antes de empezar la reunión
     * Luego de iniciar se pueba que la lista de retraso sea de tamaño 3*/
    @Test
    @DisplayName("Test retrasos")
    void obtenerRetrasos() throws Exception {
        assertEquals(0,reunionVirtual.obtenerRetrasos().size());
        reunionVirtual.llegadaEmpleado(e1);
        reunionVirtual.iniciar();
        reunionVirtual.llegadaEmpleado(e2);
        reunionVirtual.llegadaEmpleado(e3);
        reunionVirtual.llegadaEmpleado(organizador);
        assertEquals(3,reunionVirtual.obtenerRetrasos().size());
    }

    /** test de llegada de empleados
     * Prueba las excepciones que se pueden obtener
     * Se prueba que se obtengan las excepciones para empleados no invitados, invitado ya en la reunión y la llegada de un invitado después de finalizar la reunion*/
    @Test
    @DisplayName("Test Exceptions llegada")
    void llegada(){
        try {
            reunionVirtual.llegadaEmpleado(e4);
        }catch (Exception e) {

            String expectedMessage = "Asistente no invitado";
            String actualMessage = e.getMessage();

            assertTrue(actualMessage.contains(expectedMessage));
        }

        try{
            reunionVirtual.llegadaEmpleado(e2);
            reunionVirtual.llegadaEmpleado(e2);
        }catch(Exception e){
            String expectedMessage = "Asistente ya en la reunión";
            String actualMessage = e.getMessage();
            assertTrue(actualMessage.contains(expectedMessage));
        }

        try{
            reunionVirtual.finalizar(Instant.now().plus(1, ChronoUnit.HOURS));
            reunionVirtual.llegadaEmpleado(e2);
            
        }catch(Exception e){
            String expectedMessage = "Llegada a una reunión ya finalizada";
            String actualMessage = e.getMessage();
            assertTrue(actualMessage.contains(expectedMessage));
        }

    }

}