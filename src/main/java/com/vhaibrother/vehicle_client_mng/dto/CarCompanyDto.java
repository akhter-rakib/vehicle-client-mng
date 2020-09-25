package com.vhaibrother.vehicle_client_mng.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class CarCompanyDto {
    private Long id;
    @NotEmpty(message = "Name is mandatory")
    private String carCompanyName;
    private List<CarModelDto> carModelList;
}
