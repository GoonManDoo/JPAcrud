package com.example.shop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Component
public class TestValue {

    @Value("${myapp.message}")
    private String message;

    public String getMessage() {
        return message;
    }
}
