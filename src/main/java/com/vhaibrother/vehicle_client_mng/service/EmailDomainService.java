package com.vhaibrother.vehicle_client_mng.service;

import com.vhaibrother.vehicle_client_mng.dto.EmailDomainDto;
import com.vhaibrother.vehicle_client_mng.dto.Response;

public interface EmailDomainService {

    Response save(EmailDomainDto emailDomainDto);

    Response update(Long id, EmailDomainDto emailDomainDto);

    Response getById(Long id);

    Response delete(Long id);

    Response getAll();
}
