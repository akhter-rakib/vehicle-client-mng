package com.vhaibrother.vehicle_client_mng.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CarDto {
    private Long id;
    private String companyName;
    private String brandName;
    private Date yearOfModel;
    private String model;
    private String color;
    private String registrationNo;
    private CarDetailsDto carDetails;
}
