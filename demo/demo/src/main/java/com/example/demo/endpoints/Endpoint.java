package com.example.demo.endpoints;

import com.example.demo.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Endpoint {
    private Service service;

    @Autowired
    public Endpoint(Service service) {
        this.service = service;
    }

    @GetMapping("/calendar/{year}/{month}")
    public String getResult(@PathVariable int year, @PathVariable int month) {
        return service.getCalendar(year,month);
    }
}
