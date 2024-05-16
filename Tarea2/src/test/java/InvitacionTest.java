import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

/** Tests unitario para Invitacion
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */
class InvitacionTest {

    Empleado e1;
    Invitacion i;

    @BeforeEach
    void setUp(){
        Departamento d1 = new Departamento("Analistas");
        e1 = new Empleado("Juan", "Perez", "2", "jperez@correo.com", d1);
        i = new Invitacion(e1, Instant.now());

    }

    @DisplayName("Test de Invitacion correcta")
    @Test
    void getEmpleado() {
        assertSame(i.getEmpleado(),e1);
    }

}