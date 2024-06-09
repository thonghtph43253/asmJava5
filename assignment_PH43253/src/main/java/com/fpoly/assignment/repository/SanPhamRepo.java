package com.fpoly.assignment.repository;

import com.fpoly.assignment.entity.MauSac;
import com.fpoly.assignment.entity.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SanPhamRepo extends JpaRepository<SanPham,Integer> {
    public Page<SanPham> findByTenContaining(String ten, Pageable pageable);
    @Query("select sp from SanPham sp where sp.ma =:ma")
    public SanPham findByMa(@Param("ma") String ma);
}
