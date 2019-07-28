package orcl;

import BDD.Conexion;
import BDD.EST_INSTITUCIONAL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Gt37285
 */
public class conexion {
    
    private String username, password, port, host,ip;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
    Connection conn = null;
    boolean cont = false;

    public boolean isCont() {
        return cont;
    }

    public void setCont(boolean cont) {
        this.cont = cont;
    }
    
    public Connection getConn() {
        return conn;
    }
    static conexion instance = null;
    
    public conexion (String user,String pass, String port, String host, String ip){
        this.username = user;
        this.password = pass;
        this.port = port;
        this.host = host;
        this.ip = ip;
    }
    
    public void connection (){
         try {
            String driverName ="oracle.jdbc.driver.OracleDriver";
            Class.forName(driverName);
            String url = "", username = "", password="";
            url = "jdbc:oracle:thin:@"+this.ip+":"+this.port+":"+this.host;
            username = this.username;
            password = this.password;
            this.conn = DriverManager.getConnection(url,username,password);
            cont = true;
            
        }catch( SQLException e ){
//            JOptionPane.showMessageDialog(null, "Errorconexion: "+e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
            cont = false;
        }catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Errorconexion: "+e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
           cont = false;
        }
    }
    
    public void disconnect(){
        this.conn = null;
        cont = false;
    }
    
   
    
    
}
