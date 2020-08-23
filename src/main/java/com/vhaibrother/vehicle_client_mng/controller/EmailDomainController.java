package com.vhaibrother.vehicle_client_mng.controller;


import com.vhaibrother.vehicle_client_mng.annotations.ApiController;
import com.vhaibrother.vehicle_client_mng.dto.EmailDomainDto;
import com.vhaibrother.vehicle_client_mng.dto.Response;
import com.vhaibrother.vehicle_client_mng.service.EmailDomainService;
import com.vhaibrother.vehicle_client_mng.util.UrlConstraint;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@ApiController
@RequestMapping(UrlConstraint.DomainManagement.ROOT)
public class EmailDomainController {

    private final EmailDomainService emailDomainService;

    public EmailDomainController(EmailDomainService emailDomainService) {
        this.emailDomainService = emailDomainService;
    }

    @PostMapping
    public Response saveDomain(@RequestBody EmailDomainDto emailDomainDto) {
        return emailDomainService.save(emailDomainDto);
    }

    @GetMapping
    public Response getAll() {
        return emailDomainService.getAll();
    }

    @GetMapping(value = UrlConstraint.DomainManagement.GET)
    public Response getById(@PathVariable("domainId") Long domainId) {
        return emailDomainService.getById(domainId);
    }

    @DeleteMapping(value = UrlConstraint.DomainManagement.DELETE)
    public Response deleteEmailDomain(@PathVariable("domainId") Long domainId) {
        return emailDomainService.delete(domainId);
    }
    @PutMapping(value = UrlConstraint.DomainManagement.PUT)
    public Response updateEmailDomain(@RequestBody EmailDomainDto emailDomainDto, @PathVariable("domainId") Long domainId){
        return emailDomainService.update(domainId,emailDomainDto);
    }
}
