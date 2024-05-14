
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

public class ReunionTest {
    private ReunionVirtual reunionVirtual;
    private Empleado organizador;
    private Empleado e1;
    private Empleado e2;
    private Empleado e3;
    private Empleado e4;
    Departamento d1;
    Departamento d2;

    @BeforeEach
    void setUp() {
        d1 = new Departamento("Analistas");
        d2 = new Departamento("Tecnicos");
        organizador = new Empleado("Juan","Valenzuela","1","jvalenzuela@correo.com", d1);
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
    @Test
    @DisplayName("Test asistencias")
    void obtenerAsistencias() throws Exception {
        ArrayList<Asistencia> asistencias = reunionVirtual.obtenerAsistencias();
        reunionVirtual.llegadaEmpleado(e1);
        assertNotNull(asistencias);

    }

    @Test
    @DisplayName("Test ausencias")
    void obtenerAusencias() throws Exception {
        assertNotNull(reunionVirtual.obtenerAusencias());
        reunionVirtual.llegadaEmpleado(e1);
        reunionVirtual.llegadaEmpleado(e2);
        reunionVirtual.llegadaEmpleado(e3);
        reunionVirtual.llegadaEmpleado(organizador);
        assertEquals(0,reunionVirtual.obtenerAusencias().size());
    }

    @Test
    @DisplayName("Test retrasos")
    void obtenerRetrasos() throws Exception {
        assertEquals(0,reunionVirtual.obtenerRetrasos().size());
        reunionVirtual.llegadaEmpleado(e1);
        reunionVirtual.iniciar();
        reunionVirtual.llegadaEmpleado(e2);
        reunionVirtual.llegadaEmpleado(e3);
        reunionVirtual.llegadaEmpleado(organizador);
        assertEquals(4,reunionVirtual.obtenerRetrasos().size());
    }

    @Test
    @DisplayName("Test llegada no invitado")
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