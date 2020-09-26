package com.vhaibrother.vehicle_client_mng.dto;

import com.vhaibrother.vehicle_client_mng.entity.Profession;
import lombok.Data;

import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

@Data
public class ClientDto extends BaseDto {
    @NotEmpty(message = "Customer name is mandatory")
    private String customerName;
    @NotEmpty(message = "Company name is mandatory")
    private String companyName;
    private ProfessionDto profession;
    @NotEmpty(message = "Address is mandatory")
    private String address;
    @NotEmpty(message = "Area name is mandatory")
    private String areaName;
    @NotEmpty(message = "Division is mandatory")
    private String divisionName;
    @NotEmpty(message = "Contact no is mandatory")
    private String contactNo;
    @NotEmpty(message = "Email address is mandatory")
    private String emailAddress;
}
