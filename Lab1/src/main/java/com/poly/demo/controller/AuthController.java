package com.poly.demo.controller;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/login")
public class AuthController {
	 @Autowired
	 HttpServletRequest request;

	    @GetMapping("/form")
	    public String form() {
	        return "demo/form"; 
	    }
	    @PostMapping("/check") 
	    public String login(Model model) {
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        if ("poly".equals(username) && "123".equals(password)) {
	            model.addAttribute("message", "Đăng nhập thành công!");
//	            return"demo/main";
	        } else {
	            model.addAttribute("message", "Đăng nhập thất bại! Sai username hoặc password.");
	        }
	        return "demo/form"; 
	    }
}

