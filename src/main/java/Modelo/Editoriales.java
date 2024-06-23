package Modelo;

public class Editoriales {
    private int editorial_id;
    private int telefono;
    private int año_fundacion;
    private String nombre;
    private String pais;
    private String email;

    public int getEditorial_id() {return editorial_id;}
    public void setEditorial_id(int editorial_id) {this.editorial_id = editorial_id;}

    public int getTelefono() {return telefono;}
    public void setTelefono(int telefono) {this.telefono = telefono;}
    
    public int getAño_fundacion() {return año_fundacion;}
    public void setAño_fundacion(int año_fundacion) {this.año_fundacion = año_fundacion;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getPais() {return pais;}
    public void setPais(String pais) {this.pais = pais;}
    
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    
    public Object[] ListaEditoriales(){
        Object listarEditoriales[]={editorial_id,nombre,pais,telefono, email, año_fundacion};
        return listarEditoriales;
    }


}
