package EDD;


public class GrafoMA {

    private int maxVertices;
    private int numVertices;
    private double[][] matrizA;

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
    
    
    public boolean GrafoVacio(){
        return numVertices == 0;
    }
    
    // Método para asignar aristas entre vertices
    public void insertarArista(int v1, int v2, double ponteracion){
        matrizA[v1][v2] = matrizA[v2][v1] = ponteracion;
    }
    
    //Método para eliminar aristas entre vertices
    public void eliminarArista(int v1, int v2){
        matrizA[v1][v2] = matrizA[v2][v1] = 0;
    }
    
    //Método para insertar vertice en el grafo
    public void insertarVertice(int n){
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
    
    //Método para eliminar Vertice del Grafo
    public void eliminarVertice(int vertice){
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
    
    //Método para imprimir la matriz de Adyacencia del grafo
    public String imprimirMatriz(){
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