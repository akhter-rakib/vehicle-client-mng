package com.vhaibrother.vehicle_client_mng.entity;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class ImageType extends BaseModel {

    private String imageType;
}
