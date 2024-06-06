package com.fpoly.assignment.service;

import com.fpoly.assignment.entity.KhachHang;
import com.fpoly.assignment.entity.KichThuoc;
import com.fpoly.assignment.entity.SanPham;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class KichThuocService {
    private List<KichThuoc> list  = new ArrayList<>();
    public KichThuocService(){
        list.add(new KichThuoc(1,"KT01","S",true));
        list.add(new KichThuoc(2,"KT02","M",true));
        list.add(new KichThuoc(3,"KT03","L",true));
        list.add(new KichThuoc(4,"KT04","XL",true));
    }
    public List<KichThuoc> getAll(){
        return list;
    }
    public int getIDLast(){
        return (list.size()+2);
    }
    public List<KichThuoc> getKichThuocByPage(int page, int size, String ten){
        List<KichThuoc> listTen = new ArrayList<>();
        for (KichThuoc kh:list) {
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
        List<KichThuoc> listTen = new ArrayList<>();
        for (KichThuoc kh:list) {
            if(kh.getTen().toLowerCase().contains(ten.toLowerCase())){
                listTen.add(kh);
            }
        }
        return (int)Math.ceil((double) listTen.size()/size);
    }
    public void add(KichThuoc kt){
        if (check(kt.getMa())!=null){
            return;
        }
        kt.setId(getIDLast());
        list.add(kt);
    }
    public KichThuoc findById(Integer id){
        for (KichThuoc kt:list) {
            if(kt.getId()== id){
                return kt;
            }
        }
        return null;
    }
    public void update(KichThuoc kh){
        for (int i = 0; i<list.size();i++){
            if(list.get(i).getId()== kh.getId()){
                list.set(i,kh);
                break;
            }
        }
    }
    public void delete(Integer id){
        List<KichThuoc> listDl = new ArrayList<>();
        listDl.add(findById(id));
        list.removeAll(listDl);
    }
    public KichThuoc check(String ma){
        for (KichThuoc sp:list) {
            if(sp.getMa().equals(ma)){
                return sp;
            }
        }
        return null;
    }
}
