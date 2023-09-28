/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managehotelbooking.Models;

/**
 *
 * @author ASUS
 */
public class NhanVien extends Nguoi{
    private String id;
    private String matKhau;
    private String chucVu;

    public NhanVien() {
    }

    public NhanVien(String id, String matKhau, String ten, String chucVu, String cccd, String sdt) {
        super(ten, cccd, sdt);
        this.id = id;
        this.matKhau = matKhau;
        this.chucVu = chucVu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    
}
