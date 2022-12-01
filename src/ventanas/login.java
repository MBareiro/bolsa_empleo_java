package ventanas;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.sql.*;
import clases.Conexion;
import javax.swing.JOptionPane;

public class login extends javax.swing.JFrame {

    public static String user = "";
    public static String id_usuario = "";
    String pass = "";

    public login() {
        initComponents();
        setSize(400, 550);
        setResizable(false);
        setTitle("Acceso al sistema");
        setLocationRelativeTo(null);

        ImageIcon wallpaper = new ImageIcon("src/images/fondo.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
                jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Wallpaper.setIcon(icono);
        this.repaint();

        ImageIcon wallpapper_logo = new ImageIcon("src/images/logo.png");
        Icon icono_logo = new ImageIcon(wallpapper_logo.getImage().getScaledInstance(jLabel_logo.getWidth(),
                jLabel_logo.getHeight(), Image.SCALE_DEFAULT));
        jLabel_logo.setIcon(icono_logo);
        this.repaint();
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/logo.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel_logo = new javax.swing.JLabel();
        txt_user = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        jLabel_Usuario = new javax.swing.JLabel();
        jLabel_Contraseña = new javax.swing.JLabel();
        jButton_Acceder = new javax.swing.JButton();
        jLabel_Wallpaper = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        jTextField2.setText("jTextField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 150, 130));

        txt_user.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_user.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 210, -1));

        txt_password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_password.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 210, -1));

        jLabel_Usuario.setText("Usuario");
        getContentPane().add(jLabel_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, -1, -1));

        jLabel_Contraseña.setText("Contraseña");
        getContentPane().add(jLabel_Contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, -1, -1));

        jButton_Acceder.setText("Acceder");
        jButton_Acceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AccederActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Acceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 420, 210, 35));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_AccederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AccederActionPerformed

        user = txt_user.getText().trim();
        pass = txt_password.getText().trim();

        if (!user.equals("") || !pass.equals("")) {
            try{
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                    "SELECT tipo_nivel, id_usuario FROM usuarios WHERE username = '" + user + "' AND password = '" + pass + "'");
                    ResultSet rs = pst.executeQuery();
                    if(rs.next()){
                        String tipo_nivel = rs.getString("tipo_nivel");
                        id_usuario = rs.getString("id_usuario");
                        
                        if(tipo_nivel.equals("Administrador")){
                            dispose();
                            new Administrador().setVisible(true);
                            
                        
                        } else if(tipo_nivel.equals("Usuario")){
                            dispose();
                            new Usuario().setVisible(true);
                        } 
                    } else {
                        JOptionPane.showMessageDialog(null, "Datos de acceso incorrectos");
                        txt_user.setText("");
                        txt_password.setText("");
                    }
            } catch(SQLException e) {
                System.err.println("Error en el boton Acceder" + e);
                JOptionPane.showMessageDialog(null, "Error al iniciar sesion, contacte al administrador");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }

    }//GEN-LAST:event_jButton_AccederActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Acceder;
    private javax.swing.JLabel jLabel_Contraseña;
    private javax.swing.JLabel jLabel_Usuario;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JLabel jLabel_logo;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_user;
    // End of variables declaration//GEN-END:variables
}
