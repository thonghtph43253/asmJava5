package com.fpoly.assignment.service;

import com.fpoly.assignment.entity.MauSac;
import com.fpoly.assignment.entity.SanPham;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SanPhamService {
    private List<SanPham> list  = new ArrayList<>();
    public SanPhamService(){
        list.add(new SanPham(1,"SP01","Áo sơ mi haha",true));
        list.add(new SanPham(2,"SP02","Áo phông vui ",true));
        list.add(new SanPham(3,"SP03","Quần âu",true));
        list.add(new SanPham(4,"SP04","Quần short",true));
    }
    public List<SanPham> getAll(){
        return list;
    }
    public int getIDLast(){
        return (list.size()+1);
    }
    public List<SanPham> getByPage(int page, int size, String ten){
        List<SanPham> listTen = new ArrayList<>();
        for (SanPham kh:list) {
            if(kh.getTen().toLowerCase().contains(ten.toLowerCase())){
                listTen.add(kh);
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
        List<SanPham> listTen = new ArrayList<>();
        for (SanPham kh:list) {
            if(kh.getTen().toLowerCase().contains(ten.toLowerCase())){
                listTen.add(kh);
            }
        }
        return (int)Math.ceil((double) listTen.size()/size);
    }
    public void add(SanPham kt){
        if(check(kt.getMa())!=null){
            return;
        }
        kt.setId(getIDLast());
        list.add(kt);
    }
    public SanPham findById(Integer id){
        for (SanPham kt:list) {
            if(kt.getId()== id){
                return kt;
            }
        }
        return null;
    }
    public void update(SanPham kh){
        for (int i = 0; i<list.size();i++){
            if(list.get(i).getId()== kh.getId()){
                list.set(i,kh);
                break;
            }
        }
    }
    public void delete(Integer id){
        List<SanPham> listDl = new ArrayList<>();
        listDl.add(findById(id));
        list.removeAll(listDl);
    }
    public SanPham check(String ma){
        for (SanPham sp:list) {
            if(sp.getMa().equals(ma)){
                return sp;
            }
        }
        return null;
    }
}
