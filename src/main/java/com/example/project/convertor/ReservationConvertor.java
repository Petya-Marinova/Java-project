package com.example.project.convertor;

import com.example.project.dto.ReservationRequest;
import com.example.project.entity.Car;
import com.example.project.entity.Reservation;
import com.example.project.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Set;

@RequiredArgsConstructor
@Component
public class ReservationConvertor {

    public Reservation toReservation(ReservationRequest reservationRequest, User user, Car car, Date rentDate, Date endDate){
        return Reservation.builder()
                .client(user)
                .car((Set<Car>) car)
                .rentDate(rentDate)
                .endDate(endDate)
                .build();
    }
}
