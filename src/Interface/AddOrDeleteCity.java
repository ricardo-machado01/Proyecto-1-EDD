package Interface;

// SE IMPORTAN LAS CLASES Y LIBRERÍAS NECESARIAS.
import EDD.Global;
import EDD.GrafoMA;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 * Esta clase representa la página de gestión del archivo txt. 
 * @author Nicolás Planas
 */
public class AddOrDeleteCity extends javax.swing.JFrame {
    
    private GrafoMA grafo = Global.getGrafo();
    
    /**
     *  Este es el constructor de la clase y no recibe parámetros.
     */
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

        jLabel1 = new javax.swing.JLabel();
        delete_vertex = new javax.swing.JButton();
        delete_vertex_input = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        add_vertex = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        add_city_input = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        title1 = new javax.swing.JLabel();
        title2 = new javax.swing.JLabel();
        go_to_homepage = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        close_window = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setIcon(new javax.swing.ImageIcon("/Users/nicolasplanas/Desktop/j.png")); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 725, 410));
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(725, 410));
        setPreferredSize(new java.awt.Dimension(725, 410));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        delete_vertex.setFont(new java.awt.Font("Aspekta", 0, 14)); // NOI18N
        delete_vertex.setForeground(new java.awt.Color(51, 51, 51));
        delete_vertex.setText("ACEPTAR");
        delete_vertex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_vertexActionPerformed(evt);
            }
        });
        getContentPane().add(delete_vertex, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, 100, 40));

        delete_vertex_input.setFont(new java.awt.Font("Aspekta", 1, 13)); // NOI18N
        delete_vertex_input.setForeground(new java.awt.Color(51, 51, 51));
        getContentPane().add(delete_vertex_input, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 40, 30));

        jLabel3.setFont(new java.awt.Font("Aspekta", 2, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("DE LA CIUDAD:");
        jLabel3.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 180, 30));

        jLabel4.setFont(new java.awt.Font("Aspekta", 2, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("INGRESE EL NÚMERO");
        jLabel4.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 160, 30));

        add_vertex.setFont(new java.awt.Font("Aspekta", 1, 14)); // NOI18N
        add_vertex.setForeground(new java.awt.Color(51, 51, 51));
        add_vertex.setText("ACEPTAR");
        add_vertex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_vertexActionPerformed(evt);
            }
        });
        getContentPane().add(add_vertex, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, -1, 40));

        add_city_input.setColumns(20);
        add_city_input.setFont(new java.awt.Font("Aspekta", 1, 13)); // NOI18N
        add_city_input.setForeground(new java.awt.Color(51, 51, 51));
        add_city_input.setRows(5);
        jScrollPane2.setViewportView(add_city_input);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 260, 100));

        jLabel5.setFont(new java.awt.Font("Aspekta", 2, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("DEBE HACER UN SALTO DE LÍNEA!");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 240, 20));

        jLabel6.setFont(new java.awt.Font("Aspekta", 2, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("INDIQUE LAS CONEXIONES CON OTRAS CIUDADES ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 380, 30));

        jLabel8.setFont(new java.awt.Font("Aspekta", 2, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("EN EL FORMATO: \"CIUDAD DESTINO, PONDERACIÓN\"");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 380, 30));

        jLabel9.setFont(new java.awt.Font("Aspekta", 2, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("¡EN CASO DE EXISTIR MÁS DE UNA CONEXIÓN");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 300, 20));

        title1.setFont(new java.awt.Font("Woodchuck", 0, 28)); // NOI18N
        title1.setForeground(new java.awt.Color(51, 51, 51));
        title1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title1.setText("AGREGAR CIUDAD");
        title1.setToolTipText("");
        getContentPane().add(title1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 300, 60));

        title2.setFont(new java.awt.Font("Woodchuck", 0, 28)); // NOI18N
        title2.setForeground(new java.awt.Color(51, 51, 51));
        title2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title2.setText("ELIMINAR CIUDAD");
        title2.setToolTipText("");
        getContentPane().add(title2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, 330, 40));

        go_to_homepage.setFont(new java.awt.Font("Aspekta", 1, 14)); // NOI18N
        go_to_homepage.setText("¡LISTO!");
        go_to_homepage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                go_to_homepageActionPerformed(evt);
            }
        });
        getContentPane().add(go_to_homepage, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 310, 100, 40));

        jSeparator2.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator2.setForeground(new java.awt.Color(51, 51, 51));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 320, 10));

        jSeparator3.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator3.setForeground(new java.awt.Color(51, 51, 51));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 230, 310, 20));

        close_window.setFont(new java.awt.Font("Woodchuck", 0, 18)); // NOI18N
        close_window.setText("X");
        close_window.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                close_windowActionPerformed(evt);
            }
        });
        getContentPane().add(close_window, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 30, 30));

        jSeparator4.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator4.setForeground(new java.awt.Color(51, 51, 51));
        getContentPane().add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 310, 20));

        jLabel7.setIcon(new javax.swing.ImageIcon("/Users/nicolasplanas/Desktop/Images/ant.png")); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 230, -1, 80));

        jLabel2.setIcon(new javax.swing.ImageIcon("/Users/nicolasplanas/Desktop/Images/background.png")); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, -30, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void delete_vertexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_vertexActionPerformed
        final JDialog dialog = new JDialog();
        dialog.setAlwaysOnTop(true);
        
        if(!"".equalsIgnoreCase(delete_vertex_input.getText())){
            grafo.deleteVertex(Integer.parseInt(delete_vertex_input.getText()) - 1);
            JOptionPane.showMessageDialog(dialog,"¡Ciudad eliminada con éxito!");
        }else{
            JOptionPane.showMessageDialog(dialog, "Debes indicar el número de ciudad a eliminar");
        }
    }//GEN-LAST:event_delete_vertexActionPerformed

    private void add_vertexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_vertexActionPerformed
            final JDialog dialog = new JDialog();
            dialog.setAlwaysOnTop(true);
            
            if (!"".equals(add_city_input.getText())) {
                grafo.insertVertex(1);
                String aristas = add_city_input.getText();
                String[] aristasArray = aristas.split("\n");
                for (int i = 0; i < aristasArray.length; i++) {
                    String[] arista = aristasArray[i].split(",");
                    grafo.insertEdge(grafo.getNumVertex()-1, Integer.parseInt(arista[0]) - 1, Double.parseDouble(arista[1]));
                }
                add_city_input.setText("");
                JOptionPane.showMessageDialog(dialog, "Ciudad " + grafo.getNumVertex() + " creada con sus aristas");
            } else {
                JOptionPane.showMessageDialog(dialog, "Debe llenar la información de las aristas");
        }
    }//GEN-LAST:event_add_vertexActionPerformed

    private void go_to_homepageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_go_to_homepageActionPerformed
        Homescreen v1 = new Homescreen();
        this.setVisible(false);
        v1.setVisible(true);
    }//GEN-LAST:event_go_to_homepageActionPerformed

    private void close_windowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_close_windowActionPerformed
        this.dispose();
    }//GEN-LAST:event_close_windowActionPerformed

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
    private javax.swing.JTextArea add_city_input;
    private javax.swing.JButton add_vertex;
    private javax.swing.JButton close_window;
    private javax.swing.JButton delete_vertex;
    private javax.swing.JTextField delete_vertex_input;
    private javax.swing.JButton go_to_homepage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel title1;
    private javax.swing.JLabel title2;
    // End of variables declaration//GEN-END:variables
}
