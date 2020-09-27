package com.vhaibrother.vehicle_client_mng.entity;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
@Data
public class CarStock extends BaseModel {
    @OneToOne
    private CarCompany carCompany;
    @OneToOne
    private CarModel carModel;
    @OneToOne
    private CarGrade carGrade;
    private String engineNo;
    private String chassisNo;
    private Date yearOfModel;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private CarStockDetails carStockDetails;


}
