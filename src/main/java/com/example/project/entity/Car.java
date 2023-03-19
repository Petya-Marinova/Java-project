package com.example.project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "car_brand")
    private String brand;

    @Column(name="car_model")
    private String model;

    @Column(name="number_of_seats")
    private int seats;

    @Column(name="rental_price")
    private Double rentalPrice;

    @ManyToMany(mappedBy = "car")
    private Set<Reservation> reservation;


}
