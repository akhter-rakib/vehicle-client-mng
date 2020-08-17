package com.vhaibrother.vehicle_client_mng.entity;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Profession extends BaseModel {
    private String professionName;
}
