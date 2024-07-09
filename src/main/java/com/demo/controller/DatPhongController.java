package com.demo.controller;

import com.demo.entity.DatPhong;
import com.demo.entity.KhachHang;
import com.demo.repo.DatPhongRepo;
import com.demo.repo.KhachHangRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/dat-phong")
public class DatPhongController {
    @Autowired
    DatPhongRepo datPhongRepo;

    @Autowired
    KhachHangRepo khachHangRepo;

    @ModelAttribute("dsKH")
    public List<KhachHang> getDsKhachHang(){
        return khachHangRepo.findAll();
    }

    @GetMapping("/hien-thi")
    public String hienThi(Model model){
        List<DatPhong> list = datPhongRepo.findAll();
        //System.out.println("list:" + list);
        model.addAttribute("list", list);
        model.addAttribute("dp", new DatPhong());
        return "hien-thi";
    }

    @GetMapping("/search")
    public String search(@RequestParam(defaultValue="")String keyword, Model model){
        List<DatPhong> list = datPhongRepo.search("%" + keyword + "%");
        //System.out.println("list:" + list);
        model.addAttribute("list", list);
        model.addAttribute("dp", new DatPhong());
        return "hien-thi";
    }

    @GetMapping("/view-update/{id}")
    public String viewUpdate(@PathVariable Integer id, Model model){
        DatPhong dp = datPhongRepo.findById(id).orElse(null);
        model.addAttribute("dp", dp);
        model.addAttribute("list", datPhongRepo.findAll());
        return "hien-thi";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Integer id,
                     @Valid  @ModelAttribute("dp") DatPhong dp,
                     BindingResult rs){
        if(rs.hasErrors()){
            return "hien-thi";
        }
        dp.setId(id);
        datPhongRepo.save(dp);
        return "redirect:/dat-phong/hien-thi";
    }
}
