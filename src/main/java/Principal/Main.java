package Principal;

import Controlador.ControladorBienvenida;
import Vista.vistaBienvenida;

public class Main {
    public static void main(String[] args) {
        vistaBienvenida vb=new vistaBienvenida();
        ControladorBienvenida cb=new ControladorBienvenida(vb);
    }
}
