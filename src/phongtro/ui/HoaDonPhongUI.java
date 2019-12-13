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
import phongtro.dao.HoadonphongDAO;
import phongtro.dao.PhongDAO;
import phongtro.helper.DialogHelper;
import phongtro.model.Hoadonphong;
import phongtro.model.Phong;

/**
 *
 * @author Tường Ngao Tạng
 */
public class HoaDonPhongUI extends javax.swing.JFrame {

    /**
     * Creates new form HoaDonPhong
     */
    public HoaDonPhongUI() {
        initComponents();
        init();
    }
    int index = 0;
    HoadonphongDAO dao = new HoadonphongDAO();

    void init() {
        setLocationRelativeTo(null);
    }

    void exit() {
        Main main = new Main();
        main.setVisible(true);
        setVisible(false);
    }

    void load() {
        DefaultTableModel model = (DefaultTableModel) tblHoaDonPhong.getModel();
        model.setRowCount(0);
        try {
            String keyword = txtTimKiem.getText();
            List<Hoadonphong> list = dao.selectByKeyword(keyword);
            for (Hoadonphong hdp : list) {
                Object[] row = {
                    hdp.getMaHoadon(),
                    hdp.getThangNam(),
                    hdp.getMaPhong(),
                    hdp.getNguoiDaiDien(),
                    hdp.getNgayThanhToan(),
                    hdp.getTinhTrang(),
                    hdp.getThanhTien()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    void insert() {
        Hoadonphong model = getModel();
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
        setStatus(false);
        Hoadonphong model = getModel();
        try {
            dao.update(model);
            this.load();
            DialogHelper.alert(this, "Cập nhật thành công!");
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Cập nhật thất bại!");
        }
    }

    void delete() {
        if (DialogHelper.confirm(this, "Bạn thực sự muốn xóa?")) {
            String user = txtMaHd.getText();
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
        txtMaHd.setText("");
        txtThangNam.setDate(null);
        txtNguoiDaiDien.setText("");
        cboMaPhong.setSelectedIndex(0);
        txtNgayThanhToan.setDate(null);
        txtTinhTrang.setText("");
        txtThanhTien.setText("");
        setStatus(true);
    }

    void edit() {
        try {
            String user = (String) tblHoaDonPhong.getValueAt(this.index, 0);
            Hoadonphong model = dao.findById(user);
            if (model != null) {
                this.setModel(model);
                this.setStatus(false);
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    void setModel(Hoadonphong model) {
        txtMaHd.setText(model.getMaHoadon());
        txtThangNam.setDate(model.getThangNam());
        cboMaPhong.setSelectedItem(model.getMaPhong());
        txtNguoiDaiDien.setText(model.getNguoiDaiDien());
        txtNgayThanhToan.setDate(model.getNgayThanhToan());
        txtTinhTrang.setText(model.getTinhTrang());
        txtThanhTien.setText(model.getThanhTien() + "");
    }

    Hoadonphong getModel() {
        Hoadonphong model = new Hoadonphong();
        model.setMaHoadon(txtMaHd.getText());
        model.setThangNam(txtThangNam.getDate());
        model.setMaPhong((String) cboMaPhong.getSelectedItem());
        model.setNguoiDaiDien(txtNguoiDaiDien.getText());
        model.setNgayThanhToan(txtNgayThanhToan.getDate());
        model.setTinhTrang(txtTinhTrang.getText());
        return model;
    }

    void setStatus(boolean insertable) {
        txtMaHd.setEditable(insertable);
        boolean first = this.index > 0;
        boolean last = this.index < tblHoaDonPhong.getRowCount() - 1;
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
            List<Phong> list = pdao.select();
            for (Phong cd : list) {
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtMaHd = new javax.swing.JTextField();
        txtThangNam = new com.toedter.calendar.JDateChooser();
        txtNguoiDaiDien = new javax.swing.JTextField();
        txtNgayThanhToan = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtTinhTrang = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblHoaDonPhong = new javax.swing.JTable();
        txtThanhTien = new javax.swing.JTextField();
        cboMaPhong = new javax.swing.JComboBox<>();
        txtTimKiem = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JLabel();
        btnDelete = new javax.swing.JLabel();
        btnClear = new javax.swing.JLabel();
        btnLongPre = new javax.swing.JLabel();
        btnPre = new javax.swing.JLabel();
        btnNext = new javax.swing.JLabel();
        btnLongNext = new javax.swing.JLabel();
        btnSearch = new javax.swing.JLabel();
        btnClose = new javax.swing.JLabel();
        btnAdd = new javax.swing.JLabel();
        btnExit = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);

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

        txtMaHd.setBackground(new java.awt.Color(196, 200, 203));
        txtMaHd.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtMaHd.setBorder(null);
        getContentPane().add(txtMaHd);
        txtMaHd.setBounds(240, 200, 290, 40);

        txtThangNam.setBackground(new java.awt.Color(196, 200, 203));
        txtThangNam.setDateFormatString("dd/MM/yyyy");
        getContentPane().add(txtThangNam);
        txtThangNam.setBounds(240, 270, 290, 30);

        txtNguoiDaiDien.setBackground(new java.awt.Color(196, 200, 203));
        txtNguoiDaiDien.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtNguoiDaiDien.setBorder(null);
        getContentPane().add(txtNguoiDaiDien);
        txtNguoiDaiDien.setBounds(240, 400, 290, 30);

        txtNgayThanhToan.setBackground(new java.awt.Color(196, 200, 203));
        txtNgayThanhToan.setDateFormatString("dd/MM/yyyy");
        getContentPane().add(txtNgayThanhToan);
        txtNgayThanhToan.setBounds(680, 270, 290, 60);

        txtTinhTrang.setBackground(new java.awt.Color(196, 200, 203));
        txtTinhTrang.setColumns(20);
        txtTinhTrang.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtTinhTrang.setRows(5);
        txtTinhTrang.setBorder(null);
        jScrollPane1.setViewportView(txtTinhTrang);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(680, 370, 290, 60);

        tblHoaDonPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Ma Hoa Don", "Thang Nam", "Ma Phong", "Nguoi Dai Dien", "Ngay Thanh Toan", "Tinh Trang", "Thanh Tien"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDonPhong.setRowHeight(20);
        tblHoaDonPhong.setSelectionBackground(new java.awt.Color(30, 168, 155));
        tblHoaDonPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonPhongMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblHoaDonPhong);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(240, 450, 719, 190);

        txtThanhTien.setEditable(false);
        txtThanhTien.setBackground(new java.awt.Color(196, 200, 203));
        txtThanhTien.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtThanhTien.setBorder(null);
        getContentPane().add(txtThanhTien);
        txtThanhTien.setBounds(680, 200, 290, 40);

        cboMaPhong.setBackground(new java.awt.Color(196, 200, 203));
        cboMaPhong.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        getContentPane().add(cboMaPhong);
        cboMaPhong.setBounds(240, 330, 290, 40);

        txtTimKiem.setBackground(new java.awt.Color(255, 255, 255));
        txtTimKiem.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtTimKiem.setBorder(null);
        getContentPane().add(txtTimKiem);
        txtTimKiem.setBounds(690, 120, 220, 19);

        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateMouseClicked(evt);
            }
        });
        getContentPane().add(btnUpdate);
        btnUpdate.setBounds(40, 280, 120, 40);

        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });
        getContentPane().add(btnDelete);
        btnDelete.setBounds(50, 350, 110, 30);

        btnClear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClearMouseClicked(evt);
            }
        });
        getContentPane().add(btnClear);
        btnClear.setBounds(40, 420, 120, 40);

        btnLongPre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLongPre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLongPreMouseClicked(evt);
            }
        });
        getContentPane().add(btnLongPre);
        btnLongPre.setBounds(440, 670, 70, 30);

        btnPre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPreMouseClicked(evt);
            }
        });
        getContentPane().add(btnPre);
        btnPre.setBounds(530, 670, 70, 30);

        btnNext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNextMouseClicked(evt);
            }
        });
        getContentPane().add(btnNext);
        btnNext.setBounds(640, 670, 70, 30);

        btnLongNext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLongNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLongNextMouseClicked(evt);
            }
        });
        getContentPane().add(btnLongNext);
        btnLongNext.setBounds(740, 670, 60, 30);

        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });
        getContentPane().add(btnSearch);
        btnSearch.setBounds(920, 110, 60, 40);

        btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btnClose);
        btnClose.setBounds(990, 10, 20, 20);

        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });
        getContentPane().add(btnAdd);
        btnAdd.setBounds(40, 200, 120, 40);

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
        btnExit.setBounds(995, 12, 10, 19);

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/phongtro/image/quản lý hóa đơn phòng.jpg"))); // NOI18N
        getContentPane().add(Background);
        Background.setBounds(0, 0, 1020, 720);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        this.load();
        this.setStatus(true);
        fillComboBox();
    }//GEN-LAST:event_formWindowOpened

    private void tblHoaDonPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonPhongMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            this.index = tblHoaDonPhong.rowAtPoint(evt.getPoint());
            if (this.index >= 0) {
                this.edit();
            }
        }
    }//GEN-LAST:event_tblHoaDonPhongMouseClicked

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
        this.index = tblHoaDonPhong.getRowCount() - 1;
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
            java.util.logging.Logger.getLogger(HoaDonPhongUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HoaDonPhongUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HoaDonPhongUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HoaDonPhongUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HoaDonPhongUI().setVisible(true);
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblHoaDonPhong;
    private javax.swing.JTextField txtMaHd;
    private com.toedter.calendar.JDateChooser txtNgayThanhToan;
    private javax.swing.JTextField txtNguoiDaiDien;
    private com.toedter.calendar.JDateChooser txtThangNam;
    private javax.swing.JTextField txtThanhTien;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextArea txtTinhTrang;
    // End of variables declaration//GEN-END:variables
}
