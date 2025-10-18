package com.poly.rect;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/rect")
public class RectController {

    @GetMapping("/form")
    public String form() {
        return "demo/rect"; 
    }

    @PostMapping("/calc")
    public String calc(@RequestParam double length, @RequestParam double width, Model model) {
        if (length <= 0 || width <= 0) {
            model.addAttribute("error", "Chiều dài và chiều rộng phải > 0");
        } else {
        	model.addAttribute("length", length);
        	model.addAttribute("width",width);
            model.addAttribute("area", length * width);
            model.addAttribute("perimeter", 2 * (length + width));
        }
        return "demo/rect";
    }
}

