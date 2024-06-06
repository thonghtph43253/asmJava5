package com.fpoly.assignment.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "khachhang")
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Không để trống tên khách hàng")
    private String ten;
    @NotBlank(message = "Không để trống số điện thoại")
    @Pattern(regexp ="0+\\d{9}",message = "Số điện thoại không đúng định dạng")
    private String sdt;
    @NotBlank(message = "Không để trống mã khách hàng")
    private String maKH;
    @Column(name = "trangthai")
    private boolean trangThai;
}
