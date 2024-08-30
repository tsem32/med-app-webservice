package com.example.demo.rest;

import com.example.demo.mapper.AppointmentMapper;
import com.example.demo.peristence.AppointmentEntity;
import com.example.demo.peristence.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @GetMapping
    public List<Appointment> findAll() {

        List<AppointmentEntity> appointments = appointmentRepository.findAll();

        return appointments.stream().map(AppointmentMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        AppointmentEntity entity = AppointmentMapper.INSTANCE.toEntity(appointment);
        AppointmentEntity savedEntity = appointmentRepository.save(entity);
        return AppointmentMapper.INSTANCE.toDTO(savedEntity);
    }

    @GetMapping("/{appointmentId}")
    public Appointment getAppointment(String appointmentId) {
        Optional<AppointmentEntity> appointmentOptional = appointmentRepository.findById(appointmentId);

        return appointmentOptional.map(AppointmentMapper.INSTANCE::toDTO)
                .orElse(null);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Appointment updateAppointment(@RequestBody Appointment appointment) {

        AppointmentEntity entity = AppointmentMapper.INSTANCE.toEntity(appointment);
        AppointmentEntity savedEntity = appointmentRepository.save(entity);
        return AppointmentMapper.INSTANCE.toDTO(savedEntity);
    }

    @DeleteMapping("/{appointmentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAppointment(@PathVariable("appointmentId") String appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }
}
