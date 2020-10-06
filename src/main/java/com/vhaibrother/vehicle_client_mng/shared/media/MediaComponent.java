package com.vhaibrother.vehicle_client_mng.shared.media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class MediaComponent implements Serializable {
    private static final long serialVersionUID = -7845086454358671862L;

    @Value("${media.upload.dir}")
    private String uploadPath;

    @Autowired
    private MediaRepository mediaRepository;

    public void writeToDisk(MultipartFile file) throws IOException {
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdirs();
        String uploadFilePath = uploadPath + "/" + file.getOriginalFilename();
        if (!file.isEmpty()) {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(uploadFilePath);
            Files.write(path, bytes);
        }
    }

    public Media saveMedia(MultipartFile file) throws Exception {
        if (null != file) {
            this.writeToDisk(file);
            Media media = new Media();
            media.setPath(uploadPath);
            media.setType(file.getContentType());
            mediaRepository.save(media);
            media.setName(file.getOriginalFilename());
            mediaRepository.save(media);
            return media;
        }
        return null;
    }
}
