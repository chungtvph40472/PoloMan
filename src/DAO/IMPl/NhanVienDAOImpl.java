/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.IMPl;

import DAO.NhanVienDAO;
import Entity.NhanVien;
import util.XJdbc;
import java.util.List;
import util.XQuery;



/**
 *
 * @author OS
 */
public class NhanVienDAOImpl implements NhanVienDAO {
    private String SQLGetALL="select * from NhanVien";
    String createSql = "INSERT INTO NhanVien (TenNhanVien, DiaChi, MatKhau, GioiTinh,Email, SoDienThoai, ChucVu, NgayTao, NgaySua, TrangThai)	VALUES (?,?,?,?,?,?,?,?,?,?)";
    String updateSql = "update NhanVien set TenNhanVien = ?,DiaChi= ?,MatKhau= ?,GioiTinh= ?,Email= ?,SoDienThoai= ?,ChucVu= ?,TrangThai = ? where MaNhanVien = ?";
    String deleteSql = "delete NhanVien where MaNhanVien = ?";
    String findAllSql = "…";
    String findByIdSql = "…";

    @Override
    public NhanVien create(NhanVien entity) {
        Object[] values ={
//        entity.getMaNhanVien(),
        entity.getTenNhanVien(),
        entity.getDiaChi(),
        entity.getMatKhau(),
        entity.isGioiTinh(),
        entity.getEmail(),
        entity.getSoDienThoai(),
        entity.getChucVu(),
        entity.getNgayTao(),
        entity.getNgaySua(),
        entity.getTrangThai(),};
        XJdbc.executeUpdate(createSql, values);
        return entity;
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(NhanVien entity) {
        Object[] values ={
        entity.getTenNhanVien(),
        entity.getDiaChi(),
        entity.getMatKhau(),
        entity.isGioiTinh(),
        entity.getEmail(),
        entity.getSoDienThoai(),
        entity.getChucVu(),
        entity.getTrangThai(),
        entity.getMaNhanVien(),};
        XJdbc.executeUpdate(updateSql, values);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteById(String id) {
        XJdbc.executeUpdate(deleteSql, id);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<NhanVien> findAll() {
        return XQuery.getBeanList(NhanVien.class, SQLGetALL);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public NhanVien findById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
