package com.vhaibrother.vehicle_client_mng.entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class CarImage extends BaseModel {
    private String imageLocation;
}
