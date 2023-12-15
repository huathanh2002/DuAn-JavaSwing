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
import model.ChatLieu;
import model.DanhMuc;
import utility.DBConnect;
import utility.JDBCHelper;

/**
 *
 * @author natsu
 */
public class ChatLieuRepository {

    public List<ChatLieu> getAll() {
        List<ChatLieu> list = new ArrayList<>();
        String sql = "select * from chatLieu";
        ResultSet rs = JDBCHelper.excuteQuery(sql);
        try {
            while (rs.next()) {
                String id = rs.getString("idCL");
                String ma = rs.getString("maCL");
                String ten = rs.getString("tenCL");

                list.add(new ChatLieu(id, ma, ten));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThuongHieuReponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public Integer addSP(ChatLieu cl) {
        String sql = "insert into chatLieu(maCL,tenCL) values(?,?)";
        Integer row;
        row = JDBCHelper.excuteUpdate(sql,
                cl.getMaChatLieu(),
                cl.getTenChatLieu()
        );
        return row;
    }

    public Integer updateSP(ChatLieu cl, String id) {
        String sql = "update chatLieu\n"
                + "set maCL =?,tenCL=?\n"
                + "where idCL=?";
        try {
            Integer row = JDBCHelper.excuteUpdate(sql,
                    cl.getMaChatLieu(),
                    cl.getTenChatLieu(),
                    id
            );
            return row;
        } catch (Exception e) {
        }
        return -1;
    }

    public Integer deleteSP(String ma) {
        String sql = "delete chatLieu\n"
                + "where idCL =?";
        try {
            Integer row = JDBCHelper.excuteUpdate(sql, ma);
            return row;
        } catch (Exception e) {
        }
        return -1;
    }

    public List<ChatLieu> timcl(String chalieu) {
        List<ChatLieu> listSP = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement sttm = null;
        Connection con = null;

        try {
            String sSQL = "SELECT maCL,tenCL "
                    + "FROM chatLieu "
                    + "WHERE tenCL LIKE ?";
            con = DBConnect.getDBConnect();
            sttm = con.prepareStatement(sSQL);
            sttm.setString(1, "%" + chalieu + "%");
//            sttm.setString(1,"N'"+ "%" + ten + "%'");

            rs = sttm.executeQuery();

            while (rs.next()) {
                ChatLieu cl = new ChatLieu();
                cl.setTenChatLieu(rs.getString(2));
                cl.setMaChatLieu(rs.getString(1));

                listSP.add(cl);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("loi" + e.toString());
        }

        return listSP;
    }

    public ChatLieu getMaChatLieu(String ma) {
        String sql = "Select maCL,tenCL from chatLieu where maCL like ?";
        ChatLieu m = null;
        try {
            Connection con = DBConnect.getDBConnect();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                m = new ChatLieu(rs.getString(1), rs.getString(2));
            }
            return m;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
