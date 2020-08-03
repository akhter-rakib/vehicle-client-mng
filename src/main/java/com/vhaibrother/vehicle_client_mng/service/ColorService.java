package com.vhaibrother.vehicle_client_mng.service;

import com.vhaibrother.vehicle_client_mng.dto.ColorDto;
import com.vhaibrother.vehicle_client_mng.dto.Response;
import com.vhaibrother.vehicle_client_mng.entity.Color;

public interface ColorService {
    public Response save(ColorDto colorDto);

    public Response update(Long id, ColorDto colorDto);

    public Response getById(Long id);

    public Response del(Long id);

    public Response getAll();
}
