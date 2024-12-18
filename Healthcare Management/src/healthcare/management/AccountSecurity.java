/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package healthcare.management;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Xia
 */
public class AccountSecurity extends javax.swing.JFrame {

    /**
     * Creates new form AccSec
     */
    public AccountSecurity(String getName) {
        this.Name = getName; // Set the Name attribute
        this.setTitle("Account Settings");
        try {
            Connection();
        } catch (SQLException ex) {
            Logger.getLogger(AccountSecurity.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Images/NotifLogo.png")).getImage());// Assuming this method initializes GUI components
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Close this JFrame without exiting the application
        this.setLocationRelativeTo(null); // Center the window on the screen

        // Add a WindowListener to open the Account JFrame when this JFrame is closed
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                new AccountPage(Name).setVisible(true); // Open the Account JFrame
            }
        });
    }
    
    
    
    
    
    Connection con;
    Statement st;
    PreparedStatement pst;
    
    private static final String DbName = "credentials";
    private static final String DbDriver = "com.mysql.cj.jdbc.Driver";
    private static final String DbUrl = "jdbc:mysql://localhost:3306/"+DbName;
    private static final String DbUsername = "root";
    private static final String DbPass = "";
    public static String Name;
    
        
        
        
        
    public void Connection() throws SQLException{
        try {
            Class.forName(DbDriver);
            con = DriverManager.getConnection(DbUrl, DbUsername, DbPass);
            st = con.createStatement();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        ConfirmPassword = new javax.swing.JPasswordField();
        NewPassword = new javax.swing.JPasswordField();
        OldPassword = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Security");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jButton3.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, -1, -1));

        jButton2.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, -1, -1));

        jButton1.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        ConfirmPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmPasswordActionPerformed(evt);
            }
        });
        jPanel1.add(ConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 150, -1));
        jPanel1.add(NewPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 150, -1));

        OldPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OldPasswordActionPerformed(evt);
            }
        });
        jPanel1.add(OldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 150, -1));

        jLabel4.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel4.setText("New Password:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, 20));

        jLabel3.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel3.setText("Confirm New Password:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, 20));

        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel2.setText("Current Password:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        OldPassword.setText("");
        NewPassword.setText("");
        ConfirmPassword.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new AccountPage(Name).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void OldPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OldPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OldPasswordActionPerformed

    private void ConfirmPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ConfirmPasswordActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String CodeOldPassword = new String(OldPassword.getPassword());
        String CodeNewPassword = new String(NewPassword.getPassword());
        String CodeConfirmPassword = new String(ConfirmPassword.getPassword());
        String queryPullOldPass = "SELECT Password FROM accountdetails WHERE Fname = '" + Name + "';";

try {
    pst = con.prepareStatement(queryPullOldPass);
    ResultSet rs = pst.executeQuery();

    if (rs.next()) {
        String dbPassword = rs.getString("Password");

        if ("".equals(CodeOldPassword)) {
            JOptionPane.showMessageDialog(null, "Please enter your old password.", "No password", JOptionPane.ERROR_MESSAGE);
        } else if (!CodeOldPassword.equals(dbPassword)) {
            JOptionPane.showMessageDialog(null, "Your old password is incorrect.", "Wrong Password", JOptionPane.ERROR_MESSAGE);
        } else if ("".equals(CodeNewPassword)) {
            JOptionPane.showMessageDialog(null, "Please enter your new password.", "No password", JOptionPane.ERROR_MESSAGE);
        } else if ("".equals(CodeConfirmPassword)) {
            JOptionPane.showMessageDialog(null, "Please confirm your new password.", "No password", JOptionPane.ERROR_MESSAGE);
        } else if (CodeOldPassword.equals(CodeNewPassword)) {
            JOptionPane.showMessageDialog(null, "Your new password must not be the same as the old password.", "Password Error", JOptionPane.ERROR_MESSAGE);
        } else if (!CodeNewPassword.equals(CodeConfirmPassword)) {
            JOptionPane.showMessageDialog(null, "The new password and confirm password do not match.", "Password Error", JOptionPane.ERROR_MESSAGE);
        } else {
            int option = JOptionPane.showOptionDialog(
                null,
                "Do you want to continue changing your password?",
                "Password Change",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"Yes", "No"},
                "Yes"
            );

            if (option == JOptionPane.YES_OPTION) {
                String updatePasswordQuery = "UPDATE accountdetails SET Password = ? WHERE Fname = ?";
                pst = con.prepareStatement(updatePasswordQuery);
                pst.setString(1, CodeNewPassword);
                pst.setString(2, Name);
                pst.executeUpdate();

                JOptionPane.showMessageDialog(null, "Password changed successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null, "Logging Out", "Success", JOptionPane.INFORMATION_MESSAGE);
                new SignIn().setVisible(true);
                this.setVisible(false);
                
            } else {
                JOptionPane.showMessageDialog(null, "Password change canceled.", "Canceled", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    } else {
        JOptionPane.showMessageDialog(null, "Account not found.", "Error", JOptionPane.ERROR_MESSAGE);
    }
} catch (SQLException ex) {
    Logger.getLogger(AccountSecurity.class.getName()).log(Level.SEVERE, null, ex);
    JOptionPane.showMessageDialog(null, "An error occurred. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
}

    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(AccountSecurity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccountSecurity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccountSecurity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccountSecurity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccountSecurity(Name).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField ConfirmPassword;
    private javax.swing.JPasswordField NewPassword;
    private javax.swing.JPasswordField OldPassword;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
