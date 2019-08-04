package com.github.vmazheru.springboottest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.vmazheru.springboottest.model.HelloMessage;

@RestController
@RequestMapping
public class HomeController {
    
    private static final String ROOT = "/";
    
    @GetMapping(ROOT)
    public HelloMessage home() {
        return new HelloMessage("Hello, World!");
    }

}
