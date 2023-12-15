package reponsitory;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.KhachHang;
import utility.JDBCHelper;
import java.sql.*;
import utility.DBConnect;

public class KhachHangRepository {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    public List<KhachHang> getAll() {
        List<KhachHang> list = new ArrayList<>();

        try {
            // Sử dụng JDBC Helper để lấy kết nối
            con = DBConnect.getDBConnect();

            // Sử dụng PreparedStatement để tránh tình trạng SQL Injection
            String sql = "SELECT idKH,ma, ten, soDienThoai, diaChi, ngaySinh FROM KhachHang";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                // Tạo đối tượng KhachHang từ kết quả truy vấn
                KhachHang khachHang = new KhachHang(
                        rs.getString("idKH"),
                        rs.getString("ma"),
                        rs.getString("ten"),
                        rs.getString("soDienThoai"),
                        rs.getString("diaChi"),
                        rs.getDate("ngaySinh")
                );
                list.add(khachHang);
            }

            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public KhachHang getMa(String a) {
        KhachHang kh = null;
        String sql = "select ma,ten,soDienThoai,diaChi,ngaySinh from KhachHang where ma like ?";
        try {
            con = DBConnect.getDBConnect();
            ps = con.prepareStatement(sql);
            ps.setObject(1, a);
            rs = ps.executeQuery();
            while (rs.next()) {
                kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
            }
            return kh;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<KhachHang> getSearch(String a) {
        List<KhachHang> list = new ArrayList<KhachHang>();
        String sql = "select ma,ten,soDienThoai,diaChi,ngaySinh from KhachHang\n"
                + "where ma like ? or ten like ? or soDienThoai like ? or diaChi like ? or ngaySinh like ?";
        try {
            con = DBConnect.getDBConnect();
            ps = con.prepareStatement(sql);
            ps.setObject(1, a);
            ps.setObject(2, a);
            ps.setObject(3, a);
            ps.setObject(4, a);
            ps.setObject(5, a);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5)));
            }
            if (list.isEmpty()) {
                return null;
            } else {
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int addKH(KhachHang kh) {
        String sql = "insert into KhachHang(ma,ten,soDienThoai,diaChi,ngaysinh) values(?,?,?,?,?)";
        try {
            con = DBConnect.getDBConnect();
            ps = con.prepareStatement(sql);
            ps.setObject(1, kh.getMa());
            ps.setObject(2, kh.getTen());
            ps.setObject(3, kh.getSoDienThoai());
            ps.setObject(4, kh.getDiachi());
            ps.setObject(5, kh.getNgaySinh());
            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }

    public int updateKH(KhachHang kh, String a) {
        String sql = "update KhachHang\n"
                + "set ma=?,ten=?,soDienThoai=?,diaChi=?,ngaySinh=?\n"
                + "where idKH like (select idKH from khachhang where ma = ?)";
        try {
            con = DBConnect.getDBConnect();
            ps = con.prepareStatement(sql);
            ps.setObject(1, kh.getMa());
            ps.setObject(2, kh.getTen());
            ps.setObject(3, kh.getSoDienThoai());
            ps.setObject(4, kh.getDiachi());
            ps.setObject(5, kh.getNgaySinh());
            ps.setObject(6, a);
            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }

    public int deleteKH(String ma) {
        String sql = "delete KhachHang\n"
                + "where idKH like (select idKH from khachhang where ma = ?)";
        try {
            con = DBConnect.getDBConnect();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }
}
