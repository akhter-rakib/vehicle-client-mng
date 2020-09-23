package com.vhaibrother.vehicle_client_mng.service;

import com.vhaibrother.vehicle_client_mng.dto.CarModelDto;
import com.vhaibrother.vehicle_client_mng.dto.Response;

public interface CarModelService {
    public Response save(CarModelDto carModelDto);

    public Response update(Long id, CarModelDto carModelDto);

    public Response getById(Long id);

    public Response del(Long id);

    public Response getAll();
}
