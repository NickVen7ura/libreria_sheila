package Controlador;

import DAO.*;
import Modelo.Trabajadores;
import Vista.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class ControladorTrabajadores implements ActionListener {

    vistaTrabajadores vista;
    DefaultTableModel model;
    static DAOtrabajadores daotra = new DAOtrabajadores();
    static List<Trabajadores> listtra = daotra.ListarTrabajadores();

    public ControladorTrabajadores(vistaTrabajadores view) {
        this.vista = view;
        vista.btnAgregar_Tra.addActionListener(this);
        vista.btnEliminar_Tra.addActionListener(this);
        vista.btnActualizar_Tra.addActionListener(this);
        vista.btnEditar_Tra.addActionListener(this);
        vista.txtId_Tra.setEnabled(false);
        vista.btnActualizar_Tra.setEnabled(false);
        MostrarTabla(vista.tblTrabajadores);
        EliminarResaltado(vista);
    }

    public static Trabajadores CapturarDatos(vistaTrabajadores vt) {
        String nombre = vt.txtNombre_trabajadores.getText();
        String apellido = vt.txtApellidos_trabajadores.getText();
        String telefono = vt.txtTelefono_trabajadores.getText();
        String email = vt.txtEmail_trabajadores.getText();
        String dni = vt.txtDni_trabajadores.getText();
        String username = vt.txtUsername_trabajadores.getText();

        if (nombre.isEmpty() || apellido.isEmpty() || telefono.isEmpty() || email.isEmpty()
                || dni.isEmpty() || username.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Complete los datos faltantes");
            return null;
        } else if (verificarEntero(dni)&&verificarEntero(telefono)) {
            int dniint = Integer.parseInt(dni);

            Trabajadores tra = new Trabajadores();
            tra.setNombre(nombre);
            tra.setApellido(apellido);
            tra.setTelefono(telefono);
            tra.setEmail(email);
            tra.setDni(dniint);
            tra.setUsername(username);
            return tra;
        } else {
            JOptionPane.showMessageDialog(null, "No se aceptan caracteres en los campos DNI o telefono");
            return null;
        }
    }

    public void LimpiarEntradas(vistaTrabajadores vt) {
        vt.txtNombre_trabajadores.setText("");
        vt.txtApellidos_trabajadores.setText("");
        vt.txtTelefono_trabajadores.setText("");
        vt.txtEmail_trabajadores.setText("");
        vt.txtDni_trabajadores.setText("");
        vt.txtUsername_trabajadores.setText("");
        vt.txtId_Tra.setText("");
    }

    public void MostrarTabla(JTable tabla) {
        DAOtrabajadores daoedit = new DAOtrabajadores();
        List<Trabajadores> listtra = daoedit.ListarTrabajadores();
        String titulos[] = {"ID", "NOMBRE", "APELLIDO", "TELEFONO", "EMAIL", "DNI", "USERNAME",};
        model = new DefaultTableModel(null, titulos);
        //DefaultTableModel modelo = new DefaultTableModel(null,titulos);
        //tabla.setModel(modelo);
        //for(int i=0; i<listaedit.size();i++){
        //modelo.addRow(listaedit.get(i).ListaTrabajdores());
        //}
        tabla.setModel(model);
        for (int i = 0; i < listtra.size(); i++) {
            model.addRow(listtra.get(i).ListaTrabajdores());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnAgregar_Tra) {
            Trabajadores tra = CapturarDatos(vista);
            if (tra != null) {
                daotra.CrearT(tra);
                LimpiarEntradas(vista);
                MostrarTabla(vista.tblTrabajadores);
            }
        }
        if (e.getSource() == vista.btnEliminar_Tra) {
            int fila = vista.tblTrabajadores.getSelectedRow();
            if (fila != -1) {
                int idtrab = (int) model.getValueAt(fila, 0);
                daotra.EliminarT(idtrab);
                LimpiarEntradas(vista);
                MostrarTabla(vista.tblTrabajadores);
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");

            }
        }
        if (e.getSource() == vista.btnEditar_Tra) {
            int fila = vista.tblTrabajadores.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
            } else {
                vista.btnActualizar_Tra.setEnabled(true);
                int id = Integer.parseInt(vista.tblTrabajadores.getValueAt(fila, 0).toString());
                String nom = (String) vista.tblTrabajadores.getValueAt(fila, 1);
                String ape = (String) vista.tblTrabajadores.getValueAt(fila, 2);
                //String pais = (String) vista.tblTrabajadores.getValueAt(fila, 2);
                String email = (String) vista.tblTrabajadores.getValueAt(fila, 4);
                String tele = (String) vista.tblTrabajadores.getValueAt(fila, 3);
                int dni = Integer.parseInt(vista.tblTrabajadores.getValueAt(fila, 5).toString());
                String username = (String) vista.tblTrabajadores.getValueAt(fila, 6);

                vista.txtId_Tra.setText(String.valueOf(id));
                vista.txtApellidos_trabajadores.setText(ape);
                vista.txtNombre_trabajadores.setText(nom);
                vista.txtEmail_trabajadores.setText(email);
                vista.txtTelefono_trabajadores.setText(tele);
                vista.txtUsername_trabajadores.setText(username);
                vista.txtDni_trabajadores.setText(String.valueOf(dni));
            }
        }
        if (e.getSource() == vista.btnActualizar_Tra) {
            Trabajadores tra = new Trabajadores();
            tra.setTrabajador_id(Integer.parseInt(vista.txtId_Tra.getText()));
            tra.setApellido(vista.txtApellidos_trabajadores.getText());
            tra.setEmail(vista.txtEmail_trabajadores.getText());
            tra.setNombre(vista.txtNombre_trabajadores.getText());
            tra.setUsername(vista.txtUsername_trabajadores.getText());
            tra.setTelefono(vista.txtTelefono_trabajadores.getText());
            tra.setDni(Integer.parseInt(vista.txtDni_trabajadores.getText()));
            actualizar(tra);

        }
    }

    static boolean verificarEntero(String dato) {
        try {
            Integer.parseInt(dato);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //Metodo que elimina el resaltado del Boton
    void EliminarResaltado(JInternalFrame iframe) {
        vista.btnActualizar_Tra.setFocusPainted(false);
        vista.btnAgregar_Tra.setFocusPainted(false);
        vista.btnEliminar_Tra.setFocusPainted(false);
    }

    void actualizar(Trabajadores tra) {
        DAOtrabajadores daotra = new DAOtrabajadores();
        daotra.ActualizarT(tra);
        LimpiarEntradas(vista);
        MostrarTabla(vista.tblTrabajadores);
        vista.btnActualizar_Tra.setEnabled(false);

    }
    
}
