/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.sql.Connection;
import java.sql.ResultSet;
;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author natsu
 */


public class JDBCHelper {

    private static Connection conn;

    public static void beginTransaction() throws SQLException {
        if (conn == null || conn.isClosed()) {
            conn = DBConnect.getDBConnect();
        }
        conn.setAutoCommit(false);
    }

    public static void commitTransaction() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.commit();
            conn.setAutoCommit(true);
        }
    }

    public static void rollbackTransaction() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.rollback();
                conn.setAutoCommit(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet excuteQuery(String sql, Object... args) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;

        conn = DBConnect.getDBConnect();

        try {
            preparedStatement = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            rs = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public static Integer excuteUpdate(String sql, Object... args) {
        Connection conn = null;
        Integer row = 0;
        PreparedStatement preparedStatement = null;

        conn = DBConnect.getDBConnect();

        try {
            preparedStatement = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            row = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }
    public static PreparedStatement prepareStatement(String sql) throws SQLException {
        Connection conn = DBConnect.getDBConnect();
        return conn.prepareStatement(sql);
    }
}
