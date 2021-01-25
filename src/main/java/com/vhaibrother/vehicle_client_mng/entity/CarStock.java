package com.vhaibrother.vehicle_client_mng.entity;

import com.vhaibrother.vehicle_client_mng.shared.media.Media;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
public class CarStock extends BaseModel {
    @OneToOne
    private CarCompany carCompany;
    @OneToOne
    private CarModel carModel;
    @OneToOne
    private CarGrade carGrade;
    private int engineNo;
    private int chassisNo;
    private int yearOfModel;
    @OneToOne
    private Client client;
    private String carType;
    private String color;
    private Double price;
    private String carAuction;
    private Boolean availableStatus;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<Media> images;
}
