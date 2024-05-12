
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ReunionVirtualTest {
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
        organizador = new Empleado("Juan","Valenzuela","1","jvalenzuela@correo.com");
        e1 = new Empleado("Juan", "Perez", "2", "jperez@correo.com");
        e2 = new Empleado("Roberto", "Gomez", "3", "rgomez@correo.com");
        e3 = new Empleado("Maria", "Toncillo", "4", "mtoncillo@correo.com");
        e4 = new Empleado("Selena", "Rolecci", "5", "srolecci@correo.com");
        d1 = new Departamento("Analistas");
        d2 = new Departamento("Tecnicos");
        reunionVirtual = new ReunionVirtual(new Date(), Instant.now(), Duration.ofHours(1), organizador, tipoReunion.TECNICA, "www.reunion.com");

        reunionVirtual.agregarInvitado(e1);
        reunionVirtual.agregarInvitado(e2);
        reunionVirtual.agregarInvitado(e3);
        reunionVirtual.agregarInvitado(e4);
        reunionVirtual.agregarInvitado(organizador);
    }

    @AfterEach
    void tearDown(){

    }
    @Test
    void obtenerAsistencias() {
        reunionVirtual.llegada(e1);
        ArrayList<Asistencia> asistencias = reunionVirtual.obtenerAsistencias();
        assertNotNull(asistencias);
        reunionVirtual.llegada(e2);
        reunionVirtual.iniciar();
        reunionVirtual.llegada(e3);
        ArrayList<Asistencia> asistencias2 = reunionVirtual.obtenerAsistencias();
        assertNotEquals(asistencias, asistencias2);
    }

    @Test
    void obtenerAusencias() {
        assertNotNull(reunionVirtual.obtenerAusencias());
        reunionVirtual.llegada(e1);
        reunionVirtual.llegada(e2);
        reunionVirtual.llegada(e3);
        reunionVirtual.llegada(e4);
        reunionVirtual.llegada(organizador);
        assertEquals(0,reunionVirtual.obtenerAusencias().size());
    }

    @Test
    void obtenerRetrasos() {
    }

    @Test
    void agregarInvitado() {
    }

    @Test
    void llegada() {
    }
}