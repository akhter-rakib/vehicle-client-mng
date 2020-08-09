package com.vhaibrother.vehicle_client_mng.service.impl;


import com.vhaibrother.vehicle_client_mng.dto.EmailDomainDto;
import com.vhaibrother.vehicle_client_mng.dto.Response;
import com.vhaibrother.vehicle_client_mng.entity.EmailDomain;
import com.vhaibrother.vehicle_client_mng.enums.ActiveStatus;
import com.vhaibrother.vehicle_client_mng.repository.EmailDomainRepository;
import com.vhaibrother.vehicle_client_mng.service.EmailDomainService;
import com.vhaibrother.vehicle_client_mng.util.ResponseBuilder;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailDomainServiceImpl implements EmailDomainService {

    private final EmailDomainRepository emailDomainRepository;
    private final ModelMapper modelMapper;
    private String root = "Email Domain";

    public EmailDomainServiceImpl(EmailDomainRepository emailDomainRepository, ModelMapper modelMapper) {
        this.emailDomainRepository = emailDomainRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Response save(EmailDomainDto emailDomainDto) {
        EmailDomain emailDomain;
        emailDomain = modelMapper.map(emailDomainDto, EmailDomain.class);
        emailDomain = emailDomainRepository.save(emailDomain);
        if (emailDomain != null){
            return ResponseBuilder.getSuccessResponse(HttpStatus.CREATED, root+" has been Created",null);
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR,"Internal Server Error");
    }

    @Override
    public Response update(Long id, EmailDomainDto emailDomainDto) {
        return null;
    }

    @Override
    public Response getById(Long id) {
        return null;
    }

    @Override
    public Response delete(Long id) {
        return null;
    }

    @Override
    public Response getAll() {
        List<EmailDomain> domainList = emailDomainRepository.list(ActiveStatus.ACTIVE.getValue());
        List<EmailDomainDto> domainDtoList = this.getDomainName(domainList);
        if (domainDtoList.isEmpty() || domainDtoList == null){
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK, "There is no domainName", null);
        }
        return ResponseBuilder.getSuccessResponse(HttpStatus.OK, root + "Data Retrieve Successfully", domainDtoList);
    }

    private List<EmailDomainDto> getDomainName(List<EmailDomain> domains){

        List<EmailDomainDto> emailDomainDtos = new ArrayList<>();
        domains.forEach(domain ->{
            modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
            EmailDomainDto emailDomainDto = modelMapper.map(domain,EmailDomainDto.class);
            emailDomainDtos.add(emailDomainDto);
        });
        return emailDomainDtos;
    }
}
