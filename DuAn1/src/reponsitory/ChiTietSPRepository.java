/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reponsitory;

import java.util.ArrayList;
import java.util.List;
import model.ChiTietSP;
import utility.JDBCHelper;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ChatLieu;
import model.DanhMuc;
import model.MauSac;

import model.SanPham;
import model.Size;
import model.ThuongHieu;
import service.DanhMucService;
import service.ThuongHieuService;
import utility.DBConnect;

public class ChiTietSPRepository {

    private final ThuongHieuService thuongHieuService = new ThuongHieuService();
    private final DanhMucService danhMucService = new DanhMucService();

    ;

    public List<ChiTietSP> getAll() {
        List<ChiTietSP> list = new ArrayList<>();
        String sql = "select * from chiTietSP \n"
                + "inner join mauSac on chiTietSP.id_mauSac = mauSac.idMS\n"
                + "inner join chatLieu on chiTietSP.id_chatLieu = chatLieu.idCL\n"
                + "inner join quanAo on chiTietSP.id_quanAo = quanAo.idQA\n"
                + "inner join size on chiTietSP.id_size = size.idS";
        ResultSet rs = JDBCHelper.excuteQuery(sql);
        try {
            while (rs.next()) {
                String id = rs.getString("idCTSP");
                String ma = rs.getString("maCT");

                String idThuongHieu = rs.getString("id_thuongHieu");
                String idDanhMuc = rs.getString("id_danhMuc");
                ThuongHieu thuongHieu = (ThuongHieu) thuongHieuService.findById(id);
                DanhMuc danhMuc = (DanhMuc) danhMucService.findById(id);

                SanPham sp = new SanPham(rs.getString("idQA"), thuongHieu, danhMuc, rs.getString("maQA"), rs.getString("tenQA"));
                MauSac ms = new MauSac(rs.getString("idMS"), rs.getString("maMS"), rs.getString("tenMS"));
                ChatLieu cl = new ChatLieu(rs.getString("idCL"), rs.getString("maCL"), rs.getString("tenCL"));
                Size s = new Size(rs.getString("idS"), rs.getString("maS"), rs.getString("tenS"));
                Integer soluong = rs.getInt("soLuong");
                Integer namSX = rs.getInt("namSX");
                Double giaBan = rs.getDouble("giaBan");
                String trangThai = rs.getString("trangThai");

                list.add(new ChiTietSP(id, sp, ms, s, cl, ma, soluong, namSX, giaBan, trangThai));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietSPRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public Integer addCTSP(ChiTietSP chiTietSP) {
        String sql = "insert into chiTietSP(maCT,id_quanAo,id_mauSac,id_chatLieu,namSX,giaBan,soLuong,id_size,trangThai) values(?,?,?,?,?,?,?,?,?)";
        Integer row;
        row = JDBCHelper.excuteUpdate(sql,
                chiTietSP.getMaCT(),
                chiTietSP.getSanPham().getId(),
                chiTietSP.getMauSac().getId(),
                chiTietSP.getChatLieu().getId(),
                chiTietSP.getNamSX(),
                chiTietSP.getGiaBan(),
                chiTietSP.getSoluong(),
                chiTietSP.getSize().getId(),
                chiTietSP.getTrangThai()
        );
        return row;
    }

//    String sql = "update chiTietSP\n"
//                + "set id_quanAo=?,id_mauSac=?,id_chatLieu=?,namSX=?,giaBan=?,soLuong=?,id_size=?,trangThai=?\n"
//                + "where idCTSP =?";
    public Integer updateCTSP(ChiTietSP chiTietSP, String id) {
        String sql = "update chiTietSP\n"
                + "set id_mauSac=?,id_chatLieu=?,namSX=?,giaBan=?,soLuong=?,id_size=?,trangThai=?\n"
                + "where maCT =?";
        try {
            Integer row = JDBCHelper.excuteUpdate(sql,
                    //                    chiTietSP.getSanPham().getId(),
                    chiTietSP.getMauSac().getId(),
                    chiTietSP.getChatLieu().getId(),
                    chiTietSP.getNamSX(),
                    chiTietSP.getGiaBan(),
                    chiTietSP.getSoluong(),
                    chiTietSP.getSize().getId(),
                    chiTietSP.getTrangThai(),
                    id
            );
            return row;
        } catch (Exception e) {
        }
        return -1;
    }

    public Integer deleteCTSP(String id) {
        String sql = "delete chiTietSP\n"
                + "where maCT =?";
        try {
            Integer row = JDBCHelper.excuteUpdate(sql, id);
            return row;
        } catch (Exception e) {
        }
        return -1;
    }

    public List<ChiTietSP> locTen(String ten) {
        List<ChiTietSP> list = new ArrayList<>();
        String sql = "SELECT * FROM chiTietSP "
                + "INNER JOIN mauSac ON chiTietSP.id_mauSac = mauSac.idMS "
                + "INNER JOIN chatLieu ON chiTietSP.id_chatLieu = chatLieu.idCL "
                + "INNER JOIN quanAo ON chiTietSP.id_quanAo = quanAo.idQA "
                + "INNER JOIN size ON chiTietSP.id_size = size.idS "
                + "WHERE quanAo.tenQA LIKE ?";

        ResultSet rs = JDBCHelper.excuteQuery(sql, "%" + ten + "%");

        try {
            while (rs.next()) {
                String id = rs.getString("idCTSP");
                String ma = rs.getString("maCT");
                String idThuongHieu = rs.getString("id_thuongHieu");
                String idDanhMuc = rs.getString("id_danhMuc");

                MauSac ms = new MauSac(rs.getString("idMS"), rs.getString("maMS"), rs.getString("tenMS"));
                ChatLieu cl = new ChatLieu(rs.getString("idCL"), rs.getString("maCL"), rs.getString("tenCL"));
                Size s = new Size(rs.getString("idS"), rs.getString("maS"), rs.getString("tenS"));
                Integer soluong = rs.getInt("soLuong");
                Integer namSX = rs.getInt("namSX");
                Double giaBan = rs.getDouble("giaBan");
                String trangThai = rs.getString("trangThai");

                SanPham sp = new SanPham(rs.getString("idQA"), rs.getString("maQA"), rs.getString("tenQA"));

                list.add(new ChiTietSP(id, sp, ms, s, cl, ma, soluong, namSX, giaBan, trangThai));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietSPRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public List<ChiTietSP> locTenMau(MauSac mauSac) {
        List<ChiTietSP> list = new ArrayList<>();
        String sql = "SELECT * FROM chiTietSP "
                + "INNER JOIN mauSac ON chiTietSP.id_mauSac = mauSac.idMS "
                + "INNER JOIN chatLieu ON chiTietSP.id_chatLieu = chatLieu.idCL "
                + "INNER JOIN quanAo ON chiTietSP.id_quanAo = quanAo.idQA "
                + "INNER JOIN size ON chiTietSP.id_size = size.idS "
                + "WHERE mauSac.tenMS LIKE ?";

        ResultSet rs = JDBCHelper.excuteQuery(sql, mauSac.getTenMauSac());

        try {
            while (rs.next()) {
                String id = rs.getString("idCTSP");
                String ma = rs.getString("maCT");
                String idThuongHieu = rs.getString("id_thuongHieu");
                String idDanhMuc = rs.getString("id_danhMuc");
                SanPham sp = new SanPham(rs.getString("idQA"), rs.getString("maQA"), rs.getString("tenQA"));

                ChatLieu cl = new ChatLieu(rs.getString("idCL"), rs.getString("maCL"), rs.getString("tenCL"));
                Size s = new Size(rs.getString("idS"), rs.getString("maS"), rs.getString("tenS"));
                Integer soluong = rs.getInt("soLuong");
                Integer namSX = rs.getInt("namSX");
                Double giaBan = rs.getDouble("giaBan");
                String trangThai = rs.getString("trangThai");

                MauSac ms = new MauSac(rs.getString("idMS"), rs.getString("maMS"), rs.getString("tenMS"));
                list.add(new ChiTietSP(id, sp, mauSac, s, cl, ma, soluong, namSX, giaBan, trangThai));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietSPRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public List<ChiTietSP> locTenSize(Size size) {
        List<ChiTietSP> list = new ArrayList<>();
        String sql = "SELECT * FROM chiTietSP "
                + "INNER JOIN mauSac ON chiTietSP.id_mauSac = mauSac.idMS "
                + "INNER JOIN chatLieu ON chiTietSP.id_chatLieu = chatLieu.idCL "
                + "INNER JOIN quanAo ON chiTietSP.id_quanAo = quanAo.idQA "
                + "INNER JOIN size ON chiTietSP.id_size = size.idS "
                + "WHERE size.tenS LIKE ?";

        ResultSet rs = JDBCHelper.excuteQuery(sql, size.getTenSize());

        try {
            while (rs.next()) {
                String id = rs.getString("idCTSP");
                String ma = rs.getString("maCT");
                String idThuongHieu = rs.getString("id_thuongHieu");
                String idDanhMuc = rs.getString("id_danhMuc");
                SanPham sp = new SanPham(rs.getString("idQA"), rs.getString("maQA"), rs.getString("tenQA"));
                MauSac ms = new MauSac(rs.getString("idMS"), rs.getString("maMS"), rs.getString("tenMS"));
                ChatLieu cl = new ChatLieu(rs.getString("idCL"), rs.getString("maCL"), rs.getString("tenCL"));

                Integer soluong = rs.getInt("soLuong");
                Integer namSX = rs.getInt("namSX");
                Double giaBan = rs.getDouble("giaBan");
                String trangThai = rs.getString("trangThai");

                Size s = new Size(rs.getString("idS"), rs.getString("maS"), rs.getString("tenS"));
                list.add(new ChiTietSP(id, sp, ms, size, cl, ma, soluong, namSX, giaBan, trangThai));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietSPRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public List<ChiTietSP> locTenSP(SanPham ten) {
        List<ChiTietSP> list = new ArrayList<>();
        String sql = "SELECT * FROM chiTietSP "
                + "INNER JOIN mauSac ON chiTietSP.id_mauSac = mauSac.idMS "
                + "INNER JOIN chatLieu ON chiTietSP.id_chatLieu = chatLieu.idCL "
                + "INNER JOIN quanAo ON chiTietSP.id_quanAo = quanAo.idQA "
                + "INNER JOIN size ON chiTietSP.id_size = size.idS "
                + "WHERE quanAo.tenQA LIKE ?";

        ResultSet rs = JDBCHelper.excuteQuery(sql, ten.getTenSP());

        try {
            while (rs.next()) {
                String id = rs.getString("idCTSP");
                String ma = rs.getString("maCT");
                String idThuongHieu = rs.getString("id_thuongHieu");
                String idDanhMuc = rs.getString("id_danhMuc");

                MauSac ms = new MauSac(rs.getString("idMS"), rs.getString("maMS"), rs.getString("tenMS"));
                ChatLieu cl = new ChatLieu(rs.getString("idCL"), rs.getString("maCL"), rs.getString("tenCL"));
                Size s = new Size(rs.getString("idS"), rs.getString("maS"), rs.getString("tenS"));
                Integer soluong = rs.getInt("soLuong");
                Integer namSX = rs.getInt("namSX");
                Double giaBan = rs.getDouble("giaBan");
                String trangThai = rs.getString("trangThai");

                SanPham sp = new SanPham(rs.getString("idQA"), rs.getString("maQA"), rs.getString("tenQA"));

                list.add(new ChiTietSP(id, sp, ms, s, cl, ma, soluong, namSX, giaBan, trangThai));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietSPRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public List<ChiTietSP> getChiTietSPById(String id) {
        List<ChiTietSP> chiTietSPs = new ArrayList<>();
        String sql = "SELECT * FROM chiTietSP WHERE id_quanAo=?";
        ResultSet rs = JDBCHelper.excuteQuery(sql, id);
        try {
            if (rs.next()) {
                ChiTietSP chiTietSP = new ChiTietSP();
                chiTietSP.setId(rs.getString("idCTSP"));
                chiTietSP.setMaCT(rs.getString("maCT"));
                chiTietSP.setSanPham((SanPham) rs.getObject("id_quanAo"));
                chiTietSP.setMauSac((MauSac) rs.getObject("id_mauSac"));
                chiTietSP.setChatLieu((ChatLieu) rs.getObject("id_chatLieu"));
                chiTietSP.setSize((Size) rs.getObject("id_size"));
                chiTietSP.setSoluong(rs.getInt("soLuong"));
                chiTietSP.setNamSX(rs.getInt("namSX"));
                chiTietSP.setGiaBan(rs.getDouble("giaBan"));
                chiTietSP.setTrangThai(rs.getString("trangThai"));

                chiTietSPs.add(chiTietSP);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return chiTietSPs;
    }

    public List<ChiTietSP> getAllByTT() {
        List<ChiTietSP> list = new ArrayList<>();
        String sql = "select * from chiTietSP\n"
                + "inner join mauSac on chiTietSP.id_mauSac = mauSac.idMS\n"
                + "inner join chatLieu on chiTietSP.id_chatLieu = chatLieu.idCL\n"
                + "inner join quanAo on chiTietSP.id_quanAo = quanAo.idQA\n"
                + "inner join size on chiTietSP.id_size = size.idS\n"
                + "where chiTietSP.trangThai like 'Còn hàng'";
        ResultSet rs = JDBCHelper.excuteQuery(sql);
        try {
            while (rs.next()) {
                String id = rs.getString("idCTSP");
                String ma = rs.getString("maCT");

                String idThuongHieu = rs.getString("id_thuongHieu");
                String idDanhMuc = rs.getString("id_danhMuc");
                ThuongHieu thuongHieu = (ThuongHieu) thuongHieuService.findById(id);
                DanhMuc danhMuc = (DanhMuc) danhMucService.findById(id);

                SanPham sp = new SanPham(rs.getString("idQA"), thuongHieu, danhMuc, rs.getString("maQA"), rs.getString("tenQA"));
                MauSac ms = new MauSac(rs.getString("idMS"), rs.getString("maMS"), rs.getString("tenMS"));
                ChatLieu cl = new ChatLieu(rs.getString("idCL"), rs.getString("maCL"), rs.getString("tenCL"));
                Size s = new Size(rs.getString("idS"), rs.getString("maS"), rs.getString("tenS"));
                Integer soluong = rs.getInt("soLuong");
                Integer namSX = rs.getInt("namSX");
                Double giaBan = rs.getDouble("giaBan");
                String trangThai = rs.getString("trangThai");

                list.add(new ChiTietSP(id, sp, ms, s, cl, ma, soluong, namSX, giaBan, trangThai));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietSPRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public int updateTrangThaiHetHang(String maChiTietSP) {
        try {
            JDBCHelper.beginTransaction();

            // Thực hiện cập nhật trạng thái hết hàng
            String updateSql = "UPDATE chiTietSP SET trangThai =N'Hết hàng' WHERE maCT =?";
            int rowsAffected = JDBCHelper.excuteUpdate(updateSql, maChiTietSP);

            if (rowsAffected > 0) {
                // Nếu cập nhật thành công, commit giao dịch
                JDBCHelper.commitTransaction();
            } else {
                // Nếu có lỗi, rollback giao dịch
                JDBCHelper.rollbackTransaction();
            }

            return rowsAffected;
        } catch (SQLException e) {
            // Xử lý exception tùy thuộc vào yêu cầu của ứng dụng bạn.
            // Có thể in log, ném exception, hoặc thực hiện các xử lý khác dựa trên yêu cầu cụ thể.
            e.printStackTrace();
            return 0; // hoặc ném một exception tùy thuộc vào yêu cầu của bạn.
        }
    }

    public int updateTrangThaiConHang(String maChiTietSP) {
        try {
            JDBCHelper.beginTransaction();

            // Thực hiện cập nhật trạng thái hết hàng
            String updateSql = "UPDATE chiTietSP SET trangThai =N'Còn hàng' WHERE maCT =?";
            int rowsAffected = JDBCHelper.excuteUpdate(updateSql, maChiTietSP);

            if (rowsAffected > 0) {
                // Nếu cập nhật thành công, commit giao dịch
                JDBCHelper.commitTransaction();
            } else {
                // Nếu có lỗi, rollback giao dịch
                JDBCHelper.rollbackTransaction();
            }

            return rowsAffected;
        } catch (SQLException e) {
            // Xử lý exception tùy thuộc vào yêu cầu của ứng dụng bạn.
            // Có thể in log, ném exception, hoặc thực hiện các xử lý khác dựa trên yêu cầu cụ thể.
            e.printStackTrace();
            return 0; // hoặc ném một exception tùy thuộc vào yêu cầu của bạn.
        }
    }

    public String getTrangThaiSanPham(String maCTSP) {
        String trangThai = "Hết hàng";
        ResultSet resultSet = null;

        try {
            resultSet = JDBCHelper.excuteQuery("SELECT trangThai FROM chiTietSP WHERE maCT = ?", maCTSP);

            if (resultSet.next()) {
                trangThai = resultSet.getString("trangThai");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trangThai;
    }

    // Lấy số lượng sản phẩm còn lại
    public int getSoLuongSanPhamConLai(String maCTSP) {
        int soLuong = 0;
        ResultSet resultSet = null;

        try {
            resultSet = JDBCHelper.excuteQuery("SELECT soLuong FROM chiTietSP WHERE maCT = ?", maCTSP);

            if (resultSet.next()) {
                soLuong = resultSet.getInt("soLuong");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return soLuong;
    }

    public void updateSoLuongVaTrangThai(String maCTSP, int soLuong, String trangThaiMoi) {
        try {
            JDBCHelper.beginTransaction(); // Bắt đầu giao dịch

            // Cập nhật số lượng và trạng thái sản phẩm trong cơ sở dữ liệu
            String sql = "UPDATE chiTietSP SET soLuong = ?, trangThai =N'Còn hàng' WHERE maCT = ?";
            JDBCHelper.excuteUpdate(sql, soLuong, maCTSP);

            JDBCHelper.commitTransaction(); // Chấp nhận giao dịch nếu không có lỗi
        } catch (SQLException e) {
            JDBCHelper.rollbackTransaction(); // Quay lại trạng thái trước đó nếu có lỗi
            e.printStackTrace();
        }
    }
}
