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
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

/**
 *
 * @author Xia
 */
public class Adherence extends javax.swing.JFrame {

    public Adherence(String getName) {
        this.Name=getName;
        this.setTitle("Adherence");
        setCurrentDate();
        getCurrentTime();
        try {
            Connection();
        } catch (SQLException ex) {
            Logger.getLogger(Adherence.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
        getMedicine();
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Images/NotifLogo.png")).getImage());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
    
    public static String Name;
    
    
    
        
    Connection con;
    Statement st;
    ResultSet rs;
    PreparedStatement pst;
    SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy");
    
    private static final String DbName = "credentials";
    private static final String DbDriver = "com.mysql.cj.jdbc.Driver";
    private static final String DbUrl = "jdbc:mysql://localhost:3306/"+DbName;
    private static final String DbUsername = "root";
    private static final String DbPass = "";
    public static float MaxValue;
    public float MinValue;
    public String Percent;
    
    public static Date currentDateObj;
    public static String currentDate;
    
    public static DateTimeFormatter timeFormatter;
    public static LocalTime currentTime;
    public static String ActualTime;
    
public void setCurrentDate() {
    try {
        currentDateObj = new Date(); // Get the current system date
        currentDate = sdf.format(currentDateObj);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(
            this, 
            "Error setting the current date.", 
            "Error", 
            JOptionPane.ERROR_MESSAGE
        );
    }
    }
    
public void getCurrentTime() {
        // Get the current time
        currentTime = LocalTime.now();

        // Format the time in HH:mm:ss format
        timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
        ActualTime = currentTime.format(timeFormatter);


    }
    


public void getMedicine() {
    String queryMed = "SELECT MinVal, MaxVal FROM Adherence;";
    try {
        Connection();

        PreparedStatement pst = con.prepareStatement(queryMed);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            MinValue = rs.getInt("MinVal");
            MaxValue = rs.getInt("MaxVal");
        }

        MedProg.setMinimum(0); // Typically, a progress bar minimum starts at 0
        MedProg.setMaximum((int) MaxValue);

        if (MaxValue > 0) {
            double percentage = ((double) MinValue / MaxValue) * 100;
            Percent = String.format("%.2f %%", percentage);
            MedProg.setValue((int) MinValue);
        } else {
            Percent = "0.00 %";
            MedProg.setValue(0);
        }
        Percentage.setText(Percent);

        // Close resources
        rs.close();
        pst.close();
        con.close();

    } catch (SQLException ex) {
        Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        ex.printStackTrace();
    }
}





 



public void Connection() throws SQLException {
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

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jPanel3 = new javax.swing.JPanel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Percentage1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        MedProg = new javax.swing.JProgressBar();
        jButton6 = new javax.swing.JButton();
        Percentage = new javax.swing.JLabel();
        Percentage3 = new javax.swing.JLabel();
        Percentage2 = new javax.swing.JLabel();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jPanel3.add(jProgressBar1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/HomeLogo.png"))); // NOI18N
        jButton7.setBorder(null);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 590, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Reminder.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 590, -1, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Active Tracking.png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 590, -1, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Logs.png"))); // NOI18N
        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 590, -1, -1));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Account.png"))); // NOI18N
        jButton5.setBorder(null);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 590, -1, -1));

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jPanel6.setBackground(new java.awt.Color(180, 196, 208));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("under development.");
        jPanel6.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 260, 30));

        jLabel3.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("This feature is still");
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 240, 30));

        Percentage1.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        Percentage1.setForeground(new java.awt.Color(0, 51, 102));
        Percentage1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Percentage1.setText("Weekly Adherence");
        jPanel6.add(Percentage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 40));

        jPanel2.add(jPanel6);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 320, 220));

        jPanel4.setBackground(new java.awt.Color(153, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        jPanel5.setBackground(new java.awt.Color(180, 196, 208));
        jPanel5.setForeground(new java.awt.Color(180, 196, 208));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MedProg.setForeground(new java.awt.Color(102, 102, 255));
        MedProg.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                MedProgStateChanged(evt);
            }
        });
        jPanel5.add(MedProg, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 300, 30));

        jButton6.setBackground(new java.awt.Color(204, 204, 204));
        jButton6.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(34, 59, 83));
        jButton6.setText("View all logs");
        jButton6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 120, -1));

        Percentage.setFont(new java.awt.Font("Montserrat", 1, 36)); // NOI18N
        Percentage.setForeground(new java.awt.Color(0, 51, 102));
        jPanel5.add(Percentage, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 170, 80));

        Percentage3.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        Percentage3.setForeground(new java.awt.Color(0, 51, 102));
        Percentage3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Percentage3.setText("Todays Adherence");
        jPanel5.add(Percentage3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 40));

        jPanel4.add(jPanel5);

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 320, 220));

        Percentage2.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        Percentage2.setForeground(new java.awt.Color(0, 51, 102));
        Percentage2.setText("Record");
        jPanel1.add(Percentage2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 130, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        new Home().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new Reminder(Name,null,null,null).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new Adherence(Name).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new Account(Name).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new Logging(Name).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        new Logging(Name).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void MedProgStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_MedProgStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_MedProgStateChanged

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
            java.util.logging.Logger.getLogger(Adherence.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Adherence.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Adherence.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Adherence.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Adherence(Name).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar MedProg;
    private javax.swing.JLabel Percentage;
    private javax.swing.JLabel Percentage1;
    private javax.swing.JLabel Percentage2;
    private javax.swing.JLabel Percentage3;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
}
