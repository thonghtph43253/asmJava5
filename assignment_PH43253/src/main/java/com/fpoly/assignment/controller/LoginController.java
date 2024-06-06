package com.fpoly.assignment.controller;

import com.fpoly.assignment.entity.NhanVien;
import com.fpoly.assignment.repository.NhanVienRepo;
import com.fpoly.assignment.service.NhanVienService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    NhanVienService nvService;
    @Autowired
    NhanVienRepo nhanVienRepo;
    @GetMapping("/shopaaa/login")
    public String login(){
        return "shopAAA/login";
    }
    @PostMapping("/shopaaa/loginShop")
    public String loginShop(@RequestParam("username") String user,
                            @RequestParam("password") String pass,
                            HttpSession session,
                            Model model){
        NhanVien nv = nhanVienRepo.login(user, pass);
        if(nv!= null){
            session.setAttribute("nv",nv);
            return "shopAAA/index";
        }else{
            model.addAttribute("erLogin","Tên đăng nhập hoặc mật khâu không đúng");
//            return "redirect:/shopaaa?page=QuanLyBanHang";
            return "shopAAA/login";
        }
    }
    @GetMapping("/shopaaa/logout")
    public String logout(HttpSession session){
        session.removeAttribute("nv");
        return "redirect:/shopaaa/login";
    }
}
