package com.vhaibrother.vehicle_client_mng.dto;

import lombok.Data;

import javax.persistence.OneToOne;

@Data
public class CarStockDetailsDto extends BaseDto {
    private ClientDto client;
    private String carType;
    private String color;
    private Double price;
    private String carAuction;
    private Boolean availableStatus;
}
