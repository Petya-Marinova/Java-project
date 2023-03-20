package com.example.project.service;

import com.example.project.entity.Reservation;
import com.example.project.exeption.RecordNotFoundException;

import java.util.Date;

public interface ReservationService {

    Reservation addReservation(Reservation reservation);
    void deleteReservation (Long id);
    Reservation findById(Long id) throws RecordNotFoundException;
    Reservation findByUser (Long id) throws RecordNotFoundException;
    Reservation findByCar (Long id) throws RecordNotFoundException;
    Reservation findByDate (Date date) ;

    void updateCarRes (Reservation reservedCar);

    void updateDates (Reservation rentDate);

    void updateRentDate(Reservation rentDate);

    void updateEndDate(Reservation endDate);
}
