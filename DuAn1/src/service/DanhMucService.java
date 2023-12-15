/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.DanhMuc;
import reponsitory.DanhMucReponsitory;

/**
 *
 * @author natsu
 */
public class DanhMucService {

    private final DanhMucReponsitory danhMucReponsitory;

    public DanhMucService() {
        this.danhMucReponsitory = new DanhMucReponsitory();
    }

    public List<DanhMuc> getAll() {
        return danhMucReponsitory.getAll();
    }

    public Integer addSP(DanhMuc dm) {
        return danhMucReponsitory.addSP(dm);
    }

    public Integer updateSP(DanhMuc dm, String id) {
        return danhMucReponsitory.updateSP(dm, id);
    }

    public Integer deleteSP(String ma) {
        return danhMucReponsitory.deleteSP(ma);
    }

    public DanhMuc findById(String id) {
        return danhMucReponsitory.findById(id);
    }
    
    public List<DanhMuc> timDM(String danhMuc){
        return danhMucReponsitory.timDM(danhMuc);
    }
    public DanhMuc findByMa(String ma){
        return danhMucReponsitory.findByMa(ma);
    }
}
