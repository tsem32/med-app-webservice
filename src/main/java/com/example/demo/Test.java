package com.example.demo;

import com.example.demo.peristence.AppointmentEntity;
import com.example.demo.peristence.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class Test {

    private AppointmentRepository appointmentRepository;

    @Autowired
    public Test(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
        loadData();
        System.out.println(appointmentRepository.findAll());
    }


    private void loadData() {


        List<AppointmentEntity> entries = IntStream.range(0, 20)
                .mapToObj(operand -> {
                    LocalDate now = LocalDate.now().plusDays(operand);
                    AppointmentEntity appointmentEntity = new AppointmentEntity();
                    appointmentEntity.setDescription("Ελληνικη Περιγραφη");
                    appointmentEntity.setId(UUID.randomUUID().toString());
                    appointmentEntity.setStartDate(now);
                    appointmentEntity.setEndDate(now);
                    appointmentEntity.setStartTime(LocalTime.of(10, 0).toString());
                    appointmentEntity.setEndTime(LocalTime.of(11, 0).toString());
                    return appointmentEntity;
                })
                .collect(Collectors.toList());


        appointmentRepository.saveAll(entries);
    }
}
