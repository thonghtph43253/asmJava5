package com.fpoly.assignment.service;

import com.fpoly.assignment.entity.NhanVien;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NhanVienService {
    private List<NhanVien> list = new ArrayList<>();
    public NhanVienService(){
        list.add(new NhanVien(1,"Admin","admin","admin","admin123456",true,true));
        list.add(new NhanVien(2,"Hoang Trung Thong","thonght","thonght","thong2105",true,true));
        list.add(new NhanVien(3,"Nguyen Thi A","ant","ant","123456",false,true));
        list.add(new NhanVien(4,"Nguyen Van C","cnv","cnv","123456",false,true));
        list.add(new NhanVien(5,"Nhan vien","nv","nv1","123456",false,true));
        list.add(new NhanVien(6,"Nhan vien","nv","nv2","123456",false,true));
    }
    public List<NhanVien> getAll(){
        return list;
    }
    public int getIDLast(){
        return (list.size()+1);
    }
    public List<NhanVien> getNhanVienByPage(int page, int size,String ten){
        List<NhanVien> listTen = new ArrayList<>();
        for (NhanVien nv:list) {
            if(nv.getTen().toLowerCase().contains(ten.toLowerCase())){
                listTen.add(nv);
            }
        }
        int start = (page-1)* size;
        int end = Math.min(start+size,listTen.size());
        if(start>= listTen.size()){
            return new ArrayList<>();
        }
        return listTen.subList(start,end);
    }
    public int getSotrang(int size, String ten){
        List<NhanVien> listTen = new ArrayList<>();
        for (NhanVien nv:list) {
            if(nv.getTen().toLowerCase().contains(ten.toLowerCase())){
                listTen.add(nv);
            }
        }
        return (int)Math.ceil((double) listTen.size()/size);
    }
    public void add(NhanVien nv){
        if(check(nv.getMaNV())!=null){
            return;
        }
        nv.setId(getIDLast());
        list.add(nv);
    }
    public NhanVien findByID(Integer id){
        for (NhanVien nv:list) {
            if(nv.getId()== id){
                return nv;
            }
        }
        return null;
    }
    public void update(NhanVien nv){
        for (int i = 0; i< list.size();i++){
            if(list.get(i).getId() == nv.getId()){
                list.set(i, nv);
                break;
            }
        }
    }
    public void delete(Integer id){
        List<NhanVien> listDl = new ArrayList<>();
        listDl.add(findByID(id));
        list.removeAll(listDl);
    }
    public NhanVien login(String user, String pass){
        for (NhanVien nv:list) {
            if(nv.getTenDangNhap().equals(user)&& nv.getMatKhau().equals(pass)&&nv.isTrangThai()){
                return  nv;
            }
        }
        return null;
    }
    public NhanVien check(String ma){
        for (NhanVien nv: list) {
            if(nv.getMaNV().equalsIgnoreCase(ma)){
                return nv;
            }
        }
        return null;
    }
}
