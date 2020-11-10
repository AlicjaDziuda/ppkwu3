package com.example.demo.endpoints;

import com.example.demo.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Endpoint {
    private Service service;

    @Autowired
    public Endpoint(Service service) {
        this.service = service;
    }

    @GetMapping("/calendar/{year}/{month}")
    public List<String> getResult(@PathVariable String year, @PathVariable String month) throws IOException {
        return service.getCalendar(year,month);
    }
}
