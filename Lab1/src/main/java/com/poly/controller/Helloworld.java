package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;

@Controller
public class Helloworld {
	@RequestMapping("poly/hello")
	public String sayHello(Model model) {
		model.addAttribute("title","FPT Polytechnic");
		model.addAttribute("subject","Spring boot MVC-TS00727 Nguyễn Đình Triệu");
		return("/demo/hello");
	}
}
