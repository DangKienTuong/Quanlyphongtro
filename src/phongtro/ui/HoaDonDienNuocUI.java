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
import phongtro.dao.HoadondiennuocDAO;
import phongtro.dao.PhongDAO;
import phongtro.helper.DialogHelper;
import phongtro.model.Hoadondiennuoc;

/**
 *
 * @author Tường Ngao Tạng
 */
public class HoaDonDienNuocUI extends javax.swing.JFrame {

    /**
     * Creates new form HoaDonDienNuoc
     */
    public HoaDonDienNuocUI() {
        initComponents();
        init();

    }
    int index = 0;
    HoadondiennuocDAO dao = new HoadondiennuocDAO();

    void init() {
        setLocationRelativeTo(null);
    }

    void exit() {
        Main main = new Main();
        main.setVisible(true);
        setVisible(false);
    }

    void load() {
        DefaultTableModel model = (DefaultTableModel) tblHoaDonDienNuoc.getModel();
        model.setRowCount(0);
        try {
            String keyword = txtTimKiem.getText();
            List<Hoadondiennuoc> list = dao.selectByKeyword(keyword);
            for (Hoadondiennuoc hddn : list) {
                Object[] row = {
                    hddn.getMaHoaDon(),
                    hddn.getMaPhong(),
                    hddn.getNgayLap(),
                    hddn.getChiSoDau(),
                    hddn.getChiSoCuoi(),
                    hddn.getTieuThu(),
                    hddn.getThanhTien()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    void insert() {
        Hoadondiennuoc model = getModel();
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
        Hoadondiennuoc model = getModel();
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
            String user = txtMaHoaDon.getText();
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
        txtMaHoaDon.setText("");
        cboMaPhong.setSelectedIndex(0);
        txtNgayLap.setDate(null);
        txtChiSoDau.setText("");
        txtChiSoCuoi.setText("");
        txtTieuThu.setText("");
        txtThanhTien.setText("");
        setStatus(true);
    }

    void edit() {
        try {
            String user = (String) tblHoaDonDienNuoc.getValueAt(this.index, 0);
            Hoadondiennuoc model = dao.findById(user);
            if (model != null) {
                this.setModel(model);
                this.setStatus(false);
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Số nhập vào không hợp lệ");
        }
    }

    void setModel(Hoadondiennuoc model) {
        txtMaHoaDon.setText(model.getMaHoaDon());
        cboMaPhong.setSelectedItem(model.getMaPhong());
        txtNgayLap.setDate(model.getNgayLap());
        txtChiSoDau.setText(model.getChiSoDau() + "");
        txtChiSoCuoi.setText(model.getChiSoCuoi() + "");
        txtTieuThu.setText(model.getTieuThu() + "");
        txtThanhTien.setText(model.getThanhTien() + "");
    }

    Hoadondiennuoc getModel() {
        Hoadondiennuoc model = new Hoadondiennuoc();
        model.setMaHoaDon(txtMaHoaDon.getText());
        model.setMaPhong((String) cboMaPhong.getSelectedItem());
        model.setNgayLap(txtNgayLap.getDate());
        model.setChiSoDau(Integer.parseInt(txtChiSoDau.getText()));
        model.setChiSoCuoi(Integer.parseInt(txtChiSoCuoi.getText()));
        return model;
    }

    void setStatus(boolean insertable) {
        txtMaHoaDon.setEditable(insertable);
        boolean first = this.index > 0;
        boolean last = this.index < tblHoaDonDienNuoc.getRowCount() - 1;
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

        txtMaHoaDon = new javax.swing.JTextField();
        txtNgayLap = new com.toedter.calendar.JDateChooser();
        txtChiSoDau = new javax.swing.JTextField();
        txtChiSoCuoi = new javax.swing.JTextField();
        txtTieuThu = new javax.swing.JTextField();
        txtThanhTien = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDonDienNuoc = new javax.swing.JTable();
        cboMaPhong = new javax.swing.JComboBox<>();
        txtTimKiem = new javax.swing.JTextField();
        btnClose = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JLabel();
        btnDelete = new javax.swing.JLabel();
        btnClear = new javax.swing.JLabel();
        btnLongPre = new javax.swing.JLabel();
        btnPre = new javax.swing.JLabel();
        btnNext = new javax.swing.JLabel();
        btnLongNext = new javax.swing.JLabel();
        btnSearch = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JLabel();
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

        txtMaHoaDon.setBackground(new java.awt.Color(196, 200, 203));
        txtMaHoaDon.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtMaHoaDon.setBorder(null);
        getContentPane().add(txtMaHoaDon);
        txtMaHoaDon.setBounds(230, 200, 300, 40);

        txtNgayLap.setBackground(new java.awt.Color(196, 200, 203));
        txtNgayLap.setDateFormatString("dd/MM/yyyy");
        getContentPane().add(txtNgayLap);
        txtNgayLap.setBounds(230, 339, 300, 30);

        txtChiSoDau.setBackground(new java.awt.Color(196, 200, 203));
        txtChiSoDau.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtChiSoDau.setBorder(null);
        getContentPane().add(txtChiSoDau);
        txtChiSoDau.setBounds(230, 400, 290, 30);

        txtChiSoCuoi.setBackground(new java.awt.Color(196, 200, 203));
        txtChiSoCuoi.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtChiSoCuoi.setBorder(null);
        getContentPane().add(txtChiSoCuoi);
        txtChiSoCuoi.setBounds(670, 200, 300, 50);

        txtTieuThu.setEditable(false);
        txtTieuThu.setBackground(new java.awt.Color(196, 200, 203));
        txtTieuThu.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtTieuThu.setBorder(null);
        getContentPane().add(txtTieuThu);
        txtTieuThu.setBounds(670, 270, 300, 60);

        txtThanhTien.setEditable(false);
        txtThanhTien.setBackground(new java.awt.Color(196, 200, 203));
        txtThanhTien.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtThanhTien.setBorder(null);
        getContentPane().add(txtThanhTien);
        txtThanhTien.setBounds(670, 380, 300, 50);

        tblHoaDonDienNuoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Ma Hoa Don", "Ma Phong", "Ngay Lap", "Chi So Dau", "Chi So Cuoi", "Tieu Thu", "Thanh Tien"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDonDienNuoc.setRowHeight(20);
        tblHoaDonDienNuoc.setSelectionBackground(new java.awt.Color(30, 168, 155));
        tblHoaDonDienNuoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonDienNuocMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDonDienNuoc);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(240, 460, 740, 170);

        cboMaPhong.setBackground(new java.awt.Color(196, 200, 203));
        cboMaPhong.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        cboMaPhong.setBorder(null);
        getContentPane().add(cboMaPhong);
        cboMaPhong.setBounds(230, 270, 290, 30);

        txtTimKiem.setBackground(new java.awt.Color(255, 255, 255));
        txtTimKiem.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtTimKiem.setBorder(null);
        getContentPane().add(txtTimKiem);
        txtTimKiem.setBounds(720, 125, 210, 22);

        btnClose.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnClose.setForeground(new java.awt.Color(255, 0, 0));
        btnClose.setText("X");
        btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
        });
        getContentPane().add(btnClose);
        btnClose.setBounds(995, 16, 9, 10);

        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateMouseClicked(evt);
            }
        });
        getContentPane().add(btnUpdate);
        btnUpdate.setBounds(40, 300, 110, 30);

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
        btnClear.setBounds(40, 450, 110, 30);

        btnLongPre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLongPre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLongPreMouseClicked(evt);
            }
        });
        getContentPane().add(btnLongPre);
        btnLongPre.setBounds(400, 670, 60, 20);

        btnPre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPreMouseClicked(evt);
            }
        });
        getContentPane().add(btnPre);
        btnPre.setBounds(500, 660, 60, 30);

        btnNext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNextMouseClicked(evt);
            }
        });
        getContentPane().add(btnNext);
        btnNext.setBounds(590, 660, 70, 30);

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
        btnSearch.setBounds(940, 120, 60, 30);

        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jLabel9);
        jLabel9.setBounds(990, 10, 20, 20);

        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });
        getContentPane().add(btnAdd);
        btnAdd.setBounds(40, 230, 110, 30);

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/phongtro/image/hóa đơn điện nước.jpg"))); // NOI18N
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

    private void tblHoaDonDienNuocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonDienNuocMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            this.index = tblHoaDonDienNuoc.rowAtPoint(evt.getPoint());
            if (this.index >= 0) {
                this.edit();
            }
        }
    }//GEN-LAST:event_tblHoaDonDienNuocMouseClicked

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        // TODO add your handling code here:
        exit();
    }//GEN-LAST:event_btnCloseMouseClicked

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
        this.index = tblHoaDonDienNuoc.getRowCount() - 1;
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
            java.util.logging.Logger.getLogger(HoaDonDienNuocUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HoaDonDienNuocUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HoaDonDienNuocUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HoaDonDienNuocUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HoaDonDienNuocUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JLabel btnAdd;
    private javax.swing.JLabel btnClear;
    private javax.swing.JLabel btnClose;
    private javax.swing.JLabel btnDelete;
    private javax.swing.JLabel btnLongNext;
    private javax.swing.JLabel btnLongPre;
    private javax.swing.JLabel btnNext;
    private javax.swing.JLabel btnPre;
    private javax.swing.JLabel btnSearch;
    private javax.swing.JLabel btnUpdate;
    private javax.swing.JComboBox<String> cboMaPhong;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblHoaDonDienNuoc;
    private javax.swing.JTextField txtChiSoCuoi;
    private javax.swing.JTextField txtChiSoDau;
    private javax.swing.JTextField txtMaHoaDon;
    private com.toedter.calendar.JDateChooser txtNgayLap;
    private javax.swing.JTextField txtThanhTien;
    private javax.swing.JTextField txtTieuThu;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
