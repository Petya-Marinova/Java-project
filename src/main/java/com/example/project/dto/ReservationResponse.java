package com.example.project.dto;

import lombok.Builder;

import java.util.Date;

@Builder

public class ReservationResponse {

    private Long id;
    private String user;
    private String brand;
    private String model;
    private Date startDate;
    private Date endDate;
    private Double rentalPrice;

}
