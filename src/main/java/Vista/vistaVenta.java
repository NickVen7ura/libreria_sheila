/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista;

/**
 *
 * @author Frank
 */
public class vistaVenta extends javax.swing.JInternalFrame {

    /**
     * Creates new form vistaVenta
     */
    public vistaVenta() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        redondear1 = new Modelo.Redondear();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblComic_venta = new javax.swing.JTable();
        lblBuscar = new javax.swing.JLabel();
        redondear2 = new Modelo.Redondear();
        jLabel2 = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        lblCostoTotal = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblListaVender = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnVaciar = new javax.swing.JButton();
        btnVender = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        spnCantidad2 = new javax.swing.JSpinner();
        btnActualizar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        redondear3 = new Modelo.Redondear();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        txfNombreBuscar = new javax.swing.JTextField();
        spnCantidad = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();

        setBorder(null);
        setClosable(true);
        setPreferredSize(new java.awt.Dimension(870, 580));

        redondear1.setBackground(new java.awt.Color(27, 114, 159));
        redondear1.setRoundBottomLeft(60);
        redondear1.setRoundBottomRight(60);
        redondear1.setRoundTopLeft(60);
        redondear1.setRoundTopRight(60);
        redondear1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Nirmala UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(218, 150, 25));
        jLabel1.setText("Ventas");
        redondear1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, -1, -1));

        tblComic_venta.setBackground(new java.awt.Color(240, 244, 239));
        tblComic_venta.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        tblComic_venta.setForeground(new java.awt.Color(51, 51, 51));
        tblComic_venta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "EDITORIAL", "SERIE", "EDICIÓN", "CANTIDAD", "PRECIO"
            }
        ));
        jScrollPane1.setViewportView(tblComic_venta);

        redondear1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 370, 380));
        redondear1.add(lblBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        redondear2.setBackground(new java.awt.Color(247, 210, 129));
        redondear2.setRoundBottomLeft(60);
        redondear2.setRoundBottomRight(60);
        redondear2.setRoundTopLeft(60);
        redondear2.setRoundTopRight(60);
        redondear2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Nirmala UI", 0, 24)); // NOI18N
        jLabel2.setText("Comics Seleccionados");
        redondear2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        lblCantidad.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        lblCantidad.setText("Cantidad de Comic:");
        redondear2.add(lblCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 240, -1));

        lblCostoTotal.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        lblCostoTotal.setText("Costo Total:");
        redondear2.add(lblCostoTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 250, 20));

        tblListaVender.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        tblListaVender.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Comic", "Precio", "Cantidad"
            }
        ));
        jScrollPane2.setViewportView(tblListaVender);

        redondear2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 330, 340));

        btnEliminar.setBackground(new java.awt.Color(255, 0, 51));
        btnEliminar.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/minus-sign.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        redondear2.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, 100, 30));

        btnVaciar.setBackground(new java.awt.Color(204, 0, 204));
        btnVaciar.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        btnVaciar.setForeground(new java.awt.Color(255, 255, 255));
        btnVaciar.setText("Vaciar");
        redondear2.add(btnVaciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 100, 30));

        btnVender.setBackground(new java.awt.Color(0, 153, 0));
        btnVender.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        btnVender.setForeground(new java.awt.Color(255, 255, 255));
        btnVender.setText("Vender");
        redondear2.add(btnVender, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, 100, 30));

        btnEditar.setBackground(new java.awt.Color(51, 153, 255));
        btnEditar.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("Editar");
        redondear2.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 290, 100, 30));

        spnCantidad2.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        redondear2.add(spnCantidad2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, 100, 40));

        btnActualizar.setBackground(new java.awt.Color(255, 204, 0));
        btnActualizar.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("Actualizar");
        redondear2.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(347, 380, -1, 30));

        redondear1.add(redondear2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 460, 480));
        redondear1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        redondear3.setBackground(new java.awt.Color(165, 168, 167));
        redondear3.setRoundBottomLeft(40);
        redondear3.setRoundBottomRight(40);
        redondear3.setRoundTopLeft(40);
        redondear3.setRoundTopRight(40);
        redondear3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jLabel4.setText("Nombre del Comic:");
        redondear3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, 20));

        jSeparator2.setBackground(new java.awt.Color(27, 114, 159));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        redondear3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 120, 10));

        txfNombreBuscar.setBackground(new java.awt.Color(165, 168, 167));
        txfNombreBuscar.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        txfNombreBuscar.setBorder(null);
        redondear3.add(txfNombreBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 120, 30));

        spnCantidad.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        redondear3.add(spnCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 70, 30));

        jLabel3.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jLabel3.setText("Cantidad:");
        redondear3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, 20));

        btnAgregar.setBackground(new java.awt.Color(51, 204, 0));
        btnAgregar.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        btnAgregar.setText("Agregar");
        redondear3.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 100, 30));

        redondear1.add(redondear3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 370, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(redondear1, javax.swing.GroupLayout.DEFAULT_SIZE, 871, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(redondear1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActualizar;
    public javax.swing.JButton btnAgregar;
    public javax.swing.JButton btnEditar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnVaciar;
    public javax.swing.JButton btnVender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblBuscar;
    public javax.swing.JLabel lblCantidad;
    public javax.swing.JLabel lblCostoTotal;
    private Modelo.Redondear redondear1;
    private Modelo.Redondear redondear2;
    private Modelo.Redondear redondear3;
    public javax.swing.JSpinner spnCantidad;
    public javax.swing.JSpinner spnCantidad2;
    public javax.swing.JTable tblComic_venta;
    public javax.swing.JTable tblListaVender;
    public javax.swing.JTextField txfNombreBuscar;
    // End of variables declaration//GEN-END:variables
}