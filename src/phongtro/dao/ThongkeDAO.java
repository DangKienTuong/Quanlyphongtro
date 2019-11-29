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

/**
 *
 * @author Tường Ngao Tạng
 */
public class ThongkeDAO {

    public List<Object[]> getTongChi() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "Select DATEPART(MONTH,[Ngaychi]) as Thang, DATEPART(YEAR,[Ngaychi]) as Nam,sum(Sotien) as TongChi from [dbo].[Chi] group by DATEPART(MONTH,[Ngaychi]), DATEPART(YEAR,[Ngaychi])";
                rs = JdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {
                        rs.getInt("Thang"),
                        rs.getInt("Nam"),
                        rs.getDouble("TongChi")
                    };
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
}
