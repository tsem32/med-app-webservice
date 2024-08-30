package com.example.demo.mapper;

import com.example.demo.peristence.AppointmentEntity;
import com.example.demo.rest.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AppointmentMapper {
    AppointmentMapper INSTANCE = Mappers.getMapper(AppointmentMapper.class);

    AppointmentEntity toEntity(Appointment source);

    Appointment toDTO(AppointmentEntity appointmentEntity);
}