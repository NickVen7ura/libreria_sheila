package Controlador;

import Vista.*;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

public class ControladorBienvenida implements MouseListener{
    vistaBienvenida vista;
    public ControladorBienvenida(vistaBienvenida view){
        this.vista=view;
        vista.jbtnIngresar.addMouseListener(this);
        vista.jlblCerrar.addMouseListener(this);
        vista.jlblMinimizar.addMouseListener(this);
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()==vista.jlblCerrar) {
            System.exit(0);
        }
        if (e.getSource()==vista.jlblMinimizar) {
            vista.setExtendedState(JFrame.ICONIFIED);
        }
        if (e.getSource()==vista.jbtnIngresar) {
            vistaLogin vl=new vistaLogin();
            ControladorLogin cl=new ControladorLogin(vl);
            vista.dispose();
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
        if (e.getSource()==vista.jbtnIngresar) {
            vista.jbtnIngresar.setBackground(new Color(189, 193, 189));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource()==vista.jbtnIngresar) {
            vista.jbtnIngresar.setBackground(new Color(240, 244, 239));
        }
    }
    
}
