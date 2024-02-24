package EDD;

/**
 * Clase Global. Creada para mantener el grafo entre ventanas.
 * @author Ricardo Machado, Nicolas Planas
 */
public class Global {
    private static GrafoMA grafo = new GrafoMA(20);
    
    public static GrafoMA getGrafo() {
        return grafo;
    }
    
    public static void setGrafo(GrafoMA parametro) {
        grafo = parametro;
    }
}