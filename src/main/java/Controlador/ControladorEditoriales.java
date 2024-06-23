package Controlador;

import DAO.*;
import Modelo.Editoriales;
import Vista.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;


public class ControladorEditoriales implements ActionListener{
    
    vistaEditoriales vista;   
    DefaultTableModel model;
    static DAOeditoriales daoedit =  new DAOeditoriales();
    static List<Editoriales>  listedit =  daoedit.ListarEditoriales();
 
    public ControladorEditoriales(vistaEditoriales view){
        this.vista=view;
        vista.btnAgregar_Edit.addActionListener(this);
        vista.btnEliminar_Edit.addActionListener(this);
        vista.btnActualizar_Edit.addActionListener(this);
        this.vista.btnEditar_Edit.addActionListener(this);
        vista.txtId_editorial.setEnabled(false);
        vista.btnActualizar_Edit.setEnabled(false);
        MostrarTabla(vista.tblEditoriales);
        EliminarResaltado(vista);
    }
    public static Editoriales CapturarDatos(vistaEditoriales ve){    
        
        String nombre = ve.txtNombre_editorial.getText();
        String pais = ve.txtPais_editorial.getText();
        String telefono = ve.txtTelefono_editorial.getText();
        String email = ve.txtEmail_editorial.getText();
        String año = ve.txtAño_editorial.getText();

        if (nombre.isEmpty() || pais.isEmpty() || telefono.isEmpty() || email.isEmpty()
                || año.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Complete los datos faltantes");
            return null;
        } else if (verificarEntero(año)&&verificarEntero(telefono)) {
            Editoriales edi = new Editoriales();
            edi.setNombre(nombre);
            edi.setPais(pais);
            edi.setTelefono(Integer.parseInt(telefono));
            edi.setEmail(email); 
            edi.setAño_fundacion(Integer.parseInt(año));
            return edi;
        } else {
            JOptionPane.showMessageDialog(null, "No se aceptan caracteres en los campos Año o telefono");
            return null;
        }
    }
    
    public void LimpiarEntradas(vistaEditoriales ve) {  
        ve.txtId_editorial.setText("");
        ve.txtNombre_editorial.setText("");
        ve.txtPais_editorial.setText("");
        ve.txtTelefono_editorial.setText("");
        ve.txtEmail_editorial.setText("");
        ve.txtAño_editorial.setText("");
    }
    public void MostrarTabla(JTable tabla) {
        DAOeditoriales daoedit =  new DAOeditoriales();
        List<Editoriales>  listaedit =  daoedit.ListarEditoriales();
        String titulos[]={"ID","NOMBRE","PAIS","AÑO"};
        model = new DefaultTableModel(null,titulos);
        tabla.setModel(model);
        for(int i=0; i<listaedit.size();i++){
            model.addRow(listaedit.get(i).ListaEditoriales());
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.btnAgregar_Edit) {
            Editoriales edi = CapturarDatos(vista);
             if (edi != null) {
             daoedit.Crear(edi);
            LimpiarEntradas(vista);
            MostrarTabla(vista.tblEditoriales);
             }
        }
        if(e.getSource()==vista.btnEliminar_Edit) {
            int fila= vista.tblEditoriales.getSelectedRow();
            if(fila!=-1) {
                int idtrab = (int) model.getValueAt(fila, 0);
                daoedit.Eliminar(idtrab);
                LimpiarEntradas(vista);
                MostrarTabla(vista.tblEditoriales);
            }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
            
            }
        }
        if (e.getSource() == vista.btnEditar_Edit) {
            int fila = vista.tblEditoriales.getSelectedRow();
            if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
            } else {
                vista.btnActualizar_Edit.setEnabled(true);
                int id = Integer.parseInt(vista.tblEditoriales.getValueAt(fila, 0).toString());
                String nom = (String) vista.tblEditoriales.getValueAt(fila, 1);
                String pais = (String) vista.tblEditoriales.getValueAt(fila, 2);
                String email = (String) vista.tblEditoriales.getValueAt(fila, 4);
                int tele = Integer.parseInt(vista.tblEditoriales.getValueAt(fila, 3).toString());
                int year = Integer.parseInt(vista.tblEditoriales.getValueAt(fila, 5).toString());
                vista.txtId_editorial.setText(String.valueOf(id));
                vista.txtNombre_editorial.setText(nom);
                vista.txtPais_editorial.setText(pais);
                vista.txtEmail_editorial.setText(email);
                vista.txtTelefono_editorial.setText(String.valueOf(tele));
                vista.txtAño_editorial.setText(String.valueOf(year));
            }
        }
        if (e.getSource()==vista.btnActualizar_Edit) {
            Editoriales edi=new Editoriales();
            edi.setAño_fundacion(Integer.parseInt(vista.txtAño_editorial.getText()));
            edi.setEditorial_id(Integer.parseInt(vista.txtId_editorial.getText()));
            edi.setEmail(vista.txtEmail_editorial.getText());
            edi.setNombre(vista.txtNombre_editorial.getText());
            edi.setPais(vista.txtPais_editorial.getText());
            edi.setTelefono(Integer.parseInt(vista.txtTelefono_editorial.getText()));
            actualizar(edi);
        }
}
        
       
    //Metodo que elimina el resaltado del Boton
    void EliminarResaltado(JInternalFrame iframe) {
        vista.btnEditar_Edit.setFocusPainted(false);
        vista.btnAgregar_Edit.setFocusPainted(false);
        vista.btnEliminar_Edit.setFocusPainted(false);
    }
    void actualizar(Editoriales edi){
            DAOeditoriales daoedit =  new DAOeditoriales();
            daoedit.Actualizar(edi);
            LimpiarEntradas(vista);
            MostrarTabla(vista.tblEditoriales);
            vista.btnActualizar_Edit.setEnabled(false);

    }
    static boolean verificarEntero(String dato) {
        try {
            Integer.parseInt(dato);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}//Final