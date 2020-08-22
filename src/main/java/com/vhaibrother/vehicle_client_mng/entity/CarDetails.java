package com.vhaibrother.vehicle_client_mng.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;
@Data
@Entity
public class CarDetails extends BaseModel{
    private Date registryDate;
    private double mileage;
    private String grade;
    private Date fitnessDate;
    private int chassisNo;
    private String transmission;
    @Column(unique = true)
    private int engineNo;
    private int engineCapacity;
    private String fuelSystem;
    private String place;

}
