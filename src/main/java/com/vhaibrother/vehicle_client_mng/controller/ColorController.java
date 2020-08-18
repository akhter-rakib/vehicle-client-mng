package com.vhaibrother.vehicle_client_mng.controller;

import com.vhaibrother.vehicle_client_mng.annotations.ApiController;
import com.vhaibrother.vehicle_client_mng.dto.ColorDto;
import com.vhaibrother.vehicle_client_mng.dto.Response;
import com.vhaibrother.vehicle_client_mng.service.ColorService;
import com.vhaibrother.vehicle_client_mng.util.UrlConstraint;
import org.springframework.web.bind.annotation.*;

@ApiController
@RequestMapping(UrlConstraint.ColorManagement.ROOT)
public class ColorController {
    private final ColorService colorService;

    public ColorController(ColorService colorService) {
        this.colorService = colorService;
    }

    @PostMapping
    public Response saveColor(@RequestBody ColorDto colorDto) {
        return colorService.save(colorDto);
    }

    @GetMapping
    public Response getAll() {
        return colorService.getAll();
    }

    @GetMapping(value = UrlConstraint.ColorManagement.GET)
    public Response getById(@PathVariable("colorId") Long colorId) {
        return colorService.getById(colorId);
    }

    @DeleteMapping(value = UrlConstraint.ColorManagement.DELETE)
    public Response delColor(@PathVariable("colorId") Long colorId) {
        return colorService.del(colorId);
    }

    @PutMapping(value = UrlConstraint.ColorManagement.PUT)
    public Response updateColor(@RequestBody ColorDto colorDto, @PathVariable("colorId") Long colorId) {
        return colorService.update(colorId, colorDto);
    }
}
