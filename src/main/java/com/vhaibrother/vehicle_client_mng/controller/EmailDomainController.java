package com.vhaibrother.vehicle_client_mng.controller;


import com.vhaibrother.vehicle_client_mng.annotations.ApiController;
import com.vhaibrother.vehicle_client_mng.dto.EmailDomainDto;
import com.vhaibrother.vehicle_client_mng.dto.Response;
import com.vhaibrother.vehicle_client_mng.service.EmailDomainService;
import com.vhaibrother.vehicle_client_mng.util.UrlConstraint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@ApiController
@RequestMapping(UrlConstraint.DomainManagement.ROOT)
public class EmailDomainController {

    private final EmailDomainService emailDomainService;

    public EmailDomainController(EmailDomainService emailDomainService) {
        this.emailDomainService = emailDomainService;
    }

    @PostMapping
    public Response saveDomain(@RequestBody EmailDomainDto emailDomainDto){
        return emailDomainService.save(emailDomainDto);
    }
     @GetMapping
    public Response getAll(){
        return emailDomainService.getAll();
     }
}
