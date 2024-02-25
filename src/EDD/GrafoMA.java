package EDD;

import javax.swing.JOptionPane;

/**
 * Clase Grafo con Matriz de Adyacencia
 * @author Ricardo Machado
 */
public class GrafoMA {

    private int maxVertex;
    private int numVertex;
    private double[][] matrixA;

    /**
     * Constructor de la clase Grafo
     * @param maxVertex maxVertex indica el máximo de dimensiones de la matriz de Adyacencia del grafo. 
     */
    public GrafoMA(int maxVertex) {
        this.maxVertex = maxVertex;
        this.numVertex = 0;
        this.matrixA = new double[maxVertex][maxVertex];
    }

    public int getMaxVertex() {
        return maxVertex;
    }

    public void setMaxVertex(int maxVertex) {
        this.maxVertex = maxVertex;
    }

    public int getNumVertex() {
        return numVertex;
    }

    public void setNumVertex(int numVertex) {
        this.numVertex = numVertex;
    }

    public double[][] getMatrixA() {
        return matrixA;
    }

    public void setMatrixA(double[][] matrixA) {
        this.matrixA = matrixA;
    }
    
    /**
     * Método para saber si el grafo está vacío.
     * @return Retorna un tipo de dato booleano.
     */
    public boolean GraphEmpty(){
        return numVertex == 0;
    }
    
    /**
     * Método para insertar arista en un vertice de la Matriz de Adyacencia del grafo. Recordar que es no dirigido.
     * @param v1 vertice origen.
     * @param v2 vertice destino.
     * @param ponteration peso de arista entre los vertices v1 y v2. 
     */
    public void insertEdge(int v1, int v2, double ponteration){
        matrixA[v1][v2] = matrixA[v2][v1] = ponteration;
    }
    
    /**
     * Método para eliminar la arista de un vertice. Recordar que es no dirigido.
     * @param v1 vertice origen.
     * @param v2 vertice destino.
     */
    public void deleteEdge(int v1, int v2){
        matrixA[v1][v2] = matrixA[v2][v1] = 0;
    }
    
    /**
     * Método para añadir uno o más vertices a la matriz de adyacencia del Grafo.
     * @param n cantidad de vertices que se desea añadir.
     */
    public void insertVertex(int n){
        if(n > maxVertex-numVertex){
            System.out.println("El número de vertices se ha superado");
        }else{
            for (int i=0; i < numVertex + n; i++) {
                for (int j = numVertex; j < numVertex + n; j++) 
                    matrixA [i][j] = matrixA [j][i] = 0;
            }
        numVertex += n;
        }
    }
    
    /**
     * Método para eliminar un vertice del Grafo a través de la eliminación de las aristas y reducción de la matriz de adyacencia.
     * @param vertex número entero que indica la ciudad o vertice que sea eliminar.
     */
    public void deleteVertex(int vertex){
        if(vertex >= numVertex){
            JOptionPane.showInternalMessageDialog(null, "Error vertice inválido");
        }else{
            for (int i = vertex; i < numVertex; i++) {
                for (int j = 0; j < numVertex; j++) {
                    if(i == numVertex - 1 || j == numVertex - 1 ){
                        matrixA[i][j] = matrixA[j][i] = 0;
                    }else{
                        matrixA[i][j] = matrixA[i+1][j];
                        matrixA[j][i] = matrixA[i][j];
                    }
                }
            }
            numVertex--;
        }
    }
    
    /**
     * Método para imprimir la matriz de Adyacencia del Grafo.
     * @return Retorna un String con la información de la matriz de las filas y columnas.
     */
    public String printMatrix(){
        String strMatrix = "";
        
        for (int i = 0; i < numVertex; i++) {
            strMatrix += " " + (i + 1) + " - ";
            for (int j = 0; j < numVertex; j++) {
                strMatrix += "[" + matrixA[i][j] + "]" + " ";
            }
            strMatrix += "\n";
        }
    return strMatrix;
    }
}