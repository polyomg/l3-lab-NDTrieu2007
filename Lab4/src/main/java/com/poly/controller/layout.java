package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class layout {
	@RequestMapping("/home/index")
	public String index(Model model) {
		return "/home";
	}
	@RequestMapping("/home/about")
	public String about(Model model) {
		return "/about";
	}
}
