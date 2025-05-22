package Entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KhachHang {

    private int id;
    private String maKhachHang;
    private String tenKhachHang;
    private boolean gioiTinh;
    private String soDienThoai;
    private String diaChi;
    private Date ngayTao;
    private int trangThai;  // 0 = Không hoạt động, 1 = Hoạt động
}
