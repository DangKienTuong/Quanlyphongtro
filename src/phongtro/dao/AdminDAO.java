/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phongtro.dao;

import phongtro.helper.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import phongtro.model.Admin;

/**
 *
 * @author admin
 */
public class AdminDAO {

    public void insert(Admin model) {
        String sql = "INSERT INTO Admin (Username, Pass, Sdt, Email, Ghichu) VALUES (?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                model.getUsername(),
                model.getPass(),
                model.getSdt(),
                model.getEmail(),
                model.getGhiChu());

    }

    public void update(Admin model) {
        String sql = "UPDATE Admin SET  Pass=?, Sdt=?, Email=?, Ghichu=? WHERE Username=?";
        JdbcHelper.executeUpdate(sql,
                model.getPass(),
                model.getSdt(),
                model.getEmail(),
                model.getGhiChu(),
                model.getUsername());
    }

    public void delete(String username) {
        String sql = "DELETE FROM Admin WHERE Username=?";
        JdbcHelper.executeUpdate(sql, username);
    }

    public List<Admin> select() {
        String sql = "SELECT * FROM Admin";
        return select(sql);
    }

    public List<Admin> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM Admin WHERE Username LIKE ?";
        return select(sql, "%" + keyword + "%");
    }

    public Admin findById(String Username) {
        String sql = "SELECT * FROM Admin WHERE Username=?";
        List<Admin> list = select(sql, Username);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<Admin> select(String sql, Object... args) {
        List<Admin> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    Admin model = readFromResultSet(rs);
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

    private Admin readFromResultSet(ResultSet rs) throws SQLException {
        Admin model = new Admin();
        model.setUsername(rs.getString("Username"));
        model.setPass(rs.getString("Pass"));
        model.setSdt(rs.getString("Sdt"));
        model.setEmail(rs.getString("Email"));
        model.setGhiChu(rs.getString("Ghichu"));
        return model;
    }
}
