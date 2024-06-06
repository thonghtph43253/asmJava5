package com.fpoly.assignment.controller;

import com.fpoly.assignment.entity.*;
import com.fpoly.assignment.repository.*;
import com.fpoly.assignment.service.*;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/shopaaa")
public class ShopAAAController {
//    @Autowired
//    NhanVienService nvService;
//    @Autowired
//    KhachHangService khService;
//    @Autowired
//    KichThuocService ktService;
//    @Autowired
//    MauSacService msService;
//    @Autowired
//    SanPhamService spService;
//    @Autowired
//    SanPhamCTService spctService;
//    @Autowired
//    HoaDonService hdService;
//    @Autowired
//    HoaDonCTService hdctService;

    //Tiem Repo
    @Autowired
    NhanVienRepo nhanVienRepo;
    @Autowired
    KhachHangRepo khachHangRepo;
    @Autowired
    KichThuocRepo kichThuocRepo;
    @Autowired
    MauSacRepo mauSacRepo;
    @Autowired
    SanPhamRepo  sanPhamRepo;
    @Autowired
    SPChiTietRepo spChiTietRepo;
    @Autowired
    HoaDonRepo hoaDonRepo;
    @Autowired
    HoaDonChiTietRepo hoaDonChiTietRepo;
    @GetMapping("")
    public String showHome(Model model,
                           @RequestParam(defaultValue = "0",name = "pt") int page,
                           @RequestParam(defaultValue = "",name = "search") String search,
                           @RequestParam("page") String namePage,
                           HttpSession session
                           ){
        int size = 5;
        Pageable pageable = PageRequest.of(page,size);
        if(namePage.equals("QuanLyNhanVien")) {
            model.addAttribute("listNV",nhanVienRepo.findByTenContaining(search,pageable));
        }else if(namePage.equals("QuanLyKhachHang")){
            model.addAttribute("listKH", khachHangRepo.findByTenContaining(search,pageable));
        }else if (namePage.equals("QuanLySize")){
            model.addAttribute("listKT", kichThuocRepo.findByTenContaining(search,pageable));
        }else if(namePage.equals("QuanLyMauSac")){
            model.addAttribute("listMS", mauSacRepo.findByTenContaining(search,pageable));
        }else if(namePage.equals("QuanLySanPham")){
            model.addAttribute("listSP",sanPhamRepo.findByTenContaining(search,pageable));
        }else if(namePage.equals("QuanLyBanHang")){
            model.addAttribute("listSPCT",spChiTietRepo.findAll());
            model.addAttribute("listKHAll",khachHangRepo.findAll());
        }else if(namePage.equals("QuanLyHoaDon")){
//            if(search.isEmpty()){
//                model.addAttribute("listHD",hdService.getByPage(page,size));
//                model.addAttribute("soTrang", hdService.getSotrang(5));
//            }else {
//                model.addAttribute("listHD",hdService.getByPageSearch(page,5,search));
//                model.addAttribute("soTrang", hdService.getSotrangSearch(5, search));
//
//            }
            String s = "%"+search+"%";
            model.addAttribute("listHD",hoaDonRepo.findAllByNameKHAndNV(s,pageable));
        }
        Map<Integer, Integer> gioHang = (Map<Integer, Integer>) session.getAttribute("gioHang");
        if (gioHang == null) {
            gioHang = new HashMap<>();
        }
        //Map từ idspct lấy ra thông tin sản phẩm
        Map<Integer, String> thongTinSP = new HashMap<>();
        for (SPChiTiet spct: spChiTietRepo.findAll()) {
            thongTinSP.put(spct.getId(),spct.getSanPham().getTen()+","+spct.getKichThuoc().getTen()+","+spct.getMauSac().getTen());
        }

        model.addAttribute("thongTinSP", thongTinSP);
        model.addAttribute("listMua", gioHang);
        model.addAttribute("khachhang",new KhachHang());
        model.addAttribute("nhanvien",new NhanVien());
        model.addAttribute("kichthuoc",new KichThuoc());
        model.addAttribute("mausac",new MauSac());
        model.addAttribute("sanpham",new SanPham());
        model.addAttribute("sanphamct", new SPChiTiet());
        model.addAttribute("page",page);

        return "shopAAA/index";
    }

    @PostMapping("/addNhanVien")
    public String addNhanVien(@Valid @ModelAttribute("nhanvien")NhanVien nhanvien,
                              BindingResult result){
        if(result.hasErrors()){

            return "shopAAA/index";
        }

//        nvService.add(nhanvien);
        nhanVienRepo.save(nhanvien);
        return "redirect:/shopaaa?page=QuanLyNhanVien";
    }
    @GetMapping("/suaNhanVien")
    public String showFormNv(Model model, @RequestParam("id") Integer id){
//        model.addAttribute("nhanvien",nvService.findByID(id));
        model.addAttribute("nhanvien",nhanVienRepo.findById(id));
        return "shopAAA/index";
    }
    @PostMapping("/suaNhanVien")
    public String suaNhanVien(@Valid @ModelAttribute("nhanvien")NhanVien nhanvien,
                              BindingResult result,Model model){
        if(result.hasErrors()){

            return "shopAAA/index";
        }
        NhanVien nhanVienOld = nhanVienRepo.findById(nhanvien.getId()).get();
        if(nhanvien.getMatKhau() == null || nhanvien.getMatKhau().isEmpty()){
            nhanvien.setMatKhau(nhanVienOld.getMatKhau());
        }
//        nvService.update(nhanvien);
         nhanVienRepo.save(nhanvien);
        return "redirect:/shopaaa?page=QuanLyNhanVien";
    }
    @GetMapping("/deleteNV/{id}")
    public String deleteNhanVien(@PathVariable("id") Integer id){
//        nvService.delete(id);
        nhanVienRepo.deleteById(id);
        return "redirect:/shopaaa?page=QuanLyNhanVien";
    }
    //End nhan vien
    @PostMapping("/addKhachHang")
    public String addKhachHang(@Valid @ModelAttribute("khachhang") KhachHang kh,
                               BindingResult result){
        if(result.hasErrors()){
            return "shopAAA/index";
        }
        khachHangRepo.save(kh);
        return "redirect:/shopaaa?page=QuanLyKhachHang";
    }
    @GetMapping("/suaKhachHang")
    public String getFormSuaKH(Model model,
                               @RequestParam("id")Integer id){
        model.addAttribute("khachhang", khachHangRepo.findById(id).get());
        return "shopAAA/index";
    }
    @PostMapping("/suaKhachHang")
    public String suaKhachHang(@Valid @ModelAttribute("khachhang") KhachHang kh,
                               BindingResult result){
        if(result.hasErrors()){
            return "shopAAA/index";
        }
        khachHangRepo.save(kh);
        return "redirect:/shopaaa?page=QuanLyKhachHang";
    }
    @GetMapping("/deleteKH/{id}")
    public String xoaKhachHang(@PathVariable("id")Integer id){
        khachHangRepo.deleteById(id);
        return "redirect:/shopaaa?page=QuanLyKhachHang";
    }
    //End khách hàng
    @PostMapping("/addMauSac")
    public String addMauSac(@Valid @ModelAttribute("mausac")MauSac ms,
                            BindingResult result,
                            Model model,
                            @RequestParam(defaultValue = "0",name = "pt") int page,
                            @RequestParam(defaultValue = "",name = "search") String search,
                            @RequestParam("page") String namePage){
        if(result.hasErrors()){
            model.addAttribute("page",page);
            model.addAttribute("listMS",mauSacRepo.findByTenContaining(search,PageRequest.of(page,5)));
            return "shopAAA/index";
        }
        mauSacRepo.save(ms);
        return "redirect:/shopaaa?page=QuanLyMauSac";
    }
    @GetMapping("/detailMS")
    public String getDetailMS(@RequestParam(name = "id") Integer id,
                              Model model,
                              @RequestParam(defaultValue = "0",name = "pt") int page,
                              @RequestParam(defaultValue = "",name = "search") String search,
                              @RequestParam("page") String namePage){
        model.addAttribute("mausac",mauSacRepo.findById(id).get());
        model.addAttribute("page",page);
        model.addAttribute("listMS",mauSacRepo.findByTenContaining(search,PageRequest.of(page,5)));

        return "shopAAA/index";
    }
    @PostMapping("/updateMS")
    public String updateMS(@Valid @ModelAttribute("mausac")MauSac ms,
                           BindingResult result,
                           Model model,
                           @RequestParam(defaultValue = "0",name = "pt") int page,
                           @RequestParam(defaultValue = "",name = "search") String search,
                           @RequestParam("page") String namePage){
        if(result.hasErrors()){
            model.addAttribute("mausac",mauSacRepo.findById(ms.getId()).get());
            model.addAttribute("page",page);
            model.addAttribute("listMS",mauSacRepo.findByTenContaining(search,PageRequest.of(page,5)));

            return "shopAAA/index";
        }
        mauSacRepo.save(ms);
        return "redirect:/shopaaa?page=QuanLyMauSac";
    }
    @GetMapping("/deleteMS/{id}")
    public String deleteMS(@PathVariable("id") Integer id){
        mauSacRepo.deleteById(id);
        return "redirect:/shopaaa?page=QuanLyMauSac";
    }
    //End Màu sắc
    @PostMapping("/addKichThuoc")
    public String addKichThuoc(@Valid @ModelAttribute("kichthuoc") KichThuoc kt,
                               BindingResult result,
                               Model model,
                               @RequestParam(defaultValue = "0",name = "pt") int page,
                               @RequestParam(defaultValue = "",name = "search") String search,
                               @RequestParam("page") String namePage){
        KichThuoc ktTest= kichThuocRepo.findByMa(kt.getMa());
        if (ktTest!=null){
            model.addAttribute("er","Mã đã tồn tại");
            model.addAttribute("page",page);
            model.addAttribute("listKT",kichThuocRepo.findByTenContaining(search,PageRequest.of(page,5)));
            return "shopAAA/index";
        }
        if(result.hasErrors()){
            model.addAttribute("page",page);
            model.addAttribute("listKT",kichThuocRepo.findByTenContaining(search,PageRequest.of(page,5)));
            return "shopAAA/index";
        }
        kichThuocRepo.save(kt);
        return "redirect:/shopaaa?page=QuanLySize";
    }
    @GetMapping("/detailKT")
    public String getDetailKT(@RequestParam(name = "id") Integer id,
                              Model model,
                              @RequestParam(defaultValue = "0",name = "pt") int page,
                              @RequestParam(defaultValue = "",name = "search") String search,
                              @RequestParam("page") String namePage){
        model.addAttribute("kichthuoc",kichThuocRepo.findById(id).get());
        model.addAttribute("page",page);
        model.addAttribute("listKT",kichThuocRepo.findByTenContaining(search,PageRequest.of(page,5)));

        return "shopAAA/index";
    }
    @PostMapping("/updateKT")
    public String updateKT(@Valid @ModelAttribute("kichthuoc") KichThuoc kt,
                           BindingResult result,
                           @RequestParam(defaultValue = "0",name = "pt") int page,
                           @RequestParam(defaultValue = "",name = "search") String search,
                           @RequestParam("page") String namePage,
                           Model model){

        if(result.hasErrors()){
//            model.addAttribute("kichthuoc",kichThuocRepo.findById(kt.getId()).get());
            model.addAttribute("page",page);
            model.addAttribute("listKT",kichThuocRepo.findByTenContaining(search,PageRequest.of(page,5)));

            return "shopAAA/index";
        }
        kichThuocRepo.save(kt);
        return "redirect:/shopaaa?page=QuanLySize";
    }
    @GetMapping("/deleteKT/{id}")
    public String deleteKT(@PathVariable("id") Integer id){
        boolean exist = spChiTietRepo.existsByIDKichThuoc(id);
        if (exist){
             KichThuoc kt = kichThuocRepo.findById(id).get();
             kt.setTrangThai(false);
             kichThuocRepo.save(kt);
        }else {
            kichThuocRepo.deleteById(id);
        }

        return "redirect:/shopaaa?page=QuanLySize";
    }
    //End kích thước
    @PostMapping("/addSanPham")
    public String addSanPham(@Valid @ModelAttribute("sanpham") SanPham sp,
                             BindingResult result,
                             Model model,
                             @RequestParam(defaultValue = "0",name = "pt") int page,
                             @RequestParam(defaultValue = "",name = "search") String search,
                             @RequestParam("page") String namePage){
        if (result.hasErrors()){
            model.addAttribute("page",page);
            model.addAttribute("listSP",sanPhamRepo.findByTenContaining(search,PageRequest.of(page,5)));
                return "shopAAA/index";
//            return "redirect:/shopaaa?page=QuanLySanPham";
        }
        sanPhamRepo.save(sp);
        return "redirect:/shopaaa?page=QuanLySanPham";
    }
    @GetMapping("/detailSP")
    public String getDetailSP(@RequestParam(name = "id") Integer id,
                              Model model,
                              @RequestParam(defaultValue = "0",name = "pt") int page,
                              @RequestParam(defaultValue = "",name = "search") String search,
                              @RequestParam("page") String namePage){
        model.addAttribute("sanpham",sanPhamRepo.findById(id).get());
        model.addAttribute("page",page);
        model.addAttribute("listSP",sanPhamRepo.findByTenContaining(search,PageRequest.of(page,5)));
        return "shopAAA/index";
    }
    @PostMapping("/updateSP")
    public String updateSp(@Valid @ModelAttribute("sanpham") SanPham sp,
                           BindingResult result,
                           Model model,
                           @RequestParam(defaultValue = "0",name = "pt") int page,
                           @RequestParam(defaultValue = "",name = "search") String search,
                           @RequestParam("page") String namePage
                          ){
        if(result.hasErrors()){
            model.addAttribute("listSP",sanPhamRepo.findByTenContaining(search,PageRequest.of(page,5)));
            model.addAttribute("page",page);
            return "shopAAA/index";
//            return "redirect:/shopaaa?page=QuanLySanPham";
        }
        sanPhamRepo.save(sp);
        return "redirect:/shopaaa?page=QuanLySanPham";
    }
    @GetMapping("/deleteSP/{id}")
    public String deleteSP(@PathVariable("id") Integer id){
        sanPhamRepo.deleteById(id);
        return "redirect:/shopaaa?page=QuanLySanPham";
    }
    //End sản phẩm
    @GetMapping("/sanphamct")
    public String getSanPhamCT(Model model,
                               @RequestParam("id")Integer idsp,
                               @RequestParam(defaultValue = "0",name = "pt") int page,
                               @RequestParam(defaultValue = "",name = "search") String search,
                               @RequestParam("page") String namePage){
            String s = "%"+search+"%";
            model.addAttribute("listSPCT",spChiTietRepo.findAllByKTandMSandIDSP(s,idsp,PageRequest.of(page,5)));
            model.addAttribute("sanphamct", new SPChiTiet());
            model.addAttribute("idsp",idsp);
            model.addAttribute("sp",sanPhamRepo.findById(idsp).get());
            model.addAttribute("page",page);
        return "shopAAA/index";
    }
    @ModelAttribute("mausacs")
    public List<MauSac> getListMauSac(){
        return mauSacRepo.findAll();
    }
    @ModelAttribute("kichthuocs")
    public List<KichThuoc> getListKichThuoc(){
        return kichThuocRepo.findAll();
    }
    @PostMapping("/addSanPhamCT")
    public String addSanPhamCT(@Valid @ModelAttribute("sanphamct") SPChiTiet spct,
                               BindingResult result,
                               @RequestParam("id")Integer idsp,
                               @RequestParam(defaultValue = "0",name = "pt") int page,
                               @RequestParam(defaultValue = "",name = "search") String search,
                               @RequestParam("page") String namePage,
                               Model model
                               ){
        String s = "%"+search+"%";
        if(result.hasErrors()){
            model.addAttribute("listSPCT",spChiTietRepo.findAllByKTandMSandIDSP(s,idsp,PageRequest.of(page,5)));
            model.addAttribute("sanphamct", new SPChiTiet());
            model.addAttribute("idsp",idsp);
            model.addAttribute("sp",sanPhamRepo.findById(idsp).get());
            model.addAttribute("page",page);
            return "shopAAA/index";
        }
        spct.setSanPham(sanPhamRepo.findById(idsp).get());
        spChiTietRepo.save(spct);
        return "redirect:/shopaaa/sanphamct?page=QuanLySanPhamCT&id="+sanPhamRepo.findById(idsp).get().getId();
    }
    @GetMapping("/detailSPCT")
    public String getDetailSanPhamCT(Model model,
                               @RequestParam("id")Integer idsp,
                               @RequestParam(defaultValue = "0",name = "pt") int page,
                               @RequestParam(defaultValue = "",name = "search") String search,
                               @RequestParam("page") String namePage,
                               @RequestParam("idspct") Integer idspct){
        String s = "%"+search+"%";
        model.addAttribute("listSPCT",spChiTietRepo.findAllByKTandMSandIDSP(s,idsp,PageRequest.of(page,5)));
        model.addAttribute("sanphamct", new SPChiTiet());
        model.addAttribute("idsp",idsp);
        model.addAttribute("sp",sanPhamRepo.findById(idsp).get());
        model.addAttribute("page",page);
        return "shopAAA/index";
    }
    @PostMapping("/updateSPCT")
    public String updateSPCT(@Valid @ModelAttribute("sanphamct") SPChiTiet spct,
                             BindingResult result,
                             @RequestParam("id")Integer idsp,
                             @RequestParam(defaultValue = "0",name = "pt") int page,
                             @RequestParam(defaultValue = "",name = "search") String search,
                             @RequestParam("page") String namePage,

                             Model model){
        if(result.hasErrors()){
            String s = "%"+search+"%";
            model.addAttribute("listSPCT",spChiTietRepo.findAllByKTandMSandIDSP(s,idsp,PageRequest.of(page,5)));
            model.addAttribute("sanphamct", new SPChiTiet());
            model.addAttribute("idsp",idsp);
            model.addAttribute("sp",sanPhamRepo.findById(idsp).get());
            model.addAttribute("page",page);
            return "shopAAA/index";
        }
        spChiTietRepo.save(spct);
        return "redirect:/shopaaa/sanphamct?page=QuanLySanPhamCT&id="+spct.getSanPham().getId();
    }
    @GetMapping("/deleteSPCT/{id}")
    public String deleteSCPT(@PathVariable("id") Integer idSpct){
        Integer idsp = spChiTietRepo.findById(idSpct).get().getId();
        spChiTietRepo.deleteById(idSpct);
        return "redirect:/shopaaa/sanphamct?page=QuanLySanPhamCT&id="+idsp;

    }
    //End sản phẩm chi tiết
    @GetMapping("/hoadonct")
    public String getHoaDonCT(Model model,
                               @RequestParam("id")Integer idhd,
                               @RequestParam(defaultValue = "0",name = "pt") int page,
                               @RequestParam(defaultValue = "",name = "search") String search,
                               @RequestParam("page") String namePage){
//        if(search.isEmpty()){
//            model.addAttribute("listHDCT",hdctService.getByPage(page,5,idhd));
//            model.addAttribute("soTrang", hdctService.getSotrang(5,idhd));
//        }else {
//            model.addAttribute("listHDCT",hdctService.getByPageSearch(page,5,search,idhd));
//            model.addAttribute("soTrang", hdctService.getSotrangSearch(5,search,idhd));
//        }
        String s = "%"+search+"%";
        model.addAttribute("listHDCT",hoaDonChiTietRepo.findByIDHDandSPandKTandMs(s,idhd,PageRequest.of(page,5)));
        model.addAttribute("tongTien" ,hoaDonChiTietRepo.getTongTien(idhd));

        model.addAttribute("hd",hoaDonRepo.findById(idhd).get());

        model.addAttribute("page",page);
        return "shopAAA/index";
    }
    @PostMapping("/suaHD")
    public String updateHoaDon(@RequestParam("id") Integer idhd,
                               @RequestParam("trangThai") boolean trangThai){
        HoaDon hd = hoaDonRepo.findById(idhd).get();
        hd.setTrangThai(trangThai);
        hoaDonRepo.save(hd);
        return "redirect:/shopaaa/hoadonct?page=QuanLyHoaDonCT&id="+hd.getId();
    }
    //End hoadon chi tiet
    @PostMapping("/addGioHang")
    public String themGioHang(@RequestParam("idspct") Integer idspct,
                              @RequestParam("soLuongMua") Integer soLuongMua,
                              HttpSession session,
                              Model model) {
        Map<Integer, Integer> gioHang = (Map<Integer, Integer>) session.getAttribute("gioHang");
        if (gioHang == null) {
            gioHang = new HashMap<>();
        }
        SPChiTiet spct = spChiTietRepo.findById(idspct).get();
        if (spct.getSoLuong()<soLuongMua){
            model.addAttribute("srSoLuong","Số lượng mua vượt quá số lượng sản phẩm");
            return "redirect:/shopaaa?page=QuanLyBanHang";
        }
        gioHang.put(idspct,  soLuongMua);
        session.setAttribute("gioHang", gioHang);
        return "redirect:/shopaaa?page=QuanLyBanHang";
    }
    @PostMapping("/taoHoaDon")
    public String taoHoaDon(@RequestParam("idnv")Integer idnv,
                            @RequestParam("idKhachHang")Integer idkh,
                            @RequestParam("trangThai") boolean trangThai,
                            HttpSession session){
        HoaDon hd = new HoaDon();
        NhanVien nv = nhanVienRepo.findById(idnv).get();
        KhachHang kh = khachHangRepo.findById(idkh).get();
        hd.setNhanVien(nv);
        hd.setKhachHang(kh);
        hd.setTrangThai(trangThai);
        hd.setNgayMuaHang(LocalDateTime.now());
        hoaDonRepo.save(hd);
        Map<Integer, Integer> gioHang = (Map<Integer, Integer>) session.getAttribute("gioHang");
        if (gioHang == null) {
            gioHang = new HashMap<>();
        }
        for (Map.Entry<Integer, Integer> entry:gioHang.entrySet()) {
            SPChiTiet spct = spChiTietRepo.findById(entry.getKey()).get();
            HoaDonChiTiet hdct = new HoaDonChiTiet();
            HoaDon hd1 = hoaDonRepo.findById(hoaDonRepo.getIDHDLast()).get();
            hdct.setHoaDon(hd1);

            hdct.setDonGia(spct.getDonGia());
            hdct.setSpChiTiet(spct);
            hdct.setSoLuong(entry.getValue());
            hdct.setTrangThai(true);
            hoaDonChiTietRepo.save(hdct);
            spct.setSoLuong(spct.getSoLuong()- entry.getValue());
            spChiTietRepo.save(spct);

        }
        session.removeAttribute("gioHang");
        return "redirect:/shopaaa/hoadonct?page=QuanLyHoaDonCT&id="+hoaDonRepo.getIDHDLast();
    }
    @GetMapping("/deleteGiohang/{id}")
    public String xoaGioHang(@PathVariable("id")Integer id,
                             HttpSession session){
        Map<Integer, Integer> gioHang = (Map<Integer, Integer>) session.getAttribute("gioHang");
        gioHang.remove(id);
        session.setAttribute("gioHang",gioHang);
        return "redirect:/shopaaa?page=QuanLyBanHang";
    }
}
