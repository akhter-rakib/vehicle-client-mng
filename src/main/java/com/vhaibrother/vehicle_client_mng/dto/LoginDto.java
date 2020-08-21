package com.vhaibrother.vehicle_client_mng.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginDto {
    @NotBlank(message = "Username mandatory")
    private String userName;
    @NotBlank(message = "Password mandatory")
    private String password;
}
