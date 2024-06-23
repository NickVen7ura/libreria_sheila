package Controlador;

import DAO.MysqlVentasDAO;
import Formatos.FormatoVenta;
import Modelo.*;
import Vista.vistaVenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.*;
import javax.swing.SwingUtilities;

public class ControladorVentas implements DocumentListener, ActionListener {

    MysqlVentasDAO mv;
    vistaVenta vista;
    DefaultTableModel modelo;
    int filaedition;

    public ControladorVentas(vistaVenta view) {
        this.vista = view;
        mv = new MysqlVentasDAO();
        EstiloTabla();
        mv.listarComic(vista.tblComic_venta);
        FormatoVenta.formatoTabla(vista);
        FormatoVenta.formatoInicial(vista);
        vista.btnAgregar.addActionListener(this);
        vista.btnEliminar.addActionListener(this);
        vista.btnVaciar.addActionListener(this);
        vista.btnEditar.addActionListener(this);
        vista.btnActualizar.addActionListener(this);
        vista.btnVender.addActionListener(this);
        vista.txfNombreBuscar.getDocument().addDocumentListener(this);
        EliminarResaltado(vista);
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        LeerInput();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        LeerInput();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnAgregar) {
            int numfila = vista.tblComic_venta.getSelectedRow();
            if (numfila != -1) {
                AgregarVenta(numfila);
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");

            }
        }
        if (e.getSource() == vista.btnEliminar) {
            int fila = vista.tblListaVender.getSelectedRow();
            if (fila != -1) {
               
               int id= (int)modelo.getValueAt(fila, 0);
               int num= (int)modelo.getValueAt(fila, 3);
               modelo.removeRow(fila);
                for (int fila1 = 0; fila1 < vista.tblComic_venta.getRowCount(); fila1++) {
                    if ((int)vista.tblComic_venta.getValueAt(fila1,0)==id) {
                        int numDato=(int)vista.tblComic_venta.getValueAt(fila1, 2)+num;
                        vista.tblComic_venta.setValueAt((Object)numDato, fila1, 2);
                    break;
                    }
                }
                Cantidad();
                Precio();
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");

            }
            if (modelo.getRowCount() <= 0) {
                reiniciar();
                FormatoVenta.formatoInicial(vista);
            }

        }
        if (e.getSource() == vista.btnVaciar) {
            int resultado1 = JOptionPane.showConfirmDialog(null, "¿Desea vaciar la lista", "Proceso de Boleta", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (resultado1 == 0) {
                 modelo.setRowCount(0);
                reiniciar();
                FormatoVenta.formatoInicial(vista);
            } 
        }
        if (e.getSource() == vista.btnEditar) {
            filaedition = vista.tblListaVender.getSelectedRow();

            if (filaedition >= 0) {
                FormatoVenta.formato2(vista);
                Object cant = vista.tblListaVender.getValueAt(filaedition, 3);
                mv.listarComic(vista.tblComic_venta);
                vista.spnCantidad2.setValue(cant);
            } else {
                JOptionPane.showMessageDialog(null, "Selecciona una fila");
            }
        }
        if (e.getSource() == vista.btnActualizar) {
            //obtemos el id y la cantidad actual de esa fila
            int id = (int) vista.tblListaVender.getValueAt(filaedition, 0);

            //obtemos el nuevo dato
            int nuevocant = Integer.parseInt(vista.spnCantidad2.getValue().toString());
            if (nuevocant > 0) {
                int fila1 = 0, id1 = 0;
                //traemos la cantidad de ejemplares
                int cantejem = mv.cantidadvent(id);

                for (int fil = 0; fil < vista.tblComic_venta.getRowCount(); fil++) {
                    id1 = (int) vista.tblComic_venta.getValueAt(fil, 0);
                    if (id == id1) {
                        fila1 = fil;
                        break;
                    }
                }
                if (cantejem < nuevocant) {
                    JOptionPane.showMessageDialog(null, "Agregue una cantidad adecuada",
                            "Error al agregar producto", JOptionPane.WARNING_MESSAGE);
                } else {
                    vista.tblListaVender.setValueAt((Object) nuevocant, filaedition, 3);
                    vista.tblComic_venta.setValueAt(cantejem - nuevocant, fila1, 2);
                    FormatoVenta.formato1(vista);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Agregue una cantidad adecuada",
                        "Error al agregar producto", JOptionPane.WARNING_MESSAGE);
                //proceso para que muestre en pantalla la fila seleccionada 
                SwingUtilities.invokeLater(() -> {
                    vista.tblListaVender.setRowSelectionInterval(filaedition, filaedition);
                });
            }

            FormatoVenta.LimpiarCampos(vista);
            Cantidad();
            Precio();
        }
        if (e.getSource() == vista.btnVender) {
            int cantfila = vista.tblListaVender.getRowCount();
            if (cantfila > 0) {
                int resultado = JOptionPane.showConfirmDialog(null, "¿Desea realizar la venta?", "Proceso de Venta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                //en caso que sea si
                if (resultado == 0) {
                    Venta vent = new Venta();
                    double precioVenta = Precio();
                    vent.setMonto(precioVenta);

                    //INSERTAMOS EN LA TABLA VENTA y COMIC_X_VENTA
                    int cod = mv.insertarVenta(vent, modelo);
                    modelo.setRowCount(0);
                    reiniciar();
                    FormatoVenta.formatoInicial(vista);
                    int resultado1 = JOptionPane.showConfirmDialog(null, "¿Desea generar la boleta?", "Proceso de Boleta", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (resultado1 == 0) {
                        FormatoVenta.generarPdf(cod, mv);
                    } else {
                        JOptionPane.showMessageDialog(null, "Puedes revisar el boleto en el historial");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "No hay ningún comic agregado", "Error al vender", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * METODOS*
     */
    //Metodo para poder recuperar el texto del Texfield
    public void LeerInput() {
        String nombre = vista.txfNombreBuscar.getText();
        mv.listaComicxNombre(nombre, vista.tblComic_venta);
    }

    //DAR ESTILO A LA TABLA
    public void EstiloTabla() {
        String Titulos[] = {"ID", "Comic", "Precio", "Cantidad"};
        modelo = new DefaultTableModel(null, Titulos);
        vista.tblListaVender.setModel(modelo);
    }

    //Agregar el comic a la lista
    public void AgregarVenta(int num) {
        int cantidad = Integer.parseInt(vista.spnCantidad.getValue().toString());
        if (cantidad > 0) {
            //leemos la fila
            Object ID = vista.tblComic_venta.getValueAt(num, 0);
            Object nombre = vista.tblComic_venta.getValueAt(num, 1);
            int ejemplares = (int) vista.tblComic_venta.getValueAt(num, 2);
            Object precio = vista.tblComic_venta.getValueAt(num, 3);
            boolean idnue = buscaridLista((int) ID);
            if (cantidad <= ejemplares && idnue == false) {
                Object agregar[] = {ID, nombre, precio, cantidad};
                modelo.addRow(agregar);
                vista.tblComic_venta.setValueAt(ejemplares - cantidad, num, 2);
                Cantidad();
                Precio();
                FormatoVenta.LimpiarCampos(vista);
                FormatoVenta.formato1(vista);
            } else {
                JOptionPane.showMessageDialog(null, "Agregue una cantidad o el Comic "
                        + "ya esta en la lista",
                        "Error al agregar producto", JOptionPane.WARNING_MESSAGE);
                 vista.spnCantidad.setValue(0);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Agregue una cantidad",
                    "Error al agregar producto", JOptionPane.WARNING_MESSAGE);
            vista.spnCantidad.setValue(0);
        }

    }

    //Metodo que suma los comics en total
    public void Cantidad() {
        int suma = 0;
        for (int fila = 0; fila < modelo.getRowCount(); fila++) {
            Object cant = vista.tblListaVender.getValueAt(fila, 3);
            suma = suma + (int) cant;
            vista.lblCantidad.setText("Cantidad de Comic: " + suma);
        }
    }

    //metodo que suma el precio total
    public double Precio() {
        double mult = 0, suma = 0;
        for (int fila = 0; fila < modelo.getRowCount(); fila++) {
            Object precio = vista.tblListaVender.getValueAt(fila, 2);
            Object cantidad = vista.tblListaVender.getValueAt(fila, 3);
            mult = (double) precio * (int) cantidad;
            suma = suma + mult;
            BigDecimal bigDecimal = new BigDecimal(suma);
            BigDecimal roundedNumber = bigDecimal.setScale(2, RoundingMode.HALF_UP);
            vista.lblCostoTotal.setText("Costo Total: S/" + roundedNumber);
        }
        return suma;
    }

    //Reiniciar cantidades
    public void reiniciar() {
        vista.lblCostoTotal.setText("Costo Total: S/");
        vista.lblCantidad.setText("Cantidad de Comic: ");
        mv.listarComic(vista.tblComic_venta);
    }

    public boolean buscaridLista(int ido) {
        int id = 0;
        for (int fila = 0; fila < vista.tblListaVender.getRowCount(); fila++) {
            id = (int) vista.tblListaVender.getValueAt(fila, 0);
            if (ido == id) {
                return true;
            }
        }
        return false;
    }

    //Metodo que elimina el resaltado del Boton
    void EliminarResaltado(JInternalFrame iframe) {
        vista.btnActualizar.setFocusPainted(false);
        vista.btnAgregar.setFocusPainted(false);
        vista.btnEditar.setFocusPainted(false);
        vista.btnEliminar.setFocusPainted(false);
        vista.btnVaciar.setFocusPainted(false);
        vista.btnVender.setFocusPainted(false);
        //vista.btnResumen.setFocusCycleRoot(false);
    }

}
