
package Modelo;

public class Trabajadores {
    private int trabajador_id;
    private int sucursal_id;
    private int dni;
    private String fotografia;
    private String nombre;
    private String apellido;
    private String username;
    private String password;
    private String email;
    private String telefono;
    private String direccion;
    private double sueldo;

    public int getTrabajador_id() {return trabajador_id;}
    public void setTrabajador_id(int trabajador_id) {this.trabajador_id = trabajador_id;}

    public int getSucursal_id() {return sucursal_id;}
    public void setSucursal_id(int sucursal_id) {this.sucursal_id = sucursal_id;}

    public int getDni() {return dni;}
    public void setDni(int dni) {this.dni = dni;}

    public String getFotografia() {return fotografia;}
    public void setFotografia(String fotografia) {this.fotografia = fotografia;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getApellido() {return apellido;}
    public void setApellido(String apellido) {this.apellido = apellido;}

    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getTelefono() {return telefono;}
    public void setTelefono(String telefono) {this.telefono = telefono;}

    public String getDireccion() {return direccion;}
    public void setDireccion(String direccion) {this.direccion = direccion;}

    public double getSueldo() {return sueldo;}
    public void setSueldo(double sueldo) {this.sueldo = sueldo;}
    
    public Object[] ListaTrabajdores(){
        Object listarTrabajadores[]={trabajador_id, nombre, apellido, telefono, email,dni, username, sueldo};
        return listarTrabajadores;
    }
}
