package com.example.project.repository;

import com.example.project.entity.Car;
import com.example.project.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CarRepository extends CrudRepository<Car, Long> {

    Optional<Car> findById(Integer id);


}
