/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.Date;
import java.util.UUID;
/**
 *
 * @author Admin
 */
public class KhachHang {
    private String id;
    private String ma;
    private String ten;
    private String soDienThoai;
    private String diachi;
    private Date ngaySinh;

    public KhachHang() {
    }

    public KhachHang(String ma, String ten, String soDienThoai, String diachi, Date ngaySinh) {
        this.ma = ma;
        this.ten = ten;
        this.soDienThoai = soDienThoai;
        this.diachi = diachi;
        this.ngaySinh = ngaySinh;
    }

    public KhachHang(String id, String ma, String ten, String soDienThoai, String diachi, Date ngaySinh) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.soDienThoai = soDienThoai;
        this.diachi = diachi;
        this.ngaySinh = ngaySinh;
    }

    public KhachHang(String ten) {
        this.ten = ten;
    }

    public KhachHang(String id, String ten) {
        this.id = id;
        this.ten = ten;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    
    public Object[] toDataRow(){
        return new Object[]{this.ma,this.ten,this.soDienThoai,this.diachi,this.ngaySinh};
    }

    @Override
    public String toString() {
        return getTen();
    }
}
