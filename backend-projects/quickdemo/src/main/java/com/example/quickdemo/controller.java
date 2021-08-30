package com.example.quickdemo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    @GetMapping("/quick")
    public String quick() {

        return "this is will be deployed";
    }
}
