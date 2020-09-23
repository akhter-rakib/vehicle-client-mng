package com.vhaibrother.vehicle_client_mng.controller;

import com.vhaibrother.vehicle_client_mng.annotations.ApiController;
import com.vhaibrother.vehicle_client_mng.dto.ClientDto;
import com.vhaibrother.vehicle_client_mng.dto.ProfessionDto;
import com.vhaibrother.vehicle_client_mng.dto.Response;
import com.vhaibrother.vehicle_client_mng.service.ClientService;
import com.vhaibrother.vehicle_client_mng.util.ResponseBuilder;
import com.vhaibrother.vehicle_client_mng.util.UrlConstraint;
import org.springframework.data.repository.query.Param;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@ApiController
@RequestMapping(UrlConstraint.ClientManagement.ROOT)
public class ClientController {
    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public Response saveClient(@RequestBody @Valid ClientDto clientDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResponseBuilder.getFailureResponse(bindingResult, "Give valid data");
        }
        return clientService.save(clientDto);
    }

    @GetMapping
    public Response getAll(){
        return clientService.getAll();
    }
    @GetMapping(value = UrlConstraint.ClientManagement.GET)
    public Response getById(@PathVariable("clientId") Long clientId){
        return clientService.getById(clientId);
    }

    @DeleteMapping(value = UrlConstraint.ClientManagement.DELETE)
    public Response delClient(@PathVariable("clientId") Long clientId){
        return clientService.del(clientId);
    }

    @PutMapping(value = UrlConstraint.ClientManagement.PUT)
    public Response updateClient(@RequestBody ClientDto clientDto, @PathVariable("clientId") Long clientId) {
        return clientService.update(clientId, clientDto);
    }

}
