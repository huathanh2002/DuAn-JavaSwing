package utility;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author THANH
 */
public class DBConnect {

    public static final String connectionUrl = "jdbc:sqlserver://localhost:1433;encrypt=true;"
            + "trustServerCertificate=true;databaseName=da;user=sa;password=123";

    public static Connection getDBConnect() {
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("ban da cai dirver jdbc");
        } catch (Exception e) {
            System.out.println("chua co driver jdbc " + e.toString());
        }

        try {
            con = DriverManager.getConnection(connectionUrl);
            System.out.println("ket noi thanh cong");
            return con;
        } catch (Exception e) {
            System.out.println("loi connect " + e.toString());
        }
        return null;
    }

    public static void main(String[] args) {
        DBConnect con = new DBConnect();
        getDBConnect();
    }

}
