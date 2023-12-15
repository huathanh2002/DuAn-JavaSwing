/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.ChatLieu;
import model.ChiTietSP;
import model.DanhMuc;
import model.MauSac;
import model.SanPham;
import model.Size;
import model.ThuongHieu;
import reponsitory.ChatLieuRepository;
import reponsitory.MauSacRepository;
import reponsitory.SizeRepository;
import service.ChatLieuService;
import service.ChiTietSPService;
import service.DanhMucService;
import service.MauSacService;
import service.SanPhamService;
import service.SizeService;
import service.ThuongHieuService;

/**
 *
 * @author THANH
 */
public class panelSanPhamChiTiet extends javax.swing.JPanel {

    private DefaultTableModel tblModel = new DefaultTableModel();
    private final SanPhamService sanPhamService;
    private final ThuongHieuService thuongHieuService;
    private final DanhMucService danhMucService;
    private final MauSacService mauSacService;
    private final SizeService sizeService;
    private final ChatLieuService chatLieuService;
    private final ChiTietSPService chiTietSPService;
    private int index = -1;
    private boolean initializing = true;
    private SanPham selectedSanPham;
    private boolean shouldProcessItemChange = true;

    private boolean userAction = true;
    private boolean comboBoxEventEnabled = true;

    DefaultComboBoxModel<DanhMuc> modelDanhMuc;
    DefaultComboBoxModel<ThuongHieu> modelThuongHieu;
    DefaultComboBoxModel<SanPham> modelSanPham;
    DefaultComboBoxModel<MauSac> modelMacSac;
    DefaultComboBoxModel<Size> modelSize;
    DefaultComboBoxModel<ChatLieu> modelChatLieu;

    /**
     * Creates new form panelSanPhamChiTiet
     */
    public panelSanPhamChiTiet() {
        initComponents();

        addPlaceHolderStyle(txtTimTen);

        sanPhamService = new SanPhamService();
        danhMucService = new DanhMucService();
        thuongHieuService = new ThuongHieuService();
        mauSacService = new MauSacService();
        chatLieuService = new ChatLieuService();
        sizeService = new SizeService();
        chiTietSPService = new ChiTietSPService();

        List<SanPham> sanPhams = sanPhamService.getAll();
        modelSanPham = (DefaultComboBoxModel) new DefaultComboBoxModel<>(sanPhams.toArray(new SanPham[0]));
        cbo_sanPham.setModel((DefaultComboBoxModel) modelSanPham);

        List<DanhMuc> danhMucs = danhMucService.getAll();
        modelDanhMuc = (DefaultComboBoxModel) new DefaultComboBoxModel<>(danhMucs.toArray());
        cbbLoai.setModel((DefaultComboBoxModel) modelDanhMuc);

        List<ThuongHieu> thuongHieus = thuongHieuService.getAll();
        modelThuongHieu = (DefaultComboBoxModel) new DefaultComboBoxModel<>(thuongHieus.toArray());
        cbbHang.setModel((DefaultComboBoxModel) modelThuongHieu);

        List<MauSac> mauSacs = mauSacService.getAll();
        List<MauSac> mauSacs2 = mauSacService.getAll();
        modelMacSac = (DefaultComboBoxModel) new DefaultComboBoxModel<>(mauSacs.toArray());
        modelMacSac = (DefaultComboBoxModel) new DefaultComboBoxModel<>(mauSacs2.toArray());
        cbo_mauSac.setModel((DefaultComboBoxModel) modelMacSac);
        cbo_locMauSac.setModel((DefaultComboBoxModel) modelMacSac);

        List<Size> sizes = sizeService.getAll();
        List<Size> sizes2 = sizeService.getAll();
        modelSize = (DefaultComboBoxModel) new DefaultComboBoxModel<>(sizes.toArray());
        modelSize = (DefaultComboBoxModel) new DefaultComboBoxModel<>(sizes2.toArray());
        cbo_size.setModel((DefaultComboBoxModel) modelSize);
        cbo_locSize.setModel((DefaultComboBoxModel) modelSize);

        List<ChatLieu> chatLieus = chatLieuService.getAll();
        modelChatLieu = (DefaultComboBoxModel) new DefaultComboBoxModel<>(chatLieus.toArray());
        cbo_chatLieu.setModel((DefaultComboBoxModel) modelChatLieu);

        loadTableSP();
        loadTableDanhMuc();
        loadTableThuongHieu();
        loadTableMauSac();
        loadTableSize();
        loadTableChatLieu();

        loadCBB();

    }

    public void resetInputSP() {
        txtMaSP.setText(null);
        txtTenSP.setText(null);

    }

    public void resetInputDM() {
        txtMaDanhMuc.setText(null);
        txtTenDanhMuc.setText(null);
    }

    public void resetInputTH() {
        txtMaThuongHieu.setText(null);
        txtTenThuongHieu.setText(null);
    }

    public void resetInputMS() {
        txtMaMau.setText(null);
        txtTenMau.setText(null);
    }

    public void resetInputS() {
        txtMaSize.setText(null);
        txtTenSize.setText(null);
    }

    public void resetInputSPCL() {
        txtMaChatLieu.setText(null);
        txtTenChatLieu.setText(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabPanelCTSP = new javax.swing.JTabbedPane();
        pnlSanPham = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTenSP = new javax.swing.JTextField();
        cbbLoai = new javax.swing.JComboBox<>();
        cbbHang = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblList = new javax.swing.JTable();
        txtTimTen = new javax.swing.JTextField();
        bttChiTietSP = new javax.swing.JButton();
        pnlDanhMuc = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblListDM = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txtMaDanhMuc = new javax.swing.JTextField();
        txtTenDanhMuc = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        bttThemDanhMuc = new javax.swing.JButton();
        bttSuaDanhMuc = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        txtTimNDM = new javax.swing.JTextField();
        pnlThuongHieu = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblThuongHieu = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        txtMaThuongHieu = new javax.swing.JTextField();
        txtTenThuongHieu = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        bttThemThuongHieu = new javax.swing.JButton();
        bttSuaThuongHieu = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        txtSearchByName = new javax.swing.JTextField();
        pnlChiTietSP = new javax.swing.JPanel();
        pnlSanPhamChiTiet = new javax.swing.JPanel();
        lbl_ngayNhapHang = new javax.swing.JLabel();
        lbl_locMauSac = new javax.swing.JLabel();
        txt_giaBan = new javax.swing.JTextField();
        lbl_giaBan = new javax.swing.JLabel();
        lbl_soLuong = new javax.swing.JLabel();
        lbl_locDongSP = new javax.swing.JLabel();
        lbl_kichCo = new javax.swing.JLabel();
        cbo_locSize = new javax.swing.JComboBox<>();
        lbl_trangThai = new javax.swing.JLabel();
        txt_soLuong = new javax.swing.JTextField();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblCTSanPham = new javax.swing.JTable();
        btn_clear = new javax.swing.JButton();
        lbl_sanPhamct = new javax.swing.JLabel();
        txt_timKiem = new javax.swing.JTextField();
        cbo_trangThai = new javax.swing.JComboBox<>();
        lbl_deGiay = new javax.swing.JLabel();
        cbo_chatLieu = new javax.swing.JComboBox<>();
        txt_NamSX = new javax.swing.JTextField();
        btn_themMS = new javax.swing.JButton();
        cbo_mauSac = new javax.swing.JComboBox<>();
        btn_themDG1 = new javax.swing.JButton();
        lbl_mauSac = new javax.swing.JLabel();
        cbo_locMauSac = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        btnReloadCTSP = new javax.swing.JButton();
        cbo_size = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        cbo_sanPham = new javax.swing.JComboBox<>();
        pnlThuocTinh = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        pnlMauSac = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblMauSac = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        txtMaMau = new javax.swing.JTextField();
        txtTenMau = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        bttThemMau = new javax.swing.JButton();
        bttSuaMau = new javax.swing.JButton();
        txtTimkiemMausac = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSize = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txtMaSize = new javax.swing.JTextField();
        txtTenSize = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        bttThemSizze = new javax.swing.JButton();
        bttSuaSize = new javax.swing.JButton();
        txtTimKiemSize = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblChatLieu = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        txtMaChatLieu = new javax.swing.JTextField();
        txtTenChatLieu = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        bttThemChatLieu = new javax.swing.JButton();
        bttSuaChatLieu = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        txtTimChatLIeu = new javax.swing.JTextField();

        tabPanelCTSP.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabPanelCTSPStateChanged(evt);
            }
        });

        pnlSanPham.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Sản phẩm");

        jLabel2.setText("Mã:");

        jLabel3.setText("Tên:");

        jLabel4.setText("Danh mục:");

        jLabel5.setText("Thương Hiệu:");

        jButton1.setBackground(new java.awt.Color(0, 255, 51));
        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 0));
        jButton2.setText("Sửa");
        jButton2.setPreferredSize(new java.awt.Dimension(57, 21));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tblList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên", "Danh Mục", "Thương Hiệu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblList);

        txtTimTen.setText("Tìm kiếm");
        txtTimTen.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimTenCaretUpdate(evt);
            }
        });
        txtTimTen.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                txtTimTenAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        txtTimTen.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTimTenFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTimTenFocusLost(evt);
            }
        });
        txtTimTen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTimTenMouseClicked(evt);
            }
        });
        txtTimTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimTenActionPerformed(evt);
            }
        });
        txtTimTen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimTenKeyReleased(evt);
            }
        });

        bttChiTietSP.setBackground(new java.awt.Color(0, 0, 255));
        bttChiTietSP.setText("Chi tiết sản phẩm");
        bttChiTietSP.setPreferredSize(new java.awt.Dimension(57, 21));
        bttChiTietSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttChiTietSPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSanPhamLayout = new javax.swing.GroupLayout(pnlSanPham);
        pnlSanPham.setLayout(pnlSanPhamLayout);
        pnlSanPhamLayout.setHorizontalGroup(
            pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSanPhamLayout.createSequentialGroup()
                .addGroup(pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlSanPhamLayout.createSequentialGroup()
                        .addGap(433, 433, 433)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlSanPhamLayout.createSequentialGroup()
                        .addGap(387, 387, 387)
                        .addGroup(pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlSanPhamLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(txtMaSP))
                            .addGroup(pnlSanPhamLayout.createSequentialGroup()
                                .addGroup(pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSanPhamLayout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(pnlSanPhamLayout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)))
                                .addGroup(pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbbLoai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbbHang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(pnlSanPhamLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(276, 276, 276)
                        .addGroup(pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bttChiTietSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(89, Short.MAX_VALUE))
            .addGroup(pnlSanPhamLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1))
            .addGroup(pnlSanPhamLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(txtTimTen, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlSanPhamLayout.setVerticalGroup(
            pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlSanPhamLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(149, 149, 149))
                    .addGroup(pnlSanPhamLayout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bttChiTietSP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2))
                    .addGroup(pnlSanPhamLayout.createSequentialGroup()
                        .addGroup(pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaSP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addComponent(txtTimTen, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabPanelCTSP.addTab("Sản phẩm", pnlSanPham);

        pnlDanhMuc.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel6.setText("Danh mục sản phẩm");

        tblListDM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã danh mục", "Tên danh mục"
            }
        ));
        tblListDM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListDMMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblListDM);

        jLabel7.setText("Mã danh mục:");

        jLabel8.setText("Tên danh mục:");

        bttThemDanhMuc.setBackground(new java.awt.Color(0, 255, 0));
        bttThemDanhMuc.setText("Thêm");
        bttThemDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttThemDanhMucActionPerformed(evt);
            }
        });

        bttSuaDanhMuc.setBackground(new java.awt.Color(255, 255, 0));
        bttSuaDanhMuc.setText("Sửa");
        bttSuaDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttSuaDanhMucActionPerformed(evt);
            }
        });

        jLabel21.setText("Tìm nhanh danh mục :");

        txtTimNDM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimNDMKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout pnlDanhMucLayout = new javax.swing.GroupLayout(pnlDanhMuc);
        pnlDanhMuc.setLayout(pnlDanhMucLayout);
        pnlDanhMucLayout.setHorizontalGroup(
            pnlDanhMucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDanhMucLayout.createSequentialGroup()
                .addGroup(pnlDanhMucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDanhMucLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(pnlDanhMucLayout.createSequentialGroup()
                        .addGroup(pnlDanhMucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDanhMucLayout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTimNDM, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlDanhMucLayout.createSequentialGroup()
                                .addGap(411, 411, 411)
                                .addGroup(pnlDanhMucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlDanhMucLayout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMaDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlDanhMucLayout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(pnlDanhMucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pnlDanhMucLayout.createSequentialGroup()
                                                .addComponent(bttThemDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(bttSuaDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtTenDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 484, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlDanhMucLayout.setVerticalGroup(
            pnlDanhMucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDanhMucLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(pnlDanhMucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDanhMucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(pnlDanhMucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bttThemDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttSuaDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                .addGroup(pnlDanhMucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimNDM, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabPanelCTSP.addTab("Danh mục", pnlDanhMuc);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel12.setText("Thương hiệu sản phẩm");

        tblThuongHieu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã thương hiệu", "Tên thương hiệu"
            }
        ));
        tblThuongHieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThuongHieuMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblThuongHieu);

        jLabel13.setText("Mã thương hiệu:");

        txtTenThuongHieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenThuongHieuActionPerformed(evt);
            }
        });

        jLabel14.setText("Tên thương hiệu:");

        bttThemThuongHieu.setBackground(new java.awt.Color(0, 255, 0));
        bttThemThuongHieu.setText("Thêm");
        bttThemThuongHieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttThemThuongHieuActionPerformed(evt);
            }
        });

        bttSuaThuongHieu.setBackground(new java.awt.Color(255, 255, 0));
        bttSuaThuongHieu.setText("Sửa");
        bttSuaThuongHieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttSuaThuongHieuActionPerformed(evt);
            }
        });

        jLabel26.setText("Tên thương hiệu:");

        txtSearchByName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchByNameActionPerformed(evt);
            }
        });
        txtSearchByName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchByNameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchByNameKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(349, 349, 349)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bttThemThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bttSuaThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addComponent(txtTenThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMaThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearchByName, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(466, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bttThemThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttSuaThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearchByName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pnlThuongHieuLayout = new javax.swing.GroupLayout(pnlThuongHieu);
        pnlThuongHieu.setLayout(pnlThuongHieuLayout);
        pnlThuongHieuLayout.setHorizontalGroup(
            pnlThuongHieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1231, Short.MAX_VALUE)
            .addGroup(pnlThuongHieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThuongHieuLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        pnlThuongHieuLayout.setVerticalGroup(
            pnlThuongHieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 803, Short.MAX_VALUE)
            .addGroup(pnlThuongHieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabPanelCTSP.addTab("Thương hiệu", pnlThuongHieu);

        pnlSanPhamChiTiet.setBackground(new java.awt.Color(255, 255, 255));

        lbl_ngayNhapHang.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_ngayNhapHang.setText("Năm sản xuất");

        lbl_locMauSac.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_locMauSac.setText("Màu sắc");

        lbl_giaBan.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_giaBan.setText("Giá bán");

        lbl_soLuong.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_soLuong.setText("Số lượng");

        lbl_locDongSP.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_locDongSP.setText("Size:");

        lbl_kichCo.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_kichCo.setText("Size");

        cbo_locSize.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_locSizeItemStateChanged(evt);
            }
        });

        lbl_trangThai.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_trangThai.setText("Trạng thái");

        btn_them.setBackground(new java.awt.Color(255, 204, 0));
        btn_them.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_them.setForeground(new java.awt.Color(255, 255, 255));
        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_sua.setBackground(new java.awt.Color(255, 204, 0));
        btn_sua.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_sua.setForeground(new java.awt.Color(255, 255, 255));
        btn_sua.setText("Sửa");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        tblCTSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Sản Phẩm", "Màu Sắc", "Chất liệu", "Năm sản xuất", "Giá Bán", "Số Lượng", "Kích Cỡ", "Trạng Thái"
            }
        ));
        tblCTSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCTSanPhamMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblCTSanPham);

        btn_clear.setBackground(new java.awt.Color(255, 204, 0));
        btn_clear.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_clear.setForeground(new java.awt.Color(255, 255, 255));
        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        lbl_sanPhamct.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_sanPhamct.setText("Sản phẩm");

        txt_timKiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_timKiemCaretUpdate(evt);
            }
        });
        txt_timKiem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_timKiemFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_timKiemFocusLost(evt);
            }
        });
        txt_timKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_timKiemKeyReleased(evt);
            }
        });

        cbo_trangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Còn hàng", "Hết hàng" }));
        cbo_trangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_trangThaiActionPerformed(evt);
            }
        });

        lbl_deGiay.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_deGiay.setText("Chất liệu");

        txt_NamSX.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_NamSXFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_NamSXFocusLost(evt);
            }
        });

        btn_themMS.setBackground(new java.awt.Color(204, 0, 0));
        btn_themMS.setForeground(new java.awt.Color(255, 255, 255));
        btn_themMS.setText("+");
        btn_themMS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themMSActionPerformed(evt);
            }
        });

        btn_themDG1.setBackground(new java.awt.Color(204, 0, 0));
        btn_themDG1.setForeground(new java.awt.Color(255, 255, 255));
        btn_themDG1.setText("+");
        btn_themDG1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themDG1ActionPerformed(evt);
            }
        });

        lbl_mauSac.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_mauSac.setText("Màu sắc");

        cbo_locMauSac.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_locMauSacItemStateChanged(evt);
            }
        });
        cbo_locMauSac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cbo_locMauSacKeyReleased(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel22.setText("Sản phẩm chi tiết");

        btnReloadCTSP.setBackground(new java.awt.Color(255, 204, 0));
        btnReloadCTSP.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnReloadCTSP.setForeground(new java.awt.Color(255, 255, 255));
        btnReloadCTSP.setText("Reload");
        btnReloadCTSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadCTSPActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 0, 0));
        jButton4.setText("+");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        cbo_sanPham.setEnabled(false);
        cbo_sanPham.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_sanPhamItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout pnlSanPhamChiTietLayout = new javax.swing.GroupLayout(pnlSanPhamChiTiet);
        pnlSanPhamChiTiet.setLayout(pnlSanPhamChiTietLayout);
        pnlSanPhamChiTietLayout.setHorizontalGroup(
            pnlSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSanPhamChiTietLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSanPhamChiTietLayout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(pnlSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSanPhamChiTietLayout.createSequentialGroup()
                        .addComponent(lbl_sanPhamct, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbo_sanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(147, 147, 147)
                        .addGroup(pnlSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlSanPhamChiTietLayout.createSequentialGroup()
                                .addGroup(pnlSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbl_deGiay)
                                    .addComponent(lbl_ngayNhapHang)
                                    .addComponent(lbl_kichCo)
                                    .addComponent(lbl_trangThai))
                                .addGap(30, 30, 30)
                                .addGroup(pnlSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_NamSX, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbo_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnlSanPhamChiTietLayout.createSequentialGroup()
                                        .addComponent(cbo_chatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_themDG1))
                                    .addGroup(pnlSanPhamChiTietLayout.createSequentialGroup()
                                        .addComponent(cbo_size, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton4))
                                    .addGroup(pnlSanPhamChiTietLayout.createSequentialGroup()
                                        .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(pnlSanPhamChiTietLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(pnlSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnlSanPhamChiTietLayout.createSequentialGroup()
                                        .addGroup(pnlSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSanPhamChiTietLayout.createSequentialGroup()
                                                .addComponent(lbl_mauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSanPhamChiTietLayout.createSequentialGroup()
                                                .addComponent(lbl_giaBan)
                                                .addGap(38, 38, 38))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSanPhamChiTietLayout.createSequentialGroup()
                                                .addComponent(lbl_soLuong)
                                                .addGap(31, 31, 31)))
                                        .addGroup(pnlSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txt_soLuong)
                                            .addComponent(txt_giaBan)
                                            .addComponent(cbo_mauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_themMS)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnReloadCTSP)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSanPhamChiTietLayout.createSequentialGroup()
                        .addComponent(txt_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_locMauSac)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbo_locMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_locDongSP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbo_locSize, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(369, 369, 369))))
        );
        pnlSanPhamChiTietLayout.setVerticalGroup(
            pnlSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSanPhamChiTietLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(pnlSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_sanPhamct, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbo_sanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbo_mauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_mauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_themMS)
                    .addComponent(btnReloadCTSP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_giaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_giaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_deGiay, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_chatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_themDG1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_NamSX, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_ngayNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_kichCo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_size, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSanPhamChiTietLayout.createSequentialGroup()
                        .addComponent(cbo_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbl_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(pnlSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbo_locMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_locMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_locDongSP, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbo_locSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_timKiem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pnlChiTietSPLayout = new javax.swing.GroupLayout(pnlChiTietSP);
        pnlChiTietSP.setLayout(pnlChiTietSPLayout);
        pnlChiTietSPLayout.setHorizontalGroup(
            pnlChiTietSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1231, Short.MAX_VALUE)
            .addGroup(pnlChiTietSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlChiTietSPLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnlSanPhamChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        pnlChiTietSPLayout.setVerticalGroup(
            pnlChiTietSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 803, Short.MAX_VALUE)
            .addGroup(pnlChiTietSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlChiTietSPLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnlSanPhamChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        tabPanelCTSP.addTab("Thông tin sản phẩm", pnlChiTietSP);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel15.setText("Màu sắc sản phẩm");

        tblMauSac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã danh mục", "Tên danh mục"
            }
        ));
        tblMauSac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMauSacMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblMauSac);

        jLabel16.setText("Mã màu:");

        jLabel17.setText("Tên tên màu:");

        bttThemMau.setBackground(new java.awt.Color(0, 255, 0));
        bttThemMau.setText("Thêm");
        bttThemMau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttThemMauActionPerformed(evt);
            }
        });

        bttSuaMau.setBackground(new java.awt.Color(255, 255, 0));
        bttSuaMau.setText("Sửa");
        bttSuaMau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttSuaMauActionPerformed(evt);
            }
        });

        txtTimkiemMausac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimkiemMausacActionPerformed(evt);
            }
        });
        txtTimkiemMausac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimkiemMausacKeyReleased(evt);
            }
        });

        jLabel27.setText("Tìm kiếm màu sắc :");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTimkiemMausac, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(411, 411, 411)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(bttThemMau, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bttSuaMau, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtTenMau, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaMau, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(467, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaMau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenMau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bttThemMau, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bttSuaMau, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTimkiemMausac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pnlMauSacLayout = new javax.swing.GroupLayout(pnlMauSac);
        pnlMauSac.setLayout(pnlMauSacLayout);
        pnlMauSacLayout.setHorizontalGroup(
            pnlMauSacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1214, Short.MAX_VALUE)
            .addGroup(pnlMauSacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMauSacLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnlMauSacLayout.setVerticalGroup(
            pnlMauSacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 773, Short.MAX_VALUE)
            .addGroup(pnlMauSacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Màu sắc", pnlMauSac);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel9.setText("Size sản phẩm");

        tblSize.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã Size", "Size"
            }
        ));
        tblSize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSizeMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblSize);

        jLabel10.setText("Mã size:");

        jLabel11.setText("Size:");

        bttThemSizze.setBackground(new java.awt.Color(0, 255, 0));
        bttThemSizze.setText("Thêm");
        bttThemSizze.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttThemSizzeActionPerformed(evt);
            }
        });

        bttSuaSize.setBackground(new java.awt.Color(255, 255, 0));
        bttSuaSize.setText("Sửa");
        bttSuaSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttSuaSizeActionPerformed(evt);
            }
        });

        txtTimKiemSize.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemSizeKeyReleased(evt);
            }
        });

        jLabel29.setText("Tìm kiếm size");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(378, 378, 378))
            .addComponent(jScrollPane3)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addGap(443, 443, 443)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtMaSize, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtTenSize, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtTimKiemSize, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(527, 527, 527)
                        .addComponent(bttThemSizze, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bttSuaSize, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(478, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bttThemSizze, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttSuaSize, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiemSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1214, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 773, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Size", jPanel7);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel18.setText("Chất liệu sản phẩm");

        tblChatLieu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã chất liệu", "Tên chất liệu"
            }
        ));
        tblChatLieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChatLieuMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblChatLieu);

        jLabel19.setText("Mã chất liệu:");

        jLabel20.setText("Tên chất liệu:");

        bttThemChatLieu.setBackground(new java.awt.Color(0, 255, 0));
        bttThemChatLieu.setText("Thêm");
        bttThemChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttThemChatLieuActionPerformed(evt);
            }
        });

        bttSuaChatLieu.setBackground(new java.awt.Color(255, 255, 51));
        bttSuaChatLieu.setText("Sửa");
        bttSuaChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttSuaChatLieuActionPerformed(evt);
            }
        });

        jLabel28.setText("Tìm tên :");

        txtTimChatLIeu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimChatLIeuKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(378, 378, 378))
            .addComponent(jScrollPane7)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTimChatLIeu, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(409, 409, 409)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMaChatLieu))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addComponent(bttThemChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bttSuaChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtTenChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(474, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bttThemChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttSuaChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimChatLIeu, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Chât liệu", jPanel8);

        javax.swing.GroupLayout pnlThuocTinhLayout = new javax.swing.GroupLayout(pnlThuocTinh);
        pnlThuocTinh.setLayout(pnlThuocTinhLayout);
        pnlThuocTinhLayout.setHorizontalGroup(
            pnlThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThuocTinhLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1219, Short.MAX_VALUE))
        );
        pnlThuocTinhLayout.setVerticalGroup(
            pnlThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        tabPanelCTSP.addTab("Thuộc tính sản phẩm", pnlThuocTinh);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(tabPanelCTSP, javax.swing.GroupLayout.DEFAULT_SIZE, 1236, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPanelCTSP)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnReloadCTSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadCTSPActionPerformed
        loadCBB();
    }//GEN-LAST:event_btnReloadCTSPActionPerformed

    private void cbo_locMauSacItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_locMauSacItemStateChanged
        try {
            if (comboBoxEventEnabled && initializing) {
                MauSac selectedMauSac = (MauSac) cbo_locMauSac.getSelectedItem();
                if ("Tất cả".equals(selectedMauSac.getTenMauSac())) {
                    fillTableCTSP(chiTietSPService.locTenMau(selectedMauSac));
                } else {
                    fillTableCTSP(chiTietSPService.locTenMau(selectedMauSac));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            initializing = true;
        }
    }//GEN-LAST:event_cbo_locMauSacItemStateChanged

    private void btn_themDG1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themDG1ActionPerformed
        viewChatLieu chatLieuNew = new viewChatLieu();
        chatLieuNew.setVisible(true);

        // Thêm WindowListener để theo dõi sự kiện đóng cửa sổ
        chatLieuNew.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                // Được gọi khi cửa sổ được đóng
                loadCBBCL();
            }
        });
    }//GEN-LAST:event_btn_themDG1ActionPerformed

    private void btn_themMSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themMSActionPerformed
        viewMauSac mauSacnew = new viewMauSac();
        mauSacnew.setVisible(true);

        // Thêm WindowListener để theo dõi sự kiện đóng cửa sổ
        mauSacnew.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                // Được gọi khi cửa sổ được đóng
                loadCBBMS();
            }
        });
    }//GEN-LAST:event_btn_themMSActionPerformed

    private void txt_NamSXFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_NamSXFocusLost
        // TODO add your handling code here:
        //        txt_ngayNhapHang.setText(java.time.LocalDate.now() + "");
    }//GEN-LAST:event_txt_NamSXFocusLost

    private void txt_NamSXFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_NamSXFocusGained
        // TODO add your handling code here:
        //        txt_ngayNhapHang.setText("");
    }//GEN-LAST:event_txt_NamSXFocusGained

    private void cbo_trangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_trangThaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_trangThaiActionPerformed

    private void txt_timKiemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_timKiemFocusLost
        // TODO add your handling code here:
        //        txt_timKiem.setText("Tìm Kiếm...");
        //        loadTable(null);
    }//GEN-LAST:event_txt_timKiemFocusLost

    private void txt_timKiemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_timKiemFocusGained
        // TODO add your handling code here:
        //        txt_timKiem.setText("");
    }//GEN-LAST:event_txt_timKiemFocusGained

    private void txt_timKiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_timKiemCaretUpdate
        //        // TODO add your handling code here:
        //        if (txt_timKiem.getText().isEmpty()) {
        //            loadTable(null);
        //        }
        //        loadTable(txt_timKiem.getText());
    }//GEN-LAST:event_txt_timKiemCaretUpdate

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
//        cbo_sanPham.setSelectedIndex(0);
        cbo_mauSac.setSelectedIndex(0);
        cbbHang.setSelectedIndex(0);
        cbo_size.setSelectedIndex(0);
        txt_NamSX.setText(null);
        txt_giaBan.setText(null);
        txt_soLuong.setText(null);
        cbo_trangThai.setSelectedIndex(0);
    }//GEN-LAST:event_btn_clearActionPerformed

    private void tblCTSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCTSanPhamMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON1) {
            // Tạm dừng sự kiện ItemChange
            shouldProcessItemChange = false;
            showDetailsChiTietSP();
            shouldProcessItemChange = true;
        }
    }//GEN-LAST:event_tblCTSanPhamMouseClicked

    private void refreshTable() {
        List<ChiTietSP> list = chiTietSPService.getAll();
        fillTableCTSP(list);
    }
    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        int selectedRow = tblCTSanPham.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "bạn chưa chọn dòng cần sửa");
            return;
        }
        String ma = (String) tblCTSanPham.getValueAt(selectedRow, 0);
        if (checkCTSP()) {
            if (chiTietSPService.updateCTSP(getInputChiTietSP(), ma) > 0) {
                JOptionPane.showMessageDialog(this, "OK");
                SanPham selectedSanPham = (SanPham) cbo_sanPham.getSelectedItem();
                fillTableCTSP(chiTietSPService.locTenSP(selectedSanPham));
                resetInputCTSP();
            } else {
                JOptionPane.showMessageDialog(this, "Fails");
            }
        }
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        // TODO add your handling code here:
        index = tblCTSanPham.getSelectedRow();
        if (checkCTSP()) {
            ChiTietSP chiTietSP = getInputChiTietSP();
            if (chiTietSPService.addCTSP(chiTietSP) != null) {
                JOptionPane.showMessageDialog(this, "OK");
                SanPham selectedSanPham = (SanPham) cbo_sanPham.getSelectedItem();
                fillTableCTSP(chiTietSPService.locTenSP(selectedSanPham));
                resetInputCTSP();
            } else {
                JOptionPane.showMessageDialog(this, "Fails");
            }
        }
    }//GEN-LAST:event_btn_themActionPerformed

    private void cbo_locSizeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_locSizeItemStateChanged
        try {
            if (comboBoxEventEnabled && initializing) {
                Size selectedSize = (Size) cbo_locSize.getSelectedItem();
                if ("Tất cả".equals(selectedSize.getTenSize())) {
                    loadTableChitietSP();
                } else {
                    fillTableCTSP(chiTietSPService.locTenSize(selectedSize));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            initializing = true;
        }
    }//GEN-LAST:event_cbo_locSizeItemStateChanged

    private void bttThemDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttThemDanhMucActionPerformed
        // TODO add your handling code here:
        String ma = txtMaDanhMuc.getText();
        if (valideteDanhMuc()) {
            if (danhMucService.findByMa(ma) != null) {
                JOptionPane.showMessageDialog(this, "Mã danh mục đã tồn tại");
            } else {
                DanhMuc dm = getInputDanhMuc();
                if (danhMucService.addSP(dm) != null) {
                    JOptionPane.showMessageDialog(this, "OK");
                    loadTableDanhMuc();
                    loadCBB();
                    resetInputDM();
                } else {
                    JOptionPane.showMessageDialog(this, "Fails");
                }
            }
        }
    }//GEN-LAST:event_bttThemDanhMucActionPerformed

    private void tblListDMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListDMMouseClicked
        // TODO add your handling code here:
        showDetailsDanhMuc();
    }//GEN-LAST:event_tblListDMMouseClicked

    private void bttSuaDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttSuaDanhMucActionPerformed
        // TODO add your handling code here:
        index = tblListDM.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "bạn chưa chọn dòng cần sửa");
            return;
        }
        if (valideteDanhMuc()) {
            if (txtMaDanhMuc.getText().equals(tblListDM.getValueAt(index, 0))) {
                DanhMuc dm = getInputDanhMuc();
                if (danhMucService.updateSP(dm, danhMucService.getAll().get(index).getId()) > 0) {
                    JOptionPane.showMessageDialog(this, "OK");
                    loadTableDanhMuc();
                    loadCBB();
                    resetInputDM();
                } else {
                    JOptionPane.showMessageDialog(this, "Fails");
                }
            } else {
                if (danhMucService.findByMa(txtMaDanhMuc.getText()) != null) {
                    JOptionPane.showMessageDialog(this, "Mã đã dùng cho danh mục khác");
                } else {
                    DanhMuc dm = getInputDanhMuc();
                    if (danhMucService.updateSP(dm, danhMucService.getAll().get(index).getId()) > 0) {
                        JOptionPane.showMessageDialog(this, "OK");
                        loadTableDanhMuc();
                        loadCBB();
                        resetInputDM();
                    } else {
                        JOptionPane.showMessageDialog(this, "Fails");
                    }
                }
            }

        }
    }//GEN-LAST:event_bttSuaDanhMucActionPerformed

    private void tblThuongHieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThuongHieuMouseClicked
        // TODO add your handling code here:
        showDetailsThuongHieu();
    }//GEN-LAST:event_tblThuongHieuMouseClicked

    private void bttThemThuongHieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttThemThuongHieuActionPerformed
        // TODO add your handling code here:
        String ma = txtMaThuongHieu.getText();
        if (valideteThuongHieu()) {
            if (ma == null) {
                JOptionPane.showMessageDialog(this, "Mã màu đã tồn tại");
            } else {
                ThuongHieu th = getInputThuongHieu();
                if (thuongHieuService.addSP(th) != null) {
                    JOptionPane.showMessageDialog(this, "OK");
                    loadTableThuongHieu();
                    loadCBB();
                    resetInputTH();
                } else {
                    JOptionPane.showMessageDialog(this, "Fails");
                }
            }
        }
    }//GEN-LAST:event_bttThemThuongHieuActionPerformed

    private void bttSuaThuongHieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttSuaThuongHieuActionPerformed
        // TODO add your handling code here:
        index = tblThuongHieu.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "bạn chưa chọn dòng cần sửa");
            return;
        }
        if (valideteThuongHieu()) {
            ThuongHieu th = getInputThuongHieu();
            if (thuongHieuService.updateSP(th, thuongHieuService.getAll().get(index).getId()) > 0) {
                JOptionPane.showMessageDialog(this, "OK");
                loadTableThuongHieu();
                loadCBB();
                resetInputTH();
            } else {
                JOptionPane.showMessageDialog(this, "Fails");
            }
        }
    }//GEN-LAST:event_bttSuaThuongHieuActionPerformed

    private void tblMauSacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMauSacMouseClicked
        // TODO add your handling code here:
        showDetailsMauSac();
    }//GEN-LAST:event_tblMauSacMouseClicked

    private void tblSizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSizeMouseClicked
        // TODO add your handling code here:
        showDetailsSize();
    }//GEN-LAST:event_tblSizeMouseClicked

    private void tblChatLieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChatLieuMouseClicked
        // TODO add your handling code here:
        showDetailsChatLieu();
    }//GEN-LAST:event_tblChatLieuMouseClicked

    private void bttThemMauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttThemMauActionPerformed
        // TODO add your handling code here:
        if (checkMauSac()) {
            MauSacRepository mr = new MauSacRepository();
            if (mr.getMaMau(txtMaMau.getText()) != null) {
                JOptionPane.showMessageDialog(this, "Mã màu đã tồn tại");
            } else {
                MauSac ms = getInputMauSac();
                if (mauSacService.addSP(ms) != null) {
                    JOptionPane.showMessageDialog(this, "OK");
                    loadTableMauSac();
                    loadCBB();
                    resetInputMS();
                } else {
                    JOptionPane.showMessageDialog(this, "Fails");
                }
            }
        }

    }//GEN-LAST:event_bttThemMauActionPerformed

    private void bttSuaMauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttSuaMauActionPerformed
        // TODO add your handling code here:
        index = tblMauSac.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "bạn chưa chọn dòng cần sửa");
            return;
        }
        if (checkMauSac()) {
            MauSac ms = getInputMauSac();
            if (mauSacService.updateSP(ms, mauSacService.getAll().get(index).getId()) > 0) {
                JOptionPane.showMessageDialog(this, "OK");
                loadTableMauSac();
                loadCBB();
                resetInputMS();
            } else {
                JOptionPane.showMessageDialog(this, "Fails");
            }
        }

    }//GEN-LAST:event_bttSuaMauActionPerformed

    private void bttThemSizzeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttThemSizzeActionPerformed
        // TODO add your handling code here:
        Size s = getInputSize();
        String ma = txtMaSize.getText();
        if (validateSize()) {
            if (sizeService.getMaSize(ma) == null) {
                if (sizeService.addSP(s) != null) {
                    JOptionPane.showMessageDialog(this, "OK");
                    loadTableSize();
                    loadCBB();
                    resetInputS();
                } else {
                    JOptionPane.showMessageDialog(this, "Fails");
                }

            } else {
                JOptionPane.showMessageDialog(this, "Mã size đã tồn tại");
            }
        }
    }//GEN-LAST:event_bttThemSizzeActionPerformed

    private void bttSuaSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttSuaSizeActionPerformed
        // TODO add your handling code here:
        index = tblSize.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "bạn chưa chọn dòng cần sửa");
            return;
        }
        Size s = getInputSize();
        String ma = (String) tblSize.getValueAt(index, 0);
        SizeRepository sr = new SizeRepository();
        if (validateSize()) {
            if (txtMaSize.getText().equals(ma)) {
                if (sizeService.updateSP(s, sizeService.getAll().get(index).getId()) > 0) {
                    JOptionPane.showMessageDialog(this, "OK");
                    loadTableSize();
                    loadCBB();
                    resetInputS();
                } else {
                    JOptionPane.showMessageDialog(this, "Fails");
                }
            } else {
                if (sr.getMaSize(ma) == null) {
                    if (sizeService.updateSP(s, sizeService.getAll().get(index).getId()) > 0) {
                        JOptionPane.showMessageDialog(this, "OK");
                        loadTableSize();
                        loadCBB();
                        resetInputS();
                    } else {
                        JOptionPane.showMessageDialog(this, "Fails");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Mã size đã được dùng cho size khác");
                }
            }
        }
    }//GEN-LAST:event_bttSuaSizeActionPerformed

    private void bttThemChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttThemChatLieuActionPerformed
        // TODO add your handling code here:
        if (valideteChatLieu()) {
            ChatLieuRepository mr = new ChatLieuRepository();
            if (mr.getMaChatLieu(txtMaChatLieu.getText()) != null) {
                JOptionPane.showMessageDialog(this, "Mã chất liệu đã tồn tại");
            } else {
                ChatLieu cl = getInputChatLieu();
                if (chatLieuService.addSP(cl) != null) {
                    JOptionPane.showMessageDialog(this, "OK");
                    loadTableChatLieu();
                    loadCBB();
                    resetInputSPCL();
                } else {
                    JOptionPane.showMessageDialog(this, "Fails");
                }
    }//GEN-LAST:event_bttThemChatLieuActionPerformed
        }
    }
    private void bttSuaChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttSuaChatLieuActionPerformed
        // TODO add your handling code here:
        index = tblChatLieu.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "bạn chưa chọn dòng cần sửa");
            return;
        }
        if (valideteChatLieu()) {
            ChatLieu cl = getInputChatLieu();
            if (chatLieuService.updateSP(cl, chatLieuService.getAll().get(index).getId()) > 0) {
                JOptionPane.showMessageDialog(this, "OK");
                loadTableChatLieu();
                loadCBB();
                resetInputSPCL();
            } else {
                JOptionPane.showMessageDialog(this, "Fails");
            }
        }
    }//GEN-LAST:event_bttSuaChatLieuActionPerformed

    void fillTableTimDM(List<DanhMuc> list) {
        tblModel = (DefaultTableModel) tblListDM.getModel();
        tblModel.setRowCount(0);
        for (DanhMuc d : list) {
            Object toDataRow[] = {d.getMaDanhMuc(), d.getTenDanhMuc()};
            tblModel.addRow(toDataRow);
        }
    }
    private void txtTimNDMKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimNDMKeyReleased
        // TODO add your handling code here:
        this.fillTableTimDM(danhMucService.timDM(txtTimNDM.getText()));
    }//GEN-LAST:event_txtTimNDMKeyReleased

    private void txtSearchByNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchByNameKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtSearchByNameKeyPressed

    private void txtSearchByNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchByNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchByNameActionPerformed

    private void txtSearchByNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchByNameKeyReleased
        // TODO add your handling code here:
        String searchByName = txtSearchByName.getText();
        this.fillTableThuongHieu(thuongHieuService.searchByName(searchByName));
    }//GEN-LAST:event_txtSearchByNameKeyReleased


    private void txtTimThuongHieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimThuongHieuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimThuongHieuActionPerformed


    private void txtTimkiemMausacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimkiemMausacActionPerformed

    }//GEN-LAST:event_txtTimkiemMausacActionPerformed

    private void txtTimkiemMausacKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimkiemMausacKeyReleased
        String searchName = txtTimkiemMausac.getText();
        this.fillTableMauSac(mauSacService.searchName(searchName));
    }//GEN-LAST:event_txtTimkiemMausacKeyReleased

    private void txtTimChatLIeuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimChatLIeuKeyReleased
        // TODO add your handling code here:

        this.fillTableTimChatLieu(chatLieuService.timcl(txtTimChatLIeu.getText()));
    }//GEN-LAST:event_txtTimChatLIeuKeyReleased

    private void txtTimKiemSizeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemSizeKeyReleased
        // TODO add your handling code here:
        SizeRepository sr = new SizeRepository();
        String m = "%" + txtTimKiemSize.getText() + "%";
        fillTableSize(sr.getSize(m));
    }//GEN-LAST:event_txtTimKiemSizeKeyReleased

    private void tabPanelCTSPStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabPanelCTSPStateChanged
    }//GEN-LAST:event_tabPanelCTSPStateChanged

    private void cbo_locMauSacKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbo_locMauSacKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_cbo_locMauSacKeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        viewSize newViewSize = new viewSize();
        newViewSize.setVisible(true);

        // Thêm WindowListener để theo dõi sự kiện đóng cửa sổ
        newViewSize.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                // Được gọi khi cửa sổ được đóng
                loadCBBS();
            }
        });
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtTenThuongHieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenThuongHieuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenThuongHieuActionPerformed

    private void txt_timKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_timKiemKeyReleased
        String searchText = txt_timKiem.getText();
        this.fillTableCTSP(chiTietSPService.locTen(searchText));
    }//GEN-LAST:event_txt_timKiemKeyReleased

    private void txtTimTenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimTenKeyReleased
        // TODO add your handling code here:
        String searchText = txtTimTen.getText();
        this.fillTableTimTen(sanPhamService.timTen(searchText));
    }//GEN-LAST:event_txtTimTenKeyReleased

    private void txtTimTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimTenActionPerformed
        // TODO add your handling code here:
        //        sanPhamService.timTen(txtTimTen.getText());
        //        this.fillTableTimTen(sanPhamService.timTen(txtTimTen.getText()));
    }//GEN-LAST:event_txtTimTenActionPerformed

    private void txtTimTenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimTenMouseClicked
        // TODO add your handling code here:
        //        this.fillTableTimTen(sanPhamService.timTen(txtTimTen.getText()));
    }//GEN-LAST:event_txtTimTenMouseClicked

    private void txtTimTenAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_txtTimTenAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimTenAncestorAdded

    private void txtTimTenCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimTenCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimTenCaretUpdate

    private void tblListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListMouseClicked
        // TODO add your handling code here:
        showdetailsSP();
        int selectedRow = tblList.getSelectedRow();
        // Lấy thông tin sản phẩm đã chọn từ bảng
        String id = sanPhamService.getAll().get(selectedRow).getId();
        String maSP = (String) tblList.getValueAt(selectedRow, 0);
        String tenSP = (String) tblList.getValueAt(selectedRow, 1);

        selectedSanPham = new SanPham(id, maSP, tenSP);
    }//GEN-LAST:event_tblListMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        index = tblList.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "bạn chưa chọn dòng cần sửa");
            return;
        }
        if (validateSP()) {
            if (txtMaSP.getText().equals(tblList.getValueAt(index, 0))) {
                SanPham sanPham = getInputSP();
                if (sanPhamService.updateSP(sanPham, sanPhamService.getAll().get(index).getId()) > 0) {
                    JOptionPane.showMessageDialog(this, "OK");
                    loadTableSP();
                    loadCBB();
                    resetInputSP();
                } else {
                    JOptionPane.showMessageDialog(this, "Fails");
                }
            } else {
                if (sanPhamService.checkMa(txtMaSP.getText()) == 1) {
                    JOptionPane.showMessageDialog(this, "Mã SP đã được dùng cho SP khác");
                } else {
                    SanPham sanPham = getInputSP();
                    if (sanPhamService.updateSP(sanPham, sanPhamService.getAll().get(index).getId()) > 0) {
                        JOptionPane.showMessageDialog(this, "OK");
                        loadTableSP();
                        loadCBB();
                        resetInputSP();
                    } else {
                        JOptionPane.showMessageDialog(this, "Fails");
                    }
                }
            }

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (validateSP()) {
            if (sanPhamService.checkMa(txtMaSP.getText()) == 1) {
                JOptionPane.showMessageDialog(this, "Mã SP đã tồn tại");
            } else {
                SanPham sp = getInputSP();
                if (sanPhamService.addSP(sp) != null) {
                    JOptionPane.showMessageDialog(this, "OK");
                    loadTableSP();
                    loadCBB();
                    resetInputSP();
                } else {
                    JOptionPane.showMessageDialog(this, "Fails");
                }
            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtTimTenFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimTenFocusGained
        // TODO add your handling code here:
        if (txtTimTen.getText().equals("Tìm kiếm")) {
            txtTimTen.setText(null);
            removePlaceHolderStyle(txtTimTen);

        }
    }//GEN-LAST:event_txtTimTenFocusGained

    private void txtTimTenFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimTenFocusLost
        // TODO add your handling code here:
        if (txtTimTen.getText().length() == 0) {
            addPlaceHolderStyle(txtTimTen);
            txtTimTen.setText("Tìm kiếm");
        }
    }//GEN-LAST:event_txtTimTenFocusLost

    private void bttChiTietSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttChiTietSPActionPerformed
        // TODO add your handling code here:
        int i = -1;
        i = tblList.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn sản phẩm");
        } else {
            Component chiTietSPComponent = pnlChiTietSP;
            tabPanelCTSP.setSelectedComponent(chiTietSPComponent);
            if (selectedSanPham != null) {
                // Cập nhật combox sản phẩm trên tab chi tiết sản phẩm
                modelSanPham.setSelectedItem(selectedSanPham);
            }

        }
    }//GEN-LAST:event_bttChiTietSPActionPerformed

    private void cbo_sanPhamItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_sanPhamItemStateChanged
        // TODO add your handling code here:
        if (shouldProcessItemChange) {
            SanPham selectedSanPham = (SanPham) cbo_sanPham.getSelectedItem();
            fillTableCTSP(chiTietSPService.locTenSP(selectedSanPham));
        }
    }//GEN-LAST:event_cbo_sanPhamItemStateChanged
    void fillTableTimChatLieu(List<ChatLieu> list) {
        tblModel = (DefaultTableModel) tblChatLieu.getModel();
        tblModel.setRowCount(0);
        for (ChatLieu cl : list) {
            Object toDataRow[] = {cl.getMaChatLieu(), cl.getTenChatLieu(),};
            tblModel.addRow(toDataRow);
        }
    }

    void fillTableCTSP(List<ChiTietSP> list) {
        tblModel = (DefaultTableModel) tblCTSanPham.getModel();
        tblModel.setRowCount(0);
        for (ChiTietSP chiTietSP : list) {
            tblModel.addRow(chiTietSP.toDataRow());
        }
    }

    void fillTableTimTen(List<SanPham> list) {
        tblModel = (DefaultTableModel) tblList.getModel();
        tblModel.setRowCount(0);
        for (SanPham sp : list) {
            Object toDataRow[] = {sp.getMaSP(), sp.getTenSP(), sp.getDm(), sp.getTh()};
            tblModel.addRow(toDataRow);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReloadCTSP;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_themDG1;
    private javax.swing.JButton btn_themMS;
    private javax.swing.JButton bttChiTietSP;
    private javax.swing.JButton bttSuaChatLieu;
    private javax.swing.JButton bttSuaDanhMuc;
    private javax.swing.JButton bttSuaMau;
    private javax.swing.JButton bttSuaSize;
    private javax.swing.JButton bttSuaThuongHieu;
    private javax.swing.JButton bttThemChatLieu;
    private javax.swing.JButton bttThemDanhMuc;
    private javax.swing.JButton bttThemMau;
    private javax.swing.JButton bttThemSizze;
    private javax.swing.JButton bttThemThuongHieu;
    private javax.swing.JComboBox<ThuongHieu> cbbHang;
    private javax.swing.JComboBox<DanhMuc> cbbLoai;
    private javax.swing.JComboBox<ChatLieu> cbo_chatLieu;
    private javax.swing.JComboBox<String> cbo_locMauSac;
    private javax.swing.JComboBox<String> cbo_locSize;
    private javax.swing.JComboBox<MauSac> cbo_mauSac;
    private javax.swing.JComboBox<String> cbo_sanPham;
    private javax.swing.JComboBox<Size> cbo_size;
    private javax.swing.JComboBox<String> cbo_trangThai;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel lbl_deGiay;
    private javax.swing.JLabel lbl_giaBan;
    private javax.swing.JLabel lbl_kichCo;
    private javax.swing.JLabel lbl_locDongSP;
    private javax.swing.JLabel lbl_locMauSac;
    private javax.swing.JLabel lbl_mauSac;
    private javax.swing.JLabel lbl_ngayNhapHang;
    private javax.swing.JLabel lbl_sanPhamct;
    private javax.swing.JLabel lbl_soLuong;
    private javax.swing.JLabel lbl_trangThai;
    private javax.swing.JPanel pnlChiTietSP;
    private javax.swing.JPanel pnlDanhMuc;
    private javax.swing.JPanel pnlMauSac;
    private javax.swing.JPanel pnlSanPham;
    private javax.swing.JPanel pnlSanPhamChiTiet;
    private javax.swing.JPanel pnlThuocTinh;
    private javax.swing.JPanel pnlThuongHieu;
    private javax.swing.JTabbedPane tabPanelCTSP;
    private javax.swing.JTable tblCTSanPham;
    private javax.swing.JTable tblChatLieu;
    private javax.swing.JTable tblList;
    private javax.swing.JTable tblListDM;
    private javax.swing.JTable tblMauSac;
    private javax.swing.JTable tblSize;
    private javax.swing.JTable tblThuongHieu;
    private javax.swing.JTextField txtMaChatLieu;
    private javax.swing.JTextField txtMaDanhMuc;
    private javax.swing.JTextField txtMaMau;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtMaSize;
    private javax.swing.JTextField txtMaThuongHieu;
    private javax.swing.JTextField txtSearchByName;
    private javax.swing.JTextField txtTenChatLieu;
    private javax.swing.JTextField txtTenDanhMuc;
    private javax.swing.JTextField txtTenMau;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtTenSize;
    private javax.swing.JTextField txtTenThuongHieu;
    private javax.swing.JTextField txtTimChatLIeu;
    private javax.swing.JTextField txtTimKiemSize;
    private javax.swing.JTextField txtTimNDM;
    private javax.swing.JTextField txtTimTen;
    private javax.swing.JTextField txtTimkiemMausac;
    private javax.swing.JTextField txt_NamSX;
    private javax.swing.JTextField txt_giaBan;
    private javax.swing.JTextField txt_soLuong;
    private javax.swing.JTextField txt_timKiem;
    // End of variables declaration//GEN-END:variables
    private void loadTableSP() {
        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel) tblList.getModel();

        model.setRowCount(0);
        List<SanPham> list = sanPhamService.getAll();

        for (SanPham sanPham : list) {
            model.addRow(new Object[]{
                sanPham.getMaSP(),
                sanPham.getTenSP(),
                sanPham.getDm(),
                sanPham.getTh()
            });
        }
    }

    boolean validateSP() {
        if (txtMaSP.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "bạn chưa nhập mã sản phẩm ");
            return false;
        }
        if (txtTenSP.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "bạn chưa nhập tên sản phẩm ");
            return false;
        }
        return true;
    }

    public SanPham getInputSP() {
        SanPham sanPham = new SanPham();
        sanPham.setMaSP(txtMaSP.getText());
        sanPham.setTenSP(txtTenSP.getText());
        sanPham.setDm((DanhMuc) modelDanhMuc.getSelectedItem());
        sanPham.setTh((ThuongHieu) modelThuongHieu.getSelectedItem());
        return sanPham;
    }

    private void showdetailsSP() {
        Integer row = tblList.getSelectedRow();
        txtMaSP.setText(tblList.getValueAt(row, 0).toString());
        txtTenSP.setText(tblList.getValueAt(row, 1).toString());
        DanhMuc danhMuc = (DanhMuc) tblList.getValueAt(row, 2);
        modelDanhMuc.setSelectedItem(danhMuc);

        ThuongHieu thuongHieu = (ThuongHieu) tblList.getValueAt(row, 3);
        modelThuongHieu.setSelectedItem(thuongHieu);

//        selectedSanPham = new SanPham(null, maSP, tenSP);
    }

    private void loadTableDanhMuc() {
        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel) tblListDM.getModel();

        model.setRowCount(0);
        List<DanhMuc> list = danhMucService.getAll();

        for (DanhMuc danhMuc : list) {
            model.addRow(new Object[]{
                danhMuc.getMaDanhMuc(),
                danhMuc.getTenDanhMuc()
            });
        }
    }

    private void showDetailsDanhMuc() {
        Integer row = tblListDM.getSelectedRow();
        txtMaDanhMuc.setText((String) tblListDM.getValueAt(row, 0));
        txtTenDanhMuc.setText((String) tblListDM.getValueAt(row, 1));
    }

    public DanhMuc getInputDanhMuc() {
        DanhMuc dm = new DanhMuc();
        dm.setMaDanhMuc(txtMaDanhMuc.getText());
        dm.setTenDanhMuc(txtTenDanhMuc.getText());
        return dm;
    }

    private void loadTableThuongHieu() {
        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel) tblThuongHieu.getModel();

        model.setRowCount(0);
        List<ThuongHieu> list = thuongHieuService.getAll();

        for (ThuongHieu thuongHieu : list) {
            model.addRow(new Object[]{
                thuongHieu.getMaTH(),
                thuongHieu.getTenTH()
            });
        }
    }

    private void showDetailsThuongHieu() {
        Integer row = tblThuongHieu.getSelectedRow();
        txtMaThuongHieu.setText((String) tblThuongHieu.getValueAt(row, 0));
        txtTenThuongHieu.setText((String) tblThuongHieu.getValueAt(row, 1));
    }

    public ThuongHieu getInputThuongHieu() {
        ThuongHieu th = new ThuongHieu();
        th.setMaTH(txtMaThuongHieu.getText());
        th.setTenTH(txtTenThuongHieu.getText());
        return th;
    }

    private void loadTableMauSac() {
        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel) tblMauSac.getModel();

        model.setRowCount(0);
        List<MauSac> list = mauSacService.getAll();

        for (MauSac mauSac : list) {
            model.addRow(new Object[]{
                mauSac.getMaMauSac(),
                mauSac.getTenMauSac()
            });
        }
    }

    private void showDetailsMauSac() {
        Integer row = tblMauSac.getSelectedRow();
        txtMaMau.setText((String) tblMauSac.getValueAt(row, 0));
        txtTenMau.setText((String) tblMauSac.getValueAt(row, 1));
    }

    public MauSac getInputMauSac() {
        MauSac ms = new MauSac();
        ms.setMaMauSac(txtMaMau.getText());
        ms.setTenMauSac(txtTenMau.getText());
        return ms;
    }

    public Size getInputSize() {
        Size s = new Size();
        s.setMaSize(txtMaSize.getText());
        s.setTenSize(txtTenSize.getText());
        return s;
    }

    private void showDetailsSize() {
        Integer row = tblSize.getSelectedRow();
        txtMaSize.setText((String) tblSize.getValueAt(row, 0));
        txtTenSize.setText((String) tblSize.getValueAt(row, 1));
    }

    private void loadTableSize() {
        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel) tblSize.getModel();

        model.setRowCount(0);
        List<Size> list = sizeService.getAll();

        for (Size size : list) {
            model.addRow(new Object[]{
                size.getMaSize(),
                size.getTenSize()
            });
        }
    }

    private void loadTableChatLieu() {
        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel) tblChatLieu.getModel();

        model.setRowCount(0);
        List<ChatLieu> list = chatLieuService.getAll();

        for (ChatLieu chatLieu : list) {
            model.addRow(new Object[]{
                chatLieu.getMaChatLieu(),
                chatLieu.getTenChatLieu()
            });
        }
    }

    private void showDetailsChatLieu() {
        Integer row = tblChatLieu.getSelectedRow();
        txtMaChatLieu.setText((String) tblChatLieu.getValueAt(row, 0));
        txtTenChatLieu.setText((String) tblChatLieu.getValueAt(row, 1));
    }

    public ChatLieu getInputChatLieu() {
        ChatLieu cl = new ChatLieu();
        cl.setMaChatLieu(txtMaChatLieu.getText());
        cl.setTenChatLieu(txtTenChatLieu.getText());
        return cl;
    }

    private void loadCBBMS() {
        List<MauSac> mauSacs = mauSacService.getAll();
        modelMacSac = (DefaultComboBoxModel) new DefaultComboBoxModel<>(mauSacs.toArray());
        cbo_mauSac.setModel((DefaultComboBoxModel) modelMacSac);
    }

    private void loadCBBCL() {
        List<ChatLieu> chatLieus = chatLieuService.getAll();
        modelChatLieu = (DefaultComboBoxModel) new DefaultComboBoxModel<>(chatLieus.toArray());
        cbo_chatLieu.setModel((DefaultComboBoxModel) modelChatLieu);
    }

    private void loadCBBS() {
        List<Size> sizes = sizeService.getAll();
        modelSize = (DefaultComboBoxModel) new DefaultComboBoxModel<>(sizes.toArray());
        cbo_size.setModel((DefaultComboBoxModel) modelSize);
    }

    private void loadCBB() {
        List<SanPham> sanPhams = sanPhamService.getAll();
        modelSanPham = (DefaultComboBoxModel) new DefaultComboBoxModel<>(sanPhams.toArray());
        cbo_sanPham.setModel((DefaultComboBoxModel) modelSanPham);

        List<DanhMuc> danhMucs = danhMucService.getAll();
        modelDanhMuc = (DefaultComboBoxModel) new DefaultComboBoxModel<>(danhMucs.toArray());
        cbbLoai.setModel((DefaultComboBoxModel) modelDanhMuc);

        List<ThuongHieu> thuongHieus = thuongHieuService.getAll();
        modelThuongHieu = (DefaultComboBoxModel) new DefaultComboBoxModel<>(thuongHieus.toArray());
        cbbHang.setModel((DefaultComboBoxModel) modelThuongHieu);

        List<MauSac> mauSacs = mauSacService.getAll();
        modelMacSac = (DefaultComboBoxModel) new DefaultComboBoxModel<>(mauSacs.toArray());
        cbo_mauSac.setModel((DefaultComboBoxModel) modelMacSac);

        List<Size> sizes = sizeService.getAll();
        modelSize = (DefaultComboBoxModel) new DefaultComboBoxModel<>(sizes.toArray());
        cbo_size.setModel((DefaultComboBoxModel) modelSize);

        List<ChatLieu> chatLieus = chatLieuService.getAll();
        modelChatLieu = (DefaultComboBoxModel) new DefaultComboBoxModel<>(chatLieus.toArray());
        cbo_chatLieu.setModel((DefaultComboBoxModel) modelChatLieu);
    }

    private void loadTableChitietSP() {
        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel) tblCTSanPham.getModel();

        model.setRowCount(0);
        List<ChiTietSP> list = chiTietSPService.getAll();
        for (ChiTietSP chiTietSP : list) {
            model.addRow(new Object[]{
                chiTietSP.getMaCT(),
                chiTietSP.getSanPham(),
                chiTietSP.getMauSac(),
                chiTietSP.getChatLieu(),
                chiTietSP.getNamSX(),
                chiTietSP.getGiaBan(),
                chiTietSP.getSoluong(),
                chiTietSP.getSize(),
                chiTietSP.getTrangThai()
            });

        }
    }

    private void showDetailsChiTietSP() {
        // Kiểm tra hàng và số cột
        int selectedRow = tblCTSanPham.getSelectedRow();
        if (selectedRow == -1 || tblCTSanPham.getColumnCount() < 9) {
            // Không có hàng nào được chọn hoặc số cột không đủ, không thể hiển thị chi tiết.
            return;
        }

        try {
            // Hiển thị thông tin sản phẩm
            SanPham sanPham = (SanPham) tblCTSanPham.getValueAt(selectedRow, 1);
            MauSac mauSac = (MauSac) tblCTSanPham.getValueAt(selectedRow, 2);
            ChatLieu chatLieu = (ChatLieu) tblCTSanPham.getValueAt(selectedRow, 3);
            int namSX = (int) tblCTSanPham.getValueAt(selectedRow, 4);
            double giaBan = (double) tblCTSanPham.getValueAt(selectedRow, 5);
            int soLuong = (int) tblCTSanPham.getValueAt(selectedRow, 6);
            Size size = (Size) tblCTSanPham.getValueAt(selectedRow, 7);
            String trangThai = (String) tblCTSanPham.getValueAt(selectedRow, 8);

            // Tiếp tục xử lý thông tin...
            modelSanPham.setSelectedItem(sanPham);
            modelMacSac.setSelectedItem(mauSac);
            modelChatLieu.setSelectedItem(chatLieu);
            txt_NamSX.setText(String.valueOf(namSX));
            txt_soLuong.setText(String.valueOf(soLuong));
            txt_giaBan.setText(String.valueOf(giaBan));
            modelSize.setSelectedItem(size);
            cbo_trangThai.setSelectedItem(trangThai);
        } catch (Exception e) {
            // Xử lý ngoại lệ
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi hiển thị chi tiết sản phẩm.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

        // Cập nhật lựa chọn trên bảng
        tblCTSanPham.setRowSelectionInterval(selectedRow, selectedRow);
    }

    private String getCurrentMaCTList() {
        Set<String> existingMaHoaDon = new HashSet<>();

        // Lọc tất cả các hóa đơn từ cơ sở dữ liệu
        for (ChiTietSP chiTietSP : chiTietSPService.getAll()) {
            existingMaHoaDon.add(chiTietSP.getMaCT());
        }

        int soThuTu = 1;

        // Tạo mã mới đảm bảo sự duy nhất
        while (true) {
            String maHoaDon = "CT" + soThuTu;

            if (!existingMaHoaDon.contains(maHoaDon)) {
                // Nếu mã không tồn tại, sử dụng nó
                break;
            }

            // Nếu mã đã tồn tại, tăng số thứ tự lên 1 và thử lại
            soThuTu++;
        }

        ChiTietSP chiTietSP = new ChiTietSP("CT" + soThuTu);
        // Trả về mã hóa đơn mới
        return "CT" + soThuTu;
    }

    public ChiTietSP getInputChiTietSP() {
        ChiTietSP chiTietSP = new ChiTietSP();

        String maCT = getCurrentMaCTList();
        chiTietSP.setMaCT(maCT);
        chiTietSP.setSanPham((SanPham) modelSanPham.getSelectedItem());
        chiTietSP.setMauSac((MauSac) modelMacSac.getSelectedItem());
        chiTietSP.setChatLieu((ChatLieu) modelChatLieu.getSelectedItem());

        chiTietSP.setNamSX(Integer.valueOf(txt_NamSX.getText()));
        chiTietSP.setGiaBan(Double.valueOf(txt_giaBan.getText()));
        chiTietSP.setSoluong(Integer.valueOf(txt_soLuong.getText()));

        chiTietSP.setSize((Size) modelSize.getSelectedItem());

        chiTietSP.setTrangThai((String) cbo_trangThai.getSelectedItem());
        return chiTietSP;
    }

    boolean checkCTSP() {
        ChiTietSP chiTietSP = new ChiTietSP();
        chiTietSP.setSanPham((SanPham) modelSanPham.getSelectedItem());
        chiTietSP.setMauSac((MauSac) modelMacSac.getSelectedItem());
        chiTietSP.setChatLieu((ChatLieu) modelChatLieu.getSelectedItem());
        try {
            chiTietSP.setNamSX(Integer.valueOf(txt_NamSX.getText()));
        } catch (NumberFormatException e) {
            // Xử lý lỗi khi nhập giá trị không phải là số nguyên cho năm sản xuất
            JOptionPane.showMessageDialog(this, "Năm sản xuất không hợp lệ.", "Lỗi Nhập Liệu", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try {
            chiTietSP.setGiaBan(Double.valueOf(txt_giaBan.getText()));
        } catch (NumberFormatException e) {
            // Xử lý lỗi khi nhập giá trị không phải là số thực cho giá bán
            JOptionPane.showMessageDialog(this, "Giá bán không hợp lệ.", "Lỗi Nhập Liệu", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try {
            chiTietSP.setSoluong(Integer.valueOf(txt_soLuong.getText()));
        } catch (NumberFormatException e) {
            // Xử lý lỗi khi nhập giá trị không phải là số nguyên cho số lượng
            JOptionPane.showMessageDialog(this, "Số lượng không hợp lệ.", "Lỗi Nhập Liệu", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        chiTietSP.setSize((Size) modelSize.getSelectedItem());
        chiTietSP.setTrangThai((String) cbo_trangThai.getSelectedItem());

        return true;
    }

    private void resetInputCTSP() {
//        cbo_sanPham.setSelectedIndex(0);
        cbo_mauSac.setSelectedIndex(0);
        cbbHang.setSelectedIndex(0);
        cbo_size.setSelectedIndex(0);
        txt_NamSX.setText(null);
        txt_giaBan.setText(null);
        txt_soLuong.setText(null);
        cbo_trangThai.setSelectedIndex(0);
    }

    private void fillTableThuongHieu(List<ThuongHieu> searchByName) {
        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel) tblThuongHieu.getModel();

        model.setRowCount(0);
        for (ThuongHieu thuongHieu : searchByName) {
            model.addRow(new Object[]{
                thuongHieu.getMaTH(),
                thuongHieu.getTenTH()
            });
        }
    }

    private void loc_MauSac(List<MauSac> searchName) {
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        defaultTableModel = (DefaultTableModel) tblCTSanPham.getModel();
        defaultTableModel.setRowCount(0);
        for (MauSac mauSac : searchName) {
            defaultTableModel.addRow(new Object[]{mauSac.getMaMauSac(), mauSac.getTenMauSac()});
        }

    }

    private void fillTableMauSac(List<MauSac> searchName) {
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        defaultTableModel = (DefaultTableModel) tblMauSac.getModel();
        defaultTableModel.setRowCount(0);
        for (MauSac mauSac : searchName) {
            defaultTableModel.addRow(new Object[]{mauSac.getMaMauSac(), mauSac.getTenMauSac()});
        }

    }

    public void fillTableSize(List<Size> lS) {
        DefaultTableModel model = (DefaultTableModel) tblSize.getModel();
        model.setRowCount(0);
        for (Size size : lS) {
            model.addRow(size.toDataRow());
        }
    }

    boolean checkMauSac() {
        if (txtMaMau.getText().isBlank() || txtTenMau.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Không được để trống dữ liệu");
            return false;
        }
        return true;
    }

    boolean valideteChatLieu() {
        if (txtMaChatLieu.getText().isBlank() || txtTenChatLieu.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Không được để trống dữ liệu");
            return false;
        }
        return true;
    }

    boolean valideteDanhMuc() {
        if (txtMaDanhMuc.getText().isBlank() || txtTenDanhMuc.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Không được để trống dữ liệu");
            return false;
        }
        return true;
    }

    boolean valideteThuongHieu() {
        if (txtMaThuongHieu.getText().isBlank() || txtTenThuongHieu.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Không được để trống dữ liệu");
            return false;
        }
        return true;
    }

    boolean validateSize() {
        if (txtMaSize.getText().isBlank() || txtTenSize.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Không được để trống dữ liệu");
            return false;
        }
        return true;
    }

    public void addPlaceHolderStyle(JTextField textField) {
        Font font = textField.getFont();
        font = font.deriveFont(font.ITALIC);
        textField.setFont(font);
        textField.setForeground(Color.gray);

    }

    public void removePlaceHolderStyle(JTextField textField) {
        Font font = textField.getFont();
        font = font.deriveFont(font.PLAIN | Font.BOLD);
        textField.setFont(font);
        textField.setForeground(Color.gray);

    }
}
