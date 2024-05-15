
/** Una nota que puede ser extendida con otras notas
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class Nota {

    /** Contenido de la nota */
    private String contenido;

    /** La cantidad total de contenido agregado */
    private int cantidadContenido;

    /** Constructor para crear una nota */
    public Nota() {
        contenido = "";
        cantidadContenido = 0;
    }

    /** Método para agregar contenido a la nota
     * @param writing El contenido a agregar a la nota */
    public void addContenido(String writing) {
        contenido = contenido.concat("\n- "+writing);
        cantidadContenido++;
    }

    /** Método para obtener el contenido de la nota
     * @return El contenido de la nota */
    public String getContenido() {
        return contenido;
    }

    /** Método para obtener la cantidad total de contenido agregado
     * @return La cantidad de contenido agregado a la nota */
    public int getCantidadContenido() {
        return cantidadContenido;
    }

    /** Método para obtener los datos internos de la clase Nota
     * @return Un texto con la cantidad de contenido de la nota y su contenido */
    public String toString() {
        return "Cantidad: "+cantidadContenido+contenido;
    }
}
