package com.vhaibrother.vehicle_client_mng.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Data
public class CarStockDto extends BaseDto {
    private long carCompanyId;
    private long carModelId;
    private long carGradeId;
    private int engineNo;
    private int chassisNo;
    private int yearOfModel;
    private long clientId;
    private String carType;
    private String color;
    private Double price;
    private String carAuction;
    private Boolean availableStatus;
    private List<String> images = new ArrayList<>();
}
