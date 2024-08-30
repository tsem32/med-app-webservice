package com.example.demo.rest;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class Appointment {
    
    private String id;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private String startTime;
    private String endTime;

}
