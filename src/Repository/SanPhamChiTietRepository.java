package Repository;

import JDBCUtil.DBConnect;
import Response.SanPhamChiTietResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SanPhamChiTietRepository {

    public ArrayList<SanPhamChiTietResponse> getAll() {
        String sql = """
                        SELECT
                                spct.Id
                                ,spct.MaSanPhamCT
                                ,sp.MaSanPham
                                ,ms.TenMauSac
                                ,kt.TenKichThuoc
                                ,cl.TenChatLieu
                                ,spct.TenSanPhamCT
                                ,spct.Gia
                                ,spct.MoTa
                                ,spct.SoLuong
                                ,spct.NgayNhap
                                ,spct.TrangThai
                        FROM SanPhamChiTiet spct
                        JOIN SanPham sp ON spct.IdSanPham = sp.Id
                        JOIN MauSac ms ON spct.IdMauSac = ms.Id
                        JOIN KichThuoc kt ON spct.IdKichThuoc = kt.Id
                        JOIN ChatLieu cl ON spct.IdChatLieu = cl.Id
                    """;
        ArrayList<SanPhamChiTietResponse> list = new ArrayList<>();
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                SanPhamChiTietResponse spr = new SanPhamChiTietResponse();
                spr.setId(rs.getInt(1));
                spr.setMaSanPhamCT(rs.getString(2));
                spr.setMaSanPham(rs.getString(3));
                spr.setTenMauSac(rs.getString(4));
                spr.setTenKichThuoc(rs.getString(5));
                spr.setTenChatLieu(rs.getString(6));
                spr.setTenSanPham(rs.getString(7));
                spr.setGia(rs.getBigDecimal(8));
                spr.setMoTa(rs.getString(9));
                spr.setSoLuong(rs.getInt(10));
                spr.setNgayNhap(rs.getDate(11));
                spr.setTrangThai(rs.getInt(12));
                list.add(spr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public boolean updateSoLuong(SanPhamChiTietResponse response) {
        int check = 0;
        String sql = """
                    UPDATE SanPhamChiTiet
                       SET 
                          SoLuong = ?
                     WHERE MaSanPhamCT = ?
                     """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, response.getSoLuong());
            ps.setObject(2, response.getMaSanPhamCT());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;

    }
}
