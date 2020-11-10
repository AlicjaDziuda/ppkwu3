package com.example.demo.services;

@org.springframework.stereotype.Service

public class Service {
    public String getCalendar(int year, int month) {
        return "year: " + year + " month: "+month;
    }
}
