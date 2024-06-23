package Vista;

import java.awt.Color;

public class vistaLogin extends javax.swing.JFrame {

    public vistaLogin() {
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        redondear1 = new Modelo.Redondear();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        btnIngresar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnMin = new javax.swing.JLabel();
        btnCerr = new javax.swing.JLabel();
        lblError = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        redondear1.setBackground(new java.awt.Color(39, 107, 162));
        redondear1.setRoundBottomLeft(60);
        redondear1.setRoundBottomRight(60);
        redondear1.setRoundTopLeft(60);
        redondear1.setRoundTopRight(60);
        redondear1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ingresar credenciales para poder ingresar:");
        redondear1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 280, 360, 30));

        jLabel3.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Usuario:");
        redondear1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 330, 80, -1));

        jLabel4.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Bienvenido!");
        redondear1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 250, -1, -1));

        jLabel5.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Contraseña:");
        redondear1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 420, -1, -1));

        txtUser.setBackground(new java.awt.Color(26, 50, 62));
        txtUser.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        txtUser.setForeground(new java.awt.Color(255, 255, 255));
        txtUser.setBorder(null);
        redondear1.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 360, 240, 40));

        btnIngresar.setBackground(new java.awt.Color(26, 50, 62));
        btnIngresar.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresar.setText("Ingresar");
        btnIngresar.setBorder(null);
        redondear1.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 530, 140, 40));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        redondear1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 383, 220, 10));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        redondear1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 490, 220, 0));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/empleado (1).png"))); // NOI18N
        redondear1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 370, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/asegurado.png"))); // NOI18N
        redondear1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 470, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/usuarios.png"))); // NOI18N
        redondear1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 120, -1, -1));

        jLabel11.setFont(new java.awt.Font("Nirmala UI", 1, 48)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Iniciar Sesión");
        redondear1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, 310, 66));

        btnMin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/minimizar.png"))); // NOI18N
        redondear1.add(btnMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 10, -1, -1));

        btnCerr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar.png"))); // NOI18N
        redondear1.add(btnCerr, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 10, -1, -1));

        lblError.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        lblError.setForeground(new java.awt.Color(255, 0, 0));
        redondear1.add(lblError, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 280, 280, 30));

        txtPass.setBackground(new java.awt.Color(26, 50, 62));
        txtPass.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        txtPass.setForeground(new java.awt.Color(255, 255, 255));
        txtPass.setBorder(null);
        redondear1.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 460, 240, 40));

        jSeparator3.setBackground(new java.awt.Color(255, 255, 255));
        redondear1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 110, 310, -1));

        jPanel1.setBackground(new java.awt.Color(218, 150, 25));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logosheyla.png"))); // NOI18N
        jPanel1.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 210, 220));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bg_login.png"))); // NOI18N
        jPanel1.add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 580));

        redondear1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(redondear1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 0, 890, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(vistaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vistaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    public javax.swing.JLabel btnCerr;
    public javax.swing.JButton btnIngresar;
    public javax.swing.JLabel btnMin;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    public javax.swing.JLabel lblError;
    private javax.swing.JLabel logo;
    private Modelo.Redondear redondear1;
    public javax.swing.JPasswordField txtPass;
    public javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
