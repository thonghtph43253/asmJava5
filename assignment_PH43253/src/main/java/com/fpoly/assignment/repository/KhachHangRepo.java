package com.fpoly.assignment.repository;

import com.fpoly.assignment.entity.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhachHangRepo extends JpaRepository<KhachHang,Integer> {
    public Page<KhachHang> findByTenContaining(String ten, Pageable pageable);
}
