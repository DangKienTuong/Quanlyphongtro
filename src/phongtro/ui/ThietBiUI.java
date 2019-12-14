/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phongtro.ui;

import java.awt.HeadlessException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import phongtro.dao.PhongDAO;
import phongtro.dao.ThietbiDAO;
import phongtro.helper.DialogHelper;
import phongtro.model.Thietbi;

/**
 *
 * @author Tường Ngao Tạng
 */
public class ThietBiUI extends javax.swing.JFrame {

    /**
     * Creates new form Thietbi
     */
    public ThietBiUI() {
        initComponents();
        init();
    }
    int index = 0;
    ThietbiDAO dao = new ThietbiDAO();

    void init() {
        setLocationRelativeTo(null);
    }

    void exit() {
        Main main = new Main();
        main.setVisible(true);
        setVisible(false);
    }

    void load() {
        DefaultTableModel model = (DefaultTableModel) tblThietBi.getModel();
        model.setRowCount(0);
        try {
            String keyword = txtTimKiem.getText();
            List<Thietbi> list = dao.selectByKeyword(keyword);
            for (Thietbi tb : list) {
                Object[] row = {
                    tb.getMaThietBi(),
                    tb.getMaPhong(),
                    tb.getTenThietBi(),
                    tb.getDonVi(),
                    tb.getGia(),
                    tb.getTrangThai(),
                    tb.getMoTa(),
                    tb.getSoLuong()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    void insert() {
        Thietbi model = getModel();
        try {
            dao.insert(model);
            this.load();
            this.clear();
            DialogHelper.alert(this, "Thêm mới thành công!");
        } catch (Exception e) {
            DialogHelper.alert(this, "Thêm mới thất bại!");
        }
    }

    void update() {
        Thietbi model = getModel();
        try {
            dao.update(model);
            this.load();
            DialogHelper.alert(this, "Cập nhật thành công!");
        } catch (Exception e) {
            DialogHelper.alert(this, "Cập nhật thất bại!");
        }
    }

    void delete() {
        if (DialogHelper.confirm(this, "Bạn thực sự muốn xóa người học này?")) {
            String user = txtMaThietBi.getText();
            try {
                dao.delete(user);
                this.load();
                this.clear();
                DialogHelper.alert(this, "Xóa thành công!");
            } catch (HeadlessException e) {
                DialogHelper.alert(this, "Xóa thất bại!");
            }
        }
    }

    void clear() {
        Thietbi model = new Thietbi();
        this.setModel(model);
        setStatus(true);
        txtSoLuong.setText("");
        txtGia.setText("");
        List<Thietbi> list = dao.selectByKeyword("");
        int ide = (Integer) list.size() + 1;
        txtMaThietBi.setText("Mtb0" + ide);
    }

    void edit() {
        try {
            String user = (String) tblThietBi.getValueAt(this.index, 0);
            Thietbi model = dao.findById(user);
            if (model != null) {
                this.setModel(model);
                this.setStatus(false);
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    void setModel(Thietbi model) {
        txtMaThietBi.setText(model.getMaThietBi());
        cboMaPhong.setSelectedItem(model.getMaPhong());
        txtTenThietBi.setText(model.getTenThietBi());
        txtDonVi.setText(model.getDonVi());
        txtGia.setText(model.getGia() + "");
        txtTrangThai.setText(model.getTrangThai());
        txtSoLuong.setText(model.getSoLuong() + "");
        txtMoTa.setText(model.getMoTa());
    }

    Thietbi getModel() {
        Thietbi model = new Thietbi();
        model.setMaThietBi(txtMaThietBi.getText());
        model.setMaPhong((String) cboMaPhong.getSelectedItem());
        model.setTenThietBi(txtTenThietBi.getText());
        model.setDonVi(txtDonVi.getText());
        model.setGia(Double.parseDouble(txtGia.getText()));
        model.setTrangThai(txtTrangThai.getText());
        model.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
        model.setMoTa(txtMoTa.getText());
        return model;
    }

    void setStatus(boolean insertable) {
        txtMaThietBi.setEditable(insertable);
        boolean first = this.index > 0;
        boolean last = this.index < tblThietBi.getRowCount() - 1;
        btnLongPre.setEnabled(!insertable && first);
        btnPre.setEnabled(!insertable && first);
        btnNext.setEnabled(!insertable && last);
        btnLongNext.setEnabled(!insertable && last);
    }

    void fillComboBox() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboMaPhong.getModel();
        model.removeAllElements();
        try {
            PhongDAO pdao = new PhongDAO();
            List<phongtro.model.Phong> list = pdao.select();
            for (phongtro.model.Phong cd : list) {
                model.addElement(cd.getMaPhong());
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtMaThietBi = new javax.swing.JTextField();
        txtTenThietBi = new javax.swing.JTextField();
        txtDonVi = new javax.swing.JTextField();
        txtGia = new javax.swing.JTextField();
        txtTrangThai = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThietBi = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        cboMaPhong = new javax.swing.JComboBox<>();
        txtTimKiem = new javax.swing.JTextField();
        btnAdd = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JLabel();
        btnDelete = new javax.swing.JLabel();
        btnClear = new javax.swing.JLabel();
        btnLongPre = new javax.swing.JLabel();
        btnPre = new javax.swing.JLabel();
        btnNext = new javax.swing.JLabel();
        btnLongNext = new javax.swing.JLabel();
        btnSearch = new javax.swing.JLabel();
        btnClose = new javax.swing.JLabel();
        btnExit = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1020, 717));
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        txtMaThietBi.setBackground(new java.awt.Color(196, 200, 203));
        txtMaThietBi.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtMaThietBi.setBorder(null);
        getContentPane().add(txtMaThietBi);
        txtMaThietBi.setBounds(220, 220, 290, 40);

        txtTenThietBi.setBackground(new java.awt.Color(196, 200, 203));
        txtTenThietBi.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtTenThietBi.setBorder(null);
        getContentPane().add(txtTenThietBi);
        txtTenThietBi.setBounds(220, 350, 290, 40);

        txtDonVi.setBackground(new java.awt.Color(196, 200, 203));
        txtDonVi.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtDonVi.setBorder(null);
        getContentPane().add(txtDonVi);
        txtDonVi.setBounds(220, 410, 290, 40);

        txtGia.setBackground(new java.awt.Color(196, 200, 203));
        txtGia.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtGia.setBorder(null);
        getContentPane().add(txtGia);
        txtGia.setBounds(660, 220, 290, 40);

        txtTrangThai.setBackground(new java.awt.Color(196, 200, 203));
        txtTrangThai.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtTrangThai.setBorder(null);
        getContentPane().add(txtTrangThai);
        txtTrangThai.setBounds(660, 350, 290, 40);

        txtSoLuong.setBackground(new java.awt.Color(196, 200, 203));
        txtSoLuong.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtSoLuong.setBorder(null);
        getContentPane().add(txtSoLuong);
        txtSoLuong.setBounds(660, 280, 290, 40);

        tblThietBi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Ma Thiet Bi", "Ma Phong", "Ten Thiet Bi", "Don Vi", "Gia", "Trang Thai", "Mo Ta", "So Luong"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblThietBi.setRowHeight(20);
        tblThietBi.setSelectionBackground(new java.awt.Color(30, 168, 155));
        tblThietBi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThietBiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblThietBi);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(220, 510, 730, 102);

        txtMoTa.setBackground(new java.awt.Color(196, 200, 203));
        txtMoTa.setColumns(20);
        txtMoTa.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtMoTa.setRows(5);
        txtMoTa.setBorder(null);
        jScrollPane2.setViewportView(txtMoTa);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(660, 410, 290, 80);

        cboMaPhong.setBackground(new java.awt.Color(196, 200, 203));
        cboMaPhong.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        cboMaPhong.setBorder(null);
        getContentPane().add(cboMaPhong);
        cboMaPhong.setBounds(220, 280, 290, 40);

        txtTimKiem.setBackground(new java.awt.Color(255, 255, 255));
        txtTimKiem.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtTimKiem.setBorder(null);
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });
        getContentPane().add(txtTimKiem);
        txtTimKiem.setBounds(700, 137, 220, 32);

        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });
        getContentPane().add(btnAdd);
        btnAdd.setBounds(30, 220, 120, 40);

        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateMouseClicked(evt);
            }
        });
        getContentPane().add(btnUpdate);
        btnUpdate.setBounds(30, 290, 120, 40);

        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });
        getContentPane().add(btnDelete);
        btnDelete.setBounds(40, 370, 110, 30);

        btnClear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClearMouseClicked(evt);
            }
        });
        getContentPane().add(btnClear);
        btnClear.setBounds(30, 440, 120, 40);

        btnLongPre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLongPre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLongPreMouseClicked(evt);
            }
        });
        getContentPane().add(btnLongPre);
        btnLongPre.setBounds(390, 660, 70, 30);

        btnPre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPreMouseClicked(evt);
            }
        });
        getContentPane().add(btnPre);
        btnPre.setBounds(490, 660, 70, 30);

        btnNext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNextMouseClicked(evt);
            }
        });
        getContentPane().add(btnNext);
        btnNext.setBounds(600, 660, 70, 30);

        btnLongNext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLongNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLongNextMouseClicked(evt);
            }
        });
        getContentPane().add(btnLongNext);
        btnLongNext.setBounds(700, 660, 60, 30);

        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });
        getContentPane().add(btnSearch);
        btnSearch.setBounds(930, 130, 60, 40);

        btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btnClose);
        btnClose.setBounds(990, 0, 20, 20);

        btnExit.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 0, 0));
        btnExit.setText("X");
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
        });
        getContentPane().add(btnExit);
        btnExit.setBounds(992, 0, 10, 19);

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/phongtro/image/quản lý trang thiết bị.jpg"))); // NOI18N
        getContentPane().add(Background);
        Background.setBounds(0, -3, 1020, 720);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        this.load();
        this.setStatus(true);
        fillComboBox();
    }//GEN-LAST:event_formWindowOpened

    private void tblThietBiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThietBiMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            this.index = tblThietBi.rowAtPoint(evt.getPoint());
            if (this.index >= 0) {
                this.edit();
            }
        }
    }//GEN-LAST:event_tblThietBiMouseClicked

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        // TODO add your handling code here:
        exit();
    }//GEN-LAST:event_btnExitMouseClicked

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        // TODO add your handling code here:
        insert();
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseClicked
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_btnUpdateMouseClicked

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void btnClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearMouseClicked
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_btnClearMouseClicked

    private void btnLongPreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLongPreMouseClicked
        // TODO add your handling code here:
        this.index = 0;
        this.edit();
    }//GEN-LAST:event_btnLongPreMouseClicked

    private void btnPreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPreMouseClicked
        // TODO add your handling code here:
        this.index--;
        this.edit();
    }//GEN-LAST:event_btnPreMouseClicked

    private void btnNextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextMouseClicked
        // TODO add your handling code here:
        this.index++;
        this.edit();
    }//GEN-LAST:event_btnNextMouseClicked

    private void btnLongNextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLongNextMouseClicked
        // TODO add your handling code here:
        this.index = tblThietBi.getRowCount() - 1;
        this.edit();
    }//GEN-LAST:event_btnLongNextMouseClicked

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        // TODO add your handling code here:
        this.load();
        this.clear();
    }//GEN-LAST:event_btnSearchMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ThietBiUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThietBiUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThietBiUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThietBiUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThietBiUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JLabel btnAdd;
    private javax.swing.JLabel btnClear;
    private javax.swing.JLabel btnClose;
    private javax.swing.JLabel btnDelete;
    private javax.swing.JLabel btnExit;
    private javax.swing.JLabel btnLongNext;
    private javax.swing.JLabel btnLongPre;
    private javax.swing.JLabel btnNext;
    private javax.swing.JLabel btnPre;
    private javax.swing.JLabel btnSearch;
    private javax.swing.JLabel btnUpdate;
    private javax.swing.JComboBox<String> cboMaPhong;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblThietBi;
    private javax.swing.JTextField txtDonVi;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMaThietBi;
    private javax.swing.JTextArea txtMoTa;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenThietBi;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTrangThai;
    // End of variables declaration//GEN-END:variables
}
