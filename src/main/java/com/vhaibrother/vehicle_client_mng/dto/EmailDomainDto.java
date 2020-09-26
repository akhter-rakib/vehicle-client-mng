package com.vhaibrother.vehicle_client_mng.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class EmailDomainDto extends BaseDto {
    @NotEmpty(message = "Domain Name is mandatory")
    private String domainName;
}
