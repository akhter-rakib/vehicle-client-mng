package com.vhaibrother.vehicle_client_mng.controller;

import com.vhaibrother.vehicle_client_mng.annotations.ApiController;
import com.vhaibrother.vehicle_client_mng.dto.CarNameDto;
import com.vhaibrother.vehicle_client_mng.dto.Response;
import com.vhaibrother.vehicle_client_mng.service.CarNameService;
import com.vhaibrother.vehicle_client_mng.util.UrlConstraint;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@ApiController
@RequestMapping(UrlConstraint.CarNameManagement.ROOT)
public class CarNameController {

    private final CarNameService carNameService;

    public CarNameController(CarNameService carNameService) {
        this.carNameService = carNameService;
    }

    @PostMapping
    public Response saveCarName(@RequestBody CarNameDto carNameDto) {
        return carNameService.save(carNameDto);
    }
}
