package DAO;
import DAO.Interfaces.VentasDAO;
import Modelo.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class MysqlVentasDAO implements VentasDAO {
    
    //Metodo para listar todos los comics
    @Override
    public void listarComic(JTable tabla) {
        Connection cn=null;
        Statement st=null;
        ResultSet rs=null;
        String titulos[]={"ID","Titulo","Ejemplares","Costo","Ubicación"};
        DefaultTableModel modelo=new DefaultTableModel(null, titulos);
        tabla.setModel(modelo);
        try {
            cn=new ConectarBD().getConectar();
            st=cn.createStatement();
            String consulta="SELECT comic_id,titulo,ejemplares,costo,ubicacion_estante FROM comiccrown.comics "
                            + "where ejemplares>0 and ind='V';";
            rs=st.executeQuery(consulta);
            while (rs.next()) {
                Comic cm=new Comic();
                cm.setComic_id(rs.getInt(1));
                cm.setTitulo(rs.getString(2));
                cm.setEjemplares(rs.getInt(3));
                cm.setCosto(rs.getDouble(4));
                cm.setUbicacion_estante(rs.getString(5));
                modelo.addRow(cm.Listado());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try{
                if(cn!=null) cn.close();
                if(rs!=null) cn.close();
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }
    }
    
    //Metodo para filtrar los comics
    @Override
    public void listaComicxNombre(String nombre,JTable tabla) {
        Connection cn=null;
        PreparedStatement pstm=null;
        ResultSet rs=null;
        String titulos[]={"ID","Titulo","Ejemplares","Costo","Ubicación"};
        DefaultTableModel modelo=new DefaultTableModel(null, titulos);
        tabla.setModel(modelo);
        try{
            cn=new ConectarBD().getConectar();
            String consulta="select comic_id,titulo,ejemplares,costo,ubicacion_estante from comics WHERE  titulo like ? "
                            + "and  ejemplares>0 and ind='V';";
            pstm=cn.prepareStatement(consulta);
            pstm.setString(1, nombre+"%");
            rs=pstm.executeQuery();
            while (rs.next()) {
                Comic cm=new Comic();
                cm.setComic_id(rs.getInt(1));
                cm.setTitulo(rs.getString(2));
                cm.setEjemplares(rs.getInt(3));
                cm.setCosto(rs.getDouble(4));
                cm.setUbicacion_estante(rs.getString(5));
                modelo.addRow(cm.Listado());
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try{
                if(cn!=null)cn.close();
                if(pstm!=null)pstm.close();
                if(rs!=null)cn.close();
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }
    }
    
    //Metodo , trasancción para realizar la venta
    @Override
    public int insertarVenta(Venta ven,DefaultTableModel modelo) {
        Connection cn=null;
        PreparedStatement ps=null;
        try{
            cn=new ConectarBD().getConectar();
            cn.setAutoCommit(false);
            //Registrar la venta
            String consulta="insert into ventas (fecha_venta,monto) values (NOW(),?);";
            ps=cn.prepareStatement(consulta,Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1,ven.getMonto());
            ps.executeUpdate();
            ResultSet rskey=ps.getGeneratedKeys();
            rskey.next();
            int codvent=rskey.getInt(1);
            
            //Insertamos en Comic_X_Venta
            String consulta1="insert into comic_x_venta(comic_id,ventas_id,cantidad) values(?,?,?);";
            for (int fila = 0; fila<modelo.getRowCount() ; fila++) {
                ps=cn.prepareStatement(consulta1);
                int id=(int) modelo.getValueAt(fila, 0);
                int cant=(int) modelo.getValueAt(fila, 3);
                ps.setInt(1, id);
                ps.setInt(2, codvent);
                ps.setInt(3, cant);
                ps.executeUpdate();
                
                //actualizamos la cantidad de ejemplares
                String consulta2="update comics set ejemplares= ejemplares-?\n" +
                                  "where comic_id=?;";
                ps=cn.prepareStatement(consulta2);
                ps.setInt(1, cant);
                ps.setInt(2, id);
                ps.executeUpdate();
            }
            cn.commit();
            return codvent;
        }catch(Exception ex){
            try {
                cn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            ex.printStackTrace();
            return 0;
        }finally{
            try{
                if(cn!=null) cn.close();
                if(ps!=null) ps.close();
            }catch(Exception ex2){
                ex2.printStackTrace();
            }
        }
    }

    @Override
    public void consultapdf(PdfPTable tabla,Document documento,int cod) {
        Connection cn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            cn=new ConectarBD().getConectar();
            String consulta="select c.titulo,costo,x.cantidad from comic_x_venta x \n" +
                            "inner join comics c on (x.comic_id=c.comic_id) where x.ventas_id=?;";
            ps=cn.prepareStatement(consulta);
            ps.setInt(1, cod);
            rs=ps.executeQuery();
            while (rs.next()) {
                tabla.addCell(rs.getString(1));
                tabla.addCell(String.valueOf(rs.getDouble(2)));
                tabla.addCell(String.valueOf(rs.getInt(3)));
            }
            documento.add(tabla);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try{
                if(cn!=null){cn.close();}
                if(rs!=null){rs.close();}
                if(ps!=null){ps.close();}
                documento.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public int cantidadvent(int id) {
        Connection cn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        int cant=0;
        try{
            cn=new ConectarBD().getConectar();
            String consulta="SELECT ejemplares FROM comics where comic_id=?;";
            ps=cn.prepareStatement(consulta);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            while (rs.next()) {
                cant=rs.getInt(1);
            }
            return cant;
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }finally{
            try{
                if(cn!=null){cn.close();}
                if(rs!=null){rs.close();}
                if(ps!=null){ps.close();}
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
