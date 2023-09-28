/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managehotelbooking.Models;

/**
 *
 * @author ASUS
 */
public class Nguoi {
    private String ten;
    private String cccd;
    private String sdt;

    public Nguoi() {
    }

    public Nguoi(String ten, String cccd, String sdt) {
        this.ten = ten;
        this.cccd = cccd;
        this.sdt = sdt;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    
}
