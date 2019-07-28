package BDD;

import java.awt.Cursor;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import orcl.datosArbol_est_inst;
import orcl.datosTabla;
import orcl.Menu;
import orcl.crud;

/**
 *
 * @author Gt37285
 */
public class Estructura extends javax.swing.JFrame {

   
    DefaultTableModel modeloDatos;
    DefaultTreeModel modeloArbol;
    private String username,password, port, host, ip;
    datosTabla dt;
    datosArbol_est_inst da;
    crud cn;
    Menu mn;
    private ArrayList<JMenuItem> itemTabla;
    
   
    public Estructura(String user, String pass, String port, String host, String ip) {
        initComponents();
        
//        /*se inicializan los modelos de tablas y arbol*/
//        
//        modeloDatos = new DefaultTableModel();
//        itemTabla = new ArrayList<JMenuItem>();
//        
//        /*Se inicializa el constructor principal*/
//        
//        this.setLocationRelativeTo(null);
//        this.username = user;
//        this.password = pass;
//        this.port = port;
//        this.host = host;
//        this.ip = ip;
//        
//        /*inicializa la conexion para la clase de recuperar datos en tabla*/
//        dt = new DatosTabla(username, password, port, host, ip);
//        
//        /*inicializa la conexion para la clase de reperar datos en arbol*/
//        da = new DatosArbol(username, password, port, host, ip);
//        
//        /*inicializa la clase de conexion para el crud de cada tabla*/
//        cn = new crud(username, password, port, host, ip);
//        
//        /*inicializa la barra de menu */
//        mn = new Menu(username, password, port, host, ip);
//        
//        /* crea un evento de cursor de mano en los botones principales */
//        btn_add.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//        btn_connect.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//        btn_del.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//        btn_edit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//        btn_exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//        
//        
        
        try {
            
            System.out.println("la informacion enviada es: "+this.username);
            
//            txt_id.setEditable(false);
//            txt_idp.setEditable(false);
            
            /*Se llama a los metodos de carga de informacion para los arboles,
            menu y tablas*/
            
//            cargarDatosArbol();
//            menu();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), 
                    "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    /* Genera un constructor privado, necesario para el envio de parametros por
    el constructor principal */
    
    private Estructura() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    public void cargarDatosArbol() throws SQLException{
    
        ArrayList<orcl.Estructura> lista =  da.getData("1");
        ArrayList<String> raizD = da.getRaiz();
        String dataRaiz = raizD.get(0)+".  "+raizD.get(2);
        DefaultMutableTreeNode raiz = new DefaultMutableTreeNode(dataRaiz);
        
        String departamento;
        data_recursiva(raiz, lista);
        
        modeloArbol = new DefaultTreeModel(raiz);
        jtr_estructura.setModel(modeloArbol);
    }
    
     public void data_recursiva(DefaultMutableTreeNode raiz,
            ArrayList<orcl.Estructura> lista) throws SQLException{
        
        String departamento;
        
        
        for (int i = 0; i < lista.size(); i++) {
            departamento = lista.get(i).getId()+".     "+lista.get(i).getNombre();
            DefaultMutableTreeNode n1 = new DefaultMutableTreeNode(departamento);
            
            if( lista.get(i).getHoja().equals("0") ){
                
                ArrayList<orcl.Estructura> listad =  da.getData( lista.get(i).getId() );
                data_recursiva(n1, listad);
                
            }
            
            raiz.add(n1);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_tabs = new javax.swing.JTabbedPane();
        pn_estructura = new javax.swing.JPanel();
        pn_estructura_institucional = new javax.swing.JPanel();
        btn_connect1 = new javax.swing.JButton();
        btn_exit1 = new javax.swing.JButton();
        btn_del1 = new javax.swing.JButton();
        btn_edit1 = new javax.swing.JButton();
        btn_add1 = new javax.swing.JButton();
        txt_id1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_idp1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cb_un1 = new javax.swing.JComboBox<>();
        sp_nivel1 = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_nombre1 = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jtr_estructura = new javax.swing.JTree();
        pn_division = new javax.swing.JPanel();
        jtr_estructura1 = new javax.swing.JTree();
        pn_opciones_division = new javax.swing.JPanel();
        btn_connect2 = new javax.swing.JButton();
        btn_exit2 = new javax.swing.JButton();
        btn_del2 = new javax.swing.JButton();
        btn_edit2 = new javax.swing.JButton();
        btn_add2 = new javax.swing.JButton();
        txt_id2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_idp2 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        cb_un2 = new javax.swing.JComboBox<>();
        sp_nivel2 = new javax.swing.JSpinner();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_nombre2 = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        pn_cargos = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btn_connect3 = new javax.swing.JButton();
        btn_exit3 = new javax.swing.JButton();
        btn_del3 = new javax.swing.JButton();
        btn_edit3 = new javax.swing.JButton();
        btn_add3 = new javax.swing.JButton();
        txt_id3 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txt_idp3 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        cb_un3 = new javax.swing.JComboBox<>();
        sp_nivel3 = new javax.swing.JSpinner();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txt_nombre3 = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        pn_tbl_cargos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_cargos = new javax.swing.JTable();
        pn_obligaciones = new javax.swing.JPanel();
        pn_sueldos = new javax.swing.JPanel();
        pn_empleados = new javax.swing.JPanel();
        pn_nomina = new javax.swing.JPanel();
        pn_contrato = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jm_tablas = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modulo de Contrato");

        pn_estructura_institucional.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        btn_connect1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/iconos/base-de-datos.png"))); // NOI18N
        btn_connect1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_connect1ActionPerformed(evt);
            }
        });

        btn_exit1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/iconos/salida.png"))); // NOI18N
        btn_exit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exit1ActionPerformed(evt);
            }
        });

        btn_del1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/iconos/boton-x.png"))); // NOI18N
        btn_del1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_del1ActionPerformed(evt);
            }
        });

        btn_edit1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/iconos/editar.png"))); // NOI18N
        btn_edit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edit1ActionPerformed(evt);
            }
        });

        btn_add1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/iconos/mas.png"))); // NOI18N
        btn_add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add1ActionPerformed(evt);
            }
        });

        txt_id1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel6.setText("ID");

        jLabel7.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel7.setText("ID_P");

        txt_idp1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel8.setText("U Nivel");

        cb_un1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        cb_un1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "N", "S" }));

        sp_nivel1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        sp_nivel1.setModel(new javax.swing.SpinnerNumberModel(0, 0, 7, 1));

        jLabel9.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel9.setText("Nivel");

        jLabel10.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel10.setText("Nombre");

        txt_nombre1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N

        javax.swing.GroupLayout pn_estructura_institucionalLayout = new javax.swing.GroupLayout(pn_estructura_institucional);
        pn_estructura_institucional.setLayout(pn_estructura_institucionalLayout);
        pn_estructura_institucionalLayout.setHorizontalGroup(
            pn_estructura_institucionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_estructura_institucionalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_estructura_institucionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_estructura_institucionalLayout.createSequentialGroup()
                        .addGroup(pn_estructura_institucionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pn_estructura_institucionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pn_estructura_institucionalLayout.createSequentialGroup()
                                .addGroup(pn_estructura_institucionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sp_nivel1)
                                    .addComponent(txt_id1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pn_estructura_institucionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pn_estructura_institucionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cb_un1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_idp1)))
                            .addComponent(txt_nombre1)))
                    .addComponent(jSeparator4)
                    .addGroup(pn_estructura_institucionalLayout.createSequentialGroup()
                        .addComponent(btn_add1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_del1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_edit1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_connect1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_exit1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pn_estructura_institucionalLayout.setVerticalGroup(
            pn_estructura_institucionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_estructura_institucionalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_estructura_institucionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_estructura_institucionalLayout.createSequentialGroup()
                        .addGroup(pn_estructura_institucionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_id1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(txt_idp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(pn_estructura_institucionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txt_nombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(pn_estructura_institucionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_un1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(sp_nivel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addGroup(pn_estructura_institucionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_add1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_del1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_connect1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_exit1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pn_estructura_institucionalLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_edit1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jtr_estructura.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jtr_estructura.setForeground(new java.awt.Color(153, 153, 153));
        jtr_estructura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtr_estructuraMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pn_estructuraLayout = new javax.swing.GroupLayout(pn_estructura);
        pn_estructura.setLayout(pn_estructuraLayout);
        pn_estructuraLayout.setHorizontalGroup(
            pn_estructuraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_estructuraLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jtr_estructura, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pn_estructura_institucional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pn_estructuraLayout.setVerticalGroup(
            pn_estructuraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_estructuraLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pn_estructuraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_estructura_institucional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtr_estructura, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pn_tabs.addTab("Estructura_Institucional", pn_estructura);

        jtr_estructura1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jtr_estructura1.setForeground(new java.awt.Color(153, 153, 153));
        jtr_estructura1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtr_estructura1MouseClicked(evt);
            }
        });

        pn_opciones_division.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        btn_connect2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/iconos/base-de-datos.png"))); // NOI18N
        btn_connect2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_connect2ActionPerformed(evt);
            }
        });

        btn_exit2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/iconos/salida.png"))); // NOI18N
        btn_exit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exit2ActionPerformed(evt);
            }
        });

        btn_del2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/iconos/boton-x.png"))); // NOI18N
        btn_del2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_del2ActionPerformed(evt);
            }
        });

        btn_edit2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/iconos/editar.png"))); // NOI18N
        btn_edit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edit2ActionPerformed(evt);
            }
        });

        btn_add2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/iconos/mas.png"))); // NOI18N
        btn_add2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add2ActionPerformed(evt);
            }
        });

        txt_id2.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel11.setText("ID");

        jLabel12.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel12.setText("ID_P");

        txt_idp2.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel13.setText("U Nivel");

        cb_un2.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        cb_un2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "N", "S" }));

        sp_nivel2.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        sp_nivel2.setModel(new javax.swing.SpinnerNumberModel(0, 0, 7, 1));

        jLabel14.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel14.setText("Nivel");

        jLabel15.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel15.setText("Nombre");

        txt_nombre2.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N

        javax.swing.GroupLayout pn_opciones_divisionLayout = new javax.swing.GroupLayout(pn_opciones_division);
        pn_opciones_division.setLayout(pn_opciones_divisionLayout);
        pn_opciones_divisionLayout.setHorizontalGroup(
            pn_opciones_divisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_opciones_divisionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_opciones_divisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_opciones_divisionLayout.createSequentialGroup()
                        .addGroup(pn_opciones_divisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pn_opciones_divisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pn_opciones_divisionLayout.createSequentialGroup()
                                .addGroup(pn_opciones_divisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sp_nivel2)
                                    .addComponent(txt_id2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pn_opciones_divisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pn_opciones_divisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cb_un2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_idp2)))
                            .addComponent(txt_nombre2)))
                    .addComponent(jSeparator5)
                    .addGroup(pn_opciones_divisionLayout.createSequentialGroup()
                        .addComponent(btn_add2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_del2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_edit2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_connect2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_exit2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pn_opciones_divisionLayout.setVerticalGroup(
            pn_opciones_divisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_opciones_divisionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_opciones_divisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_opciones_divisionLayout.createSequentialGroup()
                        .addGroup(pn_opciones_divisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_id2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(txt_idp2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(pn_opciones_divisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txt_nombre2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(pn_opciones_divisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_un2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(sp_nivel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addGroup(pn_opciones_divisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_add2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_del2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_connect2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_exit2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pn_opciones_divisionLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_edit2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout pn_divisionLayout = new javax.swing.GroupLayout(pn_division);
        pn_division.setLayout(pn_divisionLayout);
        pn_divisionLayout.setHorizontalGroup(
            pn_divisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_divisionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jtr_estructura1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pn_opciones_division, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pn_divisionLayout.setVerticalGroup(
            pn_divisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_divisionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_divisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_opciones_division, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtr_estructura1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pn_tabs.addTab("Division_Politica", pn_division);

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        btn_connect3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/iconos/base-de-datos.png"))); // NOI18N
        btn_connect3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_connect3ActionPerformed(evt);
            }
        });

        btn_exit3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/iconos/salida.png"))); // NOI18N
        btn_exit3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exit3ActionPerformed(evt);
            }
        });

        btn_del3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/iconos/boton-x.png"))); // NOI18N
        btn_del3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_del3ActionPerformed(evt);
            }
        });

        btn_edit3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/iconos/editar.png"))); // NOI18N
        btn_edit3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edit3ActionPerformed(evt);
            }
        });

        btn_add3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/iconos/mas.png"))); // NOI18N
        btn_add3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add3ActionPerformed(evt);
            }
        });

        txt_id3.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel16.setText("ID");

        jLabel17.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel17.setText("ID_P");

        txt_idp3.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel18.setText("U Nivel");

        cb_un3.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        cb_un3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "N", "S" }));

        sp_nivel3.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        sp_nivel3.setModel(new javax.swing.SpinnerNumberModel(0, 0, 7, 1));

        jLabel19.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel19.setText("Nivel");

        jLabel20.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel20.setText("Nombre");

        txt_nombre3.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sp_nivel3)
                                    .addComponent(txt_id3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cb_un3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_idp3)))
                            .addComponent(txt_nombre3)))
                    .addComponent(jSeparator6)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btn_add3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_del3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_edit3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_connect3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_exit3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_id3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(txt_idp3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(txt_nombre3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_un3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(sp_nivel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_add3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_del3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_connect3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_exit3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_edit3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        tbl_cargos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbl_cargos);

        javax.swing.GroupLayout pn_tbl_cargosLayout = new javax.swing.GroupLayout(pn_tbl_cargos);
        pn_tbl_cargos.setLayout(pn_tbl_cargosLayout);
        pn_tbl_cargosLayout.setHorizontalGroup(
            pn_tbl_cargosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
        );
        pn_tbl_cargosLayout.setVerticalGroup(
            pn_tbl_cargosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pn_cargosLayout = new javax.swing.GroupLayout(pn_cargos);
        pn_cargos.setLayout(pn_cargosLayout);
        pn_cargosLayout.setHorizontalGroup(
            pn_cargosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_cargosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pn_tbl_cargos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pn_cargosLayout.setVerticalGroup(
            pn_cargosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_cargosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_cargosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pn_tbl_cargos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pn_tabs.addTab("Cargos", pn_cargos);

        javax.swing.GroupLayout pn_obligacionesLayout = new javax.swing.GroupLayout(pn_obligaciones);
        pn_obligaciones.setLayout(pn_obligacionesLayout);
        pn_obligacionesLayout.setHorizontalGroup(
            pn_obligacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );
        pn_obligacionesLayout.setVerticalGroup(
            pn_obligacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 254, Short.MAX_VALUE)
        );

        pn_tabs.addTab("Obligaciones", pn_obligaciones);

        javax.swing.GroupLayout pn_sueldosLayout = new javax.swing.GroupLayout(pn_sueldos);
        pn_sueldos.setLayout(pn_sueldosLayout);
        pn_sueldosLayout.setHorizontalGroup(
            pn_sueldosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );
        pn_sueldosLayout.setVerticalGroup(
            pn_sueldosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 254, Short.MAX_VALUE)
        );

        pn_tabs.addTab("Sueldos", pn_sueldos);

        javax.swing.GroupLayout pn_empleadosLayout = new javax.swing.GroupLayout(pn_empleados);
        pn_empleados.setLayout(pn_empleadosLayout);
        pn_empleadosLayout.setHorizontalGroup(
            pn_empleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );
        pn_empleadosLayout.setVerticalGroup(
            pn_empleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 254, Short.MAX_VALUE)
        );

        pn_tabs.addTab("Empleados", pn_empleados);

        javax.swing.GroupLayout pn_nominaLayout = new javax.swing.GroupLayout(pn_nomina);
        pn_nomina.setLayout(pn_nominaLayout);
        pn_nominaLayout.setHorizontalGroup(
            pn_nominaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );
        pn_nominaLayout.setVerticalGroup(
            pn_nominaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 254, Short.MAX_VALUE)
        );

        pn_tabs.addTab("Nominas", pn_nomina);

        javax.swing.GroupLayout pn_contratoLayout = new javax.swing.GroupLayout(pn_contrato);
        pn_contrato.setLayout(pn_contratoLayout);
        pn_contratoLayout.setHorizontalGroup(
            pn_contratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );
        pn_contratoLayout.setVerticalGroup(
            pn_contratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 254, Short.MAX_VALUE)
        );

        pn_tabs.addTab("Contrato", pn_contrato);

        jMenuBar1.setBackground(new java.awt.Color(204, 204, 204));

        jm_tablas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/iconos/nota.png"))); // NOI18N
        jm_tablas.setText("Tablas");
        jMenuBar1.add(jm_tablas);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/iconos/ajustes.png"))); // NOI18N
        jMenu1.setText("Opciones");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
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
            .addComponent(pn_tabs)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pn_tabs))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed


    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed

     

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked

        AcercaDe n = new AcercaDe();
        n.setVisible(true);

    }//GEN-LAST:event_jMenu2MouseClicked

    private void btn_connect1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_connect1ActionPerformed


    }//GEN-LAST:event_btn_connect1ActionPerformed

    private void btn_exit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exit1ActionPerformed

    }//GEN-LAST:event_btn_exit1ActionPerformed

    private void btn_del1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_del1ActionPerformed


    }//GEN-LAST:event_btn_del1ActionPerformed

    private void btn_edit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit1ActionPerformed

     

    }//GEN-LAST:event_btn_edit1ActionPerformed

    private void btn_add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add1ActionPerformed

     

    }//GEN-LAST:event_btn_add1ActionPerformed

    private void jtr_estructuraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtr_estructuraMouseClicked


    }//GEN-LAST:event_jtr_estructuraMouseClicked

    private void jtr_estructura1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtr_estructura1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtr_estructura1MouseClicked

    private void btn_connect2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_connect2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_connect2ActionPerformed

    private void btn_exit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exit2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_exit2ActionPerformed

    private void btn_del2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_del2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_del2ActionPerformed

    private void btn_edit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_edit2ActionPerformed

    private void btn_add2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_add2ActionPerformed

    private void btn_connect3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_connect3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_connect3ActionPerformed

    private void btn_exit3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exit3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_exit3ActionPerformed

    private void btn_del3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_del3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_del3ActionPerformed

    private void btn_edit3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_edit3ActionPerformed

    private void btn_add3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_add3ActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Estructura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add1;
    private javax.swing.JButton btn_add2;
    private javax.swing.JButton btn_add3;
    private javax.swing.JButton btn_connect1;
    private javax.swing.JButton btn_connect2;
    private javax.swing.JButton btn_connect3;
    private javax.swing.JButton btn_del1;
    private javax.swing.JButton btn_del2;
    private javax.swing.JButton btn_del3;
    private javax.swing.JButton btn_edit1;
    private javax.swing.JButton btn_edit2;
    private javax.swing.JButton btn_edit3;
    private javax.swing.JButton btn_exit1;
    private javax.swing.JButton btn_exit2;
    private javax.swing.JButton btn_exit3;
    private javax.swing.JComboBox<String> cb_un1;
    private javax.swing.JComboBox<String> cb_un2;
    private javax.swing.JComboBox<String> cb_un3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JMenu jm_tablas;
    private javax.swing.JTree jtr_estructura;
    private javax.swing.JTree jtr_estructura1;
    private javax.swing.JPanel pn_cargos;
    private javax.swing.JPanel pn_contrato;
    private javax.swing.JPanel pn_division;
    private javax.swing.JPanel pn_empleados;
    private javax.swing.JPanel pn_estructura;
    private javax.swing.JPanel pn_estructura_institucional;
    private javax.swing.JPanel pn_nomina;
    private javax.swing.JPanel pn_obligaciones;
    private javax.swing.JPanel pn_opciones_division;
    private javax.swing.JPanel pn_sueldos;
    private javax.swing.JTabbedPane pn_tabs;
    private javax.swing.JPanel pn_tbl_cargos;
    private javax.swing.JSpinner sp_nivel1;
    private javax.swing.JSpinner sp_nivel2;
    private javax.swing.JSpinner sp_nivel3;
    private javax.swing.JTable tbl_cargos;
    private javax.swing.JTextField txt_id1;
    private javax.swing.JTextField txt_id2;
    private javax.swing.JTextField txt_id3;
    private javax.swing.JTextField txt_idp1;
    private javax.swing.JTextField txt_idp2;
    private javax.swing.JTextField txt_idp3;
    private javax.swing.JTextField txt_nombre1;
    private javax.swing.JTextField txt_nombre2;
    private javax.swing.JTextField txt_nombre3;
    // End of variables declaration//GEN-END:variables
}
