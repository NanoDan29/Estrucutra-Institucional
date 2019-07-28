package orcl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Gt37285
 */
public class datosTabla {

    private conexion conn;

    public datosTabla(String user, String pass, String port, String host, String Ip) {
        this.conn = new conexion(user, pass, port, host, Ip);
    }

    public String[][] getData(String tabla, int col, String campo) throws SQLException {
        String sql = "select * from " + tabla + " order by " + campo + " asc";
        if (tabla.equals("cat_empleados")) {
            sql = "select * from " + tabla;
        }
        int fil = getFilas(tabla);
        conn.connection();

        Connection con = conn.getConn();

        String[][] m = new String[fil][col];

        Statement st = con.createStatement();
        ResultSet res = st.executeQuery(sql);

        int i = 0;

        while (res.next()) {
            for (int j = 0; j < m[0].length; j++) {
                m[i][j] = res.getString((j + 1));
            }
            i++;
        }

        return m;
    }

    public int getFilas(String tabla) throws SQLException {
        int res = 0;

        String filas = "select count(*) as \"filas\" from " + tabla + " ";

        conn.connection();
        Connection con = conn.getConn();

        Statement st = con.createStatement();
        ResultSet rsf = st.executeQuery(filas);

        rsf.next();
        int fil = rsf.getInt("filas");
        rsf.close();

        res = fil;

        return res;
    }

}
