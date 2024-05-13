import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Informacion cnv = new Informacion();

        Empleado e1 = new Empleado("Juan", "Perez", "1", "jperez@correo.com");
        Empleado e2 = new Empleado("Roberto", "Gomez", "2", "rgomez@correo.com");
        Empleado e3 = new Empleado("Maria", "Toncillo", "3", "mtoncillo@correo.com");
        Empleado e4 = new Empleado("Selena", "Rolecci", "4", "srolecci@correo.com");
        Empleado e5 = new Empleado("Carlos","Saavedra","5","csaveedra@correo.com");

        Departamento d1 = new Departamento("Menta");
        Departamento d2 = new Departamento("Flipy");

        d1.contratar(e1);
        d1.contratar(e2);
        d2.contratar(e3);
        d2.contratar(e4);

        Reunion r1 = new ReunionVirtual(new Date(), Instant.now(), Duration.ofHours(1), e1, tipoReunion.TECNICA, "www.reunion.com");

        try {
            d1.invitar(r1);
            d2.invitar(r1);
            cnv.printRegistroReunion(r1);
            r1.llegada(e2);
            cnv.printRegistroReunion(r1);
            r1.agregarNora("Roberto va a iniciar la reunión.");
            r1.iniciar();
            cnv.printRegistroReunion(r1);
            r1.llegada(e4);
            r1.agregarNora("Juan se cayó, no va a llegar.");
            cnv.printRegistroReunion(r1);
            r1.llegada(e3);
            cnv.printRegistroReunion(r1);
            r1.finalizar();
            cnv.crearInformeReunion(r1, "ejemplo");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
