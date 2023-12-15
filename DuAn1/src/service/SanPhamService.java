/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.SanPham;
import reponsitory.SanPhamRepository;

/**
 *
 * @author natsu
 */
public class SanPhamService {

    private final SanPhamRepository sanPhamRepository;

    public SanPhamService() {
        this.sanPhamRepository = new SanPhamRepository();
    }

    public List<SanPham> getAll() {
        return sanPhamRepository.getAll();
    }

    public Integer addSP(SanPham sp) {
        return sanPhamRepository.addSP(sp);
    }

    public Integer updateSP(SanPham sp, String id) {
        return sanPhamRepository.updateSP(sp, id);
    }

    public Integer deleteSP(String ma) {
        return sanPhamRepository.deleteSP(ma);
    }

    public List<SanPham> timTen(String ten) {
        return sanPhamRepository.timTen(ten);
    }
    
    public List<SanPham> timTH(String thuongHieu) {
         return sanPhamRepository.timTH(thuongHieu);
     }
    
    public List<SanPham> timDM(String danhMuc) {
        return sanPhamRepository.timDM(danhMuc);
    }
    public int checkMa(String ma) {
        return sanPhamRepository.checkMa(ma);
    }
}
