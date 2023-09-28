/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managehotelbooking.Models;

/**
 *
 * @author ASUS
 */
public class Phong {
    private String maPhong;
    private String loaiPhong;  
    public String trangThai;
    private double giaPhong;

    public Phong() {
    }

    public Phong(String maPhong, String loaiPhong, String trangThai, double giaPhong) {
        this.maPhong = maPhong;
        this.loaiPhong = loaiPhong;
        this.trangThai = trangThai;
        this.giaPhong = giaPhong;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

    public void setLoaiPhong(String loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public double getGiaPhong() {
        return giaPhong;
    }

    public void setGiaPhong(double giaPhong) {
        this.giaPhong = giaPhong;
    }
    
    
}
