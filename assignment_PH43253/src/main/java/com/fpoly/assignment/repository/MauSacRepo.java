package com.fpoly.assignment.repository;

import com.fpoly.assignment.entity.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MauSacRepo extends JpaRepository<MauSac,Integer> {
    public Page<MauSac> findByTenContaining(String ten, Pageable pageable);
}
