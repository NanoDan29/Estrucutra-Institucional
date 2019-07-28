package BDD;

import java.awt.Cursor;
import java.util.concurrent.ExecutionException;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import orcl.conexion;

/**
 *
 * @author Gt37285
 */

public class Conexion extends javax.swing.JFrame {

    /*Se crean variables privadas para toda la clase*/
    
    private String username, password, port, host,ip;
    private conexion con;
    
    /*Inicializacion del constructor*/
    
    public Conexion() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        /*Inicializacion de las variables de conexion */
        
        txt_username.setText("jbpai");
        txt_password.setText("jbpai");
        txt_port.setText("1521");
        txt_host.setText("orcl");
        txt_url.setText("localhost");
        
        /*Eventos de mouse para cada boton del frame*/
        
        btn_conectar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_salir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_testConexion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_password = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        txt_host = new javax.swing.JTextField();
        txt_port = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_url = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btn_salir = new javax.swing.JButton();
        btn_conectar = new javax.swing.JButton();
        btn_testConexion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Conexion oracle 10g");

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel1.setText("Username: ");

        txt_username.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel2.setText("Password:");

        txt_password.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        txt_password.setText("jPasswordField1");

        jLabel5.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel5.setText("Port:");

        txt_host.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N

        txt_port.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel3.setText("Host:");

        txt_url.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel4.setText("URL IP:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_port))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_host, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_url)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(txt_port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txt_host, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_url, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_salir.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        btn_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/iconos/salida.png"))); // NOI18N
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });

        btn_conectar.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        btn_conectar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/iconos/base-de-datos.png"))); // NOI18N
        btn_conectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_conectarActionPerformed(evt);
            }
        });

        btn_testConexion.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        btn_testConexion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/iconos/base-de-datos2.png"))); // NOI18N
        btn_testConexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_testConexionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_conectar)
                    .addComponent(btn_testConexion)
                    .addComponent(btn_salir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_testConexion, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_conectar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
    
    /*Este evento ejecutara la accion de salir del formulario*/
        
        int val = JOptionPane.showConfirmDialog(null, "Estas Seguro de querer salir?",
                 "Confirmacion", 0, JOptionPane.QUESTION_MESSAGE);
        if (val == 0 ) System.exit(0)  ;
    }//GEN-LAST:event_btn_salirActionPerformed

    private void btn_testConexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_testConexionActionPerformed
      
    /* La accion de este boton testeara la conexion  */    
        
        
        try{
            getDatos();

            con = new conexion(username,password, port, host, ip);

            con.connection();
            
            /* Ejecuta un hilo de espara de 1 segundo mientras valida la conexion */

            if(con.isCont()){
                Thread.sleep(1000);
                String mensaje = "Test de Conexion Completado\nConexion Establecida";
                JOptionPane.showMessageDialog(null, mensaje, "Alert!", JOptionPane.INFORMATION_MESSAGE);

            }

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btn_testConexionActionPerformed

    private void btn_conectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_conectarActionPerformed
        
    /*La accion de est boton, realiza la conexion y redirige al frame principal*/   
    
    
        try{
            getDatos();
            
            con = new conexion(username,password, port, host, ip);
            
            con.connection();
            
            if(con.isCont()){
                Thread.sleep(1000);
                String mensaje = "Conexion Establecida";
                JOptionPane.showMessageDialog(null, mensaje, 
                        "Alert!", JOptionPane.INFORMATION_MESSAGE);
                
                this.dispose();
                Proyecto e = new Proyecto(username, password, port, host, ip);
                e.setVisible(true);
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_conectarActionPerformed

    
    public void getDatos(){
        try {
            this.username = txt_username.getText().trim();
            this.password = txt_password.getText().trim();
            this.port = txt_port.getText();
            this.host = txt_host.getText();
            this.ip = txt_url.getText();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(),
                    "Error!", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
    
    
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
            java.util.logging.Logger.getLogger(Conexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Conexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Conexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Conexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Conexion().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_conectar;
    private javax.swing.JButton btn_salir;
    private javax.swing.JButton btn_testConexion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txt_host;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_port;
    private javax.swing.JTextField txt_url;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
