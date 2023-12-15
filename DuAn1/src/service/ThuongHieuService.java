/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.ThuongHieu;
import reponsitory.ThuongHieuReponsitory;

/**
 *
 * @author natsu
 */
public class ThuongHieuService {

    private final ThuongHieuReponsitory thuongHieuReponsitory;

    public ThuongHieuService() {
        this.thuongHieuReponsitory = new ThuongHieuReponsitory();
    }

    public List<ThuongHieu> getAll() {
        return thuongHieuReponsitory.getAll();
    }

    public Integer addSP(ThuongHieu th) {
        return thuongHieuReponsitory.addSP(th);
    }

    public Integer updateSP(ThuongHieu th, String id) {
        return thuongHieuReponsitory.updateSP(th, id);
    }

    public Integer deleteSP(String ma) {
        return thuongHieuReponsitory.deleteSP(ma);
    }

    public ThuongHieu findById(String id) {
        return thuongHieuReponsitory.findById(id);
    }

    public List<ThuongHieu> searchByName(String name) {
        return thuongHieuReponsitory.searchByName(name);
    }
}
