package com.vhaibrother.vehicle_client_mng.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class RoleDto {
    @NotEmpty(message = "Name is mandatory")
    private String name;
}
