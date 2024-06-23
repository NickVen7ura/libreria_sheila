package DAO.Interfaces;

import Modelo.Venta;
import javax.swing.JButton;
import javax.swing.JTable;

public interface HistorialVentaDAO {
   void listarHistorialVent(JTable tabla,JButton btn);
   void listarHistorialxID(JTable tabla,JButton btn,int id);
   void filtrarxmontomayor(JTable tabla,JButton btn);
   void filtrarventasemana(JTable tabla,JButton btn);
   void filtrarxmontomenor(JTable tabla,JButton btn);
   void ordenarMontomenormayor(JTable tabla,JButton btn);
   void ordenarMontomayormenor(JTable tabla,JButton btn);
   void ordenarFechamenormayor(JTable tabla,JButton btn); 
   void ordenarFechamayormenor(JTable tabla,JButton btn);
}
