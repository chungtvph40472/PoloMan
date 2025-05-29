/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import java.sql.Connection;
import Entity.HoaDonChiTiet;
import JDBCUtil.DBConnect;
import Response.HoaDonChiTietRepose;
import Response.HoaDonRepose;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author nguyensyan
 */
public class HoaDonChiTietRepository {

    public ArrayList<HoaDonChiTietRepose> findAll() {

        String sql = """
                        SELECT 
                                hdct.Id,
                                hd.MaHoaDon,
                                spct.TenSanPhamCT,
                                hdct.SoLuong,
                                hdct.GiaDaThanhToan,
                                kt.TenKichThuoc,
                                ms.TenMauSac, 
                                cl.TenChatLieu, 
                                spct.MoTa,
                                hd.NgayThanhToan,
                                hdct.TrangThai 
                        FROM HoaDonChiTiet hdct 
                        JOIN HoaDon hd ON hdct.IdHoaDon = hd.Id 
                        JOIN SanPhamChiTiet spct ON hdct.IdSanPhamChiTiet = spct.Id 
                        JOIN SanPham sp ON spct.IdSanPham = sp.Id 
                        JOIN MauSac ms ON spct.IdMauSac = ms.Id 
                        JOIN KichThuoc kt ON spct.IdKichThuoc = kt.Id 
                        JOIN ChatLieu cl ON spct.IdChatLieu = cl.Id
                     """;
        ArrayList<HoaDonChiTietRepose> list = new ArrayList<>();
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                HoaDonChiTietRepose hdctRepose = new HoaDonChiTietRepose();
                hdctRepose.setId(rs.getInt(1));
                hdctRepose.setMaHoaDon(rs.getString(2));
                hdctRepose.setTenSanPham(rs.getString(3));
                hdctRepose.setSoluong(rs.getInt(4));
                hdctRepose.setGiaDaThanhToan(rs.getBigDecimal(5));
                hdctRepose.setKichThuoc(rs.getString(6));
                hdctRepose.setMauSac(rs.getString(7));
                hdctRepose.setChatLieu(rs.getString(8));
                hdctRepose.setMoTa(rs.getString(9));
                hdctRepose.setNgayThanhToan(rs.getDate(10));
                hdctRepose.setTrangThai(rs.getInt(11));
                list.add(hdctRepose);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<HoaDonChiTietRepose> search(String keyword) {
        String sql = """
                    SELECT 
                            hdct.Id,
                            hd.MaHoaDon,
                            spct.TenSanPhamCT,
                            hdct.SoLuong,
                            hdct.GiaDaThanhToan,
                            kt.TenKichThuoc,
                            ms.TenMauSac, 
                            cl.TenChatLieu, 
                            spct.MoTa,
                            hd.NgayThanhToan,
                            hdct.TrangThai 
                    FROM HoaDonChiTiet hdct 
                    JOIN HoaDon hd ON hdct.IdHoaDon = hd.Id 
                    JOIN SanPhamChiTiet spct ON hdct.IdSanPhamChiTiet = spct.Id 
                    JOIN SanPham sp ON spct.IdSanPham = sp.Id 
                    JOIN MauSac ms ON spct.IdMauSac = ms.Id 
                    JOIN KichThuoc kt ON spct.IdKichThuoc = kt.Id 
                    JOIN ChatLieu cl ON spct.IdChatLieu = cl.Id
                   """;

        if (!keyword.isEmpty()) { // isempty
            sql += """
                WHERE
                    ( 
                        hd.MaHoaDon LIKE ?
                        OR spct.TenSanPhamCT LIKE ?
                        OR kt.TenKichThuoc LIKE ?
                        OR ms.TenMauSac LIKE ?
                        OR cl.TenChatLieu LIKE ?
                        OR (
                                CASE hdct.TrangThai 
                                WHEN 1 THEN N'Đã thanh toán' 
                                WHEN 0 THEN N'Chưa thanh toán' 
                                ELSE N'Không Xác Định' 
                                END 
                            )
                            LIKE ?
                    )
                  """;
        }
        ArrayList<HoaDonChiTietRepose> list = new ArrayList<>();
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            if (keyword.length() > 0) {
                String value = "%" + keyword + "%";
                for (int i = 1; i <= 6; i++) {
                    ps.setString(i, value);
                }
            }
            System.out.println("SQL: " + ps.toString());
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    HoaDonChiTietRepose hdctRepose = new HoaDonChiTietRepose();
                    hdctRepose.setId(rs.getInt(1));
                    hdctRepose.setMaHoaDon(rs.getString(2));
                    hdctRepose.setTenSanPham(rs.getString(3));
                    hdctRepose.setSoluong(rs.getInt(4));
                    String raw = rs.getString(5);
                    raw = raw.replace(" đ", "");
                    BigDecimal giaDaThanhToan = new BigDecimal(raw);
                    hdctRepose.setGiaDaThanhToan(giaDaThanhToan);
                    hdctRepose.setKichThuoc(rs.getString(6));
                    hdctRepose.setMauSac(rs.getString(7));
                    hdctRepose.setChatLieu(rs.getString(8));
                    hdctRepose.setMoTa(rs.getString(9));
                    hdctRepose.setNgayThanhToan(rs.getDate(10));
                    hdctRepose.setTrangThai(rs.getInt(11));
                    list.add(hdctRepose);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<HoaDonChiTietRepose> getByMaHoaDon(String maHD) {
        String sql = """
                    SELECT 
                            hdct.Id,
                            hd.MaHoaDon,
                            spct.TenSanPhamCT,
                            hdct.SoLuong,
                            hdct.GiaDaThanhToan,
                            kt.TenKichThuoc,
                            ms.TenMauSac, 
                            cl.TenChatLieu, 
                            spct.MoTa,
                            hd.NgayThanhToan,
                            hdct.TrangThai 
                    FROM HoaDonChiTiet hdct 
                    JOIN HoaDon hd ON hdct.IdHoaDon = hd.Id 
                    JOIN SanPhamChiTiet spct ON hdct.IdSanPhamChiTiet = spct.Id 
                    JOIN SanPham sp ON spct.IdSanPham = sp.Id 
                    JOIN MauSac ms ON spct.IdMauSac = ms.Id 
                    JOIN KichThuoc kt ON spct.IdKichThuoc = kt.Id 
                    JOIN ChatLieu cl ON spct.IdChatLieu = cl.Id
                    WHERE hd.MaHoaDon LIKE ?
                   """;
        ArrayList<HoaDonChiTietRepose> list = new ArrayList<>();
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, maHD);
            System.out.println("SQL: " + ps.toString());
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    HoaDonChiTietRepose hdctRepose = new HoaDonChiTietRepose();
                    hdctRepose.setId(rs.getInt(1));
                    hdctRepose.setMaHoaDon(rs.getString(2));
                    hdctRepose.setTenSanPham(rs.getString(3));
                    hdctRepose.setSoluong(rs.getInt(4));
                    String raw = rs.getString(5);
                    raw = raw.replace(" đ", "");
                    BigDecimal giaDaThanhToan = new BigDecimal(raw);
                    hdctRepose.setGiaDaThanhToan(giaDaThanhToan);
                    hdctRepose.setKichThuoc(rs.getString(6));
                    hdctRepose.setMauSac(rs.getString(7));
                    hdctRepose.setChatLieu(rs.getString(8));
                    hdctRepose.setMoTa(rs.getString(9));
                    hdctRepose.setNgayThanhToan(rs.getDate(10));
                    hdctRepose.setTrangThai(rs.getInt(11));
                    list.add(hdctRepose);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<HoaDonChiTietRepose> getAllById(Integer id) {
        String sql = """
                    SELECT 
                            hdct.Id,
                            hd.MaHoaDon,
                            spct.TenSanPhamCT,
                            hdct.SoLuong,
                            hdct.GiaDaThanhToan,
                            kt.TenKichThuoc,
                            ms.TenMauSac, 
                            cl.TenChatLieu, 
                            spct.MoTa,
                            hd.NgayThanhToan,
                            hdct.TrangThai 
                    FROM HoaDonChiTiet hdct 
                    JOIN HoaDon hd ON hdct.IdHoaDon = hd.Id 
                    JOIN SanPhamChiTiet spct ON hdct.IdSanPhamChiTiet = spct.Id 
                    JOIN SanPham sp ON spct.IdSanPham = sp.Id 
                    JOIN MauSac ms ON spct.IdMauSac = ms.Id 
                    JOIN KichThuoc kt ON spct.IdKichThuoc = kt.Id 
                    JOIN ChatLieu cl ON spct.IdChatLieu = cl.Id
                    WHERE hdct.Id LIKE ?
                   """;
        ArrayList<HoaDonChiTietRepose> list = new ArrayList<>();
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id);
            System.out.println("SQL: " + ps.toString());
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    HoaDonChiTietRepose hdctRepose = new HoaDonChiTietRepose();
                    hdctRepose.setId(rs.getInt(1));
                    hdctRepose.setMaHoaDon(rs.getString(2));
                    hdctRepose.setTenSanPham(rs.getString(3));
                    hdctRepose.setSoluong(rs.getInt(4));
                    String raw = rs.getString(5);
                    raw = raw.replace(" đ", "");
                    BigDecimal giaDaThanhToan = new BigDecimal(raw);
                    hdctRepose.setGiaDaThanhToan(giaDaThanhToan);
                    hdctRepose.setKichThuoc(rs.getString(6));
                    hdctRepose.setMauSac(rs.getString(7));
                    hdctRepose.setChatLieu(rs.getString(8));
                    hdctRepose.setMoTa(rs.getString(9));
                    hdctRepose.setNgayThanhToan(rs.getDate(10));
                    hdctRepose.setTrangThai(rs.getInt(11));
                    list.add(hdctRepose);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean add(HoaDonChiTietRepose hdct) {

        int check = 0;

        String sql = """
                    INSERT INTO HoaDonChiTiet
                            (IdHoaDon
                            ,IdSanPhamChiTiet
                            ,SoLuong
                            ,GiaDaThanhToan
                            ,ThanhTien
                            ,HinhThucThanhToan
                            ,TrangThai)
                    VALUES
                            (?,?,?,?,?,?,?)
                    """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            // Object la cha cua cac loai kieu du lieu 
            ps.setObject(1, hdct.getIdHoaDon());
            ps.setObject(2, hdct.getIdSanPhamChiTiet()); // Nhan vien lay tu login
            ps.setObject(3, hdct.getSoluong());
            ps.setObject(4, hdct.getGiaDaThanhToan());
            ps.setObject(5, hdct.getThanhTien());
            ps.setObject(6, hdct.getHinhThucThanhToan());
            ps.setObject(7, hdct.getGiaDaThanhToan());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

        return check > 0;
    }

}
