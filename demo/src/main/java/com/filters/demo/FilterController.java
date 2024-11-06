package com.filters.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FilterController {
    
    @GetMapping("/get")
    public String getFilter() {
        return "Hello world!";
    }
    
}
