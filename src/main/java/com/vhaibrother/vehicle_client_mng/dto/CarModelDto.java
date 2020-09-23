package com.vhaibrother.vehicle_client_mng.dto;

import lombok.Data;

import java.util.List;

@Data
public class CarModelDto {
    private String carModelName;
    private List<CarGradeDto> carGradeList;
}
