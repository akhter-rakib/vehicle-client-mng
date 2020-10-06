package com.vhaibrother.vehicle_client_mng.service;

import com.vhaibrother.vehicle_client_mng.dto.CarStockDto;
import com.vhaibrother.vehicle_client_mng.dto.Response;

public interface CarStockService {
    public Response save(CarStockDto carStockDto);

    public Response update(Long id, CarStockDto carStockDto);

    public Response getById(Long id);

    public Response del(Long id);

    public Response getAll();

    public Response getByCarType(String carType);
}
