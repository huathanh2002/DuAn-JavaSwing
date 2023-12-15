/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reponsitory;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DanhMuc;
import model.SanPham;
import model.ThuongHieu;
import utility.DBConnect;
import utility.JDBCHelper;
import java.sql.*;

/**
 *
 * @author natsu
 */
public class SanPhamRepository {

    Connection con = null;

    public List<SanPham> getAll() {
        List<SanPham> list = new ArrayList<SanPham>();
        String sql = "select * from quanAo\n"
                + "                inner join danhMuc on quanAo.id_danhMuc = danhMuc.idDM\n"
                + "                inner join thuongHieu on quanAo.id_thuongHieu = thuongHieu.idTH";
        ResultSet rs = JDBCHelper.excuteQuery(sql);
        try {
            while (rs.next()) {
                String id = rs.getString("idQA");
                String ma = rs.getString("maQA");
                String ten = rs.getString("tenQA");
                DanhMuc dm = new DanhMuc(rs.getString("idDM"), rs.getString("maDM"), rs.getString("tenDM"));
                ThuongHieu th = new ThuongHieu(rs.getString("idTH"), rs.getString("maTH"), rs.getString("tenTH"));

                list.add(new SanPham(id, th, dm, ma, ten));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public Integer addSP(SanPham sp) {
        String sql = "insert into quanAo(id_thuongHieu,id_danhMuc,maQA,tenQA) values(?,?,?,?)";
        Integer row;
        row = JDBCHelper.excuteUpdate(sql,
                sp.getTh().getId(),
                sp.getDm().getId(),
                sp.getMaSP(),
                sp.getTenSP()
        // sp.getTh().getId()
        );
        return row;
    }

    public Integer updateSP(SanPham sp, String id) {
        String sql = "update quanAo\n"
                + "set id_thuongHieu=?,id_danhMuc=?,maQA =?,tenQA=?\n"
                + "where idQA=?";
        try {
            Integer row = JDBCHelper.excuteUpdate(sql,
                    sp.getTh().getId(),
                    sp.getDm().getId(),
                    sp.getMaSP(),
                    sp.getTenSP(),
                    id
            );
            return row;
        } catch (Exception e) {
        }
        return -1;
    }

    public Integer deleteSP(String ma) {
        String sql = "delete quanAo\n"
                + "where idQA =?";
        try {
            Integer row = JDBCHelper.excuteUpdate(sql, ma);
            return row;
        } catch (Exception e) {
        }
        return -1;
    }

    public List<SanPham> timTen(String ten) {
        List<SanPham> listSP = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement sttm = null;
        Connection con = null;

        try {
            String sSQL = "SELECT quanAo.maQA, quanAo.tenQA, danhMuc.tenDM, thuongHieu.tenTH "
                    + "FROM quanAo "
                    + "JOIN danhMuc ON danhMuc.idDM = quanAo.id_danhMuc "
                    + "JOIN thuongHieu ON thuongHieu.idTH = quanAo.id_thuongHieu "
                    + "WHERE quanAo.tenQA LIKE ? or thuongHieu.tenTH LIKE ? or danhMuc.tenDM LIKE ? or quanAo.maQA like ?";
            con = DBConnect.getDBConnect();
            sttm = con.prepareStatement(sSQL);
            sttm.setString(1, "%" + ten + "%");
            sttm.setString(2, "%" + ten + "%");
            sttm.setString(3, "%" + ten + "%");
            sttm.setString(4, "%" + ten + "%");
//            sttm.setString(1,"N'"+ "%" + ten + "%'");
            
            rs = sttm.executeQuery();
            
            while (rs.next()) {
                SanPham nv = new SanPham();
                nv.setMaSP(rs.getString(1));
                nv.setTenSP(rs.getString(2));

                DanhMuc dm = new DanhMuc();
                dm.setTenDanhMuc(rs.getString(3));

                ThuongHieu th = new ThuongHieu();
                th.setTenTH(rs.getString(4));

                nv.setDm(dm);
                nv.setTh(th);

                listSP.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
            System.out.println("loi"+e.toString());
        } 

        return listSP;
    }

    public List<SanPham> timTH(String thuongHieu) {
        List<SanPham> listSP = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement sttm = null;
        Connection con = null;

        try {
            String sSQL = "SELECT quanAo.maQA, quanAo.tenQA, danhMuc.tenDM, thuongHieu.tenTH "
                    + "FROM quanAo "
                    + "JOIN danhMuc ON danhMuc.idDM = quanAo.id_danhMuc "
                    + "JOIN thuongHieu ON thuongHieu.idTH = quanAo.id_thuongHieu "
                    + "WHERE thuongHieu.tenTH LIKE ?";
            con = DBConnect.getDBConnect();
            sttm = con.prepareStatement(sSQL);
            sttm.setString(1, "%" + thuongHieu + "%");
//            sttm.setString(1,"N'"+ "%" + ten + "%'");
            
            rs = sttm.executeQuery();
            
            while (rs.next()) {
                SanPham nv = new SanPham();
                nv.setMaSP(rs.getString(1));
                nv.setTenSP(rs.getString(2));

                DanhMuc dm = new DanhMuc();
                dm.setTenDanhMuc(rs.getString(3));

                ThuongHieu th = new ThuongHieu();
                th.setTenTH(rs.getString(4));

                nv.setDm(dm);
                nv.setTh(th);

                listSP.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
            System.out.println("loi"+e.toString());
        } 

        return listSP;
    }
    
    public List<SanPham> timDM(String danhMuc) {
        List<SanPham> listSP = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement sttm = null;
        Connection con = null;

        try {
            String sSQL = "SELECT quanAo.maQA, quanAo.tenQA, danhMuc.tenDM, thuongHieu.tenTH "
                    + "FROM quanAo "
                    + "JOIN danhMuc ON danhMuc.idDM = quanAo.id_danhMuc "
                    + "JOIN thuongHieu ON thuongHieu.idTH = quanAo.id_thuongHieu "
                    + "WHERE danhMuc.tenDM LIKE ?";
            con = DBConnect.getDBConnect();
            sttm = con.prepareStatement(sSQL);
            sttm.setString(1, "%" + danhMuc + "%");
//            sttm.setString(1,"N'"+ "%" + ten + "%'");
            
            rs = sttm.executeQuery();
            
            while (rs.next()) {
                SanPham nv = new SanPham();
                nv.setMaSP(rs.getString(1));
                nv.setTenSP(rs.getString(2));

                DanhMuc dm = new DanhMuc();
                dm.setTenDanhMuc(rs.getString(3));

                ThuongHieu th = new ThuongHieu();
                th.setTenTH(rs.getString(4));

                nv.setDm(dm);
                nv.setTh(th);

                listSP.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
            System.out.println("loi"+e.toString());
        } 

        return listSP;
    }
    public int checkMa(String ma) {
        try {
            String sSQL="select quanAo.maQA from quanAo where quanAo.maQA=?";
            con=utility.DBConnect.getDBConnect();
            PreparedStatement sttm=con.prepareStatement(sSQL);
            
            sttm.setString(1, ma);
            ResultSet rs=sttm.executeQuery();
            while(rs.next()){
                return 1;
            }
            
        } catch (Exception e) {
        }
        return -1;
    }
}
