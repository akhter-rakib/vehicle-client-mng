package com.vhaibrother.vehicle_client_mng.service;

import com.vhaibrother.vehicle_client_mng.dto.CarNameDto;
import com.vhaibrother.vehicle_client_mng.dto.Response;

public interface CarNameService {
    public Response save(CarNameDto carNameDto);

    public Response update(Long id, CarNameDto carNameDto);

    public Response getById(Long id);

    public Response del(Long id);

    public Response getAll();
}
