package EDD;

// SE IMPORTA LA LIBRERÍA NECESARIA.
import java.util.Random;

/**
 * Esta clase representa a la hormiga dentro de la simulación.
 * @author Nicolás Planas
 */
public class CAnt {
    
    // GRADO DE IMPORTANCIA DE LA FEROMONA.
    private double α;
    
    // GRADO DE VISIBILIDAD DE LA CIUDAD.
    private double β;
    
    // CIUDAD ACTUAL EN DONDE SE ENCUENTRA LA HORMIGA.
    private int r;

    // CIUDAD DESTINO EN DONDE SE ENCUENTRA LA COMIDA.
    private int sf;

    // DETERMINA SI LA HORMIGA NO LLEGÓ A LA COMIDA Y SE QUEDÓ ENCERRADA EN UNA CIUDAD.
    private boolean trapped;

    // DISTANCIA ENTRE LAS CIUDADES "r" y "s".
    double drs;
    
    // VALOR DE APRENDIZAJE.
    double Q;

    // HISTORIAL DE CIUDADES RECORRIDAS.
    int[] movementHistory;
    
    /**
     * Este es el constructor de la clase.
     * @param matrix matriz del documento importado como txt.
     * @param r ciudad de partida de la hormiga o 'nido'.
     * @param sf ciudad destino de la hormiga o 'comida'.
     */
    public CAnt (GrafoMA matrix, int r, int sf) {
        α = 1;
        β = 2;
        this.r = r;
        this.sf = sf;
        this.Q = 1;
        this.trapped = false;
        this.movementHistory = new int[matrix.getMaxVertex()];
        movementHistory[0] = r;
    }

    /**
     * Este método calcula el producto de los factores 'τ' y 'η'
     * necesario para la fórmula de probabilidad.
     * @param drs distancia entre la ciudades 'r' y 's'.
     * @param t cantidad de feromona enntre las ciudades.
     * @return 'double' el cual representa el resultado de la operación.
     */
    private double m(double drs, double t){
        return Math.pow(t, α) * Math.pow((Q/drs), β);
    }
    
    /**
     * Este método sirve para desplazar a la hormiga
     * en base a la fórmula de probabilidad.
     * @param matrix matriz del archivo txt importado.
     * @param pheromoneQuantity matriz de las feromonas en cada arista.
     * @return 'int' el cual representa la posición actual de la hormiga.
     */
    public int movementProbability(GrafoMA matrix, double[][] pheromoneQuantity) {
        
        // VALIDAMOS SI LA HORMIGA YA SE ENCUENTRA EN LA CIUDAD DESTINO.
        if (r == sf) {
            return r;
        } else {

            // SUMATORIA DE TODAS LAS PROBABILIDADES.
            double Mk = 0;

            // CONTADOR DE CIUDADES CON ARISTAS.
            int citiesCont = 0;

            // GUARDAMOS LOS INDICES DE LAS CIUDADES.
            int[] idxCities = new int[matrix.getMaxVertex()];

            // CALCULAMOS LA SUMATORIA "Mk" VALIDANDO QUE LA HORMIGA NO HAYA ESTADO EN ALGUNA DE LAS CIUDADES PREVIAMENTE.
            for (int c = 0; c < matrix.getNumVertex(); c++) {
                int repeat = 0;
                if (matrix.getMatrixA()[r - 1][c] > 0) {
                    for (int i = 0; i < movementHistory.length; i++) {
                        if (movementHistory[i] == c + 1) {
                            repeat ++;
                            break;
                            }
                        }
                    if (repeat == 0) {
                        drs = matrix.getMatrixA()[r - 1][c];
                        Mk += m(drs, pheromoneQuantity[r - 1][c]);
                        idxCities[citiesCont] = c;
                        citiesCont ++;
                        }
                    }
                }

            // CREAMOS UNA VARIABLE PARA ALMACENAR LAS PROBABILIDADES DE DESPLACE HACIA CADA CIUDAD.
            double[] probabilities = new double[citiesCont];
            int idx = 0;

            // CALCULAMOS EL PORCENTAJE DE PROBABILIDAD DE DESPLAZAMIENTO PARA CADA CIUDAD DEL CONJUNTO "Mk".
            for (int c = 0; c < matrix.getNumVertex(); c++) {
                int repeat = 0;
                if (matrix.getMatrixA()[r - 1][c] > 0) {
                    for (int i = 0; i < movementHistory.length; i++) {
                        if (movementHistory[i] == c + 1) {
                            repeat ++;
                            break;
                            }
                        }
                    if (repeat == 0) {
                        drs = matrix.getMatrixA()[r - 1][c];
                        probabilities[idx] = m(drs, pheromoneQuantity[r - 1][c])/Mk;
                        idx ++;
                        }
                    }
                }

            // DETERMINAMOS SI HAY DESPLAZAMIENTO Y A CUAL CIUDAD TIENE LA MAYOR PROBABILIDAD DE DESPLAZARSE.
            if (probabilities.length == 0) {
                trapped = true;
            }
            else {

                // CREAMOS UN RANDOM PARA DETERMINAR CUAL CAMINO TOMARÁ LA HORMIGA.
                double o = 0;
                double f = 0;

                Random x = new Random();
                double randomNum = x.nextDouble(0,1);

                for (int i = 0; i < probabilities.length; i++) {
                    f += probabilities[i];
                    if (randomNum >= o && randomNum <= f) {
                        this.setR(idxCities[i] + 1);
                        break;
                    } else {
                        o = f;
                        }
                    }
                }

            // AGREGAMOS LA CIUDAD A DONDE SE DESPLAZÓ LA HORMIGA A SU HISTORIAL DE MOVIMIENTO.
            for (int i = 0; i < movementHistory.length; i++) {
                if (movementHistory[i] == r) {
                    break;
                } else if (movementHistory[i] == 0) {
                    movementHistory[i] = r;
                    break;
                }
            }

            // RETORNAMOS EL INDICE DE LA CIUDAD A LA QUE NOS DESPLAZAMOS.
            return r;
        }
    }
    
    public void setR(int r) {
        this.r = r;
    }
    
    public void setSf(int sf) {
        this.sf = sf;
    }

    public void setΑ(double α) {
        this.α = α;
    }

    public void setΒ(double β) {
        this.β = β;
    }

    public int[] getMovementHistory() {
        return movementHistory;
    }
    
    public int getR() {
        return r;
    }

    public int getSf() {
        return sf;
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