/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reponsitory;

import java.util.ArrayList;
import java.util.List;
import model.ChiTietSP;
import model.HoaDon;
import model.HoaDonChiTiet;
import utility.JDBCHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.SanPham;
import java.sql.PreparedStatement;

/**
 *
 * @author natsu
 */
public class HoaDonChiTietReposistory {

    public List<HoaDonChiTiet> getAllDetails() {
        List<HoaDonChiTiet> hoaDonChiTietList = new ArrayList<>();
        String sql = "SELECT chd.idCTHD,chd.maCTHD,cts.idCTSP,hd.idHD,qa.maQA, qa.tenQA, chd.soLuong, chd.donGia\n"
                + "FROM chiTietHoaDOn chd\n"
                + "INNER JOIN chiTietSP cts ON chd.id_chiTietSP = cts.idCTSP \n"
                + "INNER JOIN quanAo qa ON cts.id_quanAo = qa.idQA\n"
                + "INNER JOIN hoaDOn hd ON chd.id_hoaDon = hd.idHD";

        ResultSet rs = JDBCHelper.excuteQuery(sql);
        try {
            while (rs.next()) {
                HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
                hoaDonChiTiet.setId(rs.getString("idCTHD"));
                hoaDonChiTiet.setMaCTHD(rs.getString("maCTHD"));

                ChiTietSP chiTietSP = new ChiTietSP();
                chiTietSP.setId(rs.getString("idCTSP"));
                hoaDonChiTiet.setChiTietSP(chiTietSP);

                HoaDon hoaDon = new HoaDon();
                hoaDon.setId(rs.getString("idHD"));
                hoaDonChiTiet.setHoaDon(hoaDon);

                SanPham quanAo = new SanPham();
                quanAo.setMaSP(rs.getString("maQA"));
                quanAo.setTenSP(rs.getString("tenQA"));

                hoaDonChiTiet.setSanPham(quanAo);

                hoaDonChiTiet.setSoLuong(rs.getInt("soLuong"));
                hoaDonChiTiet.setDonGia(rs.getDouble("donGia"));

                // Thêm đối tượng HoaDonChiTiet vào danh sách
                hoaDonChiTietList.add(hoaDonChiTiet);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonChiTietReposistory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hoaDonChiTietList;
    }

    public Integer addChiTietHoaDon(HoaDonChiTiet hdct) {
        String insertSql = "INSERT INTO chiTietHoaDon(maCTHD,id_chiTietSP, id_hoaDon, soLuong, donGia) VALUES (?,(SELECT idCTSP FROM chiTietSP WHERE maCT = ?), ?, ?, ?)";
        String updateSql = "UPDATE chiTietSP SET soLuong = soLuong - ? WHERE idCTSP =(SELECT idCTSP FROM chiTietSP WHERE maCT = ?)";
        String updateChiTietHoaDonSql = "UPDATE chiTietHoaDon SET soLuong = soLuong + ?, donGia = donGia + ? "
                + "WHERE id_chiTietSP = (SELECT idCTSP FROM chiTietSP WHERE maCT = ?) AND id_hoaDon = ?";

        try {
            // Bắt đầu giao dịch
            JDBCHelper.beginTransaction();

            // Kiểm tra xem sản phẩm đã tồn tại trong chi tiết hóa đơn chưa
            if (checkChiTietHoaDonExist(hdct.getChiTietSP().getId(), hdct.getHoaDon().getId())) {
                // Nếu tồn tại, cập nhật số lượng và giá trên bảng chi tiết hóa đơn
                Integer updateRowChiTietHoaDon = JDBCHelper.excuteUpdate(updateChiTietHoaDonSql, hdct.getSoLuong(), hdct.getDonGia(), hdct.getChiTietSP().getId(), hdct.getHoaDon().getId());
                // Giảm số lượng sản phẩm ở bảng chi tiết sản phẩm
                Integer updateRowChiTietSP = JDBCHelper.excuteUpdate(updateSql, hdct.getSoLuong(), hdct.getChiTietSP().getId());

                if (updateRowChiTietHoaDon > 0 && updateRowChiTietSP > 0) {
                    // Trường hợp cập nhật số lượng và giá thành công
                    // Commit giao dịch nếu mọi thứ đều thành công
                    JDBCHelper.commitTransaction();
                    return updateRowChiTietHoaDon;
                }
            } else {
                // Nếu chưa tồn tại, thêm mới chi tiết hóa đơn
                Integer rowInsertChiTietHoaDon = JDBCHelper.excuteUpdate(insertSql,
                        hdct.getMaCTHD(),
                        hdct.getChiTietSP().getId(),
                        hdct.getHoaDon().getId(),
                        hdct.getSoLuong(),
                        hdct.getDonGia()
                );

                if (rowInsertChiTietHoaDon > 0) {
                    // Giảm số lượng sản phẩm ở bảng chi tiết sản phẩm
                    Integer updateRowChiTietSP = JDBCHelper.excuteUpdate(updateSql, hdct.getSoLuong(), hdct.getChiTietSP().getId());

                    if (updateRowChiTietSP > 0) {
                        // Trường hợp thêm mới và giảm số lượng thành công
                        // Commit giao dịch nếu mọi thứ đều thành công
                        JDBCHelper.commitTransaction();
                        return rowInsertChiTietHoaDon;
                    }
                }
            }

            // Trường hợp thất bại hoặc rollback giao dịch nếu có lỗi
            JDBCHelper.rollbackTransaction();
            return 0;

        } catch (Exception e) {
            // Xử lý exception nếu có lỗi xảy ra
            e.printStackTrace();
            // Rollback giao dịch nếu có lỗi
            JDBCHelper.rollbackTransaction();
            return 0;
        }
    }

    public boolean checkChiTietHoaDonExist(String maCT, String idHoaDon) {
        String query = "SELECT COUNT(*) "
                + "FROM chiTietHoaDon "
                + "WHERE id_chiTietSP = (SELECT idCTSP FROM chiTietSP WHERE maCT = ?) "
                + "AND id_hoaDon = ?";

        try {
            PreparedStatement preparedStatement = JDBCHelper.prepareStatement(query);
            preparedStatement.setString(1, maCT);
            preparedStatement.setString(2, idHoaDon);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<HoaDonChiTiet> getChiTietHoaDonByMaHoaDon(String maHD) {
        List<HoaDonChiTiet> hoaDonChiTietList = new ArrayList<>();
        String sql = "SELECT chd.idCTHD,chd.maCTHD,cts.idCTSP,cts.maCT,hd.idHD,hd.maHD, qa.tenQA, chd.soLuong, chd.donGia "
                + "FROM chiTietHoaDOn chd "
                + "INNER JOIN chiTietSP cts ON chd.id_chiTietSP = cts.idCTSP "
                + "INNER JOIN quanAo qa ON cts.id_quanAo = qa.idQA "
                + "INNER JOIN hoaDOn hd ON chd.id_hoaDon = hd.idHD "
                + "WHERE hd.idHD = ?";

        try {
            ResultSet rs = JDBCHelper.excuteQuery(sql, maHD);

            while (rs.next()) {
                HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
                hoaDonChiTiet.setId(rs.getString("idCTHD"));
                hoaDonChiTiet.setMaCTHD(rs.getString("maCTHD"));

                ChiTietSP chiTietSP = new ChiTietSP();
                chiTietSP.setId(rs.getString("idCTSP"));
                chiTietSP.setMaCT(rs.getString("maCT"));
                hoaDonChiTiet.setChiTietSP(chiTietSP);

                HoaDon hoaDon = new HoaDon();
                hoaDon.setId(rs.getString("idHD"));
                hoaDon.setMaHD(rs.getString("maHD"));
                hoaDonChiTiet.setHoaDon(hoaDon);

                SanPham quanAo = new SanPham();
                quanAo.setTenSP(rs.getString("tenQA"));
                hoaDonChiTiet.setSanPham(quanAo);

                hoaDonChiTiet.setSoLuong(rs.getInt("soLuong"));
                hoaDonChiTiet.setDonGia(rs.getDouble("donGia"));

                hoaDonChiTietList.add(hoaDonChiTiet);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonChiTietReposistory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return hoaDonChiTietList;
    }

    public List<HoaDonChiTiet> getCTHoaDonByMa(String maHD) {
        List<HoaDonChiTiet> hoaDonChiTietList = new ArrayList<>();
        String sql = "SELECT chd.idCTHD,chd.maCTHD,hd.idHD,hd.maHD, qa.maQA, qa.tenQA, chd.soLuong, chd.donGia "
                + "FROM chiTietHoaDOn chd "
                + "INNER JOIN chiTietSP cts ON chd.id_chiTietSP = cts.idCTSP "
                + "INNER JOIN quanAo qa ON cts.id_quanAo = qa.idQA "
                + "INNER JOIN hoaDOn hd ON chd.id_hoaDon = hd.idHD "
                + "WHERE hd.maHD = ?";

        try {
            ResultSet rs = JDBCHelper.excuteQuery(sql, maHD);

            while (rs.next()) {
                HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
                hoaDonChiTiet.setId(rs.getString("idCTHD"));
                hoaDonChiTiet.setMaCTHD(rs.getString("maCTHD"));

                HoaDon hoaDon = new HoaDon();
                hoaDon.setId(rs.getString("idHD"));
                hoaDon.setMaHD(rs.getString("maHD"));
                hoaDonChiTiet.setHoaDon(hoaDon);

                SanPham quanAo = new SanPham();
                quanAo.setMaSP(rs.getString("maQA"));
                quanAo.setTenSP(rs.getString("tenQA"));

                hoaDonChiTiet.setSanPham(quanAo);
                hoaDonChiTiet.setSoLuong(rs.getInt("soLuong"));
                hoaDonChiTiet.setDonGia(rs.getDouble("donGia"));

                hoaDonChiTietList.add(hoaDonChiTiet);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonChiTietReposistory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return hoaDonChiTietList;
    }

    public Integer xoaSanPhamKhoiHoaDon(String idCTSP, String idCTHD, int soLuong) {
        String deleteChiTietHoaDonSql = "DELETE FROM chiTietHoaDon WHERE maCTHD=?";
        String updateChiTietSPSql = "UPDATE chiTietSP SET soLuong = soLuong + ? WHERE maCT=?";

        try {
            // Bắt đầu giao dịch
            JDBCHelper.beginTransaction();

            // Xóa sản phẩm khỏi chi tiết hóa đơn
            Integer deleteRowChiTietHoaDon = JDBCHelper.excuteUpdate(deleteChiTietHoaDonSql, idCTHD);

            if (deleteRowChiTietHoaDon > 0) {
                // Cập nhật số lượng sản phẩm trong chi tiết sản phẩm
                Integer updateRowChiTietSP = JDBCHelper.excuteUpdate(updateChiTietSPSql, soLuong, idCTSP);

                if (updateRowChiTietSP > 0) {
                    // Trường hợp cả hai cập nhật đều thành công
                    // Commit giao dịch nếu mọi thứ đều thành công
                    JDBCHelper.commitTransaction();
                    return deleteRowChiTietHoaDon;
                } else {
                    // Trường hợp cập nhật số lượng sản phẩm thất bại
                    // Rollback giao dịch nếu có lỗi
                    JDBCHelper.rollbackTransaction();
                    return 0;
                }
            } else {
                // Trường hợp xóa sản phẩm khỏi chi tiết hóa đơn thất bại
                // Rollback giao dịch nếu có lỗi
                JDBCHelper.rollbackTransaction();
                return 0;
            }
        } catch (Exception e) {
            // Xử lý exception nếu có lỗi xảy ra
            e.printStackTrace();
            // Rollback giao dịch nếu có lỗi
            JDBCHelper.rollbackTransaction();
            return 0;
        }
    }
}
