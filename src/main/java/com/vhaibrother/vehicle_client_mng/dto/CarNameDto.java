package com.vhaibrother.vehicle_client_mng.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Data
public class CarNameDto {
    private Long id;
    @NotEmpty(message = "Name is mandatory")
    private String carName;
    private List<CarBrandDto> carBrands;

}
