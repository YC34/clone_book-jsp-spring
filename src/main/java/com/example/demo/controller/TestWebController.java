package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/test")
public class TestWebController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello2")
    @ResponseBody
    public String test(@RequestParam("msg") String msg){
        return msg;
    }


    @GetMapping("/hello/{msg}")
    public String hello3(@PathVariable String msg , Model model){
        model.addAttribute("msg",msg);
        return "hello";
    }
}
