package Controlador;

import Vista.*;
import DAO.*;
import Modelo.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ControladorLogin implements MouseListener {
    vistaLogin vista;
    MysqLoginDAO dl;
    public ControladorLogin(vistaLogin view){
        this.vista=view;
        dl=new MysqLoginDAO();
        vista.btnIngresar.addMouseListener(this);
        vista.btnCerr.addMouseListener(this);
        vista.btnMin.addMouseListener(this);
        vista.btnIngresar.setFocusPainted(false);
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()==vista.btnCerr) {
            System.exit(0);
        }
        if (e.getSource()==vista.btnMin) {
            vista.setExtendedState(JFrame.ICONIFIED);
        }
        if (e.getSource()==vista.btnIngresar) {
            String user=vista.txtUser.getText();
            String pass=vista.txtPass.getText();
          
            Trabajadores tra=dl.verificarCuenta(user, pass);
            if (user.isEmpty()||pass.isEmpty()) {
                vista.lblError.setText("Rellene los campos faltantes!!");
            }else if(tra==null){
                vista.lblError.setText("Credenciales Inválidas");
            }else{
                vista.lblError.setText("");
                JOptionPane.showMessageDialog(null, "Bienvenido al sistema", 
                        "Inicio exitoso", JOptionPane.INFORMATION_MESSAGE);
                vistaHerramienta vb=new vistaHerramienta();
                ControladorHerramienta ch=new ControladorHerramienta(vb,tra);
                 vista.txtUser.setText("");
                 vista.txtPass.setText("");
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
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
