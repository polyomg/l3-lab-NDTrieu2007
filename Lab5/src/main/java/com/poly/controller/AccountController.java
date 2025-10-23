package com.poly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import com.poly.service.CookieService;
import com.poly.service.ParamService;
import com.poly.service.SessionService;

@Controller
public class AccountController {

    @Autowired
    CookieService cookieService;

    @Autowired
    ParamService paramService;

    @Autowired
    SessionService sessionService;

    // Hiển thị form đăng nhập
    @GetMapping("/account/login")
    public String login1(Model model) {
        // Đọc cookie đã lưu (nếu có)
        String username = cookieService.getValue("user");
        model.addAttribute("username", username);
        return "/account/login";
    }

    // Xử lý đăng nhập
    @PostMapping("/account/login")
    public String login2(Model model) {
        // Đọc tham số từ form
        String un = paramService.getString("username", "");
        String pw = paramService.getString("password", "");
        boolean rm = paramService.getBoolean("remember", false);

        // Kiểm tra đăng nhập
        if (un.equals("poly") && pw.equals("123")) {
            // Lưu vào session
            sessionService.set("username", un);

            // Xử lý ghi nhớ tài khoản
            if (rm) {
                // Lưu cookie 10 ngày (10 * 24 giờ)
                cookieService.add("user", un, 10 * 24);
            } else {
                // Xóa cookie nếu có
                cookieService.remove("user");
            }

            // Thông báo và chuyển hướng
            model.addAttribute("message", "Đăng nhập thành công!");
        } else {
            model.addAttribute("message", "Sai tài khoản hoặc mật khẩu!");
        }

        return "/account/login";
    }
}
