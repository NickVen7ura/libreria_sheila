package Formatos;

import DAO.DAOinventario;
import Modelo.*;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class CargarComboBox_Iinventario {
    public static ArrayList<Autor> autores = new ArrayList<>();
    public static ArrayList<Editoriales> edit = new ArrayList<>();
    public static ArrayList<Genero> gen = new ArrayList<>();
    
    public static void nombreEditoriales(JComboBox cbx){
    cbx.removeAllItems();

        DAOinventario dai=new DAOinventario();
        dai.CargarEditorial(cbx);
    }
    public static void nombreAutor(JComboBox cbx){
        cbx.removeAllItems();
        DAOinventario dai=new DAOinventario();
        dai.CargarAutor(cbx);
    }
    public static void nombreGenero(JComboBox cbx){
        cbx.removeAllItems();
        DAOinventario dai=new DAOinventario();
        dai.CargarGenero(cbx);
    }
}
