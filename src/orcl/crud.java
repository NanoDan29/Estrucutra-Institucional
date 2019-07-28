package orcl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.scene.control.Spinner;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Gt37285
 */
public class crud {
    
    private conexion conn;
    private boolean test = false;
    datosArbol_est_inst da;
    datosArbol_div_politica dv;
    
    public crud(String user, String pass, String port, String host, String Ip){
        this.conn = new conexion(user,pass,port,host,Ip);
        this.da = new datosArbol_est_inst(user, pass, port, host, Ip);
        this.dv = new datosArbol_div_politica(user, pass, port, host, Ip);
    }

    public boolean isTest() {
        return test;
    }

    public void setTest(boolean test) {
        this.test = test;
    }
    
    
    public void Insert(String id,String id_p,String nombre, int nivel, String u_nivel,String tabla) {
        
        try{
            conn.connection();
            Connection con = conn.getConn();
        
            String sql = "insert into "+tabla+"\n" +
                            "values('"+id+"','"+id_p+"','"+nombre+"',"+nivel+",'"+u_nivel+"')";

            
            PreparedStatement st = con.prepareStatement(sql);
            st.execute();
           
            st.close();
            test = true;
            
        }catch(SQLException e){
            test = false;
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
       
    }
    
    public void Insert_Div(String id,String id_p,String nombre, int nivel, String u_nivel) {
        
        try{
            conn.connection();
            Connection con = conn.getConn();
        
            String sql = "insert into CAT_DIVPOLITICA values('"+id+"','"+id_p+"','"+nombre+"',"+nivel+",'"+u_nivel+"')";

            
            PreparedStatement st = con.prepareStatement(sql);
            st.execute();
           
            st.close();
            test = true;
            
            commit();
            
        }catch(SQLException e){
            test = false;
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
       
    }
    
    
    
    public void edit(String id,String id_p,String nombre, int nivel, String u_nivel,String tabla) {
        
        try{
            conn.connection();
            Connection con = conn.getConn();
        
             String sql = "update "+tabla+" \n" +
                        "set IDINST='"+id+"',IDPINST='"+id_p+"',NOMFUNCION='"+nombre+"',NIVEL="+nivel+",ULTIMONIVEL='"+u_nivel+"'\n" +
                        "where IDINST='"+id+"'";

            PreparedStatement st = con.prepareStatement(sql);
            st.execute();
            st.close();
            
            test = true;
            
        }catch(SQLException e){
            test = false;
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
       
    }
    
    
    public void Delete(String id,String tabla) {
        
        try{
            conn.connection();
            Connection con = conn.getConn();
        
             String sql = "delete "+tabla+" \n" +
                            "where IDINST='"+id+"'";

            
            PreparedStatement st = con.prepareStatement(sql);
            st.execute();
            st.close();
            
            test = true;
            
        }catch(SQLException e){
            test = false;
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
       
    }
    
       public void crudContratos( String IdContrato,String Id_inst,
                                String Id_sueldo, String IdFuncion, String IdCargo, String IdPersona,
                                String IdEmpleador, String NroContrato,String FechaInicio,
                                String FechaFin,String Estado,String horas, String instruccion) throws SQLException {
        try{
            
            String sql = "";

            if (instruccion.equals("insert")) {
                sql = "insert into cat_contrato\n"
                        + "values('" + IdContrato + "',"
                        + "'" + Id_inst + "',"
                        + "'" + Id_sueldo + "',"
                        + "'" + IdFuncion + "',"
                        + "'" + IdCargo + "',"
                        + "'" + IdPersona + "',"
                        + "'" + IdEmpleador + "',"
                        + "'" + NroContrato + "',"
                        + "'" + FechaInicio + "',"
                        + "'" + FechaFin + "',"
                        + "'" + Estado + "',"
                        + "'" + horas+"')";
                
                
            } else if (instruccion.equals("update")) {
                sql = "update cat_contrato \n"
                        + "set IDINST='" + Id_inst + "',"
                        + "IDSUELDO='" + Id_sueldo + "',"
                        + "IDFUNCION='" + IdFuncion + "',"
                        + "IDCARGO='" + IdCargo  + "',"
                        + "IDPERSONA='" + IdPersona + "',"
                        + "EMPLEADOR='" + IdEmpleador + "',"
                        + "NROCONTRATO='" + NroContrato + "',"
                        + "FECHAINICIO='" + FechaInicio + "',"
                        + "FECHAFIN='" + FechaFin + "',"
                        + "ESTADOCONTRATO='" + Estado + "'\n"
                        + "where IDCONTRATO='" + IdContrato + "'";

            } else if (instruccion.equals("delete")) {
                sql = "delete cat_contrato \n"
                        + "where IDCONTRATO='" + IdContrato + "'";
            }



            conn.connection();
            Connection con = conn.getConn();
            PreparedStatement st = con.prepareStatement(sql);
            st.execute();
            
            
            JOptionPane.showMessageDialog(null, "Operacion completada", 
                    "Alerta!", JOptionPane.INFORMATION_MESSAGE);
            test = true;
            st.close();
            
        }catch(SQLException e){
            test = false;
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
       
    public ArrayList<Estructura> selectEstructuraIns() throws SQLException {
        
        ArrayList<Estructura> listaTabla = new ArrayList();
        
        Estructura  estructura = null;

        conn.connection();
        Connection con = conn.getConn();

        String sql = "select * from est_institucional";

        Statement st = con.createStatement();
        ResultSet res = st.executeQuery(sql);

        while (res.next()) {
             estructura = new Estructura(res.getString(1),
                                             res.getString(2),
                                             res.getString(3),
                                             res.getString(4),
                                             "ignora esto",
                                             "ignora esto");
             
                 listaTabla.add(estructura);
        }
        return listaTabla;
    }

    public ArrayList<Division> selectDivPolitica() throws SQLException {
        ArrayList<Division> listaTabla = new ArrayList();
        Division d;

        conn.connection();
        Connection con = conn.getConn();

        String sql = "select * from CAT_DIVPOLITICA where ID_DIVISION_P is null";

        Statement st = con.createStatement();
        ResultSet res = st.executeQuery(sql);

        while (res.next()) {
            d = new Division(res.getString(1),
                            res.getString(2),
                            res.getString(3),
                            res.getString(4),
                            res.getString(5),
                            res.getString(6));

            listaTabla.add(d);

        }
        return listaTabla;
    }
    
    public void commit(){
         try{
            conn.connection();
            Connection con = conn.getConn();
        
            String sql = "commit";

            
            PreparedStatement st = con.prepareStatement(sql);
            st.execute();
            st.close();
            
            test = true;
            
        }catch(SQLException e){
            test = false;
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void rollback(){
         try{
            conn.connection();
            Connection con = conn.getConn();
        
             String sql = "rollback";
             
             

            
            PreparedStatement st = con.prepareStatement(sql);
            st.execute();
            st.close();
            
            test = true;
            
        }catch(SQLException e){
            test = false;
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public void inserccion(String nombre,String id,JComboBox cb_un,
            JTree jtr_estructura,DefaultTreeModel modeloArbol){
        try{
            
            DefaultMutableTreeNode node = ( DefaultMutableTreeNode ) jtr_estructura.getSelectionPath().getLastPathComponent();
            
            
            ArrayList<Estructura> lista = da.getData(id);
       
            String padre="",ID_INSERT,u_nivel="";
            int data_id = 0,idp = 0,nivel = 0,U_NIVEL_Data=0,aux = 0;

            int mayor = 0;
             
            padre = id;
            
            for (int i = 0; i < lista.size(); i++) {

                id = lista.get( i ).getId();
                nivel = Integer.parseInt( lista.get( i ).getNivel() );
                data_id = Integer.parseInt( id.substring( id.lastIndexOf(".")+1 ));
                u_nivel = lista.get(i).getUltimo_nivel();
                if( data_id > mayor ) mayor = data_id;
                
            }
           
                aux = nivel;

                ID_INSERT = padre+"."+(mayor+1);

                if( nivel == U_NIVEL_Data ) u_nivel = "N";

                Insert(ID_INSERT, padre, nombre, nivel, u_nivel,"EST_INSTITUCIONAL");


                if( isTest() ){
                    String departamento = ID_INSERT+".  "+nombre;
                    DefaultMutableTreeNode newnode = new DefaultMutableTreeNode(departamento);
                    node.add(newnode);
                    modeloArbol.reload();
                    jtr_estructura.setModel(modeloArbol);
                }
                
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), 
                    "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
  
    
    public void eliminar(JTree jtr_estructura,DefaultTreeModel modeloArbol){
        try{
             
            int val = JOptionPane.showConfirmDialog(null, "Deseas borrar el registro?",
                    "Alerta!", 0, JOptionPane.INFORMATION_MESSAGE);
            
            if(val == 0){
                DefaultMutableTreeNode node = ( DefaultMutableTreeNode ) jtr_estructura.getSelectionPath().getLastPathComponent();
            
                String data = node.getUserObject().toString();
                data = data.substring(0,data.lastIndexOf(".")).trim();
                Delete(data,"EST_INSTITUCIONAL");
                
                

                if( isTest() ){
                    if(node != jtr_estructura.getModel()){
                        modeloArbol.removeNodeFromParent(node);
                        modeloArbol.reload();
                        jtr_estructura.setModel(modeloArbol);
                    }
                }
            }
             
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public void actualizar(JTree jtr_estructura,DefaultTreeModel modeloArbol,
            String id_da,String nombre_da,String idp_da,JComboBox cb_un,JSpinner sp_nivel){
        try{
            DefaultMutableTreeNode node = ( DefaultMutableTreeNode ) jtr_estructura.getSelectionPath().getLastPathComponent();
            
            node.setUserObject(id_da+". "+nombre_da);
            modeloArbol.reload();
            jtr_estructura.setModel(modeloArbol);
            
            String data = node.getUserObject().toString();
            data = data.substring(0,data.lastIndexOf(".")).trim();
            
            String id,idp,nombre,u_nivel;
            int nivel = 0;
            
            id = data;
            idp = idp_da;
            nombre = nombre_da;
            u_nivel = cb_un.getSelectedItem().toString();
            nivel = (int) sp_nivel.getValue();
            
            edit(id, idp, nombre, nivel, u_nivel,"EST_INSTITUCIONAL");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    

}
