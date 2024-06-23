package Formatos;

import Vista.vistaHistorial_Venta;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

public class FormatoHistorialVenta {
    //DAR ESTILO A LA TABLA
    public static void EstiloTabla(JTable tabla) {
        String titulos[] = {"ID", "Fecha Venta", "Monto Total", "Visualizar"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };
        tabla.setModel(modelo);
    }
    
    public static void LimpiarCampos(vistaHistorial_Venta vh){
        vh.txfIngresoID.setText("");
        vh.cbxFiltrar.setSelectedItem("Selecciona");
        vh.cbxOrdenar.setSelectedItem("Selecciona");
        vh.txfIngresoID.requestFocus();
    }

}
