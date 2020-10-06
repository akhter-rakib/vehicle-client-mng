package com.vhaibrother.vehicle_client_mng.dto;

import com.vhaibrother.vehicle_client_mng.entity.*;
import com.vhaibrother.vehicle_client_mng.shared.media.Media;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import java.util.Date;
import java.util.List;

@Data
public class CarStockDto extends BaseDto {
    private CarCompanyDto carCompany;
    private CarModelDto carModel;
    private CarGradeDto carGrade;
    private int engineNo;
    private int chassisNo;
    private Date yearOfModel;
    private CarStockDetailsDto carStockDetails;
    private MultipartFile imagePath;
    private long mediaId;
}
