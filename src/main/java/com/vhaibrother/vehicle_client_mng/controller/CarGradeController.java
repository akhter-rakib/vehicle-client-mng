package com.vhaibrother.vehicle_client_mng.controller;

import com.vhaibrother.vehicle_client_mng.annotations.ApiController;
import com.vhaibrother.vehicle_client_mng.dto.CarGradeDto;
import com.vhaibrother.vehicle_client_mng.dto.Response;
import com.vhaibrother.vehicle_client_mng.service.CarGradeService;
import com.vhaibrother.vehicle_client_mng.util.UrlConstraint;
import org.springframework.web.bind.annotation.*;

@ApiController
@RequestMapping(UrlConstraint.CarGradeManagement.ROOT)
public class CarGradeController {

    private final CarGradeService carGradeService;

    CarGradeController(CarGradeService carGradeService) {
        this.carGradeService = carGradeService;
    }

    @PostMapping
    public Response save(@RequestBody CarGradeDto carGradeDto) {
        return carGradeService.save(carGradeDto);
    }

    @GetMapping
    public Response getAll() {
        return carGradeService.getAll();
    }

    @GetMapping(value = UrlConstraint.CarGradeManagement.GET)
    public Response getById(@PathVariable("carGradeId") Long carGradeId) {
        return carGradeService.getById(carGradeId);
    }

    @DeleteMapping(value = UrlConstraint.CarGradeManagement.DELETE)
    public Response delColor(@PathVariable("carGradeId") Long carGradeId) {
        return carGradeService.del(carGradeId);
    }

    @PutMapping(value = UrlConstraint.CarGradeManagement.PUT)
    public Response updateColor(@RequestBody CarGradeDto carGradeDto, @PathVariable("carGradeId") Long carGradeId) {
        return carGradeService.update(carGradeId, carGradeDto);
    }
}
