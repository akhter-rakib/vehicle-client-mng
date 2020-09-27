package com.vhaibrother.vehicle_client_mng.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class CarStockDetails extends BaseModel {
    @OneToOne
    private Client client;
    private String carType;
    private String color;
    private Double price;
    private Boolean availableStatus;
}
