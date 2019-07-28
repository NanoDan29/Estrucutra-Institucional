package orcl;

/**
 *
 * @author Gt37285
 */
public class Estructura implements Comparable<Estructura>{
    
    private String id,id_departamento,nombre,ultimo_nivel,nivel,hoja;

    public String getHoja() {
        return hoja;
    }

    public void setHoja(String hoja) {
        this.hoja = hoja;
    }

    
    public Estructura(String id, String id_dep, String nombre, String nivel, String ultimo_nivel, String hoja){
        this.id = id;
        this.id_departamento = id_dep;
        this.nombre =  nombre;
        this.nivel = nivel;
        this.ultimo_nivel = ultimo_nivel;
        this.hoja = hoja;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(String id_departamento) {
        this.id_departamento = id_departamento;
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

    @Override
    public String toString() {
        return id +" "+ id_departamento + " " + nombre + " " + ultimo_nivel + " " + nivel + " " + hoja + "\n";
    }

    @Override
    public int compareTo(Estructura o) {
       return id.compareTo(o.getId());
    }

   
    
}
