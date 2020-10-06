package com.vhaibrother.vehicle_client_mng.shared.media;

import com.vhaibrother.vehicle_client_mng.dto.BaseDto;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class MediaDto extends BaseDto {
    private String path;
    private String name;
    private String type;
    private MultipartFile files;

    public MultipartFile getFiles() {
        return files;
    }
    public void setFiles(MultipartFile files) {
        this.files = files;
    }
}
