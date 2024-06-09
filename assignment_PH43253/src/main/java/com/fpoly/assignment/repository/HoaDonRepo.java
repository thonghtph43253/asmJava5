package com.fpoly.assignment.repository;

import com.fpoly.assignment.entity.HoaDon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HoaDonRepo extends JpaRepository<HoaDon,Integer> {
    @Query("select h from HoaDon h join KhachHang k on h.khachHang.id = k.id " +
            "join NhanVien n  on h.nhanVien.id = n.id where k.ten like:name or n.ten like:name")
    public Page<HoaDon> findAllByNameKHAndNV(@Param("name") String name, Pageable pageable);
    @Query(value = "select top 1 h.id from HoaDon h order by h.id desc ", nativeQuery = true)
    public Integer getIDHDLast();
    @Query("select count(s) > 0 from HoaDon s where s.khachHang.id =:id")
    public boolean existsByIDKhachHang(@Param("id") Integer id);
    @Query("select count(s) > 0 from HoaDon s where s.nhanVien.id =:id")
    public boolean existsByIDNhanVien(@Param("id") Integer id);
}
