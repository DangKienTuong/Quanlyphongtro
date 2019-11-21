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
import phongtro.model.Chi;
import phongtro.model.Dichvu;

/**
 *
 * @author Tường Ngao Tạng
 */
public class DichvuDAO {

    public void insert(Dichvu model) {
        String sql = "INSERT INTO Dichvu (Madichvu, Tendichvu, Dongia, Donvi, Mota) VALUES (?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                model.getMaDichVu(),
                model.getTenDichVu(),
                model.getDonGia(),
                model.getDonVi(),
                model.getMoTa());
    }

    public void update(Dichvu model) {
        String sql = "UPDATE Dichvu SET  Tendichvu=?, Dongia=?, Donvi=?, Mota=? WHERE Madichvu=?";
        JdbcHelper.executeUpdate(sql,
                model.getTenDichVu(),
                model.getDonGia(),
                model.getDonVi(),
                model.getMoTa(),
                model.getMaDichVu());

    }

    public void delete(String Madichvu) {
        String sql = "DELETE FROM Dichvu WHERE Madichvu=?";
        JdbcHelper.executeUpdate(sql, Madichvu);
    }

    public List<Dichvu> select() {
        String sql = "SELECT * FROM Dichvu";
        return select(sql);
    }

    public List<Dichvu> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM Dichvu WHERE Tendichvu LIKE ?";
        return select(sql, "%" + keyword + "%");
    }

    public Dichvu findById(String Madichvu) {
        String sql = "SELECT * FROM Dichvu WHERE Madichvu=?";
        List<Dichvu> list = select(sql, Madichvu);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<Dichvu> select(String sql, Object... args) {
        List<Dichvu> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    Dichvu model = readFromResultSet(rs);
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

    private Dichvu readFromResultSet(ResultSet rs) throws SQLException {
        Dichvu model = new Dichvu();
        model.setMaDichVu(rs.getString("Madichvu"));
        model.setTenDichVu(rs.getString("Tendichvu"));
        model.setDonGia(rs.getDouble("Dongia"));
        model.setDonVi(rs.getString("Donvi"));
        model.setMoTa(rs.getString("Mota"));
        return model;
    }
}
