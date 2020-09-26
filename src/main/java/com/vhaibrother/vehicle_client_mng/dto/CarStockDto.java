package com.vhaibrother.vehicle_client_mng.dto;

import com.vhaibrother.vehicle_client_mng.entity.*;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import java.util.Date;

@Data
public class CarStockDto extends BaseDto {
    private CarCompanyDto carCompany;
    private CarModelDto carModel;
    private CarGradeDto carGrade;
    private int engineNo;
    private int chassisNo;
    private Date yearOfModel;
    private CarStockDetailsDto carStockDetails;
}
