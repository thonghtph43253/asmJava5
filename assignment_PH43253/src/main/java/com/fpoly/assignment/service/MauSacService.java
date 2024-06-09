//package com.fpoly.assignment.service;
//
//import com.fpoly.assignment.entity.KichThuoc;
//import com.fpoly.assignment.entity.MauSac;
//import com.fpoly.assignment.entity.SanPham;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//@Service
//public class MauSacService {
//    private List<MauSac> list  = new ArrayList<>();
//    public MauSacService(){
//        list.add(new MauSac(1,"MS01","Đen",true));
//        list.add(new MauSac(2,"MS02","Xanh",true));
//        list.add(new MauSac(3,"MS03","Trắng",true));
//        list.add(new MauSac(4,"MS04","Đỏ",true));
//    }
//    public List<MauSac> getAll(){
//        return list;
//    }
//    public int getIDLast(){
//        return (list.size()+1);
//    }
//    public List<MauSac> getByPage(int page, int size, String ten){
//        List<MauSac> listTen = new ArrayList<>();
//        for (MauSac kh:list) {
//            if(kh.getTen().toLowerCase().contains(ten.toLowerCase())){
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
//    public int getSotrang(int size, String ten){
//        List<MauSac> listTen = new ArrayList<>();
//        for (MauSac kh:list) {
//            if(kh.getTen().toLowerCase().contains(ten.toLowerCase())){
//                listTen.add(kh);
//            }
//        }
//        return (int)Math.ceil((double) listTen.size()/size);
//    }
//    public void add(MauSac kt){
//        if (check(kt.getMa())!=null){
//            return;
//        }
//        kt.setId(getIDLast());
//        list.add(kt);
//    }
//    public MauSac findById(Integer id){
//        for (MauSac kt:list) {
//            if(kt.getId()== id){
//                return kt;
//            }
//        }
//        return null;
//    }
//    public void update(MauSac kh){
//        for (int i = 0; i<list.size();i++){
//            if(list.get(i).getId()== kh.getId()){
//                list.set(i,kh);
//                break;
//            }
//        }
//    }
//    public void delete(Integer id){
//        List<MauSac> listDl = new ArrayList<>();
//        listDl.add(findById(id));
//        list.removeAll(listDl);
//    }
//    public MauSac check(String ma){
//        for (MauSac sp:list) {
//            if(sp.getMa().equals(ma)){
//                return sp;
//            }
//        }
//        return null;
//    }
//}
