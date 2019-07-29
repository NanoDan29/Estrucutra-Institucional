/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BDD;

import cruds.Render;
import cruds.crudTablas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.util.Date;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import javax.swing.text.TableView;
import javax.swing.tree.DefaultTreeModel;
import orcl.Division;
import orcl.Menu;
import orcl.contrato;
import orcl.crud;
import orcl.datosArbol_est_inst;
import orcl.datosTabla;

/**
 *
 * @author Gt37285
 */
public class Proyecto extends javax.swing.JFrame {

    DefaultTableModel modeloDatos;
    DefaultTableModel modeloCargos;
    DefaultTableModel modeloCargos1;
    DefaultTableModel modeloSueldos;
    DefaultTableModel modeloContratos;
    DefaultTableModel modeloFunciones;

    private String username, password, port, host, ip;
    crud cn;
    Menu mn;
    datosTabla dt;
    private ArrayList<JMenuItem> itemTabla;
    int pestañas = 0;
    crudTablas cr;
    TableRowSorter trs;
    contrato c;
    private ArrayList<String> lisConsultas = new ArrayList<>();
    TableColumn tc;
    TableCellEditor tce;
    private int FilContrato;
    DefaultTableModel modeloNomina;
    int filas = 0;
    int id = 0;

    public Proyecto(String user, String pass, String port, String host, String ip) throws SQLException {
        initComponents();

        itemTabla = new ArrayList<JMenuItem>();

        this.setLocationRelativeTo(null);
        this.username = user;
        this.password = pass;
        this.port = port;
        this.host = host;
        this.ip = ip;

        dt = new datosTabla(username, password, port, host, ip);
        cn = new crud(username, password, port, host, ip);
        mn = new Menu(username, password, port, host, ip);
        cr = new crudTablas(user, pass, port, host, ip);

        btn_add.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_connect.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_del.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_edit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        filas = cr.getFilas("FUNCIONES") + 1;
        FilContrato = 0;

        getProvincias();
        contrato();
        empleados();
        cargos();
        funciones();
        sueldos();
        nominas();
        getProvincias();
        contrato();
        empleados();
        cargos();
        funciones();
        sueldos();
        nominas();
        getNSueldos();
        getPersonas();

    }

    private void estructura() {
        EST_INSTITUCIONAL es = new EST_INSTITUCIONAL(this.username,
                this.password, this.port, this.host, this.ip);
        es.setVisible(true);

//         System.out.println(this.username+this.password+this.port+ this.host+ this.ip);
    }

    private void combos_funciones() throws SQLException {

        /* Combo cargos */
        String datac[][] = dt.getData("cat_cargos", 2, "idcargo");
        JComboBox comboCargos = new JComboBox();

        for (int i = 0; i < datac.length; i++) {
            comboCargos.addItem(datac[i][0]);
        }

        tc = tbl_funciones.getColumnModel().getColumn(1);
        tce = new DefaultCellEditor(comboCargos);
        tc.setCellEditor(tce);
    }

    private void combos() throws SQLException {

        ArrayList<orcl.Estructura> lista = cn.selectEstructuraIns();

        /* Combo estructura institucional */
        JComboBox comboINST = new JComboBox();

        for (int i = 0; i < lista.size(); i++) {
            comboINST.addItem(lista.get(i).getId());
        }

        tc = tbl_contratos.getColumnModel().getColumn(1);
        tce = new DefaultCellEditor(comboINST);
        tc.setCellEditor(tce);

        /* Combo sueldos */
        JComboBox comboSueldo = new JComboBox();
        String data[][] = dt.getData("cat_sueldos", 3, "idsueldo");

        for (int i = 0; i < data.length; i++) {
            comboSueldo.addItem(data[i][0]);
        }

        tc = tbl_contratos.getColumnModel().getColumn(2);
        tce = new DefaultCellEditor(comboSueldo);
        tc.setCellEditor(tce);

        /* Combo funciones */
        String dataf[][] = dt.getData("funciones", 3, "idfuncion");
        JComboBox comboFuncion = new JComboBox();

        for (int i = 0; i < dataf.length; i++) {
            comboFuncion.addItem(dataf[i][0]);
        }

        tc = tbl_contratos.getColumnModel().getColumn(3);
        tce = new DefaultCellEditor(comboFuncion);
        tc.setCellEditor(tce);

        /* Combo cargos */
        String datac[][] = dt.getData("cat_cargos", 2, "idcargo");
        JComboBox comboCargos = new JComboBox();

        for (int i = 0; i < datac.length; i++) {
            comboCargos.addItem(datac[i][0]);
        }

        tc = tbl_contratos.getColumnModel().getColumn(4);
        tce = new DefaultCellEditor(comboCargos);
        tc.setCellEditor(tce);

        /* Combo persona */
        String datap[][] = dt.getData("cat_empleados", 14, "idpersona");
        JComboBox comboPersona = new JComboBox();

        for (int i = 0; i < datap.length; i++) {
            comboPersona.addItem(datap[i][0]);
        }

        tc = tbl_contratos.getColumnModel().getColumn(5);
        tce = new DefaultCellEditor(comboPersona);
        tc.setCellEditor(tce);

        tc = tbl_contratos.getColumnModel().getColumn(6);
        tce = new DefaultCellEditor(comboPersona);
        tc.setCellEditor(tce);

        /* Combo Estado */
        JComboBox comboestado = new JComboBox();

        comboestado.addItem("AC");
        comboestado.addItem("TE");

        tc = tbl_contratos.getColumnModel().getColumn(10);
        tce = new DefaultCellEditor(comboestado);
        tc.setCellEditor(tce);

    }

    public void getProvincias() {
        String matriz[] = cr.SelectProv();
        for (int i = 0; i < matriz.length; i++) {
            cbProvinciasDN.addItem(matriz[i]);
            cbProvinciasDR.addItem(matriz[i]);
        }
    }

    public void getNSueldos() {
        String matriz[] = cr.SelectNomin();
        for (int i = 0; i < matriz.length; i++) {
            cbn_IDS.addItem(matriz[i]);
            // cbn_IDS1.addItem(matriz[i]);
        }
    }

    public void getPersonas() {
        String matriz[] = cr.SelectNombres();
        for (int i = 0; i < matriz.length; i++) {
            cbn_IDP.addItem(matriz[i]);
            //
            // cbn_IDP1.addItem(matriz[i]);
        }
    }

    private void btn_add_emp() {
        try {
            String cedula = txt_cedula.getText();
            String nombre = txt_nombre.getText();
            String apellidoP = txt_apellidoP.getText();
            String apellidoM = txt_apellidoM.getText();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaA = calendarios.getDate();
            String fechaNac = formato.format(fechaA);
            String Telefono = txt_telefono.getText();
            String Email = txt_email.getText();
            String Genero = ch_genero.getSelectedItem().toString();
            String EC = ch_estadoCivil.getSelectedItem().toString();
            String residencia = txt_Residencia.getText();
            String direccion = txt_direccion.getText();
            String lugarN = txt_lugarNacimiento.getText();
            String tipoSangre = txt_tipoSangre.getText();
            int id = cr.getFilas("CAT_EMPLEADOS") + 1;
            System.out.println(id);
            cr.InsertEmpleados(id, cedula, nombre, apellidoP, apellidoM, fechaNac, residencia, direccion, Telefono, Email, Genero, lugarN, EC, tipoSangre);
            JOptionPane.showMessageDialog(null, "Guardado");
            empleados();
        } catch (SQLException ex) {
            Logger.getLogger(Proyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void vaciar_camposEmpleado() {
        try {
            txt_cedula.setText("");
            txt_nombre.setText("");
            txt_apellidoP.setText("");
            txt_apellidoM.setText("");
            txt_telefono.setText("");
            txt_email.setText("");
//        String Genero = ch_genero.getSelectedItem().toString();
//        String EC = ch_estadoCivil.getSelectedItem().toString();
            txt_Residencia.setText("");
            txt_direccion.setText("");
            txt_lugarNacimiento.setText("");
            txt_tipoSangre.setText("");
            int id = cr.getFilas("CAT_EMPLEADOS") + 1;
            txt_id2.setText(String.valueOf(id));
        } catch (SQLException ex) {
            Logger.getLogger(Proyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cargos_add() {
        try {

            String vector[] = new String[2];
            for (int i = 0; i < tbl_cargos1.getColumnCount(); i++) {
                vector[i] = tbl_cargos1.getValueAt(tbl_cargos1.getRowCount() - 1, i).toString();
            }
            System.out.println(vector[0] + vector[1]);
            cr.InsertCargos(vector[0], vector[1]);
            cargos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error!\t" + e.getMessage(),
                    "Error!", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")

    private Proyecto() {
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        btn_add = new javax.swing.JButton();
        btn_del = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_connect = new javax.swing.JButton();
        btn_exit = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        btn_division = new javax.swing.JButton();
        btn_exit2 = new javax.swing.JButton();
        btn_nuevo = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        panelPestañas = new javax.swing.JTabbedPane();
        Scroll_empleados = new javax.swing.JScrollPane();
        empleados = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        tbl_empleados = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_id2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_cedula = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_apellidoP = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_apellidoM = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_telefono = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        ch_genero = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        ch_estadoCivil = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        txt_tipoSangre = new javax.swing.JTextField();
        jSeparator14 = new javax.swing.JSeparator();
        calendarios = new com.toedter.calendar.JDateChooser();
        jPanel10 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        txt_lugarNacimiento = new javax.swing.JTextField();
        cbProvinciasDN = new javax.swing.JComboBox<>();
        cbnCiudadDN = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        cbnCantonDN = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JSeparator();
        jPanel13 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        txt_Residencia = new javax.swing.JTextField();
        cbProvinciasDR = new javax.swing.JComboBox<>();
        cbnCiudadDR = new javax.swing.JComboBox<>();
        cbnCantonDR = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txt_direccion = new javax.swing.JTextField();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbl_cargos = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_funciones = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbl_cargos1 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_contratos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_nominas = new javax.swing.JTable();
        jPanel18 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        cbn_IDS = new javax.swing.JComboBox<>();
        jSeparator15 = new javax.swing.JSeparator();
        jLabel29 = new javax.swing.JLabel();
        cbn_IDP = new javax.swing.JComboBox<>();
        jSeparator17 = new javax.swing.JSeparator();
        jLabel31 = new javax.swing.JLabel();
        txt_filtro_nomina = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        tbl_sueldos = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        txt_id_sueldos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_descripcion_sueldos = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        sp_salario_sueldos = new javax.swing.JSpinner();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        txt_filtro_sueldo = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jMenuBar1 = new javax.swing.JMenuBar();
        jm_tablas = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Proyecto Base de Datos III");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        btn_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/iconos/guardar.png"))); // NOI18N
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_del.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/iconos/boton-x.png"))); // NOI18N
        btn_del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delActionPerformed(evt);
            }
        });

        btn_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/iconos/editar.png"))); // NOI18N
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

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

        btn_division.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/iconos/ecuador-32.png"))); // NOI18N
        btn_division.setText("Division Politica");
        btn_division.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_division.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exit1ActionPerformed(evt);
            }
        });

        btn_exit2.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        btn_exit2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/iconos/rompecabezas-32.png"))); // NOI18N
        btn_exit2.setText("Estructura Institucional");
        btn_exit2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_exit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exit2ActionPerformed(evt);
            }
        });

        btn_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/iconos/mas.png"))); // NOI18N
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_del, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_connect, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_exit2)
                .addGap(18, 18, 18)
                .addComponent(btn_division, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(196, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_connect, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_del, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btn_exit2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_division, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
        );

        panelPestañas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panelPestañas.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                panelPestañasStateChanged(evt);
            }
        });

        tbl_empleados.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        tbl_empleados.setForeground(new java.awt.Color(102, 102, 102));
        tbl_empleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbl_empleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_empleadosMouseClicked(evt);
            }
        });
        jScrollPane14.setViewportView(tbl_empleados);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane14)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel1.setText("ID Persona");
        jLabel1.setEnabled(false);

        txt_id2.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        txt_id2.setForeground(new java.awt.Color(102, 102, 102));
        txt_id2.setEnabled(false);
        txt_id2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id2ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel5.setText("Cedula");

        txt_cedula.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        txt_cedula.setForeground(new java.awt.Color(102, 102, 102));

        jLabel10.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel10.setText("Nombre");

        txt_nombre.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        txt_nombre.setForeground(new java.awt.Color(102, 102, 102));

        jLabel11.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel11.setText("Apellido P");

        txt_apellidoP.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        txt_apellidoP.setForeground(new java.awt.Color(102, 102, 102));

        jLabel12.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel12.setText("Apellido M");

        txt_apellidoM.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        txt_apellidoM.setForeground(new java.awt.Color(102, 102, 102));

        jLabel13.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel13.setText("Fecha de Nacimiento");

        jLabel14.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel14.setText("Telefono");

        txt_telefono.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        txt_telefono.setForeground(new java.awt.Color(102, 102, 102));

        jLabel15.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel15.setText("Email");

        txt_email.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        txt_email.setForeground(new java.awt.Color(102, 102, 102));

        jLabel16.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel16.setText("Genero");

        ch_genero.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        ch_genero.setForeground(new java.awt.Color(102, 102, 102));
        ch_genero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "F", "M" }));

        jLabel17.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel17.setText("Estado Civil");

        ch_estadoCivil.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        ch_estadoCivil.setForeground(new java.awt.Color(102, 102, 102));
        ch_estadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Soltero/a", "Casado/a", "Divorciado/a" }));

        jLabel18.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel18.setText("Tipo Sangre");

        txt_tipoSangre.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        txt_tipoSangre.setForeground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator14))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_cedula)
                            .addComponent(txt_nombre)
                            .addComponent(txt_apellidoP)
                            .addComponent(txt_apellidoM)
                            .addComponent(txt_telefono)
                            .addComponent(txt_email)
                            .addComponent(ch_genero, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ch_estadoCivil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_tipoSangre)
                            .addComponent(calendarios, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                            .addComponent(txt_id2))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_id2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txt_apellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txt_apellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(calendarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(ch_genero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(ch_estadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txt_tipoSangre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel19.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel19.setText("Lugar Naciemeinto");

        txt_lugarNacimiento.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        txt_lugarNacimiento.setForeground(new java.awt.Color(102, 102, 102));

        cbProvinciasDN.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        cbProvinciasDN.setForeground(new java.awt.Color(102, 102, 102));
        cbProvinciasDN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbProvinciasDNMouseClicked(evt);
            }
        });

        cbnCiudadDN.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        cbnCiudadDN.setForeground(new java.awt.Color(102, 102, 102));
        cbnCiudadDN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbnCiudadDNMouseClicked(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel20.setText("Provincia");

        jLabel21.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel21.setText("Ciudad");

        cbnCantonDN.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        cbnCantonDN.setForeground(new java.awt.Color(102, 102, 102));
        cbnCantonDN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbnCantonDNMouseClicked(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel22.setText("Canton");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_lugarNacimiento)
                    .addComponent(cbnCantonDN, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbProvinciasDN, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbnCiudadDN, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbProvinciasDN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(4, 4, 4)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbnCiudadDN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbnCantonDN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txt_lugarNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jLabel23.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel23.setText("Lugar Residencia");

        txt_Residencia.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        txt_Residencia.setForeground(new java.awt.Color(102, 102, 102));

        cbProvinciasDR.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        cbProvinciasDR.setForeground(new java.awt.Color(102, 102, 102));
        cbProvinciasDR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbProvinciasDRMouseClicked(evt);
            }
        });

        cbnCiudadDR.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        cbnCiudadDR.setForeground(new java.awt.Color(102, 102, 102));
        cbnCiudadDR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbnCiudadDRMouseClicked(evt);
            }
        });

        cbnCantonDR.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        cbnCantonDR.setForeground(new java.awt.Color(102, 102, 102));
        cbnCantonDR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbnCantonDRMouseClicked(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel25.setText("Canton");

        jLabel24.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel24.setText("Provincia");

        jLabel26.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel26.setText("Ciudad");

        jLabel27.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel27.setText("Direccion");

        txt_direccion.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        txt_direccion.setForeground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator13)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_direccion)
                            .addComponent(cbnCantonDR, javax.swing.GroupLayout.Alignment.TRAILING, 0, 311, Short.MAX_VALUE)
                            .addComponent(cbnCiudadDR, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbProvinciasDR, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_Residencia))))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbProvinciasDR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(cbnCiudadDR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbnCantonDR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txt_Residencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout empleadosLayout = new javax.swing.GroupLayout(empleados);
        empleados.setLayout(empleadosLayout);
        empleadosLayout.setHorizontalGroup(
            empleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(empleadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(empleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator4))
                .addContainerGap())
        );
        empleadosLayout.setVerticalGroup(
            empleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(empleadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Scroll_empleados.setViewportView(empleados);

        panelPestañas.addTab("Empleados", Scroll_empleados);

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jScrollPane6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane6MouseClicked(evt);
            }
        });
        jScrollPane6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jScrollPane6KeyReleased(evt);
            }
        });

        tbl_cargos.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        tbl_cargos.setForeground(new java.awt.Color(102, 102, 102));
        tbl_cargos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbl_cargos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_cargosMouseClicked(evt);
            }
        });
        tbl_cargos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbl_cargosKeyReleased(evt);
            }
        });
        jScrollPane6.setViewportView(tbl_cargos);

        jScrollPane4.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jScrollPane4ComponentHidden(evt);
            }
        });

        tbl_funciones.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        tbl_funciones.setForeground(new java.awt.Color(102, 102, 102));
        tbl_funciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tbl_funciones);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 409, Short.MAX_VALUE))
        );

        panelPestañas.addTab("Cargos/Funciones", jPanel9);

        jScrollPane7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane7MouseClicked(evt);
            }
        });
        jScrollPane7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jScrollPane7KeyReleased(evt);
            }
        });

        tbl_cargos1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        tbl_cargos1.setForeground(new java.awt.Color(102, 102, 102));
        tbl_cargos1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbl_cargos1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_cargos1MouseClicked(evt);
            }
        });
        tbl_cargos1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbl_cargos1KeyReleased(evt);
            }
        });
        jScrollPane7.setViewportView(tbl_cargos1);

        panelPestañas.addTab("Cargos", jScrollPane7);

        jPanel6.setMaximumSize(new java.awt.Dimension(900, 32767));

        tbl_contratos.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        tbl_contratos.setForeground(new java.awt.Color(102, 102, 102));
        tbl_contratos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbl_contratos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_contratosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_contratos);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 906, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(499, Short.MAX_VALUE))
        );

        jScrollPane5.setViewportView(jPanel6);

        panelPestañas.addTab("Contratos", jScrollPane5);

        tbl_nominas.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        tbl_nominas.setForeground(new java.awt.Color(102, 102, 102));
        tbl_nominas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbl_nominas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_nominasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_nominas);

        jLabel28.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/iconos/etiqueta.png"))); // NOI18N
        jLabel28.setText("IDS");

        cbn_IDS.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        cbn_IDS.setForeground(new java.awt.Color(102, 102, 102));
        cbn_IDS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbn_IDSMouseClicked(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/iconos/usuario1.png"))); // NOI18N
        jLabel29.setText("IDPERSONA");

        cbn_IDP.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        cbn_IDP.setForeground(new java.awt.Color(102, 102, 102));

        jLabel31.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/iconos/lupa.png"))); // NOI18N
        jLabel31.setText("Busqueda");

        txt_filtro_nomina.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        txt_filtro_nomina.setForeground(new java.awt.Color(102, 102, 102));
        txt_filtro_nomina.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_filtro_nominaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_filtro_nominaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator15)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addGap(18, 18, Short.MAX_VALUE))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(34, 34, 34))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_filtro_nomina)
                            .addComponent(cbn_IDP, 0, 265, Short.MAX_VALUE)
                            .addComponent(cbn_IDS, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jSeparator17))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(cbn_IDS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbn_IDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addGap(29, 29, 29)
                .addComponent(jSeparator17, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txt_filtro_nomina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 99, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(77, 77, 77))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelPestañas.addTab("Nominas", jPanel2);

        tbl_sueldos.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        tbl_sueldos.setForeground(new java.awt.Color(102, 102, 102));
        tbl_sueldos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbl_sueldos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_sueldosMouseClicked(evt);
            }
        });
        tbl_sueldos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbl_sueldosKeyReleased(evt);
            }
        });
        jScrollPane16.setViewportView(tbl_sueldos);

        jPanel12.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        txt_id_sueldos.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        txt_id_sueldos.setForeground(new java.awt.Color(102, 102, 102));

        jLabel4.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/iconos/etiqueta.png"))); // NOI18N
        jLabel4.setText("ID");

        jLabel8.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/iconos/nota.png"))); // NOI18N
        jLabel8.setText("Descripcion");

        txt_descripcion_sueldos.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        txt_descripcion_sueldos.setForeground(new java.awt.Color(102, 102, 102));

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/iconos/dinero.png"))); // NOI18N
        jLabel2.setText("Salario");

        sp_salario_sueldos.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        sp_salario_sueldos.setModel(new javax.swing.SpinnerNumberModel(1.0d, 1.0d, null, 0.1d));

        jLabel6.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/iconos/lupa.png"))); // NOI18N
        jLabel6.setText("Busqueda");

        txt_filtro_sueldo.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        txt_filtro_sueldo.setForeground(new java.awt.Color(102, 102, 102));
        txt_filtro_sueldo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_filtro_sueldoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_filtro_sueldoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator10)
                    .addComponent(jSeparator9)
                    .addComponent(jSeparator5)
                    .addComponent(jSeparator6)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, Short.MAX_VALUE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(19, 19, 19)))
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_filtro_sueldo)
                            .addComponent(sp_salario_sueldos)
                            .addComponent(txt_descripcion_sueldos)
                            .addComponent(txt_id_sueldos))))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_id_sueldos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_descripcion_sueldos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(sp_salario_sueldos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_filtro_sueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane16)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelPestañas.addTab("Sueldos", jPanel5);

        jMenuBar1.setBackground(new java.awt.Color(204, 204, 204));
        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuBar1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N

        jm_tablas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/iconos/rompecabezas.png"))); // NOI18N
        jm_tablas.setText("Estructura Institucional");
        jm_tablas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jm_tablas.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jMenuBar1.add(jm_tablas);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/iconos/ecuador.png"))); // NOI18N
        jMenu4.setText("Division Politica");
        jMenu4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu4.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jMenuBar1.add(jMenu4);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/iconos/ajustes.png"))); // NOI18N
        jMenu1.setText("Opciones");
        jMenu1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/iconos/flecha-hacia-arriba.png"))); // NOI18N
        jMenuItem2.setText("Commit");
        jMenuItem2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        jMenuItem3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/iconos/usuario1.png"))); // NOI18N
        jMenu2.setText("Acerca de:");
        jMenu2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jSeparator2)))
                .addGap(13, 13, 13))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPestañas, javax.swing.GroupLayout.DEFAULT_SIZE, 923, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelPestañas, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        try {
            Thread.sleep(1500);

            cn.commit();

            if (cn.isTest()) {
                JOptionPane.showMessageDialog(null, "Commit completado!", "Alerta!",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(EST_INSTITUCIONAL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed

        try {
            Thread.sleep(1500);

            cn.rollback();

            if (cn.isTest()) {
                JOptionPane.showMessageDialog(null, "Rollback completado!", "Alerta!",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(EST_INSTITUCIONAL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked

        AcercaDe n = new AcercaDe();
        n.setVisible(true);

    }//GEN-LAST:event_jMenu2MouseClicked

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed

        try {

            pestañas = panelPestañas.getSelectedIndex();
            switch (pestañas) {
                case 0:
                    //  JOptionPane.showMessageDialog(null, pestañas);
                    btn_add_emp();
                    break;
                case 1:

                    funciones_add();
                    break;
                case 2:
                    cargos_add();
                    break;
                case 3:
                    contratos_add();
                    break;
                case 5:
                    String id_s = txt_id_sueldos.getText().trim();
                    String descripcion_s = txt_descripcion_sueldos.getText().trim();
                    Double sueldo = (Double) sp_salario_sueldos.getValue();
                    btn_add("cat_sueldos", 3, "idsueldo", "IDS_", id_s, descripcion_s, sueldo);
                    break;
            }
        } catch (Exception ex) {

        }

    }//GEN-LAST:event_btn_addActionPerformed

    private void funciones_add() {
        try {

            String vector[] = new String[3];
            for (int i = 0; i < tbl_funciones.getColumnCount(); i++) {
                vector[i] = tbl_funciones.getValueAt(tbl_funciones.getRowCount() - 1, i).toString();
            }

            cr.InsertFuciones(vector[0], vector[1], vector[2]);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error!\t" + e.getMessage(),
                    "Error!", JOptionPane.INFORMATION_MESSAGE);
        }

    }
    private void btn_delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delActionPerformed

        try {

            pestañas = panelPestañas.getSelectedIndex();

            switch (pestañas) {
                case 0:
                    String id2 = txt_id2.getText();
                    cr.DeleteEmpleados(id2);
                    empleados();
                    break;
                case 1:
                    funciones_delete();
                    break;
                case 2:
                    int fila = tbl_cargos1.getSelectedRow();
                    String id = tbl_cargos1.getValueAt(fila, 0).toString();

                    btn_delete("cat_cargos", id, "idcargo");
                    break;
                case 3:
                    int op = JOptionPane.showConfirmDialog(null, "estas seguro de eliminar el item?",
                            "Eliminar", JOptionPane.ERROR_MESSAGE);
                    if (op == 0) {
                        contratos_edit_delete("delete");
                        contrato();
                    }
                    break;
                case 5:
                    String id_s = txt_id_sueldos.getText().trim();
                    btn_delete("cat_sueldos", id_s, "idsueldo");
                    break;
            }
        } catch (SQLException ex) {

        }

    }//GEN-LAST:event_btn_delActionPerformed

    private void funciones_delete() {

        try {

            int confirm = JOptionPane.showConfirmDialog(null, "estas seguro de borrar el item?", "alerta", JOptionPane.INFORMATION_MESSAGE);

            if (confirm == 0) {
                int fila = tbl_funciones.getSelectedRow();
                String Id_funcion = String.valueOf(tbl_funciones.getValueAt(fila, 0));

                cr.DeleteFunciones(Id_funcion);
                funciones();
            }

        } catch (Exception e) {

        }
    }
    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed

        try {

            pestañas = panelPestañas.getSelectedIndex();

            switch (pestañas) {
                case 0:
                    btn_add_emp();
                    break;
                case 1:
                    funciones_edit();
                    break;
                case 2:
                    int fila = tbl_cargos1.getSelectedRow();
                    String id = tbl_cargos1.getValueAt(fila, 0).toString();
                    String nombre = tbl_cargos1.getValueAt(fila, 1).toString();
                    btn_edit("cat_cargos", id, nombre, "idcargo", 1.0);
                    break;

                case 3:
                    contratos_edit_delete("update");
                    break;

                case 5:
                    String id_s = txt_id_sueldos.getText().trim();
                    String descripcion_s = txt_descripcion_sueldos.getText().trim();
                    Double sueldo = (Double) sp_salario_sueldos.getValue();
                    btn_edit("cat_sueldos", id_s, descripcion_s, "idsueldo", sueldo);
                    break;
            }
        } catch (SQLException ex) {

        }

    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_connectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_connectActionPerformed

        mn.newUser(this.username);

        this.setVisible(false);
        Conexion c = new Conexion();
        c.setVisible(true);

    }//GEN-LAST:event_btn_connectActionPerformed

    /*Metodos carga de datos*/
    private void contrato() {
        try {

            modeloContratos = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int fila, int columna) {
                    if (columna == 0) {
                        return false;
                    } else {
                        return true;
                    }

                }
            };
            String data[][] = dt.getData("cat_contrato", 12, "idcontrato");

            ArrayList<String> lista = new ArrayList<String>();
            lista.add("CONTRATO");
            lista.add("INSTITUCION");
            lista.add("SUELDO");
            lista.add("FUNCION");
            lista.add("CARGO");
            lista.add("PERSONA");
            lista.add("EMPLEADOR");
            lista.add("NUMERO");
            lista.add("FECHA_INIC");
            lista.add("FECHA_FIN");
            lista.add("ESTADO");
            lista.add("NUM_HORAS");

            for (int i = 0; i < lista.size(); i++) {
                modeloContratos.addColumn(lista.get(i));
            }

            Object[] test = new Object[1];
            test[0] = null;
            int fila = dt.getFilas("cat_contrato");

            for (int i = 0; i < fila; i++) {
                modeloContratos.addRow(test);
            }

            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[i].length; j++) {
                    modeloContratos.setValueAt(data[i][j], i, j);
                }
            }

            tbl_contratos.setModel(modeloContratos);
            combos();

        } catch (SQLException ex) {

        }
    }

    private void empleados() {
        try {

            modeloDatos = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int fila, int columna) {
                    if (columna == 0) {
                        return false;
                    } else {
                        return true;
                    }

                }
            };
            String data[][] = dt.getData("cat_empleados", 14, "idpersona");

            ArrayList<String> lista = new ArrayList<String>();
            lista.add("PERSONA");
            lista.add("CEDULA");
            lista.add("NOMBRE");
            lista.add("APELL_PAT");
            lista.add("APELL_MAT");
            lista.add("FECHA_NAC");
            lista.add("RESIDENCIA");
            lista.add("DIRECCION");
            lista.add("TELEFONO");
            lista.add("E-MAIL");
            lista.add("GENERO");
            lista.add("LUGAR_NAC");
            lista.add("ESTADO_CIVIL");
            lista.add("TIPO_SANGRE");

            for (int i = 0; i < lista.size(); i++) {
                modeloDatos.addColumn(lista.get(i));
            }

            Object[] test = new Object[1];
            test[0] = null;
            int fila = dt.getFilas("cat_empleados");

            for (int i = 0; i < fila; i++) {
                modeloDatos.addRow(test);
            }

            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[i].length; j++) {
                    modeloDatos.setValueAt(data[i][j], i, j);
                }
            }

            tbl_empleados.setModel(modeloDatos);

        } catch (SQLException ex) {

        }
    }

    private void cargos() {
        try {
            modeloCargos1 = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int fila, int columna) {
                    if (columna == 0) {
                        return false;
                    } else {
                        return true;
                    }

                }
            };
            modeloCargos = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int fila, int columna) {
                    if (columna == 0) {
                        return false;
                    } else {
                        return true;
                    }

                }
            };
            String data[][] = dt.getData("cat_cargos", 2, "idcargo");

            ArrayList<String> lista = new ArrayList<String>();
            lista.add("ID");
            lista.add("NOMBRE");

            for (int i = 0; i < lista.size(); i++) {
                modeloCargos.addColumn(lista.get(i));
                modeloCargos1.addColumn(lista.get(i));
            }
//
            Object[] test = new Object[1];
            test[0] = null;
            int fila = dt.getFilas("cat_cargos");

            for (int i = 0; i < fila; i++) {
                modeloCargos.addRow(test);
                modeloCargos1.addRow(test);
            }

            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[i].length; j++) {
                    modeloCargos.setValueAt(data[i][j], i, j);
                    modeloCargos1.setValueAt(data[i][j], i, j);
                }
            }

            tbl_cargos.setModel(modeloCargos);
            tbl_cargos1.setModel(modeloCargos1);

        } catch (SQLException ex) {

        }
    }

    private void funciones() {
        try {

            modeloFunciones = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int fila, int columna) {
                    if (columna == 0) {
                        return false;
                    } else {
                        return true;
                    }

                }
            };;
            String data[][] = dt.getData("funciones", 3, "idfuncion");

            ArrayList<String> lista = new ArrayList<String>();
            lista.add("ID_FUNCION");
            lista.add("ID_CARGO");
            lista.add("NOMBRE");

            for (int i = 0; i < lista.size(); i++) {
                modeloFunciones.addColumn(lista.get(i));
            }

            Object[] test = new Object[1];
            test[0] = null;
            int fila = dt.getFilas("funciones");

            for (int i = 0; i < fila; i++) {
                modeloFunciones.addRow(test);
            }

            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[i].length; j++) {
                    modeloFunciones.setValueAt(data[i][j], i, j);
                }
            }

            tbl_funciones.setModel(modeloFunciones);
            combos_funciones();

        } catch (SQLException ex) {

        }
    }

    private void sueldos() {
        try {

            modeloSueldos = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int fila, int columna) {
                    if (columna == 0) {
                        return false;
                    } else {
                        return true;
                    }

                }
            };
            String data[][] = dt.getData("cat_sueldos", 3, "idsueldo");

            ArrayList<String> lista = new ArrayList<String>();
            lista.add("ID_SUELDO");
            lista.add("DESCRIPCION");
            lista.add("SALARIO");

            for (int i = 0; i < lista.size(); i++) {
                modeloSueldos.addColumn(lista.get(i));
            }

            Object[] test = new Object[1];
            test[0] = null;
            int fila = dt.getFilas("cat_sueldos");

            for (int i = 0; i < fila; i++) {
                modeloSueldos.addRow(test);
            }

            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[i].length; j++) {
                    modeloSueldos.setValueAt(data[i][j], i, j);
                }
            }

            tbl_sueldos.setModel(modeloSueldos);

        } catch (SQLException ex) {

        }
    }

    private void contratos_add() {

        try {
            Object[] test = new Object[1];
            test[0] = null;

            modeloContratos.addRow(test);
            tbl_contratos.setModel(modeloContratos);
//            
            String id = (String) tbl_contratos.getValueAt(tbl_contratos.getRowCount() - 2, 0);
            String Idrecort = id.substring(id.indexOf("_") + 1);
            int idInsert = Integer.parseInt(Idrecort) + 1;
            DecimalFormat format = new DecimalFormat("000");
            String idI = "ID_" + format.format(idInsert);
            tbl_contratos.setValueAt(idI, tbl_contratos.getRowCount() - 1, 0);
            tbl_contratos.setValueAt(idInsert, tbl_contratos.getRowCount() - 1, 7);
            tbl_contratos.setValueAt("AC", tbl_contratos.getRowCount() - 1, 10);

            /*informacion defecto persona*/
            String datap[][] = dt.getData("cat_empleados", 14, "idpersona");
            tbl_contratos.setValueAt(datap[0][0], tbl_contratos.getRowCount() - 1, 5);

            /*informacion defecto empleador*/
            tbl_contratos.setValueAt(datap[0][0], tbl_contratos.getRowCount() - 1, 6);

            /*informacion defecto institucion*/
            ArrayList<orcl.Estructura> lista = cn.selectEstructuraIns();
            tbl_contratos.setValueAt(lista.get(0).getId(), tbl_contratos.getRowCount() - 1, 1);

            /*informacion defecto sueldo*/
            String data[][] = dt.getData("cat_sueldos", 3, "idsueldo");
            tbl_contratos.setValueAt(data[0][0], tbl_contratos.getRowCount() - 1, 2);

            /* informacion defecto funciones */
            String dataf[][] = dt.getData("funciones", 3, "idfuncion");
            tbl_contratos.setValueAt(dataf[0][0], tbl_contratos.getRowCount() - 1, 3);

            /* informacion defecto cargos */
            String datac[][] = dt.getData("cat_cargos", 2, "idcargo");
            tbl_contratos.setValueAt(datac[0][0], tbl_contratos.getRowCount() - 1, 4);

            /* informacion defecto fecha*/
            java.util.Date utilDate = new java.util.Date(); //fecha actual
            long lnMilisegundos = utilDate.getTime();
            java.sql.Date sqlDate = new java.sql.Date(lnMilisegundos);

            tbl_contratos.setValueAt(sqlDate, tbl_contratos.getRowCount() - 1, 8);
            tbl_contratos.setValueAt(sqlDate, tbl_contratos.getRowCount() - 1, 9);

            /* informacion defecto numHoras*/
            tbl_contratos.setValueAt("200", tbl_contratos.getRowCount() - 1, 11);

            /*carga de la informacion en la base de datos*/
            JOptionPane.showMessageDialog(null, "Se ha cargado un nuevo contrato"
                    + " con informacion por defecto,\nPor favor editalas",
                    "Alert!", JOptionPane.INFORMATION_MESSAGE);

            cn.crudContratos(String.valueOf(idI), lista.get(0).getId(),
                    data[0][0], dataf[0][0], datac[0][0], datap[0][0],
                    datap[0][0], String.valueOf(idInsert), sqlDate.toString(),
                    sqlDate.toString(), "AC", "200", "insert");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error!\t" + e.getMessage(),
                    "Error!", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void contratos_edit_delete(String opcion) throws SQLException {

        int fila = tbl_contratos.getSelectedRow();

        String IdContrato = String.valueOf(tbl_contratos.getValueAt(fila, 0));

        String Id_inst = (String) tbl_contratos.getValueAt(fila, 1);

        String Id_sueldo = (String) tbl_contratos.getValueAt(fila, 2);

        String IdFuncion = (String) tbl_contratos.getValueAt(fila, 3);
        String IdCargo = (String) tbl_contratos.getValueAt(fila, 4);

        String IdPersona = (String) tbl_contratos.getValueAt(fila, 5);

        String IdEmpleador = (String) tbl_contratos.getValueAt(fila, 6);

        String NroContrato = String.valueOf(tbl_contratos.getValueAt(fila, 7));

        String FechaInicio = String.valueOf(tbl_contratos.getValueAt(fila, 8));
        String FechaFin = String.valueOf(tbl_contratos.getValueAt(fila, 9));

        String Estado = (String) tbl_contratos.getValueAt(fila, 10);
        String horas = (String) tbl_contratos.getValueAt(fila, 11);

        cn.crudContratos(IdContrato, Id_inst,
                Id_sueldo, IdFuncion, IdCargo, IdPersona,
                IdEmpleador, NroContrato, FechaInicio,
                FechaFin, Estado, horas, opcion);

    }

    private void funciones_edit() {

        String vector[] = new String[3];
        for (int i = 0; i < tbl_funciones.getColumnCount(); i++) {
            vector[i] = tbl_funciones.getValueAt(tbl_funciones.getRowCount() - 1, i).toString();
        }

        cr.editFunciones(vector[0], vector[1], vector[2]);

    }
//    

    private void nominas() {
        try {

            modeloDatos = new DefaultTableModel();
            String data[][] = dt.getData("valores_contrato", 3, "idsueldo");

            ArrayList<String> lista = new ArrayList<String>();
            lista.add("ID_SUELDO");
            lista.add("ID_PERSONA");
            lista.add("VALOR");

            for (int i = 0; i < lista.size(); i++) {
                modeloDatos.addColumn(lista.get(i));
            }

            Object[] test = new Object[1];
            test[0] = null;
            int fila = dt.getFilas("valores_contrato");

            for (int i = 0; i < fila; i++) {
                modeloDatos.addRow(test);
            }

            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[i].length; j++) {
                    modeloDatos.setValueAt(data[i][j], i, j);
                }
            }

            tbl_nominas.setModel(modeloDatos);

        } catch (SQLException ex) {

        }
    }

    private void division() {
        DIVISION_POLITICA dp = new DIVISION_POLITICA(this.username,
                this.password, this.port, this.host, this.ip);
        dp.setVisible(true);
    }


    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        int val = JOptionPane.showConfirmDialog(null, "Estas Seguro de querer salir?",
                "Confirmacion", 0, JOptionPane.QUESTION_MESSAGE);
        if (val == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_btn_exitActionPerformed

    private void btn_exit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exit1ActionPerformed
        division();
    }//GEN-LAST:event_btn_exit1ActionPerformed

    private void btn_exit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exit2ActionPerformed
        estructura();
    }//GEN-LAST:event_btn_exit2ActionPerformed

    private void panelPestañasStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_panelPestañasStateChanged

    }//GEN-LAST:event_panelPestañasStateChanged

    private void txt_filtro_sueldoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_filtro_sueldoKeyTyped

    }//GEN-LAST:event_txt_filtro_sueldoKeyTyped

    private void txt_filtro_sueldoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_filtro_sueldoKeyReleased

        txt_filtro_sueldo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {

                trs.setRowFilter(RowFilter.regexFilter("(?i)" + txt_filtro_sueldo.getText(), 0, 1, 2));
            }
        });

        trs = new TableRowSorter(modeloSueldos);
        tbl_sueldos.setRowSorter(trs);
    }//GEN-LAST:event_txt_filtro_sueldoKeyReleased

    private void tbl_sueldosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_sueldosKeyReleased
        int filas = tbl_sueldos.getRowCount();
        int columnas = tbl_sueldos.getColumnCount();
        getDataTabla(5, filas, columnas, tbl_sueldos, txt_id_sueldos, txt_descripcion_sueldos, sp_salario_sueldos);
    }//GEN-LAST:event_tbl_sueldosKeyReleased

    private void tbl_sueldosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_sueldosMouseClicked
        int filas = tbl_sueldos.getRowCount();
        int columnas = tbl_sueldos.getColumnCount();

        getDataTabla(5, filas, columnas, tbl_sueldos, txt_id_sueldos, txt_descripcion_sueldos, sp_salario_sueldos);
    }//GEN-LAST:event_tbl_sueldosMouseClicked

    private void txt_filtro_nominaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_filtro_nominaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_filtro_nominaKeyTyped

    private void txt_filtro_nominaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_filtro_nominaKeyReleased
        txt_filtro_nomina.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {

                trs.setRowFilter(RowFilter.regexFilter("(?i)" + txt_filtro_nomina.getText(), 0, 1, 2));
            }
        });

        trs = new TableRowSorter(modeloNomina);
        tbl_nominas.setRowSorter(trs);
    }//GEN-LAST:event_txt_filtro_nominaKeyReleased

    private void cbn_IDSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbn_IDSMouseClicked

    }//GEN-LAST:event_cbn_IDSMouseClicked

    private void tbl_nominasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_nominasMouseClicked
        int filas = tbl_nominas.getRowCount();
        int columnas = tbl_nominas.getColumnCount();

        String vector[] = new String[columnas];
        int pos = tbl_nominas.getSelectedRow();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (i == pos) {
                    vector[j] = tbl_nominas.getValueAt(i, j).toString();
                }
            }
        }

        cbn_IDS.setSelectedItem(vector[0]);
        cbn_IDP.setSelectedItem(vector[1]);

    }//GEN-LAST:event_tbl_nominasMouseClicked

    private void tbl_contratosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_contratosMouseClicked

    }//GEN-LAST:event_tbl_contratosMouseClicked

    private void jScrollPane4ComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jScrollPane4ComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane4ComponentHidden

    private void jScrollPane6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jScrollPane6KeyReleased

    }//GEN-LAST:event_jScrollPane6KeyReleased

    private void jScrollPane6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane6MouseClicked

    }//GEN-LAST:event_jScrollPane6MouseClicked

    private void tbl_cargosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_cargosKeyReleased
        try {
            int fila = tbl_cargos.getSelectedRow();
//            int columnas = tbl_cargos.getSelectedColumn();
            String campo = tbl_cargos.getValueAt(fila, 0).toString();

            String matriz[][] = cr.getData("FUNCIONES", 3, campo);
            int fil = cr.getFilasCondicion("FUNCIONES", campo);
            String nombre[] = new String[3];
            nombre[0] = "IDFUNCION";
            nombre[1] = "IDCARGO";
            nombre[2] = "NOMBRE";

            modeloFunciones = new DefaultTableModel(nombre, fil) {
                @Override
                public boolean isCellEditable(int fila, int columna) {
                    if (columna == 0 || columna == 1) {
                        return false;
                    } else {
                        return true;
                    }

                }
            };
            for (int i = 0; i < fil; i++) {
                for (int j = 0; j < 3; j++) {
                    modeloFunciones.setValueAt(matriz[i][j], i, j);
                }
            }
            tbl_funciones.setModel(modeloFunciones);

        } catch (SQLException ex) {
            Logger.getLogger(Proyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tbl_cargosKeyReleased

    private void tbl_cargosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_cargosMouseClicked
        try {
            int fila = tbl_cargos.getSelectedRow();
//            int columnas = tbl_cargos.getSelectedColumn();
            String campo = tbl_cargos.getValueAt(fila, 0).toString();

            String matriz[][] = cr.getData("FUNCIONES", 3, campo);
            int fil = cr.getFilasCondicion("FUNCIONES", campo);
            String nombre[] = new String[3];
            nombre[0] = "IDFUNCION";
            nombre[1] = "IDCARGO";
            nombre[2] = "NOMBRE";

            modeloFunciones = new DefaultTableModel(nombre, fil) {
                @Override
                public boolean isCellEditable(int fila, int columna) {
                    if (columna == 0 || columna == 1) {
                        return false;
                    } else {
                        return true;
                    }

                }
            };
            for (int i = 0; i < fil; i++) {
                for (int j = 0; j < 3; j++) {
                    modeloFunciones.setValueAt(matriz[i][j], i, j);
                }
            }
            tbl_funciones.setModel(modeloFunciones);

        } catch (SQLException ex) {
            Logger.getLogger(Proyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tbl_cargosMouseClicked

    private void cbnCantonDRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbnCantonDRMouseClicked
        String nombre = cbnCantonDR.getSelectedItem().toString();
        String id = cr.SelectIDNombreCanton(nombre);
        txt_Residencia.setText(id);        // TODO add your handling code here:
    }//GEN-LAST:event_cbnCantonDRMouseClicked

    private void cbnCiudadDRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbnCiudadDRMouseClicked

        cbnCantonDR.removeAllItems();
        String ciudad = cbnCiudadDR.getSelectedItem().toString();
        String ciudadR = cr.SelectIDNombreCiudad(ciudad);
        String cantonesR[] = cr.SelectCantonR(ciudadR);
        for (int i = 0; i < cantonesR.length; i++) {
            cbnCantonDR.addItem(cantonesR[i]);
        }
    }//GEN-LAST:event_cbnCiudadDRMouseClicked

    private void cbProvinciasDRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbProvinciasDRMouseClicked
        cbnCiudadDR.removeAllItems();

        int a = cbProvinciasDR.getSelectedIndex() + 1;
        String b = "";
        if (a < 10) {
            b = "0" + a;
        } else {
            b = a + "";
        }
        System.out.println(b);
        String ciudadesR[] = cr.SelectCiudadR(b);
        for (int i = 0; i < ciudadesR.length; i++) {
            cbnCiudadDR.addItem(ciudadesR[i]);
        }
    }//GEN-LAST:event_cbProvinciasDRMouseClicked

    private void cbnCantonDNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbnCantonDNMouseClicked
        String nombre = cbnCantonDN.getSelectedItem().toString();
        String id = cr.SelectIDNombreCanton(nombre);
        txt_lugarNacimiento.setText(id);
    }//GEN-LAST:event_cbnCantonDNMouseClicked

    private void cbnCiudadDNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbnCiudadDNMouseClicked
        cbnCantonDN.removeAllItems();
        String ciudad = cbnCiudadDN.getSelectedItem().toString();
        System.out.println(ciudad);
        String ciudadN = cr.SelectIDNombreCiudad(ciudad);
        System.out.println(ciudadN);
        String cantonesN[] = cr.SelectCantonR(ciudadN);
        for (int i = 0; i < cantonesN.length; i++) {
            cbnCantonDN.addItem(cantonesN[i]);
        }
    }//GEN-LAST:event_cbnCiudadDNMouseClicked

    private void cbProvinciasDNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbProvinciasDNMouseClicked
        cbnCiudadDN.removeAllItems();
        int a = cbProvinciasDN.getSelectedIndex() + 1;
        String b = "";
        if (a < 10) {
            b = "0" + a;
        } else if (a >= 10) {

            b = a + "";
        }
        System.out.println(b);
        String ciudadesN[] = cr.SelectCiudadN(b);
        for (int i = 0; i < ciudadesN.length; i++) {
            cbnCiudadDN.addItem(ciudadesN[i]);
        }
    }//GEN-LAST:event_cbProvinciasDNMouseClicked

    private void tbl_empleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_empleadosMouseClicked
        int filas = tbl_empleados.getRowCount();
        int columnas = tbl_empleados.getColumnCount();

        String vector[] = new String[columnas];
        int pos = tbl_empleados.getSelectedRow();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (i == pos) {
                    vector[j] = tbl_empleados.getValueAt(i, j).toString();
                }
            }
        }

        txt_id2.setText(vector[0]);
        txt_cedula.setText(vector[1]);
        txt_nombre.setText(vector[2]);
        txt_apellidoP.setText(vector[3]);
        txt_apellidoM.setText(vector[4]);
        String fecha = vector[5];

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate;
        try {
            fechaDate = formato.parse(fecha);
            calendarios.setDate(fechaDate);
        } catch (ParseException ex) {
            //            Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
        }

        txt_Residencia.setText(vector[6]);
        txt_direccion.setText(vector[7]);
        txt_telefono.setText(vector[8]);
        txt_email.setText(vector[9]);

        if (vector[10].equals("F")) {
            ch_genero.setSelectedIndex(0);
        } else if (vector[10].equals("M")) {
            ch_genero.setSelectedIndex(1);
        }
        txt_lugarNacimiento.setText(vector[11]);
        System.out.println(vector[12]);
        if (vector[12].equals("Soltero/a")) {

            ch_estadoCivil.setSelectedIndex(0);

        } else if (vector[12].equals("Casado/a")) {
            ch_estadoCivil.setSelectedIndex(1);

        } else {
            ch_estadoCivil.setSelectedItem(2);

        }

        txt_tipoSangre.setText(vector[13]);

        cbnCiudadDN.removeAllItems();
        cbnCiudadDR.removeAllItems();
        cbnCantonDN.removeAllItems();
        cbnCantonDR.removeAllItems();

        String provN = txt_lugarNacimiento.getText().substring(0, 2);

        System.out.println(provN);
        String ciudadN = txt_lugarNacimiento.getText().substring(0, 4);
        String cantonN = txt_lugarNacimiento.getText().substring(0, 6);

        //        JOptionPane.showMessageDialog(null, provN);
        cbProvinciasDN.setSelectedIndex(Integer.parseInt(provN) - 1);
        String ciudadesN[] = cr.SelectCiudadN(provN);
        for (int i = 0; i < ciudadesN.length; i++) {
            cbnCiudadDN.addItem(ciudadesN[i]);
        }
        String ciudadNU = cr.SelectCiudadNU(ciudadN);
        cbnCiudadDN.setSelectedItem(ciudadNU);
        String cantonesN[] = cr.SelectCantonN(ciudadN);
        for (int i = 0; i < cantonesN.length; i++) {
            cbnCantonDN.addItem(cantonesN[i]);
        }
        String cantonNU = cr.SelectCantonNU(ciudadN);
        cbnCantonDN.setSelectedItem(cantonNU);

        String provR = txt_Residencia.getText().substring(0, 2);
        String ciudadR = txt_Residencia.getText().substring(0, 4);
        String cantonR = txt_Residencia.getText().substring(0, 6);

        cbProvinciasDR.setSelectedIndex(Integer.parseInt(provR) - 1);

        String ciudadesR[] = cr.SelectCiudadR(provR);
        for (int i = 0; i < ciudadesR.length; i++) {
            cbnCiudadDR.addItem(ciudadesR[i]);
        }
        String ciudadRU = cr.SelectCiudadRU(ciudadR);
        cbnCiudadDR.setSelectedItem(ciudadRU);

        String cantonesR[] = cr.SelectCantonR(ciudadR);
        for (int i = 0; i < cantonesR.length; i++) {
            cbnCantonDR.addItem(cantonesR[i]);
        }
        String cantonRU = cr.SelectCantonRU(cantonR);
        cbnCantonDR.setSelectedItem(cantonRU);
    }//GEN-LAST:event_tbl_empleadosMouseClicked

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed

        try {

            pestañas = panelPestañas.getSelectedIndex();
            switch (pestañas) {
                case 0:
                    vaciar_camposEmpleado();
                    break;
                case 1:

                    int fila = tbl_cargos.getSelectedRow();
                    String campo = tbl_cargos.getValueAt(fila, 0).toString();
                    if (filas < 10) {
                        modeloFunciones.addRow(new Object[]{"IDF_00" + (filas), campo, ""});
                    } else {
                        modeloFunciones.addRow(new Object[]{"IDF_0" + (filas), campo, ""});
                    }

                    tbl_funciones.setModel(modeloFunciones);

                    Render miRender = new Render();
                    miRender.setPosFilpibot(tbl_funciones.getRowCount() - 1);
                    tbl_funciones.setDefaultRenderer(Object.class, miRender);
                    filas++;
                    break;

                case 2:
                    id = cr.getFilas("CAT_CARGOS") + 2;

                    if (id < 10) {
                        modeloCargos1.addRow(new Object[]{"IDC_00" + id});
                    } else {
                        modeloCargos1.addRow(new Object[]{"IDC_0" + id});
                    }
                    tbl_cargos1.setModel(modeloCargos1);
                    Render miRender1 = new Render();
                    miRender1.setPosFilpibot(tbl_cargos1.getRowCount() - 1);
                    tbl_cargos1.setDefaultRenderer(Object.class, miRender1);

                    break;

                case 4:
                    int id1 = cr.getFilas("VALORES_CONTRATO") + 1;
                    System.out.println(id1);
                    if (id1 < 10) {
                        modeloNomina.addRow(new Object[]{"IDS_00" + id1});
                    } else {
                        modeloNomina.addRow(new Object[]{"IDC_0" + id1});
                    }
                    tbl_nominas.setModel(modeloNomina);
                    Render miRender2 = new Render();
                    miRender2.setPosFilpibot(tbl_nominas.getRowCount() - 1);
                    tbl_nominas.setDefaultRenderer(Object.class, miRender2);
                    break;

            }
        } catch (Exception ex) {

        }


    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void tbl_cargos1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_cargos1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_cargos1MouseClicked

    private void tbl_cargos1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_cargos1KeyReleased

    }//GEN-LAST:event_tbl_cargos1KeyReleased

    private void jScrollPane7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane7MouseClicked

    private void jScrollPane7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jScrollPane7KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane7KeyReleased

    private void txt_id2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id2ActionPerformed

    /*get Data para txt*/
    private void getDataTabla(int tabla, int filas, int columnas, JTable tbl,
            JTextField txt_x, JTextField txt_y, JSpinner sp_z) {

        String vector[] = new String[columnas];
        int pos = tbl.getSelectedRow();

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (i == pos) {
                    vector[j] = tbl.getValueAt(i, j).toString();
                }
            }
        }

        txt_x.setText(vector[0]);
        txt_y.setText(vector[1]);

        if (tabla == 5) {
            sp_z.setValue(Double.parseDouble(vector[2]));
        }

    }

    /*botones de crud*/
    private void btn_add(String tabla, int col, String campo, String prefijo, String id, String nombre, Double sueldo) {
        try {

            String data[][] = dt.getData(tabla, col, campo);

            if (nombre.length() == 0) {
                nombre = "SIN REGISTRO";
            }

            String Idrecort = data[data.length - 1][0].substring(data[data.length - 1][0].indexOf("_") + 1);

            int idInsert = Integer.parseInt(Idrecort) + 1;

            DecimalFormat format = new DecimalFormat("000");

            String idI = prefijo + format.format(idInsert);

            cr.Insert(tabla, idI, nombre, sueldo);

            switch (tabla) {
                case "cat_cargos":
                    cargos();
                    break;
                case "cat_sueldos":
                    sueldos();
                    break;
            }

        } catch (SQLException ex) {

        }
    }

    private void btn_edit(String tabla, String id, String nombre, String campo_id, Double sueldo) {

        DecimalFormat format = new DecimalFormat("#######.##");

        Double valor = Double.parseDouble(format.format((sueldo)).replace(",", "."));

        cr.Edit(tabla, id, nombre, campo_id, valor);

        modeloDatos = new DefaultTableModel();
        switch (tabla) {
            case "cat_cargos":
                cargos();
                break;
            case "cat_sueldos":
                sueldos();
                break;
        }
    }

    private void btn_delete(String tabla, String id, String campo_id) {

        int confirm = JOptionPane.showConfirmDialog(null, "Seguro deseas eliminar el item?",
                "Alerta", JOptionPane.YES_NO_OPTION);

        if (confirm == 0) {
            cr.Delete(tabla, id, campo_id);
            modeloDatos = new DefaultTableModel();
            switch (tabla) {
                case "cat_cargos":
                    cargos();
                    break;
                case "cat_sueldos":
                    sueldos();
                    break;
            }
        }

    }

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
            java.util.logging.Logger.getLogger(Proyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Proyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Proyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Proyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Proyecto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane Scroll_empleados;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_connect;
    private javax.swing.JButton btn_del;
    private javax.swing.JButton btn_division;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_exit2;
    private javax.swing.JButton btn_nuevo;
    private com.toedter.calendar.JDateChooser calendarios;
    private javax.swing.JComboBox<String> cbProvinciasDN;
    private javax.swing.JComboBox<String> cbProvinciasDR;
    private javax.swing.JComboBox<String> cbnCantonDN;
    private javax.swing.JComboBox<String> cbnCantonDR;
    private javax.swing.JComboBox<String> cbnCiudadDN;
    private javax.swing.JComboBox<String> cbnCiudadDR;
    private javax.swing.JComboBox<String> cbn_IDP;
    private javax.swing.JComboBox<String> cbn_IDS;
    private javax.swing.JComboBox<String> ch_estadoCivil;
    private javax.swing.JComboBox<String> ch_genero;
    private javax.swing.JPanel empleados;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JMenu jm_tablas;
    private javax.swing.JTabbedPane panelPestañas;
    private javax.swing.JSpinner sp_salario_sueldos;
    private javax.swing.JTable tbl_cargos;
    private javax.swing.JTable tbl_cargos1;
    private javax.swing.JTable tbl_contratos;
    private javax.swing.JTable tbl_empleados;
    private javax.swing.JTable tbl_funciones;
    private javax.swing.JTable tbl_nominas;
    private javax.swing.JTable tbl_sueldos;
    private javax.swing.JTextField txt_Residencia;
    private javax.swing.JTextField txt_apellidoM;
    private javax.swing.JTextField txt_apellidoP;
    private javax.swing.JTextField txt_cedula;
    private javax.swing.JTextField txt_descripcion_sueldos;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_filtro_nomina;
    private javax.swing.JTextField txt_filtro_sueldo;
    private javax.swing.JTextField txt_id2;
    private javax.swing.JTextField txt_id_sueldos;
    private javax.swing.JTextField txt_lugarNacimiento;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_telefono;
    private javax.swing.JTextField txt_tipoSangre;
    // End of variables declaration//GEN-END:variables
}
