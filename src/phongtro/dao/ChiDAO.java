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
import phongtro.model.Chi;

/**
 *
 * @author admin
 */
public class ChiDAO {

    public void insert(Chi model) {
        String sql = "INSERT INTO Chi (Machi, Tenkhoanchi, Ngaychi, Loaikhoanchi, Soten, Mota) VALUES (?, ?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                model.getMaChi(),
                model.getTenKhoanChi(),
                DateHelper.toString(model.getNgayChi()),
                model.getLoaiKhoanChi(),
                model.getSoTien(),
                model.getMoTa());

    }

    public void update(Chi model) {
        String sql = "UPDATE Chi SET  Tenkhoanchi=?, Ngaychi=?, Loaikhoanchi=?, Sotien=?, Mota=? WHERE Machi=?";
        JdbcHelper.executeUpdate(sql,
                model.getTenKhoanChi(),
                DateHelper.toString(model.getNgayChi()),
                model.getLoaiKhoanChi(),
                model.getSoTien(),
                model.getMoTa(),
                model.getMaChi());
    }

    public void delete(String maChi) {
        String sql = "DELETE FROM Chi WHERE Machi=?";
        JdbcHelper.executeUpdate(sql, maChi);
    }

    public List<Chi> select() {
        String sql = "SELECT * FROM Chi";
        return select(sql);
    }

    public List<Chi> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM Chi WHERE Tenkhoanchi LIKE ?";
        return select(sql, "%" + keyword + "%");
    }

    public Chi findById(String Machi) {
        String sql = "SELECT * FROM Chi WHERE Machi=?";
        List<Chi> list = select(sql, Machi);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<Chi> select(String sql, Object... args) {
        List<Chi> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    Chi model = readFromResultSet(rs);
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

    private Chi readFromResultSet(ResultSet rs) throws SQLException {
        Chi model = new Chi();
        model.setMaChi(rs.getString("Machi"));
        model.setTenKhoanChi(rs.getString("Tenkhoanchi"));
        model.setNgayChi(rs.getDate("Ngaychi"));
        model.setLoaiKhoanChi(rs.getString("Loaikhoanchi"));
        model.setSoTien(rs.getDouble("Sotien"));
        model.setMoTa(rs.getString("Mota"));
        return model;
    }
}
