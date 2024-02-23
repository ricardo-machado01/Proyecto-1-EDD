package EDD;

public class Global {
    private static GrafoMA colacao = new GrafoMA(20);
    
    public static GrafoMA getGrafo() {
        return colacao;
    }
    
    public static void setGrafo(GrafoMA parametro) {
        colacao = parametro;
    }
}