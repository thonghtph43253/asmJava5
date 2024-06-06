package com.fpoly.assignment.repository;

import com.fpoly.assignment.entity.SPChiTiet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SPChiTietRepo extends JpaRepository<SPChiTiet,Integer> {
  @Query("select spct from SPChiTiet  spct join SanPham  s on spct.sanPham.id= s.id where (spct.kichThuoc.ten like:s  or spct.mauSac.ten like:s or spct.sanPham.ten like:s )" +
          "and s.id =:id")
    public Page<SPChiTiet> findAllByKTandMSandIDSP(@Param("s")String search, @Param("id")Integer idsp, Pageable pageable);
  @Query("select count(s) > 0 from SPChiTiet s where s.kichThuoc.id =:id")
  public boolean existsByIDKichThuoc(@Param("id") Integer id);
}
