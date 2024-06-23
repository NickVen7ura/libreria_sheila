package Vista;

public class vistaHistorial_Venta extends javax.swing.JInternalFrame {

    public vistaHistorial_Venta() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        redondear1 = new Modelo.Redondear();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHistorial = new javax.swing.JTable();
        cbxOrdenar = new javax.swing.JComboBox<>();
        btnFiltrar = new javax.swing.JButton();
        cbxFiltrar = new javax.swing.JComboBox<>();
        btnOrdenar = new javax.swing.JButton();
        btnMostrarTodo = new javax.swing.JButton();
        txfIngresoID = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setBorder(null);
        setClosable(true);
        setPreferredSize(new java.awt.Dimension(796, 580));

        redondear1.setBackground(new java.awt.Color(27, 114, 159));
        redondear1.setRoundBottomLeft(60);
        redondear1.setRoundBottomRight(60);
        redondear1.setRoundTopLeft(60);
        redondear1.setRoundTopRight(60);
        redondear1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Nirmala UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(218, 150, 25));
        jLabel1.setText("Historial de Ventas");
        redondear1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));

        tblHistorial.setBackground(new java.awt.Color(240, 244, 239));
        tblHistorial.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        tblHistorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID VENTA", "PRODUCTO", "CANTIDAD", "PRECIO UNITARIO", "FECHA", "HORA"
            }
        ));
        jScrollPane1.setViewportView(tblHistorial);

        redondear1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 450, 400));

        cbxOrdenar.setBackground(new java.awt.Color(240, 244, 239));
        cbxOrdenar.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        cbxOrdenar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona", "Monto de Menor a Mayor", "Monto de Mayor a Menor", "Fecha de Menor a Mayor", "Fecha de Mayor a Menor" }));
        cbxOrdenar.setBorder(null);
        redondear1.add(cbxOrdenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 320, 210, 50));

        btnFiltrar.setBackground(new java.awt.Color(0, 153, 255));
        btnFiltrar.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        btnFiltrar.setForeground(new java.awt.Color(255, 255, 255));
        btnFiltrar.setText("Filtrar");
        redondear1.add(btnFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 230, 100, 40));

        cbxFiltrar.setBackground(new java.awt.Color(240, 244, 239));
        cbxFiltrar.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        cbxFiltrar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona", "Mayor a 150", "De esta semana", "Menos a 100" }));
        cbxFiltrar.setBorder(null);
        redondear1.add(cbxFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, 130, 50));

        btnOrdenar.setBackground(new java.awt.Color(0, 204, 102));
        btnOrdenar.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        btnOrdenar.setForeground(new java.awt.Color(255, 255, 255));
        btnOrdenar.setText("Ordenar");
        redondear1.add(btnOrdenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 380, 120, 40));

        btnMostrarTodo.setBackground(new java.awt.Color(204, 204, 0));
        btnMostrarTodo.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        btnMostrarTodo.setForeground(new java.awt.Color(255, 255, 255));
        btnMostrarTodo.setText("Mostrar Todo");
        redondear1.add(btnMostrarTodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 450, 40));

        txfIngresoID.setBackground(new java.awt.Color(27, 114, 159));
        txfIngresoID.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        txfIngresoID.setForeground(new java.awt.Color(255, 255, 255));
        txfIngresoID.setBorder(null);
        redondear1.add(txfIngresoID, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, 80, 30));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        redondear1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 160, 80, 10));

        jLabel2.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Selecciona una opción");
        redondear1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 290, -1, -1));

        btnBuscar.setBackground(new java.awt.Color(255, 153, 0));
        btnBuscar.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        redondear1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 130, 110, 40));

        jLabel3.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ingresar la ID Venta:");
        redondear1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, -1, -1));

        jLabel4.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Selecciona una opción");
        redondear1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 190, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(redondear1, javax.swing.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(redondear1, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnBuscar;
    public javax.swing.JButton btnFiltrar;
    public javax.swing.JButton btnMostrarTodo;
    public javax.swing.JButton btnOrdenar;
    public javax.swing.JComboBox<String> cbxFiltrar;
    public javax.swing.JComboBox<String> cbxOrdenar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private Modelo.Redondear redondear1;
    public javax.swing.JTable tblHistorial;
    public javax.swing.JTextField txfIngresoID;
    // End of variables declaration//GEN-END:variables
}
