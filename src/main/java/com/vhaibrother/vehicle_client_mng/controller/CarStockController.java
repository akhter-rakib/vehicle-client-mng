package com.vhaibrother.vehicle_client_mng.controller;

import com.vhaibrother.vehicle_client_mng.annotations.ApiController;
import com.vhaibrother.vehicle_client_mng.dto.CarStockDto;
import com.vhaibrother.vehicle_client_mng.dto.Response;
import com.vhaibrother.vehicle_client_mng.service.CarStockService;
import com.vhaibrother.vehicle_client_mng.util.UrlConstraint;
import org.springframework.web.bind.annotation.*;

@ApiController
@RequestMapping(UrlConstraint.CarStockManagement.ROOT)
public class CarStockController {
    private final CarStockService carStockService;

    public CarStockController(CarStockService carStockService) {
        this.carStockService = carStockService;
    }

    @PostMapping
    public Response save(@ModelAttribute CarStockDto carStockDto) throws Exception {
        return carStockService.save(carStockDto);
    }

    @GetMapping
    public Response getAll() {
        return carStockService.getAll();
    }

    @GetMapping(value = UrlConstraint.CarStockManagement.GET)
    public Response getById(@PathVariable("carStockId") Long carStockId) {
        return carStockService.getById(carStockId);
    }

    @DeleteMapping(value = UrlConstraint.CarStockManagement.DELETE)
    public Response del(@PathVariable("carStockId") Long carStockId) {
        return carStockService.del(carStockId);
    }

    @PutMapping(value = UrlConstraint.CarStockManagement.PUT)
    public Response update(@RequestBody CarStockDto carStockDto, @PathVariable("carStockId") Long carStockId) {
        return carStockService.update(carStockId, carStockDto);
    }

    @GetMapping(value = UrlConstraint.CarStockManagement.GETBYCARETYPE)
    public Response getAllByCarType(@PathVariable("carType") String carType) {
        return carStockService.getByCarType(carType);
    }
}
