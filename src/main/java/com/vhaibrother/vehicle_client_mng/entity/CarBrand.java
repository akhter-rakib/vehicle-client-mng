package com.vhaibrother.vehicle_client_mng.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
public class CarBrand extends BaseModel {
    private String brandName;
    @ManyToOne
    @JoinColumn(name = "car_names_id")
    private CarName carNames;
}
