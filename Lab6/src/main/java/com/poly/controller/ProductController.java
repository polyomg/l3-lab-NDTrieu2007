package com.poly.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;  
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.DAOInterfaces.ProductDAO;
import com.poly.entity.Product;

@Controller
public class ProductController {
	@Autowired
	ProductDAO dao;
	
	@RequestMapping("/product/sort")
    public String sort(Model model, @RequestParam("field") Optional<String> field) {
        Sort sort = Sort.by(Sort.Direction.DESC, field.orElse("price"));
        model.addAttribute("field", field.orElse("price").toUpperCase());
        List<Product> items = dao.findAll(sort);
        model.addAttribute("items", items);
        return "product/sort";
    }
	
	@RequestMapping("/product/page")
	public String paginate(Model model, @RequestParam("p") Optional<Integer> p) {
		int pageIndex = p.orElse(0);
		if (pageIndex < 0) {
	        pageIndex = 0;
	    }
	    Pageable pageable = PageRequest.of(pageIndex, 5);
	    Page<Product> page = dao.findAll(pageable);
	    model.addAttribute("page", page);
	    return "product/page";
	}

}
