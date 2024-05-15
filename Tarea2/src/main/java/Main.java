import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/** El main en donde se realiza el programa
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class Main {
    public static void main(String[] args) {
        Informe inf = new Informe();

        Departamento d1 = new Departamento("Menta");
        Departamento d2 = new Departamento("Flipy");

        Empleado e1 = new Empleado("Juan", "Perez", "1", "jperez@correo.com", d1);
        Empleado e2 = new Empleado("Roberto", "Gomez", "2", "rgomez@correo.com", d1);
        Empleado e3 = new Empleado("Maria", "Toncillo", "3", "mtoncillo@correo.com", d2);
        Empleado e4 = new Empleado("Selena", "Rolecci", "4", "srolecci@correo.com", d2);
        Empleado e5 = new Empleado("Carlos","Saavedra","5","csaveedra@correo.com", d2);

        Instant horaPrevista = Instant.now();
        Reunion r1 = new ReunionVirtual(new Date(), horaPrevista, Duration.ofHours(1), e1, TipoReunion.TECNICA, "www.reunion.com");

        try {
            d1.invitar(r1);
            d2.invitar(r1);
            r1.llegadaEmpleado(e2);
            r1.agregarNota("Roberto va a iniciar la reunión.");
            r1.iniciar();
            r1.llegadaEmpleado(e4);
            r1.agregarNota("Juan se cayó, no va a llegar.");
            r1.llegadaEmpleado(e3);
            r1.finalizar(Instant.now().plus(1, ChronoUnit.HOURS));
            System.out.println(r1.toString());
            inf.crearInformeReunion(r1, "ejemplo");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
