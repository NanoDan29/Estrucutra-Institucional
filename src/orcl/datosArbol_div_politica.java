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
public class datosArbol_div_politica {
    
    private conexion conn;
    
    
    public datosArbol_div_politica(String user, String pass, String port,
            String host, String Ip){
        
        this.conn = new conexion(user,pass,port,host,Ip);
    }
    
    
    public ArrayList<Division> getData(String id) {
        
        
        ArrayList<Division> lista = new ArrayList<>();
        
         try {
             
            conn.connection();
            Connection con = conn.getConn();
            
            Division  division = null;
        
            String sql = "select distinct ID_DIVISION,ID_DIVISION_P,NOM_DIVISION,\n" +
"                    NIVEL,ULTIMO_NIVEL,CONNECT_BY_ISLEAF as hoja\n" +
"                        from CAT_DIVPOLITICA\n" +
"                        where ID_DIVISION_P = '"+id+"'\n" +
"                        start with ID_DIVISION_P is null\n" +
"                        connect by prior ID_DIVISION = ID_DIVISION_P\n" +
"                        order by ID_DIVISION asc";
            
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);

             while (res.next()) {             
                 division = new Division(res.getString(1),
                                             res.getString(2),
                                             res.getString(3),
                                             res.getString(4),
                                             res.getString(5),
                                             res.getString(6));
                 lista.add(division);
             }
         } catch (Exception e) {
         }
        
        return lista;
    }
     

    
    public ArrayList<Division> getDataPadre(){
        ArrayList<Division> lista = new ArrayList<>();
        
         try {
             
            conn.connection();
            Connection con = conn.getConn();
            
            Division  division = null;
        
            String sql = "select distinct ID_DIVISION,ID_DIVISION_P,"+
                        "NOM_DIVISION,nivel,ultimo_nivel,CONNECT_BY_ISLEAF as hoja\n" +
                        "    from CAT_DIVPOLITICA\n" +
                        "    where ID_DIVISION_P is null\n" +
                        "    start with ID_DIVISION_P is null\n" +
                        "    connect by prior ID_DIVISION = ID_DIVISION_P\n" +
                        "    order by ID_DIVISION asc";
            
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);

             while (res.next()) {             
                 division = new Division(res.getString(1),
                                             res.getString(2),
                                             res.getString(3),
                                             res.getString(4),
                                             res.getString(5),
                                             res.getString(6));
                 lista.add(division);
             }
         } catch (Exception e) {
         }
        
        return lista;
    }
    
    
    
     public ArrayList<Division> getDataCrud_institucional() throws SQLException{
        
         
         ArrayList<Division> lista = new ArrayList<>();
        
         try {
             
            conn.connection();
            Connection con = conn.getConn();
            
            Division  division = null;
        
            String sql = "select distinct ID_DIVISION,ID_DIVISION_P,NOM_DIVISION,NIVEL," +
                            "ultimo_nivel,CONNECT_BY_ISLEAF as hoja\n" +
                            "from CAT_DIVPOLITICA\n" +
                            "start with ID_DIVISION_P is null\n" +
                            "connect by prior ID_DIVISION = ID_DIVISION_P\n" +
                            "order by ID_DIVISION asc";
            
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);

             while (res.next()) {             
                 division = new Division(res.getString(1),
                                             res.getString(2),
                                             res.getString(3),
                                             res.getString(4),
                                             res.getString(5),
                                             res.getString(6));
                 lista.add(division);
             }
         } catch (Exception e) {
         }
        
        return lista;
    }
    
}
