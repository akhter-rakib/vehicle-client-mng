package com.vhaibrother.vehicle_client_mng.shared.media;

import com.vhaibrother.vehicle_client_mng.annotations.ApiController;
import com.vhaibrother.vehicle_client_mng.dto.Response;
import com.vhaibrother.vehicle_client_mng.util.UrlConstraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;

@ApiController
@RequestMapping(UrlConstraint.MediaManagement.ROOT)
public class MediaController {

    @Autowired
    private MediaRepository mediaRepository;
    @Autowired
    private MediaComponent mediaComponent;

    @GetMapping(value = UrlConstraint.MediaManagement.GET)
    public void getMedia(@PathVariable("id") Long id, HttpServletResponse response) {
        response.setContentType("image/*");
        try {
            Optional<Media> media = mediaRepository.findById(id);
            if(media !=null) {
                File file = new File(media.get().getPath() + media.get().getName());
                byte[] fileContent = Files.readAllBytes(file.toPath());
                if (fileContent != null) {
                    response.getOutputStream().write(fileContent, 0, fileContent.length);
                    response.flushBuffer();
                    response.setStatus(HttpStatus.OK.value());
                }
            }

        } catch (IOException e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }

    @GetMapping
    public List<Media> getAll() {
        return mediaRepository.findAll();
    }

    @PostMapping(value = UrlConstraint.MediaManagement.ROOT)
    public ResponseEntity<?> saveContent(@ModelAttribute MediaDto mediaDto) {

        try {
            Media media = mediaComponent.saveMedia(mediaDto.getFiles());
            return ResponseEntity.ok(media);
        } catch (IOException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }
}
