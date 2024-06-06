package com.fpoly.assignment.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "spchitiet")
public class SPChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Không để trống mã sản phẩm chi tiết")
    private String maSPCT;
    @ManyToOne
    @JoinColumn(name = "idkichthuoc",referencedColumnName = "id")
    private KichThuoc kichThuoc;
    @ManyToOne
    @JoinColumn(name = "idmausac",referencedColumnName = "id")
    private MauSac mauSac;
    @ManyToOne
    @JoinColumn(name = "idsanpham",referencedColumnName = "id")
    private SanPham sanPham;
    @NotNull(message = "Không để trống số lượng")
    @Min(value = 0,message = "Số lượng phải lớn hơn 0")
    @Column(name = "soluong")
    private Integer soLuong;
    @NotNull(message = "Không để trống đon giá")
    @DecimalMin(value ="0" ,message = "Đơn giá phải lớn hơn 0")
    @Column(name = "dongia")
    private Double donGia;
    @Column(name = "trangthai")
    private boolean trangThai;
//    public String getTenSP(){
//        return SanPhamCTService.getTenSanPham(this.idSanPham);
//    }
//    public String getThongTinSP(){
//        return SanPhamCTService.getTenSanPham(this.idSanPham)
//                +" "+SanPhamCTService.getTenKichThuoc(this.idKichThuoc)
//                +" "+SanPhamCTService.getTenMauSac(this.idMauSac);
//    }
//    public String getTenMS(){
//        return SanPhamCTService.getTenMauSac(this.idMauSac);
//    }
//    public String getTenKT(){
//        return SanPhamCTService.getTenKichThuoc(this.idKichThuoc);
//    }

}
