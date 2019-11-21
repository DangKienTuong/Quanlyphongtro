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
import phongtro.model.Sudungdv;

/**
 *
 * @author Tường Ngao Tạng
 */
public class SudungdvDAO {

    public void insert(Sudungdv model) {
        String sql = "INSERT INTO Sudungdv (Masddv, Maphong, Madichvu) VALUES (?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                model.getMaSuDungDV(),
                model.getMaPhong(),
                model.getMaDichVu()
        );
    }

    public void update(Sudungdv model) {
        String sql = "UPDATE Sudungdv SET Maphong=?, Madichvu=? WHERE Masddv=?";
        JdbcHelper.executeUpdate(sql,
                model.getMaPhong(),
                model.getMaDichVu(),
                model.getMaSuDungDV()
        );
    }

    public void delete(String Masddv) {
        String sql = "DELETE FROM Sudungdv WHERE Masddv=?";
        JdbcHelper.executeUpdate(sql, Masddv);
    }

    public List<Sudungdv> select() {
        String sql = "SELECT * FROM Sudungdv";
        return select(sql);
    }

    public List<Sudungdv> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM Sudungdv WHERE Maphong LIKE ?";
        return select(sql, "%" + keyword + "%");
    }

    public Sudungdv findById(String Maphong) {
        String sql = "SELECT * FROM Sudungdv WHERE Masddv=?";
        List<Sudungdv> list = select(sql, Maphong);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<Sudungdv> select(String sql, Object... args) {
        List<Sudungdv> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    Sudungdv model = readFromResultSet(rs);
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

    private Sudungdv readFromResultSet(ResultSet rs) throws SQLException {
        Sudungdv model = new Sudungdv();
        model.setMaSuDungDV(rs.getString("Masddv"));
        model.setMaPhong(rs.getString("Maphong"));
        model.setMaDichVu(rs.getString("Madichvu"));
        return model;
    }
}
