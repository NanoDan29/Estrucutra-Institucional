package orcl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Gt37285
 */

public class datosArbol_est_inst {
    
    private conexion conn;
    
    
    public datosArbol_est_inst(String user, String pass, String port, String host, String Ip){
        this.conn = new conexion(user,pass,port,host,Ip);
    }

    
    public ArrayList<Estructura> getData(String id) throws SQLException{
        ArrayList<Estructura> lista = new ArrayList<>();
        
         try {
             
            conn.connection();
            Connection con = conn.getConn();
            
            Estructura  estructura = null;
        
            String sql = "select distinct IDINST,IDPINST,NOMFUNCION," +
                            "NIVEL,ULTIMONIVEL,CONNECT_BY_ISLEAF as hoja\n" +
                            "from EST_INSTITUCIONAL\n" +
                            "where IDPINST = '"+id+"'\n" +
                            "start with IDPINST is null\n" +
                            "connect by prior IDINST = IDPINST\n" +
                            "order by IDINST asc";
            
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);

             while (res.next()) {             
                 estructura = new Estructura(res.getString(1),
                                             res.getString(2),
                                             res.getString(3),
                                             res.getString(4),
                                             res.getString(5),
                                             res.getString(6));
                 lista.add(estructura);
             }
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(),
                     "Error!", JOptionPane.ERROR_MESSAGE);
         }
        
        return lista;
    }
     
     
     
    public ArrayList<String> getRaiz() throws SQLException{
     
            ArrayList <String> raiz = new ArrayList<>();
            conn.connection();
            Connection con = conn.getConn();
            
            Estructura  estructura = null;
        
            String sql = "select distinct *\n" +
                            "from EST_INSTITUCIONAL\n" +
                            "where IDPINST is null";
            
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            res.next();
            for (int i = 1; i < 6; i++) {
               raiz.add( res.getString(i) );
            }
           
            res.close();

         return raiz;
     }
     
     
    public ArrayList<Estructura> getDataCrud_divpolitica() throws SQLException{
        ArrayList<Estructura> lista = new ArrayList<>();
        
         try {
             
            conn.connection();
            Connection con = conn.getConn();
            
            Estructura  estructura = null;
        
            String sql = "select distinct IDINST,IDPINST,NOMFUNCION,NIVEL," +
                            "ULTIMONIVEL,CONNECT_BY_ISLEAF as hoja\n" +
                            "from EST_INSTITUCIONAL\n" +
                            "start with IDPINST is null\n" +
                            "connect by prior IDINST = IDPINST\n" +
                            "order by IDINST asc";
            
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);

             while (res.next()) {             
                 estructura = new Estructura(res.getString(1),
                                             res.getString(2),
                                             res.getString(3),
                                             res.getString(4),
                                             res.getString(5),
                                             res.getString(6));
                 lista.add(estructura);
             }
         } catch (Exception e) {
         }
        
        return lista;
    }
     
}
