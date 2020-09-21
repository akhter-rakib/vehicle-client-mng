package com.vhaibrother.vehicle_client_mng.service;

import com.vhaibrother.vehicle_client_mng.dto.CarGradeDto;
import com.vhaibrother.vehicle_client_mng.dto.Response;

public interface CarGradeService {
    public Response save(CarGradeDto carGradeDto);

    public Response update(Long id, CarGradeDto carGradeDto);

    public Response getById(Long id);

    public Response getAll();

    public Response del(Long id);
}
