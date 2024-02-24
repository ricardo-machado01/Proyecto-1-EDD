package Interface;

import EDD.GrafoMA;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import functions.FileChooser;
import functions.GraphStream;
import EDD.CAnt;
import EDD.Global;

public class Homescreen extends javax.swing.JFrame {

    private GrafoMA grafo = Global.getGrafo();
    private int[] array;
    
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

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMatriz = new javax.swing.JTextArea();
        import_txt = new javax.swing.JButton();
        manage_txt = new javax.swing.JButton();
        create_ants = new javax.swing.JButton();
        show_graph = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(560, 530));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Aspekta", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("COLONIAS DE HORMIGAS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 410, -1));

        jLabel3.setFont(new java.awt.Font("Aspekta", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("OPTIMIZACIÓN DE");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 410, -1));

        txtMatriz.setEditable(false);
        txtMatriz.setBackground(new java.awt.Color(255, 255, 255));
        txtMatriz.setColumns(20);
        txtMatriz.setRows(5);
        jScrollPane1.setViewportView(txtMatriz);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 240, 150));

        import_txt.setFont(new java.awt.Font("Aspekta", 0, 13)); // NOI18N
        import_txt.setForeground(new java.awt.Color(102, 102, 102));
        import_txt.setText("IMPORTAR");
        import_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                import_txtActionPerformed(evt);
            }
        });
        getContentPane().add(import_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 330, 120, -1));

        manage_txt.setFont(new java.awt.Font("Aspekta", 0, 13)); // NOI18N
        manage_txt.setForeground(new java.awt.Color(102, 102, 102));
        manage_txt.setText("GESTIONAR");
        manage_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manage_txtActionPerformed(evt);
            }
        });
        getContentPane().add(manage_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 370, 120, -1));

        create_ants.setFont(new java.awt.Font("Aspekta", 1, 13)); // NOI18N
        create_ants.setForeground(new java.awt.Color(102, 102, 102));
        create_ants.setText("SIMULACIÓN");
        create_ants.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_antsActionPerformed(evt);
            }
        });
        getContentPane().add(create_ants, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 410, 120, -1));

        show_graph.setFont(new java.awt.Font("Aspekta", 0, 13)); // NOI18N
        show_graph.setForeground(new java.awt.Color(102, 102, 102));
        show_graph.setText("VER GRAFO");
        show_graph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show_graphActionPerformed(evt);
            }
        });
        getContentPane().add(show_graph, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 450, 120, -1));

        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 30, 30));

        jLabel2.setFont(new java.awt.Font("Aspekta", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("AL ARCHIVO TXT");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 190, -1));

        jLabel4.setFont(new java.awt.Font("Aspekta", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("MATRIZ CORRESPONDIENTE");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 210, -1));

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
            JOptionPane.showMessageDialog(null, "No haz importado ningún archivo!");
        } else {
        AddOrDeleteCity v2 = new AddOrDeleteCity();
        this.setVisible(false);
        v2.setVisible(true);
        }
    }//GEN-LAST:event_manage_txtActionPerformed

    private void create_antsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_antsActionPerformed
        if (txtMatriz.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "No haz importado ningún archivo!");
        } else {
            this.setVisible(false);
            Simulation v3 = new Simulation();
            v3.setVisible(true);
        }
    }//GEN-LAST:event_create_antsActionPerformed

    private void show_graphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_show_graphActionPerformed
        if (txtMatriz.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "No haz importado ningún archivo!");
        } else {
        GraphStream grafico = new GraphStream();
        int numVertices = grafo.getNumVertex();
        grafico.PintarGrafo(numVertices, grafo.getMatrixA(), array);
        }
    }//GEN-LAST:event_show_graphActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
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
        
    public GrafoMA getGrafo() {
        return grafo;
    }
    
    public void setArray(int[] array) {
        this.array = array;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton create_ants;
    private javax.swing.JButton import_txt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton manage_txt;
    private javax.swing.JButton show_graph;
    private javax.swing.JTextArea txtMatriz;
    // End of variables declaration//GEN-END:variables
}
