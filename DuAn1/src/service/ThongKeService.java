/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.*;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import model.ThongKe;
import utility.DBConnect;

/**
 *
 * @author THANH
 */
public class ThongKeService {

    Connection con = null;
    PreparedStatement sttm = null;

    public double tinhTongDoanhThu(java.sql.Date ngayBatDau, java.sql.Date ngayKetThuc) {
        double tongDoanhThu = 0.0;
        ResultSet rs = null;
        String query = "SELECT SUM(giaTien) AS TongDoanhThu FROM hoaDon WHERE ngayThanhToan BETWEEN ? AND ?";

        try {
            con = DBConnect.getDBConnect();
            sttm = con.prepareStatement(query);

            sttm.setDate(1, ngayBatDau);
            sttm.setDate(2, ngayKetThuc);

            rs = sttm.executeQuery();

            if (rs.next()) {
                tongDoanhThu = rs.getDouble("TongDoanhThu");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (sttm != null) {
                    sttm.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return tongDoanhThu;
    }

    public double tinhTongDoanhThuNgayHienTai() {
        double tongDoanhThu = 0.0;
        ResultSet rs = null;
        String query = "SELECT SUM(giaTien) AS TongDoanhThu FROM hoaDon WHERE CONVERT(date, ngayThanhToan) = CONVERT(date, GETDATE())";

        try {
            con = DBConnect.getDBConnect();
            sttm = con.prepareStatement(query);

            rs = sttm.executeQuery();

            if (rs.next()) {
                tongDoanhThu = rs.getDouble("TongDoanhThu");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (sttm != null) {
                    sttm.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return tongDoanhThu;
    }

    public List<ThongKe> getAll() {
        ResultSet rs = null;
        List<ThongKe> listNV = new ArrayList<>();
        Statement sttm = null;
//        String sSQL_getAll = "SELECT nhanVien.maNV,nhanVien.tenNV,gioiTinh,chucVu.tenCV,matKhau,ngaySinh,diaChi,soDienThoai,nhanVien.idNV,trangThai FROM nhanVien INNER JOIN chucVu ON nhanVien.id_chucVu=chucVu.idCV";
        String query = "SELECT q.maQA, q.tenQA, SUM(ch.soLuong) AS soLuongBan "
                + "FROM quanAo q "
                + "INNER JOIN chiTietSP sp ON q.idQA = sp.id_quanAo "
                + "INNER JOIN chiTietHoaDOn ch ON sp.idCTSP = ch.id_chiTietSP "
                + "GROUP BY q.maQA, q.tenQA "
                + "ORDER BY soLuongBan DESC ";
        try {
//            String sql = "select MaNH,HoTen,NgaySinh,DienThoai from NguoiHoc";
            con = DBConnect.getDBConnect();
            sttm = con.createStatement();
            rs = sttm.executeQuery(query);

            while (rs.next()) {
                ThongKe nv = new ThongKe();
                nv.setMa(rs.getString(1));
                nv.setTen(rs.getString(2));
                nv.setSoLuong(rs.getDouble(3));

                listNV.add(nv);
            }

        } catch (Exception e) {
        }
        return listNV;
    }

    public int soLuongKH() {
        int soLuong = 0;

        try {
            con = DBConnect.getDBConnect();
            String query = "SELECT COUNT(*) AS total_customers FROM khachHang";
            sttm = con.prepareStatement(query);
            ResultSet rs = sttm.executeQuery();
            if (rs.next()) {
                soLuong = rs.getInt("total_customers");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return soLuong;
    }

    public int soLuongHD() {
        int soLuong = 0;

        try {
            con = DBConnect.getDBConnect();
            String query = "SELECT COUNT(*) AS total_customers FROM hoaDOn";
            sttm = con.prepareStatement(query);
            ResultSet rs = sttm.executeQuery();
            if (rs.next()) {
                soLuong = rs.getInt("total_customers");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return soLuong;
    }

    public double doanhThu() {
        double tong = 0.0;

        con = DBConnect.getDBConnect();
        if (con != null) {
            try {
                String query = "SELECT SUM(giaTien) AS TotalRevenue FROM hoaDon";
                sttm = con.prepareStatement(query);
                ResultSet rs = sttm.executeQuery();

                if (rs.next()) {
                    tong = rs.getDouble("TotalRevenue");
                }

                rs.close();
                sttm.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return tong;
    }

    public double doanhThuThangTruoc() {
        double doanhThuThangTruoc = 0.0;

        con = DBConnect.getDBConnect();
        if (con != null) {
            try {
                LocalDate ngayDauThangTruoc = LocalDate.now().minusMonths(1).withDayOfMonth(1);
                LocalDate ngayCuoiThangTruoc = YearMonth.from(ngayDauThangTruoc).atEndOfMonth();
                String query = "SELECT SUM(giaTien) AS TotalRevenue FROM hoaDon WHERE ngayThanhToan >= ? AND ngayThanhToan <= ?";
                sttm = con.prepareStatement(query);
                sttm.setDate(1, Date.valueOf(ngayDauThangTruoc));
                sttm.setDate(2, Date.valueOf(ngayCuoiThangTruoc));
                ResultSet rs = sttm.executeQuery();
                if (rs.next()) {
                    doanhThuThangTruoc = rs.getDouble("TotalRevenue");
                }
                rs.close();
                sttm.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return doanhThuThangTruoc;
    }

    public double doanhThuThangHienTai() {
        double doanhThuThangHienTai = 0.0;

        con = DBConnect.getDBConnect();
        if (con != null) {
            try {
                LocalDate ngayDauThangHienTai = YearMonth.now().atDay(1);
                LocalDate ngayCuoiThangHienTai = YearMonth.now().atEndOfMonth();
                String query = "SELECT SUM(giaTien) AS TotalRevenue FROM hoaDon WHERE ngayThanhToan >= ? AND ngayThanhToan <= ?";
                sttm = con.prepareStatement(query);
                sttm.setDate(1, Date.valueOf(ngayDauThangHienTai));
                sttm.setDate(2, Date.valueOf(ngayCuoiThangHienTai));
                ResultSet rs = sttm.executeQuery();
                if (rs.next()) {
                    doanhThuThangHienTai = rs.getDouble("TotalRevenue");
                }
                rs.close();
                sttm.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return doanhThuThangHienTai;
    }

    public double tinhTongDoanhThu(java.util.Date ngaybdd, java.util.Date ngayktt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
