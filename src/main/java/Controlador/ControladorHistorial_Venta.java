package Controlador;

import DAO.*;
import Formatos.FormatoHistorialVenta;
import Vista.vistaHistorial_Venta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Formatos.FormatoRender;
import Formatos.FormatoVenta;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;

public class ControladorHistorial_Venta implements ActionListener, MouseListener {

    vistaHistorial_Venta vista;
    MysqlHistorialVentaDAO mh;
    JButton btn = new JButton("Abrir");
    static int columna, fila;

    public ControladorHistorial_Venta(vistaHistorial_Venta view) {
        this.vista = view;
        vista.btnBuscar.addActionListener(this);
        vista.btnMostrarTodo.addActionListener(this);
        vista.btnFiltrar.addActionListener(this);
        vista.btnOrdenar.addActionListener(this);
        vista.tblHistorial.addMouseListener(this);
        EliminarResaltado(vista);
        mh = new MysqlHistorialVentaDAO();
        FormatoHistorialVenta.EstiloTabla(vista.tblHistorial);
        btn.setBackground(new Color(180, 205, 237));
        btn.setForeground(Color.BLACK);
        vista.tblHistorial.setRowHeight(40);
        TableColumn col = vista.tblHistorial.getColumn("Visualizar");
        col.setPreferredWidth(50);
        vista.tblHistorial.setDefaultRenderer(Object.class, new FormatoRender());
        mh.listarHistorialVent(vista.tblHistorial, btn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnBuscar) {
            String dato = vista.txfIngresoID.getText();
            if (dato.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe colocar un ID");

            }else if(verificarEntero(dato)){

                int id = Integer.parseInt(vista.txfIngresoID.getText());
                mh.listarHistorialxID(vista.tblHistorial, btn, id);
                FormatoHistorialVenta.LimpiarCampos(vista);
            }else{
              JOptionPane.showMessageDialog(null, "No se aceptan caracteres en el campo");

            }
        }
        if (e.getSource() == vista.btnMostrarTodo) {
            mh.listarHistorialVent(vista.tblHistorial, btn);
            FormatoHistorialVenta.LimpiarCampos(vista);
        }
        if (e.getSource() == vista.btnFiltrar) {
            String filtro = vista.cbxFiltrar.getSelectedItem().toString();

            if (filtro.equals("Mayor a 150")) {
                mh.filtrarxmontomayor(vista.tblHistorial, btn);
            } else if (filtro.equals("De esta semana")) {
                mh.filtrarventasemana(vista.tblHistorial, btn);
            } else if (filtro.equals("Menos a 100")) {
                mh.filtrarxmontomenor(vista.tblHistorial, btn);
            } else if (filtro.equals("Selecciona")) {
                JOptionPane.showMessageDialog(null, "SELECCIONE UNA OPCIÓN");
            }
            FormatoHistorialVenta.LimpiarCampos(vista);
        }
        if (e.getSource() == vista.btnOrdenar) {
            String filtro = vista.cbxOrdenar.getSelectedItem().toString();

            if (filtro.equals("Monto de Menor a Mayor")) {
                mh.ordenarMontomenormayor(vista.tblHistorial, btn);
            } else if (filtro.equals("Monto de Mayor a Menor")) {
                mh.ordenarMontomayormenor(vista.tblHistorial, btn);
            } else if (filtro.equals("Fecha de Menor a Mayor")) {
                mh.ordenarFechamenormayor(vista.tblHistorial, btn);
            } else if (filtro.equals("Fecha de Mayor a Menor")) {
                mh.ordenarMontomayormenor(vista.tblHistorial, btn);
            } else if (filtro.equals("Selecciona")) {
                JOptionPane.showMessageDialog(null, "SELECCIONE UNA OPCIÓN");
            }
            FormatoHistorialVenta.LimpiarCampos(vista);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int fila = vista.tblHistorial.rowAtPoint(e.getPoint());
        int columna = vista.tblHistorial.columnAtPoint(e.getPoint());
        // Verificar si el clic fue en una celda
        if (fila >= 0 && columna >= 0) {
            Object valor = vista.tblHistorial.getValueAt(fila, columna);
            // verificar si el valor es un boton
            if (valor instanceof JButton) {
                JButton botonCelda = (JButton) valor;
                //al dar click 
                if (e.getClickCount() == 1) {
                    Object id = vista.tblHistorial.getValueAt(fila, 0);
                    String nombre = "factura" + id + ".pdf";
                    boolean resultado = buscarPDF(nombre);
                    if (resultado == true) {
                        try {
                            String ruta = System.getProperty("user.dir");
                            String carpetaPath = ruta + "/src/main/java/facturaspdf/" + nombre;
                            Desktop desktop = Desktop.getDesktop();
                            desktop.open(new File(carpetaPath));
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        int res = JOptionPane.showConfirmDialog(null, "¿Desea generar la factura?", "La factura no existe", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                        if (res == 0) {
                            MysqlVentasDAO mv = new MysqlVentasDAO();
                            FormatoVenta.generarPdf((int) id, mv);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    boolean buscarPDF(String nombre) {
        String ruta = System.getProperty("user.dir");
        String carpetaPath = ruta + "/src/main/java/facturaspdf";
        File carpeta = new File(carpetaPath);
        File archivos[] = carpeta.listFiles();
        for (File archivoactual : archivos) {
            if (archivoactual.isFile() && archivoactual.getName().equals(nombre)) {

                return true;
            }
        }
        return false;
    }

    //Metodo que elimina el resaltado del Boton
    void EliminarResaltado(JInternalFrame iframe) {
        vista.btnBuscar.setFocusPainted(false);
        vista.btnFiltrar.setFocusPainted(false);
        vista.btnMostrarTodo.setFocusPainted(false);
        vista.btnOrdenar.setFocusPainted(false);
    }
    static boolean verificarEntero(String dato) {
        try {
            Integer.parseInt(dato);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
