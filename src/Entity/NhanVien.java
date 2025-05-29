/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.Date;
import lombok.*;
/**
 *
 * @author OS
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class NhanVien {
    private int id;
    private String MaNhanVien;
    private String TenNhanVien;
    private String diaChi;
    private String matKhau;
    private boolean gioiTinh;
    private String email;
    private String soDienThoai;
    private String chucVu;
    private Date NgayTao;
    private Date NgaySua;
    private String TrangThai;
}
