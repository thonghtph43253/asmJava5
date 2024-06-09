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
@Table(name = "mausac")
public class MauSac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Không để trống mã màu")
    private String ma;
    @NotBlank(message = "Không để trống tên màu")
    private String ten;
    @Column(name = "trangthai")
    private Integer trangThai;
}
