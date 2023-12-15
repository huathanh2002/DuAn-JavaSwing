/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDateTime;

/**
 *
 * @author natsu
 */
public class Doitra {
    private String idDoiTra;
    private HoaDon hoaDon;
    private LocalDateTime ngayDoiTra;
    private String lyDoDoi,trangThai;

    public Doitra() {
    }

    public Doitra(String idDoiTra, HoaDon hoaDon, LocalDateTime ngayDoiTra, String lyDoDoi, String trangThai) {
        this.idDoiTra = idDoiTra;
        this.hoaDon = hoaDon;
        this.ngayDoiTra = ngayDoiTra;
        this.lyDoDoi = lyDoDoi;
        this.trangThai = trangThai;
    }

    public Doitra(String idDoiTra) {
        this.idDoiTra = idDoiTra;
    }

    public String getIdDoiTra() {
        return idDoiTra;
    }

    public void setIdDoiTra(String idDoiTra) {
        this.idDoiTra = idDoiTra;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public LocalDateTime getNgayDoiTra() {
        return ngayDoiTra;
    }

    public void setNgayDoiTra(LocalDateTime ngayDoiTra) {
        this.ngayDoiTra = ngayDoiTra;
    }

    public String getLyDoDoi() {
        return lyDoDoi;
    }

    public void setLyDoDoi(String lyDoDoi) {
        this.lyDoDoi = lyDoDoi;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
