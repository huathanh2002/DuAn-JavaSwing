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
public class ChiTietSP {

    private String id;
    private SanPham sanPham;
    private MauSac mauSac;
    private Size size;
    private ChatLieu chatLieu;
    private String maCT;
    private Integer soluong, namSX;
    private Double giaBan;
    private String trangThai;

    public ChiTietSP() {
    }

    public ChiTietSP(String id, SanPham sanPham, MauSac mauSac, Size size, ChatLieu chatLieu, String maCT, Integer soluong, Integer namSX, Double giaBan, String trangThai) {
        this.id = id;
        this.sanPham = sanPham;
        this.mauSac = mauSac;
        this.size = size;
        this.chatLieu = chatLieu;
        this.maCT = maCT;
        this.soluong = soluong;
        this.namSX = namSX;
        this.giaBan = giaBan;
        this.trangThai = trangThai;
    }

    public ChiTietSP(SanPham sanPham, MauSac mauSac, Size size, ChatLieu chatLieu, Integer soluong, Integer namSX, Double giaBan, String trangThai) {
        this.sanPham = sanPham;
        this.mauSac = mauSac;
        this.size = size;
        this.chatLieu = chatLieu;
        this.soluong = soluong;
        this.namSX = namSX;
        this.giaBan = giaBan;
        this.trangThai = trangThai;
    }

    public ChiTietSP(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public MauSac getMauSac() {
        return mauSac;
    }

    public void setMauSac(MauSac mauSac) {
        this.mauSac = mauSac;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public ChatLieu getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(ChatLieu chatLieu) {
        this.chatLieu = chatLieu;
    }

    public Integer getSoluong() {
        return soluong;
    }

    public void setSoluong(Integer soluong) {
        this.soluong = soluong;
    }

    public Integer getNamSX() {
        return namSX;
    }

    public void setNamSX(Integer namSX) {
        this.namSX = namSX;
    }

    public Double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Double giaBan) {
        this.giaBan = giaBan;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getMaCT() {
        return maCT;
    }

    public void setMaCT(String maCT) {
        this.maCT = maCT;
    }

    public Object[] toDataRow() {
        return new Object[]{this.maCT, this.sanPham, this.mauSac, this.chatLieu, this.namSX, this.giaBan, this.soluong, this.size, this.trangThai};
    }

    public Object[] toDataRow2() {
        return new Object[]{this.id,this.maCT, this.sanPham, this.mauSac, this.chatLieu, this.namSX, this.giaBan, this.soluong, this.size, this.trangThai};
    }

    @Override
    public String toString() {
        return getId();
    }

}
