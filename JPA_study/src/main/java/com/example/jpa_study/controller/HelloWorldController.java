package com.example.jpa_study.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/05/09
 */
@RestController("/")
public class HelloWorldController {

    @GetMapping("hello-world")
    public String helloWorld() {
        return "hello-world";
    }
}
