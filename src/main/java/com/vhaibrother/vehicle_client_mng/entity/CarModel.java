package com.vhaibrother.vehicle_client_mng.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class CarModel extends BaseModel {
    private String carModelName;
    @OneToMany
    private List<CarGrade> carGradeList;
}
