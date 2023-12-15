/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reponsitory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.KhuyenMai;
import utility.DBConnect;

/**
 *
 * @author Admin
 */
public class KhuyenMaiRepository {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<KhuyenMai> getAll() {
        List<KhuyenMai> list = new ArrayList<KhuyenMai>();
        String sql = "select idKM,maKM,tenKM,ngayBatDau,ngayKetThuc,GiaGiam,trangThai,ghiChu from khuyenMai";

        try {
            con = DBConnect.getDBConnect();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new KhuyenMai(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<KhuyenMai> getAllByTT() {
        List<KhuyenMai> list = new ArrayList<KhuyenMai>();
        String sql = "select idKM,maKM,tenKM,ngayBatDau,ngayKetThuc,GiaGiam,trangThai,ghiChu from khuyenMai where trangThai like N'Đang áp dụng'";

        try {
            con = DBConnect.getDBConnect();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new KhuyenMai(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public KhuyenMai getMa(String a) {
        KhuyenMai kh = null;
        String sql = "select maKM,tenKM,ngayBatDau,ngayKetThuc,GiaGiam,trangThai,ghiChu from khuyenMai where maKM like ?";
        try {
            con = DBConnect.getDBConnect();
            ps = con.prepareStatement(sql);
            ps.setObject(1, a);
            rs = ps.executeQuery();
            while (rs.next()) {
                kh = new KhuyenMai(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7));
            }
            return kh;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<KhuyenMai> getSearch(String a) {
        List<KhuyenMai> list = new ArrayList<KhuyenMai>();
        String sql = "select maKM,tenKM,ngayBatDau,ngayKetThuc,GiaGiam,trangThai,ghiChu from khuyenMai\n"
                + "where maKM like ? or tenKM like ? or ngayBatDau like ? or ngayKetThuc like ? or GiaGiam like ? or trangThai like ?";
        try {
            con = DBConnect.getDBConnect();
            ps = con.prepareStatement(sql);
            ps.setObject(1, a);
            ps.setObject(2, a);
            ps.setObject(3, a);
            ps.setObject(4, a);
            ps.setObject(5, a);
            ps.setObject(6, a);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new KhuyenMai(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int addKM(KhuyenMai km) {
        String sql = "insert into khuyenMai(maKM,tenKM,ngayBatDau,ngayKetThuc,GiaGiam,trangThai,ghiChu) values(?,?,?,?,?,?,?)";
        try {
            con = DBConnect.getDBConnect();
            ps = con.prepareStatement(sql);
            ps.setObject(1, km.getMaKM());
            ps.setObject(2, km.getTenKM());
            ps.setObject(3, km.getNgayBD());
            ps.setObject(4, km.getNgayKT());
            ps.setObject(5, km.getGiamGia());
            ps.setObject(6, km.getTrangThai());
            ps.setObject(7, km.getGhiChu());
            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }

    public int updateKM(KhuyenMai km, String a) {
        String sql = "update khuyenMai\n"
                + "set maKM = ?, tenKM = ?, ngayBatDau = ?, ngayKetThuc = ?, GiaGiam = ?, trangThai = ?, ghiChu=?\n"
                + "where idKM like (select idKM from khuyenMai where maKM = ?)";
        try {
            con = DBConnect.getDBConnect();
            ps = con.prepareStatement(sql);
            ps.setObject(1, km.getMaKM());
            ps.setObject(2, km.getTenKM());
            ps.setObject(3, km.getNgayBD());
            ps.setObject(4, km.getNgayKT());
            ps.setObject(5, km.getGiamGia());
            ps.setObject(6, km.getTrangThai());
            ps.setObject(7, km.getGhiChu());
            ps.setObject(8, a);
            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }

    public int updateTrangThai() {
        String sql = "update khuyenMai set trangThai = N'Đã hết hạn' where day(ngayKetThuc)< DAY(GETDATE()) and month(ngayKetThuc)<= month(GETDATE()) and year(ngayKetThuc)<= year(GETDATE())";
        try {
            con = DBConnect.getDBConnect();
            ps = con.prepareStatement(sql);
            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }

    public int updateTrangThaikt2() {
        String sql = "update khuyenMai set trangThai = N'Đã hết hạn' where month(ngayKetThuc)< month(GETDATE()) and year(ngayKetThuc)<= year(GETDATE())";
        try {
            con = DBConnect.getDBConnect();
            ps = con.prepareStatement(sql);
            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }

    public int updateTrangThaikt3() {
        String sql = "update khuyenMai set trangThai = N'Đã hết hạn' where year(ngayKetThuc)< year(GETDATE())";
        try {
            con = DBConnect.getDBConnect();
            ps = con.prepareStatement(sql);
            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }

    public int updateTrangThaiBD() {
        String sql = "update khuyenMai set trangThai = N'Đang áp dụng' where day(ngayBatDau)>= DAY(GETDATE()) and month(ngayBatDau) >= month(GETDATE()) and year(ngayBatDau)>= year(GETDATE())";
        try {
            con = DBConnect.getDBConnect();
            ps = con.prepareStatement(sql);
            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }

    public int deleteKM(String ma) {
        String sql = "delete khuyenMai\n"
                + "where idKM like (select idKM from khuyenMai where maKM = ?)";
        try {
            con = DBConnect.getDBConnect();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }

//    public String getGiaGiamFromKhuyenMai(String tenChuongTrinh) {
//        Connection con = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        try {
//            con = DBConnect.getDBConnect();
//
//            // Truy vấn sử dụng PreparedStatement với tham số
//            String sql = "SELECT GiaGiam FROM khuyenMai WHERE idKM = (SELECT idKM FROM khuyenMai WHERE tenKM = ?)";
//            ps = con.prepareStatement(sql);
//            ps.setString(1, tenChuongTrinh);
//
//            rs = ps.executeQuery();
//
//            // Kiểm tra xem có kết quả hay không
//            if (rs.next()) {
//                // Lấy giá trị từ cột GiaGiam
//                return rs.getString("GiaGiam");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            // Đảm bảo đóng tất cả các resource
//            try {
//                if (rs != null) {
//                    rs.close();
//                }
//                if (ps != null) {
//                    ps.close();
//                }
//                if (con != null) {
//                    con.close();
//                }
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//        }
//        return null; // Trả về giá trị mặc định nếu có lỗi hoặc không có kết quả
//    }
}
