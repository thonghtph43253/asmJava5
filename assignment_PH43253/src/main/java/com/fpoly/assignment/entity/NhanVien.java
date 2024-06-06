package com.fpoly.assignment.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "nhanvien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "ten")
    @NotBlank(message = "Không để trống tên")
    private String ten;
    @Column(name = "manv")
    @NotBlank(message = "Không để trống mã nhân viên")
    private String maNV;
    @Column(name = "tendangnhap")
    @NotBlank(message = "Không để trống mã tên đăng nhập")
    private String tenDangNhap;
    @Column(name = "matkhau")
    @NotBlank(message = "Không để trống mã mật khẩu")
    private String matKhau;
    @Column(name = "vaitro")
    private boolean vaiTro;
    @Column(name = "trangthai")
    private boolean trangThai;
}
