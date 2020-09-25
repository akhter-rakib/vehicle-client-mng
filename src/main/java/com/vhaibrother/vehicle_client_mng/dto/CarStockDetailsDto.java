package com.vhaibrother.vehicle_client_mng.dto;

import lombok.Data;

import javax.persistence.OneToOne;

@Data
public class CarStockDetailsDto {
    private Long id;
    private ClientDto client;
    private String carType;
    private String color;
    private Double price;
    private Boolean availableStatus;
    private CarStockDto carStock;
}
