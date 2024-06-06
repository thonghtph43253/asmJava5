//package com.fpoly.assignment.service;
//
//import com.fpoly.assignment.entity.HoaDon;
//import com.fpoly.assignment.entity.HoaDonChiTiet;
//import com.fpoly.assignment.entity.SPChiTiet;
//import com.fpoly.assignment.entity.SanPham;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//@Service
//public class HoaDonCTService {
//    private List<HoaDonChiTiet> list = new ArrayList<>();
//    public HoaDonCTService(){
//        list.add(new HoaDonChiTiet(1,1,1,2,40000.0,true));
//        list.add(new HoaDonChiTiet(2,1,2,2,40000.0,true));
//        list.add(new HoaDonChiTiet(3,1,3,2,40000.0,true));
//        list.add(new HoaDonChiTiet(4,1,4,2,40000.0,true));
//        list.add(new HoaDonChiTiet(5,2,1,2,40000.0,true));
//        list.add(new HoaDonChiTiet(6,2,2,2,40000.0,true));
//    }
//    public List<HoaDonChiTiet> getAll(){
//        return list;
//    }
//    public int getIDLast(){
//        return (list.size()+1);
//    }
//    public List<HoaDonChiTiet> getByPage(int page, int size, Integer idHd){
//
//        List<HoaDonChiTiet> listTen = new ArrayList<>();
//        for (HoaDonChiTiet kh:list) {
//            if(kh.getIdHoaDon() ==idHd){
//                listTen.add(kh);
//            }
//        }
//        int start = (page-1)* size;
//        int end = Math.min(start+size,listTen.size());
//        if(start>= listTen.size()){
//            return new ArrayList<>();
//        }
//        return listTen.subList(start,end);
//    }
//    public List<HoaDonChiTiet> getByPageSearch(int page, int size, String ten, Integer idhd){
//        List<HoaDonChiTiet> listTen = new ArrayList<>();
//        for (HoaDonChiTiet kh:list) {
//            if(kh.getId()== Integer.parseInt(ten)&&kh.getIdHoaDon() ==idhd){
//                listTen.add(kh);
//            }
//        }
//        int start = (page-1)* size;
//        int end = Math.min(start+size,listTen.size());
//        if(start>= listTen.size()){
//            return new ArrayList<>();
//        }
//        return listTen.subList(start,end);
//    }
//    public int getSotrang(int size,Integer idhd){
//        List<HoaDonChiTiet> listTen = new ArrayList<>();
//        for (HoaDonChiTiet kh:list) {
//            if( kh.getIdHoaDon() == idhd){
//                listTen.add(kh);
//            }
//        }
//        return (int)Math.ceil((double) listTen.size()/size);
//    }
//    public int getSotrangSearch(int size, String ten, Integer idhd){
//        List<HoaDonChiTiet> listTen = new ArrayList<>();
//        for (HoaDonChiTiet kh:list) {
//            if(kh.getId()== Integer.parseInt(ten)&& kh.getIdHoaDon() == idhd){
//                listTen.add(kh);
//            }
//        }
//        return (int)Math.ceil((double) listTen.size()/size);
//    }
//    public static String getThongTinSanPham(Integer id){
//        SanPhamCTService spctService = new SanPhamCTService();
//        for (SPChiTiet spct:spctService.getAll()) {
//            if(spct.getId()==id){
//                return SanPhamCTService.getTenSanPham(spct.getIdSanPham())+";"+
//                        SanPhamCTService.getTenMauSac(spct.getIdMauSac())+";"+
//                        SanPhamCTService.getTenKichThuoc(spct.getIdKichThuoc());
//            }
//        }
//        return "";
//    }
//    public Double getTongTien(Integer idhd){
//        double tong=0;
//        for (HoaDonChiTiet hdct:list) {
//            if(hdct.getIdHoaDon() == idhd){
//                tong+=hdct.getDonGia()*hdct.getSoLuong();
//            }
//        }
//        return tong;
//    }
//    public void update(HoaDonChiTiet hdctU){
//        for (int i =0; i< list.size();i++) {
//            if(list.get(i).getId() == hdctU.getId()){
//                list.set(i,hdctU);
//            }
//        }
//    }
//    public HoaDonChiTiet findByID(Integer id){
//        for (HoaDonChiTiet hdct: list) {
//            if(hdct.getId() ==id){
//                return hdct;
//            }
//        }
//        return null;
//    }
//    public void add(HoaDonChiTiet hdct){
//        hdct.setId(getIDLast());
//        list.add(hdct);
//    }
//}
