package Vista;

import java.awt.Color;

public class vistaBienvenida extends javax.swing.JFrame {

    public vistaBienvenida() {
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        redondear1 = new Modelo.Redondear();
        jlblCerrar = new javax.swing.JLabel();
        jlblMinimizar = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jbtnIngresar = new Modelo.Redondear();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);
        setSize(new java.awt.Dimension(796, 580));

        redondear1.setBackground(new java.awt.Color(13, 24, 33));
        redondear1.setRoundBottomLeft(60);
        redondear1.setRoundBottomRight(60);
        redondear1.setRoundTopLeft(60);
        redondear1.setRoundTopRight(60);
        redondear1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar.png"))); // NOI18N
        redondear1.add(jlblCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jlblMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/minimizar.png"))); // NOI18N
        redondear1.add(jlblMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("© 2024 - Libreria Sheila");
        redondear1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, -1, -1));

        jLabel10.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText(" Por favor, presiona el siguiente botón para acceder al sistema.");
        redondear1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 670, 30));

        jLabel8.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText(" ¡Bienvenido a nuestro sistema virtual! ");
        redondear1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 490, -1));

        jLabel14.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText(" Estamos emocionados de tenerte aquí.");
        redondear1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 600, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logosheyla.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        redondear1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 210, 210));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bg_bienvenida.png"))); // NOI18N
        jLabel7.setText("jLabel7");
        redondear1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 760, 300));

        jbtnIngresar.setBackground(new java.awt.Color(240, 244, 239));
        jbtnIngresar.setRoundBottomLeft(60);
        jbtnIngresar.setRoundBottomRight(60);
        jbtnIngresar.setRoundTopLeft(60);
        jbtnIngresar.setRoundTopRight(60);
        jbtnIngresar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Nirmala UI", 0, 24)); // NOI18N
        jLabel3.setText("Ingresar");
        jbtnIngresar.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 100, 40));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/gerente.png"))); // NOI18N
        jbtnIngresar.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 4, 70, 70));

        redondear1.add(jbtnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 460, 230, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(redondear1, javax.swing.GroupLayout.PREFERRED_SIZE, 788, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(redondear1, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vistaBienvenida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public Modelo.Redondear jbtnIngresar;
    public javax.swing.JLabel jlblCerrar;
    public javax.swing.JLabel jlblMinimizar;
    private Modelo.Redondear redondear1;
    // End of variables declaration//GEN-END:variables
}
