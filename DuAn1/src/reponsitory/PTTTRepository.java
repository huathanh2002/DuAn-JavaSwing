/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reponsitory;

import java.util.ArrayList;
import java.util.List;
import model.PTTToan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utility.JDBCHelper;

/**
 *
 * @author natsu
 */
public class PTTTRepository {

    public List<PTTToan> getAll() {
        List<PTTToan> list = new ArrayList<>();
        String sql = "select * from phuongThucThanhToan";
        ResultSet rs = JDBCHelper.excuteQuery(sql);
        try {
            while (rs.next()) {
                String id = rs.getString("idPTTT");
                String ma = rs.getString("maPTTT");
                String ten = rs.getString("tenPTTT");
                String trangThai = rs.getString("trangThai");
                list.add(new PTTToan(id, ma, ten, trangThai));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PTTTRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
