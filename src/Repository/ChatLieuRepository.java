package Repository;

import JDBCUtil.DBConnect;
import Response.ChatLieuResponse;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class ChatLieuRepository {

    public List<ChatLieuResponse> getAll() {
        String sql = """
                     	SELECT 
                            Id
                            ,MaChatLieu
                            ,TenChatLieu
                            ,TrangThai
                        FROM ChatLieu
                     """;
        List<ChatLieuResponse> list = new ArrayList<>();
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                ChatLieuResponse cl = new ChatLieuResponse();
                cl.setId(rs.getInt(1));
                cl.setMaChatLieu(rs.getString(2));
                cl.setTenChatLieu(rs.getString(3));
                cl.setTrangThai(rs.getInt(4));
                list.add(cl);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
