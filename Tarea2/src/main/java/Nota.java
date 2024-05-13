public class Nota {
    private String contenido;
    public Nota() {
        contenido = "";
    }
    public void addContenido(String writing) {
        contenido = contenido.concat("\n"+writing);
    }
    public String getContenido() {
        return contenido;
    }
    public void printContenido() {
        System.out.println(contenido);
    }
}
