package Entity;

import java.util.Objects;
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
public class ThuongHieu {
    private int  idThuongHieu;
    private String maThuongHieu;
    private String tenThuongHieu;
    private int trangThai;
    
    @Override
    public String toString() {
        return tenThuongHieu;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.idThuongHieu;
        hash = 31 * hash + (this.maThuongHieu != null ? this.maThuongHieu.hashCode() : 0);
        hash = 31 * hash + (this.tenThuongHieu != null ? this.tenThuongHieu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final ThuongHieu other = (ThuongHieu) obj;
        return this.idThuongHieu == other.idThuongHieu
                && Objects.equals(this.maThuongHieu, other.maThuongHieu)
                && Objects.equals(this.tenThuongHieu, other.tenThuongHieu);
    }
}
