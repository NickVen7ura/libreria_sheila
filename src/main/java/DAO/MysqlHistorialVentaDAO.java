package DAO;
import DAO.Interfaces.HistorialVentaDAO;
import Modelo.Venta;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MysqlHistorialVentaDAO implements HistorialVentaDAO {

    @Override
    public void listarHistorialVent(JTable tabla,JButton btn) {
        Connection cn=null;
        Statement st=null;
        ResultSet rs=null;
        DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0); 
        try {
            cn=new ConectarBD().getConectar();
            st=cn.createStatement();
            String consulta="select * from ventas";
            rs=st.executeQuery(consulta);
            while (rs.next()) {
                Venta ven=new Venta();
                ven.setVenta_id(rs.getInt(1));
                ven.setFechaVenta(rs.getDate(2));
                ven.setMonto(rs.getDouble(3));
                modelo.addRow(ven.Listar(btn));
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

    @Override
    public void listarHistorialxID(JTable tabla,JButton btn,int id) {
         Connection cn=null;
        Statement st=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0); 

        try {
            cn=new ConectarBD().getConectar();
            st=cn.createStatement();
            String consulta="select * from ventas where ventas_id=?";
            ps=cn.prepareStatement(consulta);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            while (rs.next()) {
                Venta ven=new Venta();
                ven.setVenta_id(rs.getInt(1));
                ven.setFechaVenta(rs.getDate(2));
                ven.setMonto(rs.getDouble(3));
                modelo.addRow(ven.Listar(btn));
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

    @Override
    public void filtrarxmontomayor(JTable tabla, JButton btn) {
        Connection cn=null;
        Statement st=null;
        ResultSet rs=null;
        DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0); 
        try {
            cn=new ConectarBD().getConectar();
            st=cn.createStatement();
            String consulta="select *from ventas where monto>=150 ;";
            rs=st.executeQuery(consulta);
            while (rs.next()) {
                Venta ven=new Venta();
                ven.setVenta_id(rs.getInt(1));
                ven.setFechaVenta(rs.getDate(2));
                ven.setMonto(rs.getDouble(3));
                modelo.addRow(ven.Listar(btn));
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

    @Override
    public void filtrarventasemana(JTable tabla, JButton btn) {
        Connection cn=null;
        Statement st=null;
        ResultSet rs=null;
        DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0); 
        try {
            cn=new ConectarBD().getConectar();
            st=cn.createStatement();
            String consulta="SELECT * FROM ventas WHERE YEARWEEK(fecha_venta) = YEARWEEK(CURDATE());";
            rs=st.executeQuery(consulta);
            while (rs.next()) {
                Venta ven=new Venta();
                ven.setVenta_id(rs.getInt(1));
                ven.setFechaVenta(rs.getDate(2));
                ven.setMonto(rs.getDouble(3));
                modelo.addRow(ven.Listar(btn));
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

    @Override
    public void filtrarxmontomenor(JTable tabla, JButton btn) {
        Connection cn=null;
        Statement st=null;
        ResultSet rs=null;
        DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0); 
        try {
            cn=new ConectarBD().getConectar();
            st=cn.createStatement();
            String consulta="select * from ventas where monto<=100 ;";
            rs=st.executeQuery(consulta);
            while (rs.next()) {
                Venta ven=new Venta();
                ven.setVenta_id(rs.getInt(1));
                ven.setFechaVenta(rs.getDate(2));
                ven.setMonto(rs.getDouble(3));
                modelo.addRow(ven.Listar(btn));
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

    @Override
    public void ordenarMontomenormayor(JTable tabla, JButton btn) {
        Connection cn=null;
        Statement st=null;
        ResultSet rs=null;
        DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0); 
        try {
            cn=new ConectarBD().getConectar();
            st=cn.createStatement();
            String consulta="SELECT * FROM ventas ORDER BY monto ASC;";
            rs=st.executeQuery(consulta);
            while (rs.next()) {
                Venta ven=new Venta();
                ven.setVenta_id(rs.getInt(1));
                ven.setFechaVenta(rs.getDate(2));
                ven.setMonto(rs.getDouble(3));
                modelo.addRow(ven.Listar(btn));
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

    @Override
    public void ordenarMontomayormenor(JTable tabla, JButton btn) {
    Connection cn=null;
        Statement st=null;
        ResultSet rs=null;
        DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0); 
        try {
            cn=new ConectarBD().getConectar();
            st=cn.createStatement();
            String consulta="SELECT * FROM ventas ORDER BY monto DESC;";
            rs=st.executeQuery(consulta);
            while (rs.next()) {
                Venta ven=new Venta();
                ven.setVenta_id(rs.getInt(1));
                ven.setFechaVenta(rs.getDate(2));
                ven.setMonto(rs.getDouble(3));
                modelo.addRow(ven.Listar(btn));
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

    @Override
    public void ordenarFechamenormayor(JTable tabla, JButton btn) {
Connection cn=null;
        Statement st=null;
        ResultSet rs=null;
        DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0); 
        try {
            cn=new ConectarBD().getConectar();
            st=cn.createStatement();
            String consulta="SELECT * FROM ventas ORDER BY fecha_venta ASC;";
            rs=st.executeQuery(consulta);
            while (rs.next()) {
                Venta ven=new Venta();
                ven.setVenta_id(rs.getInt(1));
                ven.setFechaVenta(rs.getDate(2));
                ven.setMonto(rs.getDouble(3));
                modelo.addRow(ven.Listar(btn));
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

    @Override
    public void ordenarFechamayormenor(JTable tabla, JButton btn) {
Connection cn=null;
        Statement st=null;
        ResultSet rs=null;
        DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0); 
        try {
            cn=new ConectarBD().getConectar();
            st=cn.createStatement();
            String consulta="SELECT * FROM ventas ORDER BY fecha_venta DESC;";
            rs=st.executeQuery(consulta);
            while (rs.next()) {
                Venta ven=new Venta();
                ven.setVenta_id(rs.getInt(1));
                ven.setFechaVenta(rs.getDate(2));
                ven.setMonto(rs.getDouble(3));
                modelo.addRow(ven.Listar(btn));
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
    
}
