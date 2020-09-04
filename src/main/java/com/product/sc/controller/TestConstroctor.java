package com.product.sc.controller;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TestConstroctor {

    @PostConstruct
    private void init(){
        System.out.println("true = " + true);
    }
}
