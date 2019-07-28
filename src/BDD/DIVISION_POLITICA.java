package BDD;

import java.awt.Cursor;
import java.awt.List;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;
import orcl.datosArbol_est_inst;
import orcl.datosArbol_div_politica;
import orcl.datosTabla;
import orcl.Division;
import orcl.Estructura;
import orcl.Menu;
import orcl.crud;

/**
 *
 * @author Gt37285
 */

public class DIVISION_POLITICA extends javax.swing.JFrame {

    DefaultTreeModel modeloArbol;
    private String username,password, port, host, ip;
    datosArbol_div_politica da;
    crud cn;
    Menu mn;
    
    public DIVISION_POLITICA(String user, String pass, String port, String host, String Ip) {
        initComponents();
        
        this.setLocationRelativeTo(null);
        this.username = user;
        this.password = pass;
        this.port = port;
        this.host = host;
        this.ip = ip;
        
        
        
        da = new datosArbol_div_politica(username, password, port, host, Ip);
        cn = new crud(username, password, port, host, ip);
        mn = new Menu(username, password, port, host, ip);
        
     
        try {
           
            cargarDatos();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), 
                    "Error!", JOptionPane.ERROR_MESSAGE);
        }
        
    }

    private DIVISION_POLITICA() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtr_division = new javax.swing.JTree();
        jPanel1 = new javax.swing.JPanel();
        btn_connect = new javax.swing.JButton();
        btn_exit = new javax.swing.JButton();
        txt_id_div = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_idp_div = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cb_un_div = new javax.swing.JComboBox<>();
        sp_nivel_div = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_nombre_div = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Divison Politica Ecuatoriana");

        jtr_division.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jtr_division.setForeground(new java.awt.Color(153, 153, 153));
        jtr_division.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtr_divisionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtr_division);

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        btn_connect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/iconos/base-de-datos.png"))); // NOI18N
        btn_connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_connectActionPerformed(evt);
            }
        });

        btn_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/iconos/salida.png"))); // NOI18N
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });

        txt_id_div.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel1.setText("ID");

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel2.setText("ID_P");

        txt_idp_div.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel3.setText("U Nivel");

        cb_un_div.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        cb_un_div.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "N", "S" }));

        sp_nivel_div.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        sp_nivel_div.setModel(new javax.swing.SpinnerNumberModel(0, 0, 7, 1));

        jLabel4.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel4.setText("Nivel");

        jLabel5.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel5.setText("Nombre");

        txt_nombre_div.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(txt_id_div, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txt_idp_div))
                                .addComponent(txt_nombre_div, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(sp_nivel_div, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cb_un_div, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btn_connect, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_id_div, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txt_idp_div, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_nombre_div, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_un_div, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(sp_nivel_div, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_connect, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_exit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jMenuBar1.setBackground(new java.awt.Color(204, 204, 204));
        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuBar1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/iconos/ajustes.png"))); // NOI18N
        jMenu1.setText("Opciones");
        jMenu1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/iconos/flecha-hacia-arriba.png"))); // NOI18N
        jMenuItem2.setText("Commit");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);
        jMenu1.add(jSeparator1);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/iconos/flechas.png"))); // NOI18N
        jMenuItem3.setText("Rollback");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/iconos/usuario1.png"))); // NOI18N
        jMenu2.setText("Acerca de:");
        jMenu2.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void jtr_divisionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtr_divisionMouseClicked
        
        try{
            
            TreeSelectionModel s = jtr_division.getSelectionModel();
            
            if(s.getSelectionCount() > 0){
                DefaultMutableTreeNode node = ( DefaultMutableTreeNode ) jtr_division.getSelectionPath().getLastPathComponent();
                String data = node.getUserObject().toString();
                data = data.substring(0,data.lastIndexOf(".")).trim();
            
                ArrayList<Division> lista = da.getDataCrud_institucional();
                
                for (int i = 0; i < lista.size(); i++) {
                    
                    
                    if(data.equals(lista.get(i).getId_division())){
                        
                        txt_id_div.setText(lista.get(i).getId_division());
                        txt_idp_div.setText(lista.get(i).getId_divisionp());
                        txt_nombre_div.setText(lista.get(i).getNombre());
                        cb_un_div.setSelectedItem(lista.get(i).getUltimo_nivel());
                        sp_nivel_div.setValue(Integer.parseInt(lista.get(i).getNivel()));
                    }
                }
            }
            
        }catch(Exception e){
            
        }
        
    }//GEN-LAST:event_jtr_divisionMouseClicked

   
    
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

       

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed

       

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked

        AcercaDe n = new AcercaDe();
        n.setVisible(true);

    }//GEN-LAST:event_jMenu2MouseClicked

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        int val = JOptionPane.showConfirmDialog(null, "Estas Seguro de querer salir?",
            "Confirmacion", 0, JOptionPane.QUESTION_MESSAGE);
        if (val == 0 ) System.exit(0)  ;
    }//GEN-LAST:event_btn_exitActionPerformed

    private void btn_connectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_connectActionPerformed

    }//GEN-LAST:event_btn_connectActionPerformed

    
    public void cargarDatos()  {
    
        /*Se crea un nodo general que tendra a todas las raices padre*/
        DefaultMutableTreeNode raizPadre = new
                       DefaultMutableTreeNode("DIVISION POLITICA");
        /*Se guarda en una lista de tipo division todos los padres
        que se encuentren en la base de datos*/
        
        ArrayList<Division>  lista =  da.getDataPadre();
        
        
        /*algoritmo recursivo para la impresion de hijos*/
        data_recursiva(raizPadre, lista);
        
        /*Se agrega el padre general al modelo y el modelo al arbol*/
        
        modeloArbol = new DefaultTreeModel(raizPadre);
        jtr_division.setModel(modeloArbol);
        
    }
    
    
   public void data_recursiva(DefaultMutableTreeNode raiz,ArrayList<Division> lista){
        
        String departamento;
        for (int i = 0; i < lista.size(); i++) {
            departamento = lista.get(i).getId_division()+".     "+lista.get(i).getNombre();
            DefaultMutableTreeNode n1 = new DefaultMutableTreeNode(departamento);
            
            if( lista.get(i).getHoja().equals("0") ){
                
                ArrayList<Division> listad =  da.getData( lista.get(i).getId_division());
                data_recursiva(n1, listad);
            }
            raiz.add(n1);
        }
    }
    
   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DIVISION_POLITICA().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_connect;
    private javax.swing.JButton btn_exit;
    private javax.swing.JComboBox<String> cb_un_div;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTree jtr_division;
    private javax.swing.JSpinner sp_nivel_div;
    private javax.swing.JTextField txt_id_div;
    private javax.swing.JTextField txt_idp_div;
    private javax.swing.JTextField txt_nombre_div;
    // End of variables declaration//GEN-END:variables
}
