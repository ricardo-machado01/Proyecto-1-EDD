package EDD;

import EDD.GrafoMA;
import java.util.Random;

/**
 * Esta clase representa a la hormiga.
 * @author nicolasplanas
 */
public class CAnt {
    
    // GRADO DE IMPORTANCIA DE LA FEROMONA
    private double α;
    
    // GRADO DE VISIBILIDAD DE LA CIUDAD
    private double β;
    
    // CIUDAD ACTUAL EN DONDE SE ENCUENTRA LA HORMIGA
    private int r;

    // CIUDAD DESTINO EN DONDE SE ENCUENTRA LA COMIDA
    private int s;
    
    // CREAMOS UN ARRAY QUE CONTIENE LA CANTIDAD DE FEROMONA PARA CADA ARISTA DE LAS CIUDADES ADYACENTES A "r"!
    //private double[] tf;
    
    // DETERMINA SI LA HORMIGA LLEGO AL DESTINO O SE QUEDO ENCERRADA EN UNA CIUDAD
    private boolean trapped;

    // DISTANCIA ENTRE LAS CIUDADES "r" y "u"
    double drs;
    
    // VALOR DE APRENDIZAJE
    double Q;

    // CIUDADES RECORRIDAS
    int[] movementHistory;
    
    /**
     * Este es el constructor de la clase hormiga y recibe tres parametros.
     * @param matrix
     * @param r
     * @param s 
     */
    public CAnt (GrafoMA matrix, int r, int s) {
        α = 1;
        β = 2;
        this.r = r;
        this.s = s;
        this.Q = 1;
        this.trapped = false;
        this.movementHistory = new int[matrix.getMaxVertices()];
        movementHistory[0] = r;
    }

    // FÓRMULA PARA CALCULAR τ*η!
    private double m(double drs, double t){
        return Math.pow(t, α) * Math.pow((Q/drs), β);
    }

    public int movementProbability(GrafoMA matrix, double[][] pheromoneQuantity) {
        
        if (r == s) {
            return r;
        } else {

        // SUMATORIA DE TODAS LAS PROBABILIDADES!
        double Mk = 0;
        
        // CONTADOR DE CIUDADES CON ARISTAS!
        int citiesCont = 0;
        
        // INDICES DE LAS CIUDADES!
        int[] idxCities = new int[matrix.getMaxVertices()];
        
        // CALCULAMOS LA SUMATORIA "Mk" VALIDANDO QUE LA HORMIGA NO HAYA ESTADO EN ALGUNA DE LAS CIUDADES ANTES!
        for (int c = 0; c < matrix.getNumVertices(); c++) {
            int repeat = 0;
            if (matrix.getMatrizA()[r - 1][c] > 0) {
                for (int i = 0; i < movementHistory.length; i++) {
                    if (movementHistory[i] == c + 1) {
                        repeat ++;
                        break;
                        }
                    }
                if (repeat == 0) {
                    drs = matrix.getMatrizA()[r - 1][c];
                    Mk += m(drs, pheromoneQuantity[r - 1][c]);
                    idxCities[citiesCont] = c;
                    citiesCont ++;
                    }
                }
            }

        // CREAMOS UNA VARIABLE PARA ALMACENAR LAS PROBABILIDADES DE DESPLACE DE CADA CIUDAD!
        double[] probabilities = new double[citiesCont];
        int idx = 0;
        
        // CALCULAMOS EL PORCENTAJE DE PROBABILIDAD DE DESPLAZAMIENTO PARA CADA CIUDAD DEL CONJUNTO "Mk"!
        for (int c = 0; c < matrix.getNumVertices(); c++) {
            int repeat = 0;
            if (matrix.getMatrizA()[r - 1][c] > 0) {
                for (int i = 0; i < movementHistory.length; i++) {
                    if (movementHistory[i] == c + 1) {
                        repeat ++;
                        break;
                        }
                    }
                if (repeat == 0) {
                    drs = matrix.getMatrizA()[r - 1][c];
                    probabilities[idx] = m(drs, pheromoneQuantity[r - 1][c])/Mk;
                    idx ++;
                    }
                }
            }

        // DETERMINAMOS SI HAY DESPLAZAMIENTO Y A CUAL CIUDAD TIENE LA MAYOR PROBABILIDAD DE DESPLAZARSE!
        if (probabilities.length == 0) {
            trapped = true;
        }
        else {

            // CREAMOS UN RANDOM PARA DETERMINAR CUAL CAMINO TOMAREMOS!
            double o = 0;
            double f = 0;
            
            Random x = new Random();
            double randomNum = x.nextDouble(0,1);

            for (int i = 0; i < probabilities.length; i++) {
                f += probabilities[i];
                if (randomNum >= o && randomNum <= f) {
                    System.out.println("\nRango: " + o + " < " + randomNum + " < " + f);
                    this.setR(idxCities[i] + 1);
                    break;
                } else {
                    o = f;
                    }
                }
            }

        // AGREGAMOS LA CIUDAD A DONDE SE DESPLAZO LA HORMIGA A SU HISTORIAL!
        for (int i = 0; i < movementHistory.length; i++) {
            if (movementHistory[i] == r) {
                break;
            } else if (movementHistory[i] == 0) {
                movementHistory[i] = r;
                break;
            }
        }

        // RETORNAMOS EL INDICE DE LA CIUDAD A LA QUE NOS DESPLAZAMOS!
        return r;
        }
    }
    
    // MÉTODOS SET!
    public void setR(int r) {
        this.r = r;
    }

    public void setS(int s) {
        this.s = s;
    }

    public void setΑ(double α) {
        this.α = α;
    }

    public void setΒ(double β) {
        this.β = β;
    }

    // MÉTODOS GET!
    public int[] getMovementHistory() {
        return movementHistory;
    }

    public int getR() {
        return r;
    }

    public int getS() {
        return s;
    }

    public double getΑ() {
        return α;
    }

    public double getΒ() {
        return β;
    }

    public boolean getTrapped() {
        return trapped;
    }
}