package Interface;

import EDD.Global;
import EDD.GrafoMA;
import javax.swing.JOptionPane;

public class AddOrDeleteCity extends javax.swing.JFrame {
    
    private GrafoMA grafo = Global.getGrafo();
    
    public AddOrDeleteCity() {
        initComponents();
        this.setVisible(false);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        deleteVertex = new javax.swing.JButton();
        ciudadEliminar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        addVertex = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAristas = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        text2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(725, 410));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        deleteVertex.setFont(new java.awt.Font("Aspekta", 0, 13)); // NOI18N
        deleteVertex.setForeground(new java.awt.Color(51, 51, 51));
        deleteVertex.setText("ACEPTAR");
        deleteVertex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteVertexActionPerformed(evt);
            }
        });
        getContentPane().add(deleteVertex, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, 100, -1));

        ciudadEliminar.setFont(new java.awt.Font("Aspekta", 1, 13)); // NOI18N
        ciudadEliminar.setForeground(new java.awt.Color(51, 51, 51));
        getContentPane().add(ciudadEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 150, 40, 30));

        jLabel3.setFont(new java.awt.Font("Aspekta", 2, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("DE LA CIUDAD:");
        jLabel3.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 180, 30));

        jLabel4.setFont(new java.awt.Font("Aspekta", 2, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("INGRESE EL NÚMERO");
        jLabel4.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 160, 30));

        addVertex.setFont(new java.awt.Font("Aspekta", 1, 13)); // NOI18N
        addVertex.setForeground(new java.awt.Color(51, 51, 51));
        addVertex.setText("ACEPTAR");
        addVertex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addVertexActionPerformed(evt);
            }
        });
        getContentPane().add(addVertex, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 100, -1));

        txtAristas.setColumns(20);
        txtAristas.setFont(new java.awt.Font("Aspekta", 1, 13)); // NOI18N
        txtAristas.setForeground(new java.awt.Color(51, 51, 51));
        txtAristas.setRows(5);
        jScrollPane2.setViewportView(txtAristas);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 260, 100));

        jLabel5.setFont(new java.awt.Font("Aspekta", 2, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("DEBE HACER UN SALTO DE LÍNEA!");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 240, 20));

        jLabel6.setFont(new java.awt.Font("Aspekta", 2, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("INDIQUE LAS CONEXIONES CON OTRAS CIUDADES ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 380, 30));

        jLabel8.setFont(new java.awt.Font("Aspekta", 2, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("EN EL FORMATO: \"CIUDAD DESTINO, PONDERACIÓN\"");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 380, 30));

        jLabel9.setFont(new java.awt.Font("Aspekta", 2, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("EN CASO DE EXISTIR MÁS DE UNA CONEXIÓN");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 300, 20));

        jLabel1.setFont(new java.awt.Font("Woodchuck", 0, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("AGREGAR CIUDAD");
        jLabel1.setToolTipText("");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 300, 60));

        text2.setFont(new java.awt.Font("Woodchuck", 0, 28)); // NOI18N
        text2.setForeground(new java.awt.Color(51, 51, 51));
        text2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        text2.setText("ELIMINAR CIUDAD");
        text2.setToolTipText("");
        getContentPane().add(text2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 330, 40));

        jButton1.setFont(new java.awt.Font("Aspekta", 0, 13)); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, 30, 30));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 320, 70));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 310, 20));

        jButton2.setFont(new java.awt.Font("Woodchuck", 0, 18)); // NOI18N
        jButton2.setText("X");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(682, 10, 30, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteVertexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteVertexActionPerformed
        if(!"".equalsIgnoreCase(ciudadEliminar.getText())){
            grafo.deleteVertex(Integer.parseInt(ciudadEliminar.getText()) - 1);
            JOptionPane.showMessageDialog(null,"¡Ciudad eliminada con éxito!");
        }else{
            JOptionPane.showMessageDialog(null, "Debes indicar el número de ciudad a eliminar");
        }
        
    }//GEN-LAST:event_deleteVertexActionPerformed

    private void addVertexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addVertexActionPerformed
        if(!"".equals(txtAristas.getText())){
            grafo.insertVertex(1);
            String aristas = txtAristas.getText();
            String[] aristasArray = aristas.split("\n");
            for (int i = 0; i < aristasArray.length; i++) {
                String[] arista = aristasArray[i].split(",");
                grafo.insertEdge(grafo.getNumVertex()-1,Integer.parseInt(arista[0]) - 1, Double.parseDouble(arista[1]));
            }
            txtAristas.setText("");
            JOptionPane.showMessageDialog(null, "Ciudad " + grafo.getNumVertex() + " creada con sus aristas");
        }else{
            JOptionPane.showMessageDialog(null, "Debe llenar la información de las aristas");
        }
    }//GEN-LAST:event_addVertexActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Homescreen v1 = new Homescreen();
        this.setVisible(false);
        v1.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(AddOrDeleteCity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddOrDeleteCity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddOrDeleteCity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddOrDeleteCity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddOrDeleteCity().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addVertex;
    private javax.swing.JTextField ciudadEliminar;
    private javax.swing.JButton deleteVertex;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel text2;
    private javax.swing.JTextArea txtAristas;
    // End of variables declaration//GEN-END:variables
}
