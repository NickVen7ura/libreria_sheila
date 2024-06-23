package DAO;

import DAO.Interfaces.*;
import Formatos.CargarComboBox_Iinventario;
import Modelo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DAOinventario implements InterfazInventario {

    ConectarBD conexion = new ConectarBD();
    Connection cnt;
    PreparedStatement pstt;
    ResultSet rst;
    Comic comic = new Comic();

    @Override
    public List ListarComic() {
        ArrayList<Comic> listacmc = new ArrayList();
        String consulta = "SELECT c.comic_id, e.nombre, c.titulo, c.ubicacion_estante, c.clasificacion, c.formato, c.num_pagina, c.ejemplares, c.costo FROM comics c INNER JOIN editoriales e ON c.editorial_id = e.editorial_id WHERE c.ind='V'";
        try {
            cnt = conexion.getConnection();
            pstt = cnt.prepareStatement(consulta);
            rst = pstt.executeQuery();
            while (rst.next()) {
                Comic cmc = new Comic();
                cmc.setComic_id(rst.getInt(1));
                cmc.setEditorial(rst.getString(2));
                cmc.setTitulo(rst.getString(3));
                cmc.setUbicacion_estante(rst.getString(4));
                cmc.setClasificacion(rst.getString(5));
                cmc.setFormato(rst.getString(6));
                cmc.setNum_pagina(rst.getInt(7));
                cmc.setEjemplares(rst.getInt(8));
                cmc.setCosto(rst.getDouble(9));
                listacmc.add(cmc);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se puede mostrar los comics. \n" + ex);
        }
        return listacmc;
    }

    @Override
    public Comic Obtener(int id) {
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            cn = new ConectarBD().getConectar();
            String consulta = "SELECT * FROM comic_crown.comics where comic_id=?;";
            ps = cn.prepareStatement(consulta);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Comic cm = new Comic();
                cm.setComic_id(rs.getInt(consulta));
                return cm;
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
    public void Crear(Comic cmc, DefaultTableModel modelo, DefaultTableModel modelo1) {
        Connection cn = null;
        PreparedStatement ps = null;
        try {
            cn = new ConectarBD().getConectar();
            cn.setAutoCommit(false);
            //Registrar la venta
            String consulta = "insert into comics(editorial_id,fotografia,titulo,num_pagina,sipnosis,formato,fecha_edicion,costo,ubicacion_estante,ejemplares\n"
                    + ",clasificacion,ind) values (?,?,?,?,?,?,?,?,?,?,?,'V');";
            ps = cn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, cmc.getEditorial_id());
            ps.setString(2, cmc.getFotografia());
            ps.setString(3, cmc.getTitulo());
            ps.setInt(4, cmc.getNum_pagina());
            ps.setString(5, cmc.getSipnosis());
            ps.setString(6, cmc.getFormato());
            ps.setDate(7, cmc.getFecha_edicion());
            ps.setDouble(8, cmc.getCosto());
            ps.setString(9, cmc.getUbicacion_estante());
            ps.setDouble(10, cmc.getEjemplares());
            ps.setString(11, cmc.getClasificacion());
            ps.executeUpdate();
            ResultSet rskey = ps.getGeneratedKeys();
            rskey.next();
            int codcomi = rskey.getInt(1);

            //Insertamos en Comic_X_autor
            String consulta1 = "insert into comic_x_autor(comic_id,autor_id) values(?,?);";
            for (int fila = 0; fila < modelo.getRowCount(); fila++) {
                ps = cn.prepareStatement(consulta1);
                int id = (int) modelo.getValueAt(fila, 0);
                ps.setInt(1, codcomi);
                ps.setInt(2, id);
                ps.executeUpdate();
            }
            //Insertamos en Comic_X_genero
            String consulta2 = "insert into comic_x_genero(comic_id,genero_id) values(?,?);";
            for (int fila = 0; fila < modelo1.getRowCount(); fila++) {
                ps = cn.prepareStatement(consulta2);
                int idg = (int) modelo.getValueAt(fila, 0);
                ps.setInt(1, codcomi);
                ps.setInt(2, idg);
                ps.executeUpdate();
            }
            cn.commit();
        }catch(Exception ex){
            try {
                cn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            ex.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception ex2) {
                ex2.printStackTrace();
            }
        }
    }

    @Override
    public boolean Eliminar(int id) {
        String consulta = "update comics set ind='N' where comic_id=?;";
        try {
            cnt = conexion.getConnection();
            pstt = cnt.prepareStatement(consulta);
            pstt.setInt(1, id);
            pstt.executeUpdate();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar los datos del cliente \n" + ex);
        }
        return false;
    }

    //Metodo para filtrar los comics
    @Override
    public void listaComicxNombre(String nombre, JTable tabla) {
        Connection cn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        tabla.setModel(modelo);
        modelo.setRowCount(0);
        try {
            cn = new ConectarBD().getConectar();
            String consulta = "SELECT c.comic_id, e.nombre, c.titulo, c.ubicacion_estante, c.clasificacion, c.formato, c.num_pagina, c.ejemplares, c.costo \n"
                    + "FROM comics c \n"
                    + "INNER JOIN editoriales e ON c.editorial_id = e.editorial_id \n"
                    + "WHERE c.titulo LIKE ? AND ejemplares > 0 AND c.ind = 'V'; ";
            pstm = cn.prepareStatement(consulta);
            pstm.setString(1, nombre + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                Comic cm = new Comic();
                cm.setComic_id(rs.getInt(1));
                cm.setEditorial(rs.getString(2));
                cm.setTitulo(rs.getString(3));
                cm.setUbicacion_estante(rs.getString(4));
                cm.setClasificacion(rs.getString(5));
                cm.setFormato(rs.getString(6));
                cm.setNum_pagina(rs.getInt(7));
                cm.setEjemplares(rs.getInt(8));
                cm.setCosto(rs.getDouble(9));
                modelo.addRow(cm.ListaInventario());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (rs != null) {
                    cn.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void CargarEditorial(JComboBox cbx) {
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            cn = new ConectarBD().getConectar();
            st = cn.createStatement();
            String consulta = "SELECT editorial_id,nombre FROM comic_crown.editoriales;";
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                Editoriales edi = new Editoriales();
                edi.setEditorial_id(rs.getInt(1));
                edi.setNombre(rs.getString(2));
                cbx.addItem(edi.getNombre());
                CargarComboBox_Iinventario.edit.add(edi);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
                if (rs != null) {
                    cn.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void CargarAutor(JComboBox cbx) {
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            cn = new ConectarBD().getConectar();
            st = cn.createStatement();
            String consulta = "SELECT autor_id,apellido FROM comic_crown.autores;";
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                Autor aut = new Autor();
                aut.setAutor_id(rs.getInt(1));
                aut.setApellido(rs.getString(2));
                cbx.addItem(aut.getApellido());
                CargarComboBox_Iinventario.autores.add(aut);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
                if (rs != null) {
                    cn.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void CargarGenero(JComboBox cbx) {
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            cn = new ConectarBD().getConectar();
            st = cn.createStatement();
            String consulta = "SELECT * FROM comic_crown.generos;";
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                Genero gn = new Genero();
                gn.setGenero_id(rs.getInt(1));
                gn.setNombre(rs.getString(2));
                cbx.addItem(gn.getNombre());
                CargarComboBox_Iinventario.gen.add(gn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
                if (rs != null) {
                    cn.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
