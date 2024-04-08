package com.example.demo.controller;

import com.example.demo.dto.ResponseData;
import com.example.demo.service.MainService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class MainController {

    @Autowired
    private MainService mainService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("page", 1);
        model.addAttribute("perPage", 10);
        return "index";
    }

    @PostMapping("/")
    public String index(@RequestParam(defaultValue = "1") int page,
                        @RequestParam(defaultValue = "10") int perPage,
                        Model model) throws IOException {

        ResponseData data = mainService.test(page, perPage);
//        ObjectMapper objectMapper = new ObjectMapper();
//        String dataJson = objectMapper.writeValueAsString(data);
        model.addAttribute("result", data);
        return "index";
    }

}
