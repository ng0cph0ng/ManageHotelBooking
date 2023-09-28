/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package managehotelbooking.GiaoDien;

import com.opencsv.exceptions.CsvValidationException;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import managehotelbooking.Models.DatPhong;
import managehotelbooking.Models.DocGhiFile;
import managehotelbooking.Models.KhachHang;
import managehotelbooking.Models.NhanVien;
import managehotelbooking.Models.Phong;

/**
 *
 * @author ASUS
 */
public class MainPage extends javax.swing.JFrame {

    /**
     * Creates new form Start
     */
    private List<KhachHang> kH = new ArrayList<>();
    private List<Phong> phong = new ArrayList<>();
    private List<DatPhong> dP = new ArrayList<>();
    private List<NhanVien> nV = new ArrayList<>();

    private static final String curentDir = System.getProperty("user.dir");
    private static final String separator = File.separator;
    private static final String PATH_FILE_CSV = curentDir + separator + "data" + separator + "KhachHang.csv";
    private static final String PATH_FILE_CSV_NhanVien = curentDir + separator + "data" + separator + "NhanVien.csv";
    private static final String PATH_FILE_CSV_Phong = curentDir + separator + "data" + separator + "Phong.csv";
    private static final String PATH_FILE_CSV_DATPHONG = curentDir + separator + "data" + separator + "DatPhong.csv";
    private static File fileKH = new File(PATH_FILE_CSV);
    private static File fileNV = new File(PATH_FILE_CSV_NhanVien);
    private static File fileP = new File(PATH_FILE_CSV_Phong);
    private static File fileDP = new File(PATH_FILE_CSV_DATPHONG);
    private DocGhiFile dg = new DocGhiFile();

    private DefaultTableModel modelKH;
    private DefaultTableModel modelNV;
    private DefaultTableModel modelPh;

    public static MainPage Instance;
    public JLabel jlbTen, jlbMa, jlbChucVu;

    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();

    public MainPage() {
        initComponents();
        thongTinPhong.setVisible(false);
        timKiem1.setVisible(false);
        themNV1.setVisible(false);

        Instance = this;
        jlbTen = txtTenNV;
        jlbMa = txtMaNV;
        jlbChucVu = txtChucVu;

        if (fileKH.exists()) {
            try {
                kH = dg.docFileKhachHang();
            } catch (CsvValidationException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (fileNV.exists()) {
            try {
                nV = dg.docFileNhanVien();
            } catch (CsvValidationException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (fileP.exists()) {
            try {
                phong = dg.docFilePhong();
            } catch (CsvValidationException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (fileDP.exists()) {
            try {
                try {
                    dP = dg.docFileDatPhong();
                } catch (ParseException ex) {
                    Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (CsvValidationException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        String parts[];

        parts = phong01.getText().split(" ");
        String maP01 = parts[1];

        parts = phong02.getText().split(" ");
        String maP02 = parts[1];

        parts = phong03.getText().split(" ");
        String maP03 = parts[1];

        parts = phong04.getText().split(" ");
        String maP04 = parts[1];

        parts = phong05.getText().split(" ");
        String maP05 = parts[1];

        parts = phong06.getText().split(" ");
        String maP06 = parts[1];

        parts = phong07.getText().split(" ");
        String maP07 = parts[1];

        parts = phong08.getText().split(" ");
        String maP08 = parts[1];

        parts = phong09.getText().split(" ");
        String maP09 = parts[1];

        parts = phong10.getText().split(" ");
        String maP10 = parts[1];

        parts = phong11.getText().split(" ");
        String maP11 = parts[1];

        parts = phong1.getText().split(" ");
        String maP1 = parts[1];

        parts = phong2.getText().split(" ");
        String maP2 = parts[1];

        parts = phong3.getText().split(" ");
        String maP3 = parts[1];

        parts = phong4.getText().split(" ");
        String maP4 = parts[1];

        parts = phong5.getText().split(" ");
        String maP5 = parts[1];

        parts = phong6.getText().split(" ");
        String maP6 = parts[1];

        parts = phong7.getText().split(" ");
        String maP7 = parts[1];

        parts = phong8.getText().split(" ");
        String maP8 = parts[1];

        parts = phong9.getText().split(" ");
        String maP9 = parts[1];

        for (Phong item : phong) {
            if (maP01.equals(item.getMaPhong())) {
                if (item.getTrangThai().equals("Da dat")) {
                    phong01.setBackground(new java.awt.Color(255, 0, 51));
                } else {
                    phong01.setBackground(new java.awt.Color(50, 205, 50));
                }
            }
            if (maP02.equals(item.getMaPhong())) {
                if (item.getTrangThai().equals("Da dat")) {
                    phong02.setBackground(new java.awt.Color(255, 0, 51));
                } else {
                    phong02.setBackground(new java.awt.Color(50, 205, 50));
                }
            }
            if (maP03.equals(item.getMaPhong())) {
                if (item.getTrangThai().equals("Da dat")) {
                    phong03.setBackground(new java.awt.Color(255, 0, 51));
                } else {
                    phong03.setBackground(new java.awt.Color(50, 205, 50));
                }
            }
            if (maP04.equals(item.getMaPhong())) {
                if (item.getTrangThai().equals("Da dat")) {
                    phong04.setBackground(new java.awt.Color(255, 0, 51));
                } else {
                    phong04.setBackground(new java.awt.Color(50, 205, 50));
                }
            }
            if (maP05.equals(item.getMaPhong())) {
                if (item.getTrangThai().equals("Da dat")) {
                    phong05.setBackground(new java.awt.Color(255, 0, 51));
                } else {
                    phong05.setBackground(new java.awt.Color(50, 205, 50));
                }
            }
            if (maP06.equals(item.getMaPhong())) {
                if (item.getTrangThai().equals("Da dat")) {
                    phong06.setBackground(new java.awt.Color(255, 0, 51));
                } else {
                    phong06.setBackground(new java.awt.Color(50, 205, 50));
                }
            }
            if (maP07.equals(item.getMaPhong())) {
                if (item.getTrangThai().equals("Da dat")) {
                    phong07.setBackground(new java.awt.Color(255, 0, 51));
                } else {
                    phong07.setBackground(new java.awt.Color(50, 205, 50));
                }
            }
            if (maP08.equals(item.getMaPhong())) {
                if (item.getTrangThai().equals("Da dat")) {
                    phong08.setBackground(new java.awt.Color(255, 0, 51));
                } else {
                    phong08.setBackground(new java.awt.Color(50, 205, 50));
                }
            }
            if (maP09.equals(item.getMaPhong())) {
                if (item.getTrangThai().equals("Da dat")) {
                    phong09.setBackground(new java.awt.Color(255, 0, 51));
                } else {
                    phong09.setBackground(new java.awt.Color(50, 205, 50));
                }
            }
            if (maP10.equals(item.getMaPhong())) {
                if (item.getTrangThai().equals("Da dat")) {
                    phong10.setBackground(new java.awt.Color(255, 0, 51));
                } else {
                    phong10.setBackground(new java.awt.Color(50, 205, 50));
                }
            }
            if (maP11.equals(item.getMaPhong())) {
                if (item.getTrangThai().equals("Da dat")) {
                    phong11.setBackground(new java.awt.Color(255, 0, 51));
                } else {
                    phong11.setBackground(new java.awt.Color(50, 205, 50));
                }
            }
            if (maP1.equals(item.getMaPhong())) {
                if (item.getTrangThai().equals("Da dat")) {
                    phong1.setBackground(new java.awt.Color(255, 0, 51));
                } else {
                    phong1.setBackground(new java.awt.Color(50, 205, 50));
                }
            }
            if (maP2.equals(item.getMaPhong())) {
                if (item.getTrangThai().equals("Da dat")) {
                    phong2.setBackground(new java.awt.Color(255, 0, 51));
                } else {
                    phong2.setBackground(new java.awt.Color(50, 205, 50));
                }
            }
            if (maP3.equals(item.getMaPhong())) {
                if (item.getTrangThai().equals("Da dat")) {
                    phong3.setBackground(new java.awt.Color(255, 0, 51));
                } else {
                    phong3.setBackground(new java.awt.Color(50, 205, 50));
                }
            }
            if (maP4.equals(item.getMaPhong())) {
                if (item.getTrangThai().equals("Da dat")) {
                    phong4.setBackground(new java.awt.Color(255, 0, 51));
                } else {
                    phong4.setBackground(new java.awt.Color(50, 205, 50));
                }
            }
            if (maP5.equals(item.getMaPhong())) {
                if (item.getTrangThai().equals("Da dat")) {
                    phong5.setBackground(new java.awt.Color(255, 0, 51));
                } else {
                    phong5.setBackground(new java.awt.Color(50, 205, 50));
                }
            }
            if (maP6.equals(item.getMaPhong())) {
                if (item.getTrangThai().equals("Da dat")) {
                    phong6.setBackground(new java.awt.Color(255, 0, 51));
                } else {
                    phong6.setBackground(new java.awt.Color(50, 205, 50));
                }
            }
            if (maP7.equals(item.getMaPhong())) {
                if (item.getTrangThai().equals("Da dat")) {
                    phong7.setBackground(new java.awt.Color(255, 0, 51));
                } else {
                    phong7.setBackground(new java.awt.Color(50, 205, 50));
                }
            }
            if (maP8.equals(item.getMaPhong())) {
                if (item.getTrangThai().equals("Da dat")) {
                    phong8.setBackground(new java.awt.Color(255, 0, 51));
                } else {
                    phong8.setBackground(new java.awt.Color(50, 205, 50));
                }
            }
            if (maP9.equals(item.getMaPhong())) {
                if (item.getTrangThai().equals("Da dat")) {
                    phong9.setBackground(new java.awt.Color(255, 0, 51));
                } else {
                    phong9.setBackground(new java.awt.Color(50, 205, 50));
                }
            }
        }

        addRowtoTableKH();
        addRowtoTableNV();
        addRowtoTableP();
    }

    public void close() {
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }

    public void addRowtoTableKH() {
        modelKH = (DefaultTableModel) tableKH.getModel();
        Object rowData[] = new Object[4];
        modelKH.setRowCount(0);
        for (int i = 0; i < kH.size(); i++) {
            rowData[0] = kH.get(i).getId();
            rowData[1] = kH.get(i).getTen();
            rowData[2] = kH.get(i).getCccd();
            rowData[3] = kH.get(i).getSdt();
            modelKH.addRow(rowData);
        }
    }

    public void addRowtoTableNV() {
        modelNV = (DefaultTableModel) tableNV.getModel();
        Object rowData[] = new Object[5];
        modelNV.setRowCount(0);
        for (int i = 0; i < nV.size(); i++) {
            rowData[0] = nV.get(i).getId();
            rowData[1] = nV.get(i).getTen();
            rowData[2] = nV.get(i).getChucVu();
            rowData[3] = nV.get(i).getCccd();
            rowData[4] = nV.get(i).getSdt();
            modelNV.addRow(rowData);
        }
    }

    public void addRowtoTableP() {
        modelPh = (DefaultTableModel) tablePh.getModel();
        Object rowData[] = new Object[4];
        modelPh.setRowCount(0);
        for (int i = 0; i < phong.size(); i++) {
            rowData[0] = phong.get(i).getMaPhong();
            rowData[1] = phong.get(i).getLoaiPhong();
            rowData[2] = phong.get(i).getTrangThai();
            rowData[3] = phong.get(i).getGiaPhong();
            modelPh.addRow(rowData);
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

        thongTinNV = new javax.swing.JLabel();
        thongTinNV1 = new javax.swing.JLabel();
        tenNV = new javax.swing.JLabel();
        txtTenNV = new javax.swing.JLabel();
        maNV = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JLabel();
        chucVu = new javax.swing.JLabel();
        txtChucVu = new javax.swing.JLabel();
        tacVuChinh = new javax.swing.JLabel();
        tacVuChinh1 = new javax.swing.JLabel();
        thuePhong = new javax.swing.JLabel();
        timKiem = new javax.swing.JLabel();
        themNV = new javax.swing.JLabel();
        signOut = new javax.swing.JButton();
        thuePhong1 = new javax.swing.JPanel();
        lenLau34 = new javax.swing.JLabel();
        tang2 = new javax.swing.JLabel();
        phong01 = new javax.swing.JLabel();
        phong02 = new javax.swing.JLabel();
        phong03 = new javax.swing.JLabel();
        phong04 = new javax.swing.JLabel();
        phong05 = new javax.swing.JLabel();
        tang1 = new javax.swing.JLabel();
        phong06 = new javax.swing.JLabel();
        phong07 = new javax.swing.JLabel();
        phong08 = new javax.swing.JLabel();
        phong09 = new javax.swing.JLabel();
        phong10 = new javax.swing.JLabel();
        thuePhong2 = new javax.swing.JPanel();
        xuongLau12 = new javax.swing.JLabel();
        tang3 = new javax.swing.JLabel();
        phong1 = new javax.swing.JLabel();
        phong2 = new javax.swing.JLabel();
        phong3 = new javax.swing.JLabel();
        phong4 = new javax.swing.JLabel();
        phong5 = new javax.swing.JLabel();
        tang4 = new javax.swing.JLabel();
        phong6 = new javax.swing.JLabel();
        phong7 = new javax.swing.JLabel();
        phong8 = new javax.swing.JLabel();
        phong9 = new javax.swing.JLabel();
        phong11 = new javax.swing.JLabel();
        thongTinPhong = new javax.swing.JPanel();
        thongtinPhong = new javax.swing.JLabel();
        maPhong = new javax.swing.JLabel();
        gia = new javax.swing.JLabel();
        loaiPhong = new javax.swing.JLabel();
        trangThai = new javax.swing.JLabel();
        txtMaPhong = new javax.swing.JLabel();
        txtLoaiPhong = new javax.swing.JLabel();
        txtTrangThai = new javax.swing.JLabel();
        txtGia = new javax.swing.JLabel();
        btnThuePhong = new javax.swing.JLabel();
        thongtinKH = new javax.swing.JLabel();
        hoTen = new javax.swing.JLabel();
        CCCD = new javax.swing.JLabel();
        SDT = new javax.swing.JLabel();
        in4KH = new javax.swing.JPanel();
        txtHoTen = new javax.swing.JTextField();
        txtCCCD = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        in4KH1 = new javax.swing.JPanel();
        txtHoTen1 = new javax.swing.JLabel();
        txtCCCD1 = new javax.swing.JLabel();
        txtSDT1 = new javax.swing.JLabel();
        btnThanhToan = new javax.swing.JLabel();
        timKiem1 = new javax.swing.JPanel();
        comboOtp = new javax.swing.JComboBox<>();
        timKiemIn4 = new javax.swing.JLabel();
        nhapThongTin = new javax.swing.JLabel();
        txtThongTin = new javax.swing.JTextField();
        btnTim = new javax.swing.JLabel();
        scrollPKH = new javax.swing.JScrollPane();
        tableKH = new javax.swing.JTable();
        scrollPphong = new javax.swing.JScrollPane();
        tablePh = new javax.swing.JTable();
        scrollPNV = new javax.swing.JScrollPane();
        tableNV = new javax.swing.JTable();
        backgroundKH = new javax.swing.JLabel();
        themNV1 = new javax.swing.JPanel();
        hoTenNV = new javax.swing.JLabel();
        chucVU = new javax.swing.JLabel();
        soCCCDNV = new javax.swing.JLabel();
        sDTNV = new javax.swing.JLabel();
        matKhau = new javax.swing.JLabel();
        txtHTNV = new javax.swing.JTextField();
        txtChucVU = new javax.swing.JTextField();
        txtCCCDNV = new javax.swing.JTextField();
        txtSDTNV = new javax.swing.JTextField();
        txtMatKhau = new javax.swing.JTextField();
        btnThemNV = new javax.swing.JLabel();
        backGround = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Làm ziệc đi");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        getContentPane().setLayout(null);

        thongTinNV.setBackground(new java.awt.Color(51, 51, 255));
        thongTinNV.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        thongTinNV.setForeground(new java.awt.Color(255, 255, 255));
        thongTinNV.setText("   THÔNG TIN NHÂN VIÊN");
        thongTinNV.setToolTipText("");
        thongTinNV.setOpaque(true);
        getContentPane().add(thongTinNV);
        thongTinNV.setBounds(0, 0, 380, 80);

        thongTinNV1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        thongTinNV1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(thongTinNV1);
        thongTinNV1.setBounds(0, 70, 380, 210);

        tenNV.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tenNV.setText("    Tên nhân viên:");
        tenNV.setToolTipText("");
        getContentPane().add(tenNV);
        tenNV.setBounds(0, 80, 380, 65);

        txtTenNV.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(txtTenNV);
        txtTenNV.setBounds(150, 95, 200, 30);

        maNV.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        maNV.setText("    Mã nhân viên:");
        getContentPane().add(maNV);
        maNV.setBounds(0, 145, 380, 65);

        txtMaNV.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(txtMaNV);
        txtMaNV.setBounds(150, 160, 200, 30);

        chucVu.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        chucVu.setText("    Chức vụ:");
        getContentPane().add(chucVu);
        chucVu.setBounds(0, 210, 380, 65);

        txtChucVu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(txtChucVu);
        txtChucVu.setBounds(150, 226, 200, 30);

        tacVuChinh.setBackground(new java.awt.Color(51, 51, 255));
        tacVuChinh.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        tacVuChinh.setForeground(new java.awt.Color(255, 255, 255));
        tacVuChinh.setText("             CHỨC NĂNG");
        tacVuChinh.setToolTipText("");
        tacVuChinh.setOpaque(true);
        getContentPane().add(tacVuChinh);
        tacVuChinh.setBounds(0, 340, 380, 80);

        tacVuChinh1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tacVuChinh1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(tacVuChinh1);
        tacVuChinh1.setBounds(0, 410, 380, 240);

        thuePhong.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        thuePhong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        thuePhong.setText("THUÊ PHÒNG");
        thuePhong.setToolTipText("");
        thuePhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                thuePhongMouseClicked(evt);
            }
        });
        getContentPane().add(thuePhong);
        thuePhong.setBounds(0, 420, 380, 76);

        timKiem.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        timKiem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timKiem.setText("TÌM KIẾM");
        timKiem.setToolTipText("");
        timKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                timKiemMouseClicked(evt);
            }
        });
        getContentPane().add(timKiem);
        timKiem.setBounds(0, 496, 380, 76);

        themNV.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        themNV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        themNV.setText("THÊM NHÂN VIÊN");
        themNV.setToolTipText("");
        themNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                themNVMouseClicked(evt);
            }
        });
        getContentPane().add(themNV);
        themNV.setBounds(0, 572, 380, 76);

        signOut.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        signOut.setText("THOÁT CA TRỰC");
        signOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signOutActionPerformed(evt);
            }
        });
        getContentPane().add(signOut);
        signOut.setBounds(30, 930, 200, 40);

        thuePhong1.setBackground(new java.awt.Color(255, 255, 255));
        thuePhong1.setLayout(null);

        lenLau34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/managehotelbooking/Hinh/go-upstairs.png"))); // NOI18N
        lenLau34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lenLau34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lenLau34MouseClicked(evt);
            }
        });
        thuePhong1.add(lenLau34);
        lenLau34.setBounds(1120, 75, 75, 75);

        tang2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        tang2.setText("      TẦNG 2");
        tang2.setToolTipText("");
        thuePhong1.add(tang2);
        tang2.setBounds(0, 200, 150, 50);

        phong01.setBackground(new java.awt.Color(50, 205, 50));
        phong01.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        phong01.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        phong01.setText("PHÒNG 201");
        phong01.setToolTipText("");
        phong01.setOpaque(true);
        phong01.setRequestFocusEnabled(false);
        phong01.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong01MouseClicked(evt);
            }
        });
        thuePhong1.add(phong01);
        phong01.setBounds(150, 250, 200, 200);

        phong02.setBackground(new java.awt.Color(50, 205, 50));
        phong02.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        phong02.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        phong02.setText("PHÒNG 202");
        phong02.setToolTipText("");
        phong02.setOpaque(true);
        phong02.setRequestFocusEnabled(false);
        phong02.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong02MouseClicked(evt);
            }
        });
        thuePhong1.add(phong02);
        phong02.setBounds(400, 250, 200, 200);

        phong03.setBackground(new java.awt.Color(50, 205, 50));
        phong03.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        phong03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        phong03.setText("PHÒNG 203");
        phong03.setToolTipText("");
        phong03.setOpaque(true);
        phong03.setRequestFocusEnabled(false);
        phong03.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong03MouseClicked(evt);
            }
        });
        thuePhong1.add(phong03);
        phong03.setBounds(650, 250, 200, 200);

        phong04.setBackground(new java.awt.Color(50, 205, 50));
        phong04.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        phong04.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        phong04.setText("PHÒNG 204");
        phong04.setToolTipText("");
        phong04.setOpaque(true);
        phong04.setRequestFocusEnabled(false);
        phong04.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong04MouseClicked(evt);
            }
        });
        thuePhong1.add(phong04);
        phong04.setBounds(900, 250, 200, 200);

        phong05.setBackground(new java.awt.Color(50, 205, 50));
        phong05.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        phong05.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        phong05.setText("PHÒNG 205");
        phong05.setToolTipText("");
        phong05.setOpaque(true);
        phong05.setRequestFocusEnabled(false);
        phong05.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong05MouseClicked(evt);
            }
        });
        thuePhong1.add(phong05);
        phong05.setBounds(1150, 250, 200, 200);

        tang1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        tang1.setText("      TẦNG 1");
        tang1.setToolTipText("");
        thuePhong1.add(tang1);
        tang1.setBounds(0, 550, 150, 50);

        phong06.setBackground(new java.awt.Color(50, 205, 50));
        phong06.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        phong06.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        phong06.setText("PHÒNG 101");
        phong06.setToolTipText("");
        phong06.setOpaque(true);
        phong06.setRequestFocusEnabled(false);
        phong06.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong06MouseClicked(evt);
            }
        });
        thuePhong1.add(phong06);
        phong06.setBounds(150, 650, 200, 200);

        phong07.setBackground(new java.awt.Color(50, 205, 50));
        phong07.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        phong07.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        phong07.setText("PHÒNG 102");
        phong07.setToolTipText("");
        phong07.setOpaque(true);
        phong07.setRequestFocusEnabled(false);
        phong07.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong07MouseClicked(evt);
            }
        });
        thuePhong1.add(phong07);
        phong07.setBounds(400, 650, 200, 200);

        phong08.setBackground(new java.awt.Color(50, 205, 50));
        phong08.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        phong08.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        phong08.setText("PHÒNG 103");
        phong08.setToolTipText("");
        phong08.setOpaque(true);
        phong08.setRequestFocusEnabled(false);
        phong08.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong08MouseClicked(evt);
            }
        });
        thuePhong1.add(phong08);
        phong08.setBounds(650, 650, 200, 200);

        phong09.setBackground(new java.awt.Color(50, 205, 50));
        phong09.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        phong09.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        phong09.setText("PHÒNG 104");
        phong09.setToolTipText("");
        phong09.setOpaque(true);
        phong09.setRequestFocusEnabled(false);
        phong09.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong09MouseClicked(evt);
            }
        });
        thuePhong1.add(phong09);
        phong09.setBounds(900, 650, 200, 200);

        phong10.setBackground(new java.awt.Color(50, 205, 50));
        phong10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        phong10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        phong10.setText("PHÒNG 105");
        phong10.setToolTipText("");
        phong10.setOpaque(true);
        phong10.setRequestFocusEnabled(false);
        phong10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong10MouseClicked(evt);
            }
        });
        thuePhong1.add(phong10);
        phong10.setBounds(1150, 650, 200, 200);

        getContentPane().add(thuePhong1);
        thuePhong1.setBounds(435, 60, 1400, 900);

        thuePhong2.setBackground(new java.awt.Color(255, 255, 255));
        thuePhong2.setLayout(null);

        xuongLau12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/managehotelbooking/Hinh/downstairs.png"))); // NOI18N
        xuongLau12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        xuongLau12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                xuongLau12MouseClicked(evt);
            }
        });
        thuePhong2.add(xuongLau12);
        xuongLau12.setBounds(1230, 75, 75, 75);

        tang3.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        tang3.setText("      TẦNG 4");
        tang3.setToolTipText("");
        thuePhong2.add(tang3);
        tang3.setBounds(0, 200, 150, 50);

        phong1.setBackground(new java.awt.Color(50, 205, 50));
        phong1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        phong1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        phong1.setText("PHÒNG 401");
        phong1.setToolTipText("");
        phong1.setOpaque(true);
        phong1.setRequestFocusEnabled(false);
        phong1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong1MouseClicked(evt);
            }
        });
        thuePhong2.add(phong1);
        phong1.setBounds(150, 250, 200, 200);

        phong2.setBackground(new java.awt.Color(50, 205, 50));
        phong2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        phong2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        phong2.setText("PHÒNG 402");
        phong2.setToolTipText("");
        phong2.setOpaque(true);
        phong2.setRequestFocusEnabled(false);
        phong2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong2MouseClicked(evt);
            }
        });
        thuePhong2.add(phong2);
        phong2.setBounds(400, 250, 200, 200);

        phong3.setBackground(new java.awt.Color(50, 205, 50));
        phong3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        phong3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        phong3.setText("PHÒNG 403");
        phong3.setToolTipText("");
        phong3.setOpaque(true);
        phong3.setRequestFocusEnabled(false);
        phong3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong3MouseClicked(evt);
            }
        });
        thuePhong2.add(phong3);
        phong3.setBounds(650, 250, 200, 200);

        phong4.setBackground(new java.awt.Color(50, 205, 50));
        phong4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        phong4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        phong4.setText("PHÒNG 404");
        phong4.setToolTipText("");
        phong4.setOpaque(true);
        phong4.setRequestFocusEnabled(false);
        phong4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong4MouseClicked(evt);
            }
        });
        thuePhong2.add(phong4);
        phong4.setBounds(900, 250, 200, 200);

        phong5.setBackground(new java.awt.Color(50, 205, 50));
        phong5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        phong5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        phong5.setText("PHÒNG 405");
        phong5.setToolTipText("");
        phong5.setOpaque(true);
        phong5.setRequestFocusEnabled(false);
        phong5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong5MouseClicked(evt);
            }
        });
        thuePhong2.add(phong5);
        phong5.setBounds(1150, 250, 200, 200);

        tang4.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        tang4.setText("      TẦNG 3");
        tang4.setToolTipText("");
        thuePhong2.add(tang4);
        tang4.setBounds(0, 550, 150, 50);

        phong6.setBackground(new java.awt.Color(50, 205, 50));
        phong6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        phong6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        phong6.setText("PHÒNG 301");
        phong6.setToolTipText("");
        phong6.setOpaque(true);
        phong6.setRequestFocusEnabled(false);
        phong6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong6MouseClicked(evt);
            }
        });
        thuePhong2.add(phong6);
        phong6.setBounds(150, 650, 200, 200);

        phong7.setBackground(new java.awt.Color(50, 205, 50));
        phong7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        phong7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        phong7.setText("PHÒNG 302");
        phong7.setToolTipText("");
        phong7.setOpaque(true);
        phong7.setRequestFocusEnabled(false);
        phong7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong7MouseClicked(evt);
            }
        });
        thuePhong2.add(phong7);
        phong7.setBounds(400, 650, 200, 200);

        phong8.setBackground(new java.awt.Color(50, 205, 50));
        phong8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        phong8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        phong8.setText("PHÒNG 303");
        phong8.setToolTipText("");
        phong8.setOpaque(true);
        phong8.setRequestFocusEnabled(false);
        phong8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong8MouseClicked(evt);
            }
        });
        thuePhong2.add(phong8);
        phong8.setBounds(650, 650, 200, 200);

        phong9.setBackground(new java.awt.Color(50, 205, 50));
        phong9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        phong9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        phong9.setText("PHÒNG 304");
        phong9.setToolTipText("");
        phong9.setOpaque(true);
        phong9.setRequestFocusEnabled(false);
        phong9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong9MouseClicked(evt);
            }
        });
        thuePhong2.add(phong9);
        phong9.setBounds(900, 650, 200, 200);

        phong11.setBackground(new java.awt.Color(50, 205, 50));
        phong11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        phong11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        phong11.setText("PHÒNG 305");
        phong11.setToolTipText("");
        phong11.setOpaque(true);
        phong11.setRequestFocusEnabled(false);
        phong11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong11MouseClicked(evt);
            }
        });
        thuePhong2.add(phong11);
        phong11.setBounds(1150, 650, 200, 200);

        getContentPane().add(thuePhong2);
        thuePhong2.setBounds(435, 60, 1400, 900);

        thongTinPhong.setBackground(new java.awt.Color(255, 255, 255));
        thongTinPhong.setLayout(null);

        thongtinPhong.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        thongtinPhong.setText("THÔNG TIN PHÒNG");
        thongTinPhong.add(thongtinPhong);
        thongtinPhong.setBounds(150, 40, 410, 140);

        maPhong.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        maPhong.setText("Mã Phòng:");
        thongTinPhong.add(maPhong);
        maPhong.setBounds(120, 160, 170, 80);

        gia.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        gia.setText("Giá tiền:");
        thongTinPhong.add(gia);
        gia.setBounds(120, 470, 170, 80);

        loaiPhong.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        loaiPhong.setText("Loại Phòng:");
        thongTinPhong.add(loaiPhong);
        loaiPhong.setBounds(120, 260, 170, 80);

        trangThai.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        trangThai.setText("Trạng Thái:");
        thongTinPhong.add(trangThai);
        trangThai.setBounds(120, 370, 170, 80);

        txtMaPhong.setBackground(new java.awt.Color(255, 255, 255));
        txtMaPhong.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtMaPhong.setOpaque(true);
        thongTinPhong.add(txtMaPhong);
        txtMaPhong.setBounds(340, 180, 180, 40);

        txtLoaiPhong.setBackground(new java.awt.Color(255, 255, 255));
        txtLoaiPhong.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtLoaiPhong.setOpaque(true);
        thongTinPhong.add(txtLoaiPhong);
        txtLoaiPhong.setBounds(340, 277, 180, 40);

        txtTrangThai.setBackground(new java.awt.Color(255, 255, 255));
        txtTrangThai.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTrangThai.setOpaque(true);
        thongTinPhong.add(txtTrangThai);
        txtTrangThai.setBounds(340, 390, 180, 40);

        txtGia.setBackground(new java.awt.Color(255, 255, 255));
        txtGia.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtGia.setOpaque(true);
        thongTinPhong.add(txtGia);
        txtGia.setBounds(340, 487, 180, 40);

        btnThuePhong.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        btnThuePhong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnThuePhong.setText("Thuê Phòng");
        btnThuePhong.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnThuePhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThuePhongMouseClicked(evt);
            }
        });
        thongTinPhong.add(btnThuePhong);
        btnThuePhong.setBounds(570, 700, 180, 60);

        thongtinKH.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        thongtinKH.setText("THÔNG TIN kHÁCH HÀNG");
        thongTinPhong.add(thongtinKH);
        thongtinKH.setBounds(790, 40, 440, 140);

        hoTen.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        hoTen.setText("Họ Tên Khách Hàng:");
        thongTinPhong.add(hoTen);
        hoTen.setBounds(760, 160, 190, 80);

        CCCD.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CCCD.setText("Căn Cước Công Dân:");
        thongTinPhong.add(CCCD);
        CCCD.setBounds(760, 260, 190, 80);

        SDT.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        SDT.setText("Số Điện Thoại:");
        thongTinPhong.add(SDT);
        SDT.setBounds(760, 370, 190, 80);

        in4KH.setBackground(new java.awt.Color(255, 255, 255));
        in4KH.setLayout(null);

        txtHoTen.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtHoTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoTenActionPerformed(evt);
            }
        });
        in4KH.add(txtHoTen);
        txtHoTen.setBounds(0, 20, 200, 30);

        txtCCCD.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        in4KH.add(txtCCCD);
        txtCCCD.setBounds(0, 113, 200, 30);

        txtSDT.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        in4KH.add(txtSDT);
        txtSDT.setBounds(0, 217, 200, 30);

        thongTinPhong.add(in4KH);
        in4KH.setBounds(970, 170, 370, 280);

        in4KH1.setBackground(new java.awt.Color(255, 255, 255));
        in4KH1.setLayout(null);

        txtHoTen1.setBackground(new java.awt.Color(255, 255, 255));
        txtHoTen1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtHoTen1.setOpaque(true);
        in4KH1.add(txtHoTen1);
        txtHoTen1.setBounds(0, 10, 180, 40);

        txtCCCD1.setBackground(new java.awt.Color(255, 255, 255));
        txtCCCD1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCCCD1.setOpaque(true);
        in4KH1.add(txtCCCD1);
        txtCCCD1.setBounds(0, 113, 180, 40);

        txtSDT1.setBackground(new java.awt.Color(255, 255, 255));
        txtSDT1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSDT1.setOpaque(true);
        in4KH1.add(txtSDT1);
        txtSDT1.setBounds(0, 218, 180, 40);

        thongTinPhong.add(in4KH1);
        in4KH1.setBounds(970, 170, 370, 280);

        btnThanhToan.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        btnThanhToan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThanhToanMouseClicked(evt);
            }
        });
        thongTinPhong.add(btnThanhToan);
        btnThanhToan.setBounds(900, 700, 180, 60);

        getContentPane().add(thongTinPhong);
        thongTinPhong.setBounds(435, 60, 1400, 900);

        timKiem1.setBackground(new java.awt.Color(255, 255, 255));
        timKiem1.setToolTipText("");
        timKiem1.setLayout(null);

        comboOtp.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        comboOtp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Khach Hang", "Nhan Vien", "Phong" }));
        comboOtp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboOtpActionPerformed(evt);
            }
        });
        timKiem1.add(comboOtp);
        comboOtp.setBounds(550, 130, 220, 40);

        timKiemIn4.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        timKiemIn4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timKiemIn4.setText("TÌM KIẾM THÔNG TIN");
        timKiem1.add(timKiemIn4);
        timKiemIn4.setBounds(0, 30, 550, 120);

        nhapThongTin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nhapThongTin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nhapThongTin.setText("Nhập thông tin cần tìm:");
        timKiem1.add(nhapThongTin);
        nhapThongTin.setBounds(300, 230, 270, 50);

        txtThongTin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtThongTinKeyPressed(evt);
            }
        });
        timKiem1.add(txtThongTin);
        txtThongTin.setBounds(565, 233, 270, 40);

        btnTim.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnTim.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTim.setText("Tìm");
        btnTim.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnTim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTimMouseClicked(evt);
            }
        });
        timKiem1.add(btnTim);
        btnTim.setBounds(855, 232, 100, 40);

        scrollPKH.setBackground(new java.awt.Color(255, 255, 255));
        scrollPKH.setBorder(null);

        tableKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ma Khach Hang", "Ho Ten Khach Hang", "Can Cuoc Cong Dan", "So Dien Thoai"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPKH.setViewportView(tableKH);
        if (tableKH.getColumnModel().getColumnCount() > 0) {
            tableKH.getColumnModel().getColumn(0).setResizable(false);
            tableKH.getColumnModel().getColumn(1).setResizable(false);
            tableKH.getColumnModel().getColumn(2).setResizable(false);
            tableKH.getColumnModel().getColumn(3).setResizable(false);
        }

        timKiem1.add(scrollPKH);
        scrollPKH.setBounds(185, 290, 1010, 430);

        scrollPphong.setBackground(new java.awt.Color(255, 255, 255));
        scrollPphong.setBorder(null);

        tablePh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ma Phong", "Loai Phong", "Trang Thai", "Gia Tien"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPphong.setViewportView(tablePh);
        if (tablePh.getColumnModel().getColumnCount() > 0) {
            tablePh.getColumnModel().getColumn(0).setResizable(false);
            tablePh.getColumnModel().getColumn(1).setResizable(false);
            tablePh.getColumnModel().getColumn(2).setResizable(false);
            tablePh.getColumnModel().getColumn(3).setResizable(false);
        }

        timKiem1.add(scrollPphong);
        scrollPphong.setBounds(185, 290, 1010, 430);

        scrollPNV.setBackground(new java.awt.Color(255, 255, 255));
        scrollPNV.setBorder(null);

        tableNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ma Nhan Vien", "Ho Ten Nhan Vien", "Chuc Vu", "Can Cuoc Cong Dan", "So Dien Thoai"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPNV.setViewportView(tableNV);
        if (tableNV.getColumnModel().getColumnCount() > 0) {
            tableNV.getColumnModel().getColumn(0).setResizable(false);
            tableNV.getColumnModel().getColumn(1).setResizable(false);
            tableNV.getColumnModel().getColumn(2).setResizable(false);
            tableNV.getColumnModel().getColumn(3).setResizable(false);
            tableNV.getColumnModel().getColumn(4).setResizable(false);
        }

        timKiem1.add(scrollPNV);
        scrollPNV.setBounds(185, 290, 1010, 430);

        backgroundKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/managehotelbooking/Hinh/wp4581485.jpg"))); // NOI18N
        backgroundKH.setToolTipText("");
        timKiem1.add(backgroundKH);
        backgroundKH.setBounds(125, 200, 1150, 600);

        getContentPane().add(timKiem1);
        timKiem1.setBounds(435, 60, 1400, 900);

        themNV1.setBackground(new java.awt.Color(255, 255, 255));
        themNV1.setLayout(null);

        hoTenNV.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        hoTenNV.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        hoTenNV.setText("Họ Tên Nhân Viên:");
        hoTenNV.setToolTipText("");
        themNV1.add(hoTenNV);
        hoTenNV.setBounds(150, 120, 250, 60);

        chucVU.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        chucVU.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        chucVU.setText("Chức vụ:");
        chucVU.setToolTipText("");
        themNV1.add(chucVU);
        chucVU.setBounds(150, 200, 250, 60);

        soCCCDNV.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        soCCCDNV.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        soCCCDNV.setText("Số CCCD:");
        soCCCDNV.setToolTipText("");
        themNV1.add(soCCCDNV);
        soCCCDNV.setBounds(150, 280, 250, 60);

        sDTNV.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        sDTNV.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sDTNV.setText("Số điện thoại:");
        sDTNV.setToolTipText("");
        themNV1.add(sDTNV);
        sDTNV.setBounds(150, 360, 250, 60);

        matKhau.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        matKhau.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        matKhau.setText("Mật khẩu:");
        matKhau.setToolTipText("");
        themNV1.add(matKhau);
        matKhau.setBounds(150, 440, 250, 60);

        txtHTNV.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        themNV1.add(txtHTNV);
        txtHTNV.setBounds(450, 130, 250, 50);

        txtChucVU.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        themNV1.add(txtChucVU);
        txtChucVU.setBounds(450, 210, 250, 50);

        txtCCCDNV.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        themNV1.add(txtCCCDNV);
        txtCCCDNV.setBounds(450, 290, 250, 50);

        txtSDTNV.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        themNV1.add(txtSDTNV);
        txtSDTNV.setBounds(450, 370, 250, 50);

        txtMatKhau.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        themNV1.add(txtMatKhau);
        txtMatKhau.setBounds(450, 450, 250, 50);

        btnThemNV.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        btnThemNV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnThemNV.setText("Thêm Nhân Viên");
        btnThemNV.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnThemNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemNVMouseClicked(evt);
            }
        });
        themNV1.add(btnThemNV);
        btnThemNV.setBounds(900, 600, 230, 60);

        getContentPane().add(themNV1);
        themNV1.setBounds(435, 60, 1400, 900);

        backGround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/managehotelbooking/Hinh/wp4581485.jpg"))); // NOI18N
        backGround.setPreferredSize(new java.awt.Dimension(1920, 1080));
        getContentPane().add(backGround);
        backGround.setBounds(0, 0, 1980, 1080);

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void signOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signOutActionPerformed
        MainPage mpFrame = new MainPage();
        Login lFrame = new Login();

        lFrame.setVisible(true);
        close();
    }//GEN-LAST:event_signOutActionPerformed

    private void thuePhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_thuePhongMouseClicked
        thuePhong1.setVisible(true);
        thuePhong2.setVisible(false);
        timKiem1.setVisible(false);
        thongTinPhong.setVisible(false);
        themNV1.setVisible(false);
    }//GEN-LAST:event_thuePhongMouseClicked

    private void lenLau34MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lenLau34MouseClicked
        thuePhong1.setVisible(false);
        thuePhong2.setVisible(true);
        timKiem1.setVisible(false);
        thongTinPhong.setVisible(false);
        themNV1.setVisible(false);
    }//GEN-LAST:event_lenLau34MouseClicked

    private void xuongLau12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xuongLau12MouseClicked
        thuePhong1.setVisible(true);
        thuePhong2.setVisible(false);
        timKiem1.setVisible(false);
        thongTinPhong.setVisible(false);
        themNV1.setVisible(false);
    }//GEN-LAST:event_xuongLau12MouseClicked

    private void timKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timKiemMouseClicked
        thuePhong1.setVisible(false);
        thuePhong2.setVisible(false);
        timKiem1.setVisible(true);
        thongTinPhong.setVisible(false);
        themNV1.setVisible(false);
    }//GEN-LAST:event_timKiemMouseClicked

    private void themNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_themNVMouseClicked
        MainPage mpFrame = new MainPage();

        if (jlbChucVu.getText().equals("Quan ly")) {
            thuePhong1.setVisible(false);
            thuePhong2.setVisible(false);
            timKiem1.setVisible(false);
            thongTinPhong.setVisible(false);
            themNV1.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(mpFrame, "Bạn không có quyền thêm nhân viên");
        }


    }//GEN-LAST:event_themNVMouseClicked

    private void phong06MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong06MouseClicked
        thuePhong1.setVisible(false);
        thuePhong2.setVisible(false);
        timKiem1.setVisible(false);
//        in4KH.setVisible(true);
//        in4KH1.setVisible(false);

        String maPhong = "101";

        for (Phong item : phong) {
            if (maPhong.equals(item.getMaPhong())) {
                txtMaPhong.setText(item.getMaPhong());
                txtLoaiPhong.setText(item.getLoaiPhong());
                txtTrangThai.setText(item.getTrangThai());
                txtGia.setText(String.valueOf(item.getGiaPhong()));
                in4KH.setVisible(true);

                if (item.getTrangThai().equals("Da dat")) {
                    for (DatPhong items : dP) {
                        if (maPhong.equals(items.getMaPhong())) {
                            for (KhachHang itemss : kH) {
                                if (items.getMaKhachHang().equals(itemss.getId())) {
                                    in4KH.setVisible(false);
                                    in4KH1.setVisible(true);
                                    btnThuePhong.setVisible(false);
                                    btnThanhToan.setVisible(true);
                                    txtHoTen1.setText(itemss.getTen());
                                    txtCCCD1.setText(itemss.getCccd());
                                    txtSDT1.setText(itemss.getSdt());
                                }
                            }
                        }
                    }
                    break;
                }
                if (item.getTrangThai().equals("Trong")) {
                    in4KH.setVisible(true);
                    in4KH1.setVisible(false);
                    btnThuePhong.setVisible(true);
                    btnThanhToan.setVisible(false);
                }

            }
        }

        thongTinPhong.setVisible(true);
    }//GEN-LAST:event_phong06MouseClicked

    private void phong01MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong01MouseClicked
        thuePhong1.setVisible(false);
        thuePhong2.setVisible(false);
        timKiem1.setVisible(false);

        String maPhong = "201";

        for (Phong item : phong) {
            if (maPhong.equals(item.getMaPhong())) {
                txtMaPhong.setText(item.getMaPhong());
                txtLoaiPhong.setText(item.getLoaiPhong());
                txtTrangThai.setText(item.getTrangThai());
                txtGia.setText(String.valueOf(item.getGiaPhong()));

                if (item.getTrangThai().equals("Da dat")) {
                    for (DatPhong items : dP) {
                        if (maPhong.equals(items.getMaPhong())) {
                            for (KhachHang itemss : kH) {
                                if (items.getMaKhachHang().equals(itemss.getId())) {
                                    in4KH.setVisible(false);
                                    in4KH1.setVisible(true);
                                    btnThuePhong.setVisible(false);
                                    btnThanhToan.setVisible(true);
                                    txtHoTen1.setText(itemss.getTen());
                                    txtCCCD1.setText(itemss.getCccd());
                                    txtSDT1.setText(itemss.getSdt());
                                }
                            }
                        }
                    }
                    break;
                } else {
                    txtHoTen.setText("");
                    txtCCCD.setText("");
                    txtSDT.setText("");
                    in4KH.setVisible(true);
                    in4KH1.setVisible(false);
                    btnThuePhong.setVisible(true);
                    btnThanhToan.setVisible(false);
                }
            }
        }

        thongTinPhong.setVisible(true);
    }//GEN-LAST:event_phong01MouseClicked

    private void phong02MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong02MouseClicked
        thuePhong1.setVisible(false);
        thuePhong2.setVisible(false);
        timKiem1.setVisible(false);

        String maPhong = "202";

        for (Phong item : phong) {
            if (maPhong.equals(item.getMaPhong())) {
                txtMaPhong.setText(item.getMaPhong());
                txtLoaiPhong.setText(item.getLoaiPhong());
                txtTrangThai.setText(item.getTrangThai());
                txtGia.setText(String.valueOf(item.getGiaPhong()));

                if (item.getTrangThai().equals("Da dat")) {
                    for (DatPhong items : dP) {
                        if (maPhong.equals(items.getMaPhong())) {
                            for (KhachHang itemss : kH) {
                                if (items.getMaKhachHang().equals(itemss.getId())) {
                                    in4KH.setVisible(false);
                                    in4KH1.setVisible(true);
                                    btnThuePhong.setVisible(false);
                                    btnThanhToan.setVisible(true);
                                    txtHoTen1.setText(itemss.getTen());
                                    txtCCCD1.setText(itemss.getCccd());
                                    txtSDT1.setText(itemss.getSdt());
                                }
                            }
                        }
                    }
                    break;
                } else {
                    txtHoTen.setText("");
                    txtCCCD.setText("");
                    txtSDT.setText("");
                    txtHoTen1.setText("");
                    txtCCCD1.setText("");
                    txtSDT1.setText("");
                    in4KH.setVisible(true);
                    in4KH1.setVisible(false);
                    btnThuePhong.setVisible(true);
                    btnThanhToan.setVisible(false);
                }
            }
        }

        thongTinPhong.setVisible(true);
    }//GEN-LAST:event_phong02MouseClicked

    private void phong07MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong07MouseClicked
        thuePhong1.setVisible(false);
        thuePhong2.setVisible(false);
        timKiem1.setVisible(false);

        String maPhong = "102";

        for (Phong item : phong) {
            if (maPhong.equals(item.getMaPhong())) {
                txtMaPhong.setText(item.getMaPhong());
                txtLoaiPhong.setText(item.getLoaiPhong());
                txtTrangThai.setText(item.getTrangThai());
                txtGia.setText(String.valueOf(item.getGiaPhong()));

                if (item.getTrangThai().equals("Da dat")) {
                    for (DatPhong items : dP) {
                        if (maPhong.equals(items.getMaPhong())) {
                            for (KhachHang itemss : kH) {
                                if (items.getMaKhachHang().equals(itemss.getId())) {
                                    in4KH.setVisible(false);
                                    in4KH1.setVisible(true);
                                    btnThuePhong.setVisible(false);
                                    btnThanhToan.setVisible(true);
                                    txtHoTen1.setText(itemss.getTen());
                                    txtCCCD1.setText(itemss.getCccd());
                                    txtSDT1.setText(itemss.getSdt());
                                }
                            }
                        }
                    }
                    break;
                } else {
                    txtHoTen.setText("");
                    txtCCCD.setText("");
                    txtSDT.setText("");
                    txtHoTen1.setText("");
                    txtCCCD1.setText("");
                    txtSDT1.setText("");
                    in4KH.setVisible(true);
                    in4KH1.setVisible(false);
                    btnThuePhong.setVisible(true);
                    btnThanhToan.setVisible(false);
                }
            }
        }

        thongTinPhong.setVisible(true);
    }//GEN-LAST:event_phong07MouseClicked

    private void phong08MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong08MouseClicked
        thuePhong1.setVisible(false);
        thuePhong2.setVisible(false);
        timKiem1.setVisible(false);

        String maPhong = "103";

        for (Phong item : phong) {
            if (maPhong.equals(item.getMaPhong())) {
                txtMaPhong.setText(item.getMaPhong());
                txtLoaiPhong.setText(item.getLoaiPhong());
                txtTrangThai.setText(item.getTrangThai());
                txtGia.setText(String.valueOf(item.getGiaPhong()));

                if (item.getTrangThai().equals("Da dat")) {
                    for (DatPhong items : dP) {
                        if (maPhong.equals(items.getMaPhong())) {
                            for (KhachHang itemss : kH) {
                                if (items.getMaKhachHang().equals(itemss.getId())) {
                                    in4KH.setVisible(false);
                                    in4KH1.setVisible(true);
                                    btnThuePhong.setVisible(false);
                                    btnThanhToan.setVisible(true);
                                    txtHoTen1.setText(itemss.getTen());
                                    txtCCCD1.setText(itemss.getCccd());
                                    txtSDT1.setText(itemss.getSdt());
                                }
                            }
                        }
                    }
                    break;
                } else {
                    txtHoTen.setText("");
                    txtCCCD.setText("");
                    txtSDT.setText("");
                    txtHoTen1.setText("");
                    txtCCCD1.setText("");
                    txtSDT1.setText("");
                    in4KH.setVisible(true);
                    in4KH1.setVisible(false);
                    btnThuePhong.setVisible(true);
                    btnThanhToan.setVisible(false);
                }
            }
        }

        thongTinPhong.setVisible(true);
    }//GEN-LAST:event_phong08MouseClicked

    private void phong03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong03MouseClicked
        thuePhong1.setVisible(false);
        thuePhong2.setVisible(false);
        timKiem1.setVisible(false);

        String maPhong = "203";

        for (Phong item : phong) {
            if (maPhong.equals(item.getMaPhong())) {
                txtMaPhong.setText(item.getMaPhong());
                txtLoaiPhong.setText(item.getLoaiPhong());
                txtTrangThai.setText(item.getTrangThai());
                txtGia.setText(String.valueOf(item.getGiaPhong()));

                if (item.getTrangThai().equals("Da dat")) {
                    for (DatPhong items : dP) {
                        if (maPhong.equals(items.getMaPhong())) {
                            for (KhachHang itemss : kH) {
                                if (items.getMaKhachHang().equals(itemss.getId())) {
                                    in4KH.setVisible(false);
                                    in4KH1.setVisible(true);
                                    btnThuePhong.setVisible(false);
                                    btnThanhToan.setVisible(true);
                                    txtHoTen1.setText(itemss.getTen());
                                    txtCCCD1.setText(itemss.getCccd());
                                    txtSDT1.setText(itemss.getSdt());
                                }
                            }
                        }
                    }
                    break;
                } else {
                    txtHoTen.setText("");
                    txtCCCD.setText("");
                    txtSDT.setText("");
                    txtHoTen1.setText("");
                    txtCCCD1.setText("");
                    txtSDT1.setText("");
                    in4KH.setVisible(true);
                    in4KH1.setVisible(false);
                    btnThuePhong.setVisible(true);
                    btnThanhToan.setVisible(false);
                }
            }
        }

        thongTinPhong.setVisible(true);
    }//GEN-LAST:event_phong03MouseClicked

    private void phong04MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong04MouseClicked
        thuePhong1.setVisible(false);
        thuePhong2.setVisible(false);
        timKiem1.setVisible(false);

        String maPhong = "204";

        for (Phong item : phong) {
            if (maPhong.equals(item.getMaPhong())) {
                txtMaPhong.setText(item.getMaPhong());
                txtLoaiPhong.setText(item.getLoaiPhong());
                txtTrangThai.setText(item.getTrangThai());
                txtGia.setText(String.valueOf(item.getGiaPhong()));

                if (item.getTrangThai().equals("Da dat")) {
                    for (DatPhong items : dP) {
                        if (maPhong.equals(items.getMaPhong())) {
                            for (KhachHang itemss : kH) {
                                if (items.getMaKhachHang().equals(itemss.getId())) {
                                    in4KH.setVisible(false);
                                    in4KH1.setVisible(true);
                                    btnThuePhong.setVisible(false);
                                    btnThanhToan.setVisible(true);
                                    txtHoTen1.setText(itemss.getTen());
                                    txtCCCD1.setText(itemss.getCccd());
                                    txtSDT1.setText(itemss.getSdt());
                                }
                            }
                        }
                    }
                    break;
                } else {
                    txtHoTen.setText("");
                    txtCCCD.setText("");
                    txtSDT.setText("");
                    txtHoTen1.setText("");
                    txtCCCD1.setText("");
                    txtSDT1.setText("");
                    in4KH.setVisible(true);
                    in4KH1.setVisible(false);
                    btnThuePhong.setVisible(true);
                    btnThanhToan.setVisible(false);
                }
            }
        }

        thongTinPhong.setVisible(true);
    }//GEN-LAST:event_phong04MouseClicked

    private void phong09MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong09MouseClicked
        thuePhong1.setVisible(false);
        thuePhong2.setVisible(false);
        timKiem1.setVisible(false);

        String maPhong = "104";

        for (Phong item : phong) {
            if (maPhong.equals(item.getMaPhong())) {
                txtMaPhong.setText(item.getMaPhong());
                txtLoaiPhong.setText(item.getLoaiPhong());
                txtTrangThai.setText(item.getTrangThai());
                txtGia.setText(String.valueOf(item.getGiaPhong()));

                if (item.getTrangThai().equals("Da dat")) {
                    for (DatPhong items : dP) {
                        if (maPhong.equals(items.getMaPhong())) {
                            for (KhachHang itemss : kH) {
                                if (items.getMaKhachHang().equals(itemss.getId())) {
                                    in4KH.setVisible(false);
                                    in4KH1.setVisible(true);
                                    btnThuePhong.setVisible(false);
                                    btnThanhToan.setVisible(true);
                                    txtHoTen1.setText(itemss.getTen());
                                    txtCCCD1.setText(itemss.getCccd());
                                    txtSDT1.setText(itemss.getSdt());
                                }
                            }
                        }
                    }
                    break;
                } else {
                    txtHoTen.setText("");
                    txtCCCD.setText("");
                    txtSDT.setText("");
                    txtHoTen1.setText("");
                    txtCCCD1.setText("");
                    txtSDT1.setText("");
                    in4KH.setVisible(true);
                    in4KH1.setVisible(false);
                    btnThuePhong.setVisible(true);
                    btnThanhToan.setVisible(false);
                }
            }
        }

        thongTinPhong.setVisible(true);
    }//GEN-LAST:event_phong09MouseClicked

    private void phong05MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong05MouseClicked
        thuePhong1.setVisible(false);
        thuePhong2.setVisible(false);
        timKiem1.setVisible(false);

        String maPhong = "205";

        for (Phong item : phong) {
            if (maPhong.equals(item.getMaPhong())) {
                txtMaPhong.setText(item.getMaPhong());
                txtLoaiPhong.setText(item.getLoaiPhong());
                txtTrangThai.setText(item.getTrangThai());
                txtGia.setText(String.valueOf(item.getGiaPhong()));

                if (item.getTrangThai().equals("Da dat")) {
                    for (DatPhong items : dP) {
                        if (maPhong.equals(items.getMaPhong())) {
                            for (KhachHang itemss : kH) {
                                if (items.getMaKhachHang().equals(itemss.getId())) {
                                    in4KH.setVisible(false);
                                    in4KH1.setVisible(true);
                                    btnThuePhong.setVisible(false);
                                    btnThanhToan.setVisible(true);
                                    txtHoTen1.setText(itemss.getTen());
                                    txtCCCD1.setText(itemss.getCccd());
                                    txtSDT1.setText(itemss.getSdt());
                                }
                            }
                        }
                    }
                    break;
                } else {
                    txtHoTen.setText("");
                    txtCCCD.setText("");
                    txtSDT.setText("");
                    txtHoTen1.setText("");
                    txtCCCD1.setText("");
                    txtSDT1.setText("");
                    in4KH.setVisible(true);
                    in4KH1.setVisible(false);
                    btnThuePhong.setVisible(true);
                    btnThanhToan.setVisible(false);
                }
            }
        }

        thongTinPhong.setVisible(true);
    }//GEN-LAST:event_phong05MouseClicked

    private void phong10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong10MouseClicked
        thuePhong1.setVisible(false);
        thuePhong2.setVisible(false);
        timKiem1.setVisible(false);

        String maPhong = "105";

        for (Phong item : phong) {
            if (maPhong.equals(item.getMaPhong())) {
                txtMaPhong.setText(item.getMaPhong());
                txtLoaiPhong.setText(item.getLoaiPhong());
                txtTrangThai.setText(item.getTrangThai());
                txtGia.setText(String.valueOf(item.getGiaPhong()));

                if (item.getTrangThai().equals("Da dat")) {
                    for (DatPhong items : dP) {
                        if (maPhong.equals(items.getMaPhong())) {
                            for (KhachHang itemss : kH) {
                                if (items.getMaKhachHang().equals(itemss.getId())) {
                                    in4KH.setVisible(false);
                                    in4KH1.setVisible(true);
                                    btnThuePhong.setVisible(false);
                                    btnThanhToan.setVisible(true);
                                    txtHoTen1.setText(itemss.getTen());
                                    txtCCCD1.setText(itemss.getCccd());
                                    txtSDT1.setText(itemss.getSdt());
                                }
                            }
                        }
                    }
                    break;
                } else {
                    txtHoTen.setText("");
                    txtCCCD.setText("");
                    txtSDT.setText("");
                    txtHoTen1.setText("");
                    txtCCCD1.setText("");
                    txtSDT1.setText("");
                    in4KH.setVisible(true);
                    in4KH1.setVisible(false);
                    btnThuePhong.setVisible(true);
                    btnThanhToan.setVisible(false);
                }
            }
        }

        thongTinPhong.setVisible(true);
    }//GEN-LAST:event_phong10MouseClicked

    private void phong1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong1MouseClicked
        thuePhong1.setVisible(false);
        thuePhong2.setVisible(false);
        timKiem1.setVisible(false);
        themNV1.setVisible(false);

        String maPhong = "401";

        for (Phong item : phong) {
            if (maPhong.equals(item.getMaPhong())) {
                txtMaPhong.setText(item.getMaPhong());
                txtLoaiPhong.setText(item.getLoaiPhong());
                txtTrangThai.setText(item.getTrangThai());
                txtGia.setText(String.valueOf(item.getGiaPhong()));

                if (item.getTrangThai().equals("Da dat")) {
                    for (DatPhong items : dP) {
                        if (maPhong.equals(items.getMaPhong())) {
                            for (KhachHang itemss : kH) {
                                if (items.getMaKhachHang().equals(itemss.getId())) {
                                    in4KH.setVisible(false);
                                    in4KH1.setVisible(true);
                                    btnThuePhong.setVisible(false);
                                    btnThanhToan.setVisible(true);
                                    txtHoTen1.setText(itemss.getTen());
                                    txtCCCD1.setText(itemss.getCccd());
                                    txtSDT1.setText(itemss.getSdt());
                                }
                            }
                        }
                    }
                    break;
                } else {
                    txtHoTen.setText("");
                    txtCCCD.setText("");
                    txtSDT.setText("");
                    txtHoTen1.setText("");
                    txtCCCD1.setText("");
                    txtSDT1.setText("");
                    in4KH.setVisible(true);
                    in4KH1.setVisible(false);
                    btnThuePhong.setVisible(true);
                    btnThanhToan.setVisible(false);
                }
            }
        }

        thongTinPhong.setVisible(true);
    }//GEN-LAST:event_phong1MouseClicked

    private void phong2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong2MouseClicked
        thuePhong1.setVisible(false);
        thuePhong2.setVisible(false);
        timKiem1.setVisible(false);
        themNV1.setVisible(false);

        String maPhong = "402";

        for (Phong item : phong) {
            if (maPhong.equals(item.getMaPhong())) {
                txtMaPhong.setText(item.getMaPhong());
                txtLoaiPhong.setText(item.getLoaiPhong());
                txtTrangThai.setText(item.getTrangThai());
                txtGia.setText(String.valueOf(item.getGiaPhong()));

                if (item.getTrangThai().equals("Da dat")) {
                    for (DatPhong items : dP) {
                        if (maPhong.equals(items.getMaPhong())) {
                            for (KhachHang itemss : kH) {
                                if (items.getMaKhachHang().equals(itemss.getId())) {
                                    in4KH.setVisible(false);
                                    in4KH1.setVisible(true);
                                    btnThuePhong.setVisible(false);
                                    btnThanhToan.setVisible(true);
                                    txtHoTen1.setText(itemss.getTen());
                                    txtCCCD1.setText(itemss.getCccd());
                                    txtSDT1.setText(itemss.getSdt());
                                }
                            }
                        }
                    }
                    break;
                } else {
                    txtHoTen.setText("");
                    txtCCCD.setText("");
                    txtSDT.setText("");
                    txtHoTen1.setText("");
                    txtCCCD1.setText("");
                    txtSDT1.setText("");
                    in4KH.setVisible(true);
                    in4KH1.setVisible(false);
                    btnThuePhong.setVisible(true);
                    btnThanhToan.setVisible(false);
                }
            }
        }

        thongTinPhong.setVisible(true);
    }//GEN-LAST:event_phong2MouseClicked

    private void phong3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong3MouseClicked
        thuePhong1.setVisible(false);
        thuePhong2.setVisible(false);
        timKiem1.setVisible(false);
        themNV1.setVisible(false);

        String maPhong = "403";

        for (Phong item : phong) {
            if (maPhong.equals(item.getMaPhong())) {
                txtMaPhong.setText(item.getMaPhong());
                txtLoaiPhong.setText(item.getLoaiPhong());
                txtTrangThai.setText(item.getTrangThai());
                txtGia.setText(String.valueOf(item.getGiaPhong()));

                if (item.getTrangThai().equals("Da dat")) {
                    for (DatPhong items : dP) {
                        if (maPhong.equals(items.getMaPhong())) {
                            for (KhachHang itemss : kH) {
                                if (items.getMaKhachHang().equals(itemss.getId())) {
                                    in4KH.setVisible(false);
                                    in4KH1.setVisible(true);
                                    btnThuePhong.setVisible(false);
                                    btnThanhToan.setVisible(true);
                                    txtHoTen1.setText(itemss.getTen());
                                    txtCCCD1.setText(itemss.getCccd());
                                    txtSDT1.setText(itemss.getSdt());
                                }
                            }
                        }
                    }
                    break;
                } else {
                    txtHoTen.setText("");
                    txtCCCD.setText("");
                    txtSDT.setText("");
                    txtHoTen1.setText("");
                    txtCCCD1.setText("");
                    txtSDT1.setText("");
                    in4KH.setVisible(true);
                    in4KH1.setVisible(false);
                    btnThuePhong.setVisible(true);
                    btnThanhToan.setVisible(false);
                }
            }
        }

        thongTinPhong.setVisible(true);
    }//GEN-LAST:event_phong3MouseClicked

    private void phong4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong4MouseClicked
        thuePhong1.setVisible(false);
        thuePhong2.setVisible(false);
        timKiem1.setVisible(false);
        themNV1.setVisible(false);

        String maPhong = "404";

        for (Phong item : phong) {
            if (maPhong.equals(item.getMaPhong())) {
                txtMaPhong.setText(item.getMaPhong());
                txtLoaiPhong.setText(item.getLoaiPhong());
                txtTrangThai.setText(item.getTrangThai());
                txtGia.setText(String.valueOf(item.getGiaPhong()));

                if (item.getTrangThai().equals("Da dat")) {
                    for (DatPhong items : dP) {
                        if (maPhong.equals(items.getMaPhong())) {
                            for (KhachHang itemss : kH) {
                                if (items.getMaKhachHang().equals(itemss.getId())) {
                                    in4KH.setVisible(false);
                                    in4KH1.setVisible(true);
                                    btnThuePhong.setVisible(false);
                                    btnThanhToan.setVisible(true);
                                    txtHoTen1.setText(itemss.getTen());
                                    txtCCCD1.setText(itemss.getCccd());
                                    txtSDT1.setText(itemss.getSdt());
                                }
                            }
                        }
                    }
                    break;
                } else {
                    txtHoTen.setText("");
                    txtCCCD.setText("");
                    txtSDT.setText("");
                    txtHoTen1.setText("");
                    txtCCCD1.setText("");
                    txtSDT1.setText("");
                    in4KH.setVisible(true);
                    in4KH1.setVisible(false);
                    btnThuePhong.setVisible(true);
                    btnThanhToan.setVisible(false);
                }
            }
        }

        thongTinPhong.setVisible(true);
    }//GEN-LAST:event_phong4MouseClicked

    private void phong5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong5MouseClicked
        thuePhong1.setVisible(false);
        thuePhong2.setVisible(false);
        timKiem1.setVisible(false);
        themNV1.setVisible(false);

        String maPhong = "405";

        for (Phong item : phong) {
            if (maPhong.equals(item.getMaPhong())) {
                txtMaPhong.setText(item.getMaPhong());
                txtLoaiPhong.setText(item.getLoaiPhong());
                txtTrangThai.setText(item.getTrangThai());
                txtGia.setText(String.valueOf(item.getGiaPhong()));

                if (item.getTrangThai().equals("Da dat")) {
                    for (DatPhong items : dP) {
                        if (maPhong.equals(items.getMaPhong())) {
                            for (KhachHang itemss : kH) {
                                if (items.getMaKhachHang().equals(itemss.getId())) {
                                    in4KH.setVisible(false);
                                    in4KH1.setVisible(true);
                                    btnThuePhong.setVisible(false);
                                    btnThanhToan.setVisible(true);
                                    txtHoTen1.setText(itemss.getTen());
                                    txtCCCD1.setText(itemss.getCccd());
                                    txtSDT1.setText(itemss.getSdt());
                                }
                            }
                        }
                    }
                    break;
                } else {
                    txtHoTen.setText("");
                    txtCCCD.setText("");
                    txtSDT.setText("");
                    txtHoTen1.setText("");
                    txtCCCD1.setText("");
                    txtSDT1.setText("");
                    in4KH.setVisible(true);
                    in4KH1.setVisible(false);
                    btnThuePhong.setVisible(true);
                    btnThanhToan.setVisible(false);
                }
            }
        }

        thongTinPhong.setVisible(true);
    }//GEN-LAST:event_phong5MouseClicked

    private void phong6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong6MouseClicked
        thuePhong1.setVisible(false);
        thuePhong2.setVisible(false);
        timKiem1.setVisible(false);
        themNV1.setVisible(false);

        String maPhong = "301";

        for (Phong item : phong) {
            if (maPhong.equals(item.getMaPhong())) {
                txtMaPhong.setText(item.getMaPhong());
                txtLoaiPhong.setText(item.getLoaiPhong());
                txtTrangThai.setText(item.getTrangThai());
                txtGia.setText(String.valueOf(item.getGiaPhong()));

                if (item.getTrangThai().equals("Da dat")) {
                    for (DatPhong items : dP) {
                        if (maPhong.equals(items.getMaPhong())) {
                            for (KhachHang itemss : kH) {
                                if (items.getMaKhachHang().equals(itemss.getId())) {
                                    in4KH.setVisible(false);
                                    in4KH1.setVisible(true);
                                    btnThuePhong.setVisible(false);
                                    btnThanhToan.setVisible(true);
                                    txtHoTen1.setText(itemss.getTen());
                                    txtCCCD1.setText(itemss.getCccd());
                                    txtSDT1.setText(itemss.getSdt());
                                }
                            }
                        }
                    }
                    break;
                } else {
                    txtHoTen.setText("");
                    txtCCCD.setText("");
                    txtSDT.setText("");
                    txtHoTen1.setText("");
                    txtCCCD1.setText("");
                    txtSDT1.setText("");
                    in4KH.setVisible(true);
                    in4KH1.setVisible(false);
                    btnThuePhong.setVisible(true);
                    btnThanhToan.setVisible(false);
                }
            }
        }

        thongTinPhong.setVisible(true);
    }//GEN-LAST:event_phong6MouseClicked

    private void phong7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong7MouseClicked
        thuePhong1.setVisible(false);
        thuePhong2.setVisible(false);
        timKiem1.setVisible(false);
        themNV1.setVisible(false);

        String maPhong = "302";

        for (Phong item : phong) {
            if (maPhong.equals(item.getMaPhong())) {
                txtMaPhong.setText(item.getMaPhong());
                txtLoaiPhong.setText(item.getLoaiPhong());
                txtTrangThai.setText(item.getTrangThai());
                txtGia.setText(String.valueOf(item.getGiaPhong()));

                if (item.getTrangThai().equals("Da dat")) {
                    for (DatPhong items : dP) {
                        if (maPhong.equals(items.getMaPhong())) {
                            for (KhachHang itemss : kH) {
                                if (items.getMaKhachHang().equals(itemss.getId())) {
                                    in4KH.setVisible(false);
                                    in4KH1.setVisible(true);
                                    btnThuePhong.setVisible(false);
                                    btnThanhToan.setVisible(true);
                                    txtHoTen1.setText(itemss.getTen());
                                    txtCCCD1.setText(itemss.getCccd());
                                    txtSDT1.setText(itemss.getSdt());
                                }
                            }
                        }
                    }
                    break;
                } else {
                    txtHoTen.setText("");
                    txtCCCD.setText("");
                    txtSDT.setText("");
                    txtHoTen1.setText("");
                    txtCCCD1.setText("");
                    txtSDT1.setText("");
                    in4KH.setVisible(true);
                    in4KH1.setVisible(false);
                    btnThuePhong.setVisible(true);
                    btnThanhToan.setVisible(false);
                }
            }
        }

        thongTinPhong.setVisible(true);
    }//GEN-LAST:event_phong7MouseClicked

    private void phong8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong8MouseClicked
        thuePhong1.setVisible(false);
        thuePhong2.setVisible(false);
        timKiem1.setVisible(false);
        themNV1.setVisible(false);

        String maPhong = "303";

        for (Phong item : phong) {
            if (maPhong.equals(item.getMaPhong())) {
                txtMaPhong.setText(item.getMaPhong());
                txtLoaiPhong.setText(item.getLoaiPhong());
                txtTrangThai.setText(item.getTrangThai());
                txtGia.setText(String.valueOf(item.getGiaPhong()));

                if (item.getTrangThai().equals("Da dat")) {
                    for (DatPhong items : dP) {
                        if (maPhong.equals(items.getMaPhong())) {
                            for (KhachHang itemss : kH) {
                                if (items.getMaKhachHang().equals(itemss.getId())) {
                                    in4KH.setVisible(false);
                                    in4KH1.setVisible(true);
                                    btnThuePhong.setVisible(false);
                                    btnThanhToan.setVisible(true);
                                    txtHoTen1.setText(itemss.getTen());
                                    txtCCCD1.setText(itemss.getCccd());
                                    txtSDT1.setText(itemss.getSdt());
                                }
                            }
                        }
                    }
                    break;
                } else {
                    txtHoTen.setText("");
                    txtCCCD.setText("");
                    txtSDT.setText("");
                    txtHoTen1.setText("");
                    txtCCCD1.setText("");
                    txtSDT1.setText("");
                    in4KH.setVisible(true);
                    in4KH1.setVisible(false);
                    btnThuePhong.setVisible(true);
                    btnThanhToan.setVisible(false);
                }
            }
        }

        thongTinPhong.setVisible(true);
    }//GEN-LAST:event_phong8MouseClicked

    private void phong9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong9MouseClicked
        thuePhong1.setVisible(false);
        thuePhong2.setVisible(false);
        timKiem1.setVisible(false);
        themNV1.setVisible(false);

        String maPhong = "304";

        for (Phong item : phong) {
            if (maPhong.equals(item.getMaPhong())) {
                txtMaPhong.setText(item.getMaPhong());
                txtLoaiPhong.setText(item.getLoaiPhong());
                txtTrangThai.setText(item.getTrangThai());
                txtGia.setText(String.valueOf(item.getGiaPhong()));

                if (item.getTrangThai().equals("Da dat")) {
                    for (DatPhong items : dP) {
                        if (maPhong.equals(items.getMaPhong())) {
                            for (KhachHang itemss : kH) {
                                if (items.getMaKhachHang().equals(itemss.getId())) {
                                    in4KH.setVisible(false);
                                    in4KH1.setVisible(true);
                                    btnThuePhong.setVisible(false);
                                    btnThanhToan.setVisible(true);
                                    txtHoTen1.setText(itemss.getTen());
                                    txtCCCD1.setText(itemss.getCccd());
                                    txtSDT1.setText(itemss.getSdt());
                                }
                            }
                        }
                    }
                    break;
                } else {
                    txtHoTen.setText("");
                    txtCCCD.setText("");
                    txtSDT.setText("");
                    txtHoTen1.setText("");
                    txtCCCD1.setText("");
                    txtSDT1.setText("");
                    in4KH.setVisible(true);
                    in4KH1.setVisible(false);
                    btnThuePhong.setVisible(true);
                    btnThanhToan.setVisible(false);
                }
            }
        }

        thongTinPhong.setVisible(true);
    }//GEN-LAST:event_phong9MouseClicked

    private void phong11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong11MouseClicked
        thuePhong1.setVisible(false);
        thuePhong2.setVisible(false);
        timKiem1.setVisible(false);
        themNV1.setVisible(false);

        String maPhong = "305";

        for (Phong item : phong) {
            if (maPhong.equals(item.getMaPhong())) {
                txtMaPhong.setText(item.getMaPhong());
                txtLoaiPhong.setText(item.getLoaiPhong());
                txtTrangThai.setText(item.getTrangThai());
                txtGia.setText(String.valueOf(item.getGiaPhong()));

                if (item.getTrangThai().equals("Da dat")) {
                    for (DatPhong items : dP) {
                        if (maPhong.equals(items.getMaPhong())) {
                            for (KhachHang itemss : kH) {
                                if (items.getMaKhachHang().equals(itemss.getId())) {
                                    in4KH.setVisible(false);
                                    in4KH1.setVisible(true);
                                    btnThuePhong.setVisible(false);
                                    btnThanhToan.setVisible(true);
                                    txtHoTen1.setText(itemss.getTen());
                                    txtCCCD1.setText(itemss.getCccd());
                                    txtSDT1.setText(itemss.getSdt());
                                }
                            }
                        }
                    }
                    break;
                } else {
                    txtHoTen.setText("");
                    txtCCCD.setText("");
                    txtSDT.setText("");
                    txtHoTen1.setText("");
                    txtCCCD1.setText("");
                    txtSDT1.setText("");
                    in4KH.setVisible(true);
                    in4KH1.setVisible(false);
                    btnThuePhong.setVisible(true);
                    btnThanhToan.setVisible(false);
                }
            }
        }

        thongTinPhong.setVisible(true);
    }//GEN-LAST:event_phong11MouseClicked

    private void btnThuePhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThuePhongMouseClicked
        MainPage mpFrame = new MainPage();

        if (txtHoTen.getText().isBlank() || txtCCCD.getText().isBlank() || txtSDT.getText().isBlank()) {
            JOptionPane.showMessageDialog(mpFrame, "Thông tin khách hàng không được bỏ trống");
        } else {
            int i = dP.size();
            int j = kH.size();
            String maDP = "DP" + i;
            String maP = txtMaPhong.getText();
            String maKH = "KH" + j;
            Date ngayDat = new Date();

            DatPhong dp = new DatPhong(maDP, maP, maKH, ngayDat, ngayDat, 0);
            KhachHang kh = new KhachHang(maKH, txtHoTen.getText(), txtCCCD.getText(), txtSDT.getText());

            for (Phong item : phong) {
                if (txtMaPhong.getText().equals(item.getMaPhong())) {
                    item.setTrangThai("Da dat");
                }
            }

            fileP.delete();
            dg.ghiFilePhong(phong);

            dP.clear();
            dP.add(dp);
            dg.ghiFileDatPhong(dP);

            kH.clear();
            kH.add(kh);
            dg.ghiFileKhachHang(kH);

            JOptionPane.showMessageDialog(mpFrame, "Thuê phòng thành công");

            txtHoTen.setText(null);
            txtCCCD.setText(null);
            txtSDT.setText(null);
            
            //in4KH.setVisible(false);

            modelKH.addRow(new Object[]{maKH, txtHoTen.getText(), txtCCCD.getText(), txtSDT.getText()});

            String parts[];

            parts = phong01.getText().split(" ");
            String maP01 = parts[1];

            parts = phong02.getText().split(" ");
            String maP02 = parts[1];

            parts = phong03.getText().split(" ");
            String maP03 = parts[1];

            parts = phong04.getText().split(" ");
            String maP04 = parts[1];

            parts = phong05.getText().split(" ");
            String maP05 = parts[1];

            parts = phong06.getText().split(" ");
            String maP06 = parts[1];

            parts = phong07.getText().split(" ");
            String maP07 = parts[1];

            parts = phong08.getText().split(" ");
            String maP08 = parts[1];

            parts = phong09.getText().split(" ");
            String maP09 = parts[1];

            parts = phong10.getText().split(" ");
            String maP10 = parts[1];

            parts = phong11.getText().split(" ");
            String maP11 = parts[1];

            parts = phong1.getText().split(" ");
            String maP1 = parts[1];

            parts = phong2.getText().split(" ");
            String maP2 = parts[1];

            parts = phong3.getText().split(" ");
            String maP3 = parts[1];

            parts = phong4.getText().split(" ");
            String maP4 = parts[1];

            parts = phong5.getText().split(" ");
            String maP5 = parts[1];

            parts = phong6.getText().split(" ");
            String maP6 = parts[1];

            parts = phong7.getText().split(" ");
            String maP7 = parts[1];

            parts = phong8.getText().split(" ");
            String maP8 = parts[1];

            parts = phong9.getText().split(" ");
            String maP9 = parts[1];

            for (Phong item : phong) {
                if (maP01.equals(item.getMaPhong())) {
                    if (item.getTrangThai().equals("Da dat")) {
                        phong01.setBackground(new java.awt.Color(255, 0, 51));
                    } else {
                        phong01.setBackground(new java.awt.Color(50, 205, 50));
                    }
                }
                if (maP02.equals(item.getMaPhong())) {
                    if (item.getTrangThai().equals("Da dat")) {
                        phong02.setBackground(new java.awt.Color(255, 0, 51));
                    } else {
                        phong02.setBackground(new java.awt.Color(50, 205, 50));
                    }
                }
                if (maP03.equals(item.getMaPhong())) {
                    if (item.getTrangThai().equals("Da dat")) {
                        phong03.setBackground(new java.awt.Color(255, 0, 51));
                    } else {
                        phong03.setBackground(new java.awt.Color(50, 205, 50));
                    }
                }
                if (maP04.equals(item.getMaPhong())) {
                    if (item.getTrangThai().equals("Da dat")) {
                        phong04.setBackground(new java.awt.Color(255, 0, 51));
                    } else {
                        phong04.setBackground(new java.awt.Color(50, 205, 50));
                    }
                }
                if (maP05.equals(item.getMaPhong())) {
                    if (item.getTrangThai().equals("Da dat")) {
                        phong05.setBackground(new java.awt.Color(255, 0, 51));
                    } else {
                        phong05.setBackground(new java.awt.Color(50, 205, 50));
                    }
                }
                if (maP06.equals(item.getMaPhong())) {
                    if (item.getTrangThai().equals("Da dat")) {
                        phong06.setBackground(new java.awt.Color(255, 0, 51));
                    } else {
                        phong06.setBackground(new java.awt.Color(50, 205, 50));
                    }
                }
                if (maP07.equals(item.getMaPhong())) {
                    if (item.getTrangThai().equals("Da dat")) {
                        phong07.setBackground(new java.awt.Color(255, 0, 51));
                    } else {
                        phong07.setBackground(new java.awt.Color(50, 205, 50));
                    }
                }
                if (maP08.equals(item.getMaPhong())) {
                    if (item.getTrangThai().equals("Da dat")) {
                        phong08.setBackground(new java.awt.Color(255, 0, 51));
                    } else {
                        phong08.setBackground(new java.awt.Color(50, 205, 50));
                    }
                }
                if (maP09.equals(item.getMaPhong())) {
                    if (item.getTrangThai().equals("Da dat")) {
                        phong09.setBackground(new java.awt.Color(255, 0, 51));
                    } else {
                        phong09.setBackground(new java.awt.Color(50, 205, 50));
                    }
                }
                if (maP10.equals(item.getMaPhong())) {
                    if (item.getTrangThai().equals("Da dat")) {
                        phong10.setBackground(new java.awt.Color(255, 0, 51));
                    } else {
                        phong10.setBackground(new java.awt.Color(50, 205, 50));
                    }
                }
                if (maP11.equals(item.getMaPhong())) {
                    if (item.getTrangThai().equals("Da dat")) {
                        phong11.setBackground(new java.awt.Color(255, 0, 51));
                    } else {
                        phong11.setBackground(new java.awt.Color(50, 205, 50));
                    }
                }
                if (maP1.equals(item.getMaPhong())) {
                    if (item.getTrangThai().equals("Da dat")) {
                        phong1.setBackground(new java.awt.Color(255, 0, 51));
                    } else {
                        phong1.setBackground(new java.awt.Color(50, 205, 50));
                    }
                }
                if (maP2.equals(item.getMaPhong())) {
                    if (item.getTrangThai().equals("Da dat")) {
                        phong2.setBackground(new java.awt.Color(255, 0, 51));
                    } else {
                        phong2.setBackground(new java.awt.Color(50, 205, 50));
                    }
                }
                if (maP3.equals(item.getMaPhong())) {
                    if (item.getTrangThai().equals("Da dat")) {
                        phong3.setBackground(new java.awt.Color(255, 0, 51));
                    } else {
                        phong3.setBackground(new java.awt.Color(50, 205, 50));
                    }
                }
                if (maP4.equals(item.getMaPhong())) {
                    if (item.getTrangThai().equals("Da dat")) {
                        phong4.setBackground(new java.awt.Color(255, 0, 51));
                    } else {
                        phong4.setBackground(new java.awt.Color(50, 205, 50));
                    }
                }
                if (maP5.equals(item.getMaPhong())) {
                    if (item.getTrangThai().equals("Da dat")) {
                        phong5.setBackground(new java.awt.Color(255, 0, 51));
                    } else {
                        phong5.setBackground(new java.awt.Color(50, 205, 50));
                    }
                }
                if (maP6.equals(item.getMaPhong())) {
                    if (item.getTrangThai().equals("Da dat")) {
                        phong6.setBackground(new java.awt.Color(255, 0, 51));
                    } else {
                        phong6.setBackground(new java.awt.Color(50, 205, 50));
                    }
                }
                if (maP7.equals(item.getMaPhong())) {
                    if (item.getTrangThai().equals("Da dat")) {
                        phong7.setBackground(new java.awt.Color(255, 0, 51));
                    } else {
                        phong7.setBackground(new java.awt.Color(50, 205, 50));
                    }
                }
                if (maP8.equals(item.getMaPhong())) {
                    if (item.getTrangThai().equals("Da dat")) {
                        phong8.setBackground(new java.awt.Color(255, 0, 51));
                    } else {
                        phong8.setBackground(new java.awt.Color(50, 205, 50));
                    }
                }
                if (maP9.equals(item.getMaPhong())) {
                    if (item.getTrangThai().equals("Da dat")) {
                        phong9.setBackground(new java.awt.Color(255, 0, 51));
                    } else {
                        phong9.setBackground(new java.awt.Color(50, 205, 50));
                    }
                }
            }

            thuePhong1.setVisible(true);
            thuePhong2.setVisible(false);
            timKiem1.setVisible(false);
            themNV1.setVisible(false);
            thongTinPhong.setVisible(false);
            in4KH.setVisible(false);

        }
    }//GEN-LAST:event_btnThuePhongMouseClicked

    private void btnThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThanhToanMouseClicked
        MainPage mpFrame = new MainPage();

        double thanhToan = 0, tong;
        int thgianThue;

        Date ngayDat = new Date();
        Date ngayTra = new Date();

        for (DatPhong item : dP) {
            if (txtMaPhong.getText().equals(item.getMaPhong())) {
                ngayDat = item.getNgayDat();
                item.setNgayTra(ngayTra);
            }
        }

        for (Phong item : phong) {
            if (txtMaPhong.getText().equals(item.getMaPhong())) {
                thanhToan = item.getGiaPhong();
            }
        }
        
        

        thgianThue = ((ngayTra.getDay() * 24) + ngayTra.getHours()) - ((ngayDat.getDay() * 24) + ngayDat.getHours()) ;

        if (thgianThue <= 12 && thgianThue > 0) {
            tong = ((thanhToan % 10) + 5) * thgianThue;
        } else if (thgianThue <= 24 && thgianThue > 12) {
            tong = thanhToan + ((thanhToan % 10) + 5) * thgianThue;
        } else {
            tong = (thanhToan + thanhToan / 4) * (thgianThue % 12);
        }

        for (Phong item : phong) {
            if (txtMaPhong.getText().equals(item.getMaPhong())) {
                item.setTrangThai("Trong");
            }
        }

        fileP.delete();
        dg.ghiFilePhong(phong);

        for (DatPhong item : dP) {
            if (txtMaPhong.getText().equals(item.getMaPhong())) {
                item.setTongTien(tong);
            }
        }

        fileDP.delete();
        dg.ghiFileDatPhong(dP);

        JOptionPane.showMessageDialog(mpFrame, "Số tiền khách cần phải thanh toán là: " + tong + "(nghìn vnđ)");
        JOptionPane.showMessageDialog(mpFrame, "Thanh toán thành công");

        String parts[];

        parts = phong01.getText().split(" ");
        String maP01 = parts[1];

        parts = phong02.getText().split(" ");
        String maP02 = parts[1];

        parts = phong03.getText().split(" ");
        String maP03 = parts[1];

        parts = phong04.getText().split(" ");
        String maP04 = parts[1];

        parts = phong05.getText().split(" ");
        String maP05 = parts[1];

        parts = phong06.getText().split(" ");
        String maP06 = parts[1];

        parts = phong07.getText().split(" ");
        String maP07 = parts[1];

        parts = phong08.getText().split(" ");
        String maP08 = parts[1];

        parts = phong09.getText().split(" ");
        String maP09 = parts[1];

        parts = phong10.getText().split(" ");
        String maP10 = parts[1];

        parts = phong11.getText().split(" ");
        String maP11 = parts[1];

        parts = phong1.getText().split(" ");
        String maP1 = parts[1];

        parts = phong2.getText().split(" ");
        String maP2 = parts[1];

        parts = phong3.getText().split(" ");
        String maP3 = parts[1];

        parts = phong4.getText().split(" ");
        String maP4 = parts[1];

        parts = phong5.getText().split(" ");
        String maP5 = parts[1];

        parts = phong6.getText().split(" ");
        String maP6 = parts[1];

        parts = phong7.getText().split(" ");
        String maP7 = parts[1];

        parts = phong8.getText().split(" ");
        String maP8 = parts[1];

        parts = phong9.getText().split(" ");
        String maP9 = parts[1];

        for (Phong item : phong) {
            if (maP01.equals(item.getMaPhong())) {
                if (item.getTrangThai().equals("Da dat")) {
                    phong01.setBackground(new java.awt.Color(255, 0, 51));
                } else {
                    phong01.setBackground(new java.awt.Color(50, 205, 50));
                }
            }
            if (maP02.equals(item.getMaPhong())) {
                if (item.getTrangThai().equals("Da dat")) {
                    phong02.setBackground(new java.awt.Color(255, 0, 51));
                } else {
                    phong02.setBackground(new java.awt.Color(50, 205, 50));
                }
            }
            if (maP03.equals(item.getMaPhong())) {
                if (item.getTrangThai().equals("Da dat")) {
                    phong03.setBackground(new java.awt.Color(255, 0, 51));
                } else {
                    phong03.setBackground(new java.awt.Color(50, 205, 50));
                }
            }
            if (maP04.equals(item.getMaPhong())) {
                if (item.getTrangThai().equals("Da dat")) {
                    phong04.setBackground(new java.awt.Color(255, 0, 51));
                } else {
                    phong04.setBackground(new java.awt.Color(50, 205, 50));
                }
            }
            if (maP05.equals(item.getMaPhong())) {
                if (item.getTrangThai().equals("Da dat")) {
                    phong05.setBackground(new java.awt.Color(255, 0, 51));
                } else {
                    phong05.setBackground(new java.awt.Color(50, 205, 50));
                }
            }
            if (maP06.equals(item.getMaPhong())) {
                if (item.getTrangThai().equals("Da dat")) {
                    phong06.setBackground(new java.awt.Color(255, 0, 51));
                } else {
                    phong06.setBackground(new java.awt.Color(50, 205, 50));
                }
            }
            if (maP07.equals(item.getMaPhong())) {
                if (item.getTrangThai().equals("Da dat")) {
                    phong07.setBackground(new java.awt.Color(255, 0, 51));
                } else {
                    phong07.setBackground(new java.awt.Color(50, 205, 50));
                }
            }
            if (maP08.equals(item.getMaPhong())) {
                if (item.getTrangThai().equals("Da dat")) {
                    phong08.setBackground(new java.awt.Color(255, 0, 51));
                } else {
                    phong08.setBackground(new java.awt.Color(50, 205, 50));
                }
            }
            if (maP09.equals(item.getMaPhong())) {
                if (item.getTrangThai().equals("Da dat")) {
                    phong09.setBackground(new java.awt.Color(255, 0, 51));
                } else {
                    phong09.setBackground(new java.awt.Color(50, 205, 50));
                }
            }
            if (maP10.equals(item.getMaPhong())) {
                if (item.getTrangThai().equals("Da dat")) {
                    phong10.setBackground(new java.awt.Color(255, 0, 51));
                } else {
                    phong10.setBackground(new java.awt.Color(50, 205, 50));
                }
            }
            if (maP11.equals(item.getMaPhong())) {
                if (item.getTrangThai().equals("Da dat")) {
                    phong11.setBackground(new java.awt.Color(255, 0, 51));
                } else {
                    phong11.setBackground(new java.awt.Color(50, 205, 50));
                }
            }
            if (maP1.equals(item.getMaPhong())) {
                if (item.getTrangThai().equals("Da dat")) {
                    phong1.setBackground(new java.awt.Color(255, 0, 51));
                } else {
                    phong1.setBackground(new java.awt.Color(50, 205, 50));
                }
            }
            if (maP2.equals(item.getMaPhong())) {
                if (item.getTrangThai().equals("Da dat")) {
                    phong2.setBackground(new java.awt.Color(255, 0, 51));
                } else {
                    phong2.setBackground(new java.awt.Color(50, 205, 50));
                }
            }
            if (maP3.equals(item.getMaPhong())) {
                if (item.getTrangThai().equals("Da dat")) {
                    phong3.setBackground(new java.awt.Color(255, 0, 51));
                } else {
                    phong3.setBackground(new java.awt.Color(50, 205, 50));
                }
            }
            if (maP4.equals(item.getMaPhong())) {
                if (item.getTrangThai().equals("Da dat")) {
                    phong4.setBackground(new java.awt.Color(255, 0, 51));
                } else {
                    phong4.setBackground(new java.awt.Color(50, 205, 50));
                }
            }
            if (maP5.equals(item.getMaPhong())) {
                if (item.getTrangThai().equals("Da dat")) {
                    phong5.setBackground(new java.awt.Color(255, 0, 51));
                } else {
                    phong5.setBackground(new java.awt.Color(50, 205, 50));
                }
            }
            if (maP6.equals(item.getMaPhong())) {
                if (item.getTrangThai().equals("Da dat")) {
                    phong6.setBackground(new java.awt.Color(255, 0, 51));
                } else {
                    phong6.setBackground(new java.awt.Color(50, 205, 50));
                }
            }
            if (maP7.equals(item.getMaPhong())) {
                if (item.getTrangThai().equals("Da dat")) {
                    phong7.setBackground(new java.awt.Color(255, 0, 51));
                } else {
                    phong7.setBackground(new java.awt.Color(50, 205, 50));
                }
            }
            if (maP8.equals(item.getMaPhong())) {
                if (item.getTrangThai().equals("Da dat")) {
                    phong8.setBackground(new java.awt.Color(255, 0, 51));
                } else {
                    phong8.setBackground(new java.awt.Color(50, 205, 50));
                }
            }
            if (maP9.equals(item.getMaPhong())) {
                if (item.getTrangThai().equals("Da dat")) {
                    phong9.setBackground(new java.awt.Color(255, 0, 51));
                } else {
                    phong9.setBackground(new java.awt.Color(50, 205, 50));
                }
            }
        }

        thuePhong1.setVisible(true);
        thuePhong2.setVisible(false);
        timKiem1.setVisible(false);
        themNV1.setVisible(false);
        thongTinPhong.setVisible(false);

    }//GEN-LAST:event_btnThanhToanMouseClicked

    private void comboOtpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboOtpActionPerformed
        if (comboOtp.getSelectedItem().equals("Khach Hang")) {
            scrollPKH.setVisible(true);
            scrollPNV.setVisible(false);
            scrollPphong.setVisible(false);
        }
        if (comboOtp.getSelectedItem().equals("Nhan Vien")) {
            scrollPKH.setVisible(false);
            scrollPNV.setVisible(true);
            scrollPphong.setVisible(false);
        }
        if (comboOtp.getSelectedItem().equals("Phong")) {
            scrollPKH.setVisible(false);
            scrollPNV.setVisible(false);
            scrollPphong.setVisible(true);
        }
    }//GEN-LAST:event_comboOtpActionPerformed

    private void btnThemNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemNVMouseClicked
        MainPage mpFrame = new MainPage();

        if (txtHTNV.getText().isBlank() || txtChucVU.getText().isBlank() || txtSDTNV.getText().isBlank() || txtCCCDNV.getText().isBlank() || txtMatKhau.getText().isBlank()) {
            JOptionPane.showMessageDialog(mpFrame, "Thông tin nhân viên không được bỏ trống");
        } else {
            int i = nV.size();
            NhanVien nv = new NhanVien("NV" + i, txtMatKhau.getText(), txtHTNV.getText(), txtChucVU.getText(), txtCCCDNV.getText(), txtSDTNV.getText());
            
            fileNV.delete();
            nV.add(nv);
            dg.ghiFileNhanVien(nV);
            
            

            JOptionPane.showMessageDialog(mpFrame, "Thêm nhân viên thành công");

            thuePhong1.setVisible(true);
            thuePhong2.setVisible(false);
            timKiem1.setVisible(false);
            themNV1.setVisible(false);
        }


    }//GEN-LAST:event_btnThemNVMouseClicked

    private void btnTimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimMouseClicked
        MainPage mpFrame = new MainPage();

        String textTimKiem = txtThongTin.getText();

        boolean kiemTra = false;

        String parts[];

        if (comboOtp.getSelectedItem().equals("Khach Hang")) {
            if (textTimKiem.isBlank()) {
                modelKH.setRowCount(0);
                addRowtoTableKH();
                kiemTra = true;
            }

            for (KhachHang item : kH) {
                parts = item.getTen().split(" ");
                if (item.getId().equals(textTimKiem) || parts[0].equals(textTimKiem) || parts[parts.length - 1].equals(textTimKiem) || item.getCccd().equals(textTimKiem) || item.getSdt().equals(textTimKiem)) {
                    modelKH.setRowCount(0);
                    kiemTra = true;
                    modelKH.addRow(new Object[]{item.getId(), item.getTen(), item.getCccd(), item.getSdt()});
                }
            }
        }

        if (comboOtp.getSelectedItem().equals("Nhan Vien")) {
            if (textTimKiem.isBlank()) {
                modelNV.setRowCount(0);
                addRowtoTableNV();
                kiemTra = true;
            }

            for (NhanVien item : nV) {
                parts = item.getTen().split(" ");
                if (item.getId().equals(textTimKiem) || parts[0].equals(textTimKiem) || parts[parts.length - 1].equals(textTimKiem) || item.getChucVu().equals(textTimKiem) || item.getCccd().equals(textTimKiem) || item.getSdt().equals(textTimKiem)) {
                    modelKH.setRowCount(0);
                    kiemTra = true;
                    modelNV.addRow(new Object[]{item.getId(), item.getTen(), item.getChucVu(), item.getCccd(), item.getSdt()});
                }
            }
        }

        if (comboOtp.getSelectedItem().equals("Phong")) {
            if (textTimKiem.isBlank()) {
                modelPh.setRowCount(0);
                addRowtoTableP();
                kiemTra = true;
            }

            for (Phong item : phong) {
                if (item.getMaPhong().equals(textTimKiem) || item.getLoaiPhong().equals(textTimKiem) || item.getTrangThai().equals(textTimKiem) || String.valueOf(item.getGiaPhong()).equals(textTimKiem)) {
                    modelKH.setRowCount(0);
                    kiemTra = true;
                    modelPh.addRow(new Object[]{item.getMaPhong(), item.getLoaiPhong(), item.getTrangThai(), item.getGiaPhong()});
                }
            }
        }

        if (kiemTra == false) {
            JOptionPane.showMessageDialog(mpFrame, "Không có thông tin muốn tìm");
        }
    }//GEN-LAST:event_btnTimMouseClicked

    private void txtThongTinKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtThongTinKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            MainPage mpFrame = new MainPage();

            String textTimKiem = txtThongTin.getText();

            boolean kiemTra = false;

            String parts[];

            if (comboOtp.getSelectedItem().equals("Khach Hang")) {
                if (textTimKiem.isBlank()) {
                    modelKH.setRowCount(0);
                    addRowtoTableKH();
                    kiemTra = true;
                }

                for (KhachHang item : kH) {
                    parts = item.getTen().split(" ");
                    if (item.getId().equals(textTimKiem) || parts[0].equals(textTimKiem) || parts[parts.length - 1].equals(textTimKiem) || item.getCccd().equals(textTimKiem) || item.getSdt().equals(textTimKiem)) {
                        modelKH.setRowCount(0);
                        kiemTra = true;
                        modelKH.addRow(new Object[]{item.getId(), item.getTen(), item.getCccd(), item.getSdt()});
                    }
                }
            }

            if (comboOtp.getSelectedItem().equals("Nhan Vien")) {
                if (textTimKiem.isBlank()) {
                    modelNV.setRowCount(0);
                    addRowtoTableNV();
                    kiemTra = true;
                }

                for (NhanVien item : nV) {
                    parts = item.getTen().split(" ");
                    if (item.getId().equals(textTimKiem) || parts[0].equals(textTimKiem) || parts[parts.length - 1].equals(textTimKiem) || item.getChucVu().equals(textTimKiem) || item.getCccd().equals(textTimKiem) || item.getSdt().equals(textTimKiem)) {
                        modelKH.setRowCount(0);
                        kiemTra = true;
                        modelNV.addRow(new Object[]{item.getId(), item.getTen(), item.getChucVu(), item.getCccd(), item.getSdt()});
                    }
                }
            }

            if (comboOtp.getSelectedItem().equals("Phong")) {
                if (textTimKiem.isBlank()) {
                    modelPh.setRowCount(0);
                    addRowtoTableP();
                    kiemTra = true;
                }

                for (Phong item : phong) {
                    if (item.getMaPhong().equals(textTimKiem) || item.getLoaiPhong().equals(textTimKiem) || item.getTrangThai().equals(textTimKiem) || String.valueOf(item.getGiaPhong()).equals(textTimKiem)) {
                        modelKH.setRowCount(0);
                        kiemTra = true;
                        modelPh.addRow(new Object[]{item.getMaPhong(), item.getLoaiPhong(), item.getTrangThai(), item.getGiaPhong()});
                    }
                }
            }

            if (kiemTra == false) {
                JOptionPane.showMessageDialog(mpFrame, "Không có thông tin muốn tìm");
            }
        }
    }//GEN-LAST:event_txtThongTinKeyPressed

    private void txtHoTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoTenActionPerformed

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
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CCCD;
    private javax.swing.JLabel SDT;
    private javax.swing.JLabel backGround;
    private javax.swing.JLabel backgroundKH;
    private javax.swing.JLabel btnThanhToan;
    private javax.swing.JLabel btnThemNV;
    private javax.swing.JLabel btnThuePhong;
    private javax.swing.JLabel btnTim;
    private javax.swing.JLabel chucVU;
    private javax.swing.JLabel chucVu;
    private javax.swing.JComboBox<String> comboOtp;
    private javax.swing.JLabel gia;
    private javax.swing.JLabel hoTen;
    private javax.swing.JLabel hoTenNV;
    private javax.swing.JPanel in4KH;
    private javax.swing.JPanel in4KH1;
    private javax.swing.JLabel lenLau34;
    private javax.swing.JLabel loaiPhong;
    private javax.swing.JLabel maNV;
    private javax.swing.JLabel maPhong;
    private javax.swing.JLabel matKhau;
    private javax.swing.JLabel nhapThongTin;
    private javax.swing.JLabel phong01;
    private javax.swing.JLabel phong02;
    private javax.swing.JLabel phong03;
    private javax.swing.JLabel phong04;
    private javax.swing.JLabel phong05;
    private javax.swing.JLabel phong06;
    private javax.swing.JLabel phong07;
    private javax.swing.JLabel phong08;
    private javax.swing.JLabel phong09;
    private javax.swing.JLabel phong1;
    private javax.swing.JLabel phong10;
    private javax.swing.JLabel phong11;
    private javax.swing.JLabel phong2;
    private javax.swing.JLabel phong3;
    private javax.swing.JLabel phong4;
    private javax.swing.JLabel phong5;
    private javax.swing.JLabel phong6;
    private javax.swing.JLabel phong7;
    private javax.swing.JLabel phong8;
    private javax.swing.JLabel phong9;
    private javax.swing.JLabel sDTNV;
    private javax.swing.JScrollPane scrollPKH;
    private javax.swing.JScrollPane scrollPNV;
    private javax.swing.JScrollPane scrollPphong;
    private javax.swing.JButton signOut;
    private javax.swing.JLabel soCCCDNV;
    private javax.swing.JTable tableKH;
    private javax.swing.JTable tableNV;
    private javax.swing.JTable tablePh;
    private javax.swing.JLabel tacVuChinh;
    private javax.swing.JLabel tacVuChinh1;
    private javax.swing.JLabel tang1;
    private javax.swing.JLabel tang2;
    private javax.swing.JLabel tang3;
    private javax.swing.JLabel tang4;
    private javax.swing.JLabel tenNV;
    private javax.swing.JLabel themNV;
    private javax.swing.JPanel themNV1;
    private javax.swing.JLabel thongTinNV;
    private javax.swing.JLabel thongTinNV1;
    private javax.swing.JPanel thongTinPhong;
    private javax.swing.JLabel thongtinKH;
    private javax.swing.JLabel thongtinPhong;
    private javax.swing.JLabel thuePhong;
    private javax.swing.JPanel thuePhong1;
    private javax.swing.JPanel thuePhong2;
    private javax.swing.JLabel timKiem;
    private javax.swing.JPanel timKiem1;
    private javax.swing.JLabel timKiemIn4;
    private javax.swing.JLabel trangThai;
    private javax.swing.JTextField txtCCCD;
    private javax.swing.JLabel txtCCCD1;
    private javax.swing.JTextField txtCCCDNV;
    private javax.swing.JTextField txtChucVU;
    private javax.swing.JLabel txtChucVu;
    private javax.swing.JLabel txtGia;
    private javax.swing.JTextField txtHTNV;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JLabel txtHoTen1;
    private javax.swing.JLabel txtLoaiPhong;
    private javax.swing.JLabel txtMaNV;
    private javax.swing.JLabel txtMaPhong;
    private javax.swing.JTextField txtMatKhau;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JLabel txtSDT1;
    private javax.swing.JTextField txtSDTNV;
    private javax.swing.JLabel txtTenNV;
    private javax.swing.JTextField txtThongTin;
    private javax.swing.JLabel txtTrangThai;
    private javax.swing.JLabel xuongLau12;
    // End of variables declaration//GEN-END:variables

}
