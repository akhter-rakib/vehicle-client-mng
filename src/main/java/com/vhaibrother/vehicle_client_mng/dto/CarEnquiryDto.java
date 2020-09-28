package com.vhaibrother.vehicle_client_mng.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CarEnquiryDto extends BaseDto {
    private ClientDto client;
    private CarCompanyDto carCompany;
    private CarModelDto carModel;
    private CarGradeDto carGrade;
    private Date yearOfModel;
    private String color;
    private String chasisCode;
    private Double priceLimit;
}
