package functions;

//Importando librerias de GraphStream
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;

/**
 * ClaseGraphStream.
 * @author Ricardo Machado
 */
public class GraphStream {
    
    
    /**
     * Método para crear la gráfica y pintar el grafo.
     * @param numVertices Sirve para crear la cantidad de nodos.
     * @param matriz    Sirve para obtener las aristas y crear las conexiones.
     * @param ciudadesRecorridas Sirve para cambiar el color a los vertices por donde pasa la hormiga.
     */
    public void PintarGrafo(int numVertices, double[][] matriz, int[]ciudadesRecorridas){
        
        System.setProperty("org.graphstream.ui", "swing");
	
        //se crea la gráfica.
	Graph g = new SingleGraph("GraphStream_Example_03");

	g.setAttribute("ui.stylesheet", styleSheet);

	g.setStrict(false);
	g.setAutoCreate( true );
	
        //Creando nodos al grafo.
        for (int i = 1; i <= numVertices; i++) {
            g.addNode(Integer.toString(i));
        }
        
        // Se crea las aristas para cada nodo usando la matriz de Adyacencia para las conexiones
        for (int i = 0; i < numVertices; i++) {
            for (int j = i; j < numVertices; j++) {
                if(matriz[i][j] != 0){
                    String nodoIni = Integer.toString(i+1);
                    String nodoFin = Integer.toString(j+1);
                    String arista = nodoIni+nodoFin;
                    g.addEdge(arista, nodoIni, nodoFin).setAttribute("length", matriz[i][j]);
                }
            }
        }
                
        g.nodes().forEach(n -> n.setAttribute("label", n.getId()));
        g.edges().forEach(e -> e.setAttribute("label", "" + (double) e.getNumber("length")));
        
        // Se cambia el color a los vertices por donde recorre la hormiga con el vector CiudadesRecorridas.
        for (int i = 0; i < ciudadesRecorridas.length; i++) {
            int ciudad = ciudadesRecorridas[i];
            Node nodo = g.getNode(Integer.toString(ciudad));
            nodo.setAttribute("ui.class", "root");
        }
        
        //Se visualiza el grafo y se setea la opción de que no cierre el programa por completo.
        Viewer viewer = g.display();
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);
    }
    
    /**
     * Cambia el estilo del grafo.
     */
    protected static String styleSheet =
		"node {"+
			"	shape: circle;"+
			"	size: 40px;"+
			" text-size: 14;"+
			"	fill-mode: plain;"+
			"	fill-color: orange;"+
			"	stroke-mode: plain;"+
			"	stroke-color: black;"+
			"	stroke-width: 1px;"+
		"}"+
		"edge { arrow-shape: arrow; arrow-size: 20px, 4px; }"+
                "node.root { fill-color: skyblue; }";
}