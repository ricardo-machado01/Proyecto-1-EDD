package functions;

//Importando librerias de GraphStream
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.Edge;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;

/**
 * ClaseGraphStream.
 * @author Ricardo Machado
 */
public class GraphStream {
    
    
    /**
     * Método para crear la gráfica y pintar el grafo.
     * @param numVertex Sirve para crear la cantidad de nodos.
     * @param matrix    Sirve para obtener las aristas y crear las conexiones.
     * @param citiesVisited Sirve para cambiar el color a los vertices por donde pasa la hormiga.
     */
    public void paintGraph(int numVertex, double[][] matrix, int[]citiesVisited) {
        
        System.setProperty("org.graphstream.ui", "swing");
	
        //se crea la gráfica.
	Graph g = new SingleGraph("GraphStream_Example_03");

	g.setAttribute("ui.stylesheet", styleSheet);

	g.setStrict(false);
	g.setAutoCreate( true );
	
        // Se crean y agregan nodos al grafo.
        for (int i = 1; i <= numVertex; i++) {
            g.addNode(Integer.toString(i));
        }
        
        // Se crea las aristas para cada nodo usando la matriz de Adyacencia para las conexiones
        for (int i = 0; i < numVertex; i++) {
            for (int j = i; j < numVertex; j++) {
                if(matrix[i][j] != 0){
                    String nodeBegin = Integer.toString(i+1);
                    String nodeFinal = Integer.toString(j+1);
                    String arista = nodeBegin+nodeFinal;
                    g.addEdge(arista, nodeBegin, nodeFinal).setAttribute("length", matrix[i][j]);
                }
            }
        }
                
        g.nodes().forEach(n -> n.setAttribute("label", n.getId()));
        g.edges().forEach(e -> e.setAttribute("label", "" + (double) e.getNumber("length")));
        
        // Se cambia el color a los vertices y aristas por donde recorre la hormiga con el vector CiudadesRecorridas.
        if (citiesVisited != null) {
            for (int i = 0; citiesVisited[i] != 0 && i < citiesVisited.length; i++) {
                int ciudad_r = citiesVisited[i];
                int ciudad_s = citiesVisited[i + 1];
                int cont_n = 0;
                
                
                Node node_r = g.getNode(Integer.toString(ciudad_r));
                node_r.setAttribute("ui.class", "root");
                
                Node node_s = g.getNode(Integer.toString(ciudad_s));
                
                if (node_s != null) {
                    Edge edge_k = node_r.getEdgeBetween(node_s);
                    edge_k.setAttribute("ui.style", "fill-color: skyblue;");
                    cont_n ++;
                    }
                }
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
			"       text-size: 30;"+
			"	fill-mode: plain;"+
			"	fill-color: orange;"+
			"	stroke-mode: plain;"+
			"	stroke-color: brown;"+
			"	stroke-width: 2.5px;"+
		"}"+
		"edge { arrow-shape: arrow; arrow-size: 20px, 4px; size: 5px; fill-color: orange; text-size: 25; }"+
                "node.root { fill-color: skyblue; stroke-color: blue;}";
}