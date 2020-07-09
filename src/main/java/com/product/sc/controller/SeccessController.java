package com.product.sc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SeccessController {

    @RequestMapping("/springmvc")
    public String test(){
        System.out.println("seccess");
        return "seccess";
    }
}
