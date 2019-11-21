/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phongtro.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import phongtro.helper.DateHelper;
import phongtro.helper.JdbcHelper;
import phongtro.model.Hoadonphong;

/**
 *
 * @author Tường Ngao Tạng
 */
public class HoadonphongDAO {

    public void insert(Hoadonphong model) {
        String sql = "INSERT INTO Hoadonphong (Mahd, Thangnam, Maphong, Nguoidaidien, Ngaythanhtoan, Tinhtrang) VALUES (?, ?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                model.getMaHoadon(),
                DateHelper.toString(model.getThangNam()),
                model.getMaPhong(),
                model.getNguoiDaiDien(),
                DateHelper.toString(model.getNgayThanhToan()),
                model.getTinhTrang()
        );
    }

    public void update(Hoadonphong model) {
        String sql = "UPDATE Hoadonphong SET  Thangnam=?, Maphong=?, Nguoidaidien=?, Ngaythanhtoan=?, Tinhtrang=? WHERE Mahd=?";
        JdbcHelper.executeUpdate(sql,
                DateHelper.toString(model.getThangNam()),
                model.getMaPhong(),
                model.getNguoiDaiDien(),
                DateHelper.toString(model.getNgayThanhToan()),
                model.getTinhTrang(),
                model.getMaHoadon()
        );

    }

    public void delete(String Mahd) {
        String sql = "DELETE FROM Hoadonphong WHERE Mahd=?";
        JdbcHelper.executeUpdate(sql, Mahd);
    }

    public List<Hoadonphong> select() {
        String sql = "SELECT * FROM Hoadonphong";
        return select(sql);
    }

    public List<Hoadonphong> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM Hoadonphong WHERE Maphong LIKE ?";
        return select(sql, "%" + keyword + "%");
    }

    public Hoadonphong findById(String Mahd) {
        String sql = "SELECT * FROM Hoadonphong WHERE Mahd=?";
        List<Hoadonphong> list = select(sql, Mahd);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<Hoadonphong> select(String sql, Object... args) {
        List<Hoadonphong> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    Hoadonphong model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    private Hoadonphong readFromResultSet(ResultSet rs) throws SQLException {
        Hoadonphong model = new Hoadonphong();
        model.setMaHoadon(rs.getString("Mahd"));
        model.setThangNam(rs.getDate("Thangnam"));
        model.setMaPhong(rs.getString("Maphong"));
        model.setNguoiDaiDien(rs.getString("Nguoidaidien"));
        model.setNgayThanhToan(rs.getDate("Ngaythanhtoan"));
        model.setTinhTrang(rs.getString("Tinhtrang"));
        return model;
    }
}
