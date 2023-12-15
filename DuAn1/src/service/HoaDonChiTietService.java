/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import java.util.UUID;
import model.ChiTietSP;
import model.HoaDonChiTiet;
import reponsitory.HoaDonChiTietReposistory;

/**
 *
 * @author natsu
 */
public class HoaDonChiTietService {

    private final HoaDonChiTietReposistory hoaDonChiTietReposistory;

    public HoaDonChiTietService() {
        this.hoaDonChiTietReposistory = new HoaDonChiTietReposistory();
    }

    public List<HoaDonChiTiet> getAll() {
        return hoaDonChiTietReposistory.getAllDetails();
    }

    public Integer addChiTietHoaDon(HoaDonChiTiet hdct) {
        return hoaDonChiTietReposistory.addChiTietHoaDon(hdct);
    }

    public List<HoaDonChiTiet> getChiTietHoaDonByIdHoaDon(String maHD) {
        return hoaDonChiTietReposistory.getChiTietHoaDonByMaHoaDon(maHD);
    }
    public List<HoaDonChiTiet> getCTHoaDonByMa(String maHD) {
        return hoaDonChiTietReposistory.getCTHoaDonByMa(maHD);
    }

    public boolean checkChiTietHoaDonExist(String idChiTietSP,String idHoaDon){
        return hoaDonChiTietReposistory.checkChiTietHoaDonExist(idChiTietSP,idHoaDon);
    }
   public Integer xoaSanPhamKhoiHoaDon(String idSanPham, String idCTHD, int soLuong){
        return  hoaDonChiTietReposistory.xoaSanPhamKhoiHoaDon(idSanPham, idCTHD, soLuong);
    }
}
