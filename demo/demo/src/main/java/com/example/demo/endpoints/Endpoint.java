package com.example.demo.endpoints;

import com.example.demo.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Endpoint {
    private Service service;
    
    @Autowired
    public Endpoint(Service service) {
        this.service = service;
    }

}
