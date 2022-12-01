/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.sql.*;
import clases.Conexion;
import com.mysql.cj.conf.StringProperty;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mb
 */
public class GestionarUsuarios extends javax.swing.JFrame {

    String user;
    public static int id_usuario = 0;
    DefaultTableModel model = new DefaultTableModel();

    /**
     * Creates new form GestionarUsuarios
     */
    public GestionarUsuarios() {
        initComponents();
        user = login.user;

        setSize(630, 330);
        setTitle("Usuarios registrados - Sesion de " + user);
        setResizable(false);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ImageIcon wallpaper = new ImageIcon("src/images/fondo.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
                jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Wallpaper.setIcon(icono);
        this.repaint();

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT id_usuario, username, nombre_usuario, email, tipo_nivel, estatus, carrera FROM usuarios WHERE tipo_nivel != 'Administrador'");
            ResultSet rs = pst.executeQuery();

            jTable_usuarios = new JTable(model);
            jScrollPane1.setViewportView(jTable_usuarios);

            model.addColumn("ID");
            model.addColumn("Username");
            model.addColumn("Nombre");
            model.addColumn("Email");
            model.addColumn("Permisos");
            model.addColumn("Estatus");
            model.addColumn("Carrera");

            while (rs.next()) {
                Object[] fila = new Object[7];
                for (int i = 0; i < 7; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error al llenar tabla.");
            JOptionPane.showMessageDialog(null, "Error al mostrar informacion, contacte al administrador");
        }
        obtenerDatosTabla();

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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_usuarios = new javax.swing.JTable();
        cmb_carrera = new javax.swing.JComboBox<>();
        btn_mostrar = new javax.swing.JButton();
        cmb_estatus = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Usuarios registrados");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        jTable_usuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable_usuarios);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 560, 180));

        cmb_carrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Analista", "Regimen", "Administracion", " " }));
        cmb_carrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_carreraActionPerformed(evt);
            }
        });
        getContentPane().add(cmb_carrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 130, -1));

        btn_mostrar.setText("Mostrar");
        btn_mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mostrarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_mostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 260, -1, -1));

        cmb_estatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Disponible", "Ocupado", " " }));
        cmb_estatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_estatusActionPerformed(evt);
            }
        });
        getContentPane().add(cmb_estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 130, -1));

        jLabel2.setText("Buscar usuario:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, -1, 20));

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        getContentPane().add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, 100, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_mostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mostrarActionPerformed
        String seleccion = cmb_estatus.getSelectedItem().toString();
        String seleccion2 = cmb_carrera.getSelectedItem().toString();
        String query = "";

        model.setRowCount(0);
        model.setColumnCount(0);

        try {
            Connection cn = Conexion.conectar();

            if (seleccion.equalsIgnoreCase("Todos") && seleccion2.equalsIgnoreCase("Todos")) {
                query = "SELECT id_usuario, username, nombre_usuario, email, tipo_nivel, estatus, carrera FROM usuarios WHERE tipo_nivel != 'Administrador'";
            } else if (seleccion2.equalsIgnoreCase("Todos")) {
                query = "SELECT id_usuario, username, nombre_usuario, email, tipo_nivel, estatus, carrera FROM usuarios WHERE estatus = '" + seleccion + "' && tipo_nivel != 'Administrador'";
            } else if (seleccion.equalsIgnoreCase("Todos")) {
                query = "SELECT id_usuario, username, nombre_usuario, email, tipo_nivel, estatus, carrera FROM usuarios WHERE carrera = '" + seleccion2 + "' && tipo_nivel != 'Administrador'";
            } else {
                query = "SELECT id_usuario, username, nombre_usuario, email, tipo_nivel, estatus, carrera FROM usuarios WHERE carrera = '" + seleccion2 + "' && estatus = '" + seleccion + "' && tipo_nivel != 'Administrador'";
            }

            PreparedStatement pst = cn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            jTable_usuarios = new JTable(model);
            jScrollPane1.setViewportView(jTable_usuarios);

            model.addColumn("ID");
            model.addColumn("Username");
            model.addColumn("Nombre");
            model.addColumn("Email");
            model.addColumn("Permisos");
            model.addColumn("Estatus");
            model.addColumn("Carrera");

            while (rs.next()) {
                Object[] fila = new Object[7];
                for (int i = 0; i < 7; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al recuperar los registros." + e);
        }
        obtenerDatosTabla();
    }//GEN-LAST:event_btn_mostrarActionPerformed

    private void cmb_carreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_carreraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_carreraActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        filtrarDatos(txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void cmb_estatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_estatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_estatusActionPerformed

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
            java.util.logging.Logger.getLogger(GestionarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionarUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_mostrar;
    private javax.swing.JComboBox<String> cmb_carrera;
    private javax.swing.JComboBox<String> cmb_estatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_usuarios;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

    public void filtrarDatos(String valor) {
        String[] titulos = {"ID", "Username", "Nombre", "Email", "Permisos", "Estatus", "Carrera"};
        String[] registros = new String[7];

        String seleccion = cmb_estatus.getSelectedItem().toString();
        String seleccion2 = cmb_carrera.getSelectedItem().toString();

        DefaultTableModel modelo = new DefaultTableModel(null, titulos);

        String SQL = "";
        if (seleccion.equalsIgnoreCase("Todos") && seleccion2.equalsIgnoreCase("Todos")) {
            SQL = "SELECT id_usuario, username, nombre_usuario, email, tipo_nivel, estatus, carrera FROM usuarios WHERE tipo_nivel != 'Administrador' && nombre_usuario like '%" + valor + "%'";
        } else if (seleccion2.equalsIgnoreCase("Todos")) {
            SQL = "SELECT id_usuario, username, nombre_usuario, email, tipo_nivel, estatus, carrera FROM usuarios WHERE estatus = '" + seleccion + "' && tipo_nivel != 'Administrador' && nombre_usuario like '%" + valor + "%'";
        } else if (seleccion.equalsIgnoreCase("Todos")) {
            SQL = "SELECT id_usuario, username, nombre_usuario, email, tipo_nivel, estatus, carrera FROM usuarios WHERE carrera = '" + seleccion2 + "' && tipo_nivel != 'Administrador' && nombre_usuario like '%" + valor + "%'";
        } else {
            SQL = "SELECT id_usuario, username, nombre_usuario, email, tipo_nivel, estatus, carrera FROM usuarios WHERE carrera = '" + seleccion2 + "' && estatus = '" + seleccion + "' && tipo_nivel != 'Administrador' && nombre_usuario like '%" + valor + "%'";
        }

        try {
            Connection cn = Conexion.conectar();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {
                System.out.println(rs.getString("id_usuario"));
                registros[0] = rs.getString("id_usuario");
                registros[1] = rs.getString("username");
                registros[2] = rs.getString("nombre_usuario");
                registros[3] = rs.getString("email");
                registros[4] = rs.getString("tipo_nivel");
                registros[5] = rs.getString("estatus");
                registros[6] = rs.getString("carrera");
                modelo.addRow(registros);
            }

            jTable_usuarios.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al filtrar: " + e);
        }

    }

    public void obtenerDatosTabla() {
        jTable_usuarios.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_usuarios.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    id_usuario = (int) model.getValueAt(fila_point, columna_point);
                    InformacionUsuario informacion_usuario = new InformacionUsuario();
                    informacion_usuario.setVisible(true);
                }
            }
        });
    }
}
