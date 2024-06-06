//package com.fpoly.assignment.service;
//
//import com.fpoly.assignment.entity.KichThuoc;
//import com.fpoly.assignment.entity.MauSac;
//import com.fpoly.assignment.entity.SPChiTiet;
//import com.fpoly.assignment.entity.SanPham;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//@Service
//public class SanPhamCTService {
//    private List<SPChiTiet> list  = new ArrayList<>();
//
//    public SanPhamCTService(){
//        list.add(new SPChiTiet(1,"Spct01",1,1,1,10,40000.0,true));
//        list.add(new SPChiTiet(2,"Spct02",2,3,1,12,30000.0,true));
//        list.add(new SPChiTiet(3,"Spct03",3,2,1,16,50000.0,true));
//        list.add(new SPChiTiet(4,"Spct04",4,1,1,12,80000.0,true));
//        list.add(new SPChiTiet(5,"Spct05",1,1,1,8,99000.0,true));
//        list.add(new SPChiTiet(6,"Spct06",1,1,2,6,60000.0,true));
//
//    }
//    public List<SPChiTiet> getAll(){
//        return list;
//    }
//    public int getIDLast(){
//        return (list.size()+1);
//    }
//    public List<SPChiTiet> getByPage(int page, int size, String ten, Integer idSP){
//        List<SPChiTiet> listTen = new ArrayList<>();
//        for (SPChiTiet kh:list) {
//            if((kh.getMaSPCT().toLowerCase().contains(ten.toLowerCase()))&&
//            kh.getIdSanPham()== idSP){
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
//    public int getSotrang(int size, String ten, Integer idSP){
//        List<SPChiTiet> listTen = new ArrayList<>();
//        for (SPChiTiet kh:list) {
//            if(kh.getMaSPCT().toLowerCase().contains(ten.toLowerCase())
//                    &&
//                    kh.getIdSanPham()== idSP){
//                listTen.add(kh);
//            }
//        }
//        return (int)Math.ceil((double) listTen.size()/size);
//    }
//    public List<SPChiTiet> getByPageAll(int page, int size, String ten){
//        List<SPChiTiet> listTen = new ArrayList<>();
//        for (SPChiTiet kh:list) {
//            if((kh.getMaSPCT().toLowerCase().contains(ten.toLowerCase()))){
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
//    public int getSotrangAll(int size, String ten){
//        List<SPChiTiet> listTen = new ArrayList<>();
//        for (SPChiTiet kh:list) {
//            if(kh.getMaSPCT().toLowerCase().contains(ten.toLowerCase())){
//                listTen.add(kh);
//            }
//        }
//        return (int)Math.ceil((double) listTen.size()/size);
//    }
//    public void add(SPChiTiet kt){
//        SPChiTiet spct = checkTrungSPCT(kt);
//        if(spct != null){
//            kt.setId(spct.getId());
//            kt.setMaSPCT(spct.getMaSPCT());
//            update(kt);
//            return;
//        }
//        kt.setId(getIDLast());
//
//        list.add(kt);
//    }
//    public SPChiTiet findById(Integer id){
//        for (SPChiTiet kt:list) {
//            if(kt.getId()== id){
//                return kt;
//            }
//        }
//        return null;
//    }
//    public void update(SPChiTiet kh){
//        for (int i = 0; i<list.size();i++){
//            if(list.get(i).getId()== kh.getId()){
//                list.set(i,kh);
//                break;
//            }
//        }
//    }
//    public void delete(Integer id){
//        List<SPChiTiet> listDl = new ArrayList<>();
//        listDl.add(findById(id));
//        list.removeAll(listDl);
//    }
//    public static String getTenSanPham(Integer id){
//        SanPhamService spService = new SanPhamService();
//
//        for (SanPham sp :spService.getAll()) {
//            if(sp.getId()==id){
//                return sp.getTen();
//            }
//        }
//        return "";
//    }
//    public static String getTenMauSac(Integer id){
//        MauSacService msService = new MauSacService();
//        for (MauSac ms :msService.getAll()) {
//            if(ms.getId()==id){
//                return ms.getTen();
//            }
//        }
//        return "";
//    }
//    public static String getTenKichThuoc(Integer id){
//
//        KichThuocService ktService  = new KichThuocService();
//        for (KichThuoc kt :ktService.getAll()) {
//            if(kt.getId()==id){
//                return kt.getTen();
//            }
//        }
//        return "";
//    }
//
//
//    public SPChiTiet checkTrungSPCT(SPChiTiet spct){
//        for (SPChiTiet spctC: list) {
//            if(spctC.getMaSPCT().equals(spct.getMaSPCT())||
//                    (spctC.getIdMauSac()==spct.getIdMauSac())&&
//                            (spctC.getIdKichThuoc()==spct.getIdKichThuoc())){
//                return spctC;
//            }
//        }
//        return null;
//    }
//    public void updateSoLuong(Integer idspct, Integer soLuongMua){
//        for (SPChiTiet spct:list) {
//            if(spct.getId() == idspct){
//                spct.setSoLuong(spct.getSoLuong()-soLuongMua);
//                update(spct);
//            }
//        }
//    }
//}
