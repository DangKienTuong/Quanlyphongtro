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
import phongtro.dao.HopdongDAO;
import phongtro.dao.PhongDAO;
import phongtro.helper.DialogHelper;
import phongtro.model.Hopdong;
import phongtro.model.Phong;

/**
 *
 * @author Tường Ngao Tạng
 */
public class HopDongUI extends javax.swing.JFrame {

    /**
     * Creates new form HopDong
     */
    public HopDongUI() {
        initComponents();
        init();
    }
    int index = 0;
    HopdongDAO dao = new HopdongDAO();

    void init() {
        setLocationRelativeTo(null);
    }

    void exit() {
        Main main = new Main();
        main.setVisible(true);
        setVisible(false);
    }

    void load() {
        DefaultTableModel model = (DefaultTableModel) tblHopDong.getModel();
        model.setRowCount(0);
        try {
            String keyword = txtTimKiem.getText();
            List<Hopdong> list = dao.selectByKeyword(keyword);
            for (Hopdong hdg : list) {
                Object[] row = {
                    hdg.getMaHopDong(),
                    hdg.getMaPhong(),
                    hdg.getNguoiDaiDien(),
                    hdg.getSdt(),
                    hdg.getTienDatCoc(),
                    hdg.getNgayDatCoc(),
                    hdg.getNgayHetHan()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    void insert() {
        Hopdong model = getModel();
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
        Hopdong model = getModel();
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
            String user = txtMaHopDong.getText();
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
        Hopdong model = new Hopdong();
        this.setModel(model);
        setStatus(true);
        txtTienDatCoc.setText("");
        List<Hopdong> list = dao.selectByKeyword("");
        int ide = (Integer) list.size() + 1;
        txtMaHopDong.setText("hopdong" + ide);
    }

    void edit() {
        try {
            String user = (String) tblHopDong.getValueAt(this.index, 0);
            Hopdong model = dao.findById(user);
            if (model != null) {
                this.setModel(model);
                this.setStatus(false);
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    void setModel(Hopdong model) {
        txtMaHopDong.setText(model.getMaHopDong());
        cboMaPhong.setSelectedItem(model.getMaPhong());
        txtNguoiDaiDien.setText(model.getNguoiDaiDien());
        txtSdt.setText(model.getSdt());
        txtTienDatCoc.setText(model.getTienDatCoc() + "");
        txtNgayDatCoc.setDate(model.getNgayDatCoc());
        txtNgayHetHan.setDate(model.getNgayHetHan());
    }

    Hopdong getModel() {
        Hopdong model = new Hopdong();
        model.setMaHopDong(txtMaHopDong.getText());
        model.setMaPhong((String) cboMaPhong.getSelectedItem());
        model.setNguoiDaiDien(txtNguoiDaiDien.getText());
        model.setSdt(txtSdt.getText());
        model.setTienDatCoc(Double.parseDouble(txtTienDatCoc.getText()));
        model.setNgayDatCoc(txtNgayDatCoc.getDate());
        model.setNgayHetHan(txtNgayHetHan.getDate());
        return model;
    }

    void setStatus(boolean insertable) {
        txtMaHopDong.setEditable(insertable);
        boolean first = this.index > 0;
        boolean last = this.index < tblHopDong.getRowCount() - 1;
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

        txtMaHopDong = new javax.swing.JTextField();
        txtNguoiDaiDien = new javax.swing.JTextField();
        txtSdt = new javax.swing.JTextField();
        txtTienDatCoc = new javax.swing.JTextField();
        txtNgayDatCoc = new com.toedter.calendar.JDateChooser();
        txtNgayHetHan = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHopDong = new javax.swing.JTable();
        cboMaPhong = new javax.swing.JComboBox<>();
        txtTimKiem = new javax.swing.JTextField();
        btnAdd = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JLabel();
        btnDelete = new javax.swing.JLabel();
        btnClear = new javax.swing.JLabel();
        btnLongPre = new javax.swing.JLabel();
        btnPre = new javax.swing.JLabel();
        btnClose = new javax.swing.JLabel();
        btnSearch = new javax.swing.JLabel();
        btnLongNext = new javax.swing.JLabel();
        btnNext = new javax.swing.JLabel();
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

        txtMaHopDong.setBackground(new java.awt.Color(196, 200, 203));
        txtMaHopDong.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtMaHopDong.setBorder(null);
        getContentPane().add(txtMaHopDong);
        txtMaHopDong.setBounds(200, 200, 360, 40);

        txtNguoiDaiDien.setBackground(new java.awt.Color(196, 200, 203));
        txtNguoiDaiDien.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtNguoiDaiDien.setBorder(null);
        getContentPane().add(txtNguoiDaiDien);
        txtNguoiDaiDien.setBounds(200, 330, 360, 40);

        txtSdt.setBackground(new java.awt.Color(196, 200, 203));
        txtSdt.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtSdt.setBorder(null);
        getContentPane().add(txtSdt);
        txtSdt.setBounds(200, 400, 360, 40);

        txtTienDatCoc.setBackground(new java.awt.Color(196, 200, 203));
        txtTienDatCoc.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtTienDatCoc.setBorder(null);
        getContentPane().add(txtTienDatCoc);
        txtTienDatCoc.setBounds(600, 200, 360, 40);

        txtNgayDatCoc.setBackground(new java.awt.Color(196, 200, 203));
        txtNgayDatCoc.setDateFormatString("dd/MM/yyyy");
        getContentPane().add(txtNgayDatCoc);
        txtNgayDatCoc.setBounds(600, 300, 360, 40);

        txtNgayHetHan.setBackground(new java.awt.Color(196, 200, 203));
        txtNgayHetHan.setDateFormatString("dd/MM/yyyy");
        getContentPane().add(txtNgayHetHan);
        txtNgayHetHan.setBounds(600, 400, 360, 40);

        tblHopDong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Ma Hop Dong", "Ma Phong", "Nguoi Dai Dien", "So Dien Thoai", "Tien Dat Coc", "Ngay Dat Coc", "Ngay Het Han"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHopDong.setRowHeight(20);
        tblHopDong.setSelectionBackground(new java.awt.Color(30, 168, 155));
        tblHopDong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHopDongMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHopDong);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(200, 460, 770, 170);

        cboMaPhong.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cboMaPhong.setForeground(new java.awt.Color(196, 200, 203));
        getContentPane().add(cboMaPhong);
        cboMaPhong.setBounds(200, 260, 360, 40);

        txtTimKiem.setBackground(new java.awt.Color(255, 255, 255));
        txtTimKiem.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtTimKiem.setBorder(null);
        getContentPane().add(txtTimKiem);
        txtTimKiem.setBounds(690, 120, 220, 24);

        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });
        getContentPane().add(btnAdd);
        btnAdd.setBounds(20, 210, 120, 40);

        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateMouseClicked(evt);
            }
        });
        getContentPane().add(btnUpdate);
        btnUpdate.setBounds(20, 290, 120, 30);

        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });
        getContentPane().add(btnDelete);
        btnDelete.setBounds(20, 360, 120, 40);

        btnClear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClearMouseClicked(evt);
            }
        });
        getContentPane().add(btnClear);
        btnClear.setBounds(20, 430, 130, 40);

        btnLongPre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLongPre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLongPreMouseClicked(evt);
            }
        });
        getContentPane().add(btnLongPre);
        btnLongPre.setBounds(430, 670, 70, 30);

        btnPre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPreMouseClicked(evt);
            }
        });
        getContentPane().add(btnPre);
        btnPre.setBounds(530, 670, 70, 30);

        btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btnClose);
        btnClose.setBounds(990, 10, 20, 20);

        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });
        getContentPane().add(btnSearch);
        btnSearch.setBounds(920, 110, 60, 40);

        btnLongNext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLongNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLongNextMouseClicked(evt);
            }
        });
        getContentPane().add(btnLongNext);
        btnLongNext.setBounds(730, 670, 60, 30);

        btnNext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNextMouseClicked(evt);
            }
        });
        getContentPane().add(btnNext);
        btnNext.setBounds(630, 670, 70, 30);

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
        btnExit.setBounds(994, 12, 10, 19);

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/phongtro/image/quản lý hợp đồng.jpg"))); // NOI18N
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

    private void tblHopDongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHopDongMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            this.index = tblHopDong.rowAtPoint(evt.getPoint());
            if (this.index >= 0) {
                this.edit();
            }
        }
    }//GEN-LAST:event_tblHopDongMouseClicked

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
        this.index = tblHopDong.getRowCount() - 1;
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
            java.util.logging.Logger.getLogger(HopDongUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HopDongUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HopDongUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HopDongUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HopDongUI().setVisible(true);
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
    private javax.swing.JTable tblHopDong;
    private javax.swing.JTextField txtMaHopDong;
    private com.toedter.calendar.JDateChooser txtNgayDatCoc;
    private com.toedter.calendar.JDateChooser txtNgayHetHan;
    private javax.swing.JTextField txtNguoiDaiDien;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtTienDatCoc;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
