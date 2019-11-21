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
import phongtro.helper.JdbcHelper;
import phongtro.model.Phong;

/**
 *
 * @author Tường Ngao Tạng
 */
public class PhongDAO {

    public void insert(Phong model) {
        String sql = "INSERT INTO Phong (Maphong, Tenphong, Songuoitoida, Dongia, Trangthai, Mota) VALUES (?, ?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                model.getMaPhong(),
                model.getTenPhong(),
                model.getSoNguoiToiDa(),
                model.getDonGia(),
                model.getTrangThai(),
                model.getMoTa()
        );
    }

    public void update(Phong model) {
        String sql = "UPDATE Phong SET Tenphong=?, Songuoitoida=?, Dongia=?, Trangthai=?, Mota = ? WHERE Maphong=?";
        JdbcHelper.executeUpdate(sql,
                model.getTenPhong(),
                model.getSoNguoiToiDa(),
                model.getDonGia(),
                model.getTrangThai(),
                model.getMoTa(),
                model.getMaPhong()
        );
    }

    public void delete(String Maphong) {
        String sql = "DELETE FROM Phong WHERE Maphong=?";
        JdbcHelper.executeUpdate(sql, Maphong);
    }

    public List<Phong> select() {
        String sql = "SELECT * FROM Phong";
        return select(sql);
    }

    public List<Phong> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM Phong WHERE Tenphong LIKE ?";
        return select(sql, "%" + keyword + "%");
    }

    public Phong findById(String Maphong) {
        String sql = "SELECT * FROM Phong WHERE Maphong=?";
        List<Phong> list = select(sql, Maphong);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<Phong> select(String sql, Object... args) {
        List<Phong> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    Phong model = readFromResultSet(rs);
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

    private Phong readFromResultSet(ResultSet rs) throws SQLException {
        Phong model = new Phong();
        model.setMaPhong(rs.getString("Maphong"));
        model.setTenPhong(rs.getString("Tenphong"));
        model.setSoNguoiToiDa(rs.getInt("Songuoitoida"));
        model.setDonGia(rs.getDouble("Dongia"));
        model.setTrangThai(rs.getString("Trangthai"));
        model.setMoTa(rs.getString("Mota"));
        return model;
    }
}
