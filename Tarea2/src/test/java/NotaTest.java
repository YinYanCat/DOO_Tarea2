import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/** Tests unitario para Nota
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */
class NotaTest {

    /** Test de notas, prueba que se guarde y se devuelvan notas correctamente */
    @DisplayName("Test de notas")
    @Test
    void getContenido() {
        Nota n = new Nota();
        n.addContenido("El departamento Tecnico a determinado que las nuevas practicas han mejorado la eficiencia del trabajo.");
        n.addContenido("Se aprovechara la reduccion de gastos para expandir el departamento");

        assertTrue("Cantidad: 2\n- El departamento Tecnico a determinado que las nuevas practicas han mejorado la eficiencia del trabajo.\n- Se aprovechara la reduccion de gastos para expandir el departamento".contains(n.getContenido()));
    }
}