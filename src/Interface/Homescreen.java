package Interface;

// SE IMPORTAN LAS CLASES Y LIBRERIAS NECESARIAS.
import EDD.GrafoMA;
import EDD.Global;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import functions.FileChooser;
import functions.GraphStream;

/**
 * Esta clase representa la página principal del programa.
 * @author Nicolás Planas
 */
public class Homescreen extends javax.swing.JFrame {

    // GRAFO PARA EL ARCHIVO TXT.
    private GrafoMA grafo = Global.getGrafo();
    
    // RECORRIDO MÁS CORTO DE LA SIMULACIÓN.
    private int[] shortestPath;
    
    /**
     * Este es el constructor de la clase y no recibe parámetros.
     */
    public Homescreen() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        txtMatriz.setText(grafo.printMatrix());
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        title2 = new javax.swing.JLabel();
        title1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMatriz = new javax.swing.JTextArea();
        import_txt = new javax.swing.JButton();
        manage_txt = new javax.swing.JButton();
        go_to_simulation = new javax.swing.JButton();
        show_graph = new javax.swing.JButton();
        close_window = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        save_txt = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jLabel9.setIcon(new javax.swing.ImageIcon("/Users/nicolasplanas/Desktop/Images/ant_trail.png")); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(725, 460));
        setPreferredSize(new java.awt.Dimension(725, 435));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title2.setFont(new java.awt.Font("Woodchuck", 0, 36)); // NOI18N
        title2.setForeground(new java.awt.Color(51, 51, 51));
        title2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title2.setText("COLONIAS DE HORMIGAS");
        getContentPane().add(title2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 560, -1));

        title1.setFont(new java.awt.Font("Woodchuck", 0, 36)); // NOI18N
        title1.setForeground(new java.awt.Color(51, 51, 51));
        title1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title1.setText("OPTIMIZACIÓN DE");
        getContentPane().add(title1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 560, -1));

        txtMatriz.setEditable(false);
        txtMatriz.setBackground(new java.awt.Color(255, 255, 255));
        txtMatriz.setColumns(20);
        txtMatriz.setFont(new java.awt.Font("Aspekta", 1, 13)); // NOI18N
        txtMatriz.setRows(5);
        jScrollPane1.setViewportView(txtMatriz);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 300, 200));

        import_txt.setFont(new java.awt.Font("Aspekta", 0, 14)); // NOI18N
        import_txt.setForeground(new java.awt.Color(51, 51, 51));
        import_txt.setText("IMPORTAR");
        import_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                import_txtActionPerformed(evt);
            }
        });
        getContentPane().add(import_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, 120, 40));

        manage_txt.setFont(new java.awt.Font("Aspekta", 0, 14)); // NOI18N
        manage_txt.setForeground(new java.awt.Color(51, 51, 51));
        manage_txt.setText("GESTIONAR");
        manage_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manage_txtActionPerformed(evt);
            }
        });
        getContentPane().add(manage_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, 120, 40));

        go_to_simulation.setFont(new java.awt.Font("Aspekta", 1, 14)); // NOI18N
        go_to_simulation.setForeground(new java.awt.Color(51, 51, 51));
        go_to_simulation.setText("SIMULACIÓN");
        go_to_simulation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                go_to_simulationActionPerformed(evt);
            }
        });
        getContentPane().add(go_to_simulation, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 250, 120, 40));

        show_graph.setFont(new java.awt.Font("Aspekta", 0, 14)); // NOI18N
        show_graph.setForeground(new java.awt.Color(51, 51, 51));
        show_graph.setText("VER GRAFO");
        show_graph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show_graphActionPerformed(evt);
            }
        });
        getContentPane().add(show_graph, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 290, 120, 40));

        close_window.setFont(new java.awt.Font("Woodchuck", 0, 18)); // NOI18N
        close_window.setText("X");
        close_window.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                close_windowActionPerformed(evt);
            }
        });
        getContentPane().add(close_window, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 30, 30));

        jLabel2.setFont(new java.awt.Font("Aspekta", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("AL ARCHIVO TXT)");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, 300, 50));

        jLabel4.setFont(new java.awt.Font("Aspekta", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("(MATRIZ CORRESPONDIENTE");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 300, 40));

        save_txt.setFont(new java.awt.Font("Aspekta", 0, 14)); // NOI18N
        save_txt.setForeground(new java.awt.Color(51, 51, 51));
        save_txt.setText("GUARDAR");
        save_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_txtActionPerformed(evt);
            }
        });
        getContentPane().add(save_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, 120, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon("/Users/nicolasplanas/Desktop/Images/ant_trail.png")); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -30, 200, 160));
        jLabel3.getAccessibleContext().setAccessibleName("");

        jLabel6.setIcon(new javax.swing.ImageIcon("/Users/nicolasplanas/Desktop/Images/ant_trail.png")); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 310, 200, 160));

        jLabel7.setIcon(new javax.swing.ImageIcon("/Users/nicolasplanas/Desktop/Images/ant_trail.png")); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 310, 200, 160));

        jLabel8.setIcon(new javax.swing.ImageIcon("/Users/nicolasplanas/Desktop/Images/ant_trail.png")); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -30, 200, 160));

        jLabel10.setIcon(new javax.swing.ImageIcon("/Users/nicolasplanas/Desktop/Images/ant_trail.png")); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -30, 200, 160));

        jLabel5.setIcon(new javax.swing.ImageIcon("/Users/nicolasplanas/Desktop/Images/background.png")); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, -50, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void import_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_import_txtActionPerformed
        FileChooser archivo = new FileChooser();
        try {
            archivo.readFile();
            int numVertices = archivo.getNumVertex();
            String[] aristas = archivo.getEdges();
            grafo.setNumVertex(numVertices);

            for (int i = 0; i < archivo.getNumEdges(); i++) {
                String[] arista = aristas[i].split(",");
                grafo.insertEdge(Integer.parseInt(arista[0])-1, Integer.parseInt(arista[1])-1, Double.parseDouble(arista[2]));
            }
            txtMatriz.setText(grafo.printMatrix());
        } catch (IOException ex) {
            Logger.getLogger(Homescreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_import_txtActionPerformed

    private void manage_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manage_txtActionPerformed
        if (txtMatriz.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "¡No haz importado ningún archivo!");
        } else {
        AddOrDeleteCity v2 = new AddOrDeleteCity();
        this.setVisible(false);
        v2.setVisible(true);
        }
    }//GEN-LAST:event_manage_txtActionPerformed

    private void go_to_simulationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_go_to_simulationActionPerformed
        if (txtMatriz.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "¡No haz importado ningún archivo!");
        } else {
            this.setVisible(false);
            Simulation v3 = new Simulation();
            v3.setVisible(true);
        }
    }//GEN-LAST:event_go_to_simulationActionPerformed

    private void show_graphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_show_graphActionPerformed
        if (txtMatriz.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "¡No haz importado ningún archivo!");
        } else {
            GraphStream grafico = new GraphStream();
            int numVertices = grafo.getNumVertex();
            grafico.paintGraph(numVertices, grafo.getMatrixA(), shortestPath);
        }
    }//GEN-LAST:event_show_graphActionPerformed

    private void close_windowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_close_windowActionPerformed
        this.dispose();
    }//GEN-LAST:event_close_windowActionPerformed

    private void save_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_txtActionPerformed
        if (!txtMatriz.getText().isBlank()) {
            FileChooser file = new FileChooser();
            try {
                file.saveFile(grafo.getNumVertex(), grafo.getMatrixA());
                JOptionPane.showMessageDialog(null, "¡Archivo txt guardado con éxito!");
            } catch (IOException ex) {
                Logger.getLogger(Homescreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "¡No haz importado ningún archivo!");
        }
    }//GEN-LAST:event_save_txtActionPerformed
   
    public GrafoMA getGrafo() {
        return grafo;
    }
    
    public void setArray(int[] array) {
        this.shortestPath = array;
    }
    
    /**
     * Este método inicializa la ventana.
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Homescreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Homescreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Homescreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Homescreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Homescreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton close_window;
    private javax.swing.JButton go_to_simulation;
    private javax.swing.JButton import_txt;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton manage_txt;
    private javax.swing.JButton save_txt;
    private javax.swing.JButton show_graph;
    private javax.swing.JLabel title1;
    private javax.swing.JLabel title2;
    private javax.swing.JTextArea txtMatriz;
    // End of variables declaration//GEN-END:variables
}
