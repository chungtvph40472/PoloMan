package Repository;

import Entity.SanPham;
import JDBCUtil.DBConnect;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.JOptionPane;

public class SanPhamRepository {

    public ArrayList<SanPham> getAll() {
        String sql = """
                        SELECT
                                sp.Id,
                                sp.IdThuongHieu,
                                sp.MaSanPham,
                                sp.TenSanPham,
                                SUM(spct.SoLuong) AS SoLuongTong,
                                sp.TrangThai
                        FROM
                                SanPham sp	
                        JOIN SanPhamChiTiet spct ON sp.Id = spct.IdSanPham
                        GROUP BY 
                                sp.Id,
                                sp.IdThuongHieu,
                                sp.MaSanPham,
                                sp.TenSanPham,
                                spct.SoLuong,
                                sp.TrangThai
                     """;

        ArrayList<SanPham> listSanPham = new ArrayList<>();
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                SanPham sanPham = new SanPham();
                sanPham.setIdSanPham(rs.getInt("Id"));
                sanPham.setIdThuongHieu(rs.getInt("IdThuongHieu"));
                sanPham.setMaSanPham(rs.getString("MaSanPham"));
                sanPham.setTenSanPham(rs.getString("TenSanPham"));
                sanPham.setSoLuong(rs.getInt("SoLuongTong"));
                sanPham.setTrangThai(rs.getInt("TrangThai"));
                listSanPham.add(sanPham);
            }
            return listSanPham;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
    }

    public boolean add(SanPham sanPham) {
        int check = 0;
        String sql = """
                        INSERT
                                sp.Id,
                                sp.IdThuongHieu,
                                sp.MaSanPham,
                                sp.TenSanPham,
                                SUM(spct.SoLuong) AS SoLuongTong,
                                sp.TrangThai
                        INTO
                                SanPham sp	
                        JOIN SanPhamChiTiet spct ON sp.Id = spct.IdSanPham
                        GROUP BY 
                                sp.Id,
                                sp.IdThuongHieu,
                                sp.MaSanPham,
                                sp.TenSanPham,
                                spct.SoLuong,
                                sp.TrangThai
                            (?, ?, ?)
                     """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, sanPham.getTenSanPham());
            ps.setInt(2, sanPham.getSoLuong());
            ps.setInt(3, sanPham.getTrangThai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(SanPham sanPham) {
        int check = 0;
        String sql = """
                     UPDATE SanPham
                     SET
                        TenSanPham = ?,
                        SoLuong = ?, 
                        TrangThai = ?
                     WHERE
                        Id = ?
                     """;

        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, sanPham.getTenSanPham());
            ps.setInt(2, sanPham.getSoLuong());
            ps.setInt(3, sanPham.getTrangThai());
            ps.setInt(4, sanPham.getIdSanPham());
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(int idSanPham) {
        int check = 0;
        String sql = """
                     DELETE FROM SanPham
                     WHERE Id = ?
                     """;

        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idSanPham);
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

        return check > 0;
    }

    public ArrayList<SanPham> search(String keyword) {
        String sql = """
                     SELECT
                        sp.Id,
                        sp.MaSanPham,
                        sp.TenSanPham,
                        spct
                        sp.TrangThai
                     FROM
                        SanPham sp
                     WHERE
                        sp.TenSanPham LIKE ?
                     OR 
                        sp.MaSanPham LIKE ?
                     """;

        ArrayList<SanPham> list = new ArrayList<>();
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            if (keyword.length() > 0) {
                String value = "%" + keyword + "%";
                for (int i = 1; i <= 2; i++) {
                    ps.setString(i, value);
                }
            }
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                SanPham sanPham = new SanPham();
                sanPham.setIdSanPham(rs.getInt("Id"));
                sanPham.setMaSanPham(rs.getString("MaSanPham"));
                sanPham.setTenSanPham(rs.getString("TenSanPham"));
                sanPham.setTrangThai(rs.getInt("TrangThai"));

                list.add(sanPham);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra khi tìm kiếm sản phẩm", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        return list;
    }
}
