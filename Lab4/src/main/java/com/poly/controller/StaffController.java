package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.poly.entity.Staff;

import jakarta.validation.Valid;

@Controller
public class StaffController {
	@RequestMapping("/staff/create")
    public String create(Model model) {
        model.addAttribute("staff", new Staff());
        return "staff-create"; 
    }
    @PostMapping("/staff/create/save")
    public String createSave(Model model,
                             @RequestParam("photo_file") MultipartFile photoFile,
                             @Valid @ModelAttribute("staff") Staff staff,
                             Errors errors) {

        if (!photoFile.isEmpty()) {
            // Lưu tên file (hoặc bạn có thể thêm code lưu file vào thư mục sau này)
            staff.setPhoto(photoFile.getOriginalFilename());
        }

        if (errors.hasErrors()) {
            model.addAttribute("message", "Vui lòng sửa các lỗi sau!");
        } else {
            model.addAttribute("message", "Dữ liệu đã nhập đúng!");
        }

        return "staff-create"; 
    }
}
