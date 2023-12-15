/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reponsitory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DanhMuc;
import model.SanPham;
import model.ThuongHieu;
import utility.DBConnect;
import utility.JDBCHelper;

/**
 *
 * @author natsu
 */
public class DanhMucReponsitory {

    public List<DanhMuc> getAll() {
        List<DanhMuc> list = new ArrayList<>();
        String sql = "select * from danhMuc";
        ResultSet rs = JDBCHelper.excuteQuery(sql);
        try {
            while (rs.next()) {
                String id = rs.getString("idDM");
                String ma = rs.getString("maDM");
                String ten = rs.getString("tenDM");

                list.add(new DanhMuc(id, ma, ten));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThuongHieuReponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public Integer addSP(DanhMuc dm) {
        String sql = "insert into danhMuc(maDM,tenDM) values(?,?)";
        Integer row;
        row = JDBCHelper.excuteUpdate(sql,
                dm.getMaDanhMuc(),
                dm.getTenDanhMuc()
        );
        return row;
    }

    public Integer updateSP(DanhMuc dm, String id) {
        String sql = "update danhMuc\n"
                + "set maDM =?,tenDM=?\n"
                + "where idDM=?";
        try {
            Integer row = JDBCHelper.excuteUpdate(sql,
                    dm.getMaDanhMuc(),
                    dm.getTenDanhMuc(),
                    id
            );
            return row;
        } catch (Exception e) {
        }
        return -1;
    }

    public Integer deleteSP(String ma) {
        String sql = "delete danhMuc\n"
                + "where idDM =?";
        try {
            Integer row = JDBCHelper.excuteUpdate(sql, ma);
            return row;
        } catch (Exception e) {
        }
        return -1;
    }

    public DanhMuc findById(String id) {
        DanhMuc danhMuc = null;
        String sql = "SELECT * FROM danhMuc WHERE idDM = ?";
        ResultSet rs = JDBCHelper.excuteQuery(sql, id);
        try {
            while (rs.next()) {
                String tenThuongHieu = rs.getString("tenDM");
                danhMuc = new DanhMuc(id, tenThuongHieu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThuongHieuReponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return danhMuc;
    }
     public DanhMuc findByMa(String ma) {
        DanhMuc danhMuc = null;
        String sql = "SELECT * FROM danhMuc WHERE maDM = ?";
        ResultSet rs = JDBCHelper.excuteQuery(sql, ma);
        try {
            while (rs.next()) {
                String tenThuongHieu = rs.getString("tenDM");
                danhMuc = new DanhMuc(ma, tenThuongHieu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThuongHieuReponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return danhMuc;
    }
    public List<DanhMuc> timDM(String danhMuc) {
        List<DanhMuc> listSP = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement sttm = null;
        Connection con = null;

        try {
            String sSQL = "SELECT maDM,tenDM "
                    + "FROM danhMuc "
                    + "WHERE tenDM LIKE ?";
            con = DBConnect.getDBConnect();
            sttm = con.prepareStatement(sSQL);
            sttm.setString(1, "%" + danhMuc + "%");
//            sttm.setString(1,"N'"+ "%" + ten + "%'");
            
            rs = sttm.executeQuery();
            
            while (rs.next()) {
                DanhMuc dm = new DanhMuc();
                dm.setTenDanhMuc(rs.getString(2));
                dm.setMaDanhMuc(rs.getString(1));
                
                listSP.add(dm);
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
            System.out.println("loi"+e.toString());
        } 

        return listSP;
    }
        public DanhMuc select(String id) {
        DanhMuc danhMuc = null;
        String sql = "SELECT * FROM danhMuc WHERE idDM = ?";
        ResultSet rs = JDBCHelper.excuteQuery(sql, id);
        try {
            while (rs.next()) {
                String tenThuongHieu = rs.getString("tenDM");
                danhMuc = new DanhMuc(id, tenThuongHieu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThuongHieuReponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return danhMuc;
    }
}
