//package com.fpoly.assignment.service;
//
//import com.fpoly.assignment.entity.HoaDon;
//import com.fpoly.assignment.entity.KhachHang;
//import com.fpoly.assignment.entity.NhanVien;
//import com.fpoly.assignment.entity.SanPham;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//@Service
//public class HoaDonService {
//    private List<HoaDon> list  = new ArrayList<>();
//    public HoaDonService(){
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
//        list.add(new HoaDon(1,1,1, LocalDateTime.parse("25/05/2024 14:30:00",formatter),true));
//        list.add(new HoaDon(2,2,2, LocalDateTime.parse("23/05/2024 14:30:00",formatter),true));
//        list.add(new HoaDon(3,3,3, LocalDateTime.parse("25/05/2024 15:30:00",formatter),true));
//        list.add(new HoaDon(4,4,4, LocalDateTime.parse("21/05/2024 14:30:00",formatter),true));
//        list.add(new HoaDon(5,1,1, LocalDateTime.parse("20/05/2024 14:30:00",formatter),true));
//        list.add(new HoaDon(6,1,1, LocalDateTime.parse("26/05/2024 14:30:00",formatter),true));
//        list.add(new HoaDon(7,1,1, LocalDateTime.parse("22/05/2024 14:30:00",formatter),false));
//
//    }
//    public List<HoaDon> getAll(){
//        return list;
//    }
//    public int getIDLast(){
//        return (list.size()+1);
//    }
//    public List<HoaDon> getByPage(int page, int size){
//
//        int start = (page-1)* size;
//        int end = Math.min(start+size,list.size());
//        if(start>= list.size()){
//            return new ArrayList<>();
//        }
//        return list.subList(start,end);
//    }
//    public List<HoaDon> getByPageSearch(int page, int size, String ten){
//        List<HoaDon> listTen = new ArrayList<>();
//        for (HoaDon kh:list) {
//            if(kh.getId()== Integer.parseInt(ten)){
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
//    public int getSotrang(int size){
//
//        return (int)Math.ceil((double) list.size()/size);
//    }
//    public int getSotrangSearch(int size, String ten){
//        List<HoaDon> listTen = new ArrayList<>();
//        for (HoaDon kh:list) {
//            if(kh.getId()== Integer.parseInt(ten)){
//                listTen.add(kh);
//            }
//        }
//        return (int)Math.ceil((double) listTen.size()/size);
//    }
//    public void add(HoaDon kt){
//        kt.setId(getIDLast());
//        LocalDateTime now = LocalDateTime.now();
//        kt.setNgayMuaHang(now);
//        list.add(kt);
//    }
//    public HoaDon findById(Integer id){
//        for (HoaDon kt:list) {
//            if(kt.getId()== id){
//                return kt;
//            }
//        }
//        return null;
//    }
//    public void update(HoaDon kh){
//        for (int i = 0; i<list.size();i++){
//            if(list.get(i).getId()== kh.getId()){
//                list.set(i,kh);
//                break;
//            }
//        }
//    }
//    public void delete(Integer id){
//        List<HoaDon> listDl = new ArrayList<>();
//        listDl.add(findById(id));
//        list.removeAll(listDl);
//    }
//    public static String getTenNhanVien(Integer id){
//        NhanVienService nvService = new NhanVienService();
//        for (NhanVien nv: nvService.getAll() ) {
//            if(nv.getId()==id){
//                return nv.getTen();
//            }
//        }
//        return "";
//    }
//    public static String getTenKhachHang(Integer id){
//        KhachHangService khService = new KhachHangService();
//        for (KhachHang kh: khService.getAll() ) {
//            if(kh.getId()==id){
//                return kh.getTen();
//            }
//        }
//        return "";
//    }
//    public static String getSDTKhachHang(Integer id){
//        KhachHangService khService = new KhachHangService();
//        for (KhachHang kh: khService.getAll() ) {
//            if(kh.getId()==id){
//                return kh.getSdt();
//            }
//        }
//        return "";
//    }
//    public Integer getIDHoaDonLast(){
//        HoaDon hd = list.get(list.size()-1);
//        return hd.getId();
//    }
//}
