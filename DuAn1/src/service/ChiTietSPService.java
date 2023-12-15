/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.ChiTietSP;
import model.MauSac;
import model.SanPham;
import model.Size;
import reponsitory.ChiTietSPRepository;

/**
 *
 * @author natsu
 */
public class ChiTietSPService {

    private final ChiTietSPRepository chiTietSPRepository;

    public ChiTietSPService() {
        this.chiTietSPRepository = new ChiTietSPRepository();
    }

    public List<ChiTietSP> getAll() {
        return chiTietSPRepository.getAll();
    }

    public Integer addCTSP(ChiTietSP chiTietSP) {
        return chiTietSPRepository.addCTSP(chiTietSP);
    }

    public Integer updateCTSP(ChiTietSP chiTietSP, String id) {
        return chiTietSPRepository.updateCTSP(chiTietSP, id);
    }

    public Integer deleteCTSP(String id) {
        return chiTietSPRepository.deleteCTSP(id);
    }

    public List<ChiTietSP> locTen(String ten) {
        return chiTietSPRepository.locTen(ten);
    }

    public List<ChiTietSP> locTenMau(MauSac mauSac) {
        return chiTietSPRepository.locTenMau(mauSac);
    }

    public List<ChiTietSP> locTenSize(Size size) {
        return chiTietSPRepository.locTenSize(size);
    }

    public List<ChiTietSP> locTenSP(SanPham ten) {
        return chiTietSPRepository.locTenSP(ten);
    }

    public List<ChiTietSP> getChiTietSPById(String id) {
        return chiTietSPRepository.getChiTietSPById(id);
    }

    public List<ChiTietSP> getAllByTT() {
        return chiTietSPRepository.getAllByTT();
    }

    public int updateTrangThaiHetHang(String maChiTietSP) {
        return chiTietSPRepository.updateTrangThaiHetHang(maChiTietSP);
    }

    public String getTrangThaiSanPham(String maCTSP) {
        return chiTietSPRepository.getTrangThaiSanPham(maCTSP);
    }

    public int getSoLuongSanPhamConLai(String maCTSP) {
        return chiTietSPRepository.getSoLuongSanPhamConLai(maCTSP);
    }

    public void updateSoLuongVaTrangThai(String maCTSP, int soLuong, String trangThaiMoi) {
        chiTietSPRepository.updateSoLuongVaTrangThai(maCTSP, soLuong, trangThaiMoi);
    }
}
