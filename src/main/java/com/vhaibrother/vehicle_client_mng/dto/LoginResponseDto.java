package com.vhaibrother.vehicle_client_mng.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class LoginResponseDto {
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private String token;
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private String userName;
}
