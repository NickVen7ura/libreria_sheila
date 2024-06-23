package Modelo;

import java.sql.Date;
import javax.swing.JButton;

public class Venta {
    private int venta_id;
    private Date fechaVenta;
    private double monto;

    public int getVenta_id() {
        return venta_id;
    }

    public void setVenta_id(int venta_id) {
        this.venta_id = venta_id;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    public Object[] Listar(JButton btn){
        Object listar[]={venta_id,fechaVenta,monto,btn};
        return listar;
    }
    
}
