package com.vhaibrother.vehicle_client_mng.service;

import com.vhaibrother.vehicle_client_mng.dto.ProfessionDto;
import com.vhaibrother.vehicle_client_mng.dto.Response;

public interface ProfessionService {

    public Response save(ProfessionDto professionDto);

    public Response update(Long id, ProfessionDto professionDto);

    public Response getById(Long id);

    public Response del(Long id);

    public Response getAll();
}
