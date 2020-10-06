package com.vhaibrother.vehicle_client_mng.entity;

import com.vhaibrother.vehicle_client_mng.shared.media.Media;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class CarStock extends BaseModel {
    @OneToOne
    private CarCompany carCompany;
    @OneToOne
    private CarModel carModel;
    @OneToOne
    private CarGrade carGrade;
    private String engineNo;
    private String chassisNo;
    private Date yearOfModel;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private CarStockDetails carStockDetails;
    private String imagePath;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Media media;
}
