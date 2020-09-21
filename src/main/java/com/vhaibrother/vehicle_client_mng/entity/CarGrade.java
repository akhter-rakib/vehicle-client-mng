package com.vhaibrother.vehicle_client_mng.entity;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class CarGrade extends BaseModel {
    private String gradeName;
}
