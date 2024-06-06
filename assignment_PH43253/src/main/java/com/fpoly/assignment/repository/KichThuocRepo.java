package com.fpoly.assignment.repository;

import com.fpoly.assignment.entity.KhachHang;
import com.fpoly.assignment.entity.KichThuoc;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface KichThuocRepo extends JpaRepository<KichThuoc,Integer> {
    public Page<KichThuoc> findByTenContaining(String ten, Pageable pageable);
    @Query("select k from KichThuoc k where k.ma =:ma")
    public KichThuoc findByMa(@Param("ma") String ma);
//    @Modifying
//    @Transactional
//    @Query("UPDATE KichThuoc k SET k.trangThai = 0 WHERE k.id = :id")
//    public void deactivateKichThuoc(@Param("id") Integer id);
}
