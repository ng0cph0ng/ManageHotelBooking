/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managehotelbooking.Models;

/**
 *
 * @author ASUS
 */
public class KhachHang extends Nguoi{
    private String id;

    public KhachHang() {
    }

    public KhachHang(String id, String ten, String cccd, String sdt) {
        super(ten, cccd, sdt);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
    
}
