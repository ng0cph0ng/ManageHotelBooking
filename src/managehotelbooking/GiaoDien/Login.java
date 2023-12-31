/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package managehotelbooking.GiaoDien;

import com.opencsv.exceptions.CsvValidationException;
import java.util.List;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import managehotelbooking.Models.DocGhiFile;
import managehotelbooking.Models.NhanVien;

/**
 *
 * @author ASUS
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Start
     */
    private List<NhanVien> nV = new ArrayList<>();

    private static final String curentDir = System.getProperty("user.dir");
    private static final String separator = File.separator;
    private static final String PATH_FILE_CSV_NhanVien = curentDir + separator + "data" + separator + "NhanVien.csv";
    private static File files = new File(PATH_FILE_CSV_NhanVien);
    private DocGhiFile dg = new DocGhiFile();

    public Login() {
        initComponents();
        if (files.exists()) {
            try {
                nV = dg.docFileNhanVien();
            } catch (CsvValidationException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void close() {
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tenDN = new javax.swing.JLabel();
        matKhau = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        dangNhapHeThong = new javax.swing.JLabel();
        txtPassWord = new javax.swing.JPasswordField();
        signIn = new javax.swing.JButton();
        signOut = new javax.swing.JButton();
        backGround = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Vô làm đi mấy con zợ iu <33");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        getContentPane().setLayout(null);

        tenDN.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tenDN.setText("TÊN ĐĂNG NHẬP");
        getContentPane().add(tenDN);
        tenDN.setBounds(790, 440, 190, 50);

        matKhau.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        matKhau.setText("MẬT KHẨU");
        getContentPane().add(matKhau);
        matKhau.setBounds(790, 510, 120, 50);

        txtUserName.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtUserName.setToolTipText("");
        getContentPane().add(txtUserName);
        txtUserName.setBounds(790, 480, 310, 30);

        dangNhapHeThong.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        dangNhapHeThong.setText("ĐĂNG NHẬP HỆ THỐNG");
        getContentPane().add(dangNhapHeThong);
        dangNhapHeThong.setBounds(800, 360, 300, 50);

        txtPassWord.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtPassWord.setToolTipText("");
        txtPassWord.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPassWordKeyPressed(evt);
            }
        });
        getContentPane().add(txtPassWord);
        txtPassWord.setBounds(790, 560, 310, 30);

        signIn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        signIn.setText("ĐĂNG NHẬP");
        signIn.setToolTipText("");
        signIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signInActionPerformed(evt);
            }
        });
        getContentPane().add(signIn);
        signIn.setBounds(850, 610, 200, 40);

        signOut.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        signOut.setText("TAN LÀM");
        signOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signOutActionPerformed(evt);
            }
        });
        getContentPane().add(signOut);
        signOut.setBounds(1620, 900, 200, 40);

        backGround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/managehotelbooking/Hinh/wp4581485.jpg"))); // NOI18N
        backGround.setPreferredSize(new java.awt.Dimension(1920, 1080));
        getContentPane().add(backGround);
        backGround.setBounds(0, 0, 1980, 1080);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void signInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signInActionPerformed
        MainPage mpFrame = new MainPage();
        Login lFrame = new Login();

        String userName = txtUserName.getText();
        String passWord = new String(txtPassWord.getPassword());

        boolean flag = false;

        for (NhanVien item : nV) {
            if (userName.equals(item.getId()) && passWord.equals(item.getMatKhau())) {

                MainPage.Instance.jlbMa.setText(item.getId());
                MainPage.Instance.jlbTen.setText(item.getTen());
                MainPage.Instance.jlbChucVu.setText(item.getChucVu());

                flag = true;
                mpFrame.setVisible(true);
                JOptionPane.showMessageDialog(lFrame, "Đăng nhập thành công");
                close();
            }
        }
        if (flag == false) {
            JOptionPane.showMessageDialog(lFrame, "Không đúng tài khoản hoặc mật khẩu");
        }
    }//GEN-LAST:event_signInActionPerformed

    private void signOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signOutActionPerformed
        close();
    }//GEN-LAST:event_signOutActionPerformed

    private void txtPassWordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassWordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            MainPage mpFrame = new MainPage();
            Login lFrame = new Login();

            String userName = txtUserName.getText();
            String passWord = new String(txtPassWord.getPassword());

            boolean flag = false;

            for (NhanVien item : nV) {

                if (userName.equals(item.getId()) && passWord.equals(item.getMatKhau())) {

                    MainPage.Instance.jlbMa.setText(item.getId());
                    MainPage.Instance.jlbTen.setText(item.getTen());
                    MainPage.Instance.jlbChucVu.setText(item.getChucVu());

                    flag = true;
                    mpFrame.setVisible(true);
                    JOptionPane.showMessageDialog(lFrame, "Đăng nhập thành công");
                    close();

                }

            }

            if (flag == false) {
                JOptionPane.showMessageDialog(lFrame, "Không đúng tài khoản hoặc mật khẩu");
            }
        }
    }//GEN-LAST:event_txtPassWordKeyPressed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backGround;
    private javax.swing.JLabel dangNhapHeThong;
    private javax.swing.JLabel matKhau;
    private javax.swing.JButton signIn;
    private javax.swing.JButton signOut;
    private javax.swing.JLabel tenDN;
    private javax.swing.JPasswordField txtPassWord;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
