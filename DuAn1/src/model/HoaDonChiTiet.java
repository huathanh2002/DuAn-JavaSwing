/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author natsu
 */
public class HoaDonChiTiet {
    private String id,idOld,maCTHD;
    private HoaDon hoaDon;
    private ChiTietSP chiTietSP;
    private SanPham sanPham;
    private int soLuong;
    private double donGia;
    private String trangThai;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String id, String idOld, String maCTHD, HoaDon hoaDon, ChiTietSP chiTietSP, SanPham sanPham, int soLuong, double donGia, String trangThai) {
        this.id = id;
        this.idOld = idOld;
        this.maCTHD = maCTHD;
        this.hoaDon = hoaDon;
        this.chiTietSP = chiTietSP;
        this.sanPham = sanPham;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.trangThai = trangThai;
    }

    public HoaDonChiTiet(String maCTHD) {
        this.maCTHD = maCTHD;
    }
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdOld() {
        return idOld;
    }

    public void setIdOld(String idOld) {
        this.idOld = idOld;
    }

    public String getMaCTHD() {
        return maCTHD;
    }

    public void setMaCTHD(String maCTHD) {
        this.maCTHD = maCTHD;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public ChiTietSP getChiTietSP() {
        return chiTietSP;
    }

    public void setChiTietSP(ChiTietSP chiTietSP) {
        this.chiTietSP = chiTietSP;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

   
}
