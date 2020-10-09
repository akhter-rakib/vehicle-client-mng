package com.vhaibrother.vehicle_client_mng.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
@Data
public class CarRegistrationAndFitness extends BaseModel {
    @OneToOne
    private Client client;
    @OneToOne
    private CarCompany carCompany;
    @OneToOne
    private CarModel carModel;
    @OneToOne
    private CarGrade carGrade;
    private Date yearOfModel;
    private Date carRegistrationDate;
    private Date carFitnessExpiredDate;

}
