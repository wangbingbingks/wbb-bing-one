package com.product.sc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wbb on 2020/8/13.
 */

@Controller
public class SeccessController {

    @RequestMapping("/springmvc")
    public String test() {
        System.out.println("index.jsp");
        return "index";
    }
}
