/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

/**
 *
 * @author THANH
 */
public class panelDoiTra extends javax.swing.JPanel {

    /**
     * Creates new form panelDoiTra
     */
    public panelDoiTra() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDoiTra = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        btnDoiSanPham = new javax.swing.JButton();
        lblTenKHDoiTra = new javax.swing.JLabel();
        lblMaHDDoiTra = new javax.swing.JLabel();
        lblNgaDoiHangDT = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        jLabel52 = new javax.swing.JLabel();
        cbbLiDoDoi = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel53 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        txtTimKiemDoiTra = new javax.swing.JTextField();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblHoaDonDoiTra = new javax.swing.JTable();
        btnLoc = new javax.swing.JButton();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tblDoiTra = new javax.swing.JTable();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tblHDCTDoiTra = new javax.swing.JTable();

        pnlDoiTra.setBackground(new java.awt.Color(255, 255, 255));

        jLabel47.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel47.setText("Quản lý đổi sản phẩm");

        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel48.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel48.setText("Tên khách hàng:");

        jLabel49.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel49.setText("Mã hóa đơn");

        jLabel50.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel50.setText("Ngày đổi hàng:");

        btnDoiSanPham.setBackground(new java.awt.Color(255, 204, 0));
        btnDoiSanPham.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnDoiSanPham.setForeground(new java.awt.Color(255, 255, 255));
        btnDoiSanPham.setText("Đổi sản phẩm");
        btnDoiSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiSanPhamActionPerformed(evt);
            }
        });

        lblTenKHDoiTra.setText("_____");

        lblMaHDDoiTra.setText("_____");

        lblNgaDoiHangDT.setText("_____");

        jLabel51.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel51.setText("Ghi chú:");

        txtGhiChu.setColumns(20);
        txtGhiChu.setRows(5);
        txtGhiChu.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtGhiChuCaretUpdate(evt);
            }
        });
        jScrollPane10.setViewportView(txtGhiChu);

        jLabel52.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel52.setText("Lí do đổi hàng:");

        cbbLiDoDoi.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cbbLiDoDoi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kich Co", "Mau Sac", "Chat Luong" }));

        jButton1.setBackground(new java.awt.Color(153, 0, 0));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Hóa đơn");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(133, 133, 133))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel52))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbLiDoDoi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMaHDDoiTra, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTenKHDoiTra, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblNgaDoiHangDT, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(btnDoiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(lblTenKHDoiTra))
                .addGap(27, 27, 27)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(lblMaHDDoiTra))
                .addGap(27, 27, 27)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(lblNgaDoiHangDT))
                .addGap(22, 22, 22)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(cbbLiDoDoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(jLabel51)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDoiSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel53.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel53.setText("Hoàn trả");

        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtTimKiemDoiTra.setText("Tìm kiếm ...");
        txtTimKiemDoiTra.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemDoiTraCaretUpdate(evt);
            }
        });
        txtTimKiemDoiTra.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTimKiemDoiTraFocusGained(evt);
            }
        });

        tblHoaDonDoiTra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblHoaDonDoiTra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblHoaDonDoiTra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonDoiTraMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tblHoaDonDoiTra);

        btnLoc.setBackground(new java.awt.Color(255, 153, 0));
        btnLoc.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnLoc.setForeground(new java.awt.Color(255, 255, 255));
        btnLoc.setText("Lọc");
        btnLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocActionPerformed(evt);
            }
        });

        jLabel77.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel77.setText("Từ ngày");

        jLabel78.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel78.setText("Đến ngày");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(txtTimKiemDoiTra, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTimKiemDoiTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnLoc)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel77)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel78)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblDoiTra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblDoiTra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane12.setViewportView(tblDoiTra);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel54.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel54.setText("Hóa đơn");

        jLabel55.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel55.setText("Hóa đơn đổi hàng");

        jLabel56.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel56.setText("Hóa đơn chi tiết");

        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblHDCTDoiTra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblHDCTDoiTra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblHDCTDoiTra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHDCTDoiTraMouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(tblHDCTDoiTra);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlDoiTraLayout = new javax.swing.GroupLayout(pnlDoiTra);
        pnlDoiTra.setLayout(pnlDoiTraLayout);
        pnlDoiTraLayout.setHorizontalGroup(
            pnlDoiTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDoiTraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDoiTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDoiTraLayout.createSequentialGroup()
                        .addGroup(pnlDoiTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel54))
                        .addGap(18, 18, 18)
                        .addGroup(pnlDoiTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDoiTraLayout.createSequentialGroup()
                                .addComponent(jLabel53)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnlDoiTraLayout.createSequentialGroup()
                                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(pnlDoiTraLayout.createSequentialGroup()
                        .addGroup(pnlDoiTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlDoiTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDoiTraLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(334, 334, 334))
                            .addGroup(pnlDoiTraLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
            .addGroup(pnlDoiTraLayout.createSequentialGroup()
                .addGap(401, 401, 401)
                .addComponent(jLabel47)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlDoiTraLayout.setVerticalGroup(
            pnlDoiTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDoiTraLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel47)
                .addGap(18, 18, 18)
                .addGroup(pnlDoiTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(jLabel53))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDoiTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlDoiTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel56)
                    .addGroup(pnlDoiTraLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel55)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDoiTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1177, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlDoiTra, javax.swing.GroupLayout.PREFERRED_SIZE, 1177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 724, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlDoiTra, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDoiSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiSanPhamActionPerformed
//        int indexHDCT = tblHDCTDoiTra.getSelectedRow();
//        int indexDT = tblDoiTra.getSelectedRow();
//
//        DoiTraCustomModel dt = new DoiTraCustomModel();
//        int indexHD = tblHoaDonDoiTra.getSelectedRow();
//        if (indexHD < 0) {
//            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn muốn đổi sản phẩm");
//        } else if (indexHDCT < 0) {
//            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phảm muốn đổi");
//        } else {
//            JOptionPane.showMessageDialog(this, "Đổi sản phẩm thành công");
//            listDoiTra.clear();
//            showDataDoiTra(listDoiTra);
//            lblMaHDDoiTra.setText("_____");
//            lblNgaDoiHangDT.setText("_____");
//            lblTenKHDoiTra.setText("_____");
//            txtGhiChu.setText("");
//            cbbLiDoDoi.setSelectedIndex(0);
//        }
    }//GEN-LAST:event_btnDoiSanPhamActionPerformed

    private void txtGhiChuCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtGhiChuCaretUpdate
//        if (txtGhiChu.getText().isEmpty()) {
//            btnDoiSanPham.setEnabled(false);
//        } else {
//            btnDoiSanPham.setEnabled(true);
//        }
    }//GEN-LAST:event_txtGhiChuCaretUpdate

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        DailogDoiTra dld = new DailogDoiTra(this, true);
//        dld.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtTimKiemDoiTraCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemDoiTraCaretUpdate
//        listHDDT = dts.SearchHDDT(txtTimKiemDoiTra.getText());
//        showDataHDDoiTra(listHDDT);
    }//GEN-LAST:event_txtTimKiemDoiTraCaretUpdate

    private void txtTimKiemDoiTraFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemDoiTraFocusGained
//        txtTimKiemDoiTra.setText("");
    }//GEN-LAST:event_txtTimKiemDoiTraFocusGained

    private void tblHoaDonDoiTraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonDoiTraMouseClicked
//        int index = tblHoaDonDoiTra.getSelectedRow();
//        HoaDonDoiTraCustomModel hd = listHDDT.get(index);
//
//        long millis = System.currentTimeMillis();
//        Timestamp t = new Timestamp(millis);
//        Date ngayTT = hd.getNgayThanhToan();
//        Calendar c1 = Calendar.getInstance();
//        Calendar c2 = Calendar.getInstance();
//        c1.setTime(ngayTT);
//        c2.setTime(t);
//        var temp = 0;
//        long noDay = (c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000);
//        if (noDay > 3) {
//            temp = JOptionPane.showConfirmDialog(this, "Hóa đơn đã quá hạn đổi, bạn vẫn muốn tiếp tục đổi ?");
//        }
//        if (temp == 0) {
//            String idHD = hd.getId();
//            listHDCTDT = dts.getHDCTDoiTra(idHD);
//            showDataHDCTDoiTra(listHDCTDT);
//            lblTenKHDoiTra.setText(hd.getTenKH());
//            lblMaHDDoiTra.setText(hd.getMaHD());
//            lblNgaDoiHangDT.setText(String.valueOf(new Date(millis)));
//        }
    }//GEN-LAST:event_tblHoaDonDoiTraMouseClicked

    private void btnLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocActionPerformed
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
//        if (dcBatDau.getDate() == null || dcKetThuc.getDate() == null) {
//            JOptionPane.showMessageDialog(this, "Ngày bắt đầu và ngày kết thúc không được để trống");
//        } else {
//
//            java.util.Date bd = (java.util.Date) dcBatDau.getDate();
//            java.util.Date kt = (java.util.Date) dcKetThuc.getDate();
//
//            Calendar c1 = Calendar.getInstance();
//            Calendar c2 = Calendar.getInstance();
//            c1.setTime(bd);
//            c2.setTime(kt);
//            var temp = 0;
//            long noDay = (c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000);
//
//            if (noDay < 0) {
//                JOptionPane.showConfirmDialog(this, "Ngày kết thúc phải lớn hơn ngày bắt đầu");
//            } else {
//
//                String batDau = sdf.format(dcBatDau.getDate());
//                String ketThuc = sdf.format(dcKetThuc.getDate());
//                listHDDT = dts.getHoaDonDoiTraBetween(batDau, ketThuc);
//                showDataHDDoiTra(listHDDT);
//            }
//        }
    }//GEN-LAST:event_btnLocActionPerformed

    private void tblHDCTDoiTraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHDCTDoiTraMouseClicked
//        int index = tblHDCTDoiTra.getSelectedRow();
//        HDCTDoiTraCustomModel hdct = listHDCTDT.get(index);
//        DoiTraCustomModel dt = new DoiTraCustomModel();
//        int indexHD = tblHoaDonDoiTra.getSelectedRow();
//        long millis = System.currentTimeMillis();
//        java.sql.Date date = new java.sql.Date(millis);
//        if (indexHD < 0) {
//            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn muốn đổi sản phẩm");
//        } else {
//            boolean trung = false;
//            for (DoiTraCustomModel x : listDoiTra) {
//                if (x.getSanPhamDoi().equals(hdct.getTenSP())) {
//                    trung = true;
//                }
//            }
//
//            if (trung) {
//                JOptionPane.showMessageDialog(this, "Sản phẩm đã có trong hóa đơn đổi hàng, để cập nhật vui lòng xóa đi chọn lại");
//            } else {
//
//                soLuongDTBH = JOptionPane.showInputDialog("Mời nhập số lượng: ");
//                if (soLuongDTBH != null) {
//                    if (!soLuongDTBH.matches("[0-9]+")) {
//                        JOptionPane.showMessageDialog(this, "Nhập đúng định dạng");
//                    } else if (Integer.valueOf(soLuongDTBH) > hdct.getSoLuong()) {
//                        JOptionPane.showMessageDialog(this, "Số lượng vượt quá");
//                    } else if (txtGhiChu.getText().isEmpty()) {
//                        JOptionPane.showMessageDialog(this, "Vui lòng điền ghi chú");
//                    } else {
//                        var chon = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn đổi sản phẩm");
//
//                        if (chon == 0) {
//                            HoaDonDoiTraCustomModel hd = listHDDT.get(indexHD);
//                            dt.setMaHD(lblMaHDDoiTra.getText());
//                            dt.setTenKH(lblTenKHDoiTra.getText());
//                            dt.setSanPhamDoi(hdct.getTenSP());
//                            dt.setSoLuongDoi(Integer.valueOf(soLuongDTBH));
//                            listDoiTra.add(dt);
//                            showDataDoiTra(listDoiTra);
//
//                            HoaDonDoiTraCustomModel hdc = listHDDT.get(indexHD);
//                            String idCTSP = hdct.getIdCTSP();
//                            String idHD = hdc.getId();
//                            String idKH = hdc.getIdKH();
//
//                            String liDoDoi = cbbLiDoDoi.getSelectedItem().toString();
//                            String ghiChu = txtGhiChu.getText();
//                            HoaDonDoiTraCustomModel hdadd = new HoaDonDoiTraCustomModel(idCTSP, idHD, idKH, date, Integer.valueOf(soLuongDTBH), liDoDoi, ghiChu);
//                            HDCTDoiTraCustomModel hdctadd = new HDCTDoiTraCustomModel(Integer.valueOf(soLuongDTBH));
//                            dts.doiTra(hdadd);
//                            dts.capNhatSoLuong(hdctadd, idCTSP);
//                        }
//                    }
//                }
//            }
//        }
    }//GEN-LAST:event_tblHDCTDoiTraMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDoiSanPham;
    private javax.swing.JButton btnLoc;
    private javax.swing.JComboBox<String> cbbLiDoDoi;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblMaHDDoiTra;
    private javax.swing.JLabel lblNgaDoiHangDT;
    private javax.swing.JLabel lblTenKHDoiTra;
    private javax.swing.JPanel pnlDoiTra;
    private javax.swing.JTable tblDoiTra;
    private javax.swing.JTable tblHDCTDoiTra;
    private javax.swing.JTable tblHoaDonDoiTra;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtTimKiemDoiTra;
    // End of variables declaration//GEN-END:variables
}
