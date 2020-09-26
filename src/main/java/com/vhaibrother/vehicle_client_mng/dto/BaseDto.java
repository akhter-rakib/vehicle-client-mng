package com.vhaibrother.vehicle_client_mng.dto;

import lombok.Data;

import java.util.Date;
@Data
public class BaseDto {
    private Long id;
    private String createdBy;
    private Date createdAt;
    private String updatedBy;
    private Date updateAt;
    private Integer activeStatus;
}
