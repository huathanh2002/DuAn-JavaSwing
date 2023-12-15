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
import model.Size;
import utility.DBConnect;
import utility.JDBCHelper;
import java.sql.*;

/**
 *
 * @author natsu
 */
public class SizeRepository {

    public List<Size> getAll() {
        List<Size> list = new ArrayList<>();
        String sql = "select * from size";
        ResultSet rs = JDBCHelper.excuteQuery(sql);
        try {
            while (rs.next()) {
                String id = rs.getString("idS");
                String ma = rs.getString("maS");
                String ten = rs.getString("tenS");

                list.add(new Size(id, ma, ten));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThuongHieuReponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public Integer addSP(Size s) {
        String sql = "insert into size(maS,tenS) values(?,?)";
        Integer row;
        row = JDBCHelper.excuteUpdate(sql,
                s.getMaSize(),
                s.getTenSize()
        );
        return row;
    }

    public Integer updateSP(Size s, String id) {
        String sql = "update size\n"
                + "set maS =?,tenS=?\n"
                + "where idS=?";
        try {
            Integer row = JDBCHelper.excuteUpdate(sql,
                    s.getMaSize(),
                    s.getTenSize(),
                    id
            );
            return row;
        } catch (Exception e) {
        }
        return -1;
    }

    public Integer deleteSP(String ma) {
        String sql = "delete size\n"
                + "where idS =?";
        try {
            Integer row = JDBCHelper.excuteUpdate(sql, ma);
            return row;
        } catch (Exception e) {
        }
        return -1;
    }

    public List<Size> getSize(String s) {
        List<Size> list = new ArrayList<>();
        String sql = "select maS, tenS from size where maS like ? or tenS like ?";
        try {
            Connection con = DBConnect.getDBConnect();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, s);
            ps.setObject(2, s);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Size si = new Size(rs.getString(1), rs.getString(2));
                list.add(si);
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

    public Size getMaSize(String ma) {
        String sql = "Select maS,tenS from size where maS like ?";
        Size s = null;
        try {
            Connection con = DBConnect.getDBConnect();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                s = new Size(rs.getString(1), rs.getString(2));
            }
            return s;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
