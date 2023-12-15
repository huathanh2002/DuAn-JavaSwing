/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.UUID;

/**
 *
 * @author natsu
 */
public class ThuongHieu {
    private String id;
    private String maTH;
    private String tenTH;

    public ThuongHieu() {
    }

    public ThuongHieu(String id, String maTH, String tenTH) {
        this.id = id;
        this.maTH = maTH;
        this.tenTH = tenTH;
    }

    public ThuongHieu(String maTH, String tenTH) {
        this.maTH = maTH;
        this.tenTH = tenTH;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaTH() {
        return maTH;
    }

    public void setMaTH(String maTH) {
        this.maTH = maTH;
    }

    public String getTenTH() {
        return tenTH;
    }

    public void setTenTH(String tenTH) {
        this.tenTH = tenTH;
    }  
    @Override
    public String toString() {
        return getTenTH();
    }
    
}
