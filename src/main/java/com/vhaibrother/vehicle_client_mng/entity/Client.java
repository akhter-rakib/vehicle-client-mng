package com.vhaibrother.vehicle_client_mng.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Data
public class Client extends BaseModel {
    private String customerName;
    private String companyName;
    @OneToOne
    private Profession profession;
    private String address;
    private String areaName;
    private String divisionName;
    private String contactNo;
    private String emailAddress;
}
