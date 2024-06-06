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
@Table(name = "kichthuoc")
public class KichThuoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Không để trống mã kích thước")
    private String ma;
    @NotBlank(message = "Không để trống tên kích thước")
    private String ten;
    @Column(name = "trangthai")
    private boolean trangThai;
}
