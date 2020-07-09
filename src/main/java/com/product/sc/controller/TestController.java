package com.product.sc.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class TestController {

    @RequestMapping(value = "/demoget", method = RequestMethod.GET)
    public String demoGet(HttpServletRequest request){
        String name = request.getParameter("name");
        if(null != name){
            System.out.println("name = " + name);
        }
        return "get 是的 aa";
    }


    @RequestMapping(value = "/demopost", method = RequestMethod.POST)
    public String demoPost(HttpServletRequest request){
        String name = request.getParameter("name");
        if(null != name){
            System.out.println("name = " + name);
        }

        return "post 是的 aa";
    }


}
