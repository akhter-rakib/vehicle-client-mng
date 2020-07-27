package com.vhaibrother.vehicle_client_mng.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Car extends BaseModel{
    private String companyName;
    private String brandName;
    private Date yearOfModel;
    private String model;
    private String color;
    @Column(unique = true)
    private String registrationNo;
}
