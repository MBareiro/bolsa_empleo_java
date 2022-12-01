/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.sql.*;
import clases.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author mb
 */
public class InformacionUsuario extends javax.swing.JFrame {

    String user = "", user_update = "", nombre_usuario, id_usuario = "";
    int ID;
    boolean usuario = false;

    /**
     * Creates new form InformacionUsuario
     */
    public InformacionUsuario() {
        initComponents();
        user = login.user;

        if (GestionarUsuarios.id_usuario > 0) {
            id_usuario = String.valueOf(GestionarUsuarios.id_usuario);
            System.out.println(id_usuario);
        } else if (login.id_usuario != "") {
            id_usuario = login.id_usuario;
            System.out.println(id_usuario);
        }

        setSize(630, 450);
        setResizable(false);
        setTitle("Informacion del usuario " + user_update + " - Sesion de " + user);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ImageIcon wallpaper = new ImageIcon("src/images/fondo.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
                jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Wallpaper.setIcon(icono);
        this.repaint();

        jLabel_Titulo.setText("Informacion del usuario " + user_update);

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT * FROM usuarios WHERE id_usuario = '" + id_usuario + "' AND tipo_nivel = 'Administrador'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                cmb_niveles.setVisible(true);
                jLabel_permisos.setVisible(true);
                jButton_RestaurarPassword.setVisible(true);
            } else {
                usuario = true;
                user_update = user;
                cmb_niveles.setVisible(false);
                jLabel_permisos.setVisible(false);
                jButton_RestaurarPassword.setVisible(false);
            }
            if (login.id_usuario != "") {
                PreparedStatement pst2 = cn.prepareStatement(
                        "SELECT * FROM usuarios WHERE id_usuario = '" + login.id_usuario + "' AND tipo_nivel = 'Administrador'");
                ResultSet rs1 = pst2.executeQuery();

                if (rs1.next()) {
                    cmb_niveles.setVisible(true);
                    jLabel_permisos.setVisible(true);
                    jButton_RestaurarPassword.setVisible(true);
                } 
            }
            cn.close();

        } catch (SQLException e) {
            System.err.println("Error encontrar usuario " + e);
            JOptionPane.showMessageDialog(null, "Error encontrar usuario! contacte al admin");
        }

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT * FROM usuarios WHERE id_usuario = '" + id_usuario + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                ID = rs.getInt("id_usuario");

                //Settea las cajas de texto con la informacion del usuario
                txt_username.setText(rs.getString("username"));
                txt_nombre.setText(rs.getString("nombre_usuario"));
                txt_mail.setText(rs.getString("email"));
                txt_telefono.setText(rs.getString("telefono"));
                cmb_estatus.setSelectedItem(rs.getString("estatus"));
                cmb_carrera.setSelectedItem(rs.getString("carrera"));
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error en cargar usuario " + e);
            JOptionPane.showMessageDialog(null, "Error al cargar! contacte al admin");
        }

    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/logo.png"));
        return retValue;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_Titulo = new javax.swing.JLabel();
        jLabel_Nombre = new javax.swing.JLabel();
        jLabel_Email = new javax.swing.JLabel();
        jLabel_Nombre2 = new javax.swing.JLabel();
        jLabel_permisos = new javax.swing.JLabel();
        jLabel_Nombre4 = new javax.swing.JLabel();
        jLabel_Nombre5 = new javax.swing.JLabel();
        jLabel_Nombre6 = new javax.swing.JLabel();
        jLabel_estatus = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_mail = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        txt_username = new javax.swing.JTextField();
        txt_nombre4 = new javax.swing.JTextField();
        txt_nombre5 = new javax.swing.JTextField();
        txt_nombre6 = new javax.swing.JTextField();
        cmb_estatus = new javax.swing.JComboBox<>();
        cmb_niveles = new javax.swing.JComboBox<>();
        jButton_Actualizar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton_Imprimir = new javax.swing.JButton();
        cmb_carrera = new javax.swing.JComboBox<>();
        Carrera = new javax.swing.JLabel();
        jButton_RestaurarPassword = new javax.swing.JButton();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel_Titulo.setText("Informacion del Usuario");
        getContentPane().add(jLabel_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        jLabel_Nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre.setText("Nombre:");
        getContentPane().add(jLabel_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel_Email.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Email.setText("Email");
        getContentPane().add(jLabel_Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel_Nombre2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre2.setText("Telefono:");
        getContentPane().add(jLabel_Nombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel_permisos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_permisos.setText("Permisos de:");
        getContentPane().add(jLabel_permisos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));
        jLabel_permisos.getAccessibleContext().setAccessibleDescription("");

        jLabel_Nombre4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre4.setText("Username:");
        getContentPane().add(jLabel_Nombre4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, -1, -1));

        jLabel_Nombre5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre5.setText("Nombre:");
        getContentPane().add(jLabel_Nombre5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel_Nombre6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre6.setText("Nombre:");
        getContentPane().add(jLabel_Nombre6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel_estatus.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_estatus.setText("Estatus:");
        getContentPane().add(jLabel_estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, -1, -1));

        txt_nombre.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_nombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 210, -1));

        txt_mail.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_mail.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 210, -1));

        txt_telefono.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_telefono.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 210, -1));

        txt_username.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_username.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 210, -1));

        txt_nombre4.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_nombre4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_nombre4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 210, -1));

        txt_nombre5.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_nombre5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_nombre5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 210, -1));

        txt_nombre6.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_nombre6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_nombre6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 210, -1));

        cmb_estatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disponible", "Ocupado" }));
        getContentPane().add(cmb_estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, -1, -1));

        cmb_niveles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Usuario" }));
        cmb_niveles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_nivelesActionPerformed(evt);
            }
        });
        getContentPane().add(cmb_niveles, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        jButton_Actualizar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton_Actualizar.setText("Actualizar Usuario");
        jButton_Actualizar.setBorder(null);
        jButton_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, 210, 35));

        jLabel3.setText("Imprimir");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 360, -1, -1));

        jButton_Imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/impresora.png"))); // NOI18N
        jButton_Imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ImprimirActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Imprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, 120, 100));

        cmb_carrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Analista", "Regimen", "Administracion" }));
        getContentPane().add(cmb_carrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        Carrera.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Carrera.setText("Carrera");
        getContentPane().add(Carrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jButton_RestaurarPassword.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton_RestaurarPassword.setText("Restaurar Password");
        jButton_RestaurarPassword.setBorder(null);
        jButton_RestaurarPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RestaurarPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_RestaurarPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 210, 210, 35));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ActualizarActionPerformed
        int permisos_cmb, estatus_cmb, carrera_cmb, validacion = 0, nums = 0, letras = 0;
        String nombre, mail, telefono, username, permisos_string = "", estastus_string = "", carrera_string = "";

        mail = txt_mail.getText().trim();
        username = txt_username.getText().trim();
        nombre = txt_nombre.getText().trim();
        telefono = txt_telefono.getText().trim();
        permisos_cmb = cmb_niveles.getSelectedIndex() + 1;
        estatus_cmb = cmb_estatus.getSelectedIndex();
        carrera_cmb = cmb_carrera.getSelectedIndex();
        System.out.println("Car  " + carrera_cmb);

        if (mail.equals("")) {
            txt_mail.setBackground(Color.red);
            validacion++;
        } else {
            txt_mail.setBackground(Color.white);
        }
        if (username.equals("")) {
            txt_username.setBackground(Color.red);
            validacion++;
        } else {
            txt_username.setBackground(Color.white);
        }
        if (nombre.equals("")) {
            txt_nombre.setBackground(Color.red);
            validacion++;
        } else {
            txt_nombre.setBackground(Color.white);
        }        
        if(nombre.matches("[0-9]*")){
            nums++;
        }
        
        
        if (telefono.equals("")) {
            txt_telefono.setBackground(Color.red);
            validacion++;
        } else {
            txt_telefono.setBackground(Color.white);
        }
        if(telefono.matches("[a-zA-Z]*")){
            letras++;
        }        
        
        if (estatus_cmb < 0) {
            validacion++;
        }
        if (carrera_cmb < 0) {
            validacion++;
        }

        if (validacion == 0 && nums == 0 && letras == 0) {
            if (permisos_cmb == 1) {
                permisos_string = "Administrador";
            } else if (permisos_cmb == 2) {
                permisos_string = "Usuario";
            }

            if (estatus_cmb == 0) {
                estastus_string = "Disponible";
            } else if (estatus_cmb == 1) {
                estastus_string = "Ocupado";
            }

            if (carrera_cmb == 0) {
                carrera_string = "Analista";
            } else if (carrera_cmb == 1) {
                carrera_string = "Regimen";
            } else if (carrera_cmb == 2) {
                carrera_string = "Administracion";
            }

            System.out.println(carrera_string);
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "SELECT username FROM usuarios WHERE username = '" + username + "' AND not id_usuario = '" + ID + "'");

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    txt_username.setBackground(Color.red);
                    JOptionPane.showMessageDialog(null, "Nombre de usuario no disponible");
                } else {
                    Connection cn2 = Conexion.conectar();

                    if (usuario) {
                        PreparedStatement pst2 = cn2.prepareStatement(
                                "UPDATE usuarios SET username=?, nombre_usuario=?, email=?, telefono=?, estatus=?, carrera=? WHERE id_usuario = '" + ID + "'");

                        pst2.setString(1, username);
                        pst2.setString(2, nombre);
                        pst2.setString(3, mail);
                        pst2.setString(4, telefono);
                        pst2.setString(5, estastus_string);
                        pst2.setString(6, carrera_string);

                        pst2.executeUpdate();
                        cn2.close();

                        JOptionPane.showMessageDialog(null, "Modificacion correcta.");
                    } else {
                        JOptionPane.showMessageDialog(null, "asdasdasdasdasdasd");
                        PreparedStatement pst2 = cn2.prepareStatement(
                                "UPDATE usuarios SET username=?, tipo_nivel=?, nombre_usuario=?, email=?, telefono=?, estatus=?, carrera=? WHERE id_usuario = '" + ID + "'");

                        pst2.setString(1, username);
                        pst2.setString(2, permisos_string);
                        pst2.setString(3, nombre);
                        pst2.setString(4, mail);
                        pst2.setString(5, telefono);
                        pst2.setString(6, estastus_string);
                        pst2.setString(7, carrera_string);

                        pst2.executeUpdate();
                        cn2.close();

                        JOptionPane.showMessageDialog(null, "Modificacion correcta.");

                    }
                }
            } catch (SQLException e) {
                System.err.println("Error al actualizar " + e);
            }
        } else if(nums != 0){
            JOptionPane.showMessageDialog(null, "Nombre solo puede contener letras");
        }else if(letras != 0){
            JOptionPane.showMessageDialog(null, "Telefono solo puede contener numeros");
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }


    }//GEN-LAST:event_jButton_ActualizarActionPerformed

    private void cmb_nivelesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_nivelesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_nivelesActionPerformed

    private void jButton_ImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ImprimirActionPerformed
        Document documento = new Document();

        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/" + txt_nombre.getText().trim() + ".pdf"));

            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/images/logo.png");
            header.scaleToFit(50, 100);
            header.setAlignment(Chunk.ALIGN_CENTER);
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Informacion del usuario. \n \n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));

            documento.open();
            documento.add(header);
            documento.add(parrafo);

            PdfPTable tablaUsuario = new PdfPTable(6);
            tablaUsuario.addCell("ID");
            tablaUsuario.addCell("Nombre");
            tablaUsuario.addCell("Email");
            tablaUsuario.addCell("Telefono");
            tablaUsuario.addCell("Disponibilidad");
            tablaUsuario.addCell("Carrera");

            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "SELECT id_usuario, nombre_usuario, email, telefono, estatus, carrera FROM usuarios WHERE  id_usuario = '" + ID + "'");

                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    do {
                        tablaUsuario.addCell(rs.getString(1));
                        tablaUsuario.addCell(rs.getString(2));
                        tablaUsuario.addCell(rs.getString(3));
                        tablaUsuario.addCell(rs.getString(4));
                        tablaUsuario.addCell(rs.getString(5));
                        tablaUsuario.addCell(rs.getString(6));
                    } while (rs.next());
                    documento.add(tablaUsuario);
                }

            } catch (SQLException e) {
                System.err.println("Error al obtener los datos" + e);
            }

            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte creado con exito!");

        } catch (DocumentException | IOException e) {
            System.err.println("Error en pdf o ruta de imagen" + e);
            JOptionPane.showMessageDialog(null, "Error al generar el pdf, contacte al admin");
        }
    }//GEN-LAST:event_jButton_ImprimirActionPerformed

    private void jButton_RestaurarPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RestaurarPasswordActionPerformed
        RestaurarPassword restaurarPassword = new RestaurarPassword();
        restaurarPassword.setVisible(true);
    }//GEN-LAST:event_jButton_RestaurarPasswordActionPerformed

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
            java.util.logging.Logger.getLogger(InformacionUsuario.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacionUsuario.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacionUsuario.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacionUsuario.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacionUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Carrera;
    private javax.swing.JComboBox<String> cmb_carrera;
    private javax.swing.JComboBox<String> cmb_estatus;
    private javax.swing.JComboBox<String> cmb_niveles;
    private javax.swing.JButton jButton_Actualizar;
    private javax.swing.JButton jButton_Imprimir;
    private javax.swing.JButton jButton_RestaurarPassword;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel_Email;
    private javax.swing.JLabel jLabel_Nombre;
    private javax.swing.JLabel jLabel_Nombre2;
    private javax.swing.JLabel jLabel_Nombre4;
    private javax.swing.JLabel jLabel_Nombre5;
    private javax.swing.JLabel jLabel_Nombre6;
    private javax.swing.JLabel jLabel_Titulo;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JLabel jLabel_estatus;
    private javax.swing.JLabel jLabel_permisos;
    private javax.swing.JTextField txt_mail;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_nombre4;
    private javax.swing.JTextField txt_nombre5;
    private javax.swing.JTextField txt_nombre6;
    private javax.swing.JTextField txt_telefono;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
