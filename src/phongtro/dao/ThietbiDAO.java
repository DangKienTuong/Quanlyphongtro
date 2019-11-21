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
import phongtro.model.Thietbi;

/**
 *
 * @author Tường Ngao Tạng
 */
public class ThietbiDAO {

    public void insert(Thietbi model) {
        String sql = "INSERT INTO Thietbi (Mathietbi, Maphong, Tenthietbi, Donvi, Gia, Trangthai, Mota, Soluong) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                model.getMaThietBi(),
                model.getMaPhong(),
                model.getTenThietBi(),
                model.getDonVi(),
                model.getGia(),
                model.getTrangThai(),
                model.getMoTa(),
                model.getSoLuong()
        );
    }

    public void update(Thietbi model) {
        String sql = "UPDATE Thietbi SET Maphong=?, Tenthietbi=?, Donvi=?, Gia=?, Trangthai=?, Mota=?, Soluong=?  WHERE Mathietbi=?";
        JdbcHelper.executeUpdate(sql,
                model.getMaPhong(),
                model.getTenThietBi(),
                model.getDonVi(),
                model.getGia(),
                model.getTrangThai(),
                model.getMoTa(),
                model.getSoLuong(),
                model.getMaThietBi()
        );
    }

    public void delete(String Mathietbi) {
        String sql = "DELETE FROM Thietbi WHERE Mathietbi=?";
        JdbcHelper.executeUpdate(sql, Mathietbi);
    }

    public List<Thietbi> select() {
        String sql = "SELECT * FROM Thietbi";
        return select(sql);
    }

    public List<Thietbi> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM Thietbi WHERE Maphong LIKE ?";
        return select(sql, "%" + keyword + "%");
    }

    public Thietbi findById(String Mathietbi) {
        String sql = "SELECT * FROM Thietbi WHERE Mathietbi=?";
        List<Thietbi> list = select(sql, Mathietbi);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<Thietbi> select(String sql, Object... args) {
        List<Thietbi> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    Thietbi model = readFromResultSet(rs);
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

    private Thietbi readFromResultSet(ResultSet rs) throws SQLException {
        Thietbi model = new Thietbi();
        model.setMaThietBi(rs.getString("Mathietbi"));
        model.setMaPhong(rs.getString("Maphong"));
        model.setTenThietBi(rs.getString("Tenthietbi"));
        model.setDonVi(rs.getString("Donvi"));
        model.setGia(rs.getDouble("Gia"));
        model.setTrangThai(rs.getString("Trangthai"));
        model.setMoTa(rs.getString("Mota"));
        model.setSoLuong(rs.getInt("Soluong"));
        return model;
    }
}
