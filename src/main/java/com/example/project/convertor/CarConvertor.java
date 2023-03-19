package com.example.project.convertor;

import com.example.project.dto.CarResponse;
import com.example.project.entity.Car;
import org.springframework.stereotype.Component;

@Component
public class CarConvertor {

    public CarResponse convertToCarResponse(Car car) {
        return CarResponse.builder()
                .id(car.getId().toString())
                .carBrand(car.getBrand())
                .carModel(car.getModel())
                .build();
    }
}