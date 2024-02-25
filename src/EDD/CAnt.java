package EDD;

// SE IMPORTA LA LIBRERÍA NECESARIA.
import java.util.Random;

/**
 * ESTA CLASE REPRESENTA A LA HORMIGA DENTRO DE LA SIMULACIÓN.
 * @author nicolasplanas
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
     * ESTE ES EL CONSTRUCTOR DE LA CLASE Y RECIBE TRES PARÁMETROS.
     * @param matrix
     * @param r
     * @param sf
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
     * ESTE MÉTODO RECIBE DOS PARÁMETROS Y RETORNA UN
     * DOUBLE CALCULADO EN BASE A LA FÓRMULA 'τ*η'.
     * @param drs
     * @param t
     * @return 
     */
    private double m(double drs, double t){
        return Math.pow(t, α) * Math.pow((Q/drs), β);
    }
    
    /**
     * ESTE MÉTODO RECIBE DOS PARÁMETROS Y RETORNA UN DOUBLE
     * QUE REPRESENTA LA CIUDAD A LA QUE LA HORMIGA SE DESPLAZÓ
     * EN BASE A LA FÓRMULA DE PROBABILIDAD.
     * @param matrix
     * @param pheromoneQuantity
     * @return 
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
    
    /**
     * ESTE MÉTODO RECIBE UN 'int' COMO PARÁMETRO Y
     * SE LO ASIGNA COMO NUEVO VALOR A LA VARIABLE "r".
     * @param r 
     */
    public void setR(int r) {
        this.r = r;
    }

    /**
     * ESTE MÉTODO RECIBE UN 'int' COMO PARÁMETRO Y
     * SE LO ASIGNA COMO NUEVO VALOR A LA VARIABLE "sf".
     * @param sf 
     */
    public void setSf(int sf) {
        this.sf = sf;
    }

    /**
     * ESTE MÉTODO RECIBE UN 'double' COMO PARÁMETRO Y
     * SE LO ASIGNA COMO NUEVO VALOR A LA VARIABLE "α".
     * @param α
     */
    public void setΑ(double α) {
        this.α = α;
    }

    /**
     * ESTE MÉTODO RECIBE UN 'double' COMO PARÁMETRO Y
     * SE LO ASIGNA COMO NUEVO VALOR A LA VARIABLE "β".
     * @param β 
     */
    public void setΒ(double β) {
        this.β = β;
    }

    /**
     * ESTE MÉTODO RETORNA UN VALOR 'int[]' EL CUAL REPRESENTA
     * EL HISTORIAL DE MOVIMIENTO DE LA HORMIGA.
     * @return
     */
    public int[] getMovementHistory() {
        return movementHistory;
    }
    
    /**
     * ESTE MÉTODO RETORNA UN VALOR 'int' EL CUAL REPRESENTA
     * LA POSICIÓN ACTUAL DE LA HORMIGA.
     * @return
     */
    public int getR() {
        return r;
    }

    /**
     * ESTE MÉTODO RETORNA UN VALOR 'int' EL CUAL REPRESENTA
     * LA CIUDAD DESTINO DE LA HORMIGA.
     * @return
     */
    public int getSf() {
        return sf;
    }

    /**
     * ESTE MÉTODO RETORNA UN VALOR 'double' EL CUAL REPRESENTA
     * EL GRADO DE IMPORTANCIA DE LA FEROMONA.
     * @return
     */
    public double getΑ() {
        return α;
    }

    /**
     * ESTE MÉTODO RETORNA UN VALOR 'double' EL CUAL REPRESENTA
     * EL GRADO DE VISIBILIDAD DE LA CIUDAD.
     * @return
     */
    public double getΒ() {
        return β;
    }

    /**
     * ESTE MÉTODO RETORNA UN VALOR 'boolean' EL CUAL REPRESENTA
     * SI LA HORMIGA SE QUEDÓ ENCERRADA EN UNA CIUDAD.
     * @return
     */
    public boolean getTrapped() {
        return trapped;
    }
}