/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class KhuyenMai {
    private String id;
    private String maKM;
    private String tenKM;
    private Date ngayBD;
    private Date ngayKT;
    private String giamGia;
    private String trangThai;
    private String ghiChu;

    public KhuyenMai() {
    }

    public KhuyenMai(String maKM, String tenKM, Date ngayBD, Date ngayKT, String giamGia, String trangThai, String ghiChu) {
        this.maKM = maKM;
        this.tenKM = tenKM;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
        this.giamGia = giamGia;
        this.trangThai = trangThai;
        this.ghiChu = ghiChu;
    }

    public KhuyenMai(String id, String maKM, String tenKM, Date ngayBD, Date ngayKT, String giamGia, String trangThai, String ghiChu) {
        this.id = id;
        this.maKM = maKM;
        this.tenKM = tenKM;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
        this.giamGia = giamGia;
        this.trangThai = trangThai;
        this.ghiChu = ghiChu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public String getTenKM() {
        return tenKM;
    }

    public void setTenKM(String tenKM) {
        this.tenKM = tenKM;
    }

    public Date getNgayBD() {
        return ngayBD;
    }

    public void setNgayBD(Date ngayBD) {
        this.ngayBD = ngayBD;
    }

    public Date getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(Date ngayKT) {
        this.ngayKT = ngayKT;
    }

    public String getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(String giamGia) {
        this.giamGia = giamGia;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

 
    public Object[] toDataRow(){
        return new Object[]{this.maKM,this.tenKM,this.ngayBD,this.ngayKT,this.giamGia,this.trangThai,this.ghiChu};
    }

    @Override
    public String toString() {
        return tenKM;
    }
    
}
