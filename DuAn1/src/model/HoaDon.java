/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author natsu
 */
public class HoaDon {

    private String id, maHD;
    private NhanVienModel nv;
    private KhachHang kh;
    private Doitra doitra;
    private PTTToan pttt;
    private LocalDateTime ngayTao;
    private LocalDateTime ngayThanhToan;
    private LocalDateTime ngayShip;
    private Date ngayNhan;
    private double tongTien;
    private String trangThai;
    private double tienHoaDon;
    private double tienKhachDua;
    private double tienThua;

    public HoaDon() {
    }

    public HoaDon(String id, String maHD, NhanVienModel nv, KhachHang kh, Doitra doitra, PTTToan pttt, LocalDateTime ngayTao, LocalDateTime ngayThanhToan, LocalDateTime ngayShip, Date ngayNhan, double tongTien, String trangThai) {
        this.id = id;
        this.maHD = maHD;
        this.nv = nv;
        this.kh = kh;
        this.doitra = doitra;
        this.pttt = pttt;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.ngayShip = ngayShip;
        this.ngayNhan = ngayNhan;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }

    public HoaDon(String id, String maHD, NhanVienModel nv, KhachHang kh, LocalDateTime ngayTao, String trangThai) {
        this.id = id;
        this.maHD = maHD;
        this.nv = nv;
        this.kh = kh;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }

    public HoaDon(String id, String maHD, NhanVienModel nv, KhachHang kh, Doitra doitra, PTTToan pttt, LocalDateTime ngayTao, LocalDateTime ngayThanhToan, Date ngayNhan, double tongTien, String trangThai) {
        this.id = id;
        this.maHD = maHD;
        this.nv = nv;
        this.kh = kh;
        this.doitra = doitra;
        this.pttt = pttt;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.ngayNhan = ngayNhan;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }

    public HoaDon(String maHD) {
        this.maHD = maHD;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public NhanVienModel getNv() {
        return nv;
    }

    public void setNv(NhanVienModel nv) {
        this.nv = nv;
    }

    public KhachHang getKh() {
        return kh;
    }

    public void setKh(KhachHang kh) {
        this.kh = kh;
    }

    public Doitra getDoitra() {
        return doitra;
    }

    public void setDoitra(Doitra doitra) {
        this.doitra = doitra;
    }

    public PTTToan getPttt() {
        return pttt;
    }

    public void setPttt(PTTToan pttt) {
        this.pttt = pttt;
    }

    public LocalDateTime getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDateTime ngayTao) {
        this.ngayTao = ngayTao;
    }

    public LocalDateTime getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(LocalDateTime ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public LocalDateTime getNgayShip() {
        return ngayShip;
    }

    public void setNgayShip(LocalDateTime ngayShip) {
        this.ngayShip = ngayShip;
    }

    public Date getNgayNhan() {
        return ngayNhan;
    }

    public void setNgayNhan(Date ngayNhan) {
        this.ngayNhan = ngayNhan;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public double getTienKhachDua() {
        return tienKhachDua;
    }

    public void setTienKhachDua(double tienKhachDua) {
        this.tienKhachDua = tienKhachDua;
    }

    public double getTienThua() {
        return tienThua;
    }

    public void setTienThua(double tienThua) {
        this.tienThua = tienThua;
    }

    public double getTienHoaDon() {
        return tienHoaDon;
    }

    public void setTienHoaDon(double tienHoaDon) {
        this.tienHoaDon = tienHoaDon;
    }

}
