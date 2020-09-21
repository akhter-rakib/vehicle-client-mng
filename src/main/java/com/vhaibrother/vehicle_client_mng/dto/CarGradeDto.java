package com.vhaibrother.vehicle_client_mng.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CarGradeDto {
    private Long id;
    @NotEmpty(message = "Name is mandetory")
    private String gradeName;

}
