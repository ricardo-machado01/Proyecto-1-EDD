package EDD;

public class Global {
    private static GrafoMA grafo = new GrafoMA(20);
    
    public static GrafoMA getGrafo() {
        return grafo;
    }
    
    public static void setGrafo(GrafoMA parametro) {
        grafo = parametro;
    }
}