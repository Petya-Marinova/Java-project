package com.example.project.service.impl;

import com.example.project.convertor.ReservationConvertor;
import com.example.project.entity.Reservation;
import com.example.project.exeption.RecordNotFoundException;
import com.example.project.repository.ReservationRepository;
import com.example.project.service.ReservationService;
import com.example.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final UserService userService;
    private final ReservationConvertor convertor;
    private final ReservationRepository reservationRepository;
    private final CarServiceImpl carService;
    @Autowired
    public ReservationServiceImpl(UserService userService, ReservationConvertor convertor, ReservationRepository reservationRepository, CarServiceImpl carService) {
        this.userService = userService;
        this.convertor = convertor;
        this.reservationRepository = reservationRepository;
        this.carService = carService;
    }


    @Override
    public Reservation addReservation(Reservation reservation) {
        return null;
    }

    @Override
    public void deleteReservation(Long id) {
     reservationRepository.deleteById(id);

    }

    @Override
    public Reservation findById(Long id) throws RecordNotFoundException {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(String.format("Reservation with id %s not found", id)));
    }


    @Override
    public Reservation findByUser(Long id) throws RecordNotFoundException {
        return reservationRepository.findByUser(String.valueOf(id)).orElseThrow(()->new RecordNotFoundException("Reservation not found"));
    }

    @Override
    public Reservation findByCar(Long id) throws RecordNotFoundException {
        return reservationRepository.findByCar(id).orElseThrow(()->new RecordNotFoundException("Reservation not found"));
    }

    @Override
    public Reservation findByDate(Date date) {
        try {
            return reservationRepository.findByDate(date).orElseThrow(()->new RecordNotFoundException("Reservation not found"));
        } catch (RecordNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateCarRes(Reservation reservedCar) {

    }

    @Override
    public void updateRentDate(Reservation rentDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        sdf.format(rentDate.getRentDate());
        ReservationRepository.updateDates(new Date(),rentDate.getRentDate());
    }

    @Override
    public void updateEndDate(Reservation endDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        sdf.format(endDate.getEndDate());
        ReservationRepository.updateDates(new Date(),endDate.getEndDate());
    }


}
