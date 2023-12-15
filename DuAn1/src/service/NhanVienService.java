/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import model.NhanVienModel;
import reponsitory.NhanVienITF;
import utility.DBConnect;

/**
 *
 * @author THANH
 */
public class NhanVienService implements NhanVienITF {

    Connection con = null;
    PreparedStatement sttm = null;
    String sSQL_getAll = "SELECT nhanVien.maNV,nhanVien.tenNV,gioiTinh,chucVu.tenCV,matKhau,ngaySinh,diaChi,soDienThoai,nhanVien.idNV,trangThai FROM nhanVien INNER JOIN chucVu ON nhanVien.id_chucVu=chucVu.idCV";
    String sSQL_add = "   INSERT INTO nhanVien(idNV,id_chucVu,maNV,tenNV,matKhau,soDienThoai,gioiTinh,ngaySinh,diaChi,trangThai) VALUES (?,(SELECT idCV FROM chucVu WHERE tenCV=?),?,?,?,?,?,?,?,?)";
    String sSQL_delete = "DELETE nhanVien WHERE idNV=?";
    String sSQL_update = "UPDATE nhanVien SET id_chucVu=(SELECT idCV FROM chucVu WHERE tenCV=?), maNV=?,tenNV=?, matKhau=?, soDienThoai=?,gioiTinh=?,ngaySinh=?,diaChi=? WHERE idNV=?";

    @Override
    public List<NhanVienModel> getAll() {
        ResultSet rs = null;
        List<NhanVienModel> listNV = new ArrayList<>();
        Statement sttm = null;
        try {
//            String sql = "select MaNH,HoTen,NgaySinh,DienThoai from NguoiHoc";
            con = DBConnect.getDBConnect();
            sttm = con.createStatement();
            rs = sttm.executeQuery(sSQL_getAll);

            while (rs.next()) {
                NhanVienModel nv = new NhanVienModel();
                nv.setMa(rs.getString(1));
                nv.setHoTen(rs.getString(2));
                nv.setGioiTinh(rs.getString(3));
                nv.setChucVu(rs.getString(4));

                nv.setMatKhau(rs.getString(5));
                nv.setNgaySinh(rs.getDate(6));
                nv.setDiaChi(rs.getString(7));
                nv.setsDT(rs.getString(8));

                nv.setId(rs.getString(9));
                nv.setTrangThai(rs.getString(10));

                listNV.add(nv);
            }

        } catch (Exception e) {
        }
        return listNV;
    }

    @Override
    public int add(NhanVienModel nv) {
        try {
            con = DBConnect.getDBConnect();
            sttm = con.prepareStatement(sSQL_add);
            String uniqueID = UUID.randomUUID().toString();

            sttm.setObject(1, uniqueID);
            sttm.setObject(2, nv.getChucVu());
            sttm.setObject(3, nv.getMa());
            sttm.setObject(4, nv.getHoTen());

            sttm.setObject(5, nv.getMatKhau());
            sttm.setObject(6, nv.getsDT());

            sttm.setObject(7, nv.getGioiTinh());
            sttm.setObject(8, nv.getNgaySinh());
            sttm.setObject(9, nv.getDiaChi());
            sttm.setObject(10, nv.getTrangThai());

            if (sttm.executeUpdate() > 0) {
                return 1;
            }
        } catch (Exception e) {
            System.out.println("loi" + e.toString());
        }
        return -1;
    }

    @Override
    public int update(NhanVienModel nv, String id) {
        try {
            con = DBConnect.getDBConnect();
            sttm = con.prepareStatement(sSQL_update);

            sttm.setObject(1, nv.getChucVu());
            sttm.setObject(2, nv.getMa());
            sttm.setObject(3, nv.getHoTen());

            sttm.setObject(4, nv.getMatKhau());
            sttm.setObject(5, nv.getsDT());

            sttm.setObject(6, nv.getGioiTinh());
            sttm.setObject(7, nv.getNgaySinh());
            sttm.setObject(8, nv.getDiaChi());
            sttm.setObject(9, id);

            if (sttm.executeUpdate() > 0) {
                return 1;
            }
        } catch (Exception e) {
        }
        return -1;
    }

    @Override
    public int delete(String id) {
        try {
            con = DBConnect.getDBConnect();
            sttm = con.prepareStatement(sSQL_delete);

            sttm.setObject(1, id);
            if (sttm.executeUpdate() > 0) {
                return 1;
            }
        } catch (Exception e) {
            System.out.println("" + e.toString());
        }
        return -1;
    }

    @Override
    public int checkMa(String ma) {

        try {
            String sSQL = "select maNV from nhanVien where maNV=?";
            con = utility.DBConnect.getDBConnect();
            sttm = con.prepareStatement(sSQL);

            sttm.setObject(1, ma);
            ResultSet rs = sttm.executeQuery();
            while (rs.next()) {
                return 1;
            }

        } catch (Exception e) {
        }
        return -1;
    }

    @Override
    public List<NhanVienModel> timTen(String ten) {
        ResultSet rs = null;
        List<NhanVienModel> listNV = new ArrayList<>();

        try {
//            String sql = "select MaNH,HoTen,NgaySinh,DienThoai from NguoiHoc";
            con = DBConnect.getDBConnect();

            sttm = con.prepareStatement("SELECT nhanVien.maNV,nhanVien.tenNV,gioiTinh,chucVu.tenCV,matKhau,ngaySinh,diaChi,soDienThoai,nhanVien.idNV FROM nhanVien INNER JOIN chucVu ON nhanVien.id_chucVu=chucVu.idCV"
                    + "WHERE nhanVien.tenNV LIKE ?");
            sttm.setString(1, "%" + ten + "%");
//            sttm.setString(1,"N'"+ "%" + ten + "%'");

            rs = sttm.executeQuery();
            while (rs.next()) {
                NhanVienModel nv = new NhanVienModel();
                nv.setMa(rs.getString(1));
                nv.setHoTen(rs.getString(2));
                nv.setGioiTinh(rs.getString(3));
                nv.setChucVu(rs.getString(4));

                nv.setMatKhau(rs.getString(5));
                nv.setNgaySinh(rs.getDate(6));
                nv.setDiaChi(rs.getString(7));
                nv.setsDT(rs.getString(8));

                nv.setId(rs.getString(9));

                listNV.add(nv);
            }

        } catch (Exception e) {
        }
        return listNV;
    }

    @Override
    public String idNV(String tenCV) {
        String id = null;
        try {
            String sSQL = "select idNV from nhanVien where maNV like ?";
            con = utility.DBConnect.getDBConnect();
            sttm = con.prepareStatement(sSQL);

            sttm.setObject(1, tenCV);
            ResultSet rs = sttm.executeQuery();
            while (rs.next()) {
                 id=rs.getString(1);
            }
            return id;
        } catch (Exception e) {
            return null;
        }
        
    }

    @Override
    public int upNghiViec(String id) {
    try {
            String sSQL = " UPDATE nhanVien SET trangThai = N'Nghỉ việc' where idNV = ?";
            con = utility.DBConnect.getDBConnect();
            sttm = con.prepareStatement(sSQL);

            sttm.setObject(1, id);
            if (sttm.executeUpdate() > 0) {
                return 1;
            }

        } catch (Exception e) {
        }
        return -1;
    }

    @Override
    public List<NhanVienModel> search(String a) {
         ResultSet rs = null;
        List<NhanVienModel> listNV = new ArrayList<>();
        try {
            String sql = "SELECT nhanVien.maNV,nhanVien.tenNV,gioiTinh,chucVu.tenCV,matKhau,ngaySinh,diaChi,soDienThoai,nhanVien.idNV,trangThai FROM nhanVien INNER JOIN chucVu ON nhanVien.id_chucVu=chucVu.idCV\n"
                            +"where nhanVien.maNV like ? or nhanVien.tenNV like ? or chucVu.tenCV like ? or matKhau like ? or ngaySinh like ? or diaChi like ? or soDienThoai like ? or trangThai like ?";
            con = DBConnect.getDBConnect();
            sttm = con.prepareStatement(sql);
            sttm.setString(1, "%"+a+"%");
            sttm.setString(2, "%"+a+"%");
            sttm.setString(3, "%"+a+"%");
            sttm.setString(4, "%"+a+"%");
            sttm.setString(5, "%"+a+"%");
            sttm.setString(6, "%"+a+"%");
            sttm.setString(7, "%"+a+"%");
            sttm.setString(8, "%"+a+"%");
            rs = sttm.executeQuery();

            while (rs.next()) {
                NhanVienModel nv = new NhanVienModel();
                nv.setMa(rs.getString(1));
                nv.setHoTen(rs.getString(2));
                nv.setGioiTinh(rs.getString(3));
                nv.setChucVu(rs.getString(4));

                nv.setMatKhau(rs.getString(5));
                nv.setNgaySinh(rs.getDate(6));
                nv.setDiaChi(rs.getString(7));
                nv.setsDT(rs.getString(8));

                nv.setId(rs.getString(9));
                nv.setTrangThai(rs.getString(10));

                listNV.add(nv);
            }

        } catch (Exception e) {
        }
        return listNV;
    }
    
}
