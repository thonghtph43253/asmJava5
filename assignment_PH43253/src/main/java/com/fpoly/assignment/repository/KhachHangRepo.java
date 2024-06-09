package com.fpoly.assignment.repository;

import com.fpoly.assignment.entity.KhachHang;
import com.fpoly.assignment.entity.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KhachHangRepo extends JpaRepository<KhachHang,Integer> {
    @Query("select kh from KhachHang kh where kh.ten like:s or kh.sdt like:s")
    public Page<KhachHang> findByTenContainingAndSdtContaining(@Param("s")String s, Pageable pageable);
    @Query("select kh from KhachHang kh where kh.maKH =:ma or kh.sdt=:sdt")
    public List<KhachHang> findByMa(@Param("ma") String ma, @Param("sdt")String sdt);
}
