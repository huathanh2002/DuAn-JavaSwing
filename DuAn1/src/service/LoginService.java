/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import model.NhanVienModel;
import model.UserLoginModel;
import utility.DBConnect;
import view.viewLogin;

/**
 *
 * @author THANH
 */
public class LoginService {
    public static boolean checkLogin(String taiKhoan, String matKhau) {
        int row = 0;
        try {
            Connection con = DBConnect.getDBConnect();
            Statement stm = con.createStatement();
            String sSQL = "SELECT NhanVien.maNV, matKhau, chucVu.tenCV FROM nhanVien JOIN chucVu ON NhanVien.id_chucVu=chucVu.idCV  WHERE NhanVien.maNV='" + taiKhoan + "' AND matKhau='" + matKhau + "'";
            ResultSet rs = stm.executeQuery(sSQL);
            while (rs.next()) {
                row = 1;
                String taiKhoan1 = rs.getString(1);
                String pwd = rs.getString(2);
                String role = rs.getString(3);
                viewLogin.USER = new UserLoginModel(taiKhoan, matKhau, role);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (row > 0);
    }
//
//    public NhanVienModel getLoggedInNhanVien(String taiKhoan, String matKhau) {
//        NhanVienModel loggedInNhanVien = new NhanVienModel();
//        Connection con = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//
//        try {
//            con = DBConnect.getDBConnect();
//            String sql = "SELECT * FROM NhanVien WHERE maNV = ? AND matKhau = ?";
//            stmt = con.prepareStatement(sql);
//            // Thiết lập giá trị cho các tham số
//            stmt.setString(1, taiKhoan);
//            stmt.setString(2, matKhau);
//            System.out.println("SQL query: " + sql);
//            
//            rs = stmt.executeQuery();
//
//            if (rs.next()) {
//                loggedInNhanVien = new NhanVienModel();
//                loggedInNhanVien.setId(rs.getString("idNV"));
//                loggedInNhanVien.setChucVu((String) rs.getObject("id_chucVu"));
//                loggedInNhanVien.setMa(rs.getString("maNV"));
//                loggedInNhanVien.setHoTen(rs.getString("tenNV"));
//                loggedInNhanVien.setNgaySinh(rs.getDate("ngaySinh"));
//                loggedInNhanVien.setDiaChi(rs.getString("diaChi"));
//                loggedInNhanVien.setsDT(rs.getString("soDienThoai"));
//                loggedInNhanVien.setMatKhau(rs.getString("matKhau"));
//                loggedInNhanVien.setTrangThai(rs.getString("trangThai"));
//                loggedInNhanVien.setGioiTinh(rs.getString("gioiTinh"));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return loggedInNhanVien;
//    }
//
//    public void setCredentials(UserLoginModel userLoginModel) {
//        String taiKhoan = userLoginModel.getTaiKhoan();
//        String matKhau = userLoginModel.getMatKhau();
//    }
}
