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
import phongtro.model.Khachhang;

/**
 *
 * @author Tường Ngao Tạng
 */
public class KhachhangDAO {

    public void insert(Khachhang model) {
        String sql = "INSERT INTO Khachhang (Makhachhang, Maphong, Ten, Namsinh, Cmnd, Diachi, Nghenghiep, Sdt, Hinh) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                model.getMaKhachHang(),
                model.getMaPhong(),
                model.getTen(),
                DateHelper.toString(model.getNamSinh()),
                model.getCmnd(),
                model.getDiaChi(),
                model.getNgheNghiep(),
                model.getSdt(),
                model.getHinh()
        );
    }

    public void update(Khachhang model) {
        String sql = "UPDATE Khachhang SET Maphong=?, Ten=?, Namsinh=?, Cmnd=?, Diachi = ?, Nghenghiep = ?, Sdt = ?, Hinh = ?  WHERE Makhachhang=?";
        JdbcHelper.executeUpdate(sql,
                model.getMaPhong(),
                model.getTen(),
                DateHelper.toString(model.getNamSinh()),
                model.getCmnd(),
                model.getDiaChi(),
                model.getNgheNghiep(),
                model.getSdt(),
                model.getHinh(),
                model.getMaKhachHang()
        );
    }

    public void delete(String Makhachhang) {
        String sql = "DELETE FROM Khachhang WHERE Makhachhang=?";
        JdbcHelper.executeUpdate(sql, Makhachhang);
    }

    public List<Khachhang> select() {
        String sql = "SELECT * FROM Khachhang";
        return select(sql);
    }

    public List<Khachhang> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM Khachhang WHERE Ten LIKE ?";
        return select(sql, "%" + keyword + "%");
    }

    public Khachhang findById(String Makhachhang) {
        String sql = "SELECT * FROM Khachhang WHERE Makhachhang=?";
        List<Khachhang> list = select(sql, Makhachhang);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<Khachhang> select(String sql, Object... args) {
        List<Khachhang> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    Khachhang model = readFromResultSet(rs);
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

    private Khachhang readFromResultSet(ResultSet rs) throws SQLException {
        Khachhang model = new Khachhang();
        model.setMaKhachHang(rs.getString("Makhachhang"));
        model.setMaPhong(rs.getString("Maphong"));
        model.setTen(rs.getString("Ten"));
        model.setNamSinh(rs.getDate("Namsinh"));
        model.setCmnd(rs.getString("Cmnd"));
        model.setDiaChi(rs.getString("Diachi"));
        model.setNgheNghiep(rs.getString("Nghenghiep"));
        model.setSdt(rs.getString("Sdt"));
        model.setHinh(rs.getBytes("Hinh"));
        return model;
    }
}
