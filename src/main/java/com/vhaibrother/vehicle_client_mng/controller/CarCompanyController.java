package com.vhaibrother.vehicle_client_mng.controller;

import com.vhaibrother.vehicle_client_mng.annotations.ApiController;
import com.vhaibrother.vehicle_client_mng.dto.CarCompanyDto;
import com.vhaibrother.vehicle_client_mng.dto.Response;
import com.vhaibrother.vehicle_client_mng.service.CarCompanyService;
import com.vhaibrother.vehicle_client_mng.util.UrlConstraint;
import org.springframework.web.bind.annotation.*;

@ApiController
@RequestMapping(UrlConstraint.CarCompanyManagement.ROOT)
public class CarCompanyController {
    private final CarCompanyService carCompanyService;

    public CarCompanyController(CarCompanyService carCompanyService) {
        this.carCompanyService = carCompanyService;
    }

    @PostMapping
    public Response saveColor(@RequestBody CarCompanyDto carCompanyDto) {
        return carCompanyService.save(carCompanyDto);
    }

    @GetMapping
    public Response getAll() {
        return carCompanyService.getAll();
    }

    @GetMapping(value = UrlConstraint.CarCompanyManagement.GET)
    public Response getById(@PathVariable("carCompanyId") Long carCompanyId) {
        return carCompanyService.getById(carCompanyId);
    }

    @DeleteMapping(value = UrlConstraint.CarCompanyManagement.DELETE)
    public Response del(@PathVariable("carCompanyId") Long carCompanyId) {
        return carCompanyService.del(carCompanyId);
    }

    @PutMapping(value = UrlConstraint.CarCompanyManagement.PUT)
    public Response update(@RequestBody CarCompanyDto carCompanyDto, @PathVariable("carCompanyId") Long carCompanyId) {
        return carCompanyService.update(carCompanyId, carCompanyDto);
    }
}
