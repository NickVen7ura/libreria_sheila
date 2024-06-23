package Controlador;

import DAO.*;
import Formatos.CargarComboBox_Iinventario;
import Modelo.*;
import Vista.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ControladorInventario implements ActionListener, DocumentListener {

    vistaInventario vista;
    DefaultTableModel modelo;
    DefaultTableModel modelo1;
    DefaultTableModel modelo2;
    String foto;
    static DAOinventario daoinv = new DAOinventario();
    static List<Comic> listcmc = daoinv.ListarComic();

    public ControladorInventario(vistaInventario vist) {
        this.vista = vist;
        vista.btnAgregar.addActionListener(this);
        vista.btnAgregarAutor.addActionListener(this);
        vista.btnAgregarGenero.addActionListener(this);
        vista.btnEliminarAutor.addActionListener(this);
        vista.btnEliminarGenero.addActionListener(this);
        vista.btnEliminar.addActionListener(this);
        vista.btnFoto.addActionListener(this);
        vista.btnActualizar.addActionListener(this);
        vista.btnBuscar.getDocument().addDocumentListener(this);
        CargarComboBox_Iinventario.nombreEditoriales(vista.cbxEdit);
        CargarComboBox_Iinventario.nombreAutor(vista.cbxAutor);
        CargarComboBox_Iinventario.nombreGenero(vista.cbxGenero);
        EstilotblGenero();
        EstilotblAutor();
        EliminarResaltado(vista);
        MostrarTabla(vista.tblInventario);
    }

    public static int EditorialID(String edit) {
        int editid = 0;
        if (edit.equalsIgnoreCase("MARVEL")) {
            editid = 1;
        }
        if (edit.equalsIgnoreCase("DC")) {
            editid = 2;
        }
        if (edit.equalsIgnoreCase("IDW")) {
            editid = 5;
        }
        return editid;
    }

    public static Comic CapturarDatos(vistaInventario vi,String nomb,Date fecha,String fotodex) {
        String titulo = vi.txtSer.getText();
        String num_pag = vi.spnNum.getValue().toString();
        String sipnosis = vi.txaSipnosis.getText();
        String ubicacion = vi.txtUbi.getText();
        String ejemplares = vi.spnSto.getValue().toString();
        String precio = vi.txtPre.getText();
        String titulos = vi.txtSer.getText();
        String clasi = vi.cbxRes.getSelectedItem().toString();
        String format = vi.cbxFor.getSelectedItem().toString();

        if (fotodex.isEmpty() || titulo.isEmpty() || num_pag.isEmpty() || sipnosis.isEmpty()
                || ubicacion.isEmpty() || ejemplares.isEmpty() || precio.isEmpty() || titulos.isEmpty()
                || nomb.isEmpty() || fecha == null || fecha.toString().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Complete los datos faltantes");
            return null;
        } else if (verificarEntero(num_pag) && verificarEntero(ejemplares) && verificarDouble(precio)) {
            Comic cmc = new Comic();
            int id = 0;
            for (Editoriales edit : CargarComboBox_Iinventario.edit) {
                if (nomb.equals(edit.getNombre())) {
                    id = edit.getEditorial_id();
                    break;
                }
            }
            cmc.setEditorial_id(id);
            cmc.setFotografia(fotodex);
            cmc.setTitulo(titulo);
            cmc.setNum_pagina(Integer.parseInt(num_pag));
            cmc.setSipnosis(sipnosis);
            cmc.setFormato(format);
            cmc.setFecha_edicion((java.sql.Date) fecha);
            cmc.setCosto(Double.parseDouble(precio));
            cmc.setUbicacion_estante(ubicacion);
            cmc.setEjemplares(Integer.parseInt(ejemplares));
            cmc.setClasificacion(clasi);
            return cmc;
        } else {
            JOptionPane.showMessageDialog(null, "Corrija los campos necesarios");
            return null;
        }

    }

    public void LimpiarEntradas(vistaInventario vi) {
        vi.cbxEdit.setSelectedItem(0);
        vi.txtSer.setText("");
        vi.txtUbi.setText("");
        vi.cbxRes.setSelectedItem(0);
        vi.cbxFor.setSelectedItem(0);
        vi.spnNum.setValue(0);
        vi.spnSto.setValue(0);
        vi.txtPre.setText("");
    }

    public void MostrarTabla(JTable tabla) {
        DAOinventario daoinv = new DAOinventario();
        List<Comic> listcmc = daoinv.ListarComic();
        String titulos[] = {"ID", "EDITORIAL", "TITULO", "UBICACION", "RESTRICCION", "FORMATO", "NUMERO PAG", "STOCK", "PRECIO"};
        modelo = new DefaultTableModel(null, titulos);
        tabla.setModel(modelo);
        for (int i = 0; i < listcmc.size(); i++) {
            modelo.addRow(listcmc.get(i).ListaInventario());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnAgregar) {
        String nomb = vista.cbxEdit.getSelectedItem().toString();
        Date fechaUtil = vista.dateChooser.getDate();
        java.sql.Date fecha = new java.sql.Date(fechaUtil.getTime());

        String fotoedex = foto;
          if (nomb == null || nomb.trim().isEmpty() || fechaUtil == null || fotoedex == null || fotoedex.trim().isEmpty()) {
              JOptionPane.showMessageDialog(null, "Completa");
          }else{
            Comic cmc = CapturarDatos(vista,nomb,fecha,fotoedex);
            if (cmc != null) {
                daoinv.Crear(cmc, modelo1, modelo2);
                LimpiarEntradas(vista);
                MostrarTabla(vista.tblInventario);
            }
          }
        }
        if (e.getSource() == vista.btnEliminar) {
            int fila = vista.tblInventario.getSelectedRow();
            if (fila != -1) {
                int idcmc = (int) modelo.getValueAt(fila, 0);
                daoinv.Eliminar(idcmc);
                LimpiarEntradas(vista);
                MostrarTabla(vista.tblInventario);
                vista.btnBuscar.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
            }
        }
        if (e.getSource() == vista.btnActualizar) {
            int fila = vista.tblInventario.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
            } else {
                vista.tblInventario.getValueAt(fila, 0);
            }

        }
        if (e.getSource() == vista.btnAgregarAutor) {
            Object apellido = (Object) vista.cbxAutor.getSelectedItem().toString();
            Object id = 0;
            for (Autor autor : CargarComboBox_Iinventario.autores) {
                if (apellido.equals(autor.getApellido())) {
                    id = (Object) autor.getAutor_id();
                    break;
                }
            }
            Object data[] = {id, apellido};
            modelo1.addRow(data);
        }
        if (e.getSource() == vista.btnAgregarGenero) {
            Object nombre = (Object) vista.cbxGenero.getSelectedItem().toString();
            Object id = 0;
            for (Genero gen : CargarComboBox_Iinventario.gen) {
                if (nombre.equals(gen.getNombre())) {
                    id = (Object) gen.getGenero_id();
                    break;
                }
            }
            Object data[] = {id, nombre};
            modelo2.addRow(data);
        }
        if (e.getSource() == vista.btnFoto) {

            JFileChooser img = new JFileChooser();
            img.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int result = img.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = img.getSelectedFile();
                String imagePath = selectedFile.getAbsolutePath();
                foto = imagePath;
            }
        }
        if (e.getSource() == vista.btnEliminarAutor) {
            int fila = vista.tblAutores.getSelectedRow();
            if (fila != -1) {
                modelo1.removeRow(fila);
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
            }
        }
        if (e.getSource() == vista.btnEliminarGenero) {
            int fila = vista.tblGeneros.getSelectedRow();
            if (fila != -1) {
                modelo2.removeRow(fila);
            } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
        }
        
        }
    }

//Metodo que elimina el resaltado del Boton
    void EliminarResaltado(JInternalFrame iframe) {
        vista.btnActualizar.setFocusPainted(false);
        vista.btnAgregar.setFocusPainted(false);
        vista.btnEliminar.setFocusPainted(false);
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

    void LeerInput() {
        String dato = vista.btnBuscar.getText();
        DAOinventario daoinv = new DAOinventario();
        daoinv.listaComicxNombre(dato, vista.tblInventario);
    }

    void EstilotblAutor() {
        String Titulos[] = {"ID", "Apellido"};
        modelo1 = new DefaultTableModel(null, Titulos);
        vista.tblAutores.setModel(modelo1);
    }

    void EstilotblGenero() {
        String Titulos[] = {"ID", "Nombre"};
        modelo2 = new DefaultTableModel(null, Titulos);
        vista.tblGeneros.setModel(modelo2);
    }

    static boolean verificarEntero(String dato) {
        try {
            Integer.parseInt(dato);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    static boolean verificarDouble(String dato) {
        try {
            Double.parseDouble(dato);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
