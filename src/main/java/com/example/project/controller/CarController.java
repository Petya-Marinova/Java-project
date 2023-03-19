package com.example.project.controller;

import com.example.project.convertor.CarConvertor;
import com.example.project.dto.CarResponse;
import com.example.project.entity.Car;
import com.example.project.exeption.RecordNotFoundException;
import com.example.project.service.impl.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;

@RestController
@RequestMapping(path = "/cars")
public class CarController {

    @Autowired
    CarServiceImpl carServiceImpl;

    @Autowired
    CarConvertor carConvertor;

    @PostMapping
    ResponseEntity<Car> addCar(@RequestBody Car carRequest) throws SQLIntegrityConstraintViolationException {
        Car carSaved = carServiceImpl.addCar(carRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(carServiceImpl.addCar(carSaved));
    }

    @DeleteMapping(path = "/{id}")
    ResponseEntity<String> deleteCar(@PathVariable Long id) {
        carServiceImpl.deleteCar(id);
        return ResponseEntity
                .ok()
                .body(Long.toString(id) + " deleted");
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<CarResponse> getById(@PathVariable Long id) throws RecordNotFoundException {
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(carConvertor.convertToCarResponse(carServiceImpl.findById(id)));
    }

}
