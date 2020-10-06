package com.vhaibrother.vehicle_client_mng.dto;

import lombok.Data;
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
