package com.fpoly.assignment.repository;

import com.fpoly.assignment.entity.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SanPhamRepo extends JpaRepository<SanPham,Integer> {
    public Page<SanPham> findByTenContaining(String ten, Pageable pageable);
}
