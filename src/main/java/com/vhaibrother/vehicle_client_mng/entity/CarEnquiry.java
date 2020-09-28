package com.vhaibrother.vehicle_client_mng.entity;

import com.vhaibrother.vehicle_client_mng.entity.BaseModel;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.Date;

@Data
@Entity
public class CarEnquiry extends BaseModel {
    @OneToOne
    private Client client;
    @OneToOne
    private CarCompany carCompany;
    @OneToOne
    private CarModel carModel;
    @OneToOne
    private CarGrade carGrade;
    private Date yearOfModel;
    private String color;
    private String chasisCode;
    private Double priceLimit;
}
