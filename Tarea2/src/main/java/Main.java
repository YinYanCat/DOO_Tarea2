import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Main instMain = new Main();

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
        Invitacion inv = r1.getInvitacion();
        e2.invitar(inv);
        d2.invitar(inv);

        r1.llegada(e2);
        r1.llegada(e3);
        r1.iniciar();
        System.out.println(r1.obtenerTotalAsistencia() + " / " + r1.obtenerPorcentajeAsistencia() + "%");
        instMain.printNames(r1.obtenerAsistencias(), "Asistencia");
        instMain.printNames(r1.obtenerRetrasos(), "Retrasos");
        instMain.printNames(r1.obtenerAusencias(), "Ausencias");
        r1.llegada(e4);
        r1.finalizar();
        System.out.println(r1.obtenerTotalAsistencia() + " / " + r1.obtenerPorcentajeAsistencia() + "%");
        instMain.printNames(r1.obtenerAsistencias(), "Asistencia");
        instMain.printNames(r1.obtenerRetrasos(), "Retrasos");
        instMain.printNames(r1.obtenerAusencias(), "Ausencias");
    }

    public void printNames(ArrayList<Empleado> listaEmpleados, String str) {
        System.out.print(str+": ");
        for(int i=0; i<listaEmpleados.size(); i++) {
            System.out.print(listaEmpleados.get(i).getNombre()+ " / ");
        }
        System.out.print("\n");
    }
}
