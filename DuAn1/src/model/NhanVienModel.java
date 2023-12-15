/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author THANH
 */
public class NhanVienModel {

    private String id, idCV, ma, hoTen, matKhau, sDT, gioiTinh, chucVu;
    private Date ngaySinh;
    private String diaChi, trangThai;

    public NhanVienModel() {
    }
    

    public NhanVienModel(String ma, String hoTen, String matKhau, String sDT, String gioiTinh, String chucVu, Date ngaySinh, String diaChi, String trangThai) {
        this.ma = ma;
        this.hoTen = hoTen;
        this.matKhau = matKhau;
        this.sDT = sDT;
        this.gioiTinh = gioiTinh;
        this.chucVu = chucVu;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.trangThai = trangThai;
    }

    public NhanVienModel(String id, String idCV, String ma, String hoTen, String matKhau, String sDT, String gioiTinh, String chucVu, Date ngaySinh, String diaChi, String trangThai) {
        this.id = id;
        this.idCV = idCV;
        this.ma = ma;
        this.hoTen = hoTen;
        this.matKhau = matKhau;
        this.sDT = sDT;
        this.gioiTinh = gioiTinh;
        this.chucVu = chucVu;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.trangThai = trangThai;
    }

    public NhanVienModel(String ma, String matKhau, String chucVu) {
        this.ma = ma;
        this.matKhau = matKhau;
        this.chucVu = chucVu;
    }


//get 

    public NhanVienModel(String hoTen) {
        this.hoTen = hoTen;
    }

    public NhanVienModel(String id, String hoTen) {
        this.id = id;
        this.hoTen = hoTen;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdCV() {
        return idCV;
    }

    public void setIdCV(String idCV) {
        this.idCV = idCV;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getsDT() {
        return sDT;
    }

    public void setsDT(String sDT) {
        this.sDT = sDT;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return getHoTen();
    }

}
