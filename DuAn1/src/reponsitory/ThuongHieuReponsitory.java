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
import model.ThuongHieu;
import utility.JDBCHelper;

/**
 *
 * @author natsu
 */
public class ThuongHieuReponsitory {

    public List<ThuongHieu> getAll() {
        List<ThuongHieu> list = new ArrayList<>();
        String sql = "select * from thuongHieu";
        ResultSet rs = JDBCHelper.excuteQuery(sql);
        try {
            while (rs.next()) {
                String id = rs.getString("idTH");
                String ma = rs.getString("maTH");
                String ten = rs.getString("tenTH");

                list.add(new ThuongHieu(id, ma, ten));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThuongHieuReponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public Integer addSP(ThuongHieu th) {
        String sql = "insert into thuongHieu(maTH,tenTH) values(?,?)";
        Integer row;
        row = JDBCHelper.excuteUpdate(sql,
                th.getMaTH(),
                th.getTenTH()
        );
        return row;
    }

    public Integer updateSP(ThuongHieu th, String id) {
        String sql = "update thuongHieu\n"
                + "set tenTH=?\n"
                + "where idTH=?";
        try {
            Integer row = JDBCHelper.excuteUpdate(sql,
                    th.getTenTH(),
                    id
            );
            return row;
        } catch (Exception e) {
        }
        return -1;
    }

    public Integer deleteSP(String ma) {
        String sql = "delete thuongHieu\n"
                + "where idTH =?";
        try {
            Integer row = JDBCHelper.excuteUpdate(sql, ma);
            return row;
        } catch (Exception e) {
        }
        return -1;
    }

    public ThuongHieu findById(String id) {
        ThuongHieu thuongHieu = null;
        String sql = "SELECT * FROM thuongHieu WHERE idTH = ?";
        ResultSet rs = JDBCHelper.excuteQuery(sql, id);
        try {
            while (rs.next()) {
                String tenThuongHieu = rs.getString("tenTH");
                thuongHieu = new ThuongHieu(id, tenThuongHieu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThuongHieuReponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return thuongHieu;
    }
    public List<ThuongHieu> searchByName(String name) {
        List<ThuongHieu> list = new ArrayList<>();
        String sql = "select * from thuongHieu where tenTH like ?";
        ResultSet rs = JDBCHelper.excuteQuery(sql,"%" +name+ "%");
        try {
            while (rs.next()) {
                String id = rs.getString("idTH");
                String ma = rs.getString("maTH");
                String ten = rs.getString("tenTH");

                list.add(new ThuongHieu(id, ma, ten));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThuongHieuReponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
}
