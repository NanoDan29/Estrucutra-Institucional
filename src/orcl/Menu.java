package orcl;


import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author Gt37285
 */

public class Menu {
    
    private conexion conn;
    private boolean test = false;
    
    private String user, pass, port ,host, ip;
    
    public Menu(String user, String pass, String port, String host, String Ip){
        this.conn = new conexion(user,pass,port,host,Ip);
        this.user = user;
        this.pass = pass;
        this.port = port; 
        this.host = host;
        this.ip = Ip;
    }
    
    public ArrayList<String> getTablas() throws SQLException{
        
        conn.connection();
        Connection con = conn.getConn();
        ArrayList<String> lista = new ArrayList<String>();

        String sql = "select table_name from user_tables";

        Statement st = con.createStatement();
        ResultSet res = st.executeQuery(sql);
        
        while( res.next() ){
          lista.add(res.getString(1));
        }
        
        st.close();
        test = true;
        return lista;
    }
    
    public void menuAction(JMenu jm_tablas, String tabla){
        try {
            /* Se guarda en una lista la consulta de tablas disponibles */
            ArrayList<String> lista = getTablas();
            
            /*Las variables de conexion a la base de datos son de tipo final,
            no hay otra manera de pasarlas al evento de cada tabla*/
            
            final String user = this.user,
                  pass = this.pass,
                  port = this.port,
                  host = this.host,
                  ip = this.ip;
            
            /* El for recorre toda la lista e imprime el listado de tablas*/
            
            for (int i = 0; i < lista.size(); i++) {
               
                String listaItem = "";
                
                /*Se excluye de la lista la tabla actual*/
                
                if( !lista.get(i).trim().toLowerCase()
                        .equals(tabla) ){
                    listaItem = lista.get(i).trim().toLowerCase();
                }
                
                /*Se crea un componente item de menu y se le pasa el nombre de la tabla*/
                
                JMenuItem item = new JMenuItem(listaItem); 
                
                jm_tablas.add(item);    // el componente es agregado a la tabla
                
                
                /*Cada item de la tabla tendra un evento de ejecucion, 
                el mismo que abrira el formulario correspondiente a cada tabla*/
                
                item.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                        
                        String data = item.getText().trim();
                        
                        switch(data){
                            
//                            case "est_institucional":
//                                EST_INSTITUCIONAL en = new EST_INSTITUCIONAL(
//                                        user,pass,port,host,ip);
//                                en.setVisible(true);
//                            break;
//                            case "cat_divpolitica":
//                                DIVISION_POLITICA dp = new DIVISION_POLITICA(
//                                        user,pass,port,host, ip);
//                                dp.setVisible(true);
//                            break;
//                            case "cat_cargos":
//                                Cargos ca = new Cargos(user,pass,port,
//                                        host, ip);
//                                ca.setVisible(true);
//                            break;
//                            case "funciones":
//                                Funciones ob = new Funciones(user,pass,port,
//                                        host, ip);
//                                ob.setVisible(true);
//                            break;
//                            case "cat_sueldos":
//                                Sueldos su = new Sueldos(user,pass,port,
//                                        host, ip);
//                                su.setVisible(true);
//                            break;
//                            case "cat_contrato":
//                                Contrato co = new Contrato(user,pass,port,
//                                        host, ip);
//                                co.setVisible(true);
//                            break;
//                            case "cat_empleados":
//                                Empleados em = new Empleados(user,pass,port,
//                                        host, ip);
//                                em.setVisible(true);
//                            break;
//                            case "valores_contrato":
//                                Val_Contrato vc = new Val_Contrato(user,pass,port,
//                                        host, ip);
//                                vc.setVisible(true);
//                            break;
//
//                            default:
//                                JOptionPane.showMessageDialog(null, 
//                                "No existe un formulario para la tabla seleccionada",
//                                "Alerta!", JOptionPane.INFORMATION_MESSAGE);
                        }

                    }
                });
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void newUser(String username){
         JOptionPane.showMessageDialog(null, "Hasta pronto usuario: "+
                username+"\nCerrando conexion", "alerta!", JOptionPane.ERROR_MESSAGE);
        
        try {
            Thread.sleep(1000);
            
            JOptionPane.showMessageDialog(null, "conexion cerrada", "alerta!", JOptionPane.ERROR_MESSAGE);
           
            
        } catch (InterruptedException ex) {
//            Logger.getLogger(EST_INSTITUCIONAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
