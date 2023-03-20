package com.example.project.dto;

import com.example.project.entity.User;
import lombok.Builder;

import java.util.Date;

@Builder

public class ReservationResponse {

    private Long id;
    private User user;
    private String brand;
    private String model;
    private Date startDate;
    private Date endDate;
    private Double rentalPrice;

}
