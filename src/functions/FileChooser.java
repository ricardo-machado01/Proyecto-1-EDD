package functions;

//Importando librerias para la lectura y Escritura de archivos txt
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;


/**
 * Clase FileChooser. Sirve para crear un object "txtFile" que se le puede aplicar ReadFile y SaveFile.
 * @author Ricardo Machado
 */
public class FileChooser {

    private int numVertices = 0;
    private String[] aristas = new String[50];
    private int numAristas = 0;

    
    public String[] getAristas() {
        return aristas;
    }

    public void setAristas(String[] aristas) {
        this.aristas = aristas;
    }

    public int getNumVertices() {
        return numVertices;
    }

    public void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }

    public int getNumAristas() {
        return numAristas;
    }

    public void setNumAristas(int nroAristas) {
        this.numAristas = nroAristas;
    }
    
    /**
     * Método para leer un archivo txt desde un directorio.
     */
    public void leerArchivo() throws FileNotFoundException, IOException{
        
        boolean ciudad = false; 
        int i = 0;
        
        //Creando el objecto JFileChooser
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        //Filtrando archivos txt en la selección de archivos.
                jfc.setDialogTitle("Select txt");
		jfc.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo texto", "txt");
		jfc.addChoosableFileFilter(filter);
                
                //abrir la ventana de selección del documento.
		int returnValue = jfc.showOpenDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) { //JFileChooser.APPROVE_OPTION Si el usuario le dio open en la ventana selección.
                        //Abrir el archivo seleccionado.
			File file = jfc.getSelectedFile();
                        //Creando lector de archivo seleccionado.
                        FileReader files = new FileReader(file);
                        BufferedReader in = new BufferedReader(files);
                        String line = in.readLine();
                        while (line != null) {
                            if(line.equals("ciudad")){
                                ciudad = true;
                                line = in.readLine();
                            }
                            if(line.equals("aristas")){
                                ciudad = false;
                                line = in.readLine();
                            }
                            if(ciudad == true){
                                numVertices++;
                            }else{
                                aristas[i] = line;
                                numAristas++;
                                i++;
                            }
                            line = in.readLine();
                        }
                        in.close();     
		}
    }
    
    /**
     * Método para guardar un archivo txt del grafo en la carpeta del proyecto
     * @param numVertices Indica la cantidad de ciudades que tiene el grafo actualmente.
     * @param MatrizAdyacencia Sirve para obtener las aristas por cada ciudad.
     */
    public void guardarArchivo(int numVertices, double[][] MatrizAdyacencia) throws IOException{
        
        //Creando el archivo txt
        File file = new File("GrafoUsuario.txt");
        file.createNewFile();
        //Creando el escritor para el archivo GrafoUsuario.txt
        FileWriter writer = new FileWriter(file);
        writer.write("ciudad"+"\n");
        
        //Llenando el txt con la cantidad de ciudades.
        for (int i = 1; i <= numVertices; i++) {
            writer.write(Integer.toString(i)+"\n");
        }
        
        writer.write("aristas"+"\n");
        //Llenando el txt con la cantidad de aristas.
        for (int i = 0; i < numVertices; i++) {
            for (int j = i; j < numVertices; j++) {
                if(MatrizAdyacencia[i][j] != 0){
                    String arista = Integer.toString(i+1) + "," + Integer.toString(j+1) + ","+ String.valueOf(MatrizAdyacencia[i][j] + "\n");
                    writer.write(arista);
                }
            }
        }
        //Cerrando la escritura del archivo.
        writer.close();
        JOptionPane.showMessageDialog(null, "Archivo grafo guardado con éxito");
    }
}
