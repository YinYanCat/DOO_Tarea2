public class Nota {
    private String contenido;

    public Nota(){
        contenido = "";
    }

    public void addContenido(String writing){
        contenido = contenido.concat("\n"+writing);
    }

    public void getNota(){
        System.out.print(contenido);
    }
}
