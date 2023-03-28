package com.example.projectexercise.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class Test {
    @GetMapping("/one")
    public String test(){
        return "hello word!";
    }
}
