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
public class PTTToan {
    private String idPTTT,maPTTT,tenPTTT,trangThai;

    public PTTToan() {
    }

    public PTTToan(String idPTTT, String maPTTT, String tenPTTT, String trangThai) {
        this.idPTTT = idPTTT;
        this.maPTTT = maPTTT;
        this.tenPTTT = tenPTTT;
        this.trangThai = trangThai;
    }
    public String getIdPTTT() {
        return idPTTT;
    }

    public void setIdPTTT(String idPTTT) {
        this.idPTTT = idPTTT;
    }

    public String getMaPTTT() {
        return maPTTT;
    }

    public void setMaPTTT(String maPTTT) {
        this.maPTTT = maPTTT;
    }

    public String getTenPTTT() {
        return tenPTTT;
    }

    public void setTenPTTT(String tenPTTT) {
        this.tenPTTT = tenPTTT;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return getTenPTTT();
    }
    
}
