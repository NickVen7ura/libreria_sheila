package Controlador;

import Modelo.Trabajadores;
import Vista.*;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class ControladorHerramienta implements MouseListener{
    vistaHerramienta vista;
    public ControladorHerramienta(vistaHerramienta view,Trabajadores tra){
        this.vista=view;
        vista.lblApellidos.setText(tra.getApellido());
        vista.lblNombres.setText(tra.getNombre());
        vista.lblDNI.setText("DNI:"+String.valueOf(tra.getDni()));
        //FALTARIA DARLE FORMATO DE IMAGEN
        //vista.setIconImage(tra.getFotografia());
        vista.lblCerrar.addMouseListener(this);
        vista.lblMinimizar.addMouseListener(this);
        vista.btnVentas.addMouseListener(this);
        vista.btnEditoriales.addMouseListener(this);
        vista.btnInventario.addMouseListener(this);
        vista.btnHistorial.addMouseListener(this);
        vista.btnTrabajadores.addMouseListener(this);
        vista.btnCerrarSesion.addMouseListener(this);
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()==vista.lblCerrar) {
            System.exit(0);
        }
        if (e.getSource()==vista.lblMinimizar) {
            vista.setExtendedState(JFrame.ICONIFIED);
        }
        if (e.getSource()==vista.btnVentas) {
            vista.btnVentas.setBackground(new Color(0, 51, 102));
            vista.btnInventario.setBackground(new Color(39, 107, 162));
            vista.btnEditoriales.setBackground(new Color(39, 107, 162));
            vista.btnTrabajadores.setBackground(new Color(39, 107, 162));
            vista.btnHistorial.setBackground(new Color(39, 107, 162));

            vistaVenta vv=new vistaVenta();
            ControladorVentas cv=new ControladorVentas(vv);
            MostrarInternal(vv);
        }
        if (e.getSource()==vista.btnInventario) {
            vista.btnInventario.setBackground(new Color(0, 51, 102));
            vista.btnVentas.setBackground(new Color(39, 107, 162));
            vista.btnEditoriales.setBackground(new Color(39, 107, 162));
            vista.btnTrabajadores.setBackground(new Color(39, 107, 162));
            vista.btnHistorial.setBackground(new Color(39, 107, 162));
            vistaInventario vi=new vistaInventario();
            ControladorInventario cv=new ControladorInventario(vi);
            MostrarInternal(vi);
        }
        if (e.getSource()==vista.btnHistorial) {
            vista.btnHistorial.setBackground(new Color(0, 51, 102));
            vista.btnInventario.setBackground(new Color(39, 107, 162));
            vista.btnVentas.setBackground(new Color(39, 107, 162));
            vista.btnTrabajadores.setBackground(new Color(39, 107, 162));
            vista.btnEditoriales.setBackground(new Color(39, 107, 162));
            vistaHistorial_Venta vh=new vistaHistorial_Venta();
            ControladorHistorial_Venta ch=new ControladorHistorial_Venta(vh);
            MostrarInternal(vh);
        }
        if (e.getSource()==vista.btnTrabajadores) {
            vista.btnTrabajadores.setBackground(new Color(0, 51, 102));
            vista.btnInventario.setBackground(new Color(39, 107, 162));
            vista.btnVentas.setBackground(new Color(39, 107, 162));
            vista.btnEditoriales.setBackground(new Color(39, 107, 162));
            vista.btnHistorial.setBackground(new Color(39, 107, 162));
            vistaTrabajadores vt=new vistaTrabajadores();
            ControladorTrabajadores ct=new ControladorTrabajadores(vt);
            MostrarInternal(vt);
            
        }
        if (e.getSource()==vista.btnEditoriales) {
            vista.btnEditoriales.setBackground(new Color(0, 51, 102));
            vista.btnInventario.setBackground(new Color(39, 107, 162));
            vista.btnVentas.setBackground(new Color(39, 107, 162));
            vista.btnTrabajadores.setBackground(new Color(39, 107, 162));
            vista.btnHistorial.setBackground(new Color(39, 107, 162));
            vistaEditoriales ve=new vistaEditoriales();
            ControladorEditoriales ce=new ControladorEditoriales(ve);
            MostrarInternal(ve);
        }
        if (e.getSource()==vista.btnCerrarSesion) {
            int resp=JOptionPane.showConfirmDialog(null, "¿Desea Cerrar Sesión?", "Cerrar Sesión", JOptionPane.OK_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
            if (resp==0) {
                vistaBienvenida vb=new vistaBienvenida();
                ControladorBienvenida cb=new ControladorBienvenida(vb);
                vista.dispose();
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
        if (e.getSource()==vista.btnCerrarSesion) {
            vista.btnCerrarSesion.setBackground(new Color(184, 0, 0));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {/*
        if (e.getSource() == vista.btnVentas) {
            vista.btnVentas.setBackground(new Color(224, 0, 0));
        }
        if (e.getSource() == vista.bntHistorial) {
            vista.bntHistorial.setBackground(new Color(224, 0, 0));
        }
        if (e.getSource() == vista.btnEditoriales) {
            vista.btnEditoriales.setBackground(new Color(224, 0, 0));
        }
        if (e.getSource() == vista.btnTrabajadores) {
            vista.btnTrabajadores.setBackground(new Color(224, 0, 0));
        }
        if (e.getSource() == vista.btnInventario) {
            vista.btnInventario.setBackground(new Color(224, 0, 0));
        }
        if (e.getSource()==vista.btnCerrarSesion) {
            vista.btnCerrarSesion.setBackground(new Color(224, 0, 0));
        }*/
    }
    void quitar(){
        
    }
    //Metodo para mostrar los JInternal en los desktop
    void MostrarInternal(JInternalFrame iframe){
        vista.jdpEscritorio.removeAll();
        vista.jdpEscritorio.repaint();
        removerDecorado(iframe);
        vista.jdpEscritorio.add(iframe);
        iframe.setVisible(true);
    }
    //Metodo para eliminar el decorado del JInternalFrame
    void removerDecorado(JInternalFrame internalFrame) {
        BasicInternalFrameUI ui = (BasicInternalFrameUI) internalFrame.getUI();
        ui.setNorthPane(null);
    }
    void darInfo(){
        
    }
    
}
