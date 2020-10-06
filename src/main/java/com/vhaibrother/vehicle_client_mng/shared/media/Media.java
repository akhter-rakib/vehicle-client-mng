package com.vhaibrother.vehicle_client_mng.shared.media;

import com.vhaibrother.vehicle_client_mng.entity.BaseModel;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Media extends BaseModel {
    private String path;
    private String name;
    private String type;
}
