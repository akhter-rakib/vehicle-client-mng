package com.vhaibrother.vehicle_client_mng.entity;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class CarName extends BaseModel {
    private String carName;
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "carNames")
    private List<CarBrand> carBrands;

}
