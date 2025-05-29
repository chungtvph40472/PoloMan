package Repository;

import JDBCUtil.DBConnect;
import Response.KichThuocResponse;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class KichThuocRepository {

    public List<KichThuocResponse> getAll() {
        String sql = """
                     	SELECT 
                            Id
                            ,MaKichThuoc
                            ,TenKichThuoc
                            ,TrangThai
                        FROM KichThuoc
                     """;
        List<KichThuocResponse> list = new ArrayList<>();
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                KichThuocResponse kt = new KichThuocResponse();
                kt.setId(rs.getInt(1));
                kt.setMaKichThuoc(rs.getString(2));
                kt.setTenKichThuoc(rs.getString(3));
                kt.setTrangThai(rs.getInt(4));
                list.add(kt);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
