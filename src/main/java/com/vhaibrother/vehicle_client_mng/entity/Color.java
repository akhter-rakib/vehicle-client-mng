package com.vhaibrother.vehicle_client_mng.entity;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Color extends BaseModel {
    private String colorName;
}
