package com.example.project.service.impl;

import com.example.project.entity.Car;
import com.example.project.exeption.RecordNotFoundException;
import com.example.project.repository.CarRepository;
import com.example.project.service.CarService;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;


    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public Car findById(Long id) throws RecordNotFoundException {
        return carRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(String.format("Car with id %s not found", id)));

    }

}
