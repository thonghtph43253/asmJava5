package com.fpoly.assignment.repository;

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
  public Page<NhanVien> findByTenContaining(String ten, Pageable pageable);
  @Query("select nv from NhanVien nv where nv.tenDangNhap =:user and nv.matKhau =:pass")
  public NhanVien login(@Param("user")String user, @Param("pass") String pass);
}
