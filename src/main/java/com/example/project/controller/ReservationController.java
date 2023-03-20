package com.example.project.controller;

import com.example.project.convertor.ReservationConvertor;
import com.example.project.dto.ReservationResponse;
import com.example.project.entity.Reservation;
import com.example.project.exeption.RecordNotFoundException;
import com.example.project.service.ReservationService;
import com.example.project.service.impl.ReservationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping(path = "/reservations")
public class ReservationController {
    @Autowired
    ReservationServiceImpl reservationServiceImpl;
    @Autowired
    ReservationConvertor reservationConvertor;
    @Autowired
    ReservationService reservationService;


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    @GetMapping(path = "/user")
    ResponseEntity<ReservationResponse> getByUser(@RequestBody Long id) throws RecordNotFoundException {
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body( reservationConvertor.toReservationResponse(reservationServiceImpl.findByUser(id)));
    }

    @DeleteMapping(path = "/{id}")
    public String deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return String.format("Reservation with %s id is deleted", id);
    }

    @PostMapping(path = "/add")
    public Reservation addReservation(@PathVariable Long id) {
        return reservationService.addReservation(new Reservation());
    }

    @GetMapping(path = "/{id}")
    public Reservation getByCar(@PathVariable Long id) throws RecordNotFoundException {
        return reservationService.findByCar(id);
    }

    @PostMapping("update/{resid}")
    public ResponseEntity<String> update(@PathVariable Long id, int carNumber, @ModelAttribute Reservation reservation){
        Reservation res = new Reservation();
        try{
           res = reservationService.findById(reservation.getId());
        }catch (RuntimeException exception){

        }
        res.setRentDate(reservation.getRentDate());
        res.setEndDate(reservation.getEndDate());
        reservationService.updateDates(reservation);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body("Reservation dates are changed");
    }
}