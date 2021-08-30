package com.example.quiktest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {


    @GetMapping("/quick")
    public String hello() {

        return "hello quick";
    }
}
