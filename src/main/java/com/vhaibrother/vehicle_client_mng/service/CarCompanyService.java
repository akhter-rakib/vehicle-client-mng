package com.vhaibrother.vehicle_client_mng.service;

import com.vhaibrother.vehicle_client_mng.dto.CarCompanyDto;
import com.vhaibrother.vehicle_client_mng.dto.Response;

public interface CarCompanyService {
    public Response save(CarCompanyDto carCompanyDto);

    public Response update(Long id, CarCompanyDto carCompanyDto);

    public Response getById(Long id);

    public Response del(Long id);

    public Response getAll();
}
