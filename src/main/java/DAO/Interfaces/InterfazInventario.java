package DAO.Interfaces;

import Modelo.*;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public interface InterfazInventario {

    public List ListarComic();

    public Comic Obtener(int id);

    public void Crear(Comic cmc,DefaultTableModel modelo,DefaultTableModel modelo1);

    //public boolean Actualizar(Comic cmc);
    public boolean Eliminar(int id);

    void listaComicxNombre(String nombre, JTable tabla);

    public void CargarEditorial(JComboBox cbx);

 public void CargarAutor(JComboBox cbx);

    public void CargarGenero(JComboBox cbx);

}
