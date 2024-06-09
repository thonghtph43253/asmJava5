package com.fpoly.assignment.repository;

import com.fpoly.assignment.entity.MauSac;
import com.fpoly.assignment.entity.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhanVienRepo extends JpaRepository<NhanVien, Integer> {
  @Query("select nv from NhanVien nv where nv.ten like:s or nv.maNV like:s")
  public Page<NhanVien> findByTenContainingAndMaNVContaining(@Param("s")String s, Pageable pageable);
  @Query("select nv from NhanVien nv where nv.tenDangNhap =:user and nv.matKhau =:pass")
  public NhanVien login(@Param("user")String user, @Param("pass") String pass);
  @Query("select nv from NhanVien nv where nv.maNV =:ma or nv.tenDangNhap =:tendn")
  public List<NhanVien> findByMa(@Param("ma") String ma, @Param("tendn")String tendn);
}
