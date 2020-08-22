package com.vhaibrother.vehicle_client_mng.entity;

import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Car extends BaseModel {
    private String companyName;
    private String brandName;
    private Date yearOfModel;
    private String model;
    @OneToOne
    private Color color;
    @NaturalId
    private String registrationNo;
    @OneToOne
    private CarDetails carDetails;
    @OneToMany
    private List<CarImage> carImageList;
}
