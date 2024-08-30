package com.example.demo.peristence;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AppointmentRepository extends JpaRepository<AppointmentEntity, String> {
}
