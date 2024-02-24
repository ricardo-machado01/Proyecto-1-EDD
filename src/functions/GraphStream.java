package functions;

//Importando librerias de GraphStream
import javax.swing.JOptionPane;
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
     * @param numVertices Sirve para crear la cantidad de nodos.
     * @param matriz    Sirve para obtener las aristas y crear las conexiones.
     * @param ciudadesRecorridas Sirve para cambiar el color a los vertices por donde pasa la hormiga.
     */
    public void PintarGrafo(int numVertices, double[][] matriz, int[]ciudadesRecorridas) {
        
        System.setProperty("org.graphstream.ui", "swing");
	
        //se crea la gráfica.
	Graph g = new SingleGraph("GraphStream_Example_03");

	g.setAttribute("ui.stylesheet", styleSheet);

	g.setStrict(false);
	g.setAutoCreate( true );
	
        // Se crean y agregan nodos al grafo.
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
        if (ciudadesRecorridas != null) {
            for (int i = 0; ciudadesRecorridas[i] != 0 && i < ciudadesRecorridas.length; i++) {
                int ciudad_r = ciudadesRecorridas[i];
                int ciudad_s = ciudadesRecorridas[i + 1];
                int cont_n = 0;
                
                
                Node nodo_r = g.getNode(Integer.toString(ciudad_r));
                nodo_r.setAttribute("ui.class", "root");
                
                Node nodo_s = g.getNode(Integer.toString(ciudad_s));
                
                System.out.println(nodo_r + ", " + nodo_s);
                
                if (nodo_s != null) {
                    Edge edge_k = nodo_r.getEdgeBetween(nodo_s);
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