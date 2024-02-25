package functions;

//Importando librerias para la lectura y Escritura de archivos txt
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;


/**
 * Clase FileChooser. Sirve para crear un object "txtFile" que se le puede aplicar ReadFile y SaveFile.
 * @author Ricardo Machado
 */
public class FileChooser {

    private int numVertex = 0;
    private String[] edges = new String[50];
    private int numEdges = 0;

    
    public String[] getEdges() {
        return edges;
    }

    public void setEdges(String[] edges) {
        this.edges = edges;
    }

    public int getNumVertex() {
        return numVertex;
    }

    public void setNumVertex(int numVertex) {
        this.numVertex = numVertex;
    }

    public int getNumEdges() {
        return numEdges;
    }

    public void setNumEdges(int numEdges) {
        this.numEdges = numEdges;
    }
    
    /**
     * Método para leer un archivo txt desde un directorio.
     */
    public void readFile() throws FileNotFoundException, IOException{
        
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
                                numVertex++;
                            }else{
                                edges[i] = line;
                                numEdges++;
                                i++;
                            }
                            line = in.readLine();
                        }
                        in.close();     
		}
    }
    
    /**
     * Método para guardar un archivo txt del grafo en la carpeta del proyecto
     * @param numVertex Indica la cantidad de ciudades que tiene el grafo actualmente.
     * @param MatrixA Sirve para obtener las aristas por cada ciudad.
     */
    public void saveFile(int numVertex, double[][] MatrixA) throws IOException{
        
        //Creando el archivo txt
        File file = new File("GrafoUsuario.txt");
        file.createNewFile();
        //Creando el escritor para el archivo GrafoUsuario.txt
        FileWriter writer = new FileWriter(file);
        writer.write("ciudad"+"\n");
        
        //Llenando el txt con la cantidad de ciudades.
        for (int i = 1; i <= numVertex; i++) {
            writer.write(Integer.toString(i)+"\n");
        }
        
        writer.write("aristas"+"\n");
        //Llenando el txt con la cantidad de aristas.
        for (int i = 0; i < numVertex; i++) {
            for (int j = i; j < numVertex; j++) {
                if(MatrixA[i][j] != 0){
                    String strEdges = Integer.toString(i+1) + "," + Integer.toString(j+1) + ","+ String.valueOf(MatrixA[i][j] + "\n");
                    writer.write(strEdges);
                }
            }
        }
        //Cerrando la escritura del archivo.
        writer.close();
    }
}
