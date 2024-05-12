import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Empleado e1 = new Empleado("Juan", "Perez", "1", "jperez@correo.com");
        Empleado e2 = new Empleado("Roberto", "Gomez", "2", "rgomez@correo.com");
        Empleado e3 = new Empleado("Maria", "Toncillo", "3", "mtoncillo@correo.com");
        Empleado e4 = new Empleado("Selena", "Rolecci", "4", "srolecci@correo.com");

        Departamento d1 = new Departamento("Menta");
        Departamento d2 = new Departamento("Flipy");

        d1.contratar(e1);
        d1.contratar(e2);
        d2.contratar(e3);
        d2.contratar(e4);

        Reunion r1 = new ReunionPresencial(new Date(), Instant.now(), Duration.ofHours(1), e1, "www.reunion.com");
    }
}
