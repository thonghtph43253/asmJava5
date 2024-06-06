package com.fpoly.assignment.service;

import com.fpoly.assignment.entity.KhachHang;
import com.fpoly.assignment.entity.NhanVien;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KhachHangService {
    private List<KhachHang> list = new ArrayList<>();
    public KhachHangService(){
        list.add(new KhachHang(1,"Cu Tí","0333366688","TiN",true));
        list.add(new KhachHang(2,"Cu Tèo","0333366699","TeoN",true));
        list.add(new KhachHang(3,"Cu Bin","0333366600","Bin",true));
        list.add(new KhachHang(4,"A Phò","0333366633","GAP",true));
        list.add(new KhachHang(5,"A Lử","0333366622","GAL",true));
        list.add(new KhachHang(6,"Tạ Biên Giới","0399366688","TBG",true));
    }
    public List<KhachHang> getAll(){
        return list;
    }
    public int getIDLast(){
        return (list.size()+1);
    }
    public List<KhachHang> getKhachHangByPage(int page, int size, String ten){
        List<KhachHang> listTen = new ArrayList<>();
        for (KhachHang kh:list) {
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
        List<KhachHang> listTen = new ArrayList<>();
        for (KhachHang kh:list) {
            if(kh.getTen().toLowerCase().contains(ten.toLowerCase())){
                listTen.add(kh);
            }
        }
        return (int)Math.ceil((double) listTen.size()/size);
    }
    public void add(KhachHang kh){
        if (check(kh.getMaKH(), kh.getSdt())!=null){
            return;
        }
        kh.setId(getIDLast());
        list.add(kh);

    }
    public KhachHang findById(Integer id){
        for (KhachHang kh:list) {
            if(kh.getId() == id){
                return kh;
            }
        }
        return null;
    }
    public void update(KhachHang kh){
        for (int i = 0; i<list.size();i++){
            if(list.get(i).getId()== kh.getId()){
                list.set(i,kh);
                break;
            }
        }
    }
    public void delete(Integer id){
        List<KhachHang> listDl = new ArrayList<>();
        listDl.add(findById(id));
        list.removeAll(listDl);
    }
    public KhachHang check(String ma, String sdt){
        for (KhachHang kh: list) {
            if (kh.getMaKH().equalsIgnoreCase(ma)||kh.getSdt().equals(sdt)){
                return kh;
            }
        }
        return null;
    }
}
