package com.vhaibrother.vehicle_client_mng.service;

import com.vhaibrother.vehicle_client_mng.dto.Response;
import com.vhaibrother.vehicle_client_mng.dto.RoleDto;

public interface RoleService {
    Response save(RoleDto roleDto);

    Response update(Long id, RoleDto roleDto);

    Response getById(Long id);

    Response del(Long id);

    Response getAll();
}
