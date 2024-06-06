package com.fpoly.assignment.repository;

import com.fpoly.assignment.entity.HoaDonChiTiet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HoaDonChiTietRepo extends JpaRepository<HoaDonChiTiet,Integer> {
    @Query("select hdct from HoaDonChiTiet  hdct join HoaDon  hd on hdct.hoaDon.id =hd.id join SPChiTiet spct on hdct.spChiTiet.id = spct.id where hd.id =:id " +
            "and spct.mauSac.ten like:s and spct.kichThuoc.ten like:s and spct.sanPham.ten like:s")
    public Page<HoaDonChiTiet> findByIDHDandSPandKTandMs(@Param("s")String s, @Param("id")Integer idhd, Pageable pageable);
    @Query("select sum(hdct.donGia*hdct.soLuong) from HoaDonChiTiet hdct join HoaDon hd on hdct.hoaDon.id = hd.id where hd.id =:id")
    public Double getTongTien(@Param("id") Integer idhd);
}
