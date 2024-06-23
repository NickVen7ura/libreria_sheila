package DAO.Interfaces;

import Modelo.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public interface VentasDAO {
    void listarComic(JTable tabla);
    void listaComicxNombre(String nombre,JTable tabla);
    int insertarVenta(Venta ven,DefaultTableModel modelo);
    void consultapdf(PdfPTable tabla,Document documento,int cod);
    int cantidadvent(int id);
}
