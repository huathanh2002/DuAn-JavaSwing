/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.Date;
import java.util.List;
import model.HoaDon;
import reponsitory.HoaDonRepository;

/**
 *
 * @author natsu
 */
public class HoaDonService {

    private final HoaDonRepository hoaDonRepository;

    public HoaDonService() {
        this.hoaDonRepository = new HoaDonRepository();
    }

    public List<HoaDon> getAll() {
        return hoaDonRepository.getAll();
    }
//    public List<HoaDon> getAllHoaDon() {
//        return hoaDonRepository.getAllHoaDon();
//    }

    public List<HoaDon> getAllHoaDonCho() {
        return hoaDonRepository.getAllHoaDonCho();
    }

    public Integer addHoaDon(HoaDon hd) {
        return hoaDonRepository.addHoaDon(hd);
    }

    public Integer huyHoaDon(HoaDon hoaDon, String maHoaDon) {
        return hoaDonRepository.huyHoaDon(hoaDon, maHoaDon);
    }

    public Integer thayDoiNhanVienOrKhachHang(HoaDon hoaDon, String ma) {
        return hoaDonRepository.thayDoiNhanVienOrKhachHang(hoaDon, ma);
    }

    public Integer thanhToan(HoaDon hoaDon, String id) {
        return hoaDonRepository.thanhToan(hoaDon, id);
    }

    public List<HoaDon> search(String a) {
        return hoaDonRepository.search(a);
    }

    public List<HoaDon> searchNgayBD(Date a) {
        return hoaDonRepository.searchNgayBD(a);
    }

    public List<HoaDon> searchNgayKT(Date b) {
        return hoaDonRepository.searchNgayKT(b);
    }

    public List<HoaDon> searchBdVaKt(Date a, Date b) {
        return hoaDonRepository.searchBdVaKt(a, b);
    }

    public List<HoaDon> getSearchByTT(String tt) {
        return hoaDonRepository.getSearchByTT(tt);
    }
}
