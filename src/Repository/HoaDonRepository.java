/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import java.sql.Connection;
import Entity.HoaDon;
import JDBCUtil.DBConnect;
import Response.HoaDonRepose;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

/**
 *
 * @author nguyensyan
 */
public class HoaDonRepository {

    public ArrayList<HoaDonRepose> findAll() {

        String sql = """
                 SELECT	
                        hd.Id,
                        hd.MaHoaDon,
                        nv.MaNhanVien,
                        nv.TenNhanVien,
                        kh.MaKhachHang,
                        kh.TenKhachHang,
                        (hdct.GiaDaThanhToan * hdct.SoLuong) AS ThanhTien , 
                        hd.NgayThanhToan, 
                        hd.TrangThai
                FROM HoaDon hd
                JOIN KhachHang kh ON hd.IdKhachHang = kh.Id
                JOIN NhanVien nv ON hd.IdNhanVien = nv.Id
                JOIN HoaDonChiTiet hdct ON hd.Id = hdct.IdHoaDon
                
        """;
        ArrayList<HoaDonRepose> list = new ArrayList<>();
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                HoaDonRepose hdr = new HoaDonRepose();
                hdr.setId(rs.getInt(1));
                hdr.setMaHoaDon(rs.getString(2));
                hdr.setMaNhanVien(rs.getString(3));
                hdr.setTenNhanVien(rs.getString(4));
                hdr.setMaKhachHang(rs.getString(5));
                hdr.setTenKhachHang(rs.getString(6));
                hdr.setThanhTien(rs.getBigDecimal(7));
                hdr.setNgayThanhToan(rs.getDate(8));
                hdr.setTrangThai(rs.getInt(9));
                list.add(hdr);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<HoaDonRepose> getAllByTrangThai() {

        String sql = """
                 SELECT	
                        hd.Id,
                        hd.MaHoaDon,
                        nv.MaNhanVien,
                        nv.TenNhanVien,
                        kh.MaKhachHang,
                        kh.TenKhachHang,
                        (hdct.GiaDaThanhToan * hdct.SoLuong) AS ThanhTien , 
                        hd.NgayThanhToan, 
                        hd.TrangThai
                FROM HoaDon hd
                JOIN KhachHang kh ON hd.IdKhachHang = kh.Id
                JOIN NhanVien nv ON hd.IdNhanVien = nv.Id
                JOIN HoaDonChiTiet hdct ON hd.Id = hdct.IdHoaDon
                WHERE hd.TrangThai = 0
        """;
        ArrayList<HoaDonRepose> list = new ArrayList<>();
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                HoaDonRepose hdr = new HoaDonRepose();
                hdr.setId(rs.getInt(1));
                hdr.setMaHoaDon(rs.getString(2));
                hdr.setMaNhanVien(rs.getString(3));
                hdr.setTenNhanVien(rs.getString(4));
                hdr.setMaKhachHang(rs.getString(5));
                hdr.setTenKhachHang(rs.getString(6));
                hdr.setThanhTien(rs.getBigDecimal(7));
                hdr.setNgayThanhToan(rs.getDate(8));
                hdr.setTrangThai(rs.getInt(9));
                list.add(hdr);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<HoaDonRepose> search(String keyword) {
        String sql = """
                SELECT	
                	hd.Id,
                	hd.MaHoaDon,
                	nv.MaNhanVien,
                	nv.TenNhanVien,
                	kh.TenKhachHang,
                        (hdct.GiaDaThanhToan * hdct.SoLuong) AS ThanhTien , 
                	hd.NgayThanhToan, 
                	hd.TrangThai
                FROM HoaDon hd
                JOIN KhachHang kh ON hd.IdKhachHang = kh.Id
                JOIN NhanVien nv ON hd.IdNhanVien = nv.Id
                JOIN HoaDonChiTiet hdct ON hd.Id = hdct.IdHoaDon
        """;
        if (!keyword.isEmpty()) { // isempty
            sql += """
                WHERE (
                    hd.MaHoaDon LIKE ?
                    OR nv.MaNhanVien LIKE ?
                    OR nv.TenNhanVien LIKE ?
                    OR kh.TenKhachHang LIKE ?
                    OR (
                        CASE hd.TrangThai 
                        WHEN 1 THEN N'Đã thanh toán'            
                        WHEN 0 THEN N'Chưa thanh toán'
                        ELSE N'Không xác định'
                        END 
                        ) 
                    LIKE ?
                    )
                  """;
        }
        ArrayList<HoaDonRepose> list = new ArrayList<>();
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            if (keyword.length() > 0) {
                String value = "%" + keyword + "%";
                for (int i = 1; i <= 5; i++) {
                    ps.setString(i, value);
                }
            }
            System.out.println("SQL: " + ps.toString());
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    HoaDonRepose hd = new HoaDonRepose();
                    hd.setId(rs.getInt(1));
                    hd.setMaHoaDon(rs.getString(2));
                    hd.setMaNhanVien(rs.getString(3));
                    hd.setTenNhanVien(rs.getString(4));
                    hd.setTenKhachHang(rs.getString(5));
                    String raw = rs.getString(6);
                    raw = raw.replace(" đ", "");
                    BigDecimal thanhTien = new BigDecimal(raw);
                    hd.setThanhTien(thanhTien);
                    hd.setNgayThanhToan(rs.getDate(7));
                    hd.setTrangThai(rs.getInt(8));
                    list.add(hd);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public boolean add(HoaDon hd) {
        int check = 0;

        String sql = """
                       INSERT INTO HoaDon
                                 (IdKhachHang
                                 ,IdNhanVien
                                 ,IdVoucher
                                 ,TienDua
                                 ,ThanhTien
                                 ,NgayThanhToan
                                 ,TrangThai)
                           VALUES
                                 (?,?,?,?,?,?,?)
                    """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            // Object la cha cua cac loai kieu du lieu 
            ps.setObject(1, hd.getIdKhachHang());
            ps.setObject(2, hd.getIdNhanVien()); // Nhan vien lay tu login
            ps.setObject(3, hd.getIdVoucher());
            ps.setObject(4, 0);
            ps.setObject(5, 0);
            ps.setObject(6, new Date());
            ps.setObject(7, 0);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

        return check > 0;
    }
}
