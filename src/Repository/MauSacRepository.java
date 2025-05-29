package Repository;

import JDBCUtil.DBConnect;
import Response.MauSacResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MauSacRepository {

    public List<MauSacResponse> getAll() {
        String sql = """
                     	SELECT 
                            Id
                            ,MaMauSac
                            ,TenMauSac
                            ,TrangThai
                        FROM MauSac
                     """;
        List<MauSacResponse> list = new ArrayList<>();
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                MauSacResponse ms = new MauSacResponse();
                ms.setId(rs.getInt(1));
                ms.setMaMauSac(rs.getString(2));
                ms.setTenMauSac(rs.getString(3));
                ms.setTrangThai(rs.getInt(4));
                list.add(ms);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
