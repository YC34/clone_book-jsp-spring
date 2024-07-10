package com.example.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class TestRestController {

    @GetMapping("/1")
    public String hello(@RequestParam String msg){
        return msg;
    }

    @GetMapping("/2")
    public HashMap<String, String> hello3(){
        HashMap<String,String> map = new HashMap<>();
        map.put("key","value");
        map.put("key2","value2");
        map.put("key3","value3");
        return map;
    }


    
}
