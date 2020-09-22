package com.vhaibrother.vehicle_client_mng.controller;

import com.vhaibrother.vehicle_client_mng.annotations.ApiController;
import com.vhaibrother.vehicle_client_mng.dto.ColorDto;
import com.vhaibrother.vehicle_client_mng.dto.ProfessionDto;
import com.vhaibrother.vehicle_client_mng.dto.Response;
import com.vhaibrother.vehicle_client_mng.service.ProfessionService;
import com.vhaibrother.vehicle_client_mng.util.ResponseBuilder;
import com.vhaibrother.vehicle_client_mng.util.UrlConstraint;
import org.springframework.http.HttpRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@ApiController
@RequestMapping(UrlConstraint.ProfessionManagement.ROOT)
public class ProfessionController {
    private final ProfessionService professionService;

    public ProfessionController(ProfessionService professionService) {
        this.professionService = professionService;
    }

    @PostMapping
    public Response saveProfession(@Valid ProfessionDto professionDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseBuilder.getFailureResponse(bindingResult, "Plz give valid Data");
        }
        return professionService.save(professionDto);
    }

    @GetMapping
    public Response getAll() {
        return professionService.getAll();
    }

    @GetMapping(value = UrlConstraint.ProfessionManagement.GET)
    public Response getById(@PathVariable("professionId") Long professionId) {
        return professionService.getById(professionId);
    }

    @DeleteMapping(value = UrlConstraint.ProfessionManagement.DELETE)
    public Response delProfession(@PathVariable("professionId") Long professionId) {
        return professionService.del(professionId);
    }

    @PutMapping(value = UrlConstraint.ProfessionManagement.PUT)
    public Response updateProfession(ProfessionDto professionDto, @PathVariable("professionId") Long professionId) {
        return professionService.update(professionId, professionDto);
    }
}
