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
import phongtro.model.Dichvu;
import phongtro.model.Hoadondiennuoc;

/**
 *
 * @author Tường Ngao Tạng
 */
public class HoadondiennuocDAO {

    public void insert(Hoadondiennuoc model) {
        String sql = "INSERT INTO Hoadondiennuoc (Mahoadon, Maphong, Ngaylap, Chisodau, Chisocuoi) VALUES (?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                model.getMaHoaDon(),
                model.getMaPhong(),
                model.getNgayLap(),
                model.getChiSoDau(),
                model.getChiSoCuoi()
        );
    }

    public void update(Hoadondiennuoc model) {
        String sql = "UPDATE Hoadondiennuoc SET  Maphong=?, Ngaylap=?, Chisodau=?, Chisocuoi=? WHERE Mahoadon=?";
        JdbcHelper.executeUpdate(sql,
                model.getMaPhong(),
                model.getNgayLap(),
                model.getChiSoDau(),
                model.getChiSoCuoi(),
                model.getMaHoaDon()
        );

    }

    public void delete(String MaHoaDon) {
        String sql = "DELETE FROM Hoadondiennuoc WHERE MaHoaDon=?";
        JdbcHelper.executeUpdate(sql, MaHoaDon);
    }

    public List<Hoadondiennuoc> select() {
        String sql = "SELECT * FROM Hoadondiennuoc";
        return select(sql);
    }

    public List<Hoadondiennuoc> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM Hoadondiennuoc WHERE Maphong LIKE ?";
        return select(sql, "%" + keyword + "%");
    }

    public Hoadondiennuoc findById(String MaHoaDon) {
        String sql = "SELECT * FROM Hoadondiennuoc WHERE MaHoaDon=?";
        List<Hoadondiennuoc> list = select(sql, MaHoaDon);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<Hoadondiennuoc> select(String sql, Object... args) {
        List<Hoadondiennuoc> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    Hoadondiennuoc model = readFromResultSet(rs);
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

    private Hoadondiennuoc readFromResultSet(ResultSet rs) throws SQLException {
        Hoadondiennuoc model = new Hoadondiennuoc();
        model.setMaHoaDon(rs.getString("Mahoadon"));
        model.setMaPhong(rs.getString("Maphong"));
        model.setNgayLap(rs.getDate("Ngaylap"));
        model.setChiSoDau(rs.getInt("Chisodau"));
        model.setChiSoCuoi(rs.getInt("Chisocuoi"));
        model.setTieuThu(rs.getInt("Tieuthu"));
        return model;
    }
}
