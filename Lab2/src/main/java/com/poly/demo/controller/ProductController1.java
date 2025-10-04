package com.poly.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.poly.entity.Product;

@Controller
public class ProductController1 {

    @GetMapping("/product/form1")
    public String form(Model model) {
    	Product p = new Product();
        p.setName("iPhone 30");
        p.setPrice(5000.0);
        model.addAttribute("sp1", p); 
        model.addAttribute("sp2", new Product());
        return "Product/product-form1";
    }

    @PostMapping("/product/save1")
    public String save(@ModelAttribute("sp2") Product p, Model model) {
        model.addAttribute("sp2", p); 
        return "product/form";
    }

    @ModelAttribute("items")
    public List<Product> getItems() {
        return Arrays.asList(
                new Product("A", 1.0),
                new Product("B", 12.0)
        );
    }
}
