package com.example.shop.controller;

import com.example.shop.TestValue;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    TestValue testValue;

    @GetMapping("/")
    public String index() {
        String message = testValue.getMessage();
        System.out.println("메시지: " + message);
        return "login";
    }


}
