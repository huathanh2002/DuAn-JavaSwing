/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reponsitory;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import model.HoaDon;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Doitra;
import model.KhachHang;
import model.NhanVienModel;
import model.PTTToan;
import utility.JDBCHelper;

/**
 *
 * @author natsu
 */
public class HoaDonRepository {

    public List<HoaDon> getAll() {
        List<HoaDon> list = new ArrayList<>();
        String sql = "select * FROM     hoaDOn INNER JOIN\n"
                + "                  khachHang ON hoaDOn.id_hoaKhachHang = khachHang.idKH INNER JOIN\n"
                + "                  nhanVien ON hoaDOn.id_nhanVien = nhanVien.idNV";
        ResultSet rs = JDBCHelper.excuteQuery(sql);
        try {
            while (rs.next()) {
                String id = rs.getString("idHD");
                String maHD = rs.getString("maHD");
                LocalDateTime ngayTao = rs.getTimestamp("ngayTao").toLocalDateTime();
//                LocalDateTime ngayThanhToa = rs.getTimestamp("ngayThanhToan").toLocalDateTime();
                Date ngayNhan = rs.getDate("ngayNhan");
                String trangThai = rs.getString("trangThai");
//                String tnv = rs.getString("nhanVien.tenNv");
//                String tkh = rs.getString("KhachHang.ten");
                NhanVienModel nv = new NhanVienModel(rs.getString("idNV"), rs.getString("tenNv"));
                KhachHang kh = new KhachHang(rs.getString("idKH"), rs.getString("ten"));
//                String pttt = rs.getString("id_PhuongThucThanhToan");
//                String doitra = rs.getString("id_DoiTra");
                Double tongTien = rs.getDouble("giaTien");

                list.add(new HoaDon(id, maHD, nv, kh, null, null, ngayTao, null, ngayNhan, tongTien, trangThai));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<HoaDon> search(String a) {
        List<HoaDon> list = new ArrayList<>();
        String sql = "select * FROM     hoaDOn INNER JOIN\n"
                + "                  khachHang ON hoaDOn.id_hoaKhachHang = khachHang.idKH INNER JOIN\n"
                + "                  nhanVien ON hoaDOn.id_nhanVien = nhanVien.idNV where hoaDon.maHD like ? or nhanVien.tenNV like ? or khachHang.ten like ?";
        ResultSet rs = JDBCHelper.excuteQuery(sql,
                a,
                a,
                a);
        try {
            while (rs.next()) {
                String id = rs.getString("idHD");
                String maHD = rs.getString("maHD");
                LocalDateTime ngayTao = rs.getTimestamp("ngayTao").toLocalDateTime();
//                LocalDateTime ngayThanhToa = rs.getTimestamp("ngayThanhToan").toLocalDateTime();
                Date ngayNhan = rs.getDate("ngayNhan");
                String trangThai = rs.getString("trangThai");
//                String tnv = rs.getString("nhanVien.tenNv");
//                String tkh = rs.getString("KhachHang.ten");
                NhanVienModel nv = new NhanVienModel(rs.getString("idNV"), rs.getString("tenNv"));
                KhachHang kh = new KhachHang(rs.getString("idKH"), rs.getString("ten"));
//                String pttt = rs.getString("id_PhuongThucThanhToan");
//                String doitra = rs.getString("id_DoiTra");
                Double tongTien = rs.getDouble("giaTien");

                list.add(new HoaDon(id, maHD, nv, kh, null, null, ngayTao, null, ngayNhan, tongTien, trangThai));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<HoaDon> searchNgayBD(Date a) {
        List<HoaDon> list = new ArrayList<>();
        String sql = "select * FROM     hoaDOn INNER JOIN\n"
                + "                  khachHang ON hoaDOn.id_hoaKhachHang = khachHang.idKH INNER JOIN\n"
                + "                  nhanVien ON hoaDOn.id_nhanVien = nhanVien.idNV where ngayTao >= ?";
        ResultSet rs = JDBCHelper.excuteQuery(sql,
                a);
        try {
            while (rs.next()) {
                String id = rs.getString("idHD");
                String maHD = rs.getString("maHD");
                LocalDateTime ngayTao = rs.getTimestamp("ngayTao").toLocalDateTime();
//                LocalDateTime ngayThanhToa = rs.getTimestamp("ngayThanhToan").toLocalDateTime();
                Date ngayNhan = rs.getDate("ngayNhan");
                String trangThai = rs.getString("trangThai");
//                String tnv = rs.getString("nhanVien.tenNv");
//                String tkh = rs.getString("KhachHang.ten");
                NhanVienModel nv = new NhanVienModel(rs.getString("idNV"), rs.getString("tenNv"));
                KhachHang kh = new KhachHang(rs.getString("idKH"), rs.getString("ten"));
//                String pttt = rs.getString("id_PhuongThucThanhToan");
//                String doitra = rs.getString("id_DoiTra");
                Double tongTien = rs.getDouble("giaTien");

                list.add(new HoaDon(id, maHD, nv, kh, null, null, ngayTao, null, ngayNhan, tongTien, trangThai));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<HoaDon> searchNgayKT(Date b) {
        List<HoaDon> list = new ArrayList<>();
        String sql = "select * FROM     hoaDOn INNER JOIN\n"
                + "                  khachHang ON hoaDOn.id_hoaKhachHang = khachHang.idKH INNER JOIN\n"
                + "                  nhanVien ON hoaDOn.id_nhanVien = nhanVien.idNV where Day(ngayTao) <= Day(?) and month(ngayTao)<= month(?) and year(ngayTao)<=year(?)";
        ResultSet rs = JDBCHelper.excuteQuery(sql,
                b, b, b);
        try {
            while (rs.next()) {
                String id = rs.getString("idHD");
                String maHD = rs.getString("maHD");
                LocalDateTime ngayTao = rs.getTimestamp("ngayTao").toLocalDateTime();
//                LocalDateTime ngayThanhToa = rs.getTimestamp("ngayThanhToan").toLocalDateTime();
                Date ngayNhan = rs.getDate("ngayNhan");
                String trangThai = rs.getString("trangThai");
//                String tnv = rs.getString("nhanVien.tenNv");
//                String tkh = rs.getString("KhachHang.ten");
                NhanVienModel nv = new NhanVienModel(rs.getString("idNV"), rs.getString("tenNv"));
                KhachHang kh = new KhachHang(rs.getString("idKH"), rs.getString("ten"));
//                String pttt = rs.getString("id_PhuongThucThanhToan");
//                String doitra = rs.getString("id_DoiTra");
                Double tongTien = rs.getDouble("giaTien");

                list.add(new HoaDon(id, maHD, nv, kh, null, null, ngayTao, null, ngayNhan, tongTien, trangThai));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<HoaDon> searchBdVaKt(Date a, Date b) {
        List<HoaDon> list = new ArrayList<>();
        String sql = "select * FROM     hoaDOn INNER JOIN\n"
                + "                  khachHang ON hoaDOn.id_hoaKhachHang = khachHang.idKH INNER JOIN\n"
                + "                  nhanVien ON hoaDOn.id_nhanVien = nhanVien.idNV where ngayTao >= ? and Day(ngayTao) <= Day(?) and month(ngayTao)<= month(?) and year(ngayTao)<=year(?)";
        ResultSet rs = JDBCHelper.excuteQuery(sql,
                a, b, b, b);
        try {
            while (rs.next()) {
                String id = rs.getString("idHD");
                String maHD = rs.getString("maHD");
                LocalDateTime ngayTao = rs.getTimestamp("ngayTao").toLocalDateTime();
//                LocalDateTime ngayThanhToa = rs.getTimestamp("ngayThanhToan").toLocalDateTime();
                Date ngayNhan = rs.getDate("ngayNhan");
                String trangThai = rs.getString("trangThai");
//                String tnv = rs.getString("nhanVien.tenNv");
//                String tkh = rs.getString("KhachHang.ten");
                NhanVienModel nv = new NhanVienModel(rs.getString("idNV"), rs.getString("tenNv"));
                KhachHang kh = new KhachHang(rs.getString("idKH"), rs.getString("ten"));
//                String pttt = rs.getString("id_PhuongThucThanhToan");
//                String doitra = rs.getString("id_DoiTra");
                Double tongTien = rs.getDouble("giaTien");

                list.add(new HoaDon(id, maHD, nv, kh, null, null, ngayTao, null, ngayNhan, tongTien, trangThai));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<HoaDon> getAllHoaDonCho() {
        List<HoaDon> list = new ArrayList<>();
        String sql = "select hoaDOn.idHD,hoaDOn.maHD,hoaDOn.ngayTao,hoaDOn.trangThai,nhanVien.tenNV,khachHang.ten from hoaDOn \n"
                + "join nhanVien on hoaDOn.id_nhanVien = nhanVien.idNV\n"
                + "join khachHang on hoaDOn.id_hoaKhachHang = khachHang.idKH\n"
                + "where hoaDOn.trangThai like N'Chờ thanh toán'";
        ResultSet rs = JDBCHelper.excuteQuery(sql);
        try {
            while (rs.next()) {
                String id = rs.getString("idHD");
                String maHD = rs.getString("maHD");
                LocalDateTime ngayTao = rs.getTimestamp("ngayTao").toLocalDateTime();
                String trangThai = rs.getString("trangThai");
                NhanVienModel nv = new NhanVienModel(rs.getString("tenNV"));
                KhachHang kh = new KhachHang(rs.getString("ten"));

                list.add(new HoaDon(id, maHD, nv, kh, ngayTao, trangThai));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Integer addHoaDon(HoaDon hd) {
        String sql = "insert into hoaDOn(maHD,ngayTao,trangThai,id_nhanVien,id_hoaKhachHang) values(?,?,?,?,?)";
        Integer row = JDBCHelper.excuteUpdate(sql,
                hd.getMaHD(),
                hd.getNgayTao(),
                hd.getTrangThai(),
                hd.getNv().getId(),
                hd.getKh().getId()
        );
        return row;
    }

    public Integer huyHoaDon(HoaDon hoaDon, String ma) {
        String sql = "update hoaDOn\n"
                + "set trangThai =?\n"
                + "where maHD =?";
        Integer row = JDBCHelper.excuteUpdate(sql,
                hoaDon.getTrangThai(),
                ma
        );
        return row;
    }

    public Integer thayDoiNhanVienOrKhachHang(HoaDon hoaDon, String ma) {
        String sql = "update hoaDOn\n"
                + "set id_nhanVien=?, id_hoaKhachHang =?\n"
                + "where maHD=?";
        Integer row = JDBCHelper.excuteUpdate(sql,
                hoaDon.getNv().getId(),
                hoaDon.getKh().getId(),
                ma
        );
        return row;
    }

    public Integer thanhToan(HoaDon hoaDon, String id) {
        String sql = "update hoaDOn\n"
                + "set id_PhuongThucThanhToan=?,ngayThanhToan=?,giaTien=?,trangThai=?\n"
                + "where maHD=?";
        Integer row = JDBCHelper.excuteUpdate(sql,
                hoaDon.getPttt().getIdPTTT(),
                hoaDon.getNgayThanhToan(),
                hoaDon.getTongTien(),
                hoaDon.getTrangThai(),
                id
        );
        return row;
    }

    public List<HoaDon> getSearchByTT(String tt) {
        List<HoaDon> list = new ArrayList<>();
        String sql = "select * FROM hoaDOn \n"
                + "INNER JOIN khachHang ON hoaDOn.id_hoaKhachHang = khachHang.idKH \n"
                + "INNER JOIN nhanVien ON hoaDOn.id_nhanVien = nhanVien.idNV\n"
                + "where hoaDOn.trangThai=?";
        ResultSet rs = JDBCHelper.excuteQuery(sql, tt);
        try {
            while (rs.next()) {
                String id = rs.getString("idHD");
                String maHD = rs.getString("maHD");
                LocalDateTime ngayTao = rs.getTimestamp("ngayTao").toLocalDateTime();
//                LocalDateTime ngayThanhToa = rs.getTimestamp("ngayThanhToan").toLocalDateTime();
                Date ngayNhan = rs.getDate("ngayNhan");
//                String tnv = rs.getString("nhanVien.tenNv");
//                String tkh = rs.getString("KhachHang.ten");
                NhanVienModel nv = new NhanVienModel(rs.getString("idNV"), rs.getString("tenNv"));
                KhachHang kh = new KhachHang(rs.getString("idKH"), rs.getString("ten"));
//                String pttt = rs.getString("id_PhuongThucThanhToan");
//                String doitra = rs.getString("id_DoiTra");
                Double tongTien = rs.getDouble("giaTien");
                String trangThai = rs.getString("trangThai");

                list.add(new HoaDon(id, maHD, nv, kh, null, null, ngayTao, null, ngayNhan, tongTien, trangThai));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
