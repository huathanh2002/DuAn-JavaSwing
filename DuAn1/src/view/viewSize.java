/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Size;
import reponsitory.SizeRepository;
import service.SizeService;

/**
 *
 * @author natsu
 */
public class viewSize extends javax.swing.JFrame {

    private final SizeService sizeService = new SizeService();
    private int index = -1;

    /**
     * Creates new form viewSize
     */
    public viewSize() {
        initComponents();
        setLocationRelativeTo(null);
        loadTableSize();
    }

    public void resetInputS() {
        txtMaSize.setText(null);
        txtTenSize.setText(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        txtMaSize = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtTenSize = new javax.swing.JTextField();
        bttThemSizze = new javax.swing.JButton();
        bttSuaSize = new javax.swing.JButton();
        txtTimKiemSize = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSize = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(500, 435));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel9.setText("Size sản phẩm");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTimKiemSize, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtMaSize, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtTenSize, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(bttThemSizze, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bttSuaSize, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bttThemSizze, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttSuaSize, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiemSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bttThemSizzeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttThemSizzeActionPerformed
        // TODO add your handling code here:
        Size s = getInputSize();
        String ma = txtMaSize.getText();
        if (validateSize()) {
            if (sizeService.getMaSize(ma) == null) {
                if (sizeService.addSP(s) != null) {
                    JOptionPane.showMessageDialog(this, "OK");
                    loadTableSize();
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
        Size s = getInputSize();
        String ma = txtMaSize.getText();
        if (validateSize()) {
            if (sizeService.updateSP(s, sizeService.getAll().get(index).getId()) > 0) {
                JOptionPane.showMessageDialog(this, "OK");
                loadTableSize();
                resetInputS();
            } else {
                JOptionPane.showMessageDialog(this, "Fails");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Mã size đã tồn tại");
        }
    }//GEN-LAST:event_bttSuaSizeActionPerformed

    private void txtTimKiemSizeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemSizeKeyReleased
        // TODO add your handling code here:
        SizeRepository sr = new SizeRepository();
        String m = "%" + txtTimKiemSize.getText() + "%";
        fillTableSize(sr.getSize(m));
    }//GEN-LAST:event_txtTimKiemSizeKeyReleased

    private void tblSizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSizeMouseClicked
        // TODO add your handling code here:
        showDetailsSize();
    }//GEN-LAST:event_tblSizeMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttSuaSize;
    private javax.swing.JButton bttThemSizze;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblSize;
    private javax.swing.JTextField txtMaSize;
    private javax.swing.JTextField txtTenSize;
    private javax.swing.JTextField txtTimKiemSize;
    // End of variables declaration//GEN-END:variables
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

    boolean validateSize() {
        if (txtMaSize.getText().isBlank() || txtTenSize.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Không được để trống dữ liệu");
            return false;
        }
        return true;
    }

    public void fillTableSize(List<Size> lS) {
        DefaultTableModel model = (DefaultTableModel) tblSize.getModel();
        model.setRowCount(0);
        for (Size size : lS) {
            model.addRow(size.toDataRow());
        }
    }
}
