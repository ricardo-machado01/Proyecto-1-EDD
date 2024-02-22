package EDD;

/**
 * Clase Grafo con Matriz de Adyacencia
 * @author Ricardo Machado
 */
public class GrafoMA {

    private int maxVertices;
    private int numVertices;
    private double[][] matrizA;

    /**
     * Constructor de la clase Grafo
     * @param maxVertices maxVertices indica el máximo de dimensiones de la matriz de Adyacencia del grafo. 
     */
    public GrafoMA(int maxVertices) {
        this.maxVertices = maxVertices;
        this.numVertices = 0;
        this.matrizA = new double[maxVertices][maxVertices];
    }

    public int getMaxVertices() {
        return maxVertices;
    }

    public void setMaxVertices(int maxVertices) {
        this.maxVertices = maxVertices;
    }

    public int getNumVertices() {
        return numVertices;
    }

    public void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }

    public double[][] getMatrizA() {
        return matrizA;
    }

    public void setMatrizA(double[][] matrizA) {
        this.matrizA = matrizA;
    }
    
    /**
     * Método para saber si el grafo está vacío.
     * @return Retorna un tipo de dato booleano.
     */
    public boolean GrafoVacio(){
        return numVertices == 0;
    }
    
    /**
     * Método para insertar arista en un vertice de la Matriz de Adyacencia del grafo. Recordar que es no dirigido.
     * @param v1 vertice origen.
     * @param v2 vertice destino.
     * @param ponteracion peso de arista entre los vertices v1 y v2. 
     */
    public void insertEdge(int v1, int v2, double ponteracion){
        matrizA[v1][v2] = matrizA[v2][v1] = ponteracion;
    }
    
    /**
     * Método para eliminar la arista de un vertice. Recordar que es no dirigido.
     * @param v1 vertice origen.
     * @param v2 vertice destino.
     */
    public void deleteEdge(int v1, int v2){
        matrizA[v1][v2] = matrizA[v2][v1] = 0;
    }
    
    /**
     * Método para añadir uno o más vertices a la matriz de adyacencia del Grafo.
     * @param n cantidad de vertices que se desea añadir.
     */
    public void insertVertex(int n){
        if(n > maxVertices-numVertices){
            System.out.println("El número de vertices se ha superado");
        }else{
            for (int i=0; i < numVertices + n; i++) {
                for (int j = numVertices; j < numVertices + n; j++) 
                    matrizA [i][j] = matrizA [j][i] = 0;
            }
        numVertices += n;
        }
    }
    
    /**
     * Método para eliminar un vertice del Grafo a través de la eliminación de las aristas y reducción de la matriz de adyacencia.
     * @param vertice número entero que indica la ciudad o vertice que sea eliminar.
     */
    public void deleteVertex(int vertice){
        if(vertice >= numVertices){
            System.out.println("Error vertice inválido");
        }else{
            for (int i = vertice; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    if(i == numVertices - 1 || j == numVertices - 1 ){
                        matrizA[i][j] = matrizA[j][i] = 0;
                    }else{
                        matrizA[i][j] = matrizA[i+1][j];
                        matrizA[j][i] = matrizA[i][j];
                    }
                }
            }
            numVertices--;
        }
    }
    
    /**
     * Método para imprimir la matriz de Adyacencia del Grafo.
     * @return Retorna un String con la información de la matriz de las filas y columnas.
     */
    public String printMatrix(){
        String strMatriz = "";
        System.out.println ("La matriz contiene " + numVertices + " vértices: \n");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                strMatriz += "[" + matrizA[i][j] + "]" + " ";
                /*System.out.print(matrizA[i][j] + " ");*/
            }
            strMatriz += "\n";
            /*System.out.println();*/
        }
    return strMatriz;
    }
}