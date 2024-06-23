package DAO;
import java.sql.*;
public class ConectarBD implements Parametros{
    public Connection con;
    public PreparedStatement ps;
    public Statement st;
    public ResultSet rs;
    public String mensaje;
    
    public ConectarBD(){
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url,username,password);
            st = con.createStatement();
            mensaje="Se ha conseguido la conexión con base de datos";
        }catch(Exception ex){
            mensaje="ERROR: Algo salio mal, pero no es tu culpa "+ex;
        }
    }
    
    /*----------------------------------¿Que metodo usaras?--------------------------------*/
    //Lo de Franks
    public Connection getConnection() {
        return con;
    }
    
    //Lo de Diego
    public Connection getConectar(){
        Connection cn=null;
        try{
            Class.forName(driver);
            cn=DriverManager.getConnection(url,username,password);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return cn;
    }
}
