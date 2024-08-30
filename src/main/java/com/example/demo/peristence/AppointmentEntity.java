package com.example.demo.peristence;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "appointments")
@Data
public class AppointmentEntity {

    @Id
    private String id;

    private String description;

    private LocalDate startDate;

    private LocalDate endDate;

    private String startTime;

    private String endTime;

}
