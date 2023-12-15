/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reponsitory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.MauSac;
import utility.JDBCHelper;
import java.sql.*;
import utility.DBConnect;

/**
 *
 * @author natsu
 */
public class MauSacRepository {

    public List<MauSac> getAll() {
        List<MauSac> list = new ArrayList<>();
        String sql = "select * from mauSac";
        ResultSet rs = JDBCHelper.excuteQuery(sql);
        try {
            while (rs.next()) {
                String id = rs.getString("idMS");
                String ma = rs.getString("maMS");
                String ten = rs.getString("tenMS");

                list.add(new MauSac(id, ma, ten));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThuongHieuReponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public Integer addSP(MauSac ms) {
        String sql = "insert into mauSac(maMS,tenMS) values(?,?)";
        Integer row;
        row = JDBCHelper.excuteUpdate(sql,
                ms.getMaMauSac(),
                ms.getTenMauSac()
        );
        return row;
    }

    public Integer updateSP(MauSac ms, String id) {
        String sql = "update mauSac\n"
                + "set maMS =?,tenMS=?\n"
                + "where idMS=?";
        try {
            Integer row = JDBCHelper.excuteUpdate(sql,
                    ms.getMaMauSac(),
                    ms.getTenMauSac(),
                    id
            );
            return row;
        } catch (Exception e) {
        }
        return -1;
    }

    public Integer deleteSP(String ma) {
        String sql = "delete mauSac\n"
                + "where idMS =?";
        try {
            Integer row = JDBCHelper.excuteUpdate(sql, ma);
            return row;
        } catch (Exception e) {
        }
        return -1;
    }
    
    public List<MauSac> searchName(String name) {
        List<MauSac> list = new ArrayList<>();
        String sql = "select * from mauSac where tenMS like ?";
        ResultSet rs = JDBCHelper.excuteQuery(sql,"%" +name+ "%");
        try {
            while (rs.next()) {
                String id = rs.getString("idMS");
                String ma = rs.getString("maMS");
                String ten = rs.getString("tenMS");

                list.add(new MauSac(id, ma, ten));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MauSacRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
    public MauSac getMaMau(String ma){
        String sql="Select maMS,tenMS from mauSac where maMS like ?";
        MauSac m = null;
        try {
            Connection con = DBConnect.getDBConnect();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               m= new MauSac(rs.getString(1), rs.getString(2));
            }
            return m;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
