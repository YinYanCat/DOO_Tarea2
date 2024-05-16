import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;


/** Tests unitario para Invitar a un Departamento
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */
class DepartamentoTest {

    /** Test para probar que se Invita a todos los empleados de un Departamento correctamente */
    @DisplayName("Test de Invitacion a departamento")
    @Test
    void invitar() throws Exception {
        Departamento d1 = new Departamento("Analistas");
        Empleado organizador = new Empleado("Diego","Valenzuela","1","dvalenzuela@correo.com", d1);
        Empleado e1 = new Empleado("Juan", "Perez", "2", "jperez@correo.com", d1);


        ReunionVirtual r = new ReunionVirtual(new Date(), Instant.now(), Duration.ofHours(1), organizador, TipoReunion.TECNICA, "www.reunion.com");
        d1.invitar(r);

        //se obtiene la lista de invitados de la reunion a traves de una reunion sin asistentes
        ArrayList<Empleado> empleadosInvitados = new ArrayList<>();
        empleadosInvitados.add(r.obtenerAusencias().get(0).getEmpleado());
        empleadosInvitados.add(r.obtenerAusencias().get(1).getEmpleado());

        assertEquals(d1.getEmpleados(),empleadosInvitados);

    }
}