package com.vhaibrother.vehicle_client_mng.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class CarCompany extends BaseModel {
    private String carCompanyName;
    @OneToMany
    private List<CarModel> carModelList;
}
