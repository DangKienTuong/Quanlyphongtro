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
import phongtro.model.Hopdong;

/**
 *
 * @author Tường Ngao Tạng
 */
public class HopdongDAO {

    public void insert(Hopdong model) {
        String sql = "INSERT INTO Hopdong (Mahopdong, Maphong, Nguoidaidien, Sdt, Tiendatcoc, Ngaydatcoc, Ngayhethan) VALUES (?, ?, ?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                model.getMaHopDong(),
                model.getMaPhong(),
                model.getNguoiDaiDien(),
                model.getSdt(),
                model.getTienDatCoc(),
                model.getNgayDatCoc(),
                model.getNgayHetHan()
        );
    }

    public void update(Hopdong model) {
        String sql = "UPDATE Hopdong SET  Maphong=?, Nguoidaidien=?, Sdt=?, Tiendatcoc=?, Ngaydatcoc=?, Ngayhethan=? WHERE Mahopdong=?";
        JdbcHelper.executeUpdate(sql,
                model.getMaPhong(),
                model.getNguoiDaiDien(),
                model.getSdt(),
                model.getTienDatCoc(),
                model.getNgayDatCoc(),
                model.getNgayHetHan(),
                model.getMaHopDong()
        );

    }

    public void delete(String Mahd) {
        String sql = "DELETE FROM Hopdong WHERE Mahopdong=?";
        JdbcHelper.executeUpdate(sql, Mahd);
    }

    public List<Hopdong> select() {
        String sql = "SELECT * FROM Hopdong";
        return select(sql);
    }

    public List<Hopdong> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM Hopdong WHERE Mahopdong LIKE ?";
        return select(sql, "%" + keyword + "%");
    }

    public Hopdong findById(String Mahd) {
        String sql = "SELECT * FROM Hopdong WHERE Mahopdong=?";
        List<Hopdong> list = select(sql, Mahd);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<Hopdong> select(String sql, Object... args) {
        List<Hopdong> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    Hopdong model = readFromResultSet(rs);
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

    private Hopdong readFromResultSet(ResultSet rs) throws SQLException {
        Hopdong model = new Hopdong();
        model.setMaHopDong(rs.getString("Mahopdong"));
        model.setMaPhong(rs.getString("Maphong"));
        model.setNguoiDaiDien(rs.getString("Nguoidaidien"));
        model.setSdt(rs.getString("Sdt"));
        model.setTienDatCoc(rs.getDouble("Tiendatcoc"));
        model.setNgayDatCoc(rs.getDate("Ngaydatcoc"));
        model.setNgayHetHan(rs.getDate("Ngayhethan"));
        return model;
    }
}
