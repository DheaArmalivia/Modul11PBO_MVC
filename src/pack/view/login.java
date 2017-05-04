/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.view;

import java.sql.Connection;
import java.sql.DriverManager;
import static java.sql.DriverManager.getConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import pack.control.login_koneksi;

/**
 *
 * @author Smktelkom
 */
public class login extends javax.swing.JFrame {
    
    public static String user;
    /**
     * Creates new form login
     */
    public login() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfUname = new javax.swing.JTextField();
        tfPassword = new javax.swing.JPasswordField();
        bSignUp = new javax.swing.JButton();
        bExit = new javax.swing.JButton();
        bSignIn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Password");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(160, 110, 80, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Username");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(160, 30, 80, 30);
        getContentPane().add(tfUname);
        tfUname.setBounds(110, 60, 200, 30);
        getContentPane().add(tfPassword);
        tfPassword.setBounds(110, 140, 200, 30);

        bSignUp.setFont(new java.awt.Font("MS Mincho", 0, 11)); // NOI18N
        bSignUp.setText("SignUp");
        bSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSignUpActionPerformed(evt);
            }
        });
        getContentPane().add(bSignUp);
        bSignUp.setBounds(70, 210, 70, 30);

        bExit.setFont(new java.awt.Font("MS Mincho", 0, 11)); // NOI18N
        bExit.setText("Exit");
        getContentPane().add(bExit);
        bExit.setBounds(160, 210, 70, 30);

        bSignIn.setFont(new java.awt.Font("MS Mincho", 0, 11)); // NOI18N
        bSignIn.setText("SignIn");
        bSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSignInActionPerformed(evt);
            }
        });
        getContentPane().add(bSignIn);
        bSignIn.setBounds(250, 210, 69, 30);

        setBounds(0, 0, 416, 318);
    }// </editor-fold>//GEN-END:initComponents

    private void bSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSignInActionPerformed
        Connection connection;
        PreparedStatement ps;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/toko?zeroDateTimeBehavior=convertToNull", "root", "");
            ps = connection.prepareStatement("SELECT * FROM tb_akun WHERE username = ? AND password = ?"); 
            ps.setString(1, tfUname.getText());
            ps.setString(2, tfPassword.getText());
            ResultSet result = ps.executeQuery();
             if(result.next()){ 
                new home().show(); 
                user = tfUname.getText();
                this.dispose();
             } else {
                 JOptionPane.showMessageDialog(rootPane, "Salah!");
                 tfPassword.setText("");
                 tfUname.requestFocus();
             }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Gagal!");
        }
    }//GEN-LAST:event_bSignInActionPerformed

    private void bSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSignUpActionPerformed
        String username = tfUname.getText();
        String password = tfPassword.getText();
        
        try {
            try (java.sql.Statement statement = (java.sql.Statement) login_koneksi.GetConnection().createStatement()) {
                statement.executeUpdate("insert into tb_akun(username, password) VALUES ('"+username+"','"+password+"');");
            }
            JOptionPane.showMessageDialog(null, "Selamat! Anda berhasil sign up");
        } catch (Exception t) {
            JOptionPane.showMessageDialog(null, "Mohon Maaf, ulangi lagi prosedur");
        }
    }//GEN-LAST:event_bSignUpActionPerformed

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
    private javax.swing.JButton bExit;
    private javax.swing.JButton bSignIn;
    private javax.swing.JButton bSignUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField tfPassword;
    private javax.swing.JTextField tfUname;
    // End of variables declaration//GEN-END:variables
}