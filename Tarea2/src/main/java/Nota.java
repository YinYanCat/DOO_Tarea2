
/** Una nota que puede ser extendida con otras notas
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class Nota {

    /** Contenido de la nota */
    private String contenido;

    /** Constructor para crear una nota */
    public Nota() {
        contenido = "";
    }

    /** Método para agregar contenido a la nota
     * @param writing El contenido a agregar a la nota */
    public void addContenido(String writing) {
        contenido = contenido.concat("\n"+writing);
    }

    /** Método para obtener el contenido de la nota
     * @return El contenido de la nota */
    public String getContenido() {
        return contenido;
    }
}
