package orcl;

/**
 *
 * @author Gt37285
 */
public class Division {
    private String id_division,id_divisionp,nombre,ultimo_nivel,nivel,hoja;

    public String getId_division() {
        return id_division;
    }

    public void setId_division(String id_division) {
        this.id_division = id_division;
    }

    public String getId_divisionp() {
        return id_divisionp;
    }

    public void setId_divisionp(String id_divisionp) {
        this.id_divisionp = id_divisionp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUltimo_nivel() {
        return ultimo_nivel;
    }

    public void setUltimo_nivel(String ultimo_nivel) {
        this.ultimo_nivel = ultimo_nivel;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getHoja() {
        return hoja;
    }

    public void setHoja(String hoja) {
        this.hoja = hoja;
    }
    
     public Division(String id, String id_dep, String nombre, String nivel, String ultimo_nivel, String hoja){
        this.id_division = id;
        this.id_divisionp = id_dep;
        this.nombre =  nombre;
        this.nivel = nivel;
        this.ultimo_nivel = ultimo_nivel;
        this.hoja = hoja;
    }
     
    @Override
    public String toString() {
        return id_division +" "+ id_divisionp + " " + nombre + " " + ultimo_nivel + " " + nivel + " " + hoja + "\n";
    }

     
    
}
