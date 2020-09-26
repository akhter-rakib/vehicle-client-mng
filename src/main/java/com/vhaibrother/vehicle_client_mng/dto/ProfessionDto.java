package com.vhaibrother.vehicle_client_mng.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class ProfessionDto extends BaseDto {
    @NotEmpty(message = "Profession Name is mandatory")
    private String professionName;
}
