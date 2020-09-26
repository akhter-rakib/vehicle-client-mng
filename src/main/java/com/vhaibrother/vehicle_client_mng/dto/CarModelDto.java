package com.vhaibrother.vehicle_client_mng.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class CarModelDto extends BaseDto {
    @NotEmpty(message = "Name is mandatory")
    private String carModelName;
    private List<CarGradeDto> carGradeList;
}
