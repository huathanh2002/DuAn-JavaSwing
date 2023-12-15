/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MauSac;
import reponsitory.MauSacRepository;
import service.MauSacService;

/**
 *
 * @author natsu
 */
public class viewMauSac extends javax.swing.JFrame {

    private final MauSacService mauSacService = new MauSacService();
    private int index = -1;

    /**
     * Creates new form viewMauSac
     */
    public viewMauSac() {
        initComponents();
        setLocationRelativeTo(null);
        loadTableMauSac();
    }

    public void resetInputMS() {
        txtMaMau.setText(null);
        txtTenMau.setText(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel15 = new javax.swing.JLabel();
        txtMaMau = new javax.swing.JTextField();
        txtTenMau = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        bttThemMau4 = new javax.swing.JButton();
        bttSuaMau = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblMauSac = new javax.swing.JTable();
        txtTimkiemMausac = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel15.setText("Màu sắc sản phẩm");

        jLabel16.setText("Mã màu:");

        jLabel17.setText("Tên tên màu:");

        bttThemMau4.setBackground(new java.awt.Color(0, 255, 0));
        bttThemMau4.setText("Thêm");
        bttThemMau4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttThemMau4ActionPerformed(evt);
            }
        });

        bttSuaMau.setBackground(new java.awt.Color(255, 255, 0));
        bttSuaMau.setText("Sửa");
        bttSuaMau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttSuaMauActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTimkiemMausac, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(165, 165, 165)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtTenMau, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtMaMau, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(bttThemMau4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(bttSuaMau, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaMau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenMau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bttThemMau4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttSuaMau, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimkiemMausac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addGap(14, 14, 14)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bttThemMau4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttThemMau4ActionPerformed
        // TODO add your handling code here:
        if (checkMauSac()) {
            MauSacRepository mr = new MauSacRepository();
            if (mr.getMaMau(txtMaMau.getText()) != null) {
                JOptionPane.showMessageDialog(this, "Mã màu đã tồn tại");
            } else {
                MauSac ms = getInputMauSac();
                if (mauSacService.addSP(ms) != null) {
                    JOptionPane.showMessageDialog(this, "OK");
                } else {
                    JOptionPane.showMessageDialog(this, "Fails");
                }
                loadTableMauSac();
            }
        }
    }//GEN-LAST:event_bttThemMau4ActionPerformed

    private void bttSuaMauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttSuaMauActionPerformed
        // TODO add your handling code here:
        if (checkMauSac()) {
            index = tblMauSac.getSelectedRow();
            MauSac ms = getInputMauSac();
            if (mauSacService.updateSP(ms, mauSacService.getAll().get(index).getId()) > 0) {
                JOptionPane.showMessageDialog(this, "OK");
            } else {
                JOptionPane.showMessageDialog(this, "Fails");
            }
            loadTableMauSac();
            resetInputMS();
        }
    }//GEN-LAST:event_bttSuaMauActionPerformed

    private void tblMauSacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMauSacMouseClicked
        // TODO add your handling code here:
        showDetailsMauSac();
    }//GEN-LAST:event_tblMauSacMouseClicked

    private void txtTimkiemMausacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimkiemMausacActionPerformed

    }//GEN-LAST:event_txtTimkiemMausacActionPerformed

    private void txtTimkiemMausacKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimkiemMausacKeyReleased
        String searchName = txtTimkiemMausac.getText();
        this.fillTableMauSac(mauSacService.searchName(searchName));
    }//GEN-LAST:event_txtTimkiemMausacKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttSuaMau;
    private javax.swing.JButton bttThemMau4;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable tblMauSac;
    private javax.swing.JTextField txtMaMau;
    private javax.swing.JTextField txtTenMau;
    private javax.swing.JTextField txtTimkiemMausac;
    // End of variables declaration//GEN-END:variables
        boolean checkMauSac() {
        if (txtMaMau.getText().isEmpty() || txtTenMau.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống dữ liệu");
            return false;
        }
        return true;
    }

    private void fillTableMauSac(List<MauSac> searchName) {
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        defaultTableModel = (DefaultTableModel) tblMauSac.getModel();
        defaultTableModel.setRowCount(0);
        for (MauSac mauSac : searchName) {
            defaultTableModel.addRow(new Object[]{mauSac.getMaMauSac(), mauSac.getTenMauSac()});
        }

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

}
