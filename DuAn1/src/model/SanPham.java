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
public class SanPham {
    private String id;
    private ThuongHieu th;
    private DanhMuc dm;
    private String maSP;
    private String tenSP;

    public SanPham() {
    }

    public SanPham(String id, ThuongHieu th, DanhMuc dm, String maSP, String tenSP) {
        this.id = id;
        this.th = th;
        this.dm = dm;
        this.maSP = maSP;
        this.tenSP = tenSP;
    }

    public SanPham(String id, String maSP, String tenSP) {
        this.id = id;
        this.maSP = maSP;
        this.tenSP = tenSP;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ThuongHieu getTh() {
        return th;
    }

    public void setTh(ThuongHieu th) {
        this.th = th;
    }

    public DanhMuc getDm() {
        return dm;
    }

    public void setDm(DanhMuc dm) {
        this.dm = dm;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    @Override
    public String toString() {
        return getTenSP();
    }   
}
