package DAO;

import DAO.Interfaces.*;
import Modelo.Editoriales;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class DAOeditoriales implements EditorialesDAO {

    ConectarBD conexion = new ConectarBD();
    Connection cnt;
    PreparedStatement pstt;
    ResultSet rst;
    Editoriales editoriales = new Editoriales();

    @Override
    public List ListarEditoriales() {
        ArrayList<Editoriales> listaedit = new ArrayList();
        String consulta = "select editorial_id, nombre, pais, año_fundacion from editoriales where ind='V'";
        try {
            cnt = conexion.getConnection();
            pstt = cnt.prepareStatement(consulta);
            rst = pstt.executeQuery();
            while (rst.next()) {
                Editoriales edi = new Editoriales();
                edi.setEditorial_id(rst.getInt("editorial_id"));
                edi.setNombre(rst.getString("nombre"));
                edi.setPais(rst.getString("pais"));
                edi.setAño_fundacion(rst.getInt("año_fundacion"));
                listaedit.add(edi);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se pueden mostrar las Editoriales. \n" + ex);
        }
        return listaedit;

    }

    @Override
    public Editoriales Obtener(int id) {
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            cn = new ConectarBD().getConectar();
            String consulta = "SELECT * FROM editoriales where editoriales_id=?;";
            ps = cn.prepareStatement(consulta);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Editoriales ed = new Editoriales();
                ed.setEditorial_id(rs.getInt(consulta));
                return ed;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                //documento.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean Crear(Editoriales edi) {
        String consulta = "insert into editoriales(nombre,pais,año_fundacion,ind) value(?,?,?,'V')";
        try {
            cnt = conexion.getConnection();
            pstt = cnt.prepareStatement(consulta);
            pstt.setString(1, edi.getNombre());
            pstt.setString(2, edi.getPais());
            pstt.setInt(3, edi.getAño_fundacion());
            pstt.executeUpdate();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se pudo agregar los datos de la nueva Editorial. \n" + ex);
        }
        return false;

    }

    @Override
    public boolean Actualizar(Editoriales edi) {
        String consulta = "UPDATE editoriales SET nombre=?, pais=?, año_fundacion=? WHERE editorial_id=?";
        try {
            cnt = conexion.getConnection();
            pstt = cnt.prepareStatement(consulta);
            pstt.setString(1, edi.getNombre());
            pstt.setString(2, edi.getPais());
            pstt.setInt(3, edi.getAño_fundacion());
            
            pstt.setInt(6, edi.getEditorial_id());
            pstt.executeUpdate();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se pudo actualizar los datos de la Editorial. \n" + ex);
        }
        return false;

    }

    @Override
    public boolean Eliminar(int id) {
        String consulta = "update editoriales set ind='N' where editorial_id=?;";
        try {
            cnt = conexion.getConnection();
            pstt = cnt.prepareStatement(consulta);
            pstt.setInt(1, id);
            pstt.executeUpdate();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar los datos de la Editorial \n" + ex);
        }
        return false;
    }

}
