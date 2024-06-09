package com.fpoly.assignment.repository;

import com.fpoly.assignment.entity.MauSac;
import com.fpoly.assignment.entity.SPChiTiet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SPChiTietRepo extends JpaRepository<SPChiTiet,Integer> {
  @Query("select spct from SPChiTiet  spct join SanPham  s on spct.sanPham.id= s.id where (spct.kichThuoc.ten like:s  or spct.mauSac.ten like:s or spct.sanPham.ten like:s )" +
          "and s.id =:id")
    public Page<SPChiTiet> findAllByKTandMSandIDSP(@Param("s")String search, @Param("id")Integer idsp, Pageable pageable);
  @Query("select count(s) > 0 from SPChiTiet s where s.kichThuoc.id =:id")
  public boolean existsByIDKichThuoc(@Param("id") Integer id);
  @Query("select count(s) > 0 from SPChiTiet s where s.mauSac.id =:id")
  public boolean existsByIDMauSac(@Param("id") Integer id);
  @Query("select count(s) > 0 from SPChiTiet s where s.sanPham.id =:id")
  public boolean existsByIDSanPham(@Param("id") Integer id);
  @Query("select spct from SPChiTiet  spct where spct.sanPham.id =:idsp and (spct.maSPCT =:ma or(spct.mauSac.id =:idms and spct.kichThuoc.id =:idkt))")
  public List<SPChiTiet> getByMaAndIDMSAndIDKT(@Param("ma")String ma,@Param("idms")Integer idms,@Param("idkt")Integer idkt,@Param("idsp") Integer idsp);
  @Query("select spct from SPChiTiet  spct join SanPham  s on spct.sanPham.id= s.id where spct.sanPham.id =:id")
  public List<SPChiTiet> findAllByIdSP( @Param("id")Integer idsp);
  @Query("select m from SPChiTiet m where m.trangThai=1 and m.soLuong>0 ")
  public List<SPChiTiet> findHoatDong();

}
