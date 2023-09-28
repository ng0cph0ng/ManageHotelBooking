/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managehotelbooking.Models;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import managehotelbooking.GiaoDien.DangKi;

/**
 *
 * @author ASUS
 */
public class DocGhiFile {

    private static final String curentDir = System.getProperty("user.dir");
    private static final String separator = File.separator;
    private static final String PATH_FILE_CSV = curentDir + separator + "data" + separator + "KhachHang.csv";
    private static final String PATH_FILE_CSV_NhanVien = curentDir + separator + "data" + separator + "NhanVien.csv";
    private static final String PATH_FILE_CSV_Phong = curentDir + separator + "data" + separator + "Phong.csv";
    private static final String PATH_FILE_CSV_DATPHONG = curentDir + separator + "data" + separator + "DatPhong.csv";

    public void ghiFileKhachHang(List<KhachHang> listKhachHang) {
        FileWriter fw = null;
        try {
            File f = new File(PATH_FILE_CSV);
            if (!f.exists()) {
                fw = new FileWriter(PATH_FILE_CSV, true);
                CSVWriter csvWrite = new CSVWriter(fw, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
                String[] header = {"Ma KH", "Ho Ten", "So CMND", "SDT"};
                csvWrite.writeNext(header);
                for (KhachHang item : listKhachHang) {
                    csvWrite.writeNext(new String[]{String.valueOf(item.getId()), item.getTen(), item.getCccd(), item.getSdt()});
                }
            } else {
                fw = new FileWriter(PATH_FILE_CSV, true);
                CSVWriter csvWrite = new CSVWriter(fw, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
                for (KhachHang item : listKhachHang) {
                    csvWrite.writeNext(new String[]{String.valueOf(item.getId()), item.getTen(), item.getCccd(), item.getSdt()});
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(DocGhiFile.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException ex) {
                    Logger.getLogger(DocGhiFile.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public List<KhachHang> docFileKhachHang() throws CsvValidationException {
        FileReader fr = null;
        List<KhachHang> list = new ArrayList<>();
        try {
            fr = new FileReader(PATH_FILE_CSV);
            CSVReader csvReader = new CSVReader(fr);
            String[] line;
            line = csvReader.readNext();
            while ((line = csvReader.readNext()) != null) {
                KhachHang kh = new KhachHang(line[0], line[1], line[2], line[3]);
                list.add(kh);
            }
        } catch (IOException ex) {
            Logger.getLogger(DocGhiFile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(DocGhiFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    public void ghiFileNhanVien(List<NhanVien> listNhanVien) {
        FileWriter fw = null;
        try {
            File f = new File(PATH_FILE_CSV_NhanVien);
            if (!f.exists()) {
                fw = new FileWriter(PATH_FILE_CSV_NhanVien, true);
                CSVWriter csvWrite = new CSVWriter(fw, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
                String[] header = {"Ma NV", "Mat Khau", "Ho Ten", "Chuc Vu", "So CCCD", "SDT"};
                csvWrite.writeNext(header);
                for (NhanVien item : listNhanVien) {
                    csvWrite.writeNext(new String[]{String.valueOf(item.getId()), String.valueOf(item.getMatKhau()), item.getTen(), item.getChucVu(), item.getCccd(), item.getSdt()});
                }
            } else {
                fw = new FileWriter(PATH_FILE_CSV_NhanVien, true);
                CSVWriter csvWrite = new CSVWriter(fw, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
                for (NhanVien item : listNhanVien) {
                    csvWrite.writeNext(new String[]{String.valueOf(item.getId()), String.valueOf(item.getMatKhau()), item.getTen(), item.getChucVu(), item.getCccd(), item.getSdt()});
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(DocGhiFile.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException ex) {
                    Logger.getLogger(DocGhiFile.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public List<NhanVien> docFileNhanVien() throws CsvValidationException {
        FileReader fr = null;
        List<NhanVien> list = new ArrayList<>();
        try {
            fr = new FileReader(PATH_FILE_CSV_NhanVien);
            CSVReader csvReader = new CSVReader(fr);
            String[] line;
            line = csvReader.readNext();
            while ((line = csvReader.readNext()) != null) {
                NhanVien nv = new NhanVien(line[0], line[1], line[2], line[3], line[4], line[5]);
                list.add(nv);
            }
        } catch (IOException ex) {
            Logger.getLogger(DocGhiFile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(DocGhiFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    public void ghiFilePhong(List<Phong> list) {
        FileWriter fw = null;
        try {
            File f = new File(PATH_FILE_CSV_Phong);
            if (!f.exists()) {
                fw = new FileWriter(PATH_FILE_CSV_Phong, true);
                CSVWriter csvWrite = new CSVWriter(fw, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
                String[] header = {"Ma Phong", "Loai Phong", "Trang Thai", "Gia tien"};
                csvWrite.writeNext(header);
                for (Phong item : list) {
                    csvWrite.writeNext(new String[]{String.valueOf(item.getMaPhong()), item.getLoaiPhong(), String.valueOf(item.getTrangThai()), String.valueOf(item.getGiaPhong())});
                }
            } else {
                fw = new FileWriter(PATH_FILE_CSV_Phong, true);
                CSVWriter csvWrite = new CSVWriter(fw, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
                for (Phong item : list) {
                    csvWrite.writeNext(new String[]{String.valueOf(item.getMaPhong()), String.valueOf(item.getLoaiPhong()), String.valueOf(item.getGiaPhong())});
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(DocGhiFile.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException ex) {
                    Logger.getLogger(DocGhiFile.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public List<Phong> docFilePhong() throws CsvValidationException {
        FileReader fr = null;
        List<Phong> list = new ArrayList<>();
        try {
            fr = new FileReader(PATH_FILE_CSV_Phong);
            CSVReader csvReader = new CSVReader(fr);
            String[] line;
            line = csvReader.readNext();
            while ((line = csvReader.readNext()) != null) {
                try {
                    Phong phong = new Phong(line[0], line[1], line[2], Double.parseDouble(line[3].trim()));
                    list.add(phong);
                } catch (java.lang.NumberFormatException ex) {
                    
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(DocGhiFile.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException ex) {
                    Logger.getLogger(DocGhiFile.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }

//    public void ghiFileDangNhap(List<NhanVien> listDangNhap) {
//        FileWriter fw = null;
//        try {
//            File f = new File(PATH_FILE_CSV_DangNhap);
//            if (!f.exists()) {
//                fw = new FileWriter(PATH_FILE_CSV_DangNhap, true);
//                CSVWriter csvWrite = new CSVWriter(fw, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
//                String[] header = {"Tai Khoan", "Mat Khau"};
//                csvWrite.writeNext(header);
//                for (NhanVien item : listDangNhap) {
//                    csvWrite.writeNext(new String[]{String.valueOf(item.getId()), item.getMatKhau()});
//                }
//            } else {
//                fw = new FileWriter(PATH_FILE_CSV_DangNhap, true);
//                CSVWriter csvWrite = new CSVWriter(fw, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
//                for (NhanVien item : listDangNhap) {
//                    csvWrite.writeNext(new String[]{String.valueOf(item.getId()), item.getMatKhau()});
//                }
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(DocGhiFile.class
//                    .getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            if (fw != null) {
//                try {
//                    fw.close();
//                } catch (IOException ex) {
//                    Logger.getLogger(DocGhiFile.class
//                            .getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
//    }
//
//    public List<NhanVien> docFileDangNhap() throws CsvValidationException {
//        FileReader fr = null;
//        List<NhanVien> list = new ArrayList<>();
//        try {
//            fr = new FileReader(PATH_FILE_CSV_DangNhap);
//            CSVReader csvReader = new CSVReader(fr);
//            String[] line;
//            line = csvReader.readNext();
//            while ((line = csvReader.readNext()) != null) {
//                NhanVien nv = new NhanVien(line[0], line[1]);
//                list.add(nv);
//                System.out.println("2");
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(DocGhiFile.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                fr.close();
//            } catch (IOException ex) {
//                Logger.getLogger(DocGhiFile.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        return list;
//    }

    public void ghiFileDatPhong(List<DatPhong> list) {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        FileWriter fw = null;
        try {
            File f = new File(PATH_FILE_CSV_DATPHONG);
            if (!f.exists()) {
                fw = new FileWriter(PATH_FILE_CSV_DATPHONG, true);
                CSVWriter csvWrite = new CSVWriter(fw, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
                String[] header = {"Ma Dat Phong", "Ma Phong", "Ma Khach Hang", "NgayDat", "NgayTra", "TongTien"};
                csvWrite.writeNext(header);
                for (DatPhong item : list) {
                    csvWrite.writeNext(new String[]{String.valueOf(item.getMaDatPhong()), String.valueOf(item.getMaPhong()), String.valueOf(item.getMaKhachHang()), df.format(item.getNgayDat()), df.format(item.getNgayTra()), String.valueOf(item.getTongTien())});

                }
            } else {
                fw = new FileWriter(PATH_FILE_CSV_DATPHONG, true);
                CSVWriter csvWrite = new CSVWriter(fw, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
                for (DatPhong item : list) {
                    csvWrite.writeNext(new String[]{String.valueOf(item.getMaDatPhong()), String.valueOf(item.getMaPhong()), String.valueOf(item.getMaKhachHang()), df.format(item.getNgayDat()), df.format(item.getNgayTra()), String.valueOf(item.getTongTien())});

                }
            }

        } catch (IOException ex) {
            Logger.getLogger(DocGhiFile.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fw != null) {
                try {
                    fw.close();

                } catch (IOException ex) {
                    Logger.getLogger(DocGhiFile.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public List<DatPhong> docFileDatPhong() throws CsvValidationException, ParseException {

        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        FileReader fr = null;
        List<DatPhong> list = new ArrayList<>();
        try {
            fr = new FileReader(PATH_FILE_CSV_DATPHONG);
            CSVReader csvReader = new CSVReader(fr);
            String[] line;
            line = csvReader.readNext();
            while ((line = csvReader.readNext()) != null) {
                Date ngayDat = df.parse(line[3]);
                Date ngayTra = df.parse(line[4]);
                DatPhong datPhong = new DatPhong(line[0], line[1], line[2], ngayDat, ngayTra, Double.parseDouble(line[5]));
                list.add(datPhong);

            }
        } catch (IOException ex) {
            Logger.getLogger(DocGhiFile.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fr != null) {
                try {
                    fr.close();

                } catch (IOException ex) {
                    Logger.getLogger(DocGhiFile.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        return list;
    }

}
