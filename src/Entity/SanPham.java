package Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SanPham {
    private int idSanPham;
    private int idThuongHieu;
    private String maSanPham;
    private String tenSanPham;
    private int soLuong;
    private int trangThai;
}
