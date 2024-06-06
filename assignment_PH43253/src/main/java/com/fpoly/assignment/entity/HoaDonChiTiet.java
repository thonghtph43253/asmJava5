package com.fpoly.assignment.entity;

//import com.fpoly.assignment.service.HoaDonCTService;
//import com.fpoly.assignment.service.SanPhamCTService;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "hoadonchitiet")
public class HoaDonChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "idhoadon",referencedColumnName = "id")
    private HoaDon hoaDon;
    @ManyToOne
    @JoinColumn(name = "idspct",referencedColumnName = "id")
    private SPChiTiet spChiTiet;
    @Column(name = "soluong")
    private Integer soLuong;
    @Column(name = "dongia")
    private Double donGia;
    @Column(name = "trangthai")
    private boolean trangThai;
   public String getThongTinSP(){
       return spChiTiet.getSanPham().getTen()+","+spChiTiet.getKichThuoc().getTen()+","+spChiTiet.getMauSac().getTen();
   }
}
