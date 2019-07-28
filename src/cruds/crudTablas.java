/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruds;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import orcl.conexion;

/**
 *
 * @author Jhoel Malte
 */
public class crudTablas {

    private conexion conn;
    private boolean test = false;

    public crudTablas(String user, String pass, String port, String host, String Ip) {
        this.conn = new conexion(user, pass, port, host, Ip);

    }

    public boolean isTest() {
        return test;
    }

    public void setTest(boolean test) {
        this.test = test;
    }

    /* CRUD CARGOS */
    public void Insert(String tabla, String id, String nombre, Double sueldo) {

        try {
            conn.connection();
            Connection con = conn.getConn();

            String sql = "";

            switch (tabla) {

                case "cat_cargos":
                    sql = "insert into " + tabla + "\n"
                            + "values('" + id + "','" + nombre + "')";
                    break;

                case "cat_sueldos":

                    sql = "insert into " + tabla + "\n"
                            + "values('" + id + "','" + nombre + "','" + sueldo + "')";
                    break;
            }

            PreparedStatement st = con.prepareStatement(sql);
            st.execute();

            JOptionPane.showMessageDialog(null, "Item agregado Correctamente",
                    "Alerta!", JOptionPane.INFORMATION_MESSAGE);

            st.close();
            test = true;
        } catch (Exception e) {
            test = false;
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void Edit(String tabla, String id, String nombre, String campo_id, Double sueldo) {

        try {
            conn.connection();
            Connection con = conn.getConn();

            String sql = "";

            switch (tabla) {
                case "cat_cargos":
                    sql = "update " + tabla + " \n"
                            + "set " + campo_id + "='" + id + "',nombre='" + nombre + "'\n"
                            + "where " + campo_id + "='" + id + "'";
                    break;
                case "cat_sueldos":
                    sql = "update " + tabla + " \n"
                            + "set " + campo_id + "='" + id + "',descripcion='" + nombre + "',valor='" + sueldo + "'\n"
                            + "where " + campo_id + "='" + id + "'";
                    break;
            }

            PreparedStatement st = con.prepareStatement(sql);
            st.execute();
            st.close();

            JOptionPane.showMessageDialog(null, "Item Editado", "Alerta!",
                    JOptionPane.INFORMATION_MESSAGE);

            test = true;

        } catch (SQLException e) {
            test = false;
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void Delete(String tabla, String id, String campo_id) {

        try {
            conn.connection();
            Connection con = conn.getConn();

            String sql = "delete " + tabla + " \n"
                    + "where " + campo_id + "='" + id + "'";

            PreparedStatement st = con.prepareStatement(sql);
            st.execute();
            st.close();

            JOptionPane.showMessageDialog(null, "Item Eliminado", "Alerta!",
                    JOptionPane.ERROR_MESSAGE);

            test = true;

        } catch (SQLException e) {
            test = false;
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * sueldos*
     */
    public void InsertSueldos(String id, String descripcion, int valor) {

        try {
            conn.connection();
            Connection con = conn.getConn();

            //System.out.println(id + descripcion);
            String sql = "insert into CAT_SUELDOS values('" + id + "','" + descripcion + "'," + valor + ")";

            PreparedStatement st = con.prepareStatement(sql);
            st.execute();

            st.close();
            test = true;
        } catch (Exception e) {
            test = false;
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void editSueldos(String id, String descripcion, int Valor) {

        try {
            conn.connection();
            Connection con = conn.getConn();

            String sql = "update CAT_SUELDOS \n"
                    + "set idsueldo='" + id + "',descripcion='" + descripcion + "',valor=" + Valor + "\n"
                    + "where idsueldo='" + id + "'";

            PreparedStatement st = con.prepareStatement(sql);
            st.execute();
            st.close();

            test = true;

        } catch (SQLException e) {
            test = false;
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void DeleteSueldos(String id) {

        try {
            conn.connection();
            Connection con = conn.getConn();

            String sql = "delete CAT_SUELDOS \n"
                    + "where idsueldo='" + id + "'";

            PreparedStatement st = con.prepareStatement(sql);
            st.execute();
            st.close();

            test = true;

        } catch (SQLException e) {
            test = false;
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }

    }

    public String[] SelectProv() {
        String matrizProv[] = new String[24];
        try {

            conn.connection();
            Connection con = conn.getConn();

            String sql = "select NOM_DIVISION\n"
                    + "from cat_divpolitica\n"
                    + "where id_division_p is null\n"
                    + "start with id_division_p is null\n"
                    + "connect by  prior id_division=id_division_p";

            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);

            int i = 0;
            int c = 1;

            while (res.next()) {
                for (int j = 0; j < c; j++) {
                    matrizProv[i] = res.getString(j + 1);

                }
                i++;
            }

            test = true;

        } catch (SQLException e) {
            test = false;
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
        return matrizProv;
    }

    /* Empleados */
    public String[] SelectCiudadN(String id) {
        String[] matrizCiudad = null;
        try {

            conn.connection();
            Connection con = conn.getConn();

            String sql = "select NOM_DIVISION\n"
                    + "from cat_divpolitica\n"
                    + "where id_division_p='" + id + "'";

            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);

            int i = 0;
            int c = 1;

            while (res.next()) {
                for (int j = 0; j < c; j++) {

                }
                i++;
            }

            st = con.createStatement();
            res = st.executeQuery(sql);

            matrizCiudad = new String[i];

            i = 0;
            c = 1;
            while (res.next()) {
                for (int j = 0; j < c; j++) {
                    matrizCiudad[i] = res.getString(j + 1);
                }
                i++;

            }
            test = true;
            return matrizCiudad;
        } catch (SQLException e) {
            test = false;
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
            return matrizCiudad;
        }

    }

    public String[] SelectCantonN(String id) {
        String[] matrizCiudad = null;
        try {

            conn.connection();
            Connection con = conn.getConn();

            String sql = "select NOM_DIVISION\n"
                    + "from cat_divpolitica\n"
                    + "where id_division_p='" + id + "'";

            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);

            int i = 0;
            int c = 1;

            while (res.next()) {
                for (int j = 0; j < c; j++) {

                }
                i++;
            }

            st = con.createStatement();
            res = st.executeQuery(sql);
            System.out.println(i++);
            matrizCiudad = new String[i - 1];

            i = 0;
            c = 1;
            while (res.next()) {
                for (int j = 0; j < c; j++) {
                    matrizCiudad[i] = res.getString(j + 1);

                }
                i++;

            }
            test = true;
            return matrizCiudad;
        } catch (SQLException e) {
            test = false;
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
            return matrizCiudad;
        }

    }

    public String SelectCiudadNU(String id) {
        String nombre = null;
        try {

            conn.connection();
            Connection con = conn.getConn();

            String sql = "select NOM_DIVISION from CAT_DIVPOLITICA where id_division='" + id + "'";
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                nombre = res.getString(1);
            }
            test = true;

        } catch (SQLException e) {
            test = false;
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
        return nombre;
    }

    public String SelectCantonNU(String id) {
        String nombre = null;
        try {

            conn.connection();
            Connection con = conn.getConn();

            String sql = "select NOM_DIVISION from CAT_DIVPOLITICA where id_division='" + id + "'";
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                nombre = res.getString(1);
            }
            test = true;

        } catch (SQLException e) {
            test = false;
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
        return nombre;
    }

    public String[] SelectCiudadR(String id) {
        String[] matrizCiudad = null;
        try {

            conn.connection();
            Connection con = conn.getConn();

            String sql = "select NOM_DIVISION\n"
                    + "from cat_divpolitica\n"
                    + "where id_division_p='" + id + "'";

            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);

            int i = 0;
            int c = 1;

            while (res.next()) {
                for (int j = 0; j < c; j++) {

                }
                i++;
            }

            st = con.createStatement();
            res = st.executeQuery(sql);
            System.out.println(i++);
            matrizCiudad = new String[i - 1];

            i = 0;
            c = 1;
            while (res.next()) {
                for (int j = 0; j < c; j++) {
                    matrizCiudad[i] = res.getString(j + 1);
                }
                i++;

            }
            test = true;
            return matrizCiudad;
        } catch (SQLException e) {
            test = false;
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
            return matrizCiudad;
        }

    }

    public String[] SelectCantonR(String id) {
        String[] matrizCiudad = null;
        try {

            conn.connection();
            Connection con = conn.getConn();

            String sql = "select NOM_DIVISION\n"
                    + "from cat_divpolitica\n"
                    + "where id_division_p='" + id + "'";

            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);

            int i = 0;
            int c = 1;

            while (res.next()) {
                for (int j = 0; j < c; j++) {

                }
                i++;
            }

            st = con.createStatement();
            res = st.executeQuery(sql);
            System.out.println(i++);
            matrizCiudad = new String[i - 1];

            i = 0;
            c = 1;
            while (res.next()) {
                for (int j = 0; j < c; j++) {
                    matrizCiudad[i] = res.getString(j + 1);
                }
                i++;

            }
            test = true;
            return matrizCiudad;
        } catch (SQLException e) {
            test = false;
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
            return matrizCiudad;
        }

    }

    public String SelectCiudadRU(String id) {
        String nombre = null;
        try {

            conn.connection();
            Connection con = conn.getConn();

            String sql = "select NOM_DIVISION from CAT_DIVPOLITICA where id_division='" + id + "'";
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                nombre = res.getString(1);
            }
            test = true;

        } catch (SQLException e) {
            test = false;
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
        return nombre;
    }

    public String SelectCantonRU(String id) {
        String nombre = null;
        try {

            conn.connection();
            Connection con = conn.getConn();

            String sql = "select NOM_DIVISION from CAT_DIVPOLITICA where id_division='" + id + "'";
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                nombre = res.getString(1);
            }
            test = true;

        } catch (SQLException e) {
            test = false;
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
        return nombre;
    }

    public String SelectIDNombreCanton(String nombre) {
        String id = null;
        try {

            conn.connection();
            Connection con = conn.getConn();

            String sql = "select ID_DIVISION from CAT_DIVPOLITICA where NOM_DIVISION='" + nombre + "'";
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {

                id = res.getString(1);
                System.out.println(id);
            }
            test = true;

        } catch (SQLException e) {
            test = false;
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
        return id;
    }

    public String SelectID_P_NombreCiudad(String nombre) {
        String id = null;
        try {

            conn.connection();
            Connection con = conn.getConn();

            String sql = "select ID_DIVISION_P from CAT_DIVPOLITICA where NOM_DIVISION='" + nombre + "'";
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {

                id = res.getString(1);
                System.out.println(id);
            }
            test = true;

        } catch (SQLException e) {
            test = false;
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
        return id;
    }

    public String SelectIDNombreCiudad(String nombre) {
        String id = null;
        try {

            conn.connection();
            Connection con = conn.getConn();

            String sql = "select ID_DIVISION from CAT_DIVPOLITICA where NOM_DIVISION='" + nombre + "'";
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                id = res.getString(1);
            }

            if (id.length() == 6) {
                id = id.substring(0, 4);
            }

            test = true;

        } catch (SQLException e) {
            test = false;
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
        return id;
    }


    /*CRUD EMPLEADOS */
    public void InsertEmpleados(
            String cedula, String nombre, String apellidoP,
            String apellidoM, String fechaNac, String lugarR,
            String Direccion, String telefono, String email,
            String genero, String lugarN, String EC, String tipoSangre) {

        try {
            conn.connection();
            Connection con = conn.getConn();

            //System.out.println(id + descripcion);
            String sql = "insert into CAT_EMPLEADOS\n"
                    + "values(abc.nextval,'" + cedula + "','" + nombre
                    + "','" + apellidoP + "','" + apellidoM + "','" + fechaNac
                    + "','" + lugarR + "','" + Direccion + "','" + telefono
                    + "','" + email + "','" + genero + "','" + lugarN
                    + "','" + EC + "','" + tipoSangre + "')";

            PreparedStatement st = con.prepareStatement(sql);
            st.execute();

            st.close();
            test = true;

            JOptionPane.showMessageDialog(null, "Item Agregado", "Alerta!",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            test = false;
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void DeleteEmpleados(String id) {

        try {
            conn.connection();
            Connection con = conn.getConn();

            String sql = "delete CAT_EMPLEADOS \n"
                    + "where idpersona='" + id + "'";

            PreparedStatement st = con.prepareStatement(sql);
            st.execute();
            st.close();

            test = true;
            JOptionPane.showMessageDialog(null, "Item Eliminado", "Alerta!",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            test = false;
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void editEmpleados(
            String id, String cedula, String nombre, String apellidoP,
            String apellidoM, String fechaNac, String lugarR,
            String Direccion, String telefono, String email,
            String genero, String lugarN, String EC, String tipoSangre) {

        try {
            conn.connection();
            Connection con = conn.getConn();

            String sql = "update CAT_EMPLEADOS \n"
                    + "set cedula='" + cedula + "',nombre='" + nombre + "',apellidoP='" + apellidoP + "'\n"
                    + ",apellidoM='" + apellidoM + "', fechaNac='" + fechaNac + "',lugarresi='" + lugarR + "'\n"
                    + ",direccion='" + Direccion + "', telefono='" + telefono + "',email='" + email + "'\n"
                    + ",genero='" + genero + "', lugarnac='" + lugarN + "',estadocivil='" + EC + "'\n"
                    + "where idpersona='" + id + "'";

            PreparedStatement st = con.prepareStatement(sql);
            st.execute();
            st.close();

            test = true;

        } catch (SQLException e) {
            test = false;
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * nomina *
     */
    public String[] SelectNomin() {

        String[] matrizCiudad = null;
        try {

            conn.connection();
            Connection con = conn.getConn();

            String sql = "select IDSUELDO from CAT_sueldos";
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            int i = 0;
            int c = 1;

            while (res.next()) {
                for (int j = 0; j < c; j++) {

                }
                i++;
            }

            st = con.createStatement();
            res = st.executeQuery(sql);
            System.out.println(i++);
            matrizCiudad = new String[i - 1];

            i = 0;
            c = 1;
            while (res.next()) {
                for (int j = 0; j < c; j++) {
                    matrizCiudad[i] = res.getString(j + 1);
                    System.out.println(matrizCiudad[i]);
                }
                i++;

            }

        } catch (SQLException e) {
            test = false;
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
        return matrizCiudad;
    }

    public String[] SelectNombres() {
        String nombre = null;
        String[] matrizCiudad = null;
        try {

            conn.connection();
            Connection con = conn.getConn();

            String sql = "select IDPERSONA from CAT_EMPLEADOS";
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            int i = 0;
            int c = 1;

            while (res.next()) {
                for (int j = 0; j < c; j++) {

                }
                i++;
            }

            st = con.createStatement();
            res = st.executeQuery(sql);
            System.out.println(i++);
            matrizCiudad = new String[i - 1];

            i = 0;
            c = 1;
            while (res.next()) {
                for (int j = 0; j < c; j++) {
                    matrizCiudad[i] = res.getString(j + 1);
                    System.out.println(matrizCiudad[i]);
                }
                i++;

            }

        } catch (SQLException e) {
            test = false;
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
        return matrizCiudad;
    }

    public String Selectdescripcion(String id) {
        String idq = null;
        try {

            conn.connection();
            Connection con = conn.getConn();

            String sql = "select descripcion from CAT_sueldos where idsueldo='" + id + "'";
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                id = res.getString(1);
            }

            test = true;

        } catch (SQLException e) {
            test = false;
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
        return id;
    }

    public String Selectnombre(String id) {
        String idq = null;
        try {

            conn.connection();
            Connection con = conn.getConn();

            String sql = "select nombre from CAT_EMPLEADOS where idpersona=" + id;
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                id = res.getString(1);
            }

            test = true;

        } catch (SQLException e) {
            test = false;
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
        return id;
    }

    public String[] SelectNombresInsituciones() {
        String nombre = null;
        String[] matrizCiudad = null;
        try {

            conn.connection();
            Connection con = conn.getConn();

            String sql = "select NOMFUNCION from EST_INSTITUCIONAL ";
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            int i = 0;
            int c = 1;

            while (res.next()) {
                for (int j = 0; j < c; j++) {

                }
                i++;
            }

            st = con.createStatement();
            res = st.executeQuery(sql);
            System.out.println(i++);
            matrizCiudad = new String[i - 1];

            i = 0;
            c = 1;
            while (res.next()) {
                for (int j = 0; j < c; j++) {
                    matrizCiudad[i] = res.getString(j + 1);
                    System.out.println(matrizCiudad[i]);
                }
                i++;

            }

        } catch (SQLException e) {
            test = false;
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
        return matrizCiudad;
    }

    public String[] SelectNombresCargos() {
        String nombre = null;
        String[] matrizCiudad = null;
        try {

            conn.connection();
            Connection con = conn.getConn();

            String sql = "select NOMBRE from CAT_CARGOS";
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            int i = 0;
            int c = 1;

            while (res.next()) {
                for (int j = 0; j < c; j++) {

                }
                i++;
            }

            st = con.createStatement();
            res = st.executeQuery(sql);
            System.out.println(i++);
            matrizCiudad = new String[i - 1];

            i = 0;
            c = 1;
            while (res.next()) {
                for (int j = 0; j < c; j++) {
                    matrizCiudad[i] = res.getString(j + 1);
                    System.out.println(matrizCiudad[i]);
                }
                i++;

            }

        } catch (SQLException e) {
            test = false;
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
        return matrizCiudad;
    }

    public String[] SelectNombresFunciones() {
        String nombre = null;
        String[] matrizCiudad = null;
        try {

            conn.connection();
            Connection con = conn.getConn();

            String sql = "select NOMBRE from FUNCIONES";
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            int i = 0;
            int c = 1;

            while (res.next()) {
                for (int j = 0; j < c; j++) {

                }
                i++;
            }

            st = con.createStatement();
            res = st.executeQuery(sql);
            System.out.println(i++);
            matrizCiudad = new String[i - 1];

            i = 0;
            c = 1;
            while (res.next()) {
                for (int j = 0; j < c; j++) {
                    matrizCiudad[i] = res.getString(j + 1);
                    System.out.println(matrizCiudad[i]);
                }
                i++;

            }

        } catch (SQLException e) {
            test = false;
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
        return matrizCiudad;
    }

    
     public void InsertFuciones(String id, String descripcion, String valor) {

        try {
            conn.connection();
            Connection con = conn.getConn();

            //System.out.println(id + descripcion);
            String sql = "insert into FUNCIONES values('" + id + "','" + descripcion + "','" + valor + "')";

            PreparedStatement st = con.prepareStatement(sql);
            st.execute();

            st.close();
            test = true;
        } catch (Exception e) {
            test = false;
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }

    }
       public void editFunciones(String id, String descripcion, String Valor) {

        try {
            conn.connection();
            Connection con = conn.getConn();

            String sql = "update funciones \n"
                    + "set idfuncion='" + id + "',idcargo='" + descripcion + "',nombre='" + Valor + "'\n"
                    + "where idfuncion='" + id + "'";
            
            System.out.println(sql);

            PreparedStatement st = con.prepareStatement(sql);
            st.execute();
            
            JOptionPane.showMessageDialog(null, "Item editado con exito", "Alerta!", JOptionPane.INFORMATION_MESSAGE);
            st.close();
            

            test = true;

        } catch (SQLException e) {
            test = false;
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void DeleteFunciones(String id) {

        try {
            conn.connection();
            Connection con = conn.getConn();

            String sql = "delete funciones \n"
                    + "where idfuncion='" + id + "'";
            
            System.out.println(sql);

            PreparedStatement st = con.prepareStatement(sql);
            st.execute();
            
            JOptionPane.showMessageDialog(null, "Item borrado con exito", "Alerta!", JOptionPane.INFORMATION_MESSAGE);
            st.close();

            test = true;

        } catch (SQLException e) {
            test = false;
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }

    }
}
