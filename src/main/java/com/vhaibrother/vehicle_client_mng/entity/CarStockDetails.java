package com.vhaibrother.vehicle_client_mng.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Data
public class CarStockDetails extends BaseModel {
    @OneToOne
    private Client client;
    private String carType;
    private String color;
    private Double price;
    private Boolean availableStatus;
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "car_stock_id", nullable = false)
    private CarStock carStock;
}
