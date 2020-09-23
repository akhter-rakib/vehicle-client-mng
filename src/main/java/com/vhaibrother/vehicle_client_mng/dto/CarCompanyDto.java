package com.vhaibrother.vehicle_client_mng.dto;

import lombok.Data;

import java.util.List;

@Data
public class CarCompanyDto {
    private Long id;
    private String carCompanyName;
    private List<CarModelDto> carModelList;
}
