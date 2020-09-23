package com.vhaibrother.vehicle_client_mng.entity;

import lombok.Data;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class CarModel extends BaseModel {
    private String carModelName;
    @ManyToMany
    private List<CarGrade> carGradeList;
}
