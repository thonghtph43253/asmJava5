package com.fpoly.assignment.entity;

//import com.fpoly.assignment.service.HoaDonService;
import com.fpoly.assignment.service.NhanVienService;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "hoadon")
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "idnhanvien",referencedColumnName = "id")
    private NhanVien nhanVien;
    @ManyToOne
    @JoinColumn(name = "idkhachhang",referencedColumnName = "id")
    private KhachHang khachHang;
    @Column(name = "ngaymuahang")
    private LocalDateTime ngayMuaHang;
    @Column(name = "trangthai")
    private boolean trangThai;
//    public String getTenNhanVien(){return HoaDonService.getTenNhanVien(this.idNhanVien);}
//    public String getTenKhachHang(){return HoaDonService.getTenKhachHang(this.idKhachHang);}
//    public String getsdt(){return HoaDonService.getSDTKhachHang(this.idKhachHang);}

}
