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
@Table(name = "sanpham")
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Vui lòng nhập mã sản phẩm")
    private String ma;
    @NotBlank(message = "Vui lòng nhập tên sản phẩm")
    private String ten;
    @Column(name = "trangthai")
    private boolean trangThai;

}
