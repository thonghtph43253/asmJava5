package com.fpoly.assignment.repository;

import com.fpoly.assignment.entity.KichThuoc;
import com.fpoly.assignment.entity.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MauSacRepo extends JpaRepository<MauSac,Integer> {
    public Page<MauSac> findByTenContaining(String ten, Pageable pageable);
    @Query("select m from MauSac m where m.ma =:ma")
    public MauSac findByMa(@Param("ma") String ma);
    @Query("select m from MauSac  m where m.trangThai=1 ")
    public List<MauSac> findHoatDong();
}
