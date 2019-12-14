/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phongtro.ui;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import phongtro.dao.ChiDAO;
import phongtro.dao.HoadonphongDAO;
import phongtro.helper.DialogHelper;
import phongtro.model.Chi;
import phongtro.model.Hoadonphong;

/**
 *
 * @author Tường Ngao Tạng
 */
public class ChiUI extends javax.swing.JFrame {

    /**
     * Creates new form Cackhoanchi
     */
    public ChiUI() {
        initComponents();
        init();
    }
    int index = 0;
    ChiDAO dao = new ChiDAO();

    void init() {
        setLocationRelativeTo(null);
    }

    void exit() {
        Main main = new Main();
        main.setVisible(true);
        setVisible(false);
    }

    void load() {
        DefaultTableModel model = (DefaultTableModel) tblChi.getModel();
        model.setRowCount(0);
        try {
            String keyword = txtTimKiem.getText();
            List<Chi> list = dao.selectByKeyword(keyword);
            for (Chi chi : list) {
                Object[] row = {
                    chi.getMaChi(),
                    chi.getTenKhoanChi(),
                    chi.getLoaiKhoanChi(),
                    chi.getSoTien(),
                    chi.getNgayChi(),
                    chi.getMoTa()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    void insert() {
        Chi model = getModel();
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
        Chi model = getModel();
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
            String user = txtMaChi.getText();
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
        Chi model = new Chi();
        this.setModel(model);
        setStatus(true);
        txtSoTien.setText("");
        List<Chi> list = dao.selectByKeyword("");
        int ide = (Integer) list.size() + 1;
        txtMaChi.setText("Mchi0" + ide);
    }

    void edit() {
        try {
            String user = (String) tblChi.getValueAt(this.index, 0);
            Chi model = dao.findById(user);
            if (model != null) {
                this.setModel(model);
                this.setStatus(false);
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    void setModel(Chi model) {
        txtMaChi.setText(model.getMaChi());
        txtTenKhoanChi.setText(model.getTenKhoanChi());
        txtLoaiKhoanChi.setText(model.getLoaiKhoanChi());
        txtSoTien.setText(model.getSoTien() + "");
        txtNgayChi.setDate(model.getNgayChi());
        txtMoTa.setText(model.getMoTa());
    }

    Chi getModel() {
        Chi model = new Chi();
        model.setMaChi(txtMaChi.getText());
        model.setTenKhoanChi(txtTenKhoanChi.getText());
        model.setLoaiKhoanChi(txtLoaiKhoanChi.getText());
        model.setSoTien(Double.parseDouble(txtSoTien.getText()));
        model.setNgayChi(txtNgayChi.getDate());
        model.setMoTa(txtMoTa.getText());
        return model;
    }

    void setStatus(boolean insertable) {
        txtMaChi.setEditable(insertable);
        boolean first = this.index > 0;
        boolean last = this.index < tblChi.getRowCount() - 1;
        btnFirst.setEnabled(!insertable && first);
        btnPrevious.setEnabled(!insertable && first);
        btnNext.setEnabled(!insertable && last);
        btnLast.setEnabled(!insertable && last);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtMaChi = new javax.swing.JTextField();
        txtTenKhoanChi = new javax.swing.JTextField();
        txtLoaiKhoanChi = new javax.swing.JTextField();
        txtSoTien = new javax.swing.JTextField();
        txtNgayChi = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblChi = new javax.swing.JTable();
        txtTimKiem = new javax.swing.JTextField();
        btnExit = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JLabel();
        btnDelete = new javax.swing.JLabel();
        btnClear = new javax.swing.JLabel();
        btnFirst = new javax.swing.JLabel();
        btnPrevious = new javax.swing.JLabel();
        btnNext = new javax.swing.JLabel();
        btnLast = new javax.swing.JLabel();
        btnSearch = new javax.swing.JLabel();
        btnClose = new javax.swing.JLabel();
        btnAdd = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1020, 717));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        txtMaChi.setBackground(new java.awt.Color(196, 200, 203));
        txtMaChi.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtMaChi.setBorder(null);
        getContentPane().add(txtMaChi);
        txtMaChi.setBounds(220, 220, 330, 40);

        txtTenKhoanChi.setBackground(new java.awt.Color(196, 200, 203));
        txtTenKhoanChi.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtTenKhoanChi.setBorder(null);
        getContentPane().add(txtTenKhoanChi);
        txtTenKhoanChi.setBounds(220, 290, 330, 40);

        txtLoaiKhoanChi.setBackground(new java.awt.Color(196, 200, 203));
        txtLoaiKhoanChi.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtLoaiKhoanChi.setBorder(null);
        getContentPane().add(txtLoaiKhoanChi);
        txtLoaiKhoanChi.setBounds(650, 220, 330, 40);

        txtSoTien.setBackground(new java.awt.Color(196, 200, 203));
        txtSoTien.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtSoTien.setBorder(null);
        getContentPane().add(txtSoTien);
        txtSoTien.setBounds(650, 290, 330, 40);

        txtNgayChi.setBackground(new java.awt.Color(196, 200, 203));
        txtNgayChi.setForeground(new java.awt.Color(196, 200, 203));
        txtNgayChi.setDateFormatString("dd/MM/yyyy");
        txtNgayChi.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        getContentPane().add(txtNgayChi);
        txtNgayChi.setBounds(220, 360, 330, 40);

        txtMoTa.setBackground(new java.awt.Color(196, 200, 203));
        txtMoTa.setColumns(20);
        txtMoTa.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtMoTa.setRows(5);
        txtMoTa.setBorder(null);
        jScrollPane1.setViewportView(txtMoTa);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(650, 360, 330, 90);

        tblChi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Machi", "Ten Khoan Chi", "Loai Khoan Chi", "So Tien", "Ngay Chi", "Mo Ta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblChi.setRowHeight(20);
        tblChi.setSelectionBackground(new java.awt.Color(30, 168, 155));
        tblChi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblChi);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(220, 500, 770, 130);

        txtTimKiem.setBackground(new java.awt.Color(255, 255, 255));
        txtTimKiem.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtTimKiem.setBorder(null);
        getContentPane().add(txtTimKiem);
        txtTimKiem.setBounds(690, 143, 220, 30);

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
        btnExit.setBounds(994, 7, 10, 19);

        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateMouseClicked(evt);
            }
        });
        getContentPane().add(btnUpdate);
        btnUpdate.setBounds(20, 290, 140, 40);

        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });
        getContentPane().add(btnDelete);
        btnDelete.setBounds(20, 360, 140, 40);

        btnClear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClearMouseClicked(evt);
            }
        });
        getContentPane().add(btnClear);
        btnClear.setBounds(20, 440, 140, 40);

        btnFirst.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFirst.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFirstMouseClicked(evt);
            }
        });
        getContentPane().add(btnFirst);
        btnFirst.setBounds(440, 660, 70, 30);

        btnPrevious.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPrevious.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPreviousMouseClicked(evt);
            }
        });
        getContentPane().add(btnPrevious);
        btnPrevious.setBounds(540, 660, 70, 30);

        btnNext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNextMouseClicked(evt);
            }
        });
        getContentPane().add(btnNext);
        btnNext.setBounds(640, 660, 70, 30);

        btnLast.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLast.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLastMouseClicked(evt);
            }
        });
        getContentPane().add(btnLast);
        btnLast.setBounds(740, 660, 60, 30);

        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });
        getContentPane().add(btnSearch);
        btnSearch.setBounds(920, 140, 60, 40);

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
        btnAdd.setBounds(20, 220, 140, 40);

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/phongtro/image/quản lý chi tiêu.jpg"))); // NOI18N
        getContentPane().add(Background);
        Background.setBounds(0, 0, 1020, 710);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        this.load();
        this.setStatus(true);
    }//GEN-LAST:event_formWindowOpened

    private void tblChiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChiMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            this.index = tblChi.rowAtPoint(evt.getPoint());
            if (this.index >= 0) {
                this.edit();
            }
        }
    }//GEN-LAST:event_tblChiMouseClicked

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

    private void btnFirstMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFirstMouseClicked
        // TODO add your handling code here:
        this.index = 0;
        this.edit();
    }//GEN-LAST:event_btnFirstMouseClicked

    private void btnPreviousMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPreviousMouseClicked
        // TODO add your handling code here:
        this.index--;
        this.edit();
    }//GEN-LAST:event_btnPreviousMouseClicked

    private void btnNextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextMouseClicked
        // TODO add your handling code here:
        this.index++;
        this.edit();
    }//GEN-LAST:event_btnNextMouseClicked

    private void btnLastMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLastMouseClicked
        // TODO add your handling code here:
        this.index = tblChi.getRowCount() - 1;
        this.edit();
    }//GEN-LAST:event_btnLastMouseClicked

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
            java.util.logging.Logger.getLogger(ChiUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChiUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChiUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChiUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChiUI().setVisible(true);
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
    private javax.swing.JLabel btnFirst;
    private javax.swing.JLabel btnLast;
    private javax.swing.JLabel btnNext;
    private javax.swing.JLabel btnPrevious;
    private javax.swing.JLabel btnSearch;
    private javax.swing.JLabel btnUpdate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblChi;
    private javax.swing.JTextField txtLoaiKhoanChi;
    private javax.swing.JTextField txtMaChi;
    private javax.swing.JTextArea txtMoTa;
    private com.toedter.calendar.JDateChooser txtNgayChi;
    private javax.swing.JTextField txtSoTien;
    private javax.swing.JTextField txtTenKhoanChi;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
