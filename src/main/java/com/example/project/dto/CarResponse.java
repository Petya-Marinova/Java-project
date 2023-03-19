package com.example.project.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarResponse {

    String id;
    String carBrand;
    String carModel;
}
