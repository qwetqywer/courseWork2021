package vgvr.stocksapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartController {
    @GetMapping("/index")
    public String findAll(Model model){
        return "index";
    }
}
