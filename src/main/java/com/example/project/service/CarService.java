package com.example.project.service;

import com.example.project.dto.UserPasswordUpdate;
import com.example.project.entity.Car;
import com.example.project.exeption.RecordNotFoundException;

public interface CarService {
    Car addCar(Car car);

    void deleteCar(Long id);

    Car findById(Long id) throws RecordNotFoundException;

   // void updateCar(CarUpdate car) throws RecordNotFoundException;
}
